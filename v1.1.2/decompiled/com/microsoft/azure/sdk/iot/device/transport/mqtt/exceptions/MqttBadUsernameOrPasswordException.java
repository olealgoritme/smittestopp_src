package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class MqttBadUsernameOrPasswordException
  extends ProtocolException
{
  public MqttBadUsernameOrPasswordException() {}
  
  public MqttBadUsernameOrPasswordException(String paramString)
  {
    super(paramString);
  }
  
  public MqttBadUsernameOrPasswordException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public MqttBadUsernameOrPasswordException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttBadUsernameOrPasswordException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */