package com.microsoft.identity.common.adal.internal.net;

import android.content.Context;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.exception.ClientException;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpWebRequest
{
  public static final int CONNECT_TIME_OUT = AuthenticationSettings.INSTANCE.getConnectTimeOut();
  public static final int DEBUG_SIMULATE_DELAY = 0;
  public static final int READ_TIME_OUT = AuthenticationSettings.INSTANCE.getReadTimeOut();
  public static final String REQUEST_METHOD_GET = "GET";
  public static final String REQUEST_METHOD_POST = "POST";
  public final byte[] mRequestContent;
  public final String mRequestContentType;
  public final Map<String, String> mRequestHeaders;
  public final String mRequestMethod;
  public final URL mUrl;
  
  public HttpWebRequest(URL paramURL, String paramString, Map<String, String> paramMap)
  {
    this(paramURL, paramString, paramMap, null, null);
  }
  
  public HttpWebRequest(URL paramURL, String paramString1, Map<String, String> paramMap, byte[] paramArrayOfByte, String paramString2)
  {
    mUrl = paramURL;
    mRequestMethod = paramString1;
    paramString1 = new HashMap();
    mRequestHeaders = paramString1;
    paramURL = mUrl;
    if (paramURL != null) {
      paramString1.put("Host", paramURL.getAuthority());
    }
    mRequestHeaders.putAll(paramMap);
    mRequestContent = paramArrayOfByte;
    mRequestContentType = paramString2;
  }
  
  /* Error */
  public static String convertStreamToString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 90	java/io/BufferedReader
    //   5: astore_2
    //   6: new 92	java/io/InputStreamReader
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokespecial 95	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   15: aload_2
    //   16: aload_3
    //   17: invokespecial 98	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: new 100	java/lang/StringBuilder
    //   23: astore_0
    //   24: aload_0
    //   25: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   28: aload_2
    //   29: invokevirtual 104	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +26 -> 60
    //   37: aload_0
    //   38: invokevirtual 107	java/lang/StringBuilder:length	()I
    //   41: ifle +10 -> 51
    //   44: aload_0
    //   45: bipush 10
    //   47: invokevirtual 111	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: aload_1
    //   53: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -29 -> 28
    //   60: aload_0
    //   61: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual 120	java/io/BufferedReader:close	()V
    //   69: aload_0
    //   70: areturn
    //   71: astore_0
    //   72: goto +6 -> 78
    //   75: astore_0
    //   76: aload_1
    //   77: astore_2
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 120	java/io/BufferedReader:close	()V
    //   86: aload_0
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramInputStream	java.io.InputStream
    //   1	76	1	str	String
    //   5	78	2	localObject	Object
    //   9	8	3	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   20	28	71	finally
    //   28	33	71	finally
    //   37	51	71	finally
    //   51	57	71	finally
    //   60	65	71	finally
    //   2	20	75	finally
  }
  
  public static void safeCloseStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
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
  
  public static void setRequestBody(HttpURLConnection paramHttpURLConnection, byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      if ((paramString != null) && (!paramString.isEmpty())) {
        paramHttpURLConnection.setRequestProperty("Content-Type", paramString);
      }
      paramHttpURLConnection.setRequestProperty("Content-Length", Integer.toString(paramArrayOfByte.length));
      paramHttpURLConnection.setFixedLengthStreamingMode(paramArrayOfByte.length);
      paramString = null;
      try
      {
        paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
        paramString = paramHttpURLConnection;
        paramHttpURLConnection.write(paramArrayOfByte);
      }
      finally
      {
        safeCloseStream(paramString);
      }
    }
  }
  
  private HttpURLConnection setupConnection()
  {
    Object localObject = mUrl;
    if (localObject != null)
    {
      if ((!((URL)localObject).getProtocol().equalsIgnoreCase("http")) && (!mUrl.getProtocol().equalsIgnoreCase("https"))) {
        throw new IllegalArgumentException("requestURL");
      }
      HttpURLConnection.setFollowRedirects(true);
      localObject = HttpUrlConnectionFactory.createHttpUrlConnection(mUrl);
      ((HttpURLConnection)localObject).setConnectTimeout(CONNECT_TIME_OUT);
      ((HttpURLConnection)localObject).setRequestProperty("Connection", "close");
      Iterator localIterator = mRequestHeaders.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((HttpURLConnection)localObject).setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      ((HttpURLConnection)localObject).setReadTimeout(READ_TIME_OUT);
      ((HttpURLConnection)localObject).setInstanceFollowRedirects(true);
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setRequestMethod(mRequestMethod);
      ((HttpURLConnection)localObject).setDoInput(true);
      setRequestBody((HttpURLConnection)localObject, mRequestContent, mRequestContentType);
      return (HttpURLConnection)localObject;
    }
    throw new IllegalArgumentException("requestURL");
  }
  
  public static void throwIfNetworkNotAvailable(Context paramContext)
  {
    paramContext = new DefaultConnectionService(paramContext);
    if (!paramContext.isConnectionAvailable())
    {
      if (paramContext.isNetworkDisabledFromOptimizations()) {
        throw new ClientException("device_network_not_available_doze_mode", "Connection is not available to refresh token because power optimization is enabled. And the device is in doze mode or the app is standby");
      }
      throw new ClientException("device_network_not_available", "Connection is not available to refresh token");
    }
  }
  
  /* Error */
  public HttpWebResponse send()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 277	com/microsoft/identity/common/adal/internal/net/HttpWebRequest:setupConnection	()Ljava/net/HttpURLConnection;
    //   4: astore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: aload_1
    //   10: invokevirtual 281	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   13: astore 4
    //   15: aload 4
    //   17: astore_2
    //   18: goto +20 -> 38
    //   21: astore_2
    //   22: goto +69 -> 91
    //   25: astore 4
    //   27: aload_2
    //   28: astore_3
    //   29: aload_1
    //   30: invokevirtual 284	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +51 -> 86
    //   38: aload_2
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 287	java/net/HttpURLConnection:getResponseCode	()I
    //   44: istore 5
    //   46: aload_2
    //   47: astore_3
    //   48: aload_2
    //   49: invokestatic 289	com/microsoft/identity/common/adal/internal/net/HttpWebRequest:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   52: astore 4
    //   54: aload_2
    //   55: astore_3
    //   56: invokestatic 294	android/os/Debug:isDebuggerConnected	()Z
    //   59: pop
    //   60: aload_2
    //   61: astore_3
    //   62: new 296	com/microsoft/identity/common/adal/internal/net/HttpWebResponse
    //   65: dup
    //   66: iload 5
    //   68: aload 4
    //   70: aload_1
    //   71: invokevirtual 300	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   74: invokespecial 303	com/microsoft/identity/common/adal/internal/net/HttpWebResponse:<init>	(ILjava/lang/String;Ljava/util/Map;)V
    //   77: astore 4
    //   79: aload_2
    //   80: invokestatic 170	com/microsoft/identity/common/adal/internal/net/HttpWebRequest:safeCloseStream	(Ljava/io/Closeable;)V
    //   83: aload 4
    //   85: areturn
    //   86: aload_2
    //   87: astore_3
    //   88: aload 4
    //   90: athrow
    //   91: aload_3
    //   92: invokestatic 170	com/microsoft/identity/common/adal/internal/net/HttpWebRequest:safeCloseStream	(Ljava/io/Closeable;)V
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	HttpWebRequest
    //   4	67	1	localHttpURLConnection	HttpURLConnection
    //   6	12	2	localObject1	Object
    //   21	7	2	localObject2	Object
    //   33	63	2	localInputStream1	java.io.InputStream
    //   8	84	3	localObject3	Object
    //   13	3	4	localInputStream2	java.io.InputStream
    //   25	1	4	localIOException	IOException
    //   52	37	4	localObject4	Object
    //   44	23	5	i	int
    // Exception table:
    //   from	to	target	type
    //   9	15	21	finally
    //   29	34	21	finally
    //   40	46	21	finally
    //   48	54	21	finally
    //   56	60	21	finally
    //   62	79	21	finally
    //   88	91	21	finally
    //   9	15	25	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.net.HttpWebRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */