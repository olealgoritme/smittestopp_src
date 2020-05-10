package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpNotFoundException
  extends ProtocolException
{
  public static final String errorCode = "amqp:not-found";
  
  public AmqpNotFoundException() {}
  
  public AmqpNotFoundException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpNotFoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpNotFoundException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpNotFoundException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */