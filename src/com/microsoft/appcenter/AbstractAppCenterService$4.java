package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.AppCenterLog;

public class AbstractAppCenterService$4
  implements Runnable
{
  public AbstractAppCenterService$4(AbstractAppCenterService paramAbstractAppCenterService, Runnable paramRunnable1, Runnable paramRunnable2) {}
  
  public void run()
  {
    if (this$0.isInstanceEnabled())
    {
      val$runnable.run();
    }
    else
    {
      Object localObject = val$serviceDisabledRunnable;
      if (localObject != null)
      {
        ((Runnable)localObject).run();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this$0.getServiceName());
        ((StringBuilder)localObject).append(" service disabled, discarding calls.");
        AppCenterLog.info("AppCenter", ((StringBuilder)localObject).toString());
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.AbstractAppCenterService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */