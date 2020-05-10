package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;

public class CommandDispatcher$3$3
  implements Runnable
{
  public CommandDispatcher$3$3(CommandDispatcher.3 param3, ILocalAuthenticationResult paramILocalAuthenticationResult) {}
  
  public void run()
  {
    this$0.val$command.getCallback().onTaskCompleted(val$authenticationResult);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandDispatcher.3.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */