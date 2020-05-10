package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface IPublicClientApplication$ISingleAccountApplicationCreatedListener
{
  public abstract void onCreated(ISingleAccountPublicClientApplication paramISingleAccountPublicClientApplication);
  
  public abstract void onError(MsalException paramMsalException);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IPublicClientApplication.ISingleAccountApplicationCreatedListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */