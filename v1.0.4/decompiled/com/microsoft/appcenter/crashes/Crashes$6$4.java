package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.model.ErrorReport;

public class Crashes$6$4
  implements Crashes.CallbackProcessor
{
  public Crashes$6$4(Crashes.6 param6, Exception paramException) {}
  
  public void onCallBack(ErrorReport paramErrorReport)
  {
    Crashes.access$700(this$1.this$0).onSendingFailed(paramErrorReport, val$e);
  }
  
  public boolean shouldDeleteThrowable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.Crashes.6.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */