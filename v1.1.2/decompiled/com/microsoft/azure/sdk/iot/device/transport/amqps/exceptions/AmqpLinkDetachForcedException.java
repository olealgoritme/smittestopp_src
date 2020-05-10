package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpLinkDetachForcedException
  extends ProtocolException
{
  public static final String errorCode = "amqp:link:detach-forced";
  
  public AmqpLinkDetachForcedException()
  {
    isRetryable = true;
  }
  
  public AmqpLinkDetachForcedException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpLinkDetachForcedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpLinkDetachForcedException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkDetachForcedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */