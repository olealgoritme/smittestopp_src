package com.microsoft.azure.proton.transport.proxy.impl;

import com.microsoft.azure.proton.transport.proxy.Proxy;
import com.microsoft.azure.proton.transport.proxy.Proxy.ProxyState;
import com.microsoft.azure.proton.transport.proxy.ProxyConfiguration;
import com.microsoft.azure.proton.transport.proxy.ProxyHandler;
import java.nio.ByteBuffer;
import java.util.Map;
import k.a.b.a.d.c0;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.b0;
import k.a.b.a.d.g0.d0;
import k.a.b.a.d.g0.f0;
import k.a.b.a.d.g0.l0;
import k.f.b;
import k.f.c;

public class ProxyImpl
  implements Proxy, d0
{
  public static final b LOGGER = c.a(ProxyImpl.class);
  public static final String PROXY_CONNECT_FAILED = "Proxy connect request failed with error: ";
  public static final String PROXY_CONNECT_USER_ERROR = "User configuration error. Using non-matching proxy authentication.";
  public static final int PROXY_HANDSHAKE_BUFFER_SIZE = 8192;
  public boolean headClosed = false;
  public Map<String, String> headers = null;
  public String host = "";
  public final ByteBuffer inputBuffer = ByteBuffer.allocate(8192);
  public boolean isProxyConfigured = false;
  public final ByteBuffer outputBuffer = ByteBuffer.allocate(8192);
  public final ProxyConfiguration proxyConfiguration;
  public ProxyHandler proxyHandler;
  public Proxy.ProxyState proxyState = Proxy.ProxyState.PN_PROXY_NOT_STARTED;
  public boolean tailClosed = false;
  public a0 underlyingTransport;
  
  public ProxyImpl()
  {
    this(null);
  }
  
  public ProxyImpl(ProxyConfiguration paramProxyConfiguration)
  {
    proxyConfiguration = paramProxyConfiguration;
  }
  
  public void configure(String paramString, Map<String, String> paramMap, ProxyHandler paramProxyHandler, c0 paramc0)
  {
    host = paramString;
    headers = paramMap;
    proxyHandler = paramProxyHandler;
    underlyingTransport = ((a0)paramc0);
    isProxyConfigured = true;
  }
  
  public ByteBuffer getInputBuffer()
  {
    return inputBuffer;
  }
  
  public boolean getIsHandshakeInProgress()
  {
    boolean bool;
    if ((isProxyConfigured) && (proxyState != Proxy.ProxyState.PN_PROXY_CONNECTED)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Boolean getIsProxyConfigured()
  {
    return Boolean.valueOf(isProxyConfigured);
  }
  
  public ByteBuffer getOutputBuffer()
  {
    return outputBuffer;
  }
  
  public ProxyHandler getProxyHandler()
  {
    return proxyHandler;
  }
  
  public Map<String, String> getProxyRequestHeaders()
  {
    return headers;
  }
  
  public Proxy.ProxyState getProxyState()
  {
    return proxyState;
  }
  
  public c0 getUnderlyingTransport()
  {
    return underlyingTransport;
  }
  
  public l0 wrap(b0 paramb0, f0 paramf0)
  {
    return new ProxyImpl.ProxyTransportWrapper(this, paramb0, paramf0);
  }
  
  public void writeProxyRequest()
  {
    outputBuffer.clear();
    String str = proxyHandler.createProxyRequest(host, headers);
    if (LOGGER.a()) {
      LOGGER.a("Writing proxy request:{}{}", System.lineSeparator(), str);
    }
    outputBuffer.put(str.getBytes());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.impl.ProxyImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */