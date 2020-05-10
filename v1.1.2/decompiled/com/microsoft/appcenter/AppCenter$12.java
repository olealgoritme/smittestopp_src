package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class AppCenter$12
  implements Runnable
{
  public AppCenter$12(AppCenter paramAppCenter, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    val$future.complete(IdHelper.getInstallId());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.AppCenter.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */