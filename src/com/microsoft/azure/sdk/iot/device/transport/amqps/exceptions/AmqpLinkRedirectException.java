package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class AmqpLinkRedirectException
  extends ProtocolException
{
  public static final String errorCode = "amqp:link:redirect";
  
  public AmqpLinkRedirectException()
  {
    isRetryable = true;
  }
  
  public AmqpLinkRedirectException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public AmqpLinkRedirectException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public AmqpLinkRedirectException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.AmqpLinkRedirectException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */