package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Map;

public class Analytics$7
  implements Runnable
{
  public Analytics$7(Analytics paramAnalytics, String paramString, Map paramMap) {}
  
  public void run()
  {
    if (Analytics.access$600(this$0)) {
      Analytics.access$700(this$0, val$name, val$propertiesCopy);
    } else {
      AppCenterLog.error("AppCenterAnalytics", "Cannot track page if not started from app.");
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.Analytics.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */