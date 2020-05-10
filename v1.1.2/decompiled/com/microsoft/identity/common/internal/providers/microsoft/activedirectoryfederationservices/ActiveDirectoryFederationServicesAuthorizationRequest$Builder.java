package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;

public final class ActiveDirectoryFederationServicesAuthorizationRequest$Builder
  extends MicrosoftAuthorizationRequest.Builder<Builder>
{
  public ActiveDirectoryFederationServicesAuthorizationRequest build()
  {
    return new ActiveDirectoryFederationServicesAuthorizationRequest(this, null);
  }
  
  public Builder self()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices.ActiveDirectoryFederationServicesAuthorizationRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */