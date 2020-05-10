package com.microsoft.appcenter.http;

import java.util.Map;

public abstract class HttpClientCallDecorator
  implements Runnable, ServiceCall, ServiceCallback
{
  public final HttpClient.CallTemplate mCallTemplate;
  public final HttpClient mDecoratedApi;
  public final Map<String, String> mHeaders;
  public final String mMethod;
  public ServiceCall mServiceCall;
  public final ServiceCallback mServiceCallback;
  public final String mUrl;
  
  public HttpClientCallDecorator(HttpClient paramHttpClient, String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback)
  {
    mDecoratedApi = paramHttpClient;
    mUrl = paramString1;
    mMethod = paramString2;
    mHeaders = paramMap;
    mCallTemplate = paramCallTemplate;
    mServiceCallback = paramServiceCallback;
  }
  
  public void cancel()
  {
    try
    {
      mServiceCall.cancel();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onCallFailed(Exception paramException)
  {
    mServiceCallback.onCallFailed(paramException);
  }
  
  public void onCallSucceeded(HttpResponse paramHttpResponse)
  {
    mServiceCallback.onCallSucceeded(paramHttpResponse);
  }
  
  public void run()
  {
    try
    {
      mServiceCall = mDecoratedApi.callAsync(mUrl, mMethod, mHeaders, mCallTemplate, this);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.HttpClientCallDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */