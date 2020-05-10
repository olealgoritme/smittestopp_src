package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class IotHubServiceException
  extends TransportException
{
  public IotHubServiceException() {}
  
  public IotHubServiceException(String paramString)
  {
    super(paramString);
  }
  
  public IotHubServiceException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public IotHubServiceException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.ERROR;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.IotHubServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */