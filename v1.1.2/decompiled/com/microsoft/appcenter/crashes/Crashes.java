package com.microsoft.appcenter.crashes;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.Channel.GroupListener;
import com.microsoft.appcenter.crashes.ingestion.models.AbstractErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.json.ErrorAttachmentLogFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.HandledErrorLogFactory;
import com.microsoft.appcenter.crashes.ingestion.models.json.ManagedErrorLogFactory;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.model.NativeException;
import com.microsoft.appcenter.crashes.model.TestCrashException;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer;
import com.microsoft.appcenter.ingestion.models.json.LogFactory;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.HandlerUtils;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.context.SessionContext;
import com.microsoft.appcenter.utils.context.SessionContext.SessionInfo;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import e.a.a.a.a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;

public class Crashes
  extends AbstractAppCenterService
{
  public static final int ALWAYS_SEND = 2;
  public static final CrashesListener DEFAULT_ERROR_REPORTING_LISTENER = new DefaultCrashesListener(null);
  public static final int DONT_SEND = 1;
  public static final String ERROR_GROUP = "groupErrors";
  public static final String LOG_TAG = "AppCenterCrashes";
  public static final int MAX_ATTACHMENT_PER_CRASH = 2;
  public static final int MAX_ATTACHMENT_SIZE = 7340032;
  public static final String PREF_KEY_ALWAYS_SEND = "com.microsoft.appcenter.crashes.always.send";
  public static final String PREF_KEY_MEMORY_RUNNING_LEVEL = "com.microsoft.appcenter.crashes.memory";
  public static final int SEND = 0;
  public static final String SERVICE_NAME = "Crashes";
  @SuppressLint({"StaticFieldLeak"})
  public static Crashes sInstance = null;
  public boolean mAutomaticProcessing = true;
  public Context mContext;
  public CrashesListener mCrashesListener;
  public Device mDevice;
  public final Map<UUID, ErrorLogReport> mErrorReportCache;
  public final Map<String, LogFactory> mFactories;
  public boolean mHasReceivedMemoryWarningInLastSession;
  public long mInitializeTimestamp;
  public ErrorReport mLastSessionErrorReport;
  public LogSerializer mLogSerializer;
  public ComponentCallbacks2 mMemoryWarningListener;
  public boolean mSavedUncaughtException;
  public UncaughtExceptionHandler mUncaughtExceptionHandler;
  public final Map<UUID, ErrorLogReport> mUnprocessedErrorReports;
  
  public Crashes()
  {
    Object localObject = new HashMap();
    mFactories = ((Map)localObject);
    ((Map)localObject).put("managedError", ManagedErrorLogFactory.getInstance());
    mFactories.put("handledError", HandledErrorLogFactory.getInstance());
    mFactories.put("errorAttachment", ErrorAttachmentLogFactory.getInstance());
    localObject = new DefaultLogSerializer();
    mLogSerializer = ((LogSerializer)localObject);
    ((LogSerializer)localObject).addLogFactory("managedError", ManagedErrorLogFactory.getInstance());
    mLogSerializer.addLogFactory("errorAttachment", ErrorAttachmentLogFactory.getInstance());
    mCrashesListener = DEFAULT_ERROR_REPORTING_LISTENER;
    mUnprocessedErrorReports = new LinkedHashMap();
    mErrorReportCache = new LinkedHashMap();
  }
  
  public static void generateTestCrash()
  {
    if (!Constants.APPLICATION_DEBUGGABLE)
    {
      AppCenterLog.warn("AppCenterCrashes", "The application is not debuggable so SDK won't generate test crash");
      return;
    }
    throw new TestCrashException();
  }
  
  public static Crashes getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localCrashes = new com/microsoft/appcenter/crashes/Crashes;
        localCrashes.<init>();
        sInstance = localCrashes;
      }
      Crashes localCrashes = sInstance;
      return localCrashes;
    }
    finally {}
  }
  
  private AppCenterFuture<ErrorReport> getInstanceLastSessionCrashReport()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      Runnable local4 = new com/microsoft/appcenter/crashes/Crashes$4;
      local4.<init>(this, localDefaultAppCenterFuture);
      postAsyncGetter(local4, localDefaultAppCenterFuture, null);
      return localDefaultAppCenterFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static AppCenterFuture<ErrorReport> getLastSessionCrashReport()
  {
    return getInstance().getInstanceLastSessionCrashReport();
  }
  
  public static AppCenterFuture<String> getMinidumpDirectory()
  {
    return getInstance().getNewMinidumpDirectoryAsync();
  }
  
  private AppCenterFuture<String> getNewMinidumpDirectoryAsync()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      Runnable local1 = new com/microsoft/appcenter/crashes/Crashes$1;
      local1.<init>(this, localDefaultAppCenterFuture);
      postAsyncGetter(local1, localDefaultAppCenterFuture, null);
      return localDefaultAppCenterFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void handleUserConfirmation(int paramInt)
  {
    try
    {
      Runnable local12 = new com/microsoft/appcenter/crashes/Crashes$12;
      local12.<init>(this, paramInt);
      post(local12);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static AppCenterFuture<Boolean> hasCrashedInLastSession()
  {
    return getInstance().hasInstanceCrashedInLastSession();
  }
  
  private AppCenterFuture<Boolean> hasInstanceCrashedInLastSession()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      Runnable local2 = new com/microsoft/appcenter/crashes/Crashes$2;
      local2.<init>(this, localDefaultAppCenterFuture);
      postAsyncGetter(local2, localDefaultAppCenterFuture, Boolean.valueOf(false));
      return localDefaultAppCenterFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private AppCenterFuture<Boolean> hasInstanceReceivedMemoryWarningInLastSession()
  {
    try
    {
      DefaultAppCenterFuture localDefaultAppCenterFuture = new com/microsoft/appcenter/utils/async/DefaultAppCenterFuture;
      localDefaultAppCenterFuture.<init>();
      Runnable local3 = new com/microsoft/appcenter/crashes/Crashes$3;
      local3.<init>(this, localDefaultAppCenterFuture);
      postAsyncGetter(local3, localDefaultAppCenterFuture, Boolean.valueOf(false));
      return localDefaultAppCenterFuture;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static AppCenterFuture<Boolean> hasReceivedMemoryWarningInLastSession()
  {
    return getInstance().hasInstanceReceivedMemoryWarningInLastSession();
  }
  
  private void initialize()
  {
    boolean bool = isInstanceEnabled();
    long l;
    if (bool) {
      l = System.currentTimeMillis();
    } else {
      l = -1L;
    }
    mInitializeTimestamp = l;
    UncaughtExceptionHandler localUncaughtExceptionHandler;
    if (!bool)
    {
      localUncaughtExceptionHandler = mUncaughtExceptionHandler;
      if (localUncaughtExceptionHandler != null)
      {
        localUncaughtExceptionHandler.unregister();
        mUncaughtExceptionHandler = null;
      }
    }
    else
    {
      localUncaughtExceptionHandler = new UncaughtExceptionHandler();
      mUncaughtExceptionHandler = localUncaughtExceptionHandler;
      localUncaughtExceptionHandler.register();
      processMinidumpFiles();
    }
  }
  
  public static AppCenterFuture<Boolean> isEnabled()
  {
    return getInstance().isInstanceEnabledAsync();
  }
  
  public static boolean isMemoryRunningLevelWasReceived(int paramInt)
  {
    boolean bool;
    if ((paramInt != 5) && (paramInt != 10) && (paramInt != 15) && (paramInt != 80)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static void notifyUserConfirmation(int paramInt)
  {
    getInstance().handleUserConfirmation(paramInt);
  }
  
  private void processMinidumpFiles()
  {
    Object localObject1;
    for (localObject1 : ) {
      if (!((File)localObject1).isDirectory())
      {
        AppCenterLog.debug("AppCenterCrashes", "Found a minidump from a previous SDK version.");
        processSingleMinidump((File)localObject1, (File)localObject1);
      }
      else
      {
        localObject2 = ((File)localObject1).listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return paramAnonymousString.equals("deviceInfo") ^ true;
          }
        });
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          int k = localObject2.length;
          for (int m = 0; m < k; m++) {
            processSingleMinidump(localObject2[m], (File)localObject1);
          }
        }
      }
    }
    for (Object localObject2 = ErrorLogHelper.getLastErrorLogFile(); (localObject2 != null) && (((File)localObject2).length() == 0L); localObject2 = ErrorLogHelper.getLastErrorLogFile())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Deleting empty error file: ");
      ((StringBuilder)localObject1).append(localObject2);
      AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)localObject1).toString());
      ((File)localObject2).delete();
    }
    if (localObject2 != null)
    {
      AppCenterLog.debug("AppCenterCrashes", "Processing crash report for the last session.");
      localObject2 = FileManager.read((File)localObject2);
      if (localObject2 == null) {
        AppCenterLog.error("AppCenterCrashes", "Error reading last session error log.");
      } else {
        try
        {
          mLastSessionErrorReport = buildErrorReport((ManagedErrorLog)mLogSerializer.deserializeLog((String)localObject2, null));
          AppCenterLog.debug("AppCenterCrashes", "Processed crash report for the last session.");
        }
        catch (JSONException localJSONException)
        {
          AppCenterLog.error("AppCenterCrashes", "Error parsing last session error log.", localJSONException);
        }
      }
    }
    ErrorLogHelper.removeStaleMinidumpSubfolders();
  }
  
  private void processPendingErrors()
  {
    for (File localFile : )
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Process pending error file: ");
      ((StringBuilder)localObject1).append(localFile);
      AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject1).toString());
      localObject1 = FileManager.read(localFile);
      if (localObject1 != null) {
        try
        {
          localObject2 = (ManagedErrorLog)mLogSerializer.deserializeLog((String)localObject1, null);
          localObject1 = ((AbstractErrorLog)localObject2).getId();
          localObject2 = buildErrorReport((ManagedErrorLog)localObject2);
          if (localObject2 == null)
          {
            removeAllStoredErrorLogFiles((UUID)localObject1);
          }
          else if ((mAutomaticProcessing) && (!mCrashesListener.shouldProcess((ErrorReport)localObject2)))
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            ((StringBuilder)localObject2).append("CrashesListener.shouldProcess returned false, clean up and ignore log: ");
            ((StringBuilder)localObject2).append(((UUID)localObject1).toString());
            AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject2).toString());
            removeAllStoredErrorLogFiles((UUID)localObject1);
          }
          else
          {
            if (!mAutomaticProcessing)
            {
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              ((StringBuilder)localObject2).append("CrashesListener.shouldProcess returned true, continue processing log: ");
              ((StringBuilder)localObject2).append(((UUID)localObject1).toString());
              AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject2).toString());
            }
            mUnprocessedErrorReports.put(localObject1, mErrorReportCache.get(localObject1));
          }
        }
        catch (JSONException localJSONException)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Error parsing error log. Deleting invalid file: ");
          ((StringBuilder)localObject2).append(localFile);
          AppCenterLog.error("AppCenterCrashes", ((StringBuilder)localObject2).toString(), localJSONException);
          localFile.delete();
        }
      }
    }
    boolean bool = isMemoryRunningLevelWasReceived(SharedPreferencesManager.getInt("com.microsoft.appcenter.crashes.memory", -1));
    mHasReceivedMemoryWarningInLastSession = bool;
    if (bool) {
      AppCenterLog.debug("AppCenterCrashes", "The application received a low memory warning in the last session.");
    }
    SharedPreferencesManager.remove("com.microsoft.appcenter.crashes.memory");
    if (mAutomaticProcessing) {
      sendCrashReportsOrAwaitUserConfirmation();
    }
  }
  
  private void processSingleMinidump(File paramFile1, File paramFile2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Process pending minidump file: ");
    ((StringBuilder)localObject).append(paramFile1);
    AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject).toString());
    long l = paramFile1.lastModified();
    File localFile = new File(ErrorLogHelper.getPendingMinidumpDirectory(), paramFile1.getName());
    localObject = new com.microsoft.appcenter.crashes.ingestion.models.Exception();
    ((com.microsoft.appcenter.crashes.ingestion.models.Exception)localObject).setType("minidump");
    ((com.microsoft.appcenter.crashes.ingestion.models.Exception)localObject).setWrapperSdkName("appcenter.ndk");
    ((com.microsoft.appcenter.crashes.ingestion.models.Exception)localObject).setMinidumpFilePath(localFile.getPath());
    ManagedErrorLog localManagedErrorLog = new ManagedErrorLog();
    localManagedErrorLog.setException((com.microsoft.appcenter.crashes.ingestion.models.Exception)localObject);
    localManagedErrorLog.setTimestamp(new Date(l));
    localManagedErrorLog.setFatal(Boolean.valueOf(true));
    localManagedErrorLog.setId(ErrorLogHelper.parseLogFolderUuid(paramFile2));
    localObject = SessionContext.getInstance().getSessionAt(l);
    if ((localObject != null) && (((SessionContext.SessionInfo)localObject).getAppLaunchTimestamp() <= l)) {
      localManagedErrorLog.setAppLaunchTimestamp(new Date(((SessionContext.SessionInfo)localObject).getAppLaunchTimestamp()));
    } else {
      localManagedErrorLog.setAppLaunchTimestamp(localManagedErrorLog.getTimestamp());
    }
    localManagedErrorLog.setProcessId(Integer.valueOf(0));
    localManagedErrorLog.setProcessName("");
    localManagedErrorLog.setUserId(UserIdContext.getInstance().getUserId());
    try
    {
      localObject = ErrorLogHelper.getStoredDeviceInfo(paramFile2);
      paramFile2 = (File)localObject;
      if (localObject == null)
      {
        paramFile2 = getDeviceInfo(mContext);
        paramFile2.setWrapperSdkName("appcenter.ndk");
      }
      localManagedErrorLog.setDevice(paramFile2);
      paramFile2 = new com/microsoft/appcenter/crashes/model/NativeException;
      paramFile2.<init>();
      saveErrorLogFiles(paramFile2, localManagedErrorLog);
      if (!paramFile1.renameTo(localFile))
      {
        paramFile2 = new java/io/IOException;
        paramFile2.<init>("Failed to move file");
        throw paramFile2;
      }
    }
    catch (Exception paramFile2)
    {
      paramFile1.delete();
      removeAllStoredErrorLogFiles(localManagedErrorLog.getId());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to process new minidump file: ");
      ((StringBuilder)localObject).append(paramFile1);
      AppCenterLog.error("AppCenterCrashes", ((StringBuilder)localObject).toString(), paramFile2);
    }
  }
  
  private UUID queueException(ExceptionModelBuilder paramExceptionModelBuilder, Map<String, String> paramMap, Iterable<ErrorAttachmentLog> paramIterable)
  {
    try
    {
      String str = UserIdContext.getInstance().getUserId();
      UUID localUUID = UUID.randomUUID();
      Map localMap = ErrorLogHelper.validateProperties(paramMap, "HandledError");
      paramMap = new com/microsoft/appcenter/crashes/Crashes$9;
      paramMap.<init>(this, localUUID, str, paramExceptionModelBuilder, localMap, paramIterable);
      post(paramMap);
      return localUUID;
    }
    finally
    {
      paramExceptionModelBuilder = finally;
      throw paramExceptionModelBuilder;
    }
  }
  
  private void queueException(Throwable paramThrowable, Map<String, String> paramMap, Iterable<ErrorAttachmentLog> paramIterable)
  {
    try
    {
      ExceptionModelBuilder local7 = new com/microsoft/appcenter/crashes/Crashes$7;
      local7.<init>(this, paramThrowable);
      queueException(local7, paramMap, paramIterable);
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private void removeAllStoredErrorLogFiles(UUID paramUUID)
  {
    ErrorLogHelper.removeStoredErrorLogFile(paramUUID);
    removeStoredThrowable(paramUUID);
  }
  
  private void removeStoredThrowable(UUID paramUUID)
  {
    mErrorReportCache.remove(paramUUID);
    WrapperSdkExceptionManager.deleteWrapperExceptionData(paramUUID);
    ErrorLogHelper.removeStoredThrowableFile(paramUUID);
  }
  
  private UUID saveErrorLogFiles(Throwable paramThrowable, ManagedErrorLog paramManagedErrorLog)
  {
    File localFile1 = ErrorLogHelper.getErrorStorageDirectory();
    UUID localUUID = paramManagedErrorLog.getId();
    String str = localUUID.toString();
    AppCenterLog.debug("AppCenterCrashes", "Saving uncaught exception.");
    File localFile2 = new File(localFile1, a.b(str, ".json"));
    FileManager.write(localFile2, mLogSerializer.serializeLog(paramManagedErrorLog));
    paramManagedErrorLog = new StringBuilder();
    paramManagedErrorLog.append("Saved JSON content for ingestion into ");
    paramManagedErrorLog.append(localFile2);
    AppCenterLog.debug("AppCenterCrashes", paramManagedErrorLog.toString());
    localFile2 = new File(localFile1, a.b(str, ".throwable"));
    paramManagedErrorLog = paramThrowable;
    if (paramThrowable != null) {
      try
      {
        str = android.util.Log.getStackTraceString(paramThrowable);
        FileManager.write(localFile2, str);
        paramManagedErrorLog = new java/lang/StringBuilder;
        paramManagedErrorLog.<init>();
        paramManagedErrorLog.append("Saved stack trace as is for client side inspection in ");
        paramManagedErrorLog.append(localFile2);
        paramManagedErrorLog.append(" stack trace:");
        paramManagedErrorLog.append(str);
        AppCenterLog.debug("AppCenterCrashes", paramManagedErrorLog.toString());
        paramManagedErrorLog = paramThrowable;
      }
      catch (StackOverflowError paramThrowable)
      {
        AppCenterLog.error("AppCenterCrashes", "Failed to store stack trace.", paramThrowable);
        paramManagedErrorLog = null;
        localFile2.delete();
      }
    }
    if (paramManagedErrorLog == null) {
      if (localFile2.createNewFile())
      {
        paramThrowable = new StringBuilder();
        paramThrowable.append("Saved empty Throwable file in ");
        paramThrowable.append(localFile2);
        AppCenterLog.debug("AppCenterCrashes", paramThrowable.toString());
      }
      else
      {
        throw new IOException(localFile2.getName());
      }
    }
    return localUUID;
  }
  
  public static void saveMemoryRunningLevel(int paramInt)
  {
    SharedPreferencesManager.putInt("com.microsoft.appcenter.crashes.memory", paramInt);
    AppCenterLog.debug("AppCenterCrashes", String.format("The memory running level (%s) was saved.", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  private boolean sendCrashReportsOrAwaitUserConfirmation()
  {
    final boolean bool = SharedPreferencesManager.getBoolean("com.microsoft.appcenter.crashes.always.send", false);
    HandlerUtils.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (Crashes.access$1000(Crashes.this).size() > 0)
        {
          if (bool)
          {
            AppCenterLog.debug("AppCenterCrashes", "The flag for user confirmation is set to ALWAYS_SEND, will send logs.");
            Crashes.access$1100(Crashes.this, 0);
            return;
          }
          if (!Crashes.access$1200(Crashes.this))
          {
            AppCenterLog.debug("AppCenterCrashes", "Automatic processing disabled, will wait for explicit user confirmation.");
            return;
          }
          if (!Crashes.access$700(Crashes.this).shouldAwaitUserConfirmation())
          {
            AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned false, will send logs.");
            Crashes.access$1100(Crashes.this, 0);
          }
          else
          {
            AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned true, wait sending logs.");
          }
        }
      }
    });
    return bool;
  }
  
  private void sendErrorAttachment(UUID paramUUID, Iterable<ErrorAttachmentLog> paramIterable)
  {
    if (paramIterable == null)
    {
      paramIterable = a.a("Error report: ");
      paramIterable.append(paramUUID.toString());
      paramIterable.append(" does not have any attachment.");
      AppCenterLog.debug("AppCenterCrashes", paramIterable.toString());
    }
    else
    {
      Iterator localIterator = paramIterable.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        paramIterable = (ErrorAttachmentLog)localIterator.next();
        if (paramIterable != null)
        {
          paramIterable.setId(UUID.randomUUID());
          paramIterable.setErrorId(paramUUID);
          if (!paramIterable.isValid())
          {
            AppCenterLog.error("AppCenterCrashes", "Not all required fields are present in ErrorAttachmentLog.");
          }
          else if (paramIterable.getData().length > 7340032)
          {
            AppCenterLog.error("AppCenterCrashes", String.format(Locale.ENGLISH, "Discarding attachment with size above %d bytes: size=%d, fileName=%s.", new Object[] { Integer.valueOf(7340032), Integer.valueOf(paramIterable.getData().length), paramIterable.getFileName() }));
          }
          else
          {
            i++;
            mChannel.enqueue(paramIterable, "groupErrors", 1);
          }
        }
        else
        {
          AppCenterLog.warn("AppCenterCrashes", "Skipping null ErrorAttachmentLog.");
        }
      }
      if (i > 2) {
        AppCenterLog.warn("AppCenterCrashes", "A limit of 2 attachments per error report might be enforced by server.");
      }
    }
  }
  
  public static AppCenterFuture<Void> setEnabled(boolean paramBoolean)
  {
    return getInstance().setInstanceEnabledAsync(paramBoolean);
  }
  
  public static void setListener(CrashesListener paramCrashesListener)
  {
    getInstance().setInstanceListener(paramCrashesListener);
  }
  
  public static void trackError(Throwable paramThrowable)
  {
    trackError(paramThrowable, null, null);
  }
  
  public static void trackError(Throwable paramThrowable, Map<String, String> paramMap, Iterable<ErrorAttachmentLog> paramIterable)
  {
    getInstance().queueException(paramThrowable, paramMap, paramIterable);
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
    try
    {
      initialize();
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = new com/microsoft/appcenter/crashes/Crashes$5;
        ((5)localObject1).<init>(this);
        mMemoryWarningListener = ((ComponentCallbacks2)localObject1);
        mContext.registerComponentCallbacks((ComponentCallbacks)localObject1);
      }
      else
      {
        localObject1 = ErrorLogHelper.getErrorStorageDirectory().listFiles();
        if (localObject1 != null)
        {
          int i = localObject1.length;
          for (int j = 0; j < i; j++)
          {
            Object localObject3 = localObject1[j];
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>();
            localStringBuilder.append("Deleting file ");
            localStringBuilder.append(localObject3);
            AppCenterLog.debug("AppCenterCrashes", localStringBuilder.toString());
            if (!((File)localObject3).delete())
            {
              localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append("Failed to delete file ");
              localStringBuilder.append(localObject3);
              AppCenterLog.warn("AppCenterCrashes", localStringBuilder.toString());
            }
          }
        }
        AppCenterLog.info("AppCenterCrashes", "Deleted crashes local files");
        mErrorReportCache.clear();
        mLastSessionErrorReport = null;
        mContext.unregisterComponentCallbacks(mMemoryWarningListener);
        mMemoryWarningListener = null;
        SharedPreferencesManager.remove("com.microsoft.appcenter.crashes.memory");
      }
      return;
    }
    finally {}
  }
  
  public ErrorReport buildErrorReport(ManagedErrorLog paramManagedErrorLog)
  {
    UUID localUUID = paramManagedErrorLog.getId();
    if (mErrorReportCache.containsKey(localUUID))
    {
      localObject = ErrorLogReport.access$1300((ErrorLogReport)mErrorReportCache.get(localUUID));
      ((ErrorReport)localObject).setDevice(paramManagedErrorLog.getDevice());
      return (ErrorReport)localObject;
    }
    Object localObject = ErrorLogHelper.getStoredThrowableFile(localUUID);
    if (localObject != null)
    {
      if (((File)localObject).length() > 0L) {
        localObject = FileManager.read((File)localObject);
      } else {
        localObject = null;
      }
      localObject = ErrorLogHelper.getErrorReportFromErrorLog(paramManagedErrorLog, (String)localObject);
      mErrorReportCache.put(localUUID, new ErrorLogReport(paramManagedErrorLog, (ErrorReport)localObject, null));
      return (ErrorReport)localObject;
    }
    return null;
  }
  
  public Channel.GroupListener getChannelListener()
  {
    new Channel.GroupListener()
    {
      private void processCallback(final com.microsoft.appcenter.ingestion.models.Log paramAnonymousLog, final Crashes.CallbackProcessor paramAnonymousCallbackProcessor)
      {
        Crashes.access$600(Crashes.this, new Runnable()
        {
          public void run()
          {
            Object localObject1 = paramAnonymousLog;
            if ((localObject1 instanceof ManagedErrorLog))
            {
              localObject1 = (ManagedErrorLog)localObject1;
              final Object localObject2 = buildErrorReport((ManagedErrorLog)localObject1);
              localObject1 = ((AbstractErrorLog)localObject1).getId();
              if (localObject2 != null)
              {
                if (paramAnonymousCallbackProcessor.shouldDeleteThrowable()) {
                  Crashes.access$500(Crashes.this, (UUID)localObject1);
                }
                HandlerUtils.runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    val$callbackProcessor.onCallBack(localObject2);
                  }
                });
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Cannot find crash report for the error log: ");
                ((StringBuilder)localObject2).append(localObject1);
                AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)localObject2).toString());
              }
            }
            else if ((!(localObject1 instanceof ErrorAttachmentLog)) && (!(localObject1 instanceof HandledErrorLog)))
            {
              localObject1 = a.a("A different type of log comes to crashes: ");
              ((StringBuilder)localObject1).append(paramAnonymousLog.getClass().getName());
              AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)localObject1).toString());
            }
          }
        });
      }
      
      public void onBeforeSending(com.microsoft.appcenter.ingestion.models.Log paramAnonymousLog)
      {
        processCallback(paramAnonymousLog, new Crashes.CallbackProcessor()
        {
          public void onCallBack(ErrorReport paramAnonymous2ErrorReport)
          {
            Crashes.access$700(Crashes.this).onBeforeSending(paramAnonymous2ErrorReport);
          }
          
          public boolean shouldDeleteThrowable()
          {
            return false;
          }
        });
      }
      
      public void onFailure(com.microsoft.appcenter.ingestion.models.Log paramAnonymousLog, final Exception paramAnonymousException)
      {
        processCallback(paramAnonymousLog, new Crashes.CallbackProcessor()
        {
          public void onCallBack(ErrorReport paramAnonymous2ErrorReport)
          {
            Crashes.access$700(Crashes.this).onSendingFailed(paramAnonymous2ErrorReport, paramAnonymousException);
          }
          
          public boolean shouldDeleteThrowable()
          {
            return true;
          }
        });
      }
      
      public void onSuccess(com.microsoft.appcenter.ingestion.models.Log paramAnonymousLog)
      {
        processCallback(paramAnonymousLog, new Crashes.CallbackProcessor()
        {
          public void onCallBack(ErrorReport paramAnonymous2ErrorReport)
          {
            Crashes.access$700(Crashes.this).onSendingSucceeded(paramAnonymous2ErrorReport);
          }
          
          public boolean shouldDeleteThrowable()
          {
            return true;
          }
        });
      }
    };
  }
  
  public Device getDeviceInfo(Context paramContext)
  {
    try
    {
      if (mDevice == null) {
        mDevice = DeviceInfoHelper.getDeviceInfo(paramContext);
      }
      paramContext = mDevice;
      return paramContext;
    }
    finally {}
  }
  
  public String getGroupName()
  {
    return "groupErrors";
  }
  
  public long getInitializeTimestamp()
  {
    try
    {
      long l = mInitializeTimestamp;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public CrashesListener getInstanceListener()
  {
    return mCrashesListener;
  }
  
  public Map<String, LogFactory> getLogFactories()
  {
    return mFactories;
  }
  
  public String getLoggerTag()
  {
    return "AppCenterCrashes";
  }
  
  public String getServiceName()
  {
    return "Crashes";
  }
  
  public int getTriggerCount()
  {
    return 1;
  }
  
  public UncaughtExceptionHandler getUncaughtExceptionHandler()
  {
    return mUncaughtExceptionHandler;
  }
  
  public AppCenterFuture<Collection<ErrorReport>> getUnprocessedErrorReports()
  {
    final DefaultAppCenterFuture localDefaultAppCenterFuture = new DefaultAppCenterFuture();
    postAsyncGetter(new Runnable()
    {
      public void run()
      {
        ArrayList localArrayList = new ArrayList(Crashes.access$1000(Crashes.this).size());
        Iterator localIterator = Crashes.access$1000(Crashes.this).values().iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Crashes.ErrorLogReport.access$1300((Crashes.ErrorLogReport)localIterator.next()));
        }
        localDefaultAppCenterFuture.complete(localArrayList);
      }
    }, localDefaultAppCenterFuture, Collections.emptyList());
    return localDefaultAppCenterFuture;
  }
  
  public void onStarted(Context paramContext, Channel paramChannel, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      mContext = paramContext;
      if (!isInstanceEnabled())
      {
        ErrorLogHelper.removeMinidumpFolder();
        AppCenterLog.debug("AppCenterCrashes", "Clean up minidump folder.");
      }
      super.onStarted(paramContext, paramChannel, paramString1, paramString2, paramBoolean);
      if (isInstanceEnabled()) {
        processPendingErrors();
      }
      return;
    }
    finally {}
  }
  
  public UUID queueException(com.microsoft.appcenter.crashes.ingestion.models.Exception paramException, Map<String, String> paramMap, Iterable<ErrorAttachmentLog> paramIterable)
  {
    try
    {
      ExceptionModelBuilder local8 = new com/microsoft/appcenter/crashes/Crashes$8;
      local8.<init>(this, paramException);
      paramException = queueException(local8, paramMap, paramIterable);
      return paramException;
    }
    finally
    {
      paramException = finally;
      throw paramException;
    }
  }
  
  public UUID saveUncaughtException(Thread paramThread, Throwable paramThrowable, com.microsoft.appcenter.crashes.ingestion.models.Exception paramException)
  {
    if (!((Boolean)isEnabled().get()).booleanValue()) {
      return null;
    }
    if (mSavedUncaughtException) {
      return null;
    }
    mSavedUncaughtException = true;
    return saveErrorLogFiles(paramThrowable, ErrorLogHelper.createErrorLog(mContext, paramThread, paramException, Thread.getAllStackTraces(), mInitializeTimestamp, true));
  }
  
  public void saveUncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      saveUncaughtException(paramThread, paramThrowable, ErrorLogHelper.getModelExceptionFromThrowable(paramThrowable));
    }
    catch (IOException paramThread)
    {
      AppCenterLog.error("AppCenterCrashes", "Error writing error log to file", paramThread);
    }
    catch (JSONException paramThread)
    {
      AppCenterLog.error("AppCenterCrashes", "Error serializing error log to JSON", paramThread);
    }
  }
  
  public AppCenterFuture<Boolean> sendCrashReportsOrAwaitUserConfirmation(final Collection<String> paramCollection)
  {
    final DefaultAppCenterFuture localDefaultAppCenterFuture = new DefaultAppCenterFuture();
    postAsyncGetter(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = Crashes.access$1000(Crashes.this).entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (Map.Entry)localIterator.next();
          Object localObject2 = (UUID)((Map.Entry)localObject1).getKey();
          localObject1 = Crashes.ErrorLogReport.access$1300((Crashes.ErrorLogReport)((Map.Entry)localObject1).getValue()).getId();
          Object localObject3 = paramCollection;
          if ((localObject3 != null) && (((Collection)localObject3).contains(localObject1)))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("CrashesListener.shouldProcess returned true, continue processing log: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("CrashesListener.shouldProcess returned false, clean up and ignore log: ");
            ((StringBuilder)localObject3).append((String)localObject1);
            AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject3).toString());
            Crashes.access$1500(Crashes.this, (UUID)localObject2);
            localIterator.remove();
          }
        }
        localDefaultAppCenterFuture.complete(Boolean.valueOf(Crashes.access$1800(Crashes.this)));
      }
    }, localDefaultAppCenterFuture, Boolean.valueOf(false));
    return localDefaultAppCenterFuture;
  }
  
  public void sendErrorAttachments(final String paramString, final Iterable<ErrorAttachmentLog> paramIterable)
  {
    post(new Runnable()
    {
      public void run()
      {
        try
        {
          UUID localUUID = UUID.fromString(paramString);
          Crashes.access$900(Crashes.this, localUUID, paramIterable);
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          AppCenterLog.error("AppCenterCrashes", "Error report identifier has an invalid format for sending attachments.");
        }
      }
    });
  }
  
  public void setAutomaticProcessing(boolean paramBoolean)
  {
    mAutomaticProcessing = paramBoolean;
  }
  
  public void setInstanceListener(CrashesListener paramCrashesListener)
  {
    CrashesListener localCrashesListener = paramCrashesListener;
    if (paramCrashesListener == null) {}
    try
    {
      localCrashesListener = DEFAULT_ERROR_REPORTING_LISTENER;
      mCrashesListener = localCrashesListener;
      return;
    }
    finally {}
  }
  
  public void setLogSerializer(LogSerializer paramLogSerializer)
  {
    mLogSerializer = paramLogSerializer;
  }
  
  public void setUncaughtExceptionHandler(UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    mUncaughtExceptionHandler = paramUncaughtExceptionHandler;
  }
  
  public static abstract interface CallbackProcessor
  {
    public abstract void onCallBack(ErrorReport paramErrorReport);
    
    public abstract boolean shouldDeleteThrowable();
  }
  
  public static class DefaultCrashesListener
    extends AbstractCrashesListener
  {}
  
  public static class ErrorLogReport
  {
    public final ManagedErrorLog log;
    public final ErrorReport report;
    
    public ErrorLogReport(ManagedErrorLog paramManagedErrorLog, ErrorReport paramErrorReport)
    {
      log = paramManagedErrorLog;
      report = paramErrorReport;
    }
  }
  
  public static abstract interface ExceptionModelBuilder
  {
    public abstract com.microsoft.appcenter.crashes.ingestion.models.Exception buildExceptionModel();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */