package com.microsoft.azure.proton.transport.proxy.impl;

import b;
import com.microsoft.azure.proton.transport.proxy.ProxyChallengeProcessor;
import java.net.PasswordAuthentication;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BasicProxyChallengeProcessorImpl
  implements ProxyChallengeProcessor
{
  public final Map<String, String> headers;
  public String host;
  public final ProxyAuthenticator proxyAuthenticator;
  
  public BasicProxyChallengeProcessorImpl(String paramString, ProxyAuthenticator paramProxyAuthenticator)
  {
    Objects.requireNonNull(paramString);
    Objects.requireNonNull(paramProxyAuthenticator);
    host = paramString;
    headers = new HashMap();
    proxyAuthenticator = paramProxyAuthenticator;
  }
  
  public Map<String, String> getHeader()
  {
    Object localObject = proxyAuthenticator.getPasswordAuthentication(Constants.BASIC_LOWERCASE, host);
    if (!ProxyAuthenticator.isPasswordAuthenticationHasValues((PasswordAuthentication)localObject)) {
      return null;
    }
    localObject = b.a(":", new CharSequence[] { ((PasswordAuthentication)localObject).getUserName(), new String(((PasswordAuthentication)localObject).getPassword()) });
    headers.put("Proxy-Authorization", b.a(" ", new CharSequence[] { "Basic", Base64.getEncoder().encodeToString(((String)localObject).getBytes(StandardCharsets.UTF_8)) }));
    return headers;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.impl.BasicProxyChallengeProcessorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */