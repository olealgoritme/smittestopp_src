package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.ProxySettings;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

public class HttpProxySocketFactory
  extends SSLSocketFactory
{
  public final SSLSocketFactory delegate;
  public final ProxySettings proxySettings;
  
  public HttpProxySocketFactory(SSLSocketFactory paramSSLSocketFactory, ProxySettings paramProxySettings)
  {
    delegate = paramSSLSocketFactory;
    proxySettings = paramProxySettings;
  }
  
  public Socket createSocket()
  {
    Socket localSocket = new Socket(proxySettings.getHostname(), proxySettings.getPort());
    return new ProxiedSSLSocket(delegate, localSocket, proxySettings.getUsername(), proxySettings.getPassword());
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return delegate.createSocket(paramString, paramInt);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return delegate.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return delegate.createSocket(paramInetAddress, paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return delegate.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
  }
  
  public Socket createSocket(Socket paramSocket, InputStream paramInputStream, boolean paramBoolean)
  {
    return delegate.createSocket(paramSocket, paramInputStream, paramBoolean);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return delegate.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
  
  public String[] getDefaultCipherSuites()
  {
    return delegate.getDefaultCipherSuites();
  }
  
  public String[] getSupportedCipherSuites()
  {
    return delegate.getSupportedCipherSuites();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.HttpProxySocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */