package com.microsoft.azure.sdk.iot.deps.transport.http;

public enum HttpMethod
{
  static
  {
    DELETE = new HttpMethod("DELETE", 3);
    HttpMethod localHttpMethod = new HttpMethod("PATCH", 4);
    PATCH = localHttpMethod;
    $VALUES = new HttpMethod[] { GET, POST, PUT, DELETE, localHttpMethod };
  }
  
  public HttpMethod() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.http.HttpMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */