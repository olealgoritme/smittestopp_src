package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class TooManyDevicesException
  extends IotHubServiceException
{
  public TooManyDevicesException() {}
  
  public TooManyDevicesException(String paramString)
  {
    super(paramString);
  }
  
  public TooManyDevicesException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public TooManyDevicesException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.TOO_MANY_DEVICES;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.TooManyDevicesException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */