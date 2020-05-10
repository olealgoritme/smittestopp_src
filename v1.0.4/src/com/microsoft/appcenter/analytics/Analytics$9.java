package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.channel.Channel;

public class Analytics$9
  implements Runnable
{
  public Analytics$9(Analytics paramAnalytics) {}
  
  public void run()
  {
    Analytics.access$900(this$0).pauseGroup("group_analytics", null);
    Analytics.access$1000(this$0).pauseGroup("group_analytics_critical", null);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.Analytics.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */