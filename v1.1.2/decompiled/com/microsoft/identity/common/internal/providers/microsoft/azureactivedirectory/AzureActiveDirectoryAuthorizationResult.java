package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus;

public class AzureActiveDirectoryAuthorizationResult
  extends MicrosoftAuthorizationResult<AzureActiveDirectoryAuthorizationResponse, AzureActiveDirectoryAuthorizationErrorResponse>
{
  public AzureActiveDirectoryAuthorizationResult(AuthorizationStatus paramAuthorizationStatus, AzureActiveDirectoryAuthorizationErrorResponse paramAzureActiveDirectoryAuthorizationErrorResponse)
  {
    super(paramAuthorizationStatus, paramAzureActiveDirectoryAuthorizationErrorResponse);
  }
  
  public AzureActiveDirectoryAuthorizationResult(AuthorizationStatus paramAuthorizationStatus, AzureActiveDirectoryAuthorizationResponse paramAzureActiveDirectoryAuthorizationResponse)
  {
    super(paramAuthorizationStatus, paramAzureActiveDirectoryAuthorizationResponse);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */