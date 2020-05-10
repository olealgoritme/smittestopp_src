package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;

public class AzureActiveDirectoryAuthorizationRequest$Builder
  extends MicrosoftAuthorizationRequest.Builder<Builder>
{
  public String mClaimsChallenge;
  public String mPrompt;
  public String mResource;
  
  public AzureActiveDirectoryAuthorizationRequest build()
  {
    setLibraryName("ADAL.Android");
    setLibraryVersion("1.15.2");
    return new AzureActiveDirectoryAuthorizationRequest(this);
  }
  
  public Builder self()
  {
    return this;
  }
  
  public Builder setClaimsChallenge(String paramString)
  {
    mClaimsChallenge = paramString;
    return this;
  }
  
  public Builder setPrompt(String paramString)
  {
    mPrompt = paramString;
    return this;
  }
  
  public Builder setResource(String paramString)
  {
    mResource = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */