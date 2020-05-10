package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.ingestion.models.AbstractErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.crashes.ingestion.models.ManagedErrorLog;
import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import e.a.a.a.a;
import java.util.UUID;

public class Crashes$6$1
  implements Runnable
{
  public Crashes$6$1(Crashes.6 param6, Log paramLog, Crashes.CallbackProcessor paramCallbackProcessor) {}
  
  public void run()
  {
    Object localObject1 = val$log;
    if ((localObject1 instanceof ManagedErrorLog))
    {
      Object localObject2 = (ManagedErrorLog)localObject1;
      localObject1 = this$1.this$0.buildErrorReport((ManagedErrorLog)localObject2);
      localObject2 = ((AbstractErrorLog)localObject2).getId();
      if (localObject1 != null)
      {
        if (val$callbackProcessor.shouldDeleteThrowable()) {
          Crashes.access$500(this$1.this$0, (UUID)localObject2);
        }
        HandlerUtils.runOnUiThread(new Crashes.6.1.1(this, (ErrorReport)localObject1));
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Cannot find crash report for the error log: ");
        ((StringBuilder)localObject1).append(localObject2);
        AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)localObject1).toString());
      }
    }
    else if ((!(localObject1 instanceof ErrorAttachmentLog)) && (!(localObject1 instanceof HandledErrorLog)))
    {
      localObject1 = a.a("A different type of log comes to crashes: ");
      ((StringBuilder)localObject1).append(val$log.getClass().getName());
      AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)localObject1).toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.6.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */