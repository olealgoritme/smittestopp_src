package com.microsoft.identity.common.internal.logging;

import android.util.Log;

public class Logger$1
  implements Runnable
{
  public Logger$1(Logger paramLogger, Logger.LogLevel paramLogLevel, boolean paramBoolean, String paramString1, String paramString2, Throwable paramThrowable, String paramString3) {}
  
  public void run()
  {
    if (val$logLevel.compareTo(Logger.access$000(this$0)) > 0) {
      return;
    }
    if ((!Logger.access$100()) && (val$containsPII)) {
      return;
    }
    String str = Logger.access$200(this$0, val$correlationID, val$message, val$throwable);
    if (Logger.access$300()) {
      Logger.access$400(this$0, val$tag, val$logLevel, str);
    }
    if (Logger.access$500(this$0) != null) {
      try
      {
        Logger.access$500(this$0).log(val$tag, val$logLevel, str, val$containsPII);
      }
      catch (Exception localException)
      {
        if ((!val$containsPII) || (Logger.access$100())) {
          Log.w(val$tag, String.format("Custom log failed to log message:%s", new Object[] { str }));
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.logging.Logger.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */