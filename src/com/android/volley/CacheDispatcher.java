package com.android.volley;

import android.os.Process;
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
  public final CacheDispatcher.WaitingRequestManager mWaitingRequestManager;
  
  public CacheDispatcher(BlockingQueue<Request<?>> paramBlockingQueue1, BlockingQueue<Request<?>> paramBlockingQueue2, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    mCacheQueue = paramBlockingQueue1;
    mNetworkQueue = paramBlockingQueue2;
    mCache = paramCache;
    mDelivery = paramResponseDelivery;
    mWaitingRequestManager = new CacheDispatcher.WaitingRequestManager(this);
  }
  
  private void processRequest()
  {
    processRequest((Request)mCacheQueue.take());
  }
  
  public void processRequest(Request<?> paramRequest)
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
      if (!CacheDispatcher.WaitingRequestManager.access$000(mWaitingRequestManager, paramRequest)) {
        mNetworkQueue.put(paramRequest);
      }
      return;
    }
    if (localEntry.isExpired())
    {
      paramRequest.addMarker("cache-hit-expired");
      paramRequest.setCacheEntry(localEntry);
      if (!CacheDispatcher.WaitingRequestManager.access$000(mWaitingRequestManager, paramRequest)) {
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
      if (!CacheDispatcher.WaitingRequestManager.access$000(mWaitingRequestManager, paramRequest)) {
        mDelivery.postResponse(paramRequest, localResponse, new CacheDispatcher.1(this, paramRequest));
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
}

/* Location:
 * Qualified Name:     base.com.android.volley.CacheDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */