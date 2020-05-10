package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.channel.Channel;

public class AnalyticsTransmissionTarget$6
  implements Runnable
{
  public AnalyticsTransmissionTarget$6(AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget) {}
  
  public void run()
  {
    AnalyticsTransmissionTarget.access$100(this$0).resumeGroup("group_analytics", AnalyticsTransmissionTarget.access$500(this$0));
    AnalyticsTransmissionTarget.access$100(this$0).resumeGroup("group_analytics_critical", AnalyticsTransmissionTarget.access$500(this$0));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */