package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.internal.AsyncResult;
import com.microsoft.identity.common.internal.result.ResultFuture;

public class PublicClientApplication$13
  implements SilentAuthenticationCallback
{
  public PublicClientApplication$13(PublicClientApplication paramPublicClientApplication, ResultFuture paramResultFuture) {}
  
  public void onError(MsalException paramMsalException)
  {
    val$future.setResult(new AsyncResult(null, paramMsalException));
  }
  
  public void onSuccess(IAuthenticationResult paramIAuthenticationResult)
  {
    val$future.setResult(new AsyncResult(paramIAuthenticationResult, null));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PublicClientApplication.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */