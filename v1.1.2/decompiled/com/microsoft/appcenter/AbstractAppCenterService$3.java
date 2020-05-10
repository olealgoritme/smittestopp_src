package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;

public class AbstractAppCenterService$3
  implements Runnable
{
  public AbstractAppCenterService$3(AbstractAppCenterService paramAbstractAppCenterService, boolean paramBoolean, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    this$0.setInstanceEnabled(val$enabled);
    val$future.complete(null);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.AbstractAppCenterService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */