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
      localObject1 = (ManagedErrorLog)localObject1;
      final Object localObject2 = this$1.this$0.buildErrorReport((ManagedErrorLog)localObject1);
      localObject1 = ((AbstractErrorLog)localObject1).getId();
      if (localObject2 != null)
      {
        if (val$callbackProcessor.shouldDeleteThrowable()) {
          Crashes.access$500(this$1.this$0, (UUID)localObject1);
        }
        HandlerUtils.runOnUiThread(new Runnable()
        {
          public void run()
          {
            val$callbackProcessor.onCallBack(localObject2);
          }
        });
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Cannot find crash report for the error log: ");
        ((StringBuilder)localObject2).append(localObject1);
        AppCenterLog.warn("AppCenterCrashes", ((StringBuilder)localObject2).toString());
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
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes.6.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */