package com.microsoft.appcenter.utils;

import android.os.Process;

public class ShutdownHelper
{
  public static void shutdown(int paramInt)
  {
    Process.killProcess(Process.myPid());
    System.exit(paramInt);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.ShutdownHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */