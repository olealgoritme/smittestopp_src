package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Log;

public abstract interface Channel
{
  public abstract void addGroup(String paramString, int paramInt1, long paramLong, int paramInt2, Ingestion paramIngestion, GroupListener paramGroupListener);
  
  public abstract void addListener(Listener paramListener);
  
  public abstract void clear(String paramString);
  
  public abstract void enqueue(Log paramLog, String paramString, int paramInt);
  
  public abstract void invalidateDeviceCache();
  
  public abstract boolean isEnabled();
  
  public abstract void pauseGroup(String paramString1, String paramString2);
  
  public abstract void removeGroup(String paramString);
  
  public abstract void removeListener(Listener paramListener);
  
  public abstract void resumeGroup(String paramString1, String paramString2);
  
  public abstract void setAppSecret(String paramString);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setLogUrl(String paramString);
  
  public abstract boolean setMaxStorageSize(long paramLong);
  
  public abstract void shutdown();
  
  public static abstract interface GroupListener
  {
    public abstract void onBeforeSending(Log paramLog);
    
    public abstract void onFailure(Log paramLog, Exception paramException);
    
    public abstract void onSuccess(Log paramLog);
  }
  
  public static abstract interface Listener
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
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.channel.Channel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */