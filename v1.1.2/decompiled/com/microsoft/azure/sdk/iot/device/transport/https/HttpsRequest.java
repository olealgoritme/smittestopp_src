package com.microsoft.azure.sdk.iot.device.transport.https;

import com.microsoft.azure.sdk.iot.device.ProxySettings;
import e.a.a.a.a;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLContext;

public class HttpsRequest
{
  public byte[] body;
  public int connectionTimeout;
  public Map<String, List<String>> headers;
  public HttpsMethod method;
  public ProxySettings proxySettings;
  public SSLContext sslContext;
  public URL url;
  
  public HttpsRequest() {}
  
  public HttpsRequest(URL paramURL, HttpsMethod paramHttpsMethod, byte[] paramArrayOfByte, String paramString)
  {
    this(paramURL, paramHttpsMethod, paramArrayOfByte, paramString, null);
  }
  
  public HttpsRequest(URL paramURL, HttpsMethod paramHttpsMethod, byte[] paramArrayOfByte, String paramString, ProxySettings paramProxySettings)
  {
    url = paramURL;
    method = paramHttpsMethod;
    body = paramArrayOfByte;
    headers = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if ((paramURL != null) && (paramURL.getHost() != null) && (!paramURL.getHost().isEmpty()))
    {
      paramArrayOfByte = paramURL.getHost();
      paramHttpsMethod = paramArrayOfByte;
      if (paramURL.getPort() != -1)
      {
        paramHttpsMethod = a.a(paramArrayOfByte, ":");
        paramHttpsMethod.append(paramURL.getPort());
        paramHttpsMethod = paramHttpsMethod.toString();
      }
      localArrayList.add(paramHttpsMethod);
      headers.put("Host", localArrayList);
    }
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramURL = new ArrayList();
      paramURL.add(paramString);
      headers.put("User-Agent", paramURL);
    }
    proxySettings = paramProxySettings;
  }
  
  public byte[] getBody()
  {
    return body;
  }
  
  public String getHttpMethod()
  {
    return method.toString();
  }
  
  public String getRequestHeaders()
  {
    Iterator localIterator = headers.keySet().iterator();
    for (String str = ""; localIterator.hasNext(); str = a.b(str.substring(0, str.length() - 2), "\r\n"))
    {
      Object localObject = (String)localIterator.next();
      str = a.b(a.b(str, (String)localObject), ": ");
      localObject = ((List)headers.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        str = a.b(a.b(str, (String)((Iterator)localObject).next()), "; ");
      }
    }
    return str;
  }
  
  public URL getRequestUrl()
  {
    return url;
  }
  
  public HttpsResponse send()
  {
    Object localObject1 = url;
    if (localObject1 != null)
    {
      HttpsConnection localHttpsConnection = new HttpsConnection((URL)localObject1, method, proxySettings);
      Iterator localIterator = headers.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        localObject2 = ((List)headers.get(localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localHttpsConnection.setRequestHeader((String)localObject1, (String)((Iterator)localObject2).next());
        }
      }
      localHttpsConnection.writeOutput(body);
      localObject1 = sslContext;
      if (localObject1 != null) {
        localHttpsConnection.setSSLContext((SSLContext)localObject1);
      }
      int i = connectionTimeout;
      if (i != 0) {
        localHttpsConnection.setReadTimeoutMillis(i);
      }
      localObject1 = new byte[0];
      localHttpsConnection.connect();
      i = localHttpsConnection.getResponseStatus();
      Object localObject2 = localHttpsConnection.getResponseHeaders();
      if (i == 200) {
        localObject1 = localHttpsConnection.readInput();
      }
      return new HttpsResponse(i, (byte[])localObject1, (Map)localObject2, new byte[0]);
    }
    throw new IllegalArgumentException("url cannot be null");
  }
  
  public HttpsRequest setHeaderField(String paramString1, String paramString2)
  {
    if (headers.containsKey(paramString1))
    {
      ((List)headers.get(paramString1)).add(paramString2);
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString2);
      headers.put(paramString1, localArrayList);
    }
    return this;
  }
  
  public HttpsRequest setReadTimeoutMillis(int paramInt)
  {
    connectionTimeout = paramInt;
    return this;
  }
  
  public HttpsRequest setSSLContext(SSLContext paramSSLContext)
  {
    if (paramSSLContext != null)
    {
      sslContext = paramSSLContext;
      return this;
    }
    throw new IllegalArgumentException("Context cannot be null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.https.HttpsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */