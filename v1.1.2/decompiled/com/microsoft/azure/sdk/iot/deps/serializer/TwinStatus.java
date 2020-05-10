package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.c;

@Deprecated
public enum TwinStatus
{
  static
  {
    TwinStatus localTwinStatus = new TwinStatus("disabled", 1);
    disabled = localTwinStatus;
    $VALUES = new TwinStatus[] { enabled, localTwinStatus };
  }
  
  public TwinStatus() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.TwinStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */