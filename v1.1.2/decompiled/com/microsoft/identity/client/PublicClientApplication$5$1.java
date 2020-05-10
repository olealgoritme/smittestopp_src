package com.microsoft.identity.client;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;

public class PublicClientApplication$5$1
  implements Runnable
{
  public PublicClientApplication$5$1(PublicClientApplication.5 param5, CommandCallback paramCommandCallback, BaseException paramBaseException) {}
  
  public void run()
  {
    val$localAuthenticationCallback.onError(val$baseException);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.5.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */