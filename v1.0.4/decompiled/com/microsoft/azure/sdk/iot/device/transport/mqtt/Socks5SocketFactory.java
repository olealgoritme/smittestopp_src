package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;

public class Socks5SocketFactory
  extends SocketFactory
{
  public final InetAddress mProxyHost;
  public final int mProxyPort;
  
  public Socks5SocketFactory(String paramString, int paramInt)
  {
    mProxyHost = InetAddress.getByName(paramString);
    mProxyPort = paramInt;
  }
  
  public Socket createSocket()
  {
    return new Socks5SocketFactory.Socks5Socket(this, null);
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return createSocket(paramString, paramInt, null, 0);
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    Socket localSocket = createSocket();
    if (paramInetAddress != null) {
      localSocket.bind(new InetSocketAddress(paramInetAddress, paramInt2));
    }
    localSocket.connect(new InetSocketAddress(paramString, paramInt1));
    return localSocket;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return createSocket(paramInetAddress.getHostName(), paramInt, null, 0);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return createSocket(paramInetAddress1.getHostName(), paramInt1, paramInetAddress2, paramInt2);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.Socks5SocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */