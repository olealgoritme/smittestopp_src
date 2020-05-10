package com.microsoft.identity.common.internal.providers.oauth2;

import e.c.c.v.a;
import e.c.c.v.c;

public class TokenRequest
{
  @c("client_assertion")
  public String mClientAssertion;
  @a
  @c("client_assertion_type")
  public String mClientAssertionType;
  @a
  @c("client_id")
  public String mClientId;
  @c("client_secret")
  public String mClientSecret;
  @c("code")
  public String mCode;
  @a
  @c("grant_type")
  public String mGrantType;
  @a
  @c("redirect_uri")
  public String mRedirectUri;
  @c("refresh_token")
  public String mRefreshToken;
  @c("req_cnf")
  public String mRequestConfirmation;
  @a
  @c("scope")
  public String mScope;
  @a
  @c("token_type")
  public String mTokenType;
  
  public String getClientAssertion()
  {
    return mClientAssertion;
  }
  
  public String getClientAssertionType()
  {
    return mClientAssertionType;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public String getClientSecret()
  {
    return mClientSecret;
  }
  
  public String getCode()
  {
    return mCode;
  }
  
  public String getGrantType()
  {
    return mGrantType;
  }
  
  public String getRedirectUri()
  {
    return mRedirectUri;
  }
  
  public String getRefreshToken()
  {
    return mRefreshToken;
  }
  
  public String getRequestConfirmation()
  {
    return mRequestConfirmation;
  }
  
  public String getScope()
  {
    return mScope;
  }
  
  public String getTokenType()
  {
    return mTokenType;
  }
  
  public void setClientAssertion(String paramString)
  {
    mClientAssertion = paramString;
  }
  
  public void setClientAssertionType(String paramString)
  {
    mClientAssertionType = paramString;
  }
  
  public void setClientId(String paramString)
  {
    mClientId = paramString;
  }
  
  public void setClientSecret(String paramString)
  {
    mClientSecret = paramString;
  }
  
  public void setCode(String paramString)
  {
    mCode = paramString;
  }
  
  public void setGrantType(String paramString)
  {
    mGrantType = paramString;
  }
  
  public void setRedirectUri(String paramString)
  {
    mRedirectUri = paramString;
  }
  
  public void setRefreshToken(String paramString)
  {
    mRefreshToken = paramString;
  }
  
  public void setRequestConfirmation(String paramString)
  {
    mRequestConfirmation = paramString;
  }
  
  public void setScope(String paramString)
  {
    mScope = paramString;
  }
  
  public void setTokenType(String paramString)
  {
    mTokenType = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.TokenRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */