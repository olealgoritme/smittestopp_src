package com.microsoft.azure.proton.transport.proxy;

public class ProxyHandler$ProxyResponseResult
{
  public String error;
  public Boolean isSuccess;
  
  public ProxyHandler$ProxyResponseResult(Boolean paramBoolean, String paramString)
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

/* Location:
 * Qualified Name:     com.microsoft.azure.proton.transport.proxy.ProxyHandler.ProxyResponseResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */