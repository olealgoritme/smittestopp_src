package com.microsoft.identity.common.internal.telemetry;

import e.c.c.v.c;
import java.io.Serializable;

public class TelemetryConfiguration
  implements Serializable
{
  @c("debug_enabled")
  public boolean mDebugEnabled = false;
  @c("notify_on_failure_only")
  public boolean mNotifyOnFailureOnly = true;
  @c("pii_enabled")
  public boolean mPiiEnabled = false;
  
  public boolean isDebugEnabled()
  {
    return mDebugEnabled;
  }
  
  public boolean isPiiEnabled()
  {
    return mPiiEnabled;
  }
  
  public void setDebugEnabled(boolean paramBoolean)
  {
    mDebugEnabled = paramBoolean;
  }
  
  public void setNotifyOnFailureOnly(boolean paramBoolean)
  {
    mNotifyOnFailureOnly = paramBoolean;
  }
  
  public void setPiiEnabled(boolean paramBoolean)
  {
    mPiiEnabled = paramBoolean;
  }
  
  public boolean shouldNotifyOnFailureOnly()
  {
    return mNotifyOnFailureOnly;
  }
  
  public static final class SerializedNames
  {
    public static final String DEBUG_ENABLED = "debug_enabled";
    public static final String NOTIFY_ON_FAILTURE_ONLY = "notify_on_failure_only";
    public static final String PII_ENABLED = "pii_enabled";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.TelemetryConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */