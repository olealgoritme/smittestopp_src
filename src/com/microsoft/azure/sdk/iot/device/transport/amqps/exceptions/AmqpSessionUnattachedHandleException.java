package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpSessionUnattachedHandleException
  extends ProtocolException
{
  public static final String errorCode = "amqp:session:unattached-handle";
  
  public AmqpSessionUnattachedHandleException()
  {
    isRetryable = true;
  }
  
  public AmqpSessionUnattachedHandleException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpSessionUnattachedHandleException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpSessionUnattachedHandleException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionUnattachedHandleException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */