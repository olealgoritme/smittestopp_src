package com.microsoft.azure.sdk.iot.deps.twin;

import e.c.c.v.c;

public enum TwinStatus
{
  static
  {
    TwinStatus localTwinStatus = new TwinStatus("DISABLED", 1);
    DISABLED = localTwinStatus;
    $VALUES = new TwinStatus[] { ENABLED, localTwinStatus };
  }
  
  public TwinStatus() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.twin.TwinStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */