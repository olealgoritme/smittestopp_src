package com.android.volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher$WaitingRequestManager
  implements Request.NetworkRequestCompleteListener
{
  public final CacheDispatcher mCacheDispatcher;
  public final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();
  
  public CacheDispatcher$WaitingRequestManager(CacheDispatcher paramCacheDispatcher)
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
      paramRequest = (List)mWaitingRequests.remove(str);
      if ((paramRequest != null) && (!paramRequest.isEmpty()))
      {
        if (VolleyLog.DEBUG) {
          VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", new Object[] { Integer.valueOf(paramRequest.size()), str });
        }
        Request localRequest = (Request)paramRequest.remove(0);
        mWaitingRequests.put(str, paramRequest);
        localRequest.setNetworkRequestCompleteListener(this);
        try
        {
          CacheDispatcher.access$100(mCacheDispatcher).put(localRequest);
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
      localObject = paramRequest.getCacheKey();
      try
      {
        paramRequest = (List)mWaitingRequests.remove(localObject);
        if (paramRequest != null)
        {
          if (VolleyLog.DEBUG) {
            VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(paramRequest.size()), localObject });
          }
          paramRequest = paramRequest.iterator();
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

/* Location:
 * Qualified Name:     base.com.android.volley.CacheDispatcher.WaitingRequestManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */