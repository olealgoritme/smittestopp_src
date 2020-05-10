package com.microsoft.appcenter.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class AppNameHelper
{
  public static String getAppName(Context paramContext)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
    int i = labelRes;
    if (i == 0) {
      return String.valueOf(nonLocalizedLabel);
    }
    return paramContext.getString(i);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.AppNameHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */