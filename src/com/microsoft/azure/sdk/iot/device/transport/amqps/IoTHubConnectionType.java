package com.microsoft.azure.sdk.iot.device.transport.amqps;

public enum IoTHubConnectionType
{
  static
  {
    SINGLE_CLIENT = new IoTHubConnectionType("SINGLE_CLIENT", 1);
    IoTHubConnectionType localIoTHubConnectionType = new IoTHubConnectionType("USE_TRANSPORTCLIENT", 2);
    USE_TRANSPORTCLIENT = localIoTHubConnectionType;
    $VALUES = new IoTHubConnectionType[] { UNKNOWN, SINGLE_CLIENT, localIoTHubConnectionType };
  }
  
  public IoTHubConnectionType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.IoTHubConnectionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */