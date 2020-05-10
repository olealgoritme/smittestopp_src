package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpResourceDeletedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:resource-deleted";
  
  public AmqpResourceDeletedException() {}
  
  public AmqpResourceDeletedException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpResourceDeletedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpResourceDeletedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpResourceDeletedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */