package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;
import java.util.List;

public class MultipleAccountPublicClientApplication$3
  implements IPublicClientApplication.LoadAccountsCallback
{
  public MultipleAccountPublicClientApplication$3(MultipleAccountPublicClientApplication paramMultipleAccountPublicClientApplication, ResultFuture paramResultFuture) {}
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(null, paramMsalException));
  }
  
  public void onTaskCompleted(List<IAccount> paramList)
  {
    val$future.setResult(new AsyncResult(paramList, null));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MultipleAccountPublicClientApplication.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */