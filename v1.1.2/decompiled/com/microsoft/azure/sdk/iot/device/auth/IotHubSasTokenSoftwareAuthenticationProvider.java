package com.microsoft.azure.sdk.iot.device.auth;

import javax.net.ssl.SSLContext;

public class IotHubSasTokenSoftwareAuthenticationProvider
  extends IotHubSasTokenAuthenticationProvider
{
  public String deviceKey;
  
  public IotHubSasTokenSoftwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    deviceKey = paramString5;
    sslContextNeedsUpdate = true;
    sasToken = new IotHubSasToken(paramString1, paramString3, paramString5, paramString6, paramString4, getExpiryTimeInSeconds());
  }
  
  public IotHubSasTokenSoftwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
    deviceKey = paramString5;
    sslContextNeedsUpdate = true;
    sasToken = new IotHubSasToken(paramString1, paramString3, paramString5, paramString6, paramString4, getExpiryTimeInSeconds());
  }
  
  public IotHubSasTokenSoftwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, SSLContext paramSSLContext)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramSSLContext);
    deviceKey = paramString5;
    sasToken = new IotHubSasToken(paramString1, paramString3, paramString5, paramString6, paramString4, getExpiryTimeInSeconds());
  }
  
  public boolean canRefreshToken()
  {
    boolean bool;
    if (deviceKey != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String getRenewedSasToken(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((shouldRefreshToken(paramBoolean1)) || (paramBoolean2))
    {
      String str = deviceKey;
      if (str != null) {
        sasToken = new IotHubSasToken(hostname, deviceId, str, null, moduleId, getExpiryTimeInSeconds());
      }
    }
    return sasToken.toString();
  }
  
  public boolean isRenewalNecessary()
  {
    boolean bool;
    if ((super.isRenewalNecessary()) && (deviceKey == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setTokenValidSecs(long paramLong)
  {
    super.setTokenValidSecs(paramLong);
    String str = deviceKey;
    if (str != null) {
      sasToken = new IotHubSasToken(hostname, deviceId, str, null, moduleId, getExpiryTimeInSeconds());
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenSoftwareAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */