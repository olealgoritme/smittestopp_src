package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.c;

@Deprecated
public enum TwinConnectionState
{
  static
  {
    TwinConnectionState localTwinConnectionState = new TwinConnectionState("connected", 1);
    connected = localTwinConnectionState;
    $VALUES = new TwinConnectionState[] { disconnected, localTwinConnectionState };
  }
  
  public TwinConnectionState() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.TwinConnectionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */