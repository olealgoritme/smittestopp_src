package com.microsoft.azure.sdk.iot.device.transport;

import java.util.Queue;

public class IotHubTransport$MessageRetryRunnable
  implements Runnable
{
  public final IotHubTransportPacket transportPacket;
  public final Queue<IotHubTransportPacket> waitingPacketsQueue;
  
  public IotHubTransport$MessageRetryRunnable(Queue<IotHubTransportPacket> paramQueue, IotHubTransportPacket paramIotHubTransportPacket)
  {
    waitingPacketsQueue = paramIotHubTransportPacket;
    IotHubTransportPacket localIotHubTransportPacket;
    transportPacket = localIotHubTransportPacket;
  }
  
  public void run()
  {
    waitingPacketsQueue.add(transportPacket);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.IotHubTransport.MessageRetryRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */