package com.microsoft.azure.sdk.iot.device.transport;

import e.a.a.a.a;

public final class ReconnectionNotifier
{
  public static final String THREAD_NAME = "azure-iot-sdk-ReconnectionTask";
  
  public static void notifyDisconnectAsync(final Throwable paramThrowable, IotHubListener paramIotHubListener, final String paramString)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        val$listener.onConnectionLost(paramThrowable, paramString);
      }
    }, a.b("azure-iot-sdk-ReconnectionTask:", paramString)).start();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.ReconnectionNotifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */