package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface ISingleAccountPublicClientApplication$SignOutCallback
{
  public abstract void onError(MsalException paramMsalException);
  
  public abstract void onSignOut();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.ISingleAccountPublicClientApplication.SignOutCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */