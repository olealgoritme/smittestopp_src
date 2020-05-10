package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface SilentAuthenticationCallback
{
  public abstract void onError(MsalException paramMsalException);
  
  public abstract void onSuccess(IAuthenticationResult paramIAuthenticationResult);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.SilentAuthenticationCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */