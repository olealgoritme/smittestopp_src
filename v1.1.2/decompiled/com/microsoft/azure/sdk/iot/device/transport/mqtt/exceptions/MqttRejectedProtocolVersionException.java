package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class MqttRejectedProtocolVersionException
  extends ProtocolException
{
  public MqttRejectedProtocolVersionException() {}
  
  public MqttRejectedProtocolVersionException(String paramString)
  {
    super(paramString);
  }
  
  public MqttRejectedProtocolVersionException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttRejectedProtocolVersionException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttRejectedProtocolVersionException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */