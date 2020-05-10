package com.microsoft.azure.sdk.iot.device.transport;

public enum IotHubConnectionStatus
{
  static
  {
    IotHubConnectionStatus localIotHubConnectionStatus = new IotHubConnectionStatus("DISCONNECTED_RETRYING", 2);
    DISCONNECTED_RETRYING = localIotHubConnectionStatus;
    $VALUES = new IotHubConnectionStatus[] { CONNECTED, DISCONNECTED, localIotHubConnectionStatus };
  }
  
  public IotHubConnectionStatus() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.IotHubConnectionStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */