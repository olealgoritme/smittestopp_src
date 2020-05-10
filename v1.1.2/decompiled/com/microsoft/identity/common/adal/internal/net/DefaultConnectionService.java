package com.microsoft.identity.common.adal.internal.net;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.microsoft.identity.common.adal.internal.PowerManagerWrapper;
import com.microsoft.identity.common.adal.internal.UsageStatsManagerWrapper;
import com.microsoft.identity.common.internal.telemetry.Properties;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.BaseEvent;

public class DefaultConnectionService
  implements IConnectionService
{
  public final Context mConnectionContext;
  
  public DefaultConnectionService(Context paramContext)
  {
    mConnectionContext = paramContext;
  }
  
  public boolean isConnectionAvailable()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)mConnectionContext.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting()) && (!isNetworkDisabledFromOptimizations())) {
      bool = true;
    } else {
      bool = false;
    }
    Telemetry.emit((BaseEvent)new BaseEvent().put("Microsoft.MSAL.network_connection", String.valueOf(bool)));
    return bool;
  }
  
  @TargetApi(23)
  public boolean isNetworkDisabledFromOptimizations()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (UsageStatsManagerWrapper.getInstance().isAppInactive(mConnectionContext))
      {
        Telemetry.emit((BaseEvent)new BaseEvent().put("Microsoft.MSAL.power_optimization", String.valueOf(true)));
        return true;
      }
      PowerManagerWrapper localPowerManagerWrapper = PowerManagerWrapper.getInstance();
      if ((localPowerManagerWrapper.isDeviceIdleMode(mConnectionContext)) && (!localPowerManagerWrapper.isIgnoringBatteryOptimizations(mConnectionContext)))
      {
        Telemetry.emit((BaseEvent)new BaseEvent().put("Microsoft.MSAL.power_optimization", String.valueOf(true)));
        return true;
      }
    }
    Telemetry.emit((BaseEvent)new BaseEvent().put("Microsoft.MSAL.power_optimization", String.valueOf(false)));
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.net.DefaultConnectionService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */