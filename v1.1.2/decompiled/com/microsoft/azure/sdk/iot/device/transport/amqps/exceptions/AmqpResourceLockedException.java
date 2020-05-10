package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpResourceLockedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:resource-locked";
  
  public AmqpResourceLockedException()
  {
    isRetryable = true;
  }
  
  public AmqpResourceLockedException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpResourceLockedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpResourceLockedException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpResourceLockedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */