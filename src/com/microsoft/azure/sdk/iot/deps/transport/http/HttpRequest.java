package com.microsoft.azure.sdk.iot.deps.transport.http;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.SSLContext;

public class HttpRequest
{
  public final HttpConnection connection;
  
  public HttpRequest()
  {
    connection = null;
  }
  
  public HttpRequest(URL paramURL, HttpMethod paramHttpMethod, byte[] paramArrayOfByte)
  {
    paramURL = new HttpConnection(paramURL, paramHttpMethod);
    connection = paramURL;
    paramURL.writeOutput(paramArrayOfByte);
  }
  
  public HttpResponse send()
  {
    Object localObject = new byte[0];
    byte[] arrayOfByte1 = new byte[0];
    int i;
    Map localMap2;
    try
    {
      connection.connect();
      i = connection.getResponseStatus();
      Map localMap1 = connection.getResponseHeaders();
      byte[] arrayOfByte2 = connection.readInput();
      localObject = arrayOfByte2;
    }
    catch (IOException localIOException)
    {
      i = connection.getResponseStatus();
      localMap2 = connection.getResponseHeaders();
      arrayOfByte1 = connection.readError();
    }
    return new HttpResponse(i, (byte[])localObject, localMap2, arrayOfByte1);
  }
  
  public HttpRequest setHeaderField(String paramString1, String paramString2)
  {
    connection.setRequestHeader(paramString1, paramString2);
    return this;
  }
  
  public HttpRequest setReadTimeoutMillis(int paramInt)
  {
    connection.setReadTimeoutMillis(paramInt);
    return this;
  }
  
  public HttpRequest setSSLContext(SSLContext paramSSLContext)
  {
    if (paramSSLContext != null)
    {
      connection.setSSLContext(paramSSLContext);
      return this;
    }
    throw new IllegalArgumentException("Context cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.http.HttpRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */