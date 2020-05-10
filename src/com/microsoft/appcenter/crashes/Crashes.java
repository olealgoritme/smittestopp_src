package com.microsoft.appcenter.crashes;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.util.Log;
import com.microsoft.appcenter.AbstractAppCenterService;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.Channel.GroupListener;
import com.microsoft.appcenter.crashes.ingestion.models.AbstractErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
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
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

public class Crashes
  extends AbstractAppCenterService
{
  public static final int ALWAYS_SEND = 2;
  public static final CrashesListener DEFAULT_ERROR_REPORTING_LISTENER = new Crashes.DefaultCrashesListener(null);
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
  public final Map<UUID, Crashes.ErrorLogReport> mErrorReportCache;
  public final Map<String, LogFactory> mFactories;
  public boolean mHasReceivedMemoryWarningInLastSession;
  public long mInitializeTimestamp;
  public ErrorReport mLastSessionErrorReport;
  public LogSerializer mLogSerializer;
  public ComponentCallbacks2 mMemoryWarningListener;
  public boolean mSavedUncaughtException;
  public UncaughtExceptionHandler mUncaughtExceptionHandler;
  public final Map<UUID, Crashes.ErrorLogReport> mUnprocessedErrorReports;
  
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
      Crashes.4 local4 = new com/microsoft/appcenter/crashes/Crashes$4;
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
      Crashes.1 local1 = new com/microsoft/appcenter/crashes/Crashes$1;
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
      Crashes.12 local12 = new com/microsoft/appcenter/crashes/Crashes$12;
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
      Crashes.2 local2 = new com/microsoft/appcenter/crashes/Crashes$2;
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
      Crashes.3 local3 = new com/microsoft/appcenter/crashes/Crashes$3;
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
    for (localObject2 : ) {
      if (!((File)localObject2).isDirectory())
      {
        AppCenterLog.debug("AppCenterCrashes", "Found a minidump from a previous SDK version.");
        processSingleMinidump((File)localObject2, (File)localObject2);
      }
      else
      {
        File[] arrayOfFile = ((File)localObject2).listFiles(new Crashes.10(this));
        if ((arrayOfFile != null) && (arrayOfFile.length != 0))
        {
          int k = arrayOfFile.length;
          for (int m = 0; m < k; m++) {
            processSingleMinidump(arrayOfFile[m], (File)localObject2);
          }
        }
      }
    }
    for (Object localObject2 = ErrorLogHelper.getLastErrorLogFile(); (localObject2 != null) && (((File)localObject2).length() == 0L); localObject2 = ErrorLogHelper.getLastErrorLogFile())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Deleting empty error file: ");
      ((StringBuilder)???).append(localObject2);
      AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)???).toString());
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
          Object localObject2 = (ManagedErrorLog)mLogSerializer.deserializeLog((String)localObject1, null);
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
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Error parsing error log. Deleting invalid file: ");
          ((StringBuilder)localObject1).append(localFile);
          AppCenterLog.error("AppCenterCrashes", ((StringBuilder)localObject1).toString(), localJSONException);
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
  
  private UUID queueException(Crashes.ExceptionModelBuilder paramExceptionModelBuilder, Map<String, String> paramMap, Iterable<ErrorAttachmentLog> paramIterable)
  {
    try
    {
      String str = UserIdContext.getInstance().getUserId();
      UUID localUUID = UUID.randomUUID();
      paramMap = ErrorLogHelper.validateProperties(paramMap, "HandledError");
      Crashes.9 local9 = new com/microsoft/appcenter/crashes/Crashes$9;
      local9.<init>(this, localUUID, str, paramExceptionModelBuilder, paramMap, paramIterable);
      post(local9);
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
      Crashes.7 local7 = new com/microsoft/appcenter/crashes/Crashes$7;
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
    File localFile = ErrorLogHelper.getErrorStorageDirectory();
    UUID localUUID = paramManagedErrorLog.getId();
    Object localObject1 = localUUID.toString();
    AppCenterLog.debug("AppCenterCrashes", "Saving uncaught exception.");
    Object localObject2 = new File(localFile, a.b((String)localObject1, ".json"));
    FileManager.write((File)localObject2, mLogSerializer.serializeLog(paramManagedErrorLog));
    paramManagedErrorLog = new StringBuilder();
    paramManagedErrorLog.append("Saved JSON content for ingestion into ");
    paramManagedErrorLog.append(localObject2);
    AppCenterLog.debug("AppCenterCrashes", paramManagedErrorLog.toString());
    localObject1 = new File(localFile, a.b((String)localObject1, ".throwable"));
    paramManagedErrorLog = paramThrowable;
    if (paramThrowable != null) {
      try
      {
        paramManagedErrorLog = Log.getStackTraceString(paramThrowable);
        FileManager.write((File)localObject1, paramManagedErrorLog);
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("Saved stack trace as is for client side inspection in ");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" stack trace:");
        ((StringBuilder)localObject2).append(paramManagedErrorLog);
        AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject2).toString());
        paramManagedErrorLog = paramThrowable;
      }
      catch (StackOverflowError paramThrowable)
      {
        AppCenterLog.error("AppCenterCrashes", "Failed to store stack trace.", paramThrowable);
        paramManagedErrorLog = null;
        ((File)localObject1).delete();
      }
    }
    if (paramManagedErrorLog == null) {
      if (((File)localObject1).createNewFile())
      {
        paramThrowable = new StringBuilder();
        paramThrowable.append("Saved empty Throwable file in ");
        paramThrowable.append(localObject1);
        AppCenterLog.debug("AppCenterCrashes", paramThrowable.toString());
      }
      else
      {
        throw new IOException(((File)localObject1).getName());
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
    boolean bool = SharedPreferencesManager.getBoolean("com.microsoft.appcenter.crashes.always.send", false);
    HandlerUtils.runOnUiThread(new Crashes.11(this, bool));
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
      paramIterable = paramIterable.iterator();
      int i = 0;
      while (paramIterable.hasNext())
      {
        ErrorAttachmentLog localErrorAttachmentLog = (ErrorAttachmentLog)paramIterable.next();
        if (localErrorAttachmentLog != null)
        {
          localErrorAttachmentLog.setId(UUID.randomUUID());
          localErrorAttachmentLog.setErrorId(paramUUID);
          if (!localErrorAttachmentLog.isValid())
          {
            AppCenterLog.error("AppCenterCrashes", "Not all required fields are present in ErrorAttachmentLog.");
          }
          else if (localErrorAttachmentLog.getData().length > 7340032)
          {
            AppCenterLog.error("AppCenterCrashes", String.format(Locale.ENGLISH, "Discarding attachment with size above %d bytes: size=%d, fileName=%s.", new Object[] { Integer.valueOf(7340032), Integer.valueOf(localErrorAttachmentLog.getData().length), localErrorAttachmentLog.getFileName() }));
          }
          else
          {
            i++;
            mChannel.enqueue(localErrorAttachmentLog, "groupErrors", 1);
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
        ((Crashes.5)localObject1).<init>(this);
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
      localObject = Crashes.ErrorLogReport.access$1300((Crashes.ErrorLogReport)mErrorReportCache.get(localUUID));
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
      mErrorReportCache.put(localUUID, new Crashes.ErrorLogReport(paramManagedErrorLog, (ErrorReport)localObject, null));
      return (ErrorReport)localObject;
    }
    return null;
  }
  
  public Channel.GroupListener getChannelListener()
  {
    return new Crashes.6(this);
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
    DefaultAppCenterFuture localDefaultAppCenterFuture = new DefaultAppCenterFuture();
    postAsyncGetter(new Crashes.13(this, localDefaultAppCenterFuture), localDefaultAppCenterFuture, Collections.emptyList());
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
      Crashes.8 local8 = new com/microsoft/appcenter/crashes/Crashes$8;
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
  
  public AppCenterFuture<Boolean> sendCrashReportsOrAwaitUserConfirmation(Collection<String> paramCollection)
  {
    DefaultAppCenterFuture localDefaultAppCenterFuture = new DefaultAppCenterFuture();
    postAsyncGetter(new Crashes.14(this, paramCollection, localDefaultAppCenterFuture), localDefaultAppCenterFuture, Boolean.valueOf(false));
    return localDefaultAppCenterFuture;
  }
  
  public void sendErrorAttachments(String paramString, Iterable<ErrorAttachmentLog> paramIterable)
  {
    post(new Crashes.15(this, paramString, paramIterable));
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */