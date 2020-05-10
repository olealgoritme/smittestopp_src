package com.microsoft.identity.common.internal.controllers;

public final class CommandDispatcher$2
  implements Runnable
{
  public CommandDispatcher$2(CommandResult paramCommandResult, BaseCommand paramBaseCommand) {}
  
  public void run()
  {
    int i = val$result.getStatus().ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          val$command.getCallback().onError(val$result.getResult());
        }
      }
      else {
        val$command.getCallback().onTaskCompleted(val$result.getResult());
      }
    }
    else {
      val$command.getCallback().onCancel();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandDispatcher.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */