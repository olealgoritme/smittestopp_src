package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpIllegalStateException
  extends ProtocolException
{
  public static final String errorCode = "amqp:illegal-state";
  
  public AmqpIllegalStateException() {}
  
  public AmqpIllegalStateException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpIllegalStateException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpIllegalStateException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpIllegalStateException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */