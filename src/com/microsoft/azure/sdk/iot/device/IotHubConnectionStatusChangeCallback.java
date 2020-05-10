package com.microsoft.azure.sdk.iot.device;

import com.microsoft.azure.sdk.iot.device.transport.IotHubConnectionStatus;

public abstract interface IotHubConnectionStatusChangeCallback
{
  public abstract void execute(IotHubConnectionStatus paramIotHubConnectionStatus, IotHubConnectionStatusChangeReason paramIotHubConnectionStatusChangeReason, Throwable paramThrowable, Object paramObject);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.IotHubConnectionStatusChangeCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */