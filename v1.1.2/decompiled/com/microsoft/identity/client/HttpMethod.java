package com.microsoft.identity.client;

public enum HttpMethod
{
  static
  {
    DELETE = new HttpMethod("DELETE", 4);
    CONNECT = new HttpMethod("CONNECT", 5);
    OPTIONS = new HttpMethod("OPTIONS", 6);
    TRACE = new HttpMethod("TRACE", 7);
    HttpMethod localHttpMethod = new HttpMethod("PATCH", 8);
    PATCH = localHttpMethod;
    $VALUES = new HttpMethod[] { GET, HEAD, POST, PUT, DELETE, CONNECT, OPTIONS, TRACE, localHttpMethod };
  }
  
  public HttpMethod() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.HttpMethod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */