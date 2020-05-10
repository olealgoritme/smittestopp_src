package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface IMultipleAccountPublicClientApplication$RemoveAccountCallback
{
  public abstract void onError(MsalException paramMsalException);
  
  public abstract void onRemoved();
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMultipleAccountPublicClientApplication.RemoveAccountCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */