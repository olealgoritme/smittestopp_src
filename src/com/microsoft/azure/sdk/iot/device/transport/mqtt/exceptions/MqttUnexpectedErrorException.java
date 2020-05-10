package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class MqttUnexpectedErrorException
  extends ProtocolException
{
  public MqttUnexpectedErrorException() {}
  
  public MqttUnexpectedErrorException(String paramString)
  {
    super(paramString);
  }
  
  public MqttUnexpectedErrorException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttUnexpectedErrorException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttUnexpectedErrorException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */