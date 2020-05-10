package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.internal.providers.IdentityProvider;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;

public class AzureActiveDirectoryB2C
  extends IdentityProvider<AzureActiveDirectoryB2COAuth2Strategy, OAuth2Configuration>
{
  public AzureActiveDirectoryB2COAuth2Strategy createOAuth2Strategy(OAuth2Configuration paramOAuth2Configuration)
  {
    return new AzureActiveDirectoryB2COAuth2Strategy(paramOAuth2Configuration, new OAuth2StrategyParameters());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c.AzureActiveDirectoryB2C
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */