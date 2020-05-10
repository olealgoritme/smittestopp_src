package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpNotAllowedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:not-allowed";
  
  public AmqpNotAllowedException() {}
  
  public AmqpNotAllowedException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpNotAllowedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpNotAllowedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpNotAllowedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */