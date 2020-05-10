package com.microsoft.identity.common.internal.authorities;

import android.net.Uri;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import java.net.MalformedURLException;
import java.net.URL;

public class ActiveDirectoryFederationServicesAuthority
  extends Authority
{
  public ActiveDirectoryFederationServicesAuthority(String paramString)
  {
    mAuthorityUrl = paramString;
  }
  
  public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    throw new UnsupportedOperationException();
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
 * Qualified Name:     base.com.microsoft.identity.common.internal.authorities.ActiveDirectoryFederationServicesAuthority
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */