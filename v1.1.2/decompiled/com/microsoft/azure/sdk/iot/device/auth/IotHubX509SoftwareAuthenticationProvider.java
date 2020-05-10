package com.microsoft.azure.sdk.iot.device.auth;

import com.microsoft.azure.sdk.iot.deps.auth.IotHubSSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;

public class IotHubX509SoftwareAuthenticationProvider
  extends IotHubAuthenticationProvider
{
  public IotHubX509 iotHubX509;
  
  public IotHubX509SoftwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, String paramString6, boolean paramBoolean2)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    iotHubX509 = new IotHubX509(paramString5, paramBoolean1, paramString6, paramBoolean2);
    sslContextNeedsUpdate = false;
  }
  
  public IotHubX509SoftwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, SSLContext paramSSLContext)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramSSLContext);
    iotHubX509 = null;
  }
  
  private IotHubSSLContext generateSSLContext()
  {
    if (iotHubTrustedCert != null) {
      return new IotHubSSLContext(iotHubX509.getPublicKeyCertificate(), iotHubX509.getPrivateKey(), iotHubTrustedCert, false);
    }
    if (pathToIotHubTrustedCert != null) {
      return new IotHubSSLContext(iotHubX509.getPublicKeyCertificate(), iotHubX509.getPrivateKey(), pathToIotHubTrustedCert, true);
    }
    return new IotHubSSLContext(iotHubX509.getPublicKeyCertificate(), iotHubX509.getPrivateKey());
  }
  
  public SSLContext getSSLContext()
  {
    try
    {
      if ((iotHubSSLContext == null) || (sslContextNeedsUpdate))
      {
        iotHubSSLContext = generateSSLContext();
        sslContextNeedsUpdate = false;
      }
      SSLContext localSSLContext = iotHubSSLContext.getSSLContext();
      return localSSLContext;
    }
    catch (KeyStoreException localKeyStoreException) {}catch (KeyManagementException localKeyManagementException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (UnrecoverableKeyException localUnrecoverableKeyException) {}catch (CertificateException localCertificateException) {}
    throw new IOException(localCertificateException);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.IotHubX509SoftwareAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */