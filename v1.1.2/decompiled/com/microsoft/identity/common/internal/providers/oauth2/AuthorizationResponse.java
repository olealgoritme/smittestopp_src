package com.microsoft.identity.common.internal.providers.oauth2;

import e.c.c.v.a;

public class AuthorizationResponse
  implements ISuccessResponse
{
  public String mCode;
  @a
  public String mState;
  
  public AuthorizationResponse(String paramString)
  {
    this(paramString, null);
  }
  
  public AuthorizationResponse(String paramString1, String paramString2)
  {
    mCode = paramString1;
    mState = paramString2;
  }
  
  public String getCode()
  {
    return mCode;
  }
  
  public String getState()
  {
    return mState;
  }
  
  public void setCode(String paramString)
  {
    mCode = paramString;
  }
  
  public void setState(String paramString)
  {
    mState = paramString;
  }
  
  public static class Fields
  {
    public static final String CODE = "code";
    public static final String STATE = "state";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */