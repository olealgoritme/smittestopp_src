package com.microsoft.azure.proton.transport.proxy;

public enum Proxy$ProxyState
{
  static
  {
    PN_PROXY_CONNECTING = new ProxyState("PN_PROXY_CONNECTING", 1);
    PN_PROXY_CHALLENGE = new ProxyState("PN_PROXY_CHALLENGE", 2);
    PN_PROXY_CHALLENGE_RESPONDED = new ProxyState("PN_PROXY_CHALLENGE_RESPONDED", 3);
    PN_PROXY_CONNECTED = new ProxyState("PN_PROXY_CONNECTED", 4);
    ProxyState localProxyState = new ProxyState("PN_PROXY_FAILED", 5);
    PN_PROXY_FAILED = localProxyState;
    $VALUES = new ProxyState[] { PN_PROXY_NOT_STARTED, PN_PROXY_CONNECTING, PN_PROXY_CHALLENGE, PN_PROXY_CHALLENGE_RESPONDED, PN_PROXY_CONNECTED, localProxyState };
  }
  
  public Proxy$ProxyState() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.Proxy.ProxyState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */