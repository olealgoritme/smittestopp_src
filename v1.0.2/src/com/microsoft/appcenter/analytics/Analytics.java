package com.microsoft.appcenter.analytics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.channel.AnalyticsListener;
import com.microsoft.appcenter.analytics.channel.AnalyticsValidator;
import com.microsoft.appcenter.analytics.channel.SessionTracker;
import com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties;
import com.microsoft.appcenter.analytics.ingestion.models.PageLog;
import com.microsoft.appcenter.analytics.ingestion.models.json.EventLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.PageLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.json.StartSessionLogFactory;
import com.microsoft.appcenter.analytics.ingestion.models.one.json.CommonSchemaEventLogFactory;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.Channel.GroupListener;
import com.microsoft.appcenter.channel.Channel.Listener;
import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.UserIdContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Analytics
  extends AbstractAppCenterService
{
  public static final String ACTIVITY_SUFFIX = "Activity";
  public static final String ANALYTICS_CRITICAL_GROUP = "group_analytics_critical";
  public static final String ANALYTICS_GROUP = "group_analytics";
  public static final String LOG_TAG = "AppCenterAnalytics";
  public static final int MAXIMUM_TRANSMISSION_INTERVAL_IN_SECONDS = 86400;
  public static final int MINIMUM_TRANSMISSION_INTERVAL_IN_SECONDS = 3;
  public static final String SERVICE_NAME = "Analytics";
  @SuppressLint({"StaticFieldLeak"})
  public static Analytics sInstance;
  public AnalyticsListener mAnalyticsListener;
  public Channel.Listener mAnalyticsTransmissionTargetListener;
  public AnalyticsValidator mAnalyticsValidator;
  public boolean mAutoPageTrackingEnabled = false;
  public Context mContext;
  public WeakReference<Activity> mCurrentActivity;
  public AnalyticsTransmissionTarget mDefaultTransmissionTarget;
  public final Map<String, LogFactory> mFactories;
  public SessionTracker mSessionTracker;
  public boolean mStartedFromApp;
  public long mTransmissionInterval;
  public final Map<String, AnalyticsTransmissionTarget> mTransmissionTargets;
  
  public Analytics()
  {
    HashMap localHashMap = new HashMap();
    mFactories = localHashMap;
    localHashMap.put("startSession", new StartSessionLogFactory());
    mFactories.put("page", new PageLogFactory());
    mFactories.put("event", new EventLogFactory());
    mFactories.put("commonSchemaEvent", new CommonSchemaEventLogFactory());
    mTransmissionTargets = new HashMap();
    mTransmissionInterval = TimeUnit.SECONDS.toMillis(3L);
  }
  
  public static List<TypedProperty> convertProperties(EventProperties paramEventProperties)
  {
    if (paramEventProperties == null) {
      return null;
    }
    return new ArrayList(paramEventProperties.getProperties().values());
  }
  
  public static List<TypedProperty> convertProperties(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = new StringTypedProperty();
      paramMap.setName((String)localEntry.getKey());
      paramMap.setValue((String)localEntry.getValue());
      localArrayList.add(paramMap);
    }
    return localArrayList;
  }
  
  private AnalyticsTransmissionTarget createAnalyticsTransmissionTarget(String paramString)
  {
    AnalyticsTransmissionTarget localAnalyticsTransmissionTarget = new AnalyticsTransmissionTarget(paramString, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Created transmission target with token ");
    localStringBuilder.append(paramString);
    AppCenterLog.debug("AppCenterAnalytics", localStringBuilder.toString());
    postCommandEvenIfDisabled(new Analytics.1(this, localAnalyticsTransmissionTarget));
    return localAnalyticsTransmissionTarget;
  }
  
  public static String generatePageName(Class<?> paramClass)
  {
    String str = paramClass.getSimpleName();
    paramClass = str;
    if (str.endsWith("Activity"))
    {
      paramClass = str;
      if (str.length() > 8) {
        paramClass = str.substring(0, str.length() - 8);
      }
    }
    return paramClass;
  }
  
  public static Analytics getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localAnalytics = new com/microsoft/appcenter/analytics/Analytics;
        localAnalytics.<init>();
        sInstance = localAnalytics;
      }
      Analytics localAnalytics = sInstance;
      return localAnalytics;
    }
    finally {}
  }
  
  private AnalyticsTransmissionTarget getInstanceTransmissionTarget(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.isEmpty())
      {
        if (!AppCenter.isConfigured())
        {
          AppCenterLog.error("AppCenterAnalytics", "Cannot create transmission target, AppCenter is not configured or started.");
          return null;
        }
        AnalyticsTransmissionTarget localAnalyticsTransmissionTarget = (AnalyticsTransmissionTarget)mTransmissionTargets.get(paramString);
        if (localAnalyticsTransmissionTarget != null)
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Returning transmission target found with token ");
          localStringBuilder.append(paramString);
          AppCenterLog.debug("AppCenterAnalytics", localStringBuilder.toString());
          return localAnalyticsTransmissionTarget;
        }
        localAnalyticsTransmissionTarget = createAnalyticsTransmissionTarget(paramString);
        mTransmissionTargets.put(paramString, localAnalyticsTransmissionTarget);
        return localAnalyticsTransmissionTarget;
      }
      AppCenterLog.error("AppCenterAnalytics", "Transmission target token may not be null or empty.");
      return null;
    }
    finally {}
  }
  
  public static AnalyticsTransmissionTarget getTransmissionTarget(String paramString)
  {
    return getInstance().getInstanceTransmissionTarget(paramString);
  }
  
  public static boolean isAutoPageTrackingEnabled()
  {
    return getInstance().isInstanceAutoPageTrackingEnabled();
  }
  
  public static AppCenterFuture<Boolean> isEnabled()
  {
    return getInstance().isInstanceEnabledAsync();
  }
  
  private boolean isInstanceAutoPageTrackingEnabled()
  {
    return mAutoPageTrackingEnabled;
  }
  
  public static void pause()
  {
    getInstance().pauseInstanceAsync();
  }
  
  private void pauseInstanceAsync()
  {
    try
    {
      Analytics.9 local9 = new com/microsoft/appcenter/analytics/Analytics$9;
      local9.<init>(this);
      post(local9);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void processOnResume(Activity paramActivity)
  {
    SessionTracker localSessionTracker = mSessionTracker;
    if (localSessionTracker != null)
    {
      localSessionTracker.onActivityResumed();
      if (mAutoPageTrackingEnabled) {
        queuePage(generatePageName(paramActivity.getClass()), null);
      }
    }
  }
  
  private void queuePage(String paramString, Map<String, String> paramMap)
  {
    PageLog localPageLog = new PageLog();
    localPageLog.setName(paramString);
    localPageLog.setProperties(paramMap);
    mChannel.enqueue(localPageLog, "group_analytics", 1);
  }
  
  public static void resume()
  {
    getInstance().resumeInstanceAsync();
  }
  
  private void resumeInstanceAsync()
  {
    try
    {
      Analytics.10 local10 = new com/microsoft/appcenter/analytics/Analytics$10;
      local10.<init>(this);
      post(local10);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setAutoPageTrackingEnabled(boolean paramBoolean)
  {
    getInstance().setInstanceAutoPageTrackingEnabled(paramBoolean);
  }
  
  private void setDefaultTransmissionTarget(String paramString)
  {
    if (paramString != null) {
      mDefaultTransmissionTarget = createAnalyticsTransmissionTarget(paramString);
    }
  }
  
  public static AppCenterFuture<Void> setEnabled(boolean paramBoolean)
  {
    return getInstance().setInstanceEnabledAsync(paramBoolean);
  }
  
  private void setInstanceAutoPageTrackingEnabled(boolean paramBoolean)
  {
    try
    {
      mAutoPageTrackingEnabled = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void setInstanceListener(AnalyticsListener paramAnalyticsListener)
  {
    try
    {
      mAnalyticsListener = paramAnalyticsListener;
      return;
    }
    finally
    {
      paramAnalyticsListener = finally;
      throw paramAnalyticsListener;
    }
  }
  
  private boolean setInstanceTransmissionInterval(int paramInt)
  {
    if (mChannel != null)
    {
      AppCenterLog.error("AppCenterAnalytics", "Transmission interval should be set before the service is started.");
      return false;
    }
    if ((paramInt >= 3) && (paramInt <= 86400))
    {
      mTransmissionInterval = TimeUnit.SECONDS.toMillis(paramInt);
      return true;
    }
    AppCenterLog.error("AppCenterAnalytics", String.format(Locale.ENGLISH, "The transmission interval is invalid. The value should be between %d seconds and %d seconds (%d day).", new Object[] { Integer.valueOf(3), Integer.valueOf(86400), Long.valueOf(TimeUnit.SECONDS.toDays(86400L)) }));
    return false;
  }
  
  public static void setListener(AnalyticsListener paramAnalyticsListener)
  {
    getInstance().setInstanceListener(paramAnalyticsListener);
  }
  
  public static boolean setTransmissionInterval(int paramInt)
  {
    return getInstance().setInstanceTransmissionInterval(paramInt);
  }
  
  private void startAppLevelFeatures()
  {
    if (mStartedFromApp)
    {
      Object localObject = new AnalyticsValidator();
      mAnalyticsValidator = ((AnalyticsValidator)localObject);
      mChannel.addListener((Channel.Listener)localObject);
      localObject = new SessionTracker(mChannel, "group_analytics");
      mSessionTracker = ((SessionTracker)localObject);
      mChannel.addListener((Channel.Listener)localObject);
      localObject = mCurrentActivity;
      if (localObject != null)
      {
        localObject = (Activity)((WeakReference)localObject).get();
        if (localObject != null) {
          processOnResume((Activity)localObject);
        }
      }
      localObject = AnalyticsTransmissionTarget.getChannelListener();
      mAnalyticsTransmissionTargetListener = ((Channel.Listener)localObject);
      mChannel.addListener((Channel.Listener)localObject);
    }
  }
  
  public static void trackEvent(String paramString)
  {
    trackEvent(paramString, null, null, 1);
  }
  
  public static void trackEvent(String paramString, EventProperties paramEventProperties)
  {
    trackEvent(paramString, paramEventProperties, 1);
  }
  
  public static void trackEvent(String paramString, EventProperties paramEventProperties, int paramInt)
  {
    trackEvent(paramString, paramEventProperties, null, paramInt);
  }
  
  public static void trackEvent(String paramString, EventProperties paramEventProperties, AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget, int paramInt)
  {
    getInstance().trackEventAsync(paramString, convertProperties(paramEventProperties), paramAnalyticsTransmissionTarget, paramInt);
  }
  
  public static void trackEvent(String paramString, Map<String, String> paramMap)
  {
    getInstance().trackEventAsync(paramString, convertProperties(paramMap), null, 1);
  }
  
  public static void trackEvent(String paramString, Map<String, String> paramMap, int paramInt)
  {
    getInstance().trackEventAsync(paramString, convertProperties(paramMap), null, paramInt);
  }
  
  private void trackEventAsync(String paramString, List<TypedProperty> paramList, AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget, int paramInt)
  {
    try
    {
      String str = UserIdContext.getInstance().getUserId();
      Analytics.8 local8 = new com/microsoft/appcenter/analytics/Analytics$8;
      local8.<init>(this, paramAnalyticsTransmissionTarget, str, paramString, paramList, paramInt);
      post(local8);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void trackPage(String paramString)
  {
    trackPage(paramString, null);
  }
  
  public static void trackPage(String paramString, Map<String, String> paramMap)
  {
    getInstance().trackPageAsync(paramString, paramMap);
  }
  
  private void trackPageAsync(String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null) {
      try
      {
        localObject = new java/util/HashMap;
        ((HashMap)localObject).<init>(paramMap);
        paramMap = (Map<String, String>)localObject;
      }
      finally
      {
        break label45;
      }
    } else {
      paramMap = null;
    }
    Object localObject = new com/microsoft/appcenter/analytics/Analytics$7;
    ((Analytics.7)localObject).<init>(this, paramString, paramMap);
    post((Runnable)localObject);
    return;
    label45:
    throw paramString;
  }
  
  public static void unsetInstance()
  {
    try
    {
      sInstance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void applyEnabledState(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      mChannel.addGroup("group_analytics_critical", getTriggerCount(), 3000L, getTriggerMaxParallelRequests(), null, getChannelListener());
      startAppLevelFeatures();
      break label133;
      mChannel.removeGroup("group_analytics_critical");
      if (mAnalyticsValidator != null)
      {
        mChannel.removeListener(mAnalyticsValidator);
        mAnalyticsValidator = null;
      }
      if (mSessionTracker != null)
      {
        mChannel.removeListener(mSessionTracker);
        mSessionTracker.clearSessions();
        mSessionTracker = null;
      }
      if (mAnalyticsTransmissionTargetListener != null)
      {
        mChannel.removeListener(mAnalyticsTransmissionTargetListener);
        mAnalyticsTransmissionTargetListener = null;
      }
      label133:
      return;
    }
    finally {}
  }
  
  public Channel.GroupListener getChannelListener()
  {
    return new Analytics.6(this);
  }
  
  public WeakReference<Activity> getCurrentActivity()
  {
    return mCurrentActivity;
  }
  
  public String getEnabledPreferenceKeyPrefix()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getEnabledPreferenceKey());
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public String getGroupName()
  {
    return "group_analytics";
  }
  
  public Map<String, LogFactory> getLogFactories()
  {
    return mFactories;
  }
  
  public String getLoggerTag()
  {
    return "AppCenterAnalytics";
  }
  
  public String getServiceName()
  {
    return "Analytics";
  }
  
  public long getTriggerInterval()
  {
    return mTransmissionInterval;
  }
  
  public boolean isAppSecretRequired()
  {
    return false;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    try
    {
      Analytics.4 local4 = new com/microsoft/appcenter/analytics/Analytics$4;
      local4.<init>(this);
      paramActivity = new com/microsoft/appcenter/analytics/Analytics$5;
      paramActivity.<init>(this, local4);
      post(paramActivity, local4, local4);
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    try
    {
      Analytics.2 local2 = new com/microsoft/appcenter/analytics/Analytics$2;
      local2.<init>(this, paramActivity);
      Analytics.3 local3 = new com/microsoft/appcenter/analytics/Analytics$3;
      local3.<init>(this, local2, paramActivity);
      post(local3, local2, local2);
      return;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public void onConfigurationUpdated(String paramString1, String paramString2)
  {
    mStartedFromApp = true;
    startAppLevelFeatures();
    setDefaultTransmissionTarget(paramString2);
  }
  
  public void onStarted(Context paramContext, Channel paramChannel, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      mContext = paramContext;
      mStartedFromApp = paramBoolean;
      super.onStarted(paramContext, paramChannel, paramString1, paramString2, paramBoolean);
      setDefaultTransmissionTarget(paramString2);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void post(Runnable paramRunnable)
  {
    try
    {
      super.post(paramRunnable);
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  public <T> void postCommand(Runnable paramRunnable, DefaultAppCenterFuture<T> paramDefaultAppCenterFuture, T paramT)
  {
    postAsyncGetter(paramRunnable, paramDefaultAppCenterFuture, paramT);
  }
  
  public void postCommandEvenIfDisabled(Runnable paramRunnable)
  {
    post(paramRunnable, paramRunnable, paramRunnable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.Analytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */