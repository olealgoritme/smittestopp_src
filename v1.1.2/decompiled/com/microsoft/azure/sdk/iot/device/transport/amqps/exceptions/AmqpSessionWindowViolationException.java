package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpSessionWindowViolationException
  extends ProtocolException
{
  public static final String errorCode = "amqp:session:window-violation";
  
  public AmqpSessionWindowViolationException()
  {
    isRetryable = true;
  }
  
  public AmqpSessionWindowViolationException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpSessionWindowViolationException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpSessionWindowViolationException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionWindowViolationException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */