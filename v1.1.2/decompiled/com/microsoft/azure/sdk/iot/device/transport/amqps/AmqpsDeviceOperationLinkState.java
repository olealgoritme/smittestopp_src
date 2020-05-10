package com.microsoft.azure.sdk.iot.device.transport.amqps;

public enum AmqpsDeviceOperationLinkState
{
  static
  {
    CLOSED = new AmqpsDeviceOperationLinkState("CLOSED", 1);
    OPENING = new AmqpsDeviceOperationLinkState("OPENING", 2);
    AmqpsDeviceOperationLinkState localAmqpsDeviceOperationLinkState = new AmqpsDeviceOperationLinkState("OPENED", 3);
    OPENED = localAmqpsDeviceOperationLinkState;
    $VALUES = new AmqpsDeviceOperationLinkState[] { UNKNOWN, CLOSED, OPENING, localAmqpsDeviceOperationLinkState };
  }
  
  public AmqpsDeviceOperationLinkState() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsDeviceOperationLinkState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */