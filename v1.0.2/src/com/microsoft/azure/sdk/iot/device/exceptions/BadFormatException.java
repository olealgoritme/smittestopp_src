package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class BadFormatException
  extends IotHubServiceException
{
  public BadFormatException() {}
  
  public BadFormatException(String paramString)
  {
    super(paramString);
  }
  
  public BadFormatException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public BadFormatException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.BAD_FORMAT;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.BadFormatException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */