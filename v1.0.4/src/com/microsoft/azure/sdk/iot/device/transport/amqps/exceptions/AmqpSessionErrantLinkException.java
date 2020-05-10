package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpSessionErrantLinkException
  extends ProtocolException
{
  public static final String errorCode = "amqp:session:errant-link";
  
  public AmqpSessionErrantLinkException()
  {
    isRetryable = true;
  }
  
  public AmqpSessionErrantLinkException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpSessionErrantLinkException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpSessionErrantLinkException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionErrantLinkException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */