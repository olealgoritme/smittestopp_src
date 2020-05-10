package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface ISingleAccountPublicClientApplication$CurrentAccountCallback
{
  public abstract void onAccountChanged(IAccount paramIAccount1, IAccount paramIAccount2);
  
  public abstract void onAccountLoaded(IAccount paramIAccount);
  
  public abstract void onError(MsalException paramMsalException);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.ISingleAccountPublicClientApplication.CurrentAccountCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */