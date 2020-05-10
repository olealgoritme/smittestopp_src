package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpConnectionRedirectException
  extends ProtocolException
{
  public static final String errorCode = "amqp:connection:redirect";
  
  public AmqpConnectionRedirectException()
  {
    isRetryable = true;
  }
  
  public AmqpConnectionRedirectException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpConnectionRedirectException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpConnectionRedirectException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpConnectionRedirectException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */