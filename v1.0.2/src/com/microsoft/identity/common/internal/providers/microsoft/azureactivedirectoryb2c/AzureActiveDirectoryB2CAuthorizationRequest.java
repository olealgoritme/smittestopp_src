package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;

public class AzureActiveDirectoryB2CAuthorizationRequest
  extends MicrosoftAuthorizationRequest<AzureActiveDirectoryB2CAuthorizationRequest>
{
  public String mPrompt;
  
  public AzureActiveDirectoryB2CAuthorizationRequest(AzureActiveDirectoryB2CAuthorizationRequest.Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public String getPrompt()
  {
    return mPrompt;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c.AzureActiveDirectoryB2CAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */