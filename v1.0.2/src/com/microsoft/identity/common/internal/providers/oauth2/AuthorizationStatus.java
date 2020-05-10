package com.microsoft.identity.common.internal.providers.oauth2;

public enum AuthorizationStatus
{
  static
  {
    SDK_CANCEL = new AuthorizationStatus("SDK_CANCEL", 2);
    FAIL = new AuthorizationStatus("FAIL", 3);
    AuthorizationStatus localAuthorizationStatus = new AuthorizationStatus("INVALID_REQUEST", 4);
    INVALID_REQUEST = localAuthorizationStatus;
    $VALUES = new AuthorizationStatus[] { SUCCESS, USER_CANCEL, SDK_CANCEL, FAIL, localAuthorizationStatus };
  }
  
  public AuthorizationStatus() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */