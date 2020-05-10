package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.Response;

public class ClearCacheRequest
  extends Request<Object>
{
  public final Cache mCache;
  public final Runnable mCallback;
  
  public ClearCacheRequest(Cache paramCache, Runnable paramRunnable)
  {
    super(0, null, null);
    mCache = paramCache;
    mCallback = paramRunnable;
  }
  
  public void deliverResponse(Object paramObject) {}
  
  public Request.Priority getPriority()
  {
    return Request.Priority.IMMEDIATE;
  }
  
  public boolean isCanceled()
  {
    mCache.clear();
    if (mCallback != null) {
      new Handler(Looper.getMainLooper()).postAtFrontOfQueue(mCallback);
    }
    return true;
  }
  
  public Response<Object> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.ClearCacheRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */