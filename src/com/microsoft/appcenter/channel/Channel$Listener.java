package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.ingestion.models.Log;

public abstract interface Channel$Listener
{
  public abstract void onClear(String paramString);
  
  public abstract void onGloballyEnabled(boolean paramBoolean);
  
  public abstract void onGroupAdded(String paramString, Channel.GroupListener paramGroupListener, long paramLong);
  
  public abstract void onGroupRemoved(String paramString);
  
  public abstract void onPaused(String paramString1, String paramString2);
  
  public abstract void onPreparedLog(Log paramLog, String paramString, int paramInt);
  
  public abstract void onPreparingLog(Log paramLog, String paramString);
  
  public abstract void onResumed(String paramString1, String paramString2);
  
  public abstract boolean shouldFilter(Log paramLog);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.Channel.Listener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */