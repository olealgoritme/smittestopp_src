package com.microsoft.azure.sdk.iot.deps.transport.http;

public abstract interface HttpMessage
{
  public abstract byte[] getBody();
  
  public abstract String getContentType();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.http.HttpMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */