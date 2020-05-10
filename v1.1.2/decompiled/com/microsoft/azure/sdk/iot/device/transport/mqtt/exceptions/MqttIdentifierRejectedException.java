package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class MqttIdentifierRejectedException
  extends ProtocolException
{
  public MqttIdentifierRejectedException() {}
  
  public MqttIdentifierRejectedException(String paramString)
  {
    super(paramString);
  }
  
  public MqttIdentifierRejectedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttIdentifierRejectedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttIdentifierRejectedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */