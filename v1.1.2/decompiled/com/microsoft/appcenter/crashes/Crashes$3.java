package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class Crashes$3
  implements Runnable
{
  public Crashes$3(Crashes paramCrashes, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    val$future.complete(Boolean.valueOf(Crashes.access$300(this$0)));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */