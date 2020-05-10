package com.microsoft.appcenter;

import android.os.Handler;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.ShutdownHelper;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class UncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  public static final int SHUTDOWN_TIMEOUT = 5000;
  public final Channel mChannel;
  public Thread.UncaughtExceptionHandler mDefaultUncaughtExceptionHandler;
  public final Handler mHandler;
  
  public UncaughtExceptionHandler(Handler paramHandler, Channel paramChannel)
  {
    mHandler = paramHandler;
    mChannel = paramChannel;
  }
  
  public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler()
  {
    return mDefaultUncaughtExceptionHandler;
  }
  
  public void register()
  {
    mDefaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (AppCenter.getInstance().isInstanceEnabled())
    {
      Semaphore localSemaphore = new Semaphore(0);
      mHandler.post(new UncaughtExceptionHandler.1(this, localSemaphore));
      try
      {
        if (!localSemaphore.tryAcquire(5000L, TimeUnit.MILLISECONDS)) {
          AppCenterLog.error("AppCenter", "Timeout waiting for looper tasks to complete.");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        AppCenterLog.warn("AppCenter", "Interrupted while waiting looper to flush.", localInterruptedException);
      }
    }
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
 * Qualified Name:     base.com.microsoft.appcenter.UncaughtExceptionHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */