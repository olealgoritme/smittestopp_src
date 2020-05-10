package com.microsoft.azure.sdk.iot.device.auth;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLContext;

public abstract class IotHubSasTokenAuthenticationProvider
  extends IotHubAuthenticationProvider
{
  public static final String ENCODING_FORMAT_NAME = StandardCharsets.UTF_8.displayName();
  public static final long MILLISECONDS_PER_SECOND = 1000L;
  public static final long MINIMUM_EXPIRATION_TIME_OFFSET = 1L;
  public IotHubSasToken sasToken;
  public int timeBufferPercentage = 85;
  public long tokenValidSecs = 3600L;
  
  public IotHubSasTokenAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2, paramString3, paramString4);
  }
  
  public IotHubSasTokenAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    setTokenValidSecs(paramLong);
    if ((paramInt >= 1) && (paramInt <= 100))
    {
      timeBufferPercentage = paramInt;
      return;
    }
    throw new IllegalArgumentException("Time buffer percentage must be a percentage between 1 and 100");
  }
  
  public IotHubSasTokenAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, SSLContext paramSSLContext)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramSSLContext);
  }
  
  public abstract boolean canRefreshToken();
  
  public long getExpiryTimeInSeconds()
  {
    return System.currentTimeMillis() / 1000L + tokenValidSecs + 1L;
  }
  
  public int getMillisecondsBeforeProactiveRenewal()
  {
    return (int)tokenValidSecs * timeBufferPercentage;
  }
  
  public abstract String getRenewedSasToken(boolean paramBoolean1, boolean paramBoolean2);
  
  public long getTokenValidSecs()
  {
    return tokenValidSecs;
  }
  
  public boolean isRenewalNecessary()
  {
    IotHubSasToken localIotHubSasToken = sasToken;
    boolean bool;
    if ((localIotHubSasToken != null) && (localIotHubSasToken.isExpired())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setTokenValidSecs(long paramLong)
  {
    if (paramLong >= 1L)
    {
      tokenValidSecs = paramLong;
      return;
    }
    throw new IllegalArgumentException("tokens must live for more than 1 second");
  }
  
  public boolean shouldRefreshToken(boolean paramBoolean)
  {
    if (sasToken.isExpired()) {
      return true;
    }
    if (paramBoolean)
    {
      long l1 = IotHubSasToken.getExpiryTimeFromToken(sasToken.toString()).longValue();
      long l2 = tokenValidSecs;
      if (getMillisecondsBeforeProactiveRenewal() / 100 + (l1 - l2) < System.currentTimeMillis() / 1000L) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */