package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpSessionHandleInUseException
  extends ProtocolException
{
  public static final String errorCode = "amqp:session:handle-in-use";
  
  public AmqpSessionHandleInUseException()
  {
    isRetryable = true;
  }
  
  public AmqpSessionHandleInUseException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpSessionHandleInUseException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpSessionHandleInUseException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpSessionHandleInUseException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */