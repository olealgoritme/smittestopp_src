package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class UnauthorizedException
  extends IotHubServiceException
{
  public UnauthorizedException() {}
  
  public UnauthorizedException(String paramString)
  {
    super(paramString);
  }
  
  public UnauthorizedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UnauthorizedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.UNAUTHORIZED;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.exceptions.UnauthorizedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */