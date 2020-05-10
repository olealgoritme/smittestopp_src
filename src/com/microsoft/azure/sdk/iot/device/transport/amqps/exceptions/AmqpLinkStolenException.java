package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpLinkStolenException
  extends ProtocolException
{
  public static final String errorCode = "amqp:link:stolen";
  
  public AmqpLinkStolenException()
  {
    isRetryable = true;
  }
  
  public AmqpLinkStolenException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpLinkStolenException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpLinkStolenException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkStolenException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */