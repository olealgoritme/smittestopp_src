package com.microsoft.azure.sdk.iot.deps.transport.mqtt;

public enum MqttQos
{
  static
  {
    DELIVER_AT_LEAST_ONCE = new MqttQos("DELIVER_AT_LEAST_ONCE", 1);
    DELIVER_EXACTLY_ONCE = new MqttQos("DELIVER_EXACTLY_ONCE", 2);
    DELIVER_FAILURE = new MqttQos("DELIVER_FAILURE", 3);
    MqttQos localMqttQos = new MqttQos("DELIVER_UNKNOWN", 4);
    DELIVER_UNKNOWN = localMqttQos;
    $VALUES = new MqttQos[] { DELIVER_AT_MOST_ONCE, DELIVER_AT_LEAST_ONCE, DELIVER_EXACTLY_ONCE, DELIVER_FAILURE, localMqttQos };
  }
  
  public MqttQos() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.mqtt.MqttQos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */