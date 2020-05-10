package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpFrameSizeTooSmallException
  extends ProtocolException
{
  public static final String errorCode = "amqp:frame-size-too-small";
  
  public AmqpFrameSizeTooSmallException() {}
  
  public AmqpFrameSizeTooSmallException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpFrameSizeTooSmallException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpFrameSizeTooSmallException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpFrameSizeTooSmallException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */