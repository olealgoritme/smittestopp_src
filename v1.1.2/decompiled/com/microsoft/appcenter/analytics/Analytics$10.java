package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.channel.Channel;

public class Analytics$10
  implements Runnable
{
  public Analytics$10(Analytics paramAnalytics) {}
  
  public void run()
  {
    Analytics.access$1100(this$0).resumeGroup("group_analytics", null);
    Analytics.access$1200(this$0).resumeGroup("group_analytics_critical", null);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.Analytics.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */