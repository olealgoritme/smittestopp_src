package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.crashes.model.ErrorReport;

public abstract interface Crashes$CallbackProcessor
{
  public abstract void onCallBack(ErrorReport paramErrorReport);
  
  public abstract boolean shouldDeleteThrowable();
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes.CallbackProcessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */