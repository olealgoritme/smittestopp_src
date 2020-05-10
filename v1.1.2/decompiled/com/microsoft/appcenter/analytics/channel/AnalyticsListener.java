package com.microsoft.appcenter.analytics.channel;

import com.microsoft.appcenter.ingestion.models.Log;

public abstract interface AnalyticsListener
{
  public abstract void onBeforeSending(Log paramLog);
  
  public abstract void onSendingFailed(Log paramLog, Exception paramException);
  
  public abstract void onSendingSucceeded(Log paramLog);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.channel.AnalyticsListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */