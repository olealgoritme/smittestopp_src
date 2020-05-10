package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class MqttServerUnavailableException
  extends ProtocolException
{
  public MqttServerUnavailableException()
  {
    isRetryable = true;
  }
  
  public MqttServerUnavailableException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public MqttServerUnavailableException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public MqttServerUnavailableException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.MqttServerUnavailableException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */