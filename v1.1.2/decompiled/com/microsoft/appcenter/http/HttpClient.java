package com.microsoft.appcenter.http;

import java.io.Closeable;
import java.net.URL;
import java.util.Map;

public abstract interface HttpClient
  extends Closeable
{
  public abstract ServiceCall callAsync(String paramString1, String paramString2, Map<String, String> paramMap, CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback);
  
  public abstract void reopen();
  
  public static abstract interface CallTemplate
  {
    public abstract String buildRequestBody();
    
    public abstract void onBeforeCalling(URL paramURL, Map<String, String> paramMap);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.HttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */