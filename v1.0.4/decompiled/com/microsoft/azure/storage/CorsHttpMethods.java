package com.microsoft.azure.storage;

public enum CorsHttpMethods
{
  static
  {
    DELETE = new CorsHttpMethods("DELETE", 4);
    TRACE = new CorsHttpMethods("TRACE", 5);
    OPTIONS = new CorsHttpMethods("OPTIONS", 6);
    CONNECT = new CorsHttpMethods("CONNECT", 7);
    CorsHttpMethods localCorsHttpMethods = new CorsHttpMethods("MERGE", 8);
    MERGE = localCorsHttpMethods;
    $VALUES = new CorsHttpMethods[] { GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, CONNECT, localCorsHttpMethods };
  }
  
  public CorsHttpMethods() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CorsHttpMethods
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */