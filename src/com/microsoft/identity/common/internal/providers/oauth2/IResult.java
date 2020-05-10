package com.microsoft.identity.common.internal.providers.oauth2;

public abstract interface IResult
{
  public abstract IErrorResponse getErrorResponse();
  
  public abstract boolean getSuccess();
  
  public abstract ISuccessResponse getSuccessResponse();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.IResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */