package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface IPublicClientApplication$ApplicationCreatedListener
{
  public abstract void onCreated(IPublicClientApplication paramIPublicClientApplication);
  
  public abstract void onError(MsalException paramMsalException);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IPublicClientApplication.ApplicationCreatedListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */