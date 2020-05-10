package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.ingestion.models.Log;

public class AbstractChannelListener
  implements Channel.Listener
{
  public void onClear(String paramString) {}
  
  public void onGloballyEnabled(boolean paramBoolean) {}
  
  public void onGroupAdded(String paramString, Channel.GroupListener paramGroupListener, long paramLong) {}
  
  public void onGroupRemoved(String paramString) {}
  
  public void onPaused(String paramString1, String paramString2) {}
  
  public void onPreparedLog(Log paramLog, String paramString, int paramInt) {}
  
  public void onPreparingLog(Log paramLog, String paramString) {}
  
  public void onResumed(String paramString1, String paramString2) {}
  
  public boolean shouldFilter(Log paramLog)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.AbstractChannelListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */