package com.microsoft.appcenter.analytics;

public class AnalyticsTransmissionTarget$2
  implements Runnable
{
  public AnalyticsTransmissionTarget$2(AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget1, AnalyticsTransmissionTarget paramAnalyticsTransmissionTarget2) {}
  
  public void run()
  {
    AnalyticsTransmissionTarget localAnalyticsTransmissionTarget1 = val$finalChildTarget;
    AnalyticsTransmissionTarget localAnalyticsTransmissionTarget2 = this$0;
    localAnalyticsTransmissionTarget1.initInBackground(mContext, AnalyticsTransmissionTarget.access$100(localAnalyticsTransmissionTarget2));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */