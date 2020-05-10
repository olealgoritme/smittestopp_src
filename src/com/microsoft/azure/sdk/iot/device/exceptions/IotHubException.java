package com.microsoft.azure.sdk.iot.device.exceptions;

public class IotHubException
  extends Exception
{
  public IotHubException() {}
  
  public IotHubException(String paramString)
  {
    super(paramString);
  }
  
  public IotHubException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public IotHubException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.IotHubException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */