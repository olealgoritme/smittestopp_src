package com.microsoft.identity.common.internal.logging;

import android.os.Build.VERSION;
import android.util.Log;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import e.a.a.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Logger
{
  public static final String CUSTOM_LOG_ERROR = "Custom log failed to log message:%s";
  public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final Logger INSTANCE;
  public static boolean sAllowLogcat = false;
  public static boolean sAllowPii;
  public static ExecutorService sLogExecutor = ;
  public ILoggerCallback mExternalLogger;
  public Logger.LogLevel mLogLevel = Logger.LogLevel.VERBOSE;
  
  static
  {
    INSTANCE = new Logger();
    sAllowPii = false;
  }
  
  public static void error(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    getInstance().log(paramString1, Logger.LogLevel.ERROR, paramString2, paramString3, paramThrowable, false);
  }
  
  public static void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    getInstance().log(paramString1, Logger.LogLevel.ERROR, DiagnosticContext.getRequestContext().toJsonString(), paramString2, paramThrowable, false);
  }
  
  public static void errorPII(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    getInstance().log(paramString1, Logger.LogLevel.ERROR, paramString2, paramString3, paramThrowable, true);
  }
  
  public static void errorPII(String paramString1, String paramString2, Throwable paramThrowable)
  {
    getInstance().log(paramString1, Logger.LogLevel.ERROR, DiagnosticContext.getRequestContext().toJsonString(), paramString2, paramThrowable, true);
  }
  
  private String formatMessage(String paramString1, String paramString2, Throwable paramThrowable)
  {
    String str = paramString2;
    if (StringExtensions.isNullOrBlank(paramString2)) {
      str = "N/A";
    }
    StringBuilder localStringBuilder = a.a(" [");
    localStringBuilder.append(getUTCDateTimeAsString());
    boolean bool = StringExtensions.isNullOrBlank(paramString1);
    paramString2 = "] ";
    if (bool) {
      paramString1 = paramString2;
    } else {
      paramString1 = a.a(" - ", paramString1, "] ");
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(str);
    localStringBuilder.append(" Android ");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    if (paramThrowable == null)
    {
      paramString1 = "";
    }
    else
    {
      paramString1 = new StringBuilder();
      paramString1.append('\n');
      paramString1.append(Log.getStackTraceString(paramThrowable));
      paramString1 = paramString1.toString();
    }
    localStringBuilder.append(paramString1);
    return localStringBuilder.toString();
  }
  
  public static boolean getAllowLogcat()
  {
    return sAllowLogcat;
  }
  
  public static boolean getAllowPii()
  {
    return sAllowPii;
  }
  
  public static Logger getInstance()
  {
    return INSTANCE;
  }
  
  public static String getUTCDateTimeAsString()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(new Date());
  }
  
  public static void info(String paramString1, String paramString2)
  {
    getInstance().log(paramString1, Logger.LogLevel.INFO, DiagnosticContext.getRequestContext().toJsonString(), paramString2, null, false);
  }
  
  public static void info(String paramString1, String paramString2, String paramString3)
  {
    getInstance().log(paramString1, Logger.LogLevel.INFO, paramString2, paramString3, null, false);
  }
  
  public static void infoPII(String paramString1, String paramString2)
  {
    getInstance().log(paramString1, Logger.LogLevel.INFO, DiagnosticContext.getRequestContext().toJsonString(), paramString2, null, true);
  }
  
  public static void infoPII(String paramString1, String paramString2, String paramString3)
  {
    getInstance().log(paramString1, Logger.LogLevel.INFO, paramString2, paramString3, null, true);
  }
  
  private void log(String paramString1, Logger.LogLevel paramLogLevel, String paramString2, String paramString3, Throwable paramThrowable, boolean paramBoolean)
  {
    sLogExecutor.execute(new Logger.1(this, paramLogLevel, paramBoolean, paramString2, paramString3, paramThrowable, paramString1));
  }
  
  private void sendLogcatLogs(String paramString1, Logger.LogLevel paramLogLevel, String paramString2)
  {
    int i = paramLogLevel.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            Log.v(paramString1, paramString2);
          } else {
            throw new IllegalArgumentException("Unknown log level");
          }
        }
        else {
          Log.i(paramString1, paramString2);
        }
      }
      else {
        Log.w(paramString1, paramString2);
      }
    }
    else {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void setAllowLogcat(boolean paramBoolean)
  {
    sAllowLogcat = paramBoolean;
  }
  
  public static void setAllowPii(boolean paramBoolean)
  {
    sAllowPii = paramBoolean;
  }
  
  public static void verbose(String paramString1, String paramString2)
  {
    getInstance().log(paramString1, Logger.LogLevel.VERBOSE, DiagnosticContext.getRequestContext().toJsonString(), paramString2, null, false);
  }
  
  public static void verbose(String paramString1, String paramString2, String paramString3)
  {
    getInstance().log(paramString1, Logger.LogLevel.VERBOSE, paramString2, paramString3, null, false);
  }
  
  public static void verbosePII(String paramString1, String paramString2)
  {
    getInstance().log(paramString1, Logger.LogLevel.VERBOSE, DiagnosticContext.getRequestContext().toJsonString(), paramString2, null, true);
  }
  
  public static void verbosePII(String paramString1, String paramString2, String paramString3)
  {
    getInstance().log(paramString1, Logger.LogLevel.VERBOSE, paramString2, paramString3, null, true);
  }
  
  public static void warn(String paramString1, String paramString2)
  {
    getInstance().log(paramString1, Logger.LogLevel.WARN, DiagnosticContext.getRequestContext().toJsonString(), paramString2, null, false);
  }
  
  public static void warn(String paramString1, String paramString2, String paramString3)
  {
    getInstance().log(paramString1, Logger.LogLevel.WARN, paramString2, paramString3, null, false);
  }
  
  public static void warnPII(String paramString1, String paramString2)
  {
    getInstance().log(paramString1, Logger.LogLevel.WARN, DiagnosticContext.getRequestContext().toJsonString(), paramString2, null, true);
  }
  
  public static void warnPII(String paramString1, String paramString2, String paramString3)
  {
    getInstance().log(paramString1, Logger.LogLevel.WARN, paramString2, paramString3, null, true);
  }
  
  public void setExternalLogger(ILoggerCallback paramILoggerCallback)
  {
    mExternalLogger = paramILoggerCallback;
  }
  
  public void setLogLevel(Logger.LogLevel paramLogLevel)
  {
    mLogLevel = paramLogLevel;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.logging.Logger
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */