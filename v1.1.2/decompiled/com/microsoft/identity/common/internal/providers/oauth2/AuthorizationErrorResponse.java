package com.microsoft.identity.common.internal.providers.oauth2;

import e.c.c.v.a;

public class AuthorizationErrorResponse
  implements IErrorResponse
{
  @a
  public String mError;
  @a
  public String mErrorDescription;
  
  public AuthorizationErrorResponse(String paramString1, String paramString2)
  {
    mError = paramString1;
    mErrorDescription = paramString2;
  }
  
  public String getError()
  {
    return mError;
  }
  
  public String getErrorDescription()
  {
    return mErrorDescription;
  }
  
  public void setError(String paramString)
  {
    mError = paramString;
  }
  
  public void setErrorDescription(String paramString)
  {
    mErrorDescription = paramString;
  }
  
  public static class Fields
  {
    public static final String ERROR = "error";
    public static final String ERROR_DESCRIPTION = "error_description";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */