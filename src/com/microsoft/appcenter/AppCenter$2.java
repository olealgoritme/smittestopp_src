package com.microsoft.appcenter;

import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.channel.OneCollectorChannelListener;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;

public class AppCenter$2
  implements Runnable
{
  public AppCenter$2(AppCenter paramAppCenter, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (AppCenter.access$100(this$0) != null)
    {
      localStringBuilder = a.a("The log url of App Center endpoint has been changed to ");
      localStringBuilder.append(val$logUrl);
      AppCenterLog.info("AppCenter", localStringBuilder.toString());
      AppCenter.access$000(this$0).setLogUrl(val$logUrl);
    }
    else
    {
      localStringBuilder = a.a("The log url of One Collector endpoint has been changed to ");
      localStringBuilder.append(val$logUrl);
      AppCenterLog.info("AppCenter", localStringBuilder.toString());
      AppCenter.access$200(this$0).setLogUrl(val$logUrl);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.AppCenter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */