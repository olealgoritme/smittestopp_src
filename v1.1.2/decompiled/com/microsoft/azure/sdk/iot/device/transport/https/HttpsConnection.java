package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.device.ProxySettings;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.HttpProxySocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class HttpsConnection
{
  public byte[] body;
  public final HttpURLConnection connection;
  public ProxySettings proxySettings;
  
  public HttpsConnection()
  {
    connection = null;
  }
  
  public HttpsConnection(URL paramURL, HttpsMethod paramHttpsMethod)
  {
    this(paramURL, paramHttpsMethod, null);
  }
  
  public HttpsConnection(URL paramURL, HttpsMethod paramHttpsMethod, ProxySettings paramProxySettings)
  {
    String str = paramURL.getProtocol();
    if ((!str.equalsIgnoreCase("HTTPS")) && (!str.equalsIgnoreCase("HTTP"))) {
      throw new IllegalArgumentException(String.format("Expected URL that uses protocol HTTPS or HTTP but received one that uses protocol '%s'.%n", new Object[] { str }));
    }
    body = new byte[0];
    try
    {
      paramURL = (HttpURLConnection)paramURL.openConnection();
      connection = paramURL;
      paramURL.setRequestMethod(paramHttpsMethod.name());
      proxySettings = paramProxySettings;
      return;
    }
    catch (IOException paramURL)
    {
      throw buildTransportException(paramURL);
    }
  }
  
  public static TransportException buildTransportException(IOException paramIOException)
  {
    TransportException localTransportException = new TransportException(paramIOException);
    if (((paramIOException instanceof NoRouteToHostException)) || ((paramIOException instanceof UnknownHostException))) {
      localTransportException.setRetryable(true);
    }
    return localTransportException;
  }
  
  public static byte[] readInputStream(InputStream paramInputStream)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      for (;;)
      {
        i = paramInputStream.read();
        if (i <= -1) {
          break;
        }
        localArrayList.add(Byte.valueOf((byte)i));
      }
      int j = localArrayList.size();
      paramInputStream = new byte[j];
      for (int i = 0; i < j; i++) {
        paramInputStream[i] = ((Byte)localArrayList.get(i)).byteValue();
      }
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      throw buildTransportException(paramInputStream);
    }
  }
  
  public void connect()
  {
    try
    {
      if (body.length > 0)
      {
        connection.setDoOutput(true);
        connection.getOutputStream().write(body);
      }
      connection.connect();
      return;
    }
    catch (IOException localIOException)
    {
      throw buildTransportException(localIOException);
    }
  }
  
  public byte[] getBody()
  {
    return body;
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    return connection.getHeaderFields();
  }
  
  public int getResponseStatus()
  {
    try
    {
      int i = connection.getResponseCode();
      return i;
    }
    catch (IOException localIOException)
    {
      throw buildTransportException(localIOException);
    }
  }
  
  /* Error */
  public byte[] readError()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/microsoft/azure/sdk/iot/device/transport/https/HttpsConnection:connection	Ljava/net/HttpURLConnection;
    //   4: invokevirtual 151	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   7: astore_1
    //   8: iconst_0
    //   9: newarray <illegal type>
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +8 -> 21
    //   16: aload_1
    //   17: invokestatic 153	com/microsoft/azure/sdk/iot/device/transport/https/HttpsConnection:readInputStream	(Ljava/io/InputStream;)[B
    //   20: astore_2
    //   21: aload_1
    //   22: ifnull +7 -> 29
    //   25: aload_1
    //   26: invokevirtual 156	java/io/InputStream:close	()V
    //   29: aload_2
    //   30: areturn
    //   31: astore_3
    //   32: aload_3
    //   33: athrow
    //   34: astore_2
    //   35: aload_1
    //   36: ifnull +16 -> 52
    //   39: aload_1
    //   40: invokevirtual 156	java/io/InputStream:close	()V
    //   43: goto +9 -> 52
    //   46: astore_1
    //   47: aload_3
    //   48: aload_1
    //   49: invokevirtual 161	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   52: aload_2
    //   53: athrow
    //   54: astore_2
    //   55: aload_2
    //   56: invokestatic 72	com/microsoft/azure/sdk/iot/device/transport/https/HttpsConnection:buildTransportException	(Ljava/io/IOException;)Lcom/microsoft/azure/sdk/iot/device/exceptions/TransportException;
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	HttpsConnection
    //   7	33	1	localInputStream	InputStream
    //   46	3	1	localThrowable	Throwable
    //   11	19	2	arrayOfByte	byte[]
    //   34	19	2	localObject1	Object
    //   54	2	2	localIOException	IOException
    //   31	17	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	12	31	finally
    //   16	21	31	finally
    //   32	34	34	finally
    //   39	43	46	finally
    //   0	8	54	java/io/IOException
    //   25	29	54	java/io/IOException
    //   47	52	54	java/io/IOException
    //   52	54	54	java/io/IOException
  }
  
  /* Error */
  public byte[] readInput()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/microsoft/azure/sdk/iot/device/transport/https/HttpsConnection:connection	Ljava/net/HttpURLConnection;
    //   4: invokevirtual 165	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 153	com/microsoft/azure/sdk/iot/device/transport/https/HttpsConnection:readInputStream	(Ljava/io/InputStream;)[B
    //   12: astore_2
    //   13: aload_1
    //   14: ifnull +7 -> 21
    //   17: aload_1
    //   18: invokevirtual 156	java/io/InputStream:close	()V
    //   21: aload_2
    //   22: areturn
    //   23: astore_3
    //   24: aload_3
    //   25: athrow
    //   26: astore_2
    //   27: aload_1
    //   28: ifnull +16 -> 44
    //   31: aload_1
    //   32: invokevirtual 156	java/io/InputStream:close	()V
    //   35: goto +9 -> 44
    //   38: astore_1
    //   39: aload_3
    //   40: aload_1
    //   41: invokevirtual 161	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   44: aload_2
    //   45: athrow
    //   46: astore_1
    //   47: aload_1
    //   48: invokestatic 72	com/microsoft/azure/sdk/iot/device/transport/https/HttpsConnection:buildTransportException	(Ljava/io/IOException;)Lcom/microsoft/azure/sdk/iot/device/exceptions/TransportException;
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	HttpsConnection
    //   7	25	1	localInputStream	InputStream
    //   38	3	1	localThrowable	Throwable
    //   46	2	1	localIOException	IOException
    //   12	10	2	arrayOfByte	byte[]
    //   26	19	2	localObject1	Object
    //   23	17	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	13	23	finally
    //   24	26	26	finally
    //   31	35	38	finally
    //   0	8	46	java/io/IOException
    //   17	21	46	java/io/IOException
    //   39	44	46	java/io/IOException
    //   44	46	46	java/io/IOException
  }
  
  public void setReadTimeoutMillis(int paramInt)
  {
    connection.setReadTimeout(paramInt);
  }
  
  public void setRequestHeader(String paramString1, String paramString2)
  {
    connection.setRequestProperty(paramString1, paramString2);
  }
  
  public void setRequestMethod(HttpsMethod paramHttpsMethod)
  {
    if ((paramHttpsMethod != HttpsMethod.POST) && (paramHttpsMethod != HttpsMethod.PUT) && (body.length > 0)) {
      throw new IllegalArgumentException("Cannot change the request method from POST or PUT when the request body is non-empty.");
    }
    try
    {
      connection.setRequestMethod(paramHttpsMethod.name());
      return;
    }
    catch (SecurityException paramHttpsMethod)
    {
      throw new TransportException(paramHttpsMethod);
    }
    catch (ProtocolException paramHttpsMethod)
    {
      throw new TransportException(paramHttpsMethod);
    }
  }
  
  public void setSSLContext(SSLContext paramSSLContext)
  {
    if (paramSSLContext != null)
    {
      HttpURLConnection localHttpURLConnection = connection;
      if ((localHttpURLConnection instanceof HttpsURLConnection))
      {
        if (proxySettings != null) {
          ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(new HttpProxySocketFactory(paramSSLContext.getSocketFactory(), proxySettings));
        } else {
          ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramSSLContext.getSocketFactory());
        }
        return;
      }
      throw new UnsupportedOperationException("HTTP connections do not support using ssl socket factory");
    }
    throw new IllegalArgumentException("SSL context cannot be null");
  }
  
  public void writeOutput(byte[] paramArrayOfByte)
  {
    HttpsMethod localHttpsMethod = HttpsMethod.valueOf(connection.getRequestMethod());
    if ((localHttpsMethod != HttpsMethod.POST) && (localHttpsMethod != HttpsMethod.PUT))
    {
      if (paramArrayOfByte.length > 0) {
        throw new IllegalArgumentException("Cannot write a body to a request that is not a POST or a PUT request.");
      }
    }
    else {
      body = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.https.HttpsConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */