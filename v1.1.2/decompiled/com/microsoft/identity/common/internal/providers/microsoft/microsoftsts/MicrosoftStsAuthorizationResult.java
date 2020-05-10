package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus;

public class MicrosoftStsAuthorizationResult
  extends MicrosoftAuthorizationResult<MicrosoftStsAuthorizationResponse, MicrosoftStsAuthorizationErrorResponse>
{
  public MicrosoftStsAuthorizationResult(AuthorizationStatus paramAuthorizationStatus, MicrosoftStsAuthorizationErrorResponse paramMicrosoftStsAuthorizationErrorResponse)
  {
    super(paramAuthorizationStatus, paramMicrosoftStsAuthorizationErrorResponse);
  }
  
  public MicrosoftStsAuthorizationResult(AuthorizationStatus paramAuthorizationStatus, MicrosoftStsAuthorizationResponse paramMicrosoftStsAuthorizationResponse)
  {
    super(paramAuthorizationStatus, paramMicrosoftStsAuthorizationResponse);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */