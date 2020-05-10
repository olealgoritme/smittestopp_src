package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;

public final class PublicClientApplication$1
  implements IPublicClientApplication.ApplicationCreatedListener
{
  public PublicClientApplication$1(ResultFuture paramResultFuture) {}
  
  public void onCreated(IPublicClientApplication paramIPublicClientApplication)
  {
    val$future.setResult(new AsyncResult(paramIPublicClientApplication, null));
  }
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(null, paramMsalException));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */