package com.microsoft.azure.sdk.iot.device;

public enum TransportClient$TransportClientState
{
  static
  {
    TransportClientState localTransportClientState = new TransportClientState("OPENED", 1);
    OPENED = localTransportClientState;
    $VALUES = new TransportClientState[] { CLOSED, localTransportClientState };
  }
  
  public TransportClient$TransportClientState() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.TransportClient.TransportClientState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */