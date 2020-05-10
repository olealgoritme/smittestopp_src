package com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;

public class ProtonIOException
  extends ProtocolException
{
  public static final String errorCode = "proton:io";
  
  public ProtonIOException()
  {
    isRetryable = true;
  }
  
  public ProtonIOException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public ProtonIOException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public ProtonIOException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.exceptions.ProtonIOException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */