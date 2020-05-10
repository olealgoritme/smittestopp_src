package com.android.volley;

import android.util.Log;
import e.a.a.a.a;
import java.util.Locale;

public class VolleyLog
{
  public static final String CLASS_NAME = VolleyLog.class.getName();
  public static boolean DEBUG = Log.isLoggable("Volley", 2);
  public static String TAG = "Volley";
  
  public static String buildMessage(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      paramString = String.format(Locale.US, paramString, paramVarArgs);
    }
    paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
    for (int i = 2; i < paramVarArgs.length; i++) {
      if (!paramVarArgs[i].getClassName().equals(CLASS_NAME))
      {
        Object localObject = paramVarArgs[i].getClassName();
        localObject = ((String)localObject).substring(((String)localObject).lastIndexOf('.') + 1);
        localObject = a.a(((String)localObject).substring(((String)localObject).lastIndexOf('$') + 1), ".");
        ((StringBuilder)localObject).append(paramVarArgs[i].getMethodName());
        paramVarArgs = ((StringBuilder)localObject).toString();
        break label119;
      }
    }
    paramVarArgs = "<unknown>";
    label119:
    return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    Log.d(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void setTag(String paramString)
  {
    d("Changing log tag to %s", new Object[] { paramString });
    TAG = paramString;
    DEBUG = Log.isLoggable(paramString, 2);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      Log.v(TAG, buildMessage(paramString, paramVarArgs));
    }
  }
  
  public static void wtf(String paramString, Object... paramVarArgs)
  {
    Log.wtf(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void wtf(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.wtf(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.VolleyLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */