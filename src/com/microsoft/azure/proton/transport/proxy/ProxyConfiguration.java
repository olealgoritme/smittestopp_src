package com.microsoft.azure.proton.transport.proxy;

import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.Arrays;
import java.util.Objects;
import k.f.b;
import k.f.c;

public class ProxyConfiguration
  implements AutoCloseable
{
  public static final b LOGGER = c.a(ProxyConfiguration.class);
  public static final ProxyConfiguration SYSTEM_DEFAULTS = new ProxyConfiguration();
  public final ProxyAuthenticationType authentication;
  public final PasswordAuthentication credentials;
  public final Proxy proxyAddress;
  
  public ProxyConfiguration()
  {
    authentication = null;
    credentials = null;
    proxyAddress = null;
  }
  
  public ProxyConfiguration(ProxyAuthenticationType paramProxyAuthenticationType, Proxy paramProxy, String paramString1, String paramString2)
  {
    Objects.requireNonNull(paramProxyAuthenticationType);
    proxyAddress = paramProxy;
    authentication = paramProxyAuthenticationType;
    if ((paramString1 != null) && (paramString2 != null))
    {
      credentials = new PasswordAuthentication(paramString1, paramString2.toCharArray());
    }
    else
    {
      if (LOGGER.a()) {
        LOGGER.c("username or password is null. Using system-wide authentication.");
      }
      credentials = null;
    }
  }
  
  public ProxyAuthenticationType authentication()
  {
    return authentication;
  }
  
  public void close()
  {
    PasswordAuthentication localPasswordAuthentication = credentials;
    if (localPasswordAuthentication != null) {
      Arrays.fill(localPasswordAuthentication.getPassword(), '\000');
    }
  }
  
  public PasswordAuthentication credentials()
  {
    return credentials;
  }
  
  public boolean hasUserDefinedCredentials()
  {
    boolean bool;
    if (credentials != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isProxyAddressConfigured()
  {
    Proxy localProxy = proxyAddress;
    boolean bool;
    if ((localProxy != null) && (localProxy.address() != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Proxy proxyAddress()
  {
    return proxyAddress;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.ProxyConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */