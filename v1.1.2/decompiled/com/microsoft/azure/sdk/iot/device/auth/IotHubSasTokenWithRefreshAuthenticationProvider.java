package com.microsoft.azure.sdk.iot.device.auth;

import java.net.URLEncoder;
import l.f.b;
import l.f.c;

public abstract class IotHubSasTokenWithRefreshAuthenticationProvider
  extends IotHubSasTokenAuthenticationProvider
{
  public static final b log = c.a(IotHubSasTokenWithRefreshAuthenticationProvider.class);
  
  public IotHubSasTokenWithRefreshAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
    sasToken = new IotHubSasToken(paramString1, paramString3, null, paramString5, paramString4, getExpiryTimeInSeconds());
  }
  
  public static String buildAudience(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null) && (!paramString1.isEmpty()) && (!paramString2.isEmpty()) && (!paramString3.isEmpty())) {
      return URLEncoder.encode(String.format("%s/devices/%s/modules/%s", new Object[] { paramString1, paramString2, paramString3 }), "UTF-8");
    }
    throw new IllegalArgumentException("No argument can be null or empty");
  }
  
  public String getRenewedSasToken(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((shouldRefreshToken(paramBoolean1)) || (paramBoolean2))
    {
      log.e("Renewing the internal sas token");
      refreshSasToken();
    }
    return sasToken.toString();
  }
  
  public boolean isRenewalNecessary()
  {
    return false;
  }
  
  public abstract void refreshSasToken();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenWithRefreshAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */