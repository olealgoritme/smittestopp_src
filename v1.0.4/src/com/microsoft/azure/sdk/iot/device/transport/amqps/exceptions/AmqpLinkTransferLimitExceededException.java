package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpLinkTransferLimitExceededException
  extends ProtocolException
{
  public static final String errorCode = "amqp:link:transfer-limit-exceeded";
  
  public AmqpLinkTransferLimitExceededException()
  {
    isRetryable = true;
  }
  
  public AmqpLinkTransferLimitExceededException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpLinkTransferLimitExceededException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpLinkTransferLimitExceededException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkTransferLimitExceededException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */