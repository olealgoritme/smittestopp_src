package com.microsoft.azure.proton.transport.proxy;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface ProxyHandler
{
  public abstract String createProxyRequest(String paramString, Map<String, String> paramMap);
  
  public abstract ProxyHandler.ProxyResponseResult validateProxyResponse(ByteBuffer paramByteBuffer);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.ProxyHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */