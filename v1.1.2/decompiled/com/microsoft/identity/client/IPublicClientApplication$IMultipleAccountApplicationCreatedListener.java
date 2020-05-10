package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface IPublicClientApplication$IMultipleAccountApplicationCreatedListener
{
  public abstract void onCreated(IMultipleAccountPublicClientApplication paramIMultipleAccountPublicClientApplication);
  
  public abstract void onError(MsalException paramMsalException);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IPublicClientApplication.IMultipleAccountApplicationCreatedListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */