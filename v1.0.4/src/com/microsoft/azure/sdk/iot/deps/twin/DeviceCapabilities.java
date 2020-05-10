package com.microsoft.azure.sdk.iot.deps.twin;

import e.c.c.v.a;
import e.c.c.v.c;

public class DeviceCapabilities
{
  public static final String IOT_EDGE_NAME = "iotEdge";
  @a(deserialize=true, serialize=true)
  @c("iotEdge")
  public Boolean iotEdge = Boolean.valueOf(false);
  
  public Boolean isIotEdge()
  {
    return iotEdge;
  }
  
  public void setIotEdge(Boolean paramBoolean)
  {
    if (paramBoolean != null)
    {
      iotEdge = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("iotEdge cannot be null");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.twin.DeviceCapabilities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */