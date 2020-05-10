package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.ingestion.models.Log;

public abstract interface Channel$GroupListener
{
  public abstract void onBeforeSending(Log paramLog);
  
  public abstract void onFailure(Log paramLog, Exception paramException);
  
  public abstract void onSuccess(Log paramLog);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.Channel.GroupListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */