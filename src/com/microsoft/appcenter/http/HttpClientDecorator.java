package com.microsoft.appcenter.http;

import java.io.Closeable;

public abstract class HttpClientDecorator
  implements HttpClient
{
  public final HttpClient mDecoratedApi;
  
  public HttpClientDecorator(HttpClient paramHttpClient)
  {
    mDecoratedApi = paramHttpClient;
  }
  
  public void close()
  {
    mDecoratedApi.close();
  }
  
  public HttpClient getDecoratedApi()
  {
    return mDecoratedApi;
  }
  
  public void reopen()
  {
    mDecoratedApi.reopen();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.HttpClientDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */