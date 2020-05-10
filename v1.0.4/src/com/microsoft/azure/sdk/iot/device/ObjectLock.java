package com.microsoft.azure.sdk.iot.device;

public class ObjectLock
{
  public void notifyLock()
  {
    notify();
  }
  
  public void waitLock(long paramLong)
  {
    wait(paramLong);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.ObjectLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */