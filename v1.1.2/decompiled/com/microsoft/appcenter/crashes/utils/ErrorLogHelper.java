package com.microsoft.appcenter.crashes.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.crashes.ingestion.models.AbstractErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.WrapperSdk;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.DeviceInfoHelper.DeviceInfoException;
import com.microsoft.appcenter.utils.context.UserIdContext;
import com.microsoft.appcenter.utils.storage.FileManager;
import e.a.a.a.a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ErrorLogHelper
{
  public static final int CAUSE_LIMIT = 16;
  public static final int CAUSE_LIMIT_HALF = 8;
  public static final String DEVICE_INFO_FILE = "deviceInfo";
  public static final String ERROR_DIRECTORY = "error";
  public static final String ERROR_LOG_FILE_EXTENSION = ".json";
  public static final int FRAME_LIMIT = 256;
  public static final int FRAME_LIMIT_HALF = 128;
  public static final int MAX_PROPERTY_COUNT = 20;
  public static final int MAX_PROPERTY_ITEM_LENGTH = 125;
  public static final String MINIDUMP_DIRECTORY = "minidump";
  public static final String NEW_MINIDUMP_DIRECTORY = "new";
  public static final String PENDING_MINIDUMP_DIRECTORY = "pending";
  public static final String THROWABLE_FILE_EXTENSION = ".throwable";
  public static File sErrorLogDirectory;
  public static File sNewMinidumpDirectory;
  public static File sPendingMinidumpDirectory;
  
  public static void clearStaticState()
  {
    sNewMinidumpDirectory = null;
    sErrorLogDirectory = null;
    sPendingMinidumpDirectory = null;
  }
  
  public static ManagedErrorLog createErrorLog(Context paramContext, Thread paramThread, Exception paramException, Map<Thread, StackTraceElement[]> paramMap, long paramLong, boolean paramBoolean)
  {
    ManagedErrorLog localManagedErrorLog = new ManagedErrorLog();
    localManagedErrorLog.setId(UUID.randomUUID());
    localManagedErrorLog.setTimestamp(new Date());
    localManagedErrorLog.setUserId(UserIdContext.getInstance().getUserId());
    try
    {
      localManagedErrorLog.setDevice(DeviceInfoHelper.getDeviceInfo(paramContext));
    }
    catch (DeviceInfoHelper.DeviceInfoException localDeviceInfoException)
    {
      AppCenterLog.error("AppCenterCrashes", "Could not attach device properties snapshot to error log, will attach at sending time", localDeviceInfoException);
    }
    localManagedErrorLog.setProcessId(Integer.valueOf(Process.myPid()));
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (pid == Process.myPid()) {
            localManagedErrorLog.setProcessName(processName);
          }
        }
      }
    }
    if (localManagedErrorLog.getProcessName() == null) {
      localManagedErrorLog.setProcessName("");
    }
    localManagedErrorLog.setArchitecture(getArchitecture());
    localManagedErrorLog.setErrorThreadId(Long.valueOf(paramThread.getId()));
    localManagedErrorLog.setErrorThreadName(paramThread.getName());
    localManagedErrorLog.setFatal(Boolean.valueOf(paramBoolean));
    localManagedErrorLog.setAppLaunchTimestamp(new Date(paramLong));
    localManagedErrorLog.setException(paramException);
    paramContext = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      paramThread = (Map.Entry)paramMap.next();
      paramException = new com.microsoft.appcenter.crashes.ingestion.models.Thread();
      paramException.setId(((Thread)paramThread.getKey()).getId());
      paramException.setName(((Thread)paramThread.getKey()).getName());
      paramException.setFrames(getModelFramesFromStackTrace((StackTraceElement[])paramThread.getValue()));
      paramContext.add(paramException);
    }
    localManagedErrorLog.setThreads(paramContext);
    return localManagedErrorLog;
  }
  
  public static ManagedErrorLog createErrorLog(Context paramContext, Thread paramThread, Throwable paramThrowable, Map<Thread, StackTraceElement[]> paramMap, long paramLong)
  {
    return createErrorLog(paramContext, paramThread, getModelExceptionFromThrowable(paramThrowable), paramMap, paramLong, true);
  }
  
  @TargetApi(21)
  public static String getArchitecture()
  {
    return android.os.Build.SUPPORTED_ABIS[0];
  }
  
  public static ErrorReport getErrorReportFromErrorLog(ManagedErrorLog paramManagedErrorLog, String paramString)
  {
    ErrorReport localErrorReport = new ErrorReport();
    localErrorReport.setId(paramManagedErrorLog.getId().toString());
    localErrorReport.setThreadName(paramManagedErrorLog.getErrorThreadName());
    localErrorReport.setStackTrace(paramString);
    localErrorReport.setAppStartTime(paramManagedErrorLog.getAppLaunchTimestamp());
    localErrorReport.setAppErrorTime(paramManagedErrorLog.getTimestamp());
    localErrorReport.setDevice(paramManagedErrorLog.getDevice());
    return localErrorReport;
  }
  
  public static File getErrorStorageDirectory()
  {
    try
    {
      if (sErrorLogDirectory == null)
      {
        localFile = new java/io/File;
        localFile.<init>(Constants.FILES_PATH, "error");
        sErrorLogDirectory = localFile;
        FileManager.mkdir(localFile.getAbsolutePath());
      }
      File localFile = sErrorLogDirectory;
      return localFile;
    }
    finally {}
  }
  
  public static File getLastErrorLogFile()
  {
    FileManager.lastModifiedFile(getErrorStorageDirectory(), new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(".json");
      }
    });
  }
  
  public static Exception getModelExceptionFromThrowable(Throwable paramThrowable)
  {
    Object localObject = new LinkedList();
    while (paramThrowable != null)
    {
      ((LinkedList)localObject).add(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    }
    if (((LinkedList)localObject).size() > 16)
    {
      paramThrowable = a.a("Crash causes truncated from ");
      paramThrowable.append(((LinkedList)localObject).size());
      paramThrowable.append(" to ");
      paramThrowable.append(16);
      paramThrowable.append(" causes.");
      AppCenterLog.warn("AppCenterCrashes", paramThrowable.toString());
      ((AbstractList)localObject).subList(8, ((LinkedList)localObject).size() - 8).clear();
    }
    Iterator localIterator = ((AbstractSequentialList)localObject).iterator();
    localObject = null;
    for (Throwable localThrowable1 = null; localIterator.hasNext(); localThrowable1 = paramThrowable)
    {
      Throwable localThrowable2 = (Throwable)localIterator.next();
      paramThrowable = new Exception();
      paramThrowable.setType(localThrowable2.getClass().getName());
      paramThrowable.setMessage(localThrowable2.getMessage());
      paramThrowable.setFrames(getModelFramesFromStackTrace(localThrowable2));
      if (localObject == null) {
        localObject = paramThrowable;
      } else {
        localThrowable1.setInnerExceptions(Collections.singletonList(paramThrowable));
      }
    }
    return (Exception)localObject;
  }
  
  public static List<StackFrame> getModelFramesFromStackTrace(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement1 = paramThrowable.getStackTrace();
    StackTraceElement[] arrayOfStackTraceElement2 = arrayOfStackTraceElement1;
    if (arrayOfStackTraceElement1.length > 256)
    {
      arrayOfStackTraceElement2 = new StackTraceElement['Ā'];
      System.arraycopy(arrayOfStackTraceElement1, 0, arrayOfStackTraceElement2, 0, 128);
      System.arraycopy(arrayOfStackTraceElement1, arrayOfStackTraceElement1.length - 128, arrayOfStackTraceElement2, 128, 128);
      paramThrowable.setStackTrace(arrayOfStackTraceElement2);
      paramThrowable = a.a("Crash frames truncated from ");
      paramThrowable.append(arrayOfStackTraceElement1.length);
      paramThrowable.append(" to ");
      paramThrowable.append(256);
      paramThrowable.append(" frames.");
      AppCenterLog.warn("AppCenterCrashes", paramThrowable.toString());
    }
    return getModelFramesFromStackTrace(arrayOfStackTraceElement2);
  }
  
  public static List<StackFrame> getModelFramesFromStackTrace(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(getModelStackFrame(paramArrayOfStackTraceElement[j]));
    }
    return localArrayList;
  }
  
  public static StackFrame getModelStackFrame(StackTraceElement paramStackTraceElement)
  {
    StackFrame localStackFrame = new StackFrame();
    localStackFrame.setClassName(paramStackTraceElement.getClassName());
    localStackFrame.setMethodName(paramStackTraceElement.getMethodName());
    localStackFrame.setLineNumber(Integer.valueOf(paramStackTraceElement.getLineNumber()));
    localStackFrame.setFileName(paramStackTraceElement.getFileName());
    return localStackFrame;
  }
  
  public static File getNewMinidumpDirectory()
  {
    try
    {
      File localFile1 = getErrorStorageDirectory();
      File localFile2 = new java/io/File;
      localFile2.<init>(localFile1.getAbsolutePath(), "minidump");
      localFile2 = new File(localFile2, "new");
      return localFile2;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static File[] getNewMinidumpFiles()
  {
    File[] arrayOfFile = getNewMinidumpDirectory().listFiles();
    if (arrayOfFile == null) {
      arrayOfFile = new File[0];
    }
    return arrayOfFile;
  }
  
  public static File getNewMinidumpSubfolder()
  {
    try
    {
      if (sNewMinidumpDirectory == null)
      {
        localFile1 = getNewMinidumpDirectory();
        File localFile2 = new java/io/File;
        localFile2.<init>(localFile1, UUID.randomUUID().toString());
        sNewMinidumpDirectory = localFile2;
        FileManager.mkdir(localFile2.getPath());
      }
      File localFile1 = sNewMinidumpDirectory;
      return localFile1;
    }
    finally {}
  }
  
  public static File getNewMinidumpSubfolderWithContextData(Context paramContext)
  {
    try
    {
      File localFile1 = getNewMinidumpSubfolder();
      File localFile2 = new java/io/File;
      localFile2.<init>(localFile1, "deviceInfo");
      try
      {
        paramContext = DeviceInfoHelper.getDeviceInfo(paramContext);
        paramContext.setWrapperSdkName("appcenter.ndk");
        JSONStringer localJSONStringer = new org/json/JSONStringer;
        localJSONStringer.<init>();
        localJSONStringer.object();
        paramContext.write(localJSONStringer);
        localJSONStringer.endObject();
        FileManager.write(localFile2, localJSONStringer.toString());
      }
      catch (JSONException paramContext) {}catch (IOException paramContext) {}catch (DeviceInfoHelper.DeviceInfoException paramContext) {}
      AppCenterLog.error("AppCenterCrashes", "Failed to store device info in a minidump folder.", paramContext);
      localFile2.delete();
      return localFile1;
    }
    finally {}
  }
  
  public static File getPendingMinidumpDirectory()
  {
    try
    {
      if (sPendingMinidumpDirectory == null)
      {
        File localFile1 = getErrorStorageDirectory();
        localFile2 = new java/io/File;
        localFile2.<init>(localFile1.getAbsolutePath(), "minidump");
        localFile1 = new java/io/File;
        localFile1.<init>(localFile2, "pending");
        sPendingMinidumpDirectory = localFile1;
        FileManager.mkdir(localFile1.getPath());
      }
      File localFile2 = sPendingMinidumpDirectory;
      return localFile2;
    }
    finally {}
  }
  
  public static Device getStoredDeviceInfo(File paramFile)
  {
    paramFile = paramFile.listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.equals("deviceInfo");
      }
    });
    if ((paramFile != null) && (paramFile.length != 0))
    {
      paramFile = FileManager.read(paramFile[0]);
      if (paramFile == null)
      {
        AppCenterLog.error("AppCenterCrashes", "Failed to read stored device info.");
        return null;
      }
      return parseDevice(paramFile);
    }
    AppCenterLog.warn("AppCenterCrashes", "No stored deviceinfo file found in a minidump folder.");
    return null;
  }
  
  public static File getStoredErrorLogFile(UUID paramUUID)
  {
    return getStoredFile(paramUUID, ".json");
  }
  
  public static File[] getStoredErrorLogFiles()
  {
    File[] arrayOfFile = getErrorStorageDirectory().listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return paramAnonymousString.endsWith(".json");
      }
    });
    if (arrayOfFile == null) {
      arrayOfFile = new File[0];
    }
    return arrayOfFile;
  }
  
  public static File getStoredFile(UUID paramUUID, final String paramString)
  {
    paramUUID = getErrorStorageDirectory().listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        boolean bool;
        if ((paramAnonymousString.startsWith(val$id.toString())) && (paramAnonymousString.endsWith(paramString))) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
    });
    if ((paramUUID != null) && (paramUUID.length > 0)) {
      paramUUID = paramUUID[0];
    } else {
      paramUUID = null;
    }
    return paramUUID;
  }
  
  public static File getStoredThrowableFile(UUID paramUUID)
  {
    return getStoredFile(paramUUID, ".throwable");
  }
  
  public static Device parseDevice(String paramString)
  {
    try
    {
      Device localDevice = new com/microsoft/appcenter/ingestion/models/Device;
      localDevice.<init>();
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      localDevice.read(localJSONObject);
      return localDevice;
    }
    catch (JSONException paramString)
    {
      AppCenterLog.error("AppCenterCrashes", "Failed to deserialize device info.", paramString);
    }
    return null;
  }
  
  public static UUID parseLogFolderUuid(File paramFile)
  {
    if (paramFile.isDirectory()) {
      try
      {
        paramFile = UUID.fromString(paramFile.getName());
      }
      catch (IllegalArgumentException paramFile)
      {
        AppCenterLog.warn("AppCenterCrashes", "Cannot parse minidump folder name to UUID.", paramFile);
      }
    } else {
      paramFile = null;
    }
    Object localObject = paramFile;
    if (paramFile == null) {
      localObject = UUID.randomUUID();
    }
    return (UUID)localObject;
  }
  
  public static void removeMinidumpFolder()
  {
    FileManager.deleteDir(new File(getErrorStorageDirectory().getAbsolutePath(), "minidump"));
  }
  
  public static void removeStaleMinidumpSubfolders()
  {
    File[] arrayOfFile = getNewMinidumpDirectory().listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        if (ErrorLogHelper.access$000() != null) {
          return paramAnonymousString.equals(ErrorLogHelper.access$000().getName()) ^ true;
        }
        return true;
      }
    });
    if ((arrayOfFile != null) && (arrayOfFile.length != 0))
    {
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++) {
        FileManager.deleteDir(arrayOfFile[j]);
      }
      return;
    }
    AppCenterLog.debug("AppCenterCrashes", "No previous minidump sub-folders.");
  }
  
  public static void removeStoredErrorLogFile(UUID paramUUID)
  {
    File localFile = getStoredErrorLogFile(paramUUID);
    if (localFile != null)
    {
      paramUUID = a.a("Deleting error log file ");
      paramUUID.append(localFile.getName());
      AppCenterLog.info("AppCenterCrashes", paramUUID.toString());
      FileManager.delete(localFile);
    }
  }
  
  public static void removeStoredThrowableFile(UUID paramUUID)
  {
    File localFile = getStoredThrowableFile(paramUUID);
    if (localFile != null)
    {
      paramUUID = a.a("Deleting throwable file ");
      paramUUID.append(localFile.getName());
      AppCenterLog.info("AppCenterCrashes", paramUUID.toString());
      FileManager.delete(localFile);
    }
  }
  
  public static void setErrorLogDirectory(File paramFile)
  {
    sErrorLogDirectory = paramFile;
  }
  
  public static Map<String, String> validateProperties(Map<String, String> paramMap, String paramString)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      Object localObject = (String)paramMap.getKey();
      String str = (String)paramMap.getValue();
      if (localHashMap.size() >= 20)
      {
        AppCenterLog.warn("AppCenterCrashes", String.format("%s : properties cannot contain more than %s items. Skipping other properties.", new Object[] { paramString, Integer.valueOf(20) }));
        break;
      }
      if ((localObject != null) && (!((String)localObject).isEmpty()))
      {
        if (str == null)
        {
          AppCenterLog.warn("AppCenterCrashes", String.format("%s : property '%s' : property value cannot be null. Property '%s' will be skipped.", new Object[] { paramString, localObject, localObject }));
        }
        else
        {
          paramMap = (Map<String, String>)localObject;
          if (((String)localObject).length() > 125)
          {
            AppCenterLog.warn("AppCenterCrashes", String.format("%s : property '%s' : property key length cannot be longer than %s characters. Property key will be truncated.", new Object[] { paramString, localObject, Integer.valueOf(125) }));
            paramMap = ((String)localObject).substring(0, 125);
          }
          localObject = str;
          if (str.length() > 125)
          {
            AppCenterLog.warn("AppCenterCrashes", String.format("%s : property '%s' : property value cannot be longer than %s characters. Property value will be truncated.", new Object[] { paramString, paramMap, Integer.valueOf(125) }));
            localObject = str.substring(0, 125);
          }
          localHashMap.put(paramMap, localObject);
        }
      }
      else {
        AppCenterLog.warn("AppCenterCrashes", String.format("%s : a property key cannot be null or empty. Property will be skipped.", new Object[] { paramString }));
      }
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.utils.ErrorLogHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */