package com.microsoft.azure.sdk.iot.device;

public abstract interface MessageCallback
{
  public abstract IotHubMessageResult execute(Message paramMessage, Object paramObject);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.MessageCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */