package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpResourceLimitExceededException
  extends ProtocolException
{
  public static final String errorCode = "amqp:resource-limit-exceeded";
  
  public AmqpResourceLimitExceededException() {}
  
  public AmqpResourceLimitExceededException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpResourceLimitExceededException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpResourceLimitExceededException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpResourceLimitExceededException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */