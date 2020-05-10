package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.utils.async.DefaultAppCenterFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Crashes$13
  implements Runnable
{
  public Crashes$13(Crashes paramCrashes, DefaultAppCenterFuture paramDefaultAppCenterFuture) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(Crashes.access$1000(this$0).size());
    Iterator localIterator = Crashes.access$1000(this$0).values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Crashes.ErrorLogReport.access$1300((Crashes.ErrorLogReport)localIterator.next()));
    }
    val$future.complete(localArrayList);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */