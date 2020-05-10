package com.microsoft.azure.proton.transport.proxy;

public enum ProxyAuthenticationType
{
  static
  {
    BASIC = new ProxyAuthenticationType("BASIC", 1);
    ProxyAuthenticationType localProxyAuthenticationType = new ProxyAuthenticationType("DIGEST", 2);
    DIGEST = localProxyAuthenticationType;
    $VALUES = new ProxyAuthenticationType[] { NONE, BASIC, localProxyAuthenticationType };
  }
  
  public ProxyAuthenticationType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.ProxyAuthenticationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */