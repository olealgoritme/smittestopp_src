package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpConnectionFramingErrorException
  extends ProtocolException
{
  public static final String errorCode = "amqp:connection:framing-error";
  
  public AmqpConnectionFramingErrorException()
  {
    isRetryable = true;
  }
  
  public AmqpConnectionFramingErrorException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpConnectionFramingErrorException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpConnectionFramingErrorException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionFramingErrorException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */