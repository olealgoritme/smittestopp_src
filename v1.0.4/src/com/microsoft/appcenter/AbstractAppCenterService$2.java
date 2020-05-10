package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class AbstractAppCenterService$2
  implements Runnable
{
  public AbstractAppCenterService$2(AbstractAppCenterService paramAbstractAppCenterService, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    AppCenterLog.error("AppCenter", "App Center SDK is disabled.");
    val$future.complete(null);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.AbstractAppCenterService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */