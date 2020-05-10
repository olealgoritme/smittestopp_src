package com.microsoft.identity.common.internal.authorities;

import android.net.Uri;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import java.net.MalformedURLException;
import java.net.URL;

public class AzureActiveDirectoryB2CAuthority
  extends Authority
{
  public static final String TAG = "com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryB2CAuthority";
  
  public AzureActiveDirectoryB2CAuthority(String paramString)
  {
    mAuthorityTypeString = "B2C";
    mAuthorityUrl = paramString;
  }
  
  public MicrosoftStsOAuth2Configuration createOAuth2Configuration()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":createOAuth2Configuration");
    Logger.verbose(((StringBuilder)localObject).toString(), "Creating OAuth2Configuration");
    localObject = new MicrosoftStsOAuth2Configuration();
    ((AzureActiveDirectoryOAuth2Configuration)localObject).setMultipleCloudsSupported(false);
    ((AzureActiveDirectoryOAuth2Configuration)localObject).setAuthorityUrl(getAuthorityURL());
    return (MicrosoftStsOAuth2Configuration)localObject;
  }
  
  public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    return new MicrosoftStsOAuth2Strategy(createOAuth2Configuration(), paramOAuth2StrategyParameters);
  }
  
  public URL getAuthorityURL()
  {
    try
    {
      URL localURL = new URL(getAuthorityUri().toString());
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException("Authority URL is not a URL.", localMalformedURLException);
    }
  }
  
  public Uri getAuthorityUri()
  {
    return Uri.parse(mAuthorityUrl);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryB2CAuthority
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */