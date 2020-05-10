package com.microsoft.identity.common.internal.controllers;

public class CommandResult
{
  public Object mResult;
  public ResultStatus mStatus;
  
  public CommandResult(ResultStatus paramResultStatus, Object paramObject)
  {
    mStatus = paramResultStatus;
    mResult = paramObject;
  }
  
  public Object getResult()
  {
    return mResult;
  }
  
  public ResultStatus getStatus()
  {
    return mStatus;
  }
  
  public static enum ResultStatus
  {
    static
    {
      ResultStatus localResultStatus = new ResultStatus("ERROR", 2);
      ERROR = localResultStatus;
      $VALUES = new ResultStatus[] { CANCEL, COMPLETED, localResultStatus };
    }
    
    public ResultStatus() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */