package com.microsoft.identity.common.internal.controllers;

public enum CommandResult$ResultStatus
{
  static
  {
    ResultStatus localResultStatus = new ResultStatus("ERROR", 2);
    ERROR = localResultStatus;
    $VALUES = new ResultStatus[] { CANCEL, COMPLETED, localResultStatus };
  }
  
  public CommandResult$ResultStatus() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandResult.ResultStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */