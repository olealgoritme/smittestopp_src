package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Intent;

public abstract class AuthorizationResultFactory<GenericAuthorizationResult extends AuthorizationResult, GenericAuthorizationRequest extends AuthorizationRequest>
{
  public static final String CODE = "code";
  public static final String ERROR = "error";
  public static final String ERROR_CODE = "error_code";
  public static final String ERROR_DESCRIPTION = "error_description";
  public static final String ERROR_SUBCODE = "error_subcode";
  public static final String STATE = "state";
  
  public abstract GenericAuthorizationResult createAuthorizationResult(int paramInt, Intent paramIntent, GenericAuthorizationRequest paramGenericAuthorizationRequest);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */