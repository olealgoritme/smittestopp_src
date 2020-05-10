package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import java.util.List;

public abstract interface IPublicClientApplication$LoadAccountsCallback
  extends TaskCompletedCallbackWithError<List<IAccount>, MsalException>
{
  public abstract void onError(MsalException paramMsalException);
  
  public abstract void onTaskCompleted(List<IAccount> paramList);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.IPublicClientApplication.LoadAccountsCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */