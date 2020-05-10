package com.microsoft.azure.sdk.iot.device.exceptions;

public class DeviceClientException
  extends Exception
{
  public DeviceClientException() {}
  
  public DeviceClientException(String paramString)
  {
    super(paramString);
  }
  
  public DeviceClientException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public DeviceClientException(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
  }
  
  public DeviceClientException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.exceptions.DeviceClientException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */