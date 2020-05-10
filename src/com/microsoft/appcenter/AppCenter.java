package com.microsoft.appcenter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.DefaultChannel;
import com.microsoft.appcenter.channel.OneCollectorChannelListener;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.ingestion.models.CustomPropertiesLog;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import com.microsoft.appcenter.ingestion.models.json.CustomPropertiesLogFactory;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.json.StartServiceLogFactory;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.InstrumentationRegistryHelper;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import e.a.a.a.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class AppCenter
{
  public static final String APP_SECRET_KEY = "appsecret";
  public static final String CORE_GROUP = "group_core";
  public static final long DEFAULT_MAX_STORAGE_SIZE_IN_BYTES = 10485760L;
  public static final String KEY_VALUE_DELIMITER = "=";
  public static final String LOG_TAG = "AppCenter";
  public static final long MINIMUM_STORAGE_SIZE = 24576L;
  public static final String PAIR_DELIMITER = ";";
  public static final String RUNNING_IN_APP_CENTER = "RUNNING_IN_APP_CENTER";
  public static final String TRANSMISSION_TARGET_TOKEN_KEY = "target";
  public static final String TRUE_ENVIRONMENT_STRING = "1";
  @SuppressLint({"StaticFieldLeak"})
  public static AppCenter sInstance;
  public AppCenterHandler mAppCenterHandler;
  public String mAppSecret;
  public Application mApplication;
  public Channel mChannel;
  public boolean mConfiguredFromApp;
  public Handler mHandler;
  public HandlerThread mHandlerThread;
  public boolean mLogLevelConfigured;
  public LogSerializer mLogSerializer;
  public String mLogUrl;
  public long mMaxStorageSizeInBytes = 10485760L;
  public OneCollectorChannelListener mOneCollectorChannelListener;
  public Set<AppCenterService> mServices;
  public Set<AppCenterService> mServicesStartedFromLibrary;
  public DefaultAppCenterFuture<Boolean> mSetMaxStorageSizeFuture;
  public final List<String> mStartedServicesNamesToLog = new ArrayList();
  public String mTransmissionTargetToken;
  public UncaughtExceptionHandler mUncaughtExceptionHandler;
  
  private void applyStorageMaxSize()
  {
    boolean bool = mChannel.setMaxStorageSize(mMaxStorageSizeInBytes);
    DefaultAppCenterFuture localDefaultAppCenterFuture = mSetMaxStorageSizeFuture;
    if (localDefaultAppCenterFuture != null) {
      localDefaultAppCenterFuture.complete(Boolean.valueOf(bool));
    }
  }
  
  private boolean checkPrecondition()
  {
    try
    {
      boolean bool = isInstanceConfigured();
      if (bool) {
        return true;
      }
      AppCenterLog.error("AppCenter", "App Center hasn't been configured. You need to call AppCenter.start with appSecret or AppCenter.configure first.");
      return false;
    }
    finally {}
  }
  
  public static void configure(Application paramApplication)
  {
    getInstance().configureInstance(paramApplication, null, true);
  }
  
  public static void configure(Application paramApplication, String paramString)
  {
    getInstance().configureInstanceWithRequiredAppSecret(paramApplication, paramString);
  }
  
  private void configureAndStartServices(Application paramApplication, String paramString, boolean paramBoolean, Class<? extends AppCenterService>[] paramArrayOfClass)
  {
    if (configureInstance(paramApplication, paramString, paramBoolean)) {
      startServices(paramBoolean, paramArrayOfClass);
    }
  }
  
  private void configureAndStartServices(Application paramApplication, String paramString, Class<? extends AppCenterService>[] paramArrayOfClass)
  {
    if (paramString != null) {}
    try
    {
      if (!paramString.isEmpty()) {
        configureAndStartServices(paramApplication, paramString, true, paramArrayOfClass);
      } else {
        AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
      }
      return;
    }
    finally {}
  }
  
  private boolean configureInstance(Application paramApplication, String paramString, boolean paramBoolean)
  {
    if (paramApplication == null) {}
    try
    {
      AppCenterLog.error("AppCenter", "Application context may not be null.");
      return false;
    }
    finally {}
    if ((!mLogLevelConfigured) && ((getApplicationInfoflags & 0x2) == 2)) {
      AppCenterLog.setLogLevel(5);
    }
    String str = mAppSecret;
    if (paramBoolean)
    {
      boolean bool = configureSecretString(paramString);
      if (!bool) {
        return false;
      }
    }
    if (mHandler != null)
    {
      if ((mAppSecret != null) && (!mAppSecret.equals(str)))
      {
        paramApplication = mHandler;
        paramString = new com/microsoft/appcenter/AppCenter$4;
        paramString.<init>(this);
        paramApplication.post(paramString);
      }
      return true;
    }
    mApplication = paramApplication;
    paramApplication = new android/os/HandlerThread;
    paramApplication.<init>("AppCenter.Looper");
    mHandlerThread = paramApplication;
    paramApplication.start();
    paramApplication = new android/os/Handler;
    paramApplication.<init>(mHandlerThread.getLooper());
    mHandler = paramApplication;
    paramApplication = new com/microsoft/appcenter/AppCenter$5;
    paramApplication.<init>(this);
    mAppCenterHandler = paramApplication;
    paramApplication = new java/util/HashSet;
    paramApplication.<init>();
    mServices = paramApplication;
    paramApplication = new java/util/HashSet;
    paramApplication.<init>();
    mServicesStartedFromLibrary = paramApplication;
    paramApplication = mHandler;
    paramString = new com/microsoft/appcenter/AppCenter$6;
    paramString.<init>(this, paramBoolean);
    paramApplication.post(paramString);
    AppCenterLog.info("AppCenter", "App Center SDK configured successfully.");
    return true;
  }
  
  private void configureInstanceWithRequiredAppSecret(Application paramApplication, String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      configureInstance(paramApplication, paramString, true);
    } else {
      AppCenterLog.error("AppCenter", "appSecret may not be null or empty.");
    }
  }
  
  private boolean configureSecretString(String paramString)
  {
    if (mConfiguredFromApp)
    {
      AppCenterLog.warn("AppCenter", "App Center may only be configured once.");
      return false;
    }
    mConfiguredFromApp = true;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i = paramString.length;
      for (int j = 0; j < i; j++)
      {
        Object localObject1 = paramString[j].split("=", -1);
        Object localObject2 = localObject1[0];
        if (localObject1.length == 1)
        {
          if (!((String)localObject2).isEmpty()) {
            mAppSecret = ((String)localObject2);
          }
        }
        else if (!localObject1[1].isEmpty())
        {
          localObject1 = localObject1[1];
          if ("appsecret".equals(localObject2)) {
            mAppSecret = ((String)localObject1);
          } else if ("target".equals(localObject2)) {
            mTransmissionTargetToken = ((String)localObject1);
          }
        }
      }
    }
    return true;
  }
  
  private void finishConfiguration(boolean paramBoolean)
  {
    Constants.loadFromContext(mApplication);
    FileManager.initialize(mApplication);
    SharedPreferencesManager.initialize(mApplication);
    SessionContext.getInstance();
    boolean bool = isInstanceEnabled();
    Object localObject1 = DependencyConfiguration.getHttpClient();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = HttpUtils.createHttpClient(mApplication);
    }
    localObject1 = new DefaultLogSerializer();
    mLogSerializer = ((LogSerializer)localObject1);
    ((LogSerializer)localObject1).addLogFactory("startService", new StartServiceLogFactory());
    mLogSerializer.addLogFactory("customProperties", new CustomPropertiesLogFactory());
    localObject1 = new DefaultChannel(mApplication, mAppSecret, mLogSerializer, (HttpClient)localObject2, mHandler);
    mChannel = ((Channel)localObject1);
    if (paramBoolean) {
      applyStorageMaxSize();
    } else {
      ((Channel)localObject1).setMaxStorageSize(10485760L);
    }
    mChannel.setEnabled(bool);
    mChannel.addGroup("group_core", 50, 3000L, 3, null, null);
    mOneCollectorChannelListener = new OneCollectorChannelListener(mChannel, mLogSerializer, (HttpClient)localObject2, IdHelper.getInstallId());
    if (mLogUrl != null) {
      if (mAppSecret != null)
      {
        localObject2 = a.a("The log url of App Center endpoint has been changed to ");
        ((StringBuilder)localObject2).append(mLogUrl);
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject2).toString());
        mChannel.setLogUrl(mLogUrl);
      }
      else
      {
        localObject2 = a.a("The log url of One Collector endpoint has been changed to ");
        ((StringBuilder)localObject2).append(mLogUrl);
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject2).toString());
        mOneCollectorChannelListener.setLogUrl(mLogUrl);
      }
    }
    mChannel.addListener(mOneCollectorChannelListener);
    if (!bool) {
      NetworkStateHelper.getSharedInstance(mApplication).close();
    }
    localObject2 = new UncaughtExceptionHandler(mHandler, mChannel);
    mUncaughtExceptionHandler = ((UncaughtExceptionHandler)localObject2);
    if (bool) {
      ((UncaughtExceptionHandler)localObject2).register();
    }
    AppCenterLog.debug("AppCenter", "App Center initialized.");
  }
  
  private void finishStartServices(Iterable<AppCenterService> paramIterable1, Iterable<AppCenterService> paramIterable2, boolean paramBoolean)
  {
    Object localObject1 = paramIterable1.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AppCenterService)((Iterator)localObject1).next();
      ((AppCenterService)localObject2).onConfigurationUpdated(mAppSecret, mTransmissionTargetToken);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localObject2.getClass().getSimpleName());
      ((StringBuilder)localObject3).append(" service configuration updated.");
      AppCenterLog.info("AppCenter", ((StringBuilder)localObject3).toString());
    }
    boolean bool = isInstanceEnabled();
    Object localObject2 = paramIterable2.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (AppCenterService)((Iterator)localObject2).next();
      localObject3 = ((AppCenterService)localObject1).getLogFactories();
      if (localObject3 != null)
      {
        Iterator localIterator = ((Map)localObject3).entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (Map.Entry)localIterator.next();
          mLogSerializer.addLogFactory((String)((Map.Entry)localObject3).getKey(), (LogFactory)((Map.Entry)localObject3).getValue());
        }
      }
      if ((!bool) && (((AppCenterService)localObject1).isInstanceEnabled())) {
        ((AppCenterService)localObject1).setInstanceEnabled(false);
      }
      if (paramBoolean)
      {
        ((AppCenterService)localObject1).onStarted(mApplication, mChannel, mAppSecret, mTransmissionTargetToken, true);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject1.getClass().getSimpleName());
        ((StringBuilder)localObject3).append(" service started from application.");
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject3).toString());
      }
      else
      {
        ((AppCenterService)localObject1).onStarted(mApplication, mChannel, null, null, false);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject1.getClass().getSimpleName());
        ((StringBuilder)localObject3).append(" service started from library.");
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject3).toString());
      }
    }
    if (paramBoolean)
    {
      localObject1 = paramIterable1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramIterable1 = (AppCenterService)((Iterator)localObject1).next();
        mStartedServicesNamesToLog.add(paramIterable1.getServiceName());
      }
      paramIterable1 = paramIterable2.iterator();
      while (paramIterable1.hasNext())
      {
        paramIterable2 = (AppCenterService)paramIterable1.next();
        mStartedServicesNamesToLog.add(paramIterable2.getServiceName());
      }
      sendStartServiceLog();
    }
  }
  
  public static AppCenterFuture<UUID> getInstallId()
  {
    return getInstance().getInstanceInstallIdAsync();
  }
  
  public static AppCenter getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localAppCenter = new com/microsoft/appcenter/AppCenter;
        localAppCenter.<init>();
        sInstance = localAppCenter;
      }
      AppCenter localAppCenter = sInstance;
      return localAppCenter;
    }
    finally {}
  }
  
  private AppCenterFuture<UUID> getInstanceInstallIdAsync()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      if (checkPrecondition())
      {
        AppCenterHandler localAppCenterHandler = mAppCenterHandler;
        AppCenter.12 local12 = new com/microsoft/appcenter/AppCenter$12;
        local12.<init>(this, localDefaultAppCenterFuture);
        AppCenter.13 local13 = new com/microsoft/appcenter/AppCenter$13;
        local13.<init>(this, localDefaultAppCenterFuture);
        localAppCenterHandler.post(local12, local13);
      }
      else
      {
        localDefaultAppCenterFuture.complete(null);
      }
      return localDefaultAppCenterFuture;
    }
    finally {}
  }
  
  public static int getLogLevel()
  {
    return AppCenterLog.getLogLevel();
  }
  
  public static String getSdkVersion()
  {
    return "3.1.0";
  }
  
  private void handlerAppCenterOperation(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    try
    {
      if (checkPrecondition())
      {
        AppCenter.7 local7 = new com/microsoft/appcenter/AppCenter$7;
        local7.<init>(this, paramRunnable1, paramRunnable2);
        if (Thread.currentThread() == mHandlerThread) {
          paramRunnable1.run();
        } else {
          mHandler.post(local7);
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean isConfigured()
  {
    return getInstance().isInstanceConfigured();
  }
  
  public static AppCenterFuture<Boolean> isEnabled()
  {
    return getInstance().isInstanceEnabledAsync();
  }
  
  private boolean isInstanceConfigured()
  {
    try
    {
      Application localApplication = mApplication;
      boolean bool;
      if (localApplication != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private AppCenterFuture<Boolean> isInstanceEnabledAsync()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      if (checkPrecondition())
      {
        AppCenterHandler localAppCenterHandler = mAppCenterHandler;
        AppCenter.9 local9 = new com/microsoft/appcenter/AppCenter$9;
        local9.<init>(this, localDefaultAppCenterFuture);
        AppCenter.10 local10 = new com/microsoft/appcenter/AppCenter$10;
        local10.<init>(this, localDefaultAppCenterFuture);
        localAppCenterHandler.post(local9, local10);
      }
      else
      {
        localDefaultAppCenterFuture.complete(Boolean.valueOf(false));
      }
      return localDefaultAppCenterFuture;
    }
    finally {}
  }
  
  public static boolean isRunningInAppCenterTestCloud()
  {
    try
    {
      boolean bool = "1".equals(InstrumentationRegistryHelper.getArguments().getString("RUNNING_IN_APP_CENTER"));
      return bool;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return false;
  }
  
  private void queueCustomProperties(Map<String, Object> paramMap)
  {
    CustomPropertiesLog localCustomPropertiesLog = new CustomPropertiesLog();
    localCustomPropertiesLog.setProperties(paramMap);
    mChannel.enqueue(localCustomPropertiesLog, "group_core", 1);
  }
  
  private void sendStartServiceLog()
  {
    if ((!mStartedServicesNamesToLog.isEmpty()) && (isInstanceEnabled()))
    {
      ArrayList localArrayList = new ArrayList(mStartedServicesNamesToLog);
      mStartedServicesNamesToLog.clear();
      StartServiceLog localStartServiceLog = new StartServiceLog();
      localStartServiceLog.setServices(localArrayList);
      mChannel.enqueue(localStartServiceLog, "group_core", 1);
    }
  }
  
  public static void setCustomProperties(CustomProperties paramCustomProperties)
  {
    getInstance().setInstanceCustomProperties(paramCustomProperties);
  }
  
  public static AppCenterFuture<Void> setEnabled(boolean paramBoolean)
  {
    return getInstance().setInstanceEnabledAsync(paramBoolean);
  }
  
  private void setInstanceCustomProperties(CustomProperties paramCustomProperties)
  {
    if (paramCustomProperties == null) {}
    try
    {
      AppCenterLog.error("AppCenter", "Custom properties may not be null.");
      return;
    }
    finally {}
    Map localMap = paramCustomProperties.getProperties();
    if (localMap.size() == 0)
    {
      AppCenterLog.error("AppCenter", "Custom properties may not be empty.");
      return;
    }
    paramCustomProperties = new com/microsoft/appcenter/AppCenter$3;
    paramCustomProperties.<init>(this, localMap);
    handlerAppCenterOperation(paramCustomProperties, null);
  }
  
  private void setInstanceEnabled(boolean paramBoolean)
  {
    mChannel.setEnabled(paramBoolean);
    boolean bool = isInstanceEnabled();
    int i;
    if ((bool) && (!paramBoolean)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((!bool) && (paramBoolean)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      mUncaughtExceptionHandler.register();
      NetworkStateHelper.getSharedInstance(mApplication).reopen();
    }
    else if (i != 0)
    {
      mUncaughtExceptionHandler.unregister();
      NetworkStateHelper.getSharedInstance(mApplication).close();
    }
    String str = "enabled";
    if (paramBoolean) {
      SharedPreferencesManager.putBoolean("enabled", true);
    }
    if ((!mStartedServicesNamesToLog.isEmpty()) && (j != 0)) {
      sendStartServiceLog();
    }
    Object localObject = mServices.iterator();
    while (((Iterator)localObject).hasNext())
    {
      AppCenterService localAppCenterService = (AppCenterService)((Iterator)localObject).next();
      if (localAppCenterService.isInstanceEnabled() != paramBoolean) {
        localAppCenterService.setInstanceEnabled(paramBoolean);
      }
    }
    if (!paramBoolean) {
      SharedPreferencesManager.putBoolean("enabled", false);
    }
    if (i != 0)
    {
      AppCenterLog.info("AppCenter", "App Center has been disabled.");
    }
    else if (j != 0)
    {
      AppCenterLog.info("AppCenter", "App Center has been enabled.");
    }
    else
    {
      localObject = a.a("App Center has already been ");
      if (!paramBoolean) {
        str = "disabled";
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".");
      AppCenterLog.info("AppCenter", ((StringBuilder)localObject).toString());
    }
  }
  
  private AppCenterFuture<Void> setInstanceEnabledAsync(boolean paramBoolean)
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      if (checkPrecondition())
      {
        Handler localHandler = mHandler;
        AppCenter.11 local11 = new com/microsoft/appcenter/AppCenter$11;
        local11.<init>(this, paramBoolean, localDefaultAppCenterFuture);
        localHandler.post(local11);
      }
      else
      {
        localDefaultAppCenterFuture.complete(null);
      }
      return localDefaultAppCenterFuture;
    }
    finally {}
  }
  
  private void setInstanceLogLevel(int paramInt)
  {
    try
    {
      mLogLevelConfigured = true;
      AppCenterLog.setLogLevel(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void setInstanceLogUrl(String paramString)
  {
    try
    {
      mLogUrl = paramString;
      if (mHandler != null)
      {
        Handler localHandler = mHandler;
        AppCenter.2 local2 = new com/microsoft/appcenter/AppCenter$2;
        local2.<init>(this, paramString);
        localHandler.post(local2);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private AppCenterFuture<Boolean> setInstanceMaxStorageSizeAsync(long paramLong)
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      if (mConfiguredFromApp)
      {
        AppCenterLog.error("AppCenter", "setMaxStorageSize may not be called after App Center has been configured.");
        localDefaultAppCenterFuture.complete(Boolean.valueOf(false));
        return localDefaultAppCenterFuture;
      }
      if (paramLong < 24576L)
      {
        AppCenterLog.error("AppCenter", "Maximum storage size must be at least 24576 bytes.");
        localDefaultAppCenterFuture.complete(Boolean.valueOf(false));
        return localDefaultAppCenterFuture;
      }
      if (mSetMaxStorageSizeFuture != null)
      {
        AppCenterLog.error("AppCenter", "setMaxStorageSize may only be called once per app launch.");
        localDefaultAppCenterFuture.complete(Boolean.valueOf(false));
        return localDefaultAppCenterFuture;
      }
      mMaxStorageSizeInBytes = paramLong;
      mSetMaxStorageSizeFuture = localDefaultAppCenterFuture;
      return localDefaultAppCenterFuture;
    }
    finally {}
  }
  
  private void setInstanceUserId(String paramString)
  {
    try
    {
      if (!mConfiguredFromApp)
      {
        AppCenterLog.error("AppCenter", "AppCenter must be configured from application, libraries cannot use call setUserId.");
        return;
      }
      if ((mAppSecret == null) && (mTransmissionTargetToken == null))
      {
        AppCenterLog.error("AppCenter", "AppCenter must be configured with a secret from application to call setUserId.");
        return;
      }
      if (paramString != null)
      {
        boolean bool;
        if (mAppSecret != null)
        {
          bool = UserIdContext.checkUserIdValidForAppCenter(paramString);
          if (!bool) {
            return;
          }
        }
        if (mTransmissionTargetToken != null)
        {
          bool = UserIdContext.checkUserIdValidForOneCollector(paramString);
          if (!bool) {
            return;
          }
        }
      }
      UserIdContext.getInstance().setUserId(paramString);
      return;
    }
    finally {}
  }
  
  private void setInstanceWrapperSdk(WrapperSdk paramWrapperSdk)
  {
    try
    {
      DeviceInfoHelper.setWrapperSdk(paramWrapperSdk);
      if (mHandler != null)
      {
        Handler localHandler = mHandler;
        paramWrapperSdk = new com/microsoft/appcenter/AppCenter$1;
        paramWrapperSdk.<init>(this);
        localHandler.post(paramWrapperSdk);
      }
      return;
    }
    finally
    {
      paramWrapperSdk = finally;
      throw paramWrapperSdk;
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    getInstance().setInstanceLogLevel(paramInt);
  }
  
  public static void setLogUrl(String paramString)
  {
    getInstance().setInstanceLogUrl(paramString);
  }
  
  public static AppCenterFuture<Boolean> setMaxStorageSize(long paramLong)
  {
    return getInstance().setInstanceMaxStorageSizeAsync(paramLong);
  }
  
  public static void setUserId(String paramString)
  {
    getInstance().setInstanceUserId(paramString);
  }
  
  public static void setWrapperSdk(WrapperSdk paramWrapperSdk)
  {
    getInstance().setInstanceWrapperSdk(paramWrapperSdk);
  }
  
  @SafeVarargs
  public static void start(Application paramApplication, String paramString, Class<? extends AppCenterService>... paramVarArgs)
  {
    getInstance().configureAndStartServices(paramApplication, paramString, paramVarArgs);
  }
  
  @SafeVarargs
  public static void start(Application paramApplication, Class<? extends AppCenterService>... paramVarArgs)
  {
    getInstance().configureAndStartServices(paramApplication, null, true, paramVarArgs);
  }
  
  @SafeVarargs
  public static void start(Class<? extends AppCenterService>... paramVarArgs)
  {
    getInstance().startServices(true, paramVarArgs);
  }
  
  @SafeVarargs
  public static void startFromLibrary(Context paramContext, Class<? extends AppCenterService>... paramVarArgs)
  {
    getInstance().startInstanceFromLibrary(paramContext, paramVarArgs);
  }
  
  private void startInstanceFromLibrary(Context paramContext, Class<? extends AppCenterService>[] paramArrayOfClass)
  {
    if (paramContext != null) {
      try
      {
        paramContext = (Application)paramContext.getApplicationContext();
      }
      finally
      {
        break label34;
      }
    } else {
      paramContext = null;
    }
    configureAndStartServices(paramContext, null, false, paramArrayOfClass);
    return;
    label34:
    throw paramContext;
  }
  
  private void startOrUpdateService(AppCenterService paramAppCenterService, Collection<AppCenterService> paramCollection1, Collection<AppCenterService> paramCollection2, boolean paramBoolean)
  {
    if (paramBoolean) {
      startOrUpdateServiceFromApp(paramAppCenterService, paramCollection1, paramCollection2);
    } else if (!mServices.contains(paramAppCenterService)) {
      startServiceFromLibrary(paramAppCenterService, paramCollection1);
    }
  }
  
  private void startOrUpdateServiceFromApp(AppCenterService paramAppCenterService, Collection<AppCenterService> paramCollection1, Collection<AppCenterService> paramCollection2)
  {
    String str = paramAppCenterService.getServiceName();
    if (mServices.contains(paramAppCenterService))
    {
      if (mServicesStartedFromLibrary.remove(paramAppCenterService))
      {
        paramCollection2.add(paramAppCenterService);
      }
      else
      {
        paramCollection1 = a.a("App Center has already started the service with class name: ");
        paramCollection1.append(paramAppCenterService.getServiceName());
        AppCenterLog.warn("AppCenter", paramCollection1.toString());
      }
    }
    else if ((mAppSecret == null) && (paramAppCenterService.isAppSecretRequired()))
    {
      paramAppCenterService = new StringBuilder();
      paramAppCenterService.append("App Center was started without app secret, but the service requires it; not starting service ");
      paramAppCenterService.append(str);
      paramAppCenterService.append(".");
      AppCenterLog.error("AppCenter", paramAppCenterService.toString());
    }
    else
    {
      startService(paramAppCenterService, paramCollection1);
    }
  }
  
  private boolean startService(AppCenterService paramAppCenterService, Collection<AppCenterService> paramCollection)
  {
    String str = paramAppCenterService.getServiceName();
    if (ServiceInstrumentationUtils.isServiceDisabledByInstrumentation(str))
    {
      paramAppCenterService = new StringBuilder();
      paramAppCenterService.append("Instrumentation variable to disable service has been set; not starting service ");
      paramAppCenterService.append(str);
      paramAppCenterService.append(".");
      AppCenterLog.debug("AppCenter", paramAppCenterService.toString());
      return false;
    }
    paramAppCenterService.onStarting(mAppCenterHandler);
    mApplication.registerActivityLifecycleCallbacks(paramAppCenterService);
    mServices.add(paramAppCenterService);
    paramCollection.add(paramAppCenterService);
    return true;
  }
  
  private void startServiceFromLibrary(AppCenterService paramAppCenterService, Collection<AppCenterService> paramCollection)
  {
    String str = paramAppCenterService.getServiceName();
    if (paramAppCenterService.isAppSecretRequired())
    {
      paramAppCenterService = new StringBuilder();
      paramAppCenterService.append("This service cannot be started from a library: ");
      paramAppCenterService.append(str);
      paramAppCenterService.append(".");
      AppCenterLog.error("AppCenter", paramAppCenterService.toString());
    }
    else if (startService(paramAppCenterService, paramCollection))
    {
      mServicesStartedFromLibrary.add(paramAppCenterService);
    }
  }
  
  @SafeVarargs
  private final void startServices(boolean paramBoolean, Class<? extends AppCenterService>... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    try
    {
      AppCenterLog.error("AppCenter", "Cannot start services, services array is null. Failed to start services.");
      return;
    }
    finally {}
    Object localObject1 = mApplication;
    int i = 0;
    if (localObject1 == null)
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      j = paramVarArgs.length;
      while (i < j)
      {
        localObject2 = paramVarArgs[i];
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(((Class)localObject2).getName());
        ((StringBuilder)localObject1).append("\n");
        i++;
      }
      paramVarArgs = new java/lang/StringBuilder;
      paramVarArgs.<init>();
      paramVarArgs.append("Cannot start services, App Center has not been configured. Failed to start the following services:\n");
      paramVarArgs.append(localObject1);
      AppCenterLog.error("AppCenter", paramVarArgs.toString());
      return;
    }
    Object localObject2 = new java/util/ArrayList;
    ((ArrayList)localObject2).<init>();
    localObject1 = new java/util/ArrayList;
    ((ArrayList)localObject1).<init>();
    int j = paramVarArgs.length;
    for (i = 0; i < j; i++)
    {
      Class<? extends AppCenterService> localClass = paramVarArgs[i];
      if (localClass == null) {
        AppCenterLog.warn("AppCenter", "Skipping null service, please check your varargs/array does not contain any null reference.");
      } else {
        try
        {
          startOrUpdateService((AppCenterService)localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), (Collection)localObject2, (Collection)localObject1, paramBoolean);
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Failed to get service instance '");
          localStringBuilder.append(localClass.getName());
          localStringBuilder.append("', skipping it.");
          AppCenterLog.error("AppCenter", localStringBuilder.toString(), localException);
        }
      }
    }
    paramVarArgs = mHandler;
    AppCenter.8 local8 = new com/microsoft/appcenter/AppCenter$8;
    local8.<init>(this, (Collection)localObject1, (Collection)localObject2, paramBoolean);
    paramVarArgs.post(local8);
  }
  
  public static void unsetInstance()
  {
    try
    {
      sInstance = null;
      NetworkStateHelper.unsetInstance();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Application getApplication()
  {
    return mApplication;
  }
  
  public Set<AppCenterService> getServices()
  {
    return mServices;
  }
  
  public UncaughtExceptionHandler getUncaughtExceptionHandler()
  {
    return mUncaughtExceptionHandler;
  }
  
  public boolean isInstanceEnabled()
  {
    return SharedPreferencesManager.getBoolean("enabled", true);
  }
  
  public void setChannel(Channel paramChannel)
  {
    mChannel = paramChannel;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.AppCenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */