package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.exception.BaseException;

public class CommandDispatcher$3$5
  implements Runnable
{
  public CommandDispatcher$3$5(CommandDispatcher.3 param3, BaseException paramBaseException) {}
  
  public void run()
  {
    this$0.val$command.getCallback().onError(val$finalException);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.CommandDispatcher.3.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */