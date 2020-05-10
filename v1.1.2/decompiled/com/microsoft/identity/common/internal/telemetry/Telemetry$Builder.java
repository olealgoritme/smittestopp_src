package com.microsoft.identity.common.internal.telemetry;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.microsoft.identity.common.internal.logging.Logger;

public class Telemetry$Builder
{
  public Context mContext;
  public TelemetryConfiguration mDefaultConfiguration;
  public Boolean mIsDebugging;
  public TelemetryContext mTelemetryContext;
  
  public Telemetry build()
  {
    return Telemetry.access$400(this);
  }
  
  public Builder defaultConfiguration(TelemetryConfiguration paramTelemetryConfiguration)
  {
    mDefaultConfiguration = paramTelemetryConfiguration;
    return this;
  }
  
  public Builder withContext(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getApplicationContext();
      mContext = ((Context)localObject);
      if (localObject != null)
      {
        mTelemetryContext = TelemetryContext.create((Context)localObject);
        try
        {
          localObject = paramContext.getPackageName();
          boolean bool;
          if ((getPackageManagergetApplicationInfo0flags & 0x2) != 0) {
            bool = true;
          } else {
            bool = false;
          }
          mIsDebugging = Boolean.valueOf(bool);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          Logger.warn(Telemetry.access$300(), "The application is not found from PackageManager.");
          mIsDebugging = Boolean.valueOf(false);
        }
        return this;
      }
      throw new IllegalArgumentException("Application context must not be null.");
    }
    throw new IllegalArgumentException("Context must not be null.");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.Telemetry.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */