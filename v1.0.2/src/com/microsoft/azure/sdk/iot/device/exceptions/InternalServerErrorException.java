package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class InternalServerErrorException
  extends IotHubServiceException
{
  public InternalServerErrorException() {}
  
  public InternalServerErrorException(String paramString)
  {
    super(paramString);
  }
  
  public InternalServerErrorException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public InternalServerErrorException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.INTERNAL_SERVER_ERROR;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.InternalServerErrorException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */