package com.microsoft.appcenter.http;

public abstract interface ServiceCallback
{
  public abstract void onCallFailed(Exception paramException);
  
  public abstract void onCallSucceeded(HttpResponse paramHttpResponse);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.ServiceCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */