package com.microsoft.identity.common.adal.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.PowerManager;

public class PowerManagerWrapper
{
  public static PowerManagerWrapper sInstance;
  
  public static PowerManagerWrapper getInstance()
  {
    try
    {
      if (sInstance == null)
      {
        localPowerManagerWrapper = new com/microsoft/identity/common/adal/internal/PowerManagerWrapper;
        localPowerManagerWrapper.<init>();
        sInstance = localPowerManagerWrapper;
      }
      PowerManagerWrapper localPowerManagerWrapper = sInstance;
      return localPowerManagerWrapper;
    }
    finally {}
  }
  
  public static void setInstance(PowerManagerWrapper paramPowerManagerWrapper)
  {
    sInstance = paramPowerManagerWrapper;
  }
  
  @TargetApi(23)
  public boolean isDeviceIdleMode(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isDeviceIdleMode();
  }
  
  @TargetApi(23)
  public boolean isIgnoringBatteryOptimizations(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService("power")).isIgnoringBatteryOptimizations(paramContext.getPackageName());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.PowerManagerWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */