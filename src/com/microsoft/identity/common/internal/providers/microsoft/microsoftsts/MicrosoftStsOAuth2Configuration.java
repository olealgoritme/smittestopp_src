package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import android.net.Uri;
import android.net.Uri.Builder;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfigurationClient;
import e.a.a.a.a;
import java.net.URL;

public class MicrosoftStsOAuth2Configuration
  extends AzureActiveDirectoryOAuth2Configuration
{
  public static final String ENDPOINT_VERSION = "v2.0";
  public static final String FALLBACK_AUTHORIZE_ENDPOINT_SUFFIX = "/oAuth2/v2.0/authorize";
  public static final String FALLBACK_ENDPOINT_SUFFIX = "/oAuth2/v2.0";
  public static final String FALLBACK_TOKEN_ENDPOINT_SUFFIX = "/oAuth2/v2.0/token";
  public static final String TAG = "MicrosoftStsOAuth2Configuration";
  
  private URL getEndpointUrlFromAuthority(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":getEndpointUrlFromAuthority");
      Logger.error(((StringBuilder)localObject).toString(), "Unable to create URL from provided authority.", null);
      localObject = a.a(new StringBuilder(), TAG, ":getEndpointUrlFromAuthority");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(" Unable to create URL from provided authority. authority = ");
      localStringBuilder.append(paramString);
      Logger.errorPII((String)localObject, localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  private URL getEndpointUrlFromRootAndSuffix(URL paramURL, String paramString)
  {
    try
    {
      URL localURL = new URL(Uri.parse(paramURL.toString()).buildUpon().appendPath(paramString).build().toString());
      return localURL;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":getEndpointUrlFromRootAndSuffix");
      Logger.error(((StringBuilder)localObject).toString(), "Unable to create URL from provided root and suffix.", null);
      localObject = a.a(new StringBuilder(), TAG, ":getEndpointUrlFromRootAndSuffix");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(" Unable to create URL from provided root and suffix. root = ");
      localStringBuilder.append(paramURL.toString());
      localStringBuilder.append(" suffix = ");
      localStringBuilder.append(paramString);
      Logger.errorPII((String)localObject, localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  private OpenIdProviderConfiguration getOpenIdWellKnownConfigForAuthority()
  {
    URL localURL = getAuthorityUrl();
    return getOpenIdWellKnownConfig(localURL.getHost(), localURL.getPath());
  }
  
  public URL getAuthorizationEndpoint()
  {
    OpenIdProviderConfiguration localOpenIdProviderConfiguration = getOpenIdWellKnownConfigForAuthority();
    if (localOpenIdProviderConfiguration != null) {
      return getEndpointUrlFromAuthority(localOpenIdProviderConfiguration.getAuthorizationEndpoint());
    }
    return getEndpointUrlFromRootAndSuffix(getAuthorityUrl(), "/oAuth2/v2.0/authorize");
  }
  
  public OpenIdProviderConfiguration getOpenIdWellKnownConfig(String paramString1, String paramString2)
  {
    paramString1 = new OpenIdProviderConfigurationClient(paramString1, paramString2, "v2.0");
    try
    {
      paramString1 = paramString1.loadOpenIdProviderConfiguration();
    }
    catch (ServiceException paramString1)
    {
      Logger.error(a.a(new StringBuilder(), TAG, ":getOpenIdWellKnownConfig"), paramString1.getMessage(), paramString1);
      paramString1 = null;
    }
    return paramString1;
  }
  
  public URL getTokenEndpoint()
  {
    OpenIdProviderConfiguration localOpenIdProviderConfiguration = getOpenIdWellKnownConfigForAuthority();
    if ((localOpenIdProviderConfiguration != null) && (localOpenIdProviderConfiguration.getTokenEndpoint() != null)) {
      return getEndpointUrlFromAuthority(localOpenIdProviderConfiguration.getTokenEndpoint());
    }
    return getEndpointUrlFromRootAndSuffix(getAuthorityUrl(), "/oAuth2/v2.0/token");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */