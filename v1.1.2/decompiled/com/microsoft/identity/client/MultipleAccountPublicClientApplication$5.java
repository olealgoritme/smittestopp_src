package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;

public class MultipleAccountPublicClientApplication$5
  implements IMultipleAccountPublicClientApplication.GetAccountCallback
{
  public MultipleAccountPublicClientApplication$5(MultipleAccountPublicClientApplication paramMultipleAccountPublicClientApplication, ResultFuture paramResultFuture) {}
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(null, paramMsalException));
  }
  
  public void onTaskCompleted(IAccount paramIAccount)
  {
    val$future.setResult(new AsyncResult(paramIAccount, null));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.MultipleAccountPublicClientApplication.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */