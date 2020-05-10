package com.microsoft.azure.sdk.iot.device.exceptions;

public class ProtocolException
  extends TransportException
{
  public ProtocolException() {}
  
  public ProtocolException(String paramString)
  {
    super(paramString);
  }
  
  public ProtocolException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ProtocolException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */