package com.microsoft.azure.sdk.iot.device.exceptions;

public class ServiceUnknownException
  extends IotHubServiceException
{
  public ServiceUnknownException() {}
  
  public ServiceUnknownException(String paramString)
  {
    super(paramString);
  }
  
  public ServiceUnknownException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public ServiceUnknownException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.exceptions.ServiceUnknownException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */