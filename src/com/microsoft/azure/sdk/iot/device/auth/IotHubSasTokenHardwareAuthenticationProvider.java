package com.microsoft.azure.sdk.iot.device.auth;

import com.microsoft.azure.sdk.iot.deps.auth.IotHubSSLContext;
import com.microsoft.azure.sdk.iot.deps.util.Base64;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProvider;
import com.microsoft.azure.sdk.iot.provisioning.security.SecurityProviderTpm;
import com.microsoft.azure.sdk.iot.provisioning.security.exceptions.SecurityProviderException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.net.ssl.SSLContext;

public class IotHubSasTokenHardwareAuthenticationProvider
  extends IotHubSasTokenAuthenticationProvider
{
  public static final String SASTOKEN_FORMAT = "SharedAccessSignature sr=%s&sig=%s&se=%s";
  public static final String TOKEN_SCOPE_FORMAT = "%s/devices/%s";
  public SecurityProviderTpm securityProvider;
  
  public IotHubSasTokenHardwareAuthenticationProvider(String paramString1, String paramString2, String paramString3, String paramString4, SecurityProvider paramSecurityProvider)
  {
    super(paramString1, paramString2, paramString3, paramString4);
    try
    {
      if ((paramSecurityProvider instanceof SecurityProviderTpm))
      {
        securityProvider = ((SecurityProviderTpm)paramSecurityProvider);
        paramString2 = new com/microsoft/azure/sdk/iot/device/auth/IotHubSasToken;
        paramString2.<init>(paramString1, paramString3, null, generateSasTokenSignatureFromSecurityProvider(tokenValidSecs), paramString4, 0L);
        sasToken = paramString2;
        paramString1 = new com/microsoft/azure/sdk/iot/deps/auth/IotHubSSLContext;
        paramString1.<init>(paramSecurityProvider.getSSLContext());
        iotHubSSLContext = paramString1;
        sslContextNeedsUpdate = false;
        return;
      }
      paramString1 = new java/lang/IllegalArgumentException;
      paramString1.<init>("The provided security provided must be an instance of SecurityProviderTpm");
      throw paramString1;
    }
    catch (SecurityProviderException paramString1)
    {
      throw new IOException(paramString1);
    }
  }
  
  private String generateSasTokenSignatureFromSecurityProvider(long paramLong)
  {
    try
    {
      String str = URLEncoder.encode(String.format("%s/devices/%s", new Object[] { hostname, deviceId }), IotHubSasTokenAuthenticationProvider.ENCODING_FORMAT_NAME);
      if ((str != null) && (!str.isEmpty()))
      {
        localObject1 = Long.valueOf(System.currentTimeMillis() / 1000L + paramLong);
        Object localObject2 = securityProvider;
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append("\n");
        ((StringBuilder)localObject3).append(String.valueOf(localObject1));
        localObject2 = ((SecurityProviderTpm)localObject2).signWithIdentity(str.concat(((StringBuilder)localObject3).toString()).getBytes());
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          localObject2 = Base64.encodeBase64Local((byte[])localObject2);
          localObject3 = new java/lang/String;
          ((String)localObject3).<init>((byte[])localObject2);
          return String.format("SharedAccessSignature sr=%s&sig=%s&se=%s", new Object[] { str, URLEncoder.encode((String)localObject3, IotHubSasTokenAuthenticationProvider.ENCODING_FORMAT_NAME), localObject1 });
        }
        localObject1 = new java/io/IOException;
        ((IOException)localObject1).<init>("Security provider could not sign data successfully");
        throw ((Throwable)localObject1);
      }
      Object localObject1 = new java/io/IOException;
      ((IOException)localObject1).<init>("Could not construct token scope");
      throw ((Throwable)localObject1);
    }
    catch (SecurityProviderException localSecurityProviderException) {}catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    throw new IOException(localUnsupportedEncodingException);
  }
  
  public boolean canRefreshToken()
  {
    return true;
  }
  
  public String getRenewedSasToken(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((shouldRefreshToken(paramBoolean1)) || (paramBoolean2))
    {
      String str = generateSasTokenSignatureFromSecurityProvider(tokenValidSecs);
      sasToken = new IotHubSasToken(hostname, deviceId, null, str, moduleId, 0L);
    }
    return sasToken.toString();
  }
  
  public SSLContext getSSLContext()
  {
    return iotHubSSLContext.getSSLContext();
  }
  
  public boolean isRenewalNecessary()
  {
    return false;
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
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenHardwareAuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */