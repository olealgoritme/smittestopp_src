package com.microsoft.identity.common.internal.telemetry;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class TelemetryContext
  extends Properties
{
  public static final String TAG = "TelemetryContext";
  
  public TelemetryContext(ConcurrentHashMap<String, String> paramConcurrentHashMap)
  {
    super(paramConcurrentHashMap);
  }
  
  public static TelemetryContext create(Context paramContext)
  {
    try
    {
      TelemetryContext localTelemetryContext = new com/microsoft/identity/common/internal/telemetry/TelemetryContext;
      ConcurrentHashMap localConcurrentHashMap = new java/util/concurrent/ConcurrentHashMap;
      localConcurrentHashMap.<init>();
      localTelemetryContext.<init>(localConcurrentHashMap);
      localTelemetryContext.addApplicationInfo(paramContext);
      localTelemetryContext.addDeviceInfo(paramContext);
      localTelemetryContext.addOsInfo();
      localTelemetryContext.put("Microsoft.MSAL.time_zone", TimeZone.getDefault().getID());
      return localTelemetryContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void addApplicationInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      put("Microsoft.MSAL.application_name", applicationInfo.packageName);
      put("Microsoft.MSAL.application_version", versionName);
      put("Microsoft.MSAL.application_build", String.valueOf(versionCode));
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.warn(TAG, "Unable to find the app's package name from PackageManager.");
    }
  }
  
  public void addDeviceInfo(Context paramContext)
  {
    put("Microsoft.MSAL.device_manufacturer", Build.MANUFACTURER);
    put("Microsoft.MSAL.device_model", Build.MODEL);
    put("Microsoft.MSAL.device_name", Build.DEVICE);
    try
    {
      put("Microsoft.MSAL.device_id", StringExtensions.createHash(Settings.Secure.getString(paramContext.getContentResolver(), "android_id")));
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException paramContext)
    {
      Logger.warn(TAG, "Unable to get the device id.");
    }
  }
  
  public void addOsInfo()
  {
    put("Microsoft.MSAL.os_name", "android");
    put("Microsoft.MSAL.os_version", Build.VERSION.RELEASE);
    if (Build.VERSION.SDK_INT >= 23) {
      put("Microsoft.MSAL.security_patch", Build.VERSION.SECURITY_PATCH);
    }
  }
  
  public void isNetworkConnected(boolean paramBoolean)
  {
    put("Microsoft.MSAL.network_connection", String.valueOf(paramBoolean));
  }
  
  public void isNetworkDisabledFromOptimizations(boolean paramBoolean)
  {
    put("Microsoft.MSAL.power_optimization", String.valueOf(paramBoolean));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.TelemetryContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */