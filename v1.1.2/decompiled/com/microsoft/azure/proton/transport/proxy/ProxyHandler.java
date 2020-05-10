package com.microsoft.azure.proton.transport.proxy;

import java.nio.ByteBuffer;
import java.util.Map;

public abstract interface ProxyHandler
{
  public abstract String createProxyRequest(String paramString, Map<String, String> paramMap);
  
  public abstract ProxyResponseResult validateProxyResponse(ByteBuffer paramByteBuffer);
  
  public static class ProxyResponseResult
  {
    public String error;
    public Boolean isSuccess;
    
    public ProxyResponseResult(Boolean paramBoolean, String paramString)
    {
      isSuccess = paramBoolean;
      error = paramString;
    }
    
    public String getError()
    {
      return error;
    }
    
    public Boolean getIsSuccess()
    {
      return isSuccess;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.proton.transport.proxy.ProxyHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */