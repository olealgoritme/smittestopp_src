package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.internal.providers.IdentityProvider;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;

public class ActiveDirectoryFederationServices2016
  extends IdentityProvider<ActiveDirectoryFederationServices2016OAuth2Strategy, OAuth2Configuration>
{
  public ActiveDirectoryFederationServices2016OAuth2Strategy createOAuth2Strategy(OAuth2Configuration paramOAuth2Configuration)
  {
    return new ActiveDirectoryFederationServices2016OAuth2Strategy(paramOAuth2Configuration, new OAuth2StrategyParameters());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices.ActiveDirectoryFederationServices2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */