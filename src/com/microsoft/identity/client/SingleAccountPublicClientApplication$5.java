package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;

public class SingleAccountPublicClientApplication$5
  implements ISingleAccountPublicClientApplication.SignOutCallback
{
  public SingleAccountPublicClientApplication$5(SingleAccountPublicClientApplication paramSingleAccountPublicClientApplication, ResultFuture paramResultFuture) {}
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(Boolean.valueOf(false), paramMsalException));
  }
  
  public void onSignOut()
  {
    val$future.setResult(new AsyncResult(Boolean.valueOf(true), null));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.SingleAccountPublicClientApplication.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */