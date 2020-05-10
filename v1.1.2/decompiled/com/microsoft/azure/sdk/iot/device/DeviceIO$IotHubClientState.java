package com.microsoft.azure.sdk.iot.device;

public enum DeviceIO$IotHubClientState
{
  static
  {
    IotHubClientState localIotHubClientState = new IotHubClientState("CLOSED", 1);
    CLOSED = localIotHubClientState;
    $VALUES = new IotHubClientState[] { OPEN, localIotHubClientState };
  }
  
  public DeviceIO$IotHubClientState() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.DeviceIO.IotHubClientState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */