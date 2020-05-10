package com.microsoft.appcenter;

import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.concurrent.Semaphore;

public class UncaughtExceptionHandler$1
  implements Runnable
{
  public UncaughtExceptionHandler$1(UncaughtExceptionHandler paramUncaughtExceptionHandler, Semaphore paramSemaphore) {}
  
  public void run()
  {
    UncaughtExceptionHandler.access$000(this$0).shutdown();
    AppCenterLog.debug("AppCenter", "Channel completed shutdown.");
    val$semaphore.release();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.UncaughtExceptionHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */