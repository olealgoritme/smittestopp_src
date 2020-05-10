package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpNotImplementedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:not-implemented";
  
  public AmqpNotImplementedException() {}
  
  public AmqpNotImplementedException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpNotImplementedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpNotImplementedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpNotImplementedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */