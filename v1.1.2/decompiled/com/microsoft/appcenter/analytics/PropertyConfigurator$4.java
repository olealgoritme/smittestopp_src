package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.utils.context.UserIdContext;

public class PropertyConfigurator$4
  implements Runnable
{
  public PropertyConfigurator$4(PropertyConfigurator paramPropertyConfigurator, String paramString) {}
  
  public void run()
  {
    PropertyConfigurator.access$302(this$0, UserIdContext.getPrefixedUserId(val$userId));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.PropertyConfigurator.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */