package com.microsoft.azure.sdk.iot.deps.transport.mqtt;

public abstract interface MqttListener
{
  public abstract void connectionEstablished();
  
  public abstract void connectionLost(Throwable paramThrowable);
  
  public abstract void messageReceived(MqttMessage paramMqttMessage);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.mqtt.MqttListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */