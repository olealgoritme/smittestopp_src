package com.microsoft.azure.sdk.iot.device.auth;

import com.microsoft.azure.sdk.iot.deps.auth.IotHubSSLContext;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProvider;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderX509;
import com.microsoft.azure.sdk.iot.provisioning.security.exceptions.SecurityProviderException;
import java.io.IOException;
import javax.net.ssl.SSLContext;

public class IotHubX509HardwareAuthenticationProvider
  extends IotHubAuthenticationProvider
{
  public SecurityProviderX509 securityProviderX509;
  
  public IotHubX509HardwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, SecurityProvider paramSecurityProvider)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    if ((paramSecurityProvider instanceof SecurityProviderX509))
    {
      securityProviderX509 = ((SecurityProviderX509)paramSecurityProvider);
      return;
    }
    throw new IllegalArgumentException("The provided security provider must be of type SecurityProviderX509");
  }
  
  public SSLContext getSSLContext()
  {
    if (iotHubSSLContext == null) {
      try
      {
        IotHubSSLContext localIotHubSSLContext = new com/microsoft/azure/sdk/iot/deps/auth/IotHubSSLContext;
        localIotHubSSLContext.<init>(securityProviderX509.getSSLContext());
        iotHubSSLContext = localIotHubSSLContext;
      }
      catch (SecurityProviderException localSecurityProviderException)
      {
        throw new IOException(localSecurityProviderException);
      }
    }
    return iotHubSSLContext.getSSLContext();
  }
  
  public void setIotHubTrustedCert(String paramString)
  {
    throw new UnsupportedOperationException("Cannot change the trusted certificate when using security provider for authentication.");
  }
  
  public void setPathToIotHubTrustedCert(String paramString)
  {
    throw new UnsupportedOperationException("Cannot change the trusted certificate when using security provider for authentication.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.auth.IotHubX509HardwareAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */