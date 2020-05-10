package com.microsoft.azure.sdk.iot.device.hsm;

import com.microsoft.azure.sdk.iot.device.auth.IotHubAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasToken;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenWithRefreshAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.auth.SignatureProvider;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public class IotHubSasTokenHsmAuthenticationProvider
  extends IotHubSasTokenWithRefreshAuthenticationProvider
{
  public String generationId;
  public SignatureProvider signatureProvider;
  
  public IotHubSasTokenHsmAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, SignatureProvider paramSignatureProvider, int paramInt1, int paramInt2)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString6, paramInt1, paramInt2);
    signatureProvider = paramSignatureProvider;
    generationId = paramString5;
  }
  
  public static IotHubSasTokenHsmAuthenticationProvider create(SignatureProvider paramSignatureProvider, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    if (paramSignatureProvider != null) {
      return new IotHubSasTokenHsmAuthenticationProvider(paramString3, paramString4, paramString1, paramString2, paramString5, createNewSasToken(paramString3, paramString4, paramString1, paramString2, paramString5, paramSignatureProvider, paramInt1).getSasToken(), paramSignatureProvider, paramInt1, paramInt2);
    }
    throw new IllegalArgumentException("signatureProvider cannot be null");
  }
  
  public static IotHubSasToken createNewSasToken(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, SignatureProvider paramSignatureProvider, long paramLong)
  {
    try
    {
      String str = IotHubSasTokenWithRefreshAuthenticationProvider.buildAudience(paramString1, paramString3, paramString4);
      paramLong = System.currentTimeMillis() / 1000L + paramLong;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuilder.append(paramLong);
      paramString5 = paramSignatureProvider.sign(paramString4, localStringBuilder.toString(), paramString5);
      if ((paramString2 == null) || (paramString2.isEmpty())) {
        paramString2 = paramString1;
      }
      paramString1 = new IotHubSasToken(paramString2, paramString3, null, IotHubSasToken.buildSharedAccessToken(str, paramString5, paramLong), paramString4, paramLong);
      return paramString1;
    }
    catch (HsmException paramString1) {}catch (URISyntaxException paramString1) {}catch (UnsupportedEncodingException paramString1) {}
    throw new IOException(paramString1);
  }
  
  public boolean canRefreshToken()
  {
    return true;
  }
  
  public void refreshSasToken()
  {
    sasToken = createNewSasToken(hostname, gatewayHostname, deviceId, moduleId, generationId, signatureProvider, tokenValidSecs);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.hsm.IotHubSasTokenHsmAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */