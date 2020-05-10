package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class ThrottledException
  extends IotHubServiceException
{
  public ThrottledException()
  {
    isRetryable = true;
  }
  
  public ThrottledException(String paramString)
  {
    super(paramString);
    isRetryable = true;
  }
  
  public ThrottledException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    isRetryable = true;
  }
  
  public ThrottledException(Throwable paramThrowable)
  {
    super(paramThrowable);
    isRetryable = true;
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.THROTTLED;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.ThrottledException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */