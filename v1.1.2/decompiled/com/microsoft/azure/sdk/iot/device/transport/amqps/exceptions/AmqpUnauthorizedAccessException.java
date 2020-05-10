package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpUnauthorizedAccessException
  extends ProtocolException
{
  public static final String errorCode = "amqp:unauthorized-access";
  
  public AmqpUnauthorizedAccessException() {}
  
  public AmqpUnauthorizedAccessException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpUnauthorizedAccessException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpUnauthorizedAccessException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpUnauthorizedAccessException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */