package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.analytics.channel.SessionTracker;

public class Analytics$5
  implements Runnable
{
  public Analytics$5(Analytics paramAnalytics, Runnable paramRunnable) {}
  
  public void run()
  {
    val$updateCurrentActivityRunnable.run();
    if (Analytics.access$400(this$0) != null) {
      Analytics.access$400(this$0).onActivityPaused();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.Analytics.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */