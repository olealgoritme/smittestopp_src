package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpInvalidFieldException
  extends ProtocolException
{
  public static final String errorCode = "amqp:invalid-field";
  
  public AmqpInvalidFieldException() {}
  
  public AmqpInvalidFieldException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpInvalidFieldException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpInvalidFieldException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpInvalidFieldException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */