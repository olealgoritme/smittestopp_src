package com.microsoft.appcenter.analytics;

import android.app.Activity;

public class Analytics$3
  implements Runnable
{
  public Analytics$3(Analytics paramAnalytics, Runnable paramRunnable, Activity paramActivity) {}
  
  public void run()
  {
    val$updateCurrentActivityRunnable.run();
    Analytics.access$300(this$0, val$activity);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.Analytics.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */