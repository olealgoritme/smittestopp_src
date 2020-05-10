package com.microsoft.azure.proton.transport.proxy.impl;

import com.microsoft.azure.proton.transport.proxy.ProxyConfiguration;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Objects;

public class ProxyAuthenticator
{
  public static final String PROMPT = "Event Hubs client web socket proxy support";
  public final ProxyConfiguration configuration;
  
  public ProxyAuthenticator()
  {
    this(ProxyConfiguration.SYSTEM_DEFAULTS);
  }
  
  public ProxyAuthenticator(ProxyConfiguration paramProxyConfiguration)
  {
    Objects.requireNonNull(paramProxyConfiguration);
    configuration = paramProxyConfiguration;
  }
  
  public static boolean isPasswordAuthenticationHasValues(PasswordAuthentication paramPasswordAuthentication)
  {
    boolean bool1 = false;
    if (paramPasswordAuthentication == null) {
      return false;
    }
    String str = paramPasswordAuthentication.getUserName();
    paramPasswordAuthentication = paramPasswordAuthentication.getPassword();
    boolean bool2 = bool1;
    if (!StringUtils.isNullOrEmpty(str))
    {
      bool2 = bool1;
      if (paramPasswordAuthentication != null)
      {
        bool2 = bool1;
        if (paramPasswordAuthentication.length > 0) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static boolean isProxyAddressLegal(List<Proxy> paramList)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramList != null)
    {
      bool2 = bool1;
      if (!paramList.isEmpty())
      {
        bool2 = bool1;
        if (((Proxy)paramList.get(0)).address() != null)
        {
          bool2 = bool1;
          if ((((Proxy)paramList.get(0)).address() instanceof InetSocketAddress)) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  public PasswordAuthentication getPasswordAuthentication(String paramString1, String paramString2)
  {
    if (configuration.hasUserDefinedCredentials()) {
      return configuration.credentials();
    }
    if (configuration.isProxyAddressConfigured())
    {
      paramString2 = (InetSocketAddress)configuration.proxyAddress().address();
      return Authenticator.requestPasswordAuthentication(paramString2.getHostName(), paramString2.getAddress(), 0, null, "Event Hubs client web socket proxy support", paramString1, null, Authenticator.RequestorType.PROXY);
    }
    Object localObject1 = ProxySelector.getDefault();
    boolean bool = StringUtils.isNullOrEmpty(paramString2);
    Object localObject2 = null;
    if (!bool) {
      paramString2 = ((ProxySelector)localObject1).select(URI.create(paramString2));
    } else {
      paramString2 = null;
    }
    if (isProxyAddressLegal(paramString2))
    {
      localObject2 = ((InetSocketAddress)((Proxy)paramString2.get(0)).address()).getAddress();
      localObject1 = ((Proxy)paramString2.get(0)).type();
      paramString2 = (String)localObject2;
      localObject2 = localObject1;
    }
    else
    {
      paramString2 = null;
    }
    if (localObject2 == null) {
      localObject2 = "";
    } else {
      localObject2 = ((Proxy.Type)localObject2).name();
    }
    return Authenticator.requestPasswordAuthentication("", paramString2, 0, (String)localObject2, "Event Hubs client web socket proxy support", paramString1, null, Authenticator.RequestorType.PROXY);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.impl.ProxyAuthenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */