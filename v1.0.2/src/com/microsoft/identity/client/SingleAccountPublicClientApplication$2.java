package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;

public class SingleAccountPublicClientApplication$2
  implements ISingleAccountPublicClientApplication.CurrentAccountCallback
{
  public SingleAccountPublicClientApplication$2(SingleAccountPublicClientApplication paramSingleAccountPublicClientApplication, ResultFuture paramResultFuture) {}
  
  public void onAccountChanged(IAccount paramIAccount1, IAccount paramIAccount2)
  {
    paramIAccount1 = new CurrentAccountResult(paramIAccount2, paramIAccount1, false);
    val$future.setResult(new AsyncResult(paramIAccount1, null));
  }
  
  public void onAccountLoaded(IAccount paramIAccount)
  {
    paramIAccount = new CurrentAccountResult(paramIAccount, null, false);
    val$future.setResult(new AsyncResult(paramIAccount, null));
  }
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(null, paramMsalException));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.SingleAccountPublicClientApplication.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */