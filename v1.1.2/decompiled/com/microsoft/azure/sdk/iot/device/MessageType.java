package com.microsoft.azure.sdk.iot.device;

public enum MessageType
{
  static
  {
    CBS_AUTHENTICATION = new MessageType("CBS_AUTHENTICATION", 1);
    DEVICE_TELEMETRY = new MessageType("DEVICE_TELEMETRY", 2);
    DEVICE_METHODS = new MessageType("DEVICE_METHODS", 3);
    MessageType localMessageType = new MessageType("DEVICE_TWIN", 4);
    DEVICE_TWIN = localMessageType;
    $VALUES = new MessageType[] { UNKNOWN, CBS_AUTHENTICATION, DEVICE_TELEMETRY, DEVICE_METHODS, localMessageType };
  }
  
  public MessageType() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.MessageType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */