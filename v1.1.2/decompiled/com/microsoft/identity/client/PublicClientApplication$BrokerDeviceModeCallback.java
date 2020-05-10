package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;

public abstract interface PublicClientApplication$BrokerDeviceModeCallback
{
  public abstract void onError(MsalException paramMsalException);
  
  public abstract void onGetMode(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.BrokerDeviceModeCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */