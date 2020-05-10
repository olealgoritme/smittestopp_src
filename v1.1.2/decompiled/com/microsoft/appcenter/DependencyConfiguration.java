package com.microsoft.appcenter;

import com.microsoft.appcenter.http.HttpClient;

public final class DependencyConfiguration
{
  public static HttpClient sHttpClient;
  
  public static HttpClient getHttpClient()
  {
    return sHttpClient;
  }
  
  public static void setHttpClient(HttpClient paramHttpClient)
  {
    sHttpClient = paramHttpClient;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.DependencyConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */