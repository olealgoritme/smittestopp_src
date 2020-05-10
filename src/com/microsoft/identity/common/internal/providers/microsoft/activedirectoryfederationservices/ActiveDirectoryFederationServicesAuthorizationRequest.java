package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;

public class ActiveDirectoryFederationServicesAuthorizationRequest
  extends MicrosoftAuthorizationRequest<ActiveDirectoryFederationServicesAuthorizationRequest>
{
  public ActiveDirectoryFederationServicesAuthorizationRequest(ActiveDirectoryFederationServicesAuthorizationRequest.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices.ActiveDirectoryFederationServicesAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */