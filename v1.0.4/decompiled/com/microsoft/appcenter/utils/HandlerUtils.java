package com.microsoft.appcenter.utils;

import android.os.Handler;
import android.os.Looper;

public class HandlerUtils
{
  public static final Handler sMainHandler = new Handler(Looper.getMainLooper());
  
  public static Handler getMainHandler()
  {
    return sMainHandler;
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (Thread.currentThread() == sMainHandler.getLooper().getThread()) {
      paramRunnable.run();
    } else {
      sMainHandler.post(paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.HandlerUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */