package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class RequestEntityTooLargeException
  extends IotHubServiceException
{
  public RequestEntityTooLargeException() {}
  
  public RequestEntityTooLargeException(String paramString)
  {
    super(paramString);
  }
  
  public RequestEntityTooLargeException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public RequestEntityTooLargeException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.REQUEST_ENTITY_TOO_LARGE;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.RequestEntityTooLargeException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */