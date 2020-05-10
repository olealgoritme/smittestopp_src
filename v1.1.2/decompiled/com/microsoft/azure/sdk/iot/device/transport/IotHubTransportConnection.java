package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.IotHubMessageResult;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;

public abstract interface IotHubTransportConnection
{
  public abstract void close();
  
  public abstract String getConnectionId();
  
  public abstract void open(Queue<DeviceClientConfig> paramQueue, ScheduledExecutorService paramScheduledExecutorService);
  
  public abstract IotHubStatusCode sendMessage(Message paramMessage);
  
  public abstract boolean sendMessageResult(Message paramMessage, IotHubMessageResult paramIotHubMessageResult);
  
  public abstract void setListener(IotHubListener paramIotHubListener);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.IotHubTransportConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */