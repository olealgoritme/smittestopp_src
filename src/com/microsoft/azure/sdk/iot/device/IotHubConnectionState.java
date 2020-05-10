package com.microsoft.azure.sdk.iot.device;

public enum IotHubConnectionState
{
  static
  {
    CONNECTION_DROP = new IotHubConnectionState("CONNECTION_DROP", 1);
    IotHubConnectionState localIotHubConnectionState = new IotHubConnectionState("SAS_TOKEN_EXPIRED", 2);
    SAS_TOKEN_EXPIRED = localIotHubConnectionState;
    $VALUES = new IotHubConnectionState[] { CONNECTION_SUCCESS, CONNECTION_DROP, localIotHubConnectionState };
  }
  
  public IotHubConnectionState() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.IotHubConnectionState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */