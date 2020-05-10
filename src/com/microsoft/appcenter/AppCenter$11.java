package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class AppCenter$11
  implements Runnable
{
  public AppCenter$11(AppCenter paramAppCenter, boolean paramBoolean, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    AppCenter.access$800(this$0, val$enabled);
    val$future.complete(null);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.AppCenter.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */