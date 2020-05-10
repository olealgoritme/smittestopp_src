package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.UUID;

public class Crashes$15
  implements Runnable
{
  public Crashes$15(Crashes paramCrashes, String paramString, Iterable paramIterable) {}
  
  public void run()
  {
    try
    {
      UUID localUUID = UUID.fromString(val$errorReportId);
      Crashes.access$900(this$0, localUUID, val$attachments);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenterCrashes", "Error report identifier has an invalid format for sending attachments.");
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */