package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpDecodeErrorException
  extends ProtocolException
{
  public static final String errorCode = "amqp:decode-error";
  
  public AmqpDecodeErrorException() {}
  
  public AmqpDecodeErrorException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpDecodeErrorException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpDecodeErrorException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpDecodeErrorException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */