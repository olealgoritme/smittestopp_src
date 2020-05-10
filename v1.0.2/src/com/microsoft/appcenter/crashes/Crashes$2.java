package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class Crashes$2
  implements Runnable
{
  public Crashes$2(Crashes paramCrashes, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    DefaultAppCenterFuture localDefaultAppCenterFuture = val$future;
    boolean bool;
    if (Crashes.access$200(this$0) != null) {
      bool = true;
    } else {
      bool = false;
    }
    localDefaultAppCenterFuture.complete(Boolean.valueOf(bool));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */