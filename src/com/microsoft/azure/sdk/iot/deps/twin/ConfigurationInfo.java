package com.microsoft.azure.sdk.iot.deps.twin;

import e.c.c.v.a;
import e.c.c.v.c;

public class ConfigurationInfo
{
  public static final String STATUS_NAME = "status";
  @a(deserialize=true, serialize=true)
  @c("status")
  public ConfigurationStatus status;
  
  public ConfigurationStatus getStatus()
  {
    return status;
  }
  
  public void setStatus(ConfigurationStatus paramConfigurationStatus)
  {
    status = paramConfigurationStatus;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.twin.ConfigurationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */