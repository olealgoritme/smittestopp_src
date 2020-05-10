package com.microsoft.azure.sdk.iot.device.auth;

import com.microsoft.azure.sdk.iot.deps.auth.IotHubSSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;

public abstract class IotHubAuthenticationProvider
{
  public String deviceId;
  public String gatewayHostname;
  public String hostname;
  public IotHubSSLContext iotHubSSLContext;
  public String iotHubTrustedCert;
  public String moduleId;
  public String pathToIotHubTrustedCert;
  public boolean sslContextNeedsUpdate;
  
  public IotHubAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramString3 != null) && (!paramString3.isEmpty()))
      {
        hostname = paramString1;
        gatewayHostname = paramString2;
        deviceId = paramString3;
        moduleId = paramString4;
        return;
      }
      throw new IllegalArgumentException("deviceId cannot be null");
    }
    throw new IllegalArgumentException("hostname cannot be null");
  }
  
  public IotHubAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, SSLContext paramSSLContext)
  {
    this(paramString1, paramString2, paramString3, paramString4);
    sslContextNeedsUpdate = false;
    iotHubSSLContext = new IotHubSSLContext(paramSSLContext);
  }
  
  private IotHubSSLContext generateSSLContext()
  {
    String str = iotHubTrustedCert;
    if (str != null) {
      return new IotHubSSLContext(str, false);
    }
    str = pathToIotHubTrustedCert;
    if (str != null) {
      return new IotHubSSLContext(str, true);
    }
    return new IotHubSSLContext();
  }
  
  public String getDeviceId()
  {
    return deviceId;
  }
  
  public String getGatewayHostname()
  {
    return gatewayHostname;
  }
  
  public String getHostname()
  {
    return hostname;
  }
  
  public String getIotHubTrustedCert()
  {
    return iotHubTrustedCert;
  }
  
  public String getModuleId()
  {
    return moduleId;
  }
  
  public String getPathToIotHubTrustedCert()
  {
    return pathToIotHubTrustedCert;
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
    catch (KeyStoreException localKeyStoreException) {}catch (KeyManagementException localKeyManagementException) {}catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}catch (CertificateException localCertificateException) {}
    throw new IOException(localCertificateException);
  }
  
  public void setIotHubTrustedCert(String paramString)
  {
    String str = iotHubTrustedCert;
    if ((str == null) || (!str.equals(paramString))) {
      sslContextNeedsUpdate = true;
    }
    iotHubTrustedCert = paramString;
  }
  
  public void setPathToIotHubTrustedCert(String paramString)
  {
    String str = pathToIotHubTrustedCert;
    if ((str == null) || (!str.equals(paramString))) {
      sslContextNeedsUpdate = true;
    }
    pathToIotHubTrustedCert = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */