package com.microsoft.appcenter.http;

import java.net.URL;
import java.util.Map;

public abstract interface HttpClient$CallTemplate
{
  public abstract String buildRequestBody();
  
  public abstract void onBeforeCalling(URL paramURL, Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.HttpClient.CallTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */