package com.microsoft.azure.sdk.iot.device;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public class ProxySettings
{
  public char[] password;
  public Proxy proxy;
  public String username;
  
  public ProxySettings(Proxy paramProxy)
  {
    this(paramProxy, null, null);
  }
  
  public ProxySettings(Proxy paramProxy, String paramString, char[] paramArrayOfChar)
  {
    if (paramProxy != null)
    {
      if (paramProxy.type() != Proxy.Type.DIRECT)
      {
        proxy = paramProxy;
        if ((paramString != null) && (paramString.isEmpty())) {
          throw new IllegalArgumentException("Username cannot be an empty string");
        }
        if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 0)) {
          throw new IllegalArgumentException("Password cannot be an empty string");
        }
        username = paramString;
        password = paramArrayOfChar;
        return;
      }
      throw new IllegalArgumentException("Proxy settings cannot be configured to be DIRECT");
    }
    throw new IllegalArgumentException("Proxy cannot be null");
  }
  
  public String getHostname()
  {
    if ((proxy.address() instanceof InetSocketAddress)) {
      return ((InetSocketAddress)proxy.address()).getHostName();
    }
    throw new UnsupportedOperationException("Could not get port from saved proxy");
  }
  
  public char[] getPassword()
  {
    return password;
  }
  
  public int getPort()
  {
    if ((proxy.address() instanceof InetSocketAddress)) {
      return ((InetSocketAddress)proxy.address()).getPort();
    }
    throw new UnsupportedOperationException("Could not get port from saved proxy");
  }
  
  public Proxy getProxy()
  {
    return proxy;
  }
  
  public String getUsername()
  {
    return username;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.ProxySettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */