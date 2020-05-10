package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.a;
import e.c.c.v.c;

public class DeviceCapabilitiesParser
{
  public static final String IOT_EDGE_NAME = "iotEdge";
  @a(deserialize=true, serialize=true)
  @c("iotEdge")
  public Boolean iotEdge;
  
  public Boolean getIotEdge()
  {
    return iotEdge;
  }
  
  public void setIotEdge(Boolean paramBoolean)
  {
    iotEdge = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.DeviceCapabilitiesParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */