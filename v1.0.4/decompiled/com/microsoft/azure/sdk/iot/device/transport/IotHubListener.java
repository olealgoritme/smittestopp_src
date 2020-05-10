package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.Message;

public abstract interface IotHubListener
{
  public abstract void onConnectionEstablished(String paramString);
  
  public abstract void onConnectionLost(Throwable paramThrowable, String paramString);
  
  public abstract void onMessageReceived(IotHubTransportMessage paramIotHubTransportMessage, Throwable paramThrowable);
  
  public abstract void onMessageSent(Message paramMessage, Throwable paramThrowable);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.IotHubListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */