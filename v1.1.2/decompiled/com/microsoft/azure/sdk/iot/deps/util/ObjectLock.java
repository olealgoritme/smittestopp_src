package com.microsoft.azure.sdk.iot.deps.util;

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
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.util.ObjectLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */