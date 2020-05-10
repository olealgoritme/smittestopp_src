package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;

public final class AzureActiveDirectoryB2CAuthorizationRequest$Builder
  extends MicrosoftAuthorizationRequest.Builder<Builder>
{
  public String mPrompt;
  
  public AzureActiveDirectoryB2CAuthorizationRequest build()
  {
    return new AzureActiveDirectoryB2CAuthorizationRequest(this, null);
  }
  
  public Builder self()
  {
    return this;
  }
  
  public Builder setPrompt(String paramString)
  {
    mPrompt = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c.AzureActiveDirectoryB2CAuthorizationRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */