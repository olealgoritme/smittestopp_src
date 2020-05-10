package com.microsoft.identity.client;

import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;

public class PublicClientApplication$6$1
  implements Runnable
{
  public PublicClientApplication$6$1(PublicClientApplication.6 param6, CommandCallback paramCommandCallback, BaseException paramBaseException) {}
  
  public void run()
  {
    val$callback.onError(val$baseException);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PublicClientApplication.6.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */