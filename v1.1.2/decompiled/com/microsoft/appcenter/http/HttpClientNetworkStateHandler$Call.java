package com.microsoft.appcenter.http;

import java.util.Map;

public class HttpClientNetworkStateHandler$Call
  extends HttpClientCallDecorator
{
  public HttpClientNetworkStateHandler$Call(HttpClient paramHttpClient, String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback)
  {
    super(paramString1, paramString2, paramMap, paramCallTemplate, paramServiceCallback, localServiceCallback);
  }
  
  public void cancel()
  {
    HttpClientNetworkStateHandler.access$000(this$0, this);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.HttpClientNetworkStateHandler.Call
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */