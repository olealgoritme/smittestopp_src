package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.model.ErrorReport;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class Crashes$14
  implements Runnable
{
  public Crashes$14(Crashes paramCrashes, Collection paramCollection, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    Iterator localIterator = Crashes.access$1000(this$0).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      Object localObject2 = (UUID)((Map.Entry)localObject1).getKey();
      localObject1 = Crashes.ErrorLogReport.access$1300((Crashes.ErrorLogReport)((Map.Entry)localObject1).getValue()).getId();
      Object localObject3 = val$filteredReportIds;
      if ((localObject3 != null) && (((Collection)localObject3).contains(localObject1)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CrashesListener.shouldProcess returned true, continue processing log: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("CrashesListener.shouldProcess returned false, clean up and ignore log: ");
        ((StringBuilder)localObject3).append((String)localObject1);
        AppCenterLog.debug("AppCenterCrashes", ((StringBuilder)localObject3).toString());
        Crashes.access$1500(this$0, (UUID)localObject2);
        localIterator.remove();
      }
    }
    val$future.complete(Boolean.valueOf(Crashes.access$1800(this$0)));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */