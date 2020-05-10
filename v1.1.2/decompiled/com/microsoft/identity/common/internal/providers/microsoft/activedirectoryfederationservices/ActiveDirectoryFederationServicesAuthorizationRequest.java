package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;

public class ActiveDirectoryFederationServicesAuthorizationRequest
  extends MicrosoftAuthorizationRequest<ActiveDirectoryFederationServicesAuthorizationRequest>
{
  public ActiveDirectoryFederationServicesAuthorizationRequest(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices.ActiveDirectoryFederationServicesAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */