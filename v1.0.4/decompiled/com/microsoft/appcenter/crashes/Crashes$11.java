package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Map;

public class Crashes$11
  implements Runnable
{
  public Crashes$11(Crashes paramCrashes, boolean paramBoolean) {}
  
  public void run()
  {
    if (Crashes.access$1000(this$0).size() > 0)
    {
      if (val$alwaysSend)
      {
        AppCenterLog.debug("AppCenterCrashes", "The flag for user confirmation is set to ALWAYS_SEND, will send logs.");
        Crashes.access$1100(this$0, 0);
        return;
      }
      if (!Crashes.access$1200(this$0))
      {
        AppCenterLog.debug("AppCenterCrashes", "Automatic processing disabled, will wait for explicit user confirmation.");
        return;
      }
      if (!Crashes.access$700(this$0).shouldAwaitUserConfirmation())
      {
        AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned false, will send logs.");
        Crashes.access$1100(this$0, 0);
      }
      else
      {
        AppCenterLog.debug("AppCenterCrashes", "CrashesListener.shouldAwaitUserConfirmation returned true, wait sending logs.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */