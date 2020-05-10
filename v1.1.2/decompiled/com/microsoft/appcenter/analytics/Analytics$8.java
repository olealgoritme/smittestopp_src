package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.Flags;
import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.List;
import java.util.UUID;

public class Analytics$8
  implements Runnable
{
  public Analytics$8(Analytics paramAnalytics, AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget, String paramString1, String paramString2, List paramList, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = val$transmissionTarget;
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this$0.mDefaultTransmissionTarget;
    }
    localObject1 = new EventLog();
    if (localObject2 != null)
    {
      if (((AnalyticsTransmissionTarget)localObject2).isEnabled())
      {
        ((AbstractLog)localObject1).addTransmissionTarget(((AnalyticsTransmissionTarget)localObject2).getTransmissionTargetToken());
        ((AbstractLog)localObject1).setTag(localObject2);
        if (localObject2 == this$0.mDefaultTransmissionTarget) {
          ((AbstractLog)localObject1).setUserId(val$userId);
        }
      }
      else
      {
        AppCenterLog.error("AppCenterAnalytics", "This transmission target is disabled.");
      }
    }
    else if (!Analytics.access$600(this$0))
    {
      AppCenterLog.error("AppCenterAnalytics", "Cannot track event using Analytics.trackEvent if not started from app, please start from the application or use Analytics.getTransmissionTarget.");
      return;
    }
    ((EventLog)localObject1).setId(UUID.randomUUID());
    ((LogWithNameAndProperties)localObject1).setName(val$name);
    ((EventLog)localObject1).setTypedProperties(val$properties);
    int i = Flags.getPersistenceFlag(val$flags, true);
    Channel localChannel = Analytics.access$800(this$0);
    if (i == 2) {
      localObject2 = "group_analytics_critical";
    } else {
      localObject2 = "group_analytics";
    }
    localChannel.enqueue((Log)localObject1, (String)localObject2, i);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.Analytics.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */