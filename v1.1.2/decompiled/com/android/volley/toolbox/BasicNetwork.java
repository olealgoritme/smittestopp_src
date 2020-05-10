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
        localObject = allResponseHeaders.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramEntry = (Header)((Iterator)localObject).next();
          if (!localTreeSet.contains(paramEntry.getName())) {
            paramList.add(paramEntry);
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
      Object localObject4 = null;
      try
      {
        int i;
        label188:
        Object localObject9;
        Object localObject3;
        Object localObject5;
        try
        {
          Object localObject6 = getCacheHeaders(paramRequest.getCacheEntry());
          localObject6 = mBaseHttpStack.executeRequest(paramRequest, (Map)localObject6);
          try
          {
            i = ((HttpResponse)localObject6).getStatusCode();
            localObject4 = ((HttpResponse)localObject6).getHeaders();
            Object localObject8;
            if (i == 304) {
              try
              {
                localObject1 = paramRequest.getCacheEntry();
                if (localObject1 == null) {
                  return new NetworkResponse(304, null, true, SystemClock.elapsedRealtime() - l1, (List)localObject4);
                }
                localObject8 = combineHeaders((List)localObject4, (Cache.Entry)localObject1);
                localObject1 = new NetworkResponse(304, data, true, SystemClock.elapsedRealtime() - l1, (List)localObject8);
                return (NetworkResponse)localObject1;
              }
              catch (IOException localIOException1) {}
            }
            try
            {
              Object localObject2 = ((HttpResponse)localObject6).getContent();
              if (localObject2 != null)
              {
                localObject2 = inputStreamToBytes((InputStream)localObject2, ((HttpResponse)localObject6).getContentLength());
                break label188;
                Object localObject10 = null;
                localObject11 = localObject6;
                localObject8 = localObject4;
                localObject6 = localObject2;
                localObject4 = localObject11;
                localObject2 = localObject10;
                break label339;
              }
              else
              {
                localObject2 = new byte[0];
              }
              try
              {
                logSlowRequests(SystemClock.elapsedRealtime() - l1, paramRequest, (byte[])localObject2, i);
                long l2;
                if ((i >= 200) && (i <= 299)) {
                  l2 = SystemClock.elapsedRealtime();
                }
                try
                {
                  return new NetworkResponse(i, (byte[])localObject2, false, l2 - l1, (List)localObject4);
                }
                catch (IOException localIOException5) {}
                localObject8 = new java/io/IOException;
                ((IOException)localObject8).<init>();
                throw ((Throwable)localObject8);
              }
              catch (IOException localIOException6) {}
              localObject11 = localObject4;
              localObject4 = localObject6;
              localObject6 = localIOException6;
              localObject9 = localObject11;
            }
            catch (IOException localIOException2)
            {
              localObject9 = localObject4;
              localObject4 = localIOException2;
              localObject3 = localObject9;
            }
            localObject9 = localObject3;
          }
          catch (IOException localIOException3) {}
          localObject11 = null;
          localObject3 = localObject6;
          localObject6 = localIOException3;
          localObject5 = localObject3;
          localObject3 = localObject11;
        }
        catch (IOException localIOException4)
        {
          Object localObject11 = null;
          localObject9 = localObject3;
          localObject3 = localObject11;
        }
        label339:
        if (localObject5 != null)
        {
          i = ((HttpResponse)localObject5).getStatusCode();
          VolleyLog.e("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramRequest.getUrl() });
          if (localObject3 != null)
          {
            localObject7 = new NetworkResponse(i, (byte[])localObject3, false, SystemClock.elapsedRealtime() - l1, (List)localObject9);
            if ((i != 401) && (i != 403))
            {
              if ((i >= 400) && (i <= 499)) {
                throw new ClientError((NetworkResponse)localObject7);
              }
              if ((i >= 500) && (i <= 599))
              {
                if (paramRequest.shouldRetryServerErrors()) {
                  attemptRetryOnException("server", paramRequest, new ServerError((NetworkResponse)localObject7));
                } else {
                  throw new ServerError((NetworkResponse)localObject7);
                }
              }
              else {
                throw new ServerError((NetworkResponse)localObject7);
              }
            }
            else
            {
              attemptRetryOnException("auth", paramRequest, new AuthFailureError((NetworkResponse)localObject7));
            }
          }
          else
          {
            attemptRetryOnException("network", paramRequest, new NetworkError());
          }
        }
        else
        {
          throw new NoConnectionError((Throwable)localObject7);
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject7 = a.a("Bad URL ");
        ((StringBuilder)localObject7).append(paramRequest.getUrl());
        throw new RuntimeException(((StringBuilder)localObject7).toString(), localMalformedURLException);
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        attemptRetryOnException("socket", paramRequest, new TimeoutError());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.BasicNetwork
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */