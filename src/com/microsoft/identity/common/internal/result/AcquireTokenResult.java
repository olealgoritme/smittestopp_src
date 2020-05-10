package com.microsoft.identity.common.internal.result;

import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;

public class AcquireTokenResult
{
  public AuthorizationResult mAuthorizationResult;
  public ILocalAuthenticationResult mLocalAuthenticationResult;
  public Boolean mSucceeded = Boolean.valueOf(false);
  public TokenResult mTokenResult;
  
  public AuthorizationResult getAuthorizationResult()
  {
    return mAuthorizationResult;
  }
  
  public ILocalAuthenticationResult getLocalAuthenticationResult()
  {
    return mLocalAuthenticationResult;
  }
  
  public Boolean getSucceeded()
  {
    return mSucceeded;
  }
  
  public TokenResult getTokenResult()
  {
    return mTokenResult;
  }
  
  public void setAuthorizationResult(AuthorizationResult paramAuthorizationResult)
  {
    mAuthorizationResult = paramAuthorizationResult;
  }
  
  public void setLocalAuthenticationResult(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    mLocalAuthenticationResult = paramILocalAuthenticationResult;
    mSucceeded = Boolean.valueOf(true);
  }
  
  public void setTokenResult(TokenResult paramTokenResult)
  {
    mTokenResult = paramTokenResult;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.result.AcquireTokenResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */