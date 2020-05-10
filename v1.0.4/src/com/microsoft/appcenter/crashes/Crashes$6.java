package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.channel.Channel.GroupListener;
import com.microsoft.appcenter.ingestion.models.Log;

public class Crashes$6
  implements Channel.GroupListener
{
  public Crashes$6(Crashes paramCrashes) {}
  
  private void processCallback(Log paramLog, Crashes.CallbackProcessor paramCallbackProcessor)
  {
    Crashes.access$600(this$0, new Crashes.6.1(this, paramLog, paramCallbackProcessor));
  }
  
  public void onBeforeSending(Log paramLog)
  {
    processCallback(paramLog, new Crashes.6.2(this));
  }
  
  public void onFailure(Log paramLog, Exception paramException)
  {
    processCallback(paramLog, new Crashes.6.4(this, paramException));
  }
  
  public void onSuccess(Log paramLog)
  {
    processCallback(paramLog, new Crashes.6.3(this));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */