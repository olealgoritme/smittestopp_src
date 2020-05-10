package com.microsoft.azure.sdk.iot.device.hsm;

import com.microsoft.azure.sdk.iot.device.exceptions.DeviceClientException;

public class HsmException
  extends DeviceClientException
{
  public HsmException() {}
  
  public HsmException(String paramString)
  {
    super(paramString);
  }
  
  public HsmException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public HsmException(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
  }
  
  public HsmException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.hsm.HsmException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */