package com.microsoft.identity.common.adal.internal.net;

import java.net.HttpURLConnection;
import java.net.URL;

public final class HttpUrlConnectionFactory
{
  public static HttpURLConnection sMockedConnection;
  public static URL sMockedConnectionOpenUrl;
  
  public static HttpURLConnection createHttpUrlConnection(URL paramURL)
  {
    HttpURLConnection localHttpURLConnection = sMockedConnection;
    if (localHttpURLConnection != null)
    {
      sMockedConnectionOpenUrl = paramURL;
      return localHttpURLConnection;
    }
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public static URL getMockedConnectionOpenUrl()
  {
    return sMockedConnectionOpenUrl;
  }
  
  public static void setMockedHttpUrlConnection(HttpURLConnection paramHttpURLConnection)
  {
    sMockedConnection = paramHttpURLConnection;
    if (paramHttpURLConnection == null) {
      sMockedConnectionOpenUrl = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.net.HttpUrlConnectionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */