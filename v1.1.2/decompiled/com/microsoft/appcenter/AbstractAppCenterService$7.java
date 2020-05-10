package com.microsoft.appcenter;

import com.microsoft.appcenter.utils.HandlerUtils;

public class AbstractAppCenterService$7
  implements Runnable
{
  public AbstractAppCenterService$7(AbstractAppCenterService paramAbstractAppCenterService, Runnable paramRunnable) {}
  
  public void run()
  {
    HandlerUtils.runOnUiThread(new Runnable()
    {
      public void run()
      {
        AbstractAppCenterService.7 local7 = AbstractAppCenterService.7.this;
        AbstractAppCenterService.access$000(this$0, val$runnable);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.AbstractAppCenterService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */