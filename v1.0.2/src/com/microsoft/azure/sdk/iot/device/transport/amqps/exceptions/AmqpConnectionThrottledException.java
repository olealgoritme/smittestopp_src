package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpConnectionThrottledException
  extends ProtocolException
{
  public static final String errorCode = "com.microsoft:device-container-throttled";
  
  public AmqpConnectionThrottledException()
  {
    isRetryable = true;
  }
  
  public AmqpConnectionThrottledException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpConnectionThrottledException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpConnectionThrottledException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionThrottledException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */