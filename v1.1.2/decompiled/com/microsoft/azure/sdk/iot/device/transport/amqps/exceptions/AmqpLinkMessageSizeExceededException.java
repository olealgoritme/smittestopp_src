package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpLinkMessageSizeExceededException
  extends ProtocolException
{
  public static final String errorCode = "amqp:link:message-size-exceeded";
  
  public AmqpLinkMessageSizeExceededException() {}
  
  public AmqpLinkMessageSizeExceededException(String paramString)
  {
    super(paramString);
  }
  
  public AmqpLinkMessageSizeExceededException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AmqpLinkMessageSizeExceededException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkMessageSizeExceededException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */