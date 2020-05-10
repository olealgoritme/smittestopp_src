package com.microsoft.identity.common.internal.authorities;

import android.net.Uri;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import java.net.URL;

public class UnknownAuthority
  extends Authority
{
  public OAuth2Strategy createOAuth2Strategy(OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    throw new UnsupportedOperationException();
  }
  
  public URL getAuthorityURL()
  {
    throw new UnsupportedOperationException();
  }
  
  public Uri getAuthorityUri()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authorities.UnknownAuthority
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */