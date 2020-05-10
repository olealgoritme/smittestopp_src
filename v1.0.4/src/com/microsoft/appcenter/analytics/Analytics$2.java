package com.microsoft.appcenter.analytics;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class Analytics$2
  implements Runnable
{
  public Analytics$2(Analytics paramAnalytics, Activity paramActivity) {}
  
  public void run()
  {
    Analytics.access$202(this$0, new WeakReference(val$activity));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.Analytics.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */