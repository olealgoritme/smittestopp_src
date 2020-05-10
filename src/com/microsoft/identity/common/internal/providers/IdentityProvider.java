package com.microsoft.identity.common.internal.providers;

import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;

public abstract class IdentityProvider<T extends OAuth2Strategy, U extends OAuth2Configuration>
{
  public abstract T createOAuth2Strategy(U paramU);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.IdentityProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */