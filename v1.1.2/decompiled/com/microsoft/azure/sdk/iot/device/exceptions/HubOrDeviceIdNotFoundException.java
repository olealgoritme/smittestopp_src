package com.microsoft.azure.sdk.iot.device.exceptions;

import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;

public class HubOrDeviceIdNotFoundException
  extends IotHubServiceException
{
  public HubOrDeviceIdNotFoundException() {}
  
  public HubOrDeviceIdNotFoundException(String paramString)
  {
    super(paramString);
  }
  
  public HubOrDeviceIdNotFoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public HubOrDeviceIdNotFoundException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public IotHubStatusCode getStatusCode()
  {
    return IotHubStatusCode.HUB_OR_DEVICE_ID_NOT_FOUND;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.exceptions.HubOrDeviceIdNotFoundException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */