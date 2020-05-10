package com.microsoft.identity.common.internal.providers.oauth2;

public abstract class AuthorizationResult<GenericAuthorizationResponse extends AuthorizationResponse, GenericAuthorizationErrorResponse extends AuthorizationErrorResponse>
  implements IResult
{
  public GenericAuthorizationErrorResponse mAuthorizationErrorResponse;
  public GenericAuthorizationResponse mAuthorizationResponse;
  public AuthorizationStatus mAuthorizationStatus;
  public boolean mSuccess = false;
  
  public AuthorizationResult() {}
  
  public AuthorizationResult(GenericAuthorizationResponse paramGenericAuthorizationResponse, GenericAuthorizationErrorResponse paramGenericAuthorizationErrorResponse)
  {
    mAuthorizationResponse = paramGenericAuthorizationResponse;
    mAuthorizationErrorResponse = paramGenericAuthorizationErrorResponse;
    if (paramGenericAuthorizationResponse != null) {
      mSuccess = true;
    }
  }
  
  public AuthorizationResult(AuthorizationStatus paramAuthorizationStatus)
  {
    mAuthorizationStatus = paramAuthorizationStatus;
  }
  
  public GenericAuthorizationErrorResponse getAuthorizationErrorResponse()
  {
    return mAuthorizationErrorResponse;
  }
  
  public GenericAuthorizationResponse getAuthorizationResponse()
  {
    return mAuthorizationResponse;
  }
  
  public AuthorizationStatus getAuthorizationStatus()
  {
    return mAuthorizationStatus;
  }
  
  public IErrorResponse getErrorResponse()
  {
    return mAuthorizationErrorResponse;
  }
  
  public boolean getSuccess()
  {
    return mSuccess;
  }
  
  public ISuccessResponse getSuccessResponse()
  {
    return mAuthorizationResponse;
  }
  
  public void setAuthorizationErrorResponse(GenericAuthorizationErrorResponse paramGenericAuthorizationErrorResponse)
  {
    mAuthorizationErrorResponse = paramGenericAuthorizationErrorResponse;
  }
  
  public void setAuthorizationResponse(GenericAuthorizationResponse paramGenericAuthorizationResponse)
  {
    mAuthorizationResponse = paramGenericAuthorizationResponse;
  }
  
  public void setAuthorizationStatus(AuthorizationStatus paramAuthorizationStatus)
  {
    mAuthorizationStatus = paramAuthorizationStatus;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */