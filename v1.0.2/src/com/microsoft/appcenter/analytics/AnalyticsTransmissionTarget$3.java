package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class AnalyticsTransmissionTarget$3
  implements Runnable
{
  public AnalyticsTransmissionTarget$3(AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    val$future.complete(Boolean.valueOf(this$0.isEnabled()));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */