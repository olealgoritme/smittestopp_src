package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import e.c.c.v.c;

public class AzureActiveDirectoryAuthorizationRequest
  extends MicrosoftAuthorizationRequest
{
  @c("claims")
  public String mClaimsChallenge;
  @c("prompt")
  public String mPrompt;
  @c("resource")
  public String mResource;
  
  public AzureActiveDirectoryAuthorizationRequest(AzureActiveDirectoryAuthorizationRequest.Builder paramBuilder)
  {
    super(paramBuilder);
    mResource = AzureActiveDirectoryAuthorizationRequest.Builder.access$000(paramBuilder);
    mPrompt = AzureActiveDirectoryAuthorizationRequest.Builder.access$100(paramBuilder);
    mClaimsChallenge = AzureActiveDirectoryAuthorizationRequest.Builder.access$200(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    return null;
  }
  
  public String getClaimsChallenge()
  {
    return mClaimsChallenge;
  }
  
  public String getPrompt()
  {
    return mPrompt;
  }
  
  public String getResource()
  {
    return mResource;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */