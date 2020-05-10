package com.microsoft.identity.common.internal.request;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;

public abstract interface ILocalAuthenticationCallback
{
  public abstract void onCancel();
  
  public abstract void onError(BaseException paramBaseException);
  
  public abstract void onSuccess(ILocalAuthenticationResult paramILocalAuthenticationResult);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.ILocalAuthenticationCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */