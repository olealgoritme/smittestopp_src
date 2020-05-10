package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import e.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Request<T>
  implements Comparable<Request<T>>
{
  public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
  public Cache.Entry mCacheEntry;
  public boolean mCanceled;
  public final int mDefaultTrafficStatsTag;
  public Response.ErrorListener mErrorListener;
  public final VolleyLog.MarkerLog mEventLog;
  public final Object mLock;
  public final int mMethod;
  public NetworkRequestCompleteListener mRequestCompleteListener;
  public RequestQueue mRequestQueue;
  public boolean mResponseDelivered;
  public RetryPolicy mRetryPolicy;
  public Integer mSequence;
  public boolean mShouldCache;
  public boolean mShouldRetryServerErrors;
  public Object mTag;
  public final String mUrl;
  
  public Request(int paramInt, String paramString, Response.ErrorListener paramErrorListener)
  {
    VolleyLog.MarkerLog localMarkerLog;
    if (VolleyLog.MarkerLog.ENABLED) {
      localMarkerLog = new VolleyLog.MarkerLog();
    } else {
      localMarkerLog = null;
    }
    mEventLog = localMarkerLog;
    mLock = new Object();
    mShouldCache = true;
    mCanceled = false;
    mResponseDelivered = false;
    mShouldRetryServerErrors = false;
    mCacheEntry = null;
    mMethod = paramInt;
    mUrl = paramString;
    mErrorListener = paramErrorListener;
    setRetryPolicy(new DefaultRetryPolicy());
    mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(paramString);
  }
  
  @Deprecated
  public Request(String paramString, Response.ErrorListener paramErrorListener)
  {
    this(-1, paramString, paramErrorListener);
  }
  
  private byte[] encodeParameters(Map<String, String> paramMap, String paramString)
  {
    Object localObject = new StringBuilder();
    try
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        if ((paramMap.getKey() != null) && (paramMap.getValue() != null))
        {
          ((StringBuilder)localObject).append(URLEncoder.encode((String)paramMap.getKey(), paramString));
          ((StringBuilder)localObject).append('=');
          ((StringBuilder)localObject).append(URLEncoder.encode((String)paramMap.getValue(), paramString));
          ((StringBuilder)localObject).append('&');
        }
        else
        {
          localObject = new java/lang/IllegalArgumentException;
          ((IllegalArgumentException)localObject).<init>(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", new Object[] { paramMap.getKey(), paramMap.getValue() }));
          throw ((Throwable)localObject);
        }
      }
      paramMap = ((StringBuilder)localObject).toString().getBytes(paramString);
      return paramMap;
    }
    catch (UnsupportedEncodingException paramMap)
    {
      throw new RuntimeException(a.b("Encoding not supported: ", paramString), paramMap);
    }
  }
  
  public static int findDefaultTrafficStatsTag(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public void addMarker(String paramString)
  {
    if (VolleyLog.MarkerLog.ENABLED) {
      mEventLog.add(paramString, Thread.currentThread().getId());
    }
  }
  
  public void cancel()
  {
    synchronized (mLock)
    {
      mCanceled = true;
      mErrorListener = null;
      return;
    }
  }
  
  public int compareTo(Request<T> paramRequest)
  {
    Priority localPriority1 = getPriority();
    Priority localPriority2 = paramRequest.getPriority();
    int i;
    if (localPriority1 == localPriority2) {
      i = mSequence.intValue() - mSequence.intValue();
    } else {
      i = localPriority2.ordinal() - localPriority1.ordinal();
    }
    return i;
  }
  
  public void deliverError(VolleyError paramVolleyError)
  {
    synchronized (mLock)
    {
      Response.ErrorListener localErrorListener = mErrorListener;
      if (localErrorListener != null) {
        localErrorListener.onErrorResponse(paramVolleyError);
      }
      return;
    }
  }
  
  public abstract void deliverResponse(T paramT);
  
  public void finish(final String paramString)
  {
    RequestQueue localRequestQueue = mRequestQueue;
    if (localRequestQueue != null) {
      localRequestQueue.finish(this);
    }
    if (VolleyLog.MarkerLog.ENABLED)
    {
      final long l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            Request.access$000(Request.this).add(paramString, l);
            Request.access$000(Request.this).finish(toString());
          }
        });
        return;
      }
      mEventLog.add(paramString, l);
      mEventLog.finish(toString());
    }
  }
  
  public byte[] getBody()
  {
    Map localMap = getParams();
    if ((localMap != null) && (localMap.size() > 0)) {
      return encodeParameters(localMap, getParamsEncoding());
    }
    return null;
  }
  
  public String getBodyContentType()
  {
    StringBuilder localStringBuilder = a.a("application/x-www-form-urlencoded; charset=");
    localStringBuilder.append(getParamsEncoding());
    return localStringBuilder.toString();
  }
  
  public Cache.Entry getCacheEntry()
  {
    return mCacheEntry;
  }
  
  public String getCacheKey()
  {
    String str = getUrl();
    int i = getMethod();
    Object localObject = str;
    if (i != 0) {
      if (i == -1)
      {
        localObject = str;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(Integer.toString(i));
        ((StringBuilder)localObject).append('-');
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  public Response.ErrorListener getErrorListener()
  {
    synchronized (mLock)
    {
      Response.ErrorListener localErrorListener = mErrorListener;
      return localErrorListener;
    }
  }
  
  public Map<String, String> getHeaders()
  {
    return Collections.emptyMap();
  }
  
  public int getMethod()
  {
    return mMethod;
  }
  
  public Map<String, String> getParams()
  {
    return null;
  }
  
  public String getParamsEncoding()
  {
    return "UTF-8";
  }
  
  @Deprecated
  public byte[] getPostBody()
  {
    Map localMap = getPostParams();
    if ((localMap != null) && (localMap.size() > 0)) {
      return encodeParameters(localMap, getPostParamsEncoding());
    }
    return null;
  }
  
  @Deprecated
  public String getPostBodyContentType()
  {
    return getBodyContentType();
  }
  
  @Deprecated
  public Map<String, String> getPostParams()
  {
    return getParams();
  }
  
  @Deprecated
  public String getPostParamsEncoding()
  {
    return getParamsEncoding();
  }
  
  public Priority getPriority()
  {
    return Priority.NORMAL;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    return mRetryPolicy;
  }
  
  public final int getSequence()
  {
    Integer localInteger = mSequence;
    if (localInteger != null) {
      return localInteger.intValue();
    }
    throw new IllegalStateException("getSequence called before setSequence");
  }
  
  public Object getTag()
  {
    return mTag;
  }
  
  public final int getTimeoutMs()
  {
    return getRetryPolicy().getCurrentTimeout();
  }
  
  public int getTrafficStatsTag()
  {
    return mDefaultTrafficStatsTag;
  }
  
  public String getUrl()
  {
    return mUrl;
  }
  
  public boolean hasHadResponseDelivered()
  {
    synchronized (mLock)
    {
      boolean bool = mResponseDelivered;
      return bool;
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (mLock)
    {
      boolean bool = mCanceled;
      return bool;
    }
  }
  
  public void markDelivered()
  {
    synchronized (mLock)
    {
      mResponseDelivered = true;
      return;
    }
  }
  
  public void notifyListenerResponseNotUsable()
  {
    synchronized (mLock)
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onNoUsableResponseReceived(this);
      }
      return;
    }
  }
  
  public void notifyListenerResponseReceived(Response<?> paramResponse)
  {
    synchronized (mLock)
    {
      NetworkRequestCompleteListener localNetworkRequestCompleteListener = mRequestCompleteListener;
      if (localNetworkRequestCompleteListener != null) {
        localNetworkRequestCompleteListener.onResponseReceived(this, paramResponse);
      }
      return;
    }
  }
  
  public VolleyError parseNetworkError(VolleyError paramVolleyError)
  {
    return paramVolleyError;
  }
  
  public abstract Response<T> parseNetworkResponse(NetworkResponse paramNetworkResponse);
  
  public Request<?> setCacheEntry(Cache.Entry paramEntry)
  {
    mCacheEntry = paramEntry;
    return this;
  }
  
  public void setNetworkRequestCompleteListener(NetworkRequestCompleteListener paramNetworkRequestCompleteListener)
  {
    synchronized (mLock)
    {
      mRequestCompleteListener = paramNetworkRequestCompleteListener;
      return;
    }
  }
  
  public Request<?> setRequestQueue(RequestQueue paramRequestQueue)
  {
    mRequestQueue = paramRequestQueue;
    return this;
  }
  
  public Request<?> setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    mRetryPolicy = paramRetryPolicy;
    return this;
  }
  
  public final Request<?> setSequence(int paramInt)
  {
    mSequence = Integer.valueOf(paramInt);
    return this;
  }
  
  public final Request<?> setShouldCache(boolean paramBoolean)
  {
    mShouldCache = paramBoolean;
    return this;
  }
  
  public final Request<?> setShouldRetryServerErrors(boolean paramBoolean)
  {
    mShouldRetryServerErrors = paramBoolean;
    return this;
  }
  
  public Request<?> setTag(Object paramObject)
  {
    mTag = paramObject;
    return this;
  }
  
  public final boolean shouldCache()
  {
    return mShouldCache;
  }
  
  public final boolean shouldRetryServerErrors()
  {
    return mShouldRetryServerErrors;
  }
  
  public String toString()
  {
    Object localObject = a.a("0x");
    ((StringBuilder)localObject).append(Integer.toHexString(getTrafficStatsTag()));
    String str = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled()) {
      localObject = "[X] ";
    } else {
      localObject = "[ ] ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(getUrl());
    localStringBuilder.append(" ");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(getPriority());
    localStringBuilder.append(" ");
    localStringBuilder.append(mSequence);
    return localStringBuilder.toString();
  }
  
  public static abstract interface Method
  {
    public static final int DELETE = 3;
    public static final int DEPRECATED_GET_OR_POST = -1;
    public static final int GET = 0;
    public static final int HEAD = 4;
    public static final int OPTIONS = 5;
    public static final int PATCH = 7;
    public static final int POST = 1;
    public static final int PUT = 2;
    public static final int TRACE = 6;
  }
  
  public static abstract interface NetworkRequestCompleteListener
  {
    public abstract void onNoUsableResponseReceived(Request<?> paramRequest);
    
    public abstract void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse);
  }
  
  public static enum Priority
  {
    static
    {
      HIGH = new Priority("HIGH", 2);
      Priority localPriority = new Priority("IMMEDIATE", 3);
      IMMEDIATE = localPriority;
      $VALUES = new Priority[] { LOW, NORMAL, HIGH, localPriority };
    }
    
    public Priority() {}
  }
}

/* Location:
 * Qualified Name:     com.android.volley.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */