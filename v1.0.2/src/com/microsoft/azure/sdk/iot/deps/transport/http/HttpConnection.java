package com.microsoft.azure.sdk.iot.deps.transport.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class HttpConnection
{
  public byte[] body;
  public final HttpsURLConnection connection;
  
  public HttpConnection()
  {
    connection = null;
  }
  
  public HttpConnection(URL paramURL, HttpMethod paramHttpMethod)
  {
    String str = paramURL.getProtocol();
    if (str.equalsIgnoreCase("HTTPS"))
    {
      connection = ((HttpsURLConnection)paramURL.openConnection());
      paramURL = paramHttpMethod;
      if (paramHttpMethod == HttpMethod.PATCH)
      {
        setUnsupportedMethod(paramHttpMethod);
        paramURL = HttpMethod.POST;
      }
      connection.setRequestMethod(paramURL.name());
      body = new byte[0];
      return;
    }
    throw new IllegalArgumentException(String.format("Expected URL that uses iotHubServiceClientProtocol HTTPS but received one that uses iotHubServiceClientProtocol '%s'.\n", new Object[] { str }));
  }
  
  public static byte[] readInputStream(InputStream paramInputStream)
  {
    ArrayList localArrayList = new ArrayList();
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
  
  private void setUnsupportedMethod(HttpMethod paramHttpMethod)
  {
    if (paramHttpMethod == HttpMethod.PATCH)
    {
      setRequestHeader("X-HTTP-Method-Override", "PATCH");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected Http Method ");
    localStringBuilder.append(paramHttpMethod);
    throw new IOException(localStringBuilder.toString());
  }
  
  public void connect()
  {
    if (body.length > 0)
    {
      connection.setDoOutput(true);
      connection.getOutputStream().write(body);
    }
    connection.connect();
  }
  
  public Map<String, List<String>> getResponseHeaders()
  {
    return connection.getHeaderFields();
  }
  
  public int getResponseStatus()
  {
    return connection.getResponseCode();
  }
  
  /* Error */
  public byte[] readError()
  {
    // Byte code:
    //   0: iconst_0
    //   1: newarray <illegal type>
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 14	com/microsoft/azure/sdk/iot/deps/transport/http/HttpConnection:connection	Ljavax/net/ssl/HttpsURLConnection;
    //   8: invokevirtual 161	javax/net/ssl/HttpsURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +30 -> 43
    //   16: aload_2
    //   17: invokestatic 163	com/microsoft/azure/sdk/iot/deps/transport/http/HttpConnection:readInputStream	(Ljava/io/InputStream;)[B
    //   20: astore_1
    //   21: goto +22 -> 43
    //   24: astore_1
    //   25: aload_1
    //   26: athrow
    //   27: astore_3
    //   28: aload_2
    //   29: invokevirtual 166	java/io/InputStream:close	()V
    //   32: goto +9 -> 41
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 172	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   41: aload_3
    //   42: athrow
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 166	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	HttpConnection
    //   3	18	1	arrayOfByte1	byte[]
    //   24	28	1	arrayOfByte2	byte[]
    //   11	18	2	localInputStream	InputStream
    //   35	13	2	localThrowable	Throwable
    //   27	15	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	21	24	finally
    //   25	27	27	finally
    //   28	32	35	finally
  }
  
  /* Error */
  public byte[] readInput()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/microsoft/azure/sdk/iot/deps/transport/http/HttpConnection:connection	Ljavax/net/ssl/HttpsURLConnection;
    //   4: invokevirtual 176	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 163	com/microsoft/azure/sdk/iot/deps/transport/http/HttpConnection:readInputStream	(Ljava/io/InputStream;)[B
    //   12: astore_2
    //   13: aload_1
    //   14: ifnull +7 -> 21
    //   17: aload_1
    //   18: invokevirtual 166	java/io/InputStream:close	()V
    //   21: aload_2
    //   22: areturn
    //   23: astore_2
    //   24: aload_2
    //   25: athrow
    //   26: astore_3
    //   27: aload_1
    //   28: ifnull +16 -> 44
    //   31: aload_1
    //   32: invokevirtual 166	java/io/InputStream:close	()V
    //   35: goto +9 -> 44
    //   38: astore_1
    //   39: aload_2
    //   40: aload_1
    //   41: invokevirtual 172	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   44: aload_3
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	HttpConnection
    //   7	25	1	localInputStream	InputStream
    //   38	3	1	localThrowable	Throwable
    //   12	10	2	arrayOfByte	byte[]
    //   23	17	2	localObject1	Object
    //   26	19	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	13	23	finally
    //   24	26	26	finally
    //   31	35	38	finally
  }
  
  public void setReadTimeoutMillis(int paramInt)
  {
    connection.setReadTimeout(paramInt);
  }
  
  public void setRequestHeader(String paramString1, String paramString2)
  {
    connection.setRequestProperty(paramString1, paramString2);
  }
  
  public void setRequestMethod(HttpMethod paramHttpMethod)
  {
    if ((paramHttpMethod != HttpMethod.POST) && (paramHttpMethod != HttpMethod.PUT) && (body.length > 0)) {
      throw new IllegalArgumentException("Cannot change the request method from POST or PUT when the request body is non-empty.");
    }
    try
    {
      connection.setRequestMethod(paramHttpMethod.name());
      return;
    }
    catch (ProtocolException paramHttpMethod)
    {
      for (;;) {}
    }
  }
  
  public void setSSLContext(SSLContext paramSSLContext)
  {
    if (paramSSLContext != null)
    {
      connection.setSSLSocketFactory(paramSSLContext.getSocketFactory());
      return;
    }
    throw new IllegalArgumentException("SSL context cannot be null");
  }
  
  public void writeOutput(byte[] paramArrayOfByte)
  {
    HttpMethod localHttpMethod = HttpMethod.valueOf(connection.getRequestMethod());
    if ((localHttpMethod != HttpMethod.POST) && (localHttpMethod != HttpMethod.PUT))
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.http.HttpConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */