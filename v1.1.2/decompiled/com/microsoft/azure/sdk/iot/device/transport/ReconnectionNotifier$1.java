package com.microsoft.azure.sdk.iot.device.transport;

public final class ReconnectionNotifier$1
  implements Runnable
{
  public ReconnectionNotifier$1(IotHubListener paramIotHubListener, Throwable paramThrowable, String paramString) {}
  
  public void run()
  {
    val$listener.onConnectionLost(val$connectionLossCause, val$connectionId);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.ReconnectionNotifier.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */