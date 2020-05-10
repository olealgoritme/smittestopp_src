package com.microsoft.appcenter;

import com.microsoft.appcenter.channel.Channel;

public class AppCenter$1
  implements Runnable
{
  public AppCenter$1(AppCenter paramAppCenter) {}
  
  public void run()
  {
    AppCenter.access$000(this$0).invalidateDeviceCache();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.AppCenter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */