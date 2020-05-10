package com.microsoft.azure.sdk.iot.device;

public abstract interface IotHubEventCallback
{
  public abstract void execute(IotHubStatusCode paramIotHubStatusCode, Object paramObject);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.IotHubEventCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */