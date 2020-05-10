package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpConnectionForcedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:connection:forced";
  
  public AmqpConnectionForcedException()
  {
    isRetryable = true;
  }
  
  public AmqpConnectionForcedException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpConnectionForcedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpConnectionForcedException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionForcedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */