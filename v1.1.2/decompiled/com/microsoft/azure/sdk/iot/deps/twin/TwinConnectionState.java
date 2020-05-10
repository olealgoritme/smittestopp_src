package com.microsoft.azure.sdk.iot.deps.twin;

import e.c.c.v.c;

public enum TwinConnectionState
{
  static
  {
    TwinConnectionState localTwinConnectionState = new TwinConnectionState("CONNECTED", 1);
    CONNECTED = localTwinConnectionState;
    $VALUES = new TwinConnectionState[] { DISCONNECTED, localTwinConnectionState };
  }
  
  public TwinConnectionState() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.twin.TwinConnectionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */