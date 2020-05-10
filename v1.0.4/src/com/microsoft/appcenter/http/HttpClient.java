package com.microsoft.appcenter.http;

import java.io.Closeable;
import java.util.Map;

public abstract interface HttpClient
  extends Closeable
{
  public abstract ServiceCall callAsync(String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback);
  
  public abstract void reopen();
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.HttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */