package com.microsoft.identity.common.internal.controllers;

public class CommandResult
{
  public Object mResult;
  public CommandResult.ResultStatus mStatus;
  
  public CommandResult(CommandResult.ResultStatus paramResultStatus, Object paramObject)
  {
    mStatus = paramResultStatus;
    mResult = paramObject;
  }
  
  public Object getResult()
  {
    return mResult;
  }
  
  public CommandResult.ResultStatus getStatus()
  {
    return mStatus;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.CommandResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */