package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpPreconditionFailedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:precondition-failed";
  
  public AmqpPreconditionFailedException() {}
  
  public AmqpPreconditionFailedException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpPreconditionFailedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpPreconditionFailedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpPreconditionFailedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */