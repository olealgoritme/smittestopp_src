package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.analytics.channel.AnalyticsListener;
import com.microsoft.appcenter.channel.Channel.GroupListener;
import com.microsoft.appcenter.ingestion.models.Log;

public class Analytics$6
  implements Channel.GroupListener
{
  public Analytics$6(Analytics paramAnalytics) {}
  
  public void onBeforeSending(Log paramLog)
  {
    if (Analytics.access$500(this$0) != null) {
      Analytics.access$500(this$0).onBeforeSending(paramLog);
    }
  }
  
  public void onFailure(Log paramLog, Exception paramException)
  {
    if (Analytics.access$500(this$0) != null) {
      Analytics.access$500(this$0).onSendingFailed(paramLog, paramException);
    }
  }
  
  public void onSuccess(Log paramLog)
  {
    if (Analytics.access$500(this$0) != null) {
      Analytics.access$500(this$0).onSendingSucceeded(paramLog);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.Analytics.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */