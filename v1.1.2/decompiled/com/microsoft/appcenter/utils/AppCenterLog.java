package com.microsoft.appcenter.utils;

import android.util.Log;
import e.a.a.a.a;

public class AppCenterLog
{
  public static final String LOG_TAG = "AppCenter";
  public static final int NONE = 8;
  public static int sLogLevel = 7;
  
  public static void debug(String paramString1, String paramString2)
  {
    if (sLogLevel <= 3) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void debug(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogLevel <= 3) {
      Log.d(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void error(String paramString1, String paramString2)
  {
    if (sLogLevel <= 6) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void error(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogLevel <= 6) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static int getLogLevel()
  {
    return sLogLevel;
  }
  
  public static void info(String paramString1, String paramString2)
  {
    if (sLogLevel <= 4) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void info(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogLevel <= 4) {
      Log.i(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void logAssert(String paramString1, String paramString2)
  {
    if (sLogLevel <= 7) {
      Log.println(7, paramString1, paramString2);
    }
  }
  
  public static void logAssert(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogLevel <= 7)
    {
      paramString2 = a.a(paramString2, "\n");
      paramString2.append(Log.getStackTraceString(paramThrowable));
      Log.println(7, paramString1, paramString2.toString());
    }
  }
  
  public static void setLogLevel(int paramInt)
  {
    sLogLevel = paramInt;
  }
  
  public static void verbose(String paramString1, String paramString2)
  {
    if (sLogLevel <= 2) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void verbose(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogLevel <= 2) {
      Log.v(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void warn(String paramString1, String paramString2)
  {
    if (sLogLevel <= 5) {
      Log.w(paramString1, paramString2);
    }
  }
  
  public static void warn(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogLevel <= 5) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.AppCenterLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */