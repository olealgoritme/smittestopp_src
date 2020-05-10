package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.IdentityProvider;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;

public class MicrosoftSts
  extends IdentityProvider<MicrosoftStsOAuth2Strategy, MicrosoftStsOAuth2Configuration>
{
  public MicrosoftStsOAuth2Strategy createOAuth2Strategy(MicrosoftStsOAuth2Configuration paramMicrosoftStsOAuth2Configuration)
  {
    return new MicrosoftStsOAuth2Strategy(paramMicrosoftStsOAuth2Configuration, new OAuth2StrategyParameters());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftSts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */