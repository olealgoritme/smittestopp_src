package com.microsoft.identity.common.internal.providers.oauth2;

public abstract interface IErrorResponse
{
  public abstract String getError();
  
  public abstract String getErrorDescription();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.IErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */