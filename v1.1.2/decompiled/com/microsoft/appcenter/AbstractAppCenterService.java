package com.microsoft.appcenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.Channel.GroupListener;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import e.a.a.a.a;
import java.util.Map;

public abstract class AbstractAppCenterService
  implements AppCenterService
{
  public static final String PREFERENCE_KEY_SEPARATOR = "_";
  public Channel mChannel;
  public AppCenterHandler mHandler;
  
  private void runIfEnabled(Runnable paramRunnable)
  {
    try
    {
      if (isInstanceEnabled()) {
        paramRunnable.run();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void applyEnabledState(boolean paramBoolean) {}
  
  public Channel.GroupListener getChannelListener()
  {
    return null;
  }
  
  public String getEnabledPreferenceKey()
  {
    StringBuilder localStringBuilder = a.a("enabled_");
    localStringBuilder.append(getServiceName());
    return localStringBuilder.toString();
  }
  
  public abstract String getGroupName();
  
  public Map<String, LogFactory> getLogFactories()
  {
    return null;
  }
  
  public abstract String getLoggerTag();
  
  public int getTriggerCount()
  {
    return 50;
  }
  
  public long getTriggerInterval()
  {
    return 3000L;
  }
  
  public int getTriggerMaxParallelRequests()
  {
    return 3;
  }
  
  public boolean isAppSecretRequired()
  {
    return true;
  }
  
  public boolean isInstanceEnabled()
  {
    try
    {
      boolean bool = SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public AppCenterFuture<Boolean> isInstanceEnabledAsync()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      Runnable local1 = new com/microsoft/appcenter/AbstractAppCenterService$1;
      local1.<init>(this, localDefaultAppCenterFuture);
      postAsyncGetter(local1, localDefaultAppCenterFuture, Boolean.valueOf(false));
      return localDefaultAppCenterFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onConfigurationUpdated(String paramString1, String paramString2) {}
  
  public void onStarted(Context paramContext, Channel paramChannel, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramContext = getGroupName();
      paramBoolean = isInstanceEnabled();
      if (paramContext != null)
      {
        paramChannel.removeGroup(paramContext);
        if (paramBoolean) {
          paramChannel.addGroup(paramContext, getTriggerCount(), getTriggerInterval(), getTriggerMaxParallelRequests(), null, getChannelListener());
        } else {
          paramChannel.clear(paramContext);
        }
      }
      mChannel = paramChannel;
      applyEnabledState(paramBoolean);
      return;
    }
    finally {}
  }
  
  public final void onStarting(AppCenterHandler paramAppCenterHandler)
  {
    try
    {
      mHandler = paramAppCenterHandler;
      return;
    }
    finally
    {
      paramAppCenterHandler = finally;
      throw paramAppCenterHandler;
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    try
    {
      post(paramRunnable, null, null);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public boolean post(Runnable paramRunnable1, Runnable paramRunnable2, Runnable paramRunnable3)
  {
    try
    {
      if (mHandler == null)
      {
        paramRunnable1 = new java/lang/StringBuilder;
        paramRunnable1.<init>();
        paramRunnable1.append(getServiceName());
        paramRunnable1.append(" needs to be started before it can be used.");
        AppCenterLog.error("AppCenter", paramRunnable1.toString());
        return false;
      }
      AppCenterHandler localAppCenterHandler = mHandler;
      Runnable local4 = new com/microsoft/appcenter/AbstractAppCenterService$4;
      local4.<init>(this, paramRunnable1, paramRunnable3);
      localAppCenterHandler.post(local4, paramRunnable2);
      return true;
    }
    finally {}
  }
  
  public <T> void postAsyncGetter(Runnable paramRunnable, DefaultAppCenterFuture<T> paramDefaultAppCenterFuture, T paramT)
  {
    try
    {
      Runnable local5 = new com/microsoft/appcenter/AbstractAppCenterService$5;
      local5.<init>(this, paramDefaultAppCenterFuture, paramT);
      paramDefaultAppCenterFuture = new com/microsoft/appcenter/AbstractAppCenterService$6;
      paramDefaultAppCenterFuture.<init>(this, paramRunnable);
      if (!post(paramDefaultAppCenterFuture, local5, local5)) {
        local5.run();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void postOnUiThread(Runnable paramRunnable)
  {
    try
    {
      Runnable local7 = new com/microsoft/appcenter/AbstractAppCenterService$7;
      local7.<init>(this, paramRunnable);
      paramRunnable = new com/microsoft/appcenter/AbstractAppCenterService$8;
      paramRunnable.<init>(this);
      post(local7, paramRunnable, null);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public void setInstanceEnabled(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean == isInstanceEnabled())
      {
        str1 = getLoggerTag();
        str2 = getServiceName();
        if (paramBoolean) {
          str3 = "enabled";
        } else {
          str3 = "disabled";
        }
        AppCenterLog.info(str1, String.format("%s service has already been %s.", new Object[] { str2, str3 }));
        return;
      }
      String str3 = getGroupName();
      if ((mChannel != null) && (str3 != null)) {
        if (paramBoolean)
        {
          mChannel.addGroup(str3, getTriggerCount(), getTriggerInterval(), getTriggerMaxParallelRequests(), null, getChannelListener());
        }
        else
        {
          mChannel.clear(str3);
          mChannel.removeGroup(str3);
        }
      }
      SharedPreferencesManager.putBoolean(getEnabledPreferenceKey(), paramBoolean);
      String str1 = getLoggerTag();
      String str2 = getServiceName();
      if (paramBoolean) {
        str3 = "enabled";
      } else {
        str3 = "disabled";
      }
      AppCenterLog.info(str1, String.format("%s service has been %s.", new Object[] { str2, str3 }));
      if (mChannel != null) {
        applyEnabledState(paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  public final AppCenterFuture<Void> setInstanceEnabledAsync(boolean paramBoolean)
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      Runnable local2 = new com/microsoft/appcenter/AbstractAppCenterService$2;
      local2.<init>(this, localDefaultAppCenterFuture);
      Runnable local3 = new com/microsoft/appcenter/AbstractAppCenterService$3;
      local3.<init>(this, paramBoolean, localDefaultAppCenterFuture);
      if (!post(local3, local2, local3)) {
        localDefaultAppCenterFuture.complete(null);
      }
      return localDefaultAppCenterFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.AbstractAppCenterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */