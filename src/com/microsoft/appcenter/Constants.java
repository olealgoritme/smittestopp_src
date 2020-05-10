package com.microsoft.appcenter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.io.File;

public class Constants
{
  public static boolean APPLICATION_DEBUGGABLE = false;
  public static final String APP_SECRET = "App-Secret";
  public static final String AUTHORIZATION_HEADER = "Authorization";
  public static final String COMMON_SCHEMA_PREFIX_SEPARATOR = ":";
  public static final String DATABASE = "com.microsoft.appcenter.documents";
  public static final int DEFAULT_TRIGGER_COUNT = 50;
  public static final int DEFAULT_TRIGGER_INTERVAL = 3000;
  public static final int DEFAULT_TRIGGER_MAX_PARALLEL_REQUESTS = 3;
  public static String FILES_PATH;
  public static final String READONLY_TABLE = "app_documents";
  public static final String USER_TABLE_FORMAT = "user_%s_documents";
  public static final String WRAPPER_SDK_NAME_NDK = "appcenter.ndk";
  
  public static void loadFilesPath(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        FILES_PATH = paramContext.getFilesDir().getAbsolutePath();
      }
      catch (Exception paramContext)
      {
        AppCenterLog.error("AppCenter", "Exception thrown when accessing the application filesystem", paramContext);
      }
    }
  }
  
  public static void loadFromContext(Context paramContext)
  {
    loadFilesPath(paramContext);
    setDebuggableFlag(paramContext);
  }
  
  public static void setDebuggableFlag(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationInfo() != null))
    {
      boolean bool;
      if ((getApplicationInfoflags & 0x2) > 0) {
        bool = true;
      } else {
        bool = false;
      }
      APPLICATION_DEBUGGABLE = bool;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.Constants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */