package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class MqttUnauthorizedException
  extends ProtocolException
{
  public MqttUnauthorizedException() {}
  
  public MqttUnauthorizedException(String paramString)
  {
    super(paramString);
  }
  
  public MqttUnauthorizedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttUnauthorizedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttUnauthorizedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */