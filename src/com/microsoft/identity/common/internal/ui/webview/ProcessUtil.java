package com.microsoft.identity.common.internal.ui.webview;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class ProcessUtil
{
  public static final String AuthServiceProcess = "auth";
  
  public static boolean isRunningOnAuthService(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getPackageName());
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append("auth");
    localObject = ((StringBuilder)localObject).toString();
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if ((paramContext != null) && (paramContext.getRunningAppProcesses() != null))
    {
      paramContext = paramContext.getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((pid == i) && (processName.equalsIgnoreCase((String)localObject))) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.ProcessUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */