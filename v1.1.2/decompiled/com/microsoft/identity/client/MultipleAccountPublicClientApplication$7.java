package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;

public class MultipleAccountPublicClientApplication$7
  implements IMultipleAccountPublicClientApplication.RemoveAccountCallback
{
  public MultipleAccountPublicClientApplication$7(MultipleAccountPublicClientApplication paramMultipleAccountPublicClientApplication, ResultFuture paramResultFuture) {}
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(Boolean.valueOf(false), paramMsalException));
  }
  
  public void onRemoved()
  {
    val$future.setResult(new AsyncResult(Boolean.valueOf(true), null));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.MultipleAccountPublicClientApplication.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */