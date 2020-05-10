package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import java.io.File;

public class Crashes$1
  implements Runnable
{
  public Crashes$1(Crashes paramCrashes, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    val$future.complete(ErrorLogHelper.getNewMinidumpSubfolderWithContextData(Crashes.access$100(this$0)).getAbsolutePath());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */