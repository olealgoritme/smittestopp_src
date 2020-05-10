package com.microsoft.azure.sdk.iot.device.exceptions;

public class DeviceOperationTimeoutException
  extends DeviceClientException
{
  public DeviceOperationTimeoutException() {}
  
  public DeviceOperationTimeoutException(String paramString)
  {
    super(paramString);
  }
  
  public DeviceOperationTimeoutException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public DeviceOperationTimeoutException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.DeviceOperationTimeoutException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */