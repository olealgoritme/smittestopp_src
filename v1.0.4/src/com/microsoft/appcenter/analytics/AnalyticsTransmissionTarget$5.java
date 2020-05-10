package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.channel.Channel;

public class AnalyticsTransmissionTarget$5
  implements Runnable
{
  public AnalyticsTransmissionTarget$5(AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget) {}
  
  public void run()
  {
    AnalyticsTransmissionTarget.access$100(this$0).pauseGroup("group_analytics", AnalyticsTransmissionTarget.access$500(this$0));
    AnalyticsTransmissionTarget.access$100(this$0).pauseGroup("group_analytics_critical", AnalyticsTransmissionTarget.access$500(this$0));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */