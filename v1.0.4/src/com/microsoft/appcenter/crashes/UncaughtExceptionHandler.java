package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.utils.ShutdownHelper;

public class UncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
  public boolean mIgnoreDefaultExceptionHandler = false;
  
  public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler()
  {
    return mDefaultUncaughtExceptionHandler;
  }
  
  public void register()
  {
    if (!mIgnoreDefaultExceptionHandler) {
      mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    } else {
      mDefaultUncaughtExceptionHandler = null;
    }
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void setIgnoreDefaultExceptionHandler(boolean paramBoolean)
  {
    mIgnoreDefaultExceptionHandler = paramBoolean;
    if (paramBoolean) {
      mDefaultUncaughtExceptionHandler = null;
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Crashes.getInstance().saveUncaughtException(paramThread, paramThrowable);
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = mDefaultUncaughtExceptionHandler;
    if (localUncaughtExceptionHandler != null) {
      localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    } else {
      ShutdownHelper.shutdown(10);
    }
  }
  
  public void unregister()
  {
    Thread.setDefaultUncaughtExceptionHandler(mDefaultUncaughtExceptionHandler);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.UncaughtExceptionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */