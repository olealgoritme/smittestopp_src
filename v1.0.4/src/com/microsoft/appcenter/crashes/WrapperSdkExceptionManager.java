package com.microsoft.appcenter.crashes;

import android.content.Context;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper.DeviceInfoException;
import com.microsoft.appcenter.utils.async.AppCenterFuture;
import com.microsoft.appcenter.utils.storage.FileManager;
import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WrapperSdkExceptionManager
{
  public static final String DATA_FILE_EXTENSION = ".dat";
  public static final Map<String, String> sWrapperExceptionDataContainer = new HashMap();
  
  public static ErrorReport buildHandledErrorReport(Context paramContext, String paramString)
  {
    ErrorReport localErrorReport = new ErrorReport();
    localErrorReport.setId(paramString);
    localErrorReport.setAppErrorTime(new Date());
    localErrorReport.setAppStartTime(new Date(Crashes.getInstance().getInitializeTimestamp()));
    try
    {
      localErrorReport.setDevice(Crashes.getInstance().getDeviceInfo(paramContext));
    }
    catch (DeviceInfoHelper.DeviceInfoException paramContext)
    {
      paramContext = new StringBuilder();
      paramContext.append("Handled error report cannot get device info, errorReportId=");
      paramContext.append(paramString);
      AppCenterLog.warn("AppCenterCrashes", paramContext.toString());
    }
    return localErrorReport;
  }
  
  public static void deleteWrapperExceptionData(UUID paramUUID)
  {
    if (paramUUID == null)
    {
      AppCenterLog.error("AppCenterCrashes", "Failed to delete wrapper exception data: null errorId");
      return;
    }
    File localFile = getFile(paramUUID);
    if (localFile.exists())
    {
      if (loadWrapperExceptionData(paramUUID) == null) {
        AppCenterLog.error("AppCenterCrashes", "Failed to load wrapper exception data.");
      }
      FileManager.delete(localFile);
    }
  }
  
  public static File getFile(UUID paramUUID)
  {
    File localFile = ErrorLogHelper.getErrorStorageDirectory();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUUID.toString());
    localStringBuilder.append(".dat");
    return new File(localFile, localStringBuilder.toString());
  }
  
  public static AppCenterFuture<Collection<ErrorReport>> getUnprocessedErrorReports()
  {
    return Crashes.getInstance().getUnprocessedErrorReports();
  }
  
  public static String loadWrapperExceptionData(UUID paramUUID)
  {
    Object localObject1 = null;
    if (paramUUID == null)
    {
      AppCenterLog.error("AppCenterCrashes", "Failed to load wrapper exception data: null errorId");
      return null;
    }
    Object localObject2 = (String)sWrapperExceptionDataContainer.get(paramUUID.toString());
    if (localObject2 != null) {
      return (String)localObject2;
    }
    localObject2 = getFile(paramUUID);
    if (((File)localObject2).exists())
    {
      localObject2 = FileManager.read((File)localObject2);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        sWrapperExceptionDataContainer.put(paramUUID.toString(), localObject2);
        localObject1 = localObject2;
      }
    }
    return (String)localObject1;
  }
  
  public static UUID saveWrapperException(Thread paramThread, Throwable paramThrowable, com.microsoft.appcenter.crashes.ingestion.models.Exception paramException, String paramString)
  {
    try
    {
      paramThrowable = Crashes.getInstance().saveUncaughtException(paramThread, paramThrowable, paramException);
      if ((paramThrowable != null) && (paramString != null))
      {
        sWrapperExceptionDataContainer.put(paramThrowable.toString(), paramString);
        paramThread = getFile(paramThrowable);
        FileManager.write(paramThread, paramString);
        paramException = new java/lang/StringBuilder;
        paramException.<init>();
        paramException.append("Saved raw wrapper exception data into ");
        paramException.append(paramThread);
        AppCenterLog.debug("AppCenterCrashes", paramException.toString());
      }
      return paramThrowable;
    }
    catch (Exception paramThread)
    {
      AppCenterLog.error("AppCenterCrashes", "Failed to save wrapper exception data to file", paramThread);
    }
    return null;
  }
  
  public static AppCenterFuture<Boolean> sendCrashReportsOrAwaitUserConfirmation(Collection<String> paramCollection)
  {
    return Crashes.getInstance().sendCrashReportsOrAwaitUserConfirmation(paramCollection);
  }
  
  public static void sendErrorAttachments(String paramString, Iterable<ErrorAttachmentLog> paramIterable)
  {
    Crashes.getInstance().sendErrorAttachments(paramString, paramIterable);
  }
  
  public static void setAutomaticProcessing(boolean paramBoolean)
  {
    Crashes.getInstance().setAutomaticProcessing(paramBoolean);
  }
  
  public static String trackException(com.microsoft.appcenter.crashes.ingestion.models.Exception paramException, Map<String, String> paramMap, Iterable<ErrorAttachmentLog> paramIterable)
  {
    return Crashes.getInstance().queueException(paramException, paramMap, paramIterable).toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.WrapperSdkExceptionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */