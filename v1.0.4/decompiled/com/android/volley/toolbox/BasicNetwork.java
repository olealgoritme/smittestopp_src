package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache.Entry;
import com.android.volley.ClientError;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import e.a.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BasicNetwork
  implements Network
{
  public static final boolean DEBUG = VolleyLog.DEBUG;
  public static final int DEFAULT_POOL_SIZE = 4096;
  public static final int SLOW_REQUEST_THRESHOLD_MS = 3000;
  public final BaseHttpStack mBaseHttpStack;
  @Deprecated
  public final HttpStack mHttpStack;
  public final ByteArrayPool mPool;
  
  public BasicNetwork(BaseHttpStack paramBaseHttpStack)
  {
    this(paramBaseHttpStack, new ByteArrayPool(4096));
  }
  
  public BasicNetwork(BaseHttpStack paramBaseHttpStack, ByteArrayPool paramByteArrayPool)
  {
    mBaseHttpStack = paramBaseHttpStack;
    mHttpStack = paramBaseHttpStack;
    mPool = paramByteArrayPool;
  }
  
  @Deprecated
  public BasicNetwork(HttpStack paramHttpStack)
  {
    this(paramHttpStack, new ByteArrayPool(4096));
  }
  
  @Deprecated
  public BasicNetwork(HttpStack paramHttpStack, ByteArrayPool paramByteArrayPool)
  {
    mHttpStack = paramHttpStack;
    mBaseHttpStack = new AdaptedHttpStack(paramHttpStack);
    mPool = paramByteArrayPool;
  }
  
  public static void attemptRetryOnException(String paramString, Request<?> paramRequest, VolleyError paramVolleyError)
  {
    RetryPolicy localRetryPolicy = paramRequest.getRetryPolicy();
    int i = paramRequest.getTimeoutMs();
    try
    {
      localRetryPolicy.retry(paramVolleyError);
      paramRequest.addMarker(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (VolleyError paramVolleyError)
    {
      paramRequest.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramVolleyError;
    }
  }
  
  public static List<Header> combineHeaders(List<Header> paramList, Cache.Entry paramEntry)
  {
    TreeSet localTreeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    if (!paramList.isEmpty())
    {
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext()) {
        localTreeSet.add(((Header)((Iterator)localObject).next()).getName());
      }
    }
    paramList = new ArrayList(paramList);
    Object localObject = allResponseHeaders;
    if (localObject != null)
    {
      if (!((List)localObject).isEmpty())
      {
        paramEntry = allResponseHeaders.iterator();
        while (paramEntry.hasNext())
        {
          localObject = (Header)paramEntry.next();
          if (!localTreeSet.contains(((Header)localObject).getName())) {
            paramList.add(localObject);
          }
        }
      }
    }
    else if (!responseHeaders.isEmpty())
    {
      paramEntry = responseHeaders.entrySet().iterator();
      while (paramEntry.hasNext())
      {
        localObject = (Map.Entry)paramEntry.next();
        if (!localTreeSet.contains(((Map.Entry)localObject).getKey())) {
          paramList.add(new Header((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue()));
        }
      }
    }
    return paramList;
  }
  
  @Deprecated
  public static Map<String, String> convertHeaders(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < paramArrayOfHeader.length; i++) {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    }
    return localTreeMap;
  }
  
  private Map<String, String> getCacheHeaders(Cache.Entry paramEntry)
  {
    if (paramEntry == null) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    String str = etag;
    if (str != null) {
      localHashMap.put("If-None-Match", str);
    }
    long l = lastModified;
    if (l > 0L) {
      localHashMap.put("If-Modified-Since", HttpHeaderParser.formatEpochAsRfc1123(l));
    }
    return localHashMap;
  }
  
  private byte[] inputStreamToBytes(InputStream paramInputStream, int paramInt)
  {
    PoolingByteArrayOutputStream localPoolingByteArrayOutputStream = new PoolingByteArrayOutputStream(mPool, paramInt);
    byte[] arrayOfByte = null;
    if (paramInputStream != null)
    {
      localObject2 = arrayOfByte;
      try
      {
        arrayOfByte = mPool.getBuf(1024);
        for (;;)
        {
          localObject2 = arrayOfByte;
          paramInt = paramInputStream.read(arrayOfByte);
          if (paramInt == -1) {
            break;
          }
          localObject2 = arrayOfByte;
          localPoolingByteArrayOutputStream.write(arrayOfByte, 0, paramInt);
        }
        localObject2 = arrayOfByte;
        localObject3 = localPoolingByteArrayOutputStream.toByteArray();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
        }
        mPool.returnBuf(arrayOfByte);
        localPoolingByteArrayOutputStream.close();
        return (byte[])localObject3;
      }
      finally
      {
        break label140;
      }
    }
    Object localObject2 = localObject1;
    Object localObject3 = new com/android/volley/ServerError;
    localObject2 = localObject1;
    ((ServerError)localObject3).<init>();
    localObject2 = localObject1;
    throw ((Throwable)localObject3);
    label140:
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
      }
      catch (IOException paramInputStream)
      {
        VolleyLog.v("Error occurred when closing InputStream", new Object[0]);
      }
    }
    mPool.returnBuf((byte[])localObject2);
    localPoolingByteArrayOutputStream.close();
    throw ((Throwable)localObject1);
  }
  
  private void logSlowRequests(long paramLong, Request<?> paramRequest, byte[] paramArrayOfByte, int paramInt)
  {
    if ((DEBUG) || (paramLong > 3000L))
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
      } else {
        paramArrayOfByte = "null";
      }
      VolleyLog.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramRequest, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramInt), Integer.valueOf(paramRequest.getRetryPolicy().getCurrentRetryCount()) });
    }
  }
  
  public void logError(String paramString1, String paramString2, long paramLong)
  {
    VolleyLog.v("HTTP ERROR(%s) %d ms to fetch %s", new Object[] { paramString1, Long.valueOf(SystemClock.elapsedRealtime() - paramLong), paramString2 });
  }
  
  public NetworkResponse performRequest(Request<?> paramRequest)
  {
    long l1 = SystemClock.elapsedRealtime();
    for (;;)
    {
      Object localObject1 = Collections.emptyList();
      Object localObject3 = null;
      try
      {
        int i;
        label188:
        Object localObject8;
        Object localObject2;
        Object localObject4;
        try
        {
          Object localObject5 = getCacheHeaders(paramRequest.getCacheEntry());
          localObject5 = mBaseHttpStack.executeRequest(paramRequest, (Map)localObject5);
          try
          {
            i = ((HttpResponse)localObject5).getStatusCode();
            localObject3 = ((HttpResponse)localObject5).getHeaders();
            Object localObject7;
            if (i == 304) {
              try
              {
                localObject7 = paramRequest.getCacheEntry();
                if (localObject7 == null) {
                  return new NetworkResponse(304, null, true, SystemClock.elapsedRealtime() - l1, (List)localObject3);
                }
                localObject1 = combineHeaders((List)localObject3, (Cache.Entry)localObject7);
                localObject1 = new NetworkResponse(304, data, true, SystemClock.elapsedRealtime() - l1, (List)localObject1);
                return (NetworkResponse)localObject1;
              }
              catch (IOException localIOException6) {}
            }
            try
            {
              localObject1 = ((HttpResponse)localObject5).getContent();
              if (localObject1 != null)
              {
                localObject1 = inputStreamToBytes((InputStream)localObject1, ((HttpResponse)localObject5).getContentLength());
                break label188;
                Object localObject10 = null;
                localObject1 = localObject5;
                localObject7 = localObject3;
                localObject5 = localIOException6;
                localObject3 = localObject1;
                localObject1 = localObject10;
                break label339;
              }
              else
              {
                localObject1 = new byte[0];
              }
              try
              {
                logSlowRequests(SystemClock.elapsedRealtime() - l1, paramRequest, (byte[])localObject1, i);
                long l2;
                if ((i >= 200) && (i <= 299)) {
                  l2 = SystemClock.elapsedRealtime();
                }
                try
                {
                  return new NetworkResponse(i, (byte[])localObject1, false, l2 - l1, (List)localObject3);
                }
                catch (IOException localIOException4) {}
                localObject7 = new java/io/IOException;
                ((IOException)localObject7).<init>();
                throw ((Throwable)localObject7);
              }
              catch (IOException localIOException5) {}
              localObject9 = localObject3;
              localObject3 = localObject5;
              localObject5 = localIOException5;
              localObject8 = localObject9;
            }
            catch (IOException localIOException1)
            {
              localObject8 = localObject3;
              localObject3 = localIOException1;
              localObject2 = localObject8;
            }
            localObject8 = localObject2;
          }
          catch (IOException localIOException2) {}
          localObject9 = null;
          localObject2 = localObject5;
          localObject5 = localIOException2;
          localObject4 = localObject2;
          localObject2 = localObject9;
        }
        catch (IOException localIOException3)
        {
          Object localObject9 = null;
          localObject8 = localObject2;
          localObject2 = localObject9;
        }
        label339:
        if (localObject4 != null)
        {
          i = ((HttpResponse)localObject4).getStatusCode();
          VolleyLog.e("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramRequest.getUrl() });
          if (localObject2 != null)
          {
            localObject6 = new NetworkResponse(i, (byte[])localObject2, false, SystemClock.elapsedRealtime() - l1, (List)localObject8);
            if ((i != 401) && (i != 403))
            {
              if ((i >= 400) && (i <= 499)) {
                throw new ClientError((NetworkResponse)localObject6);
              }
              if ((i >= 500) && (i <= 599))
              {
                if (paramRequest.shouldRetryServerErrors()) {
                  attemptRetryOnException("server", paramRequest, new ServerError((NetworkResponse)localObject6));
                } else {
                  throw new ServerError((NetworkResponse)localObject6);
                }
              }
              else {
                throw new ServerError((NetworkResponse)localObject6);
              }
            }
            else
            {
              attemptRetryOnException("auth", paramRequest, new AuthFailureError((NetworkResponse)localObject6));
            }
          }
          else
          {
            attemptRetryOnException("network", paramRequest, new NetworkError());
          }
        }
        else
        {
          throw new NoConnectionError((Throwable)localObject6);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject6 = a.a("Bad URL ");
        ((StringBuilder)localObject6).append(paramRequest.getUrl());
        throw new RuntimeException(((StringBuilder)localObject6).toString(), localMalformedURLException);
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        attemptRetryOnException("socket", paramRequest, new TimeoutError());
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.toolbox.BasicNetwork
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */