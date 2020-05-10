package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus;

public abstract class MicrosoftAuthorizationResult<GenericMicrosoftAuthorizationResponse extends MicrosoftAuthorizationResponse, GenericMicrosoftAuthorizationErrorResponse extends MicrosoftAuthorizationErrorResponse>
  extends AuthorizationResult<GenericMicrosoftAuthorizationResponse, GenericMicrosoftAuthorizationErrorResponse>
{
  public static final String REQUEST_STATE_PARAMETER = "request_state_parameter";
  
  public MicrosoftAuthorizationResult(AuthorizationStatus paramAuthorizationStatus, GenericMicrosoftAuthorizationErrorResponse paramGenericMicrosoftAuthorizationErrorResponse)
  {
    super(null, paramGenericMicrosoftAuthorizationErrorResponse);
    setAuthorizationStatus(paramAuthorizationStatus);
    setAuthorizationErrorResponse(paramGenericMicrosoftAuthorizationErrorResponse);
  }
  
  public MicrosoftAuthorizationResult(AuthorizationStatus paramAuthorizationStatus, GenericMicrosoftAuthorizationResponse paramGenericMicrosoftAuthorizationResponse)
  {
    super(paramGenericMicrosoftAuthorizationResponse, null);
    setAuthorizationStatus(paramAuthorizationStatus);
    setAuthorizationResponse(paramGenericMicrosoftAuthorizationResponse);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */