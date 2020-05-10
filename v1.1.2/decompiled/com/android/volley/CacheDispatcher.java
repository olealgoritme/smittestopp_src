package com.android.volley;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher
  extends Thread
{
  public static final boolean DEBUG = VolleyLog.DEBUG;
  public final Cache mCache;
  public final BlockingQueue<Request<?>> mCacheQueue;
  public final ResponseDelivery mDelivery;
  public final BlockingQueue<Request<?>> mNetworkQueue;
  public volatile boolean mQuit = false;
  public final WaitingRequestManager mWaitingRequestManager;
  
  public CacheDispatcher(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mCacheQueue = paramBlockingQueue1;
    mNetworkQueue = paramBlockingQueue2;
    mCache = paramCache;
    mDelivery = paramResponseDelivery;
    mWaitingRequestManager = new WaitingRequestManager(this);
  }
  
  private void processRequest()
  {
    processRequest((Request)mCacheQueue.take());
  }
  
  public void processRequest(final Request<?> paramRequest)
  {
    paramRequest.addMarker("cache-queue-take");
    if (paramRequest.isCanceled())
    {
      paramRequest.finish("cache-discard-canceled");
      return;
    }
    Cache.Entry localEntry = mCache.get(paramRequest.getCacheKey());
    if (localEntry == null)
    {
      paramRequest.addMarker("cache-miss");
      if (!WaitingRequestManager.access$000(mWaitingRequestManager, paramRequest)) {
        mNetworkQueue.put(paramRequest);
      }
      return;
    }
    if (localEntry.isExpired())
    {
      paramRequest.addMarker("cache-hit-expired");
      paramRequest.setCacheEntry(localEntry);
      if (!WaitingRequestManager.access$000(mWaitingRequestManager, paramRequest)) {
        mNetworkQueue.put(paramRequest);
      }
      return;
    }
    paramRequest.addMarker("cache-hit");
    Response localResponse = paramRequest.parseNetworkResponse(new NetworkResponse(data, responseHeaders));
    paramRequest.addMarker("cache-hit-parsed");
    if (!localEntry.refreshNeeded())
    {
      mDelivery.postResponse(paramRequest, localResponse);
    }
    else
    {
      paramRequest.addMarker("cache-hit-refresh-needed");
      paramRequest.setCacheEntry(localEntry);
      intermediate = true;
      if (!WaitingRequestManager.access$000(mWaitingRequestManager, paramRequest)) {
        mDelivery.postResponse(paramRequest, localResponse, new Runnable()
        {
          public void run()
          {
            try
            {
              CacheDispatcher.access$100(CacheDispatcher.this).put(paramRequest);
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        });
      } else {
        mDelivery.postResponse(paramRequest, localResponse);
      }
    }
  }
  
  public void quit()
  {
    mQuit = true;
    interrupt();
  }
  
  public void run()
  {
    if (DEBUG) {
      VolleyLog.v("start new dispatcher", new Object[0]);
    }
    Process.setThreadPriority(10);
    mCache.initialize();
    try
    {
      for (;;)
      {
        processRequest();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      if (mQuit)
      {
        Thread.currentThread().interrupt();
        return;
      }
      VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
    }
  }
  
  public static class WaitingRequestManager
    implements Request.NetworkRequestCompleteListener
  {
    public final CacheDispatcher mCacheDispatcher;
    public final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();
    
    public WaitingRequestManager(CacheDispatcher paramCacheDispatcher)
    {
      mCacheDispatcher = paramCacheDispatcher;
    }
    
    private boolean maybeAddToWaitingRequests(Request<?> paramRequest)
    {
      try
      {
        String str = paramRequest.getCacheKey();
        if (mWaitingRequests.containsKey(str))
        {
          List localList = (List)mWaitingRequests.get(str);
          Object localObject = localList;
          if (localList == null)
          {
            localObject = new java/util/ArrayList;
            ((ArrayList)localObject).<init>();
          }
          paramRequest.addMarker("waiting-for-response");
          ((List)localObject).add(paramRequest);
          mWaitingRequests.put(str, localObject);
          if (VolleyLog.DEBUG) {
            VolleyLog.d("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return true;
        }
        mWaitingRequests.put(str, null);
        paramRequest.setNetworkRequestCompleteListener(this);
        if (VolleyLog.DEBUG) {
          VolleyLog.d("new request, sending to network %s", new Object[] { str });
        }
        return false;
      }
      finally {}
    }
    
    public void onNoUsableResponseReceived(Request<?> paramRequest)
    {
      try
      {
        String str = paramRequest.getCacheKey();
        List localList = (List)mWaitingRequests.remove(str);
        if ((localList != null) && (!localList.isEmpty()))
        {
          if (VolleyLog.DEBUG) {
            VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", new Object[] { Integer.valueOf(localList.size()), str });
          }
          paramRequest = (Request)localList.remove(0);
          mWaitingRequests.put(str, localList);
          paramRequest.setNetworkRequestCompleteListener(this);
          try
          {
            CacheDispatcher.access$100(mCacheDispatcher).put(paramRequest);
          }
          catch (InterruptedException paramRequest)
          {
            VolleyLog.e("Couldn't add request to queue. %s", new Object[] { paramRequest.toString() });
            Thread.currentThread().interrupt();
            mCacheDispatcher.quit();
          }
        }
        return;
      }
      finally {}
    }
    
    public void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse)
    {
      Object localObject = cacheEntry;
      if ((localObject != null) && (!((Cache.Entry)localObject).isExpired()))
      {
        paramRequest = paramRequest.getCacheKey();
        try
        {
          localObject = (List)mWaitingRequests.remove(paramRequest);
          if (localObject != null)
          {
            if (VolleyLog.DEBUG) {
              VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((List)localObject).size()), paramRequest });
            }
            paramRequest = ((List)localObject).iterator();
            while (paramRequest.hasNext())
            {
              localObject = (Request)paramRequest.next();
              CacheDispatcher.access$200(mCacheDispatcher).postResponse((Request)localObject, paramResponse);
            }
          }
          return;
        }
        finally {}
      }
      onNoUsableResponseReceived(paramRequest);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.CacheDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */