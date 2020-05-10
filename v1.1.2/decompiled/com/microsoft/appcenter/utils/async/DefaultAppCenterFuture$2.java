package com.microsoft.appcenter.utils.async;

import java.util.Collection;
import java.util.Iterator;

public class DefaultAppCenterFuture$2
  implements Runnable
{
  public DefaultAppCenterFuture$2(DefaultAppCenterFuture paramDefaultAppCenterFuture, Object paramObject) {}
  
  public void run()
  {
    Iterator localIterator = DefaultAppCenterFuture.access$100(this$0).iterator();
    while (localIterator.hasNext()) {
      ((AppCenterConsumer)localIterator.next()).accept(val$value);
    }
    DefaultAppCenterFuture.access$102(this$0, null);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.async.DefaultAppCenterFuture.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */