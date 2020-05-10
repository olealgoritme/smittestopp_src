package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;

public abstract interface IMultipleAccountPublicClientApplication$GetAccountCallback
  extends TaskCompletedCallbackWithError<IAccount, MsalException>
{
  public abstract void onError(MsalException paramMsalException);
  
  public abstract void onTaskCompleted(IAccount paramIAccount);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMultipleAccountPublicClientApplication.GetAccountCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */