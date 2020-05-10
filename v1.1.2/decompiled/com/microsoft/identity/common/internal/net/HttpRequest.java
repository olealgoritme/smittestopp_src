package com.microsoft.identity.common.internal.net;

import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.HttpEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.HttpStartEvent;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class HttpRequest
{
  public static int CONNECT_TIMEOUT = 30000;
  public static final String HOST = "Host";
  public static int READ_TIMEOUT = 30000;
  public static final String REQUEST_METHOD_GET = "GET";
  public static final String REQUEST_METHOD_POST = "POST";
  public static final int RETRY_TIME_WAITING_PERIOD_MSEC = 1000;
  public static final int STREAM_BUFFER_SIZE = 1024;
  public final byte[] mRequestContent;
  public final String mRequestContentType;
  public final Map<String, String> mRequestHeaders;
  public final String mRequestMethod;
  public final URL mRequestUrl;
  
  public HttpRequest(URL paramURL, Map<String, String> paramMap, String paramString)
  {
    this(paramURL, paramMap, paramString, null, null);
  }
  
  public HttpRequest(URL paramURL, Map<String, String> paramMap, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    mRequestHeaders = localHashMap;
    mRequestUrl = paramURL;
    localHashMap.put("Host", paramURL.getAuthority());
    mRequestHeaders.putAll(paramMap);
    mRequestMethod = paramString1;
    mRequestContent = paramArrayOfByte;
    mRequestContentType = paramString2;
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    try
    {
      Object localObject1 = new java/io/BufferedReader;
      Object localObject3 = new java/io/InputStreamReader;
      ((InputStreamReader)localObject3).<init>(paramInputStream);
      ((BufferedReader)localObject1).<init>((Reader)localObject3);
      localObject3 = new char['Ѐ'];
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      for (;;)
      {
        int i = ((BufferedReader)localObject1).read((char[])localObject3);
        if (i <= -1) {
          break;
        }
        localStringBuilder.append((char[])localObject3, 0, i);
      }
      localObject1 = localStringBuilder.toString();
      return (String)localObject1;
    }
    finally
    {
      safeCloseStream(paramInputStream);
    }
  }
  
  /* Error */
  private HttpResponse executeHttpSend()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 112	com/microsoft/identity/common/internal/net/HttpRequest:setupConnection	()Ljava/net/HttpURLConnection;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_0
    //   7: getfield 67	com/microsoft/identity/common/internal/net/HttpRequest:mRequestMethod	Ljava/lang/String;
    //   10: invokevirtual 118	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: iconst_1
    //   15: invokevirtual 122	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 69	com/microsoft/identity/common/internal/net/HttpRequest:mRequestContent	[B
    //   23: aload_0
    //   24: getfield 71	com/microsoft/identity/common/internal/net/HttpRequest:mRequestContentType	Ljava/lang/String;
    //   27: invokestatic 126	com/microsoft/identity/common/internal/net/HttpRequest:setRequestBody	(Ljava/net/HttpURLConnection;[BLjava/lang/String;)V
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_2
    //   33: astore_3
    //   34: aload_1
    //   35: invokevirtual 130	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   38: astore 4
    //   40: aload 4
    //   42: astore_2
    //   43: goto +15 -> 58
    //   46: astore_2
    //   47: goto +71 -> 118
    //   50: astore_3
    //   51: aload_2
    //   52: astore_3
    //   53: aload_1
    //   54: invokevirtual 133	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   57: astore_2
    //   58: aload_2
    //   59: astore_3
    //   60: aload_1
    //   61: invokevirtual 137	java/net/HttpURLConnection:getResponseCode	()I
    //   64: istore 5
    //   66: aload_2
    //   67: ifnonnull +10 -> 77
    //   70: ldc -117
    //   72: astore 4
    //   74: goto +11 -> 85
    //   77: aload_2
    //   78: astore_3
    //   79: aload_2
    //   80: invokestatic 141	com/microsoft/identity/common/internal/net/HttpRequest:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   83: astore 4
    //   85: aload_2
    //   86: astore_3
    //   87: new 143	com/microsoft/identity/common/internal/net/HttpResponse
    //   90: dup
    //   91: iload 5
    //   93: aload 4
    //   95: aload_1
    //   96: invokevirtual 147	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   99: invokespecial 150	com/microsoft/identity/common/internal/net/HttpResponse:<init>	(ILjava/lang/String;Ljava/util/Map;)V
    //   102: astore 4
    //   104: aload_2
    //   105: invokestatic 102	com/microsoft/identity/common/internal/net/HttpRequest:safeCloseStream	(Ljava/io/Closeable;)V
    //   108: aload 4
    //   110: areturn
    //   111: astore 4
    //   113: aload_2
    //   114: astore_3
    //   115: aload 4
    //   117: athrow
    //   118: aload_3
    //   119: invokestatic 102	com/microsoft/identity/common/internal/net/HttpRequest:safeCloseStream	(Ljava/io/Closeable;)V
    //   122: aload_2
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	HttpRequest
    //   4	92	1	localHttpURLConnection	HttpURLConnection
    //   31	12	2	localObject1	Object
    //   46	6	2	localObject2	Object
    //   57	66	2	localInputStream	InputStream
    //   33	1	3	localObject3	Object
    //   50	1	3	localIOException	IOException
    //   52	67	3	localObject4	Object
    //   38	71	4	localObject5	Object
    //   111	5	4	localSocketTimeoutException	SocketTimeoutException
    //   64	28	5	i	int
    // Exception table:
    //   from	to	target	type
    //   34	40	46	finally
    //   53	58	46	finally
    //   60	66	46	finally
    //   79	85	46	finally
    //   87	104	46	finally
    //   115	118	46	finally
    //   34	40	50	java/io/IOException
    //   34	40	111	java/net/SocketTimeoutException
  }
  
  public static boolean isRetryableError(int paramInt)
  {
    boolean bool;
    if ((paramInt != 500) && (paramInt != 504) && (paramInt != 503)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void safeCloseStream(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;) {}
    }
  }
  
  private HttpResponse send()
  {
    HttpResponse localHttpResponse = sendWithRetry();
    if ((localHttpResponse != null) && (isRetryableError(localHttpResponse.getStatusCode()))) {
      throw new UnknownServiceException("Retry failed again with 500/503/504");
    }
    return localHttpResponse;
  }
  
  public static HttpResponse sendGet(URL paramURL, Map<String, String> paramMap)
  {
    HttpStartEvent localHttpStartEvent = new HttpStartEvent().putMethod("GET").putPath(paramURL);
    String str;
    if (paramMap == null) {
      str = null;
    } else {
      str = (String)paramMap.get("client-request-id");
    }
    Telemetry.emit(localHttpStartEvent.putRequestIdHeader(str));
    paramURL = new HttpRequest(paramURL, paramMap, "GET").send();
    paramMap = new HttpEndEvent();
    if (paramURL != null) {
      paramMap.putStatusCode(paramURL.getStatusCode());
    }
    Telemetry.emit(paramMap);
    return paramURL;
  }
  
  public static HttpResponse sendPost(URL paramURL, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString)
  {
    HttpStartEvent localHttpStartEvent = new HttpStartEvent().putMethod("POST").putPath(paramURL);
    String str;
    if (paramMap == null) {
      str = null;
    } else {
      str = (String)paramMap.get("client-request-id");
    }
    Telemetry.emit(localHttpStartEvent.putRequestIdHeader(str));
    paramMap = new HttpRequest(paramURL, paramMap, "POST", paramArrayOfByte, paramString).send();
    paramURL = new HttpEndEvent();
    if (paramMap != null) {
      paramURL.putStatusCode(paramMap.getStatusCode());
    }
    Telemetry.emit(paramURL);
    return paramMap;
  }
  
  private HttpResponse sendWithRetry()
  {
    try
    {
      HttpResponse localHttpResponse1 = executeHttpSend();
      HttpResponse localHttpResponse2 = localHttpResponse1;
      if (isRetryableError(localHttpResponse1.getStatusCode()))
      {
        waitBeforeRetry();
        localHttpResponse2 = executeHttpSend();
      }
      return localHttpResponse2;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      waitBeforeRetry();
    }
    return executeHttpSend();
  }
  
  public static void setRequestBody(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    paramHttpURLConnection.setDoOutput(true);
    if (!StringUtil.isEmpty(paramString)) {
      paramHttpURLConnection.setRequestProperty("Content-Type", paramString);
    }
    paramHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(paramArrayOfByte.length));
    paramString = null;
    try
    {
      paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
      paramString = paramHttpURLConnection;
      paramHttpURLConnection.write(paramArrayOfByte);
      return;
    }
    finally
    {
      safeCloseStream(paramString);
    }
  }
  
  private HttpURLConnection setupConnection()
  {
    HttpURLConnection localHttpURLConnection = HttpUrlConnectionFactory.createHttpURLConnection(mRequestUrl);
    Iterator localIterator = mRequestHeaders.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localHttpURLConnection.setConnectTimeout(CONNECT_TIMEOUT);
    localHttpURLConnection.setReadTimeout(READ_TIMEOUT);
    localHttpURLConnection.setInstanceFollowRedirects(true);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    return localHttpURLConnection;
  }
  
  private void waitBeforeRetry()
  {
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.net.HttpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */