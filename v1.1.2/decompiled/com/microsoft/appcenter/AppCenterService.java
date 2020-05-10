package com.microsoft.appcenter;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import java.util.Map;

public abstract interface AppCenterService
  extends Application.ActivityLifecycleCallbacks
{
  public abstract Map<String, LogFactory> getLogFactories();
  
  public abstract String getServiceName();
  
  public abstract boolean isAppSecretRequired();
  
  public abstract boolean isInstanceEnabled();
  
  public abstract void onConfigurationUpdated(String paramString1, String paramString2);
  
  public abstract void onStarted(Context paramContext, Channel paramChannel, String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void onStarting(AppCenterHandler paramAppCenterHandler);
  
  public abstract void setInstanceEnabled(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.AppCenterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */