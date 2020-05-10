package com.microsoft.identity.common.adal.internal;

import android.annotation.TargetApi;
import android.app.usage.UsageStatsManager;
import android.content.Context;

public class UsageStatsManagerWrapper
{
  public static UsageStatsManagerWrapper sInstance;
  
  public static UsageStatsManagerWrapper getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localUsageStatsManagerWrapper = new com/microsoft/identity/common/adal/internal/UsageStatsManagerWrapper;
        localUsageStatsManagerWrapper.<init>();
        sInstance = localUsageStatsManagerWrapper;
      }
      UsageStatsManagerWrapper localUsageStatsManagerWrapper = sInstance;
      return localUsageStatsManagerWrapper;
    }
    finally {}
  }
  
  public static void setInstance(UsageStatsManagerWrapper paramUsageStatsManagerWrapper)
  {
    try
    {
      sInstance = paramUsageStatsManagerWrapper;
      return;
    }
    finally
    {
      paramUsageStatsManagerWrapper = finally;
      throw paramUsageStatsManagerWrapper;
    }
  }
  
  @TargetApi(23)
  public boolean isAppInactive(Context paramContext)
  {
    return ((UsageStatsManager)paramContext.getSystemService("usagestats")).isAppInactive(paramContext.getPackageName());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.UsageStatsManagerWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */