package com.microsoft.appcenter.channel;

import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Log;

public abstract interface Channel
{
  public abstract void addGroup(String paramString, int paramInt1, long paramLong, int paramInt2, Ingestion paramIngestion, Channel.GroupListener paramGroupListener);
  
  public abstract void addListener(Channel.Listener paramListener);
  
  public abstract void clear(String paramString);
  
  public abstract void enqueue(Log paramLog, String paramString, int paramInt);
  
  public abstract void invalidateDeviceCache();
  
  public abstract boolean isEnabled();
  
  public abstract void pauseGroup(String paramString1, String paramString2);
  
  public abstract void removeGroup(String paramString);
  
  public abstract void removeListener(Channel.Listener paramListener);
  
  public abstract void resumeGroup(String paramString1, String paramString2);
  
  public abstract void setAppSecret(String paramString);
  
  public abstract void setEnabled(boolean paramBoolean);
  
  public abstract void setLogUrl(String paramString);
  
  public abstract boolean setMaxStorageSize(long paramLong);
  
  public abstract void shutdown();
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.Channel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */