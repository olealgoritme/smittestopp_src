package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class AnalyticsTransmissionTarget$4
  implements Runnable
{
  public AnalyticsTransmissionTarget$4(AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget, boolean paramBoolean, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    if (AnalyticsTransmissionTarget.access$200(this$0))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(this$0);
      if (!localLinkedList.isEmpty())
      {
        ListIterator localListIterator = localLinkedList.listIterator();
        while (localListIterator.hasNext())
        {
          Object localObject = (AnalyticsTransmissionTarget)localListIterator.next();
          localListIterator.remove();
          SharedPreferencesManager.putBoolean(AnalyticsTransmissionTarget.access$300((AnalyticsTransmissionTarget)localObject), val$enabled);
          localObject = AnalyticsTransmissionTarget.access$400((AnalyticsTransmissionTarget)localObject).values().iterator();
          while (((Iterator)localObject).hasNext()) {
            localListIterator.add((AnalyticsTransmissionTarget)((Iterator)localObject).next());
          }
        }
      }
    }
    else
    {
      AppCenterLog.error("AppCenterAnalytics", "One of the parent transmission target is disabled, cannot change state.");
    }
    val$future.complete(null);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */