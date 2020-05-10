package com.microsoft.appcenter.analytics;

import android.content.Context;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.Channel.Listener;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.Extensions;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.ingestion.models.one.ProtocolExtension;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AnalyticsTransmissionTarget
{
  public static AuthenticationProvider sAuthenticationProvider;
  public Channel mChannel;
  public final Map<String, AnalyticsTransmissionTarget> mChildrenTargets = new HashMap();
  public Context mContext;
  public final AnalyticsTransmissionTarget mParentTarget;
  public final PropertyConfigurator mPropertyConfigurator;
  public final String mTransmissionTargetToken;
  
  public AnalyticsTransmissionTarget(String paramString, AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget)
  {
    mTransmissionTargetToken = paramString;
    mParentTarget = paramAnalyticsTransmissionTarget;
    mPropertyConfigurator = new PropertyConfigurator(this);
  }
  
  public static void addAuthenticationProvider(AuthenticationProvider paramAuthenticationProvider)
  {
    if (paramAuthenticationProvider == null) {}
    try
    {
      AppCenterLog.error("AppCenterAnalytics", "Authentication provider may not be null.");
      return;
    }
    finally {}
    if (paramAuthenticationProvider.getType() == null)
    {
      AppCenterLog.error("AppCenterAnalytics", "Authentication provider type may not be null.");
      return;
    }
    if (paramAuthenticationProvider.getTicketKey() == null)
    {
      AppCenterLog.error("AppCenterAnalytics", "Authentication ticket key may not be null.");
      return;
    }
    if (paramAuthenticationProvider.getTokenProvider() == null)
    {
      AppCenterLog.error("AppCenterAnalytics", "Authentication token provider may not be null.");
      return;
    }
    if (AppCenter.isConfigured())
    {
      Analytics localAnalytics = Analytics.getInstance();
      Runnable local1 = new com/microsoft/appcenter/analytics/AnalyticsTransmissionTarget$1;
      local1.<init>(paramAuthenticationProvider);
      localAnalytics.postCommandEvenIfDisabled(local1);
    }
    else
    {
      updateProvider(paramAuthenticationProvider);
    }
  }
  
  public static void addTicketToLog(Log paramLog)
  {
    Object localObject = sAuthenticationProvider;
    if ((localObject != null) && ((paramLog instanceof CommonSchemaLog)))
    {
      paramLog = (CommonSchemaLog)paramLog;
      localObject = ((AuthenticationProvider)localObject).getTicketKeyHash();
      paramLog.getExt().getProtocol().setTicketKeys(Collections.singletonList(localObject));
      sAuthenticationProvider.checkTokenExpiry();
    }
  }
  
  private boolean areAncestorsEnabled()
  {
    for (AnalyticsTransmissionTarget localAnalyticsTransmissionTarget = mParentTarget; localAnalyticsTransmissionTarget != null; localAnalyticsTransmissionTarget = mParentTarget) {
      if (!localAnalyticsTransmissionTarget.isEnabledInStorage()) {
        return false;
      }
    }
    return true;
  }
  
  public static Channel.Listener getChannelListener()
  {
    new AbstractChannelListener()
    {
      public void onPreparingLog(Log paramAnonymousLog, String paramAnonymousString)
      {
        AnalyticsTransmissionTarget.access$600(paramAnonymousLog);
      }
    };
  }
  
  private String getEnabledPreferenceKey()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Analytics.getInstance().getEnabledPreferenceKeyPrefix());
    localStringBuilder.append(PartAUtils.getTargetKey(mTransmissionTargetToken));
    return localStringBuilder.toString();
  }
  
  private boolean isEnabledInStorage()
  {
    return SharedPreferencesManager.getBoolean(getEnabledPreferenceKey(), true);
  }
  
  public static void updateProvider(AuthenticationProvider paramAuthenticationProvider)
  {
    sAuthenticationProvider = paramAuthenticationProvider;
    paramAuthenticationProvider.acquireTokenAsync();
  }
  
  public PropertyConfigurator getPropertyConfigurator()
  {
    return mPropertyConfigurator;
  }
  
  public AnalyticsTransmissionTarget getTransmissionTarget(String paramString)
  {
    try
    {
      Object localObject1 = (AnalyticsTransmissionTarget)mChildrenTargets.get(paramString);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new com/microsoft/appcenter/analytics/AnalyticsTransmissionTarget;
        ((AnalyticsTransmissionTarget)localObject2).<init>(paramString, this);
        mChildrenTargets.put(paramString, localObject2);
        paramString = Analytics.getInstance();
        localObject1 = new com/microsoft/appcenter/analytics/AnalyticsTransmissionTarget$2;
        ((2)localObject1).<init>(this, (AnalyticsTransmissionTarget)localObject2);
        paramString.postCommandEvenIfDisabled((Runnable)localObject1);
      }
      return (AnalyticsTransmissionTarget)localObject2;
    }
    finally {}
  }
  
  public String getTransmissionTargetToken()
  {
    return mTransmissionTargetToken;
  }
  
  public void initInBackground(Context paramContext, Channel paramChannel)
  {
    mContext = paramContext;
    mChannel = paramChannel;
    paramChannel.addListener(mPropertyConfigurator);
  }
  
  public boolean isEnabled()
  {
    boolean bool;
    if ((areAncestorsEnabled()) && (isEnabledInStorage())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public AppCenterFuture<Boolean> isEnabledAsync()
  {
    final DefaultAppCenterFuture localDefaultAppCenterFuture = new DefaultAppCenterFuture();
    Analytics.getInstance().postCommand(new Runnable()
    {
      public void run()
      {
        localDefaultAppCenterFuture.complete(Boolean.valueOf(isEnabled()));
      }
    }, localDefaultAppCenterFuture, Boolean.valueOf(false));
    return localDefaultAppCenterFuture;
  }
  
  public void pause()
  {
    Analytics.getInstance().post(new Runnable()
    {
      public void run()
      {
        AnalyticsTransmissionTarget.access$100(AnalyticsTransmissionTarget.this).pauseGroup("group_analytics", AnalyticsTransmissionTarget.access$500(AnalyticsTransmissionTarget.this));
        AnalyticsTransmissionTarget.access$100(AnalyticsTransmissionTarget.this).pauseGroup("group_analytics_critical", AnalyticsTransmissionTarget.access$500(AnalyticsTransmissionTarget.this));
      }
    });
  }
  
  public void resume()
  {
    Analytics.getInstance().post(new Runnable()
    {
      public void run()
      {
        AnalyticsTransmissionTarget.access$100(AnalyticsTransmissionTarget.this).resumeGroup("group_analytics", AnalyticsTransmissionTarget.access$500(AnalyticsTransmissionTarget.this));
        AnalyticsTransmissionTarget.access$100(AnalyticsTransmissionTarget.this).resumeGroup("group_analytics_critical", AnalyticsTransmissionTarget.access$500(AnalyticsTransmissionTarget.this));
      }
    });
  }
  
  public AppCenterFuture<Void> setEnabledAsync(final boolean paramBoolean)
  {
    final DefaultAppCenterFuture localDefaultAppCenterFuture = new DefaultAppCenterFuture();
    Analytics.getInstance().postCommand(new Runnable()
    {
      public void run()
      {
        if (AnalyticsTransmissionTarget.access$200(AnalyticsTransmissionTarget.this))
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(AnalyticsTransmissionTarget.this);
          if (!localLinkedList.isEmpty())
          {
            ListIterator localListIterator = localLinkedList.listIterator();
            while (localListIterator.hasNext())
            {
              Object localObject = (AnalyticsTransmissionTarget)localListIterator.next();
              localListIterator.remove();
              SharedPreferencesManager.putBoolean(AnalyticsTransmissionTarget.access$300((AnalyticsTransmissionTarget)localObject), paramBoolean);
              localObject = AnalyticsTransmissionTarget.access$400((AnalyticsTransmissionTarget)localObject).values().iterator();
              while (((Iterator)localObject).hasNext()) {
                localListIterator.add((AnalyticsTransmissionTarget)((Iterator)localObject).next());
              }
            }
          }
        }
        else
        {
          AppCenterLog.error("AppCenterAnalytics", "One of the parent transmission target is disabled, cannot change state.");
        }
        localDefaultAppCenterFuture.complete(null);
      }
    }, localDefaultAppCenterFuture, null);
    return localDefaultAppCenterFuture;
  }
  
  public void trackEvent(String paramString)
  {
    trackEvent(paramString, null, 1);
  }
  
  public void trackEvent(String paramString, EventProperties paramEventProperties)
  {
    trackEvent(paramString, paramEventProperties, 1);
  }
  
  public void trackEvent(String paramString, EventProperties paramEventProperties, int paramInt)
  {
    EventProperties localEventProperties = new EventProperties();
    for (AnalyticsTransmissionTarget localAnalyticsTransmissionTarget = this; localAnalyticsTransmissionTarget != null; localAnalyticsTransmissionTarget = mParentTarget) {
      localAnalyticsTransmissionTarget.getPropertyConfigurator().mergeEventProperties(localEventProperties);
    }
    if (paramEventProperties != null)
    {
      localEventProperties.getProperties().putAll(paramEventProperties.getProperties());
      paramEventProperties = localEventProperties;
    }
    else
    {
      paramEventProperties = localEventProperties;
      if (localEventProperties.getProperties().isEmpty()) {
        paramEventProperties = null;
      }
    }
    Analytics.trackEvent(paramString, paramEventProperties, this, paramInt);
  }
  
  public void trackEvent(String paramString, Map<String, String> paramMap)
  {
    trackEvent(paramString, paramMap, 1);
  }
  
  public void trackEvent(String paramString, Map<String, String> paramMap, int paramInt)
  {
    if (paramMap != null)
    {
      EventProperties localEventProperties = new EventProperties();
      Iterator localIterator = paramMap.entrySet().iterator();
      for (;;)
      {
        paramMap = localEventProperties;
        if (!localIterator.hasNext()) {
          break;
        }
        paramMap = (Map.Entry)localIterator.next();
        localEventProperties.set((String)paramMap.getKey(), (String)paramMap.getValue());
      }
    }
    paramMap = null;
    trackEvent(paramString, paramMap, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */