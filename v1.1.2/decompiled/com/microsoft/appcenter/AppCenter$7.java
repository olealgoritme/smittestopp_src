package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;

public class AppCenter$7
  implements Runnable
{
  public AppCenter$7(AppCenter paramAppCenter, Runnable paramRunnable1, Runnable paramRunnable2) {}
  
  public void run()
  {
    if (this$0.isInstanceEnabled())
    {
      val$runnable.run();
    }
    else
    {
      Runnable localRunnable = val$disabledRunnable;
      if (localRunnable != null) {
        localRunnable.run();
      } else {
        AppCenterLog.error("AppCenter", "App Center SDK is disabled.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.AppCenter.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */