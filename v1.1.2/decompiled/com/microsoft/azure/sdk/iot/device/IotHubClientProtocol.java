package com.microsoft.azure.sdk.iot.device;

public enum IotHubClientProtocol
{
  static
  {
    AMQPS = new IotHubClientProtocol("AMQPS", 1);
    MQTT = new IotHubClientProtocol("MQTT", 2);
    AMQPS_WS = new IotHubClientProtocol("AMQPS_WS", 3);
    IotHubClientProtocol localIotHubClientProtocol = new IotHubClientProtocol("MQTT_WS", 4);
    MQTT_WS = localIotHubClientProtocol;
    $VALUES = new IotHubClientProtocol[] { HTTPS, AMQPS, MQTT, AMQPS_WS, localIotHubClientProtocol };
  }
  
  public IotHubClientProtocol() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubClientProtocol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */