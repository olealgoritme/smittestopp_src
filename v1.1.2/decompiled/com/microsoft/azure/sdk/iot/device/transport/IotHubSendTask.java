package com.microsoft.azure.sdk.iot.device.transport;

import l.f.b;
import l.f.c;

public final class IotHubSendTask
  implements Runnable
{
  public static final String THREAD_NAME = "azure-iot-sdk-IotHubSendTask";
  public static final b log = c.a(IotHubSendTask.class);
  public final IotHubTransport transport;
  
  public IotHubSendTask(IotHubTransport paramIotHubTransport)
  {
    if (paramIotHubTransport != null)
    {
      transport = paramIotHubTransport;
      return;
    }
    throw new IllegalArgumentException("Parameter 'transport' must not be null");
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 45	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: ldc 10
    //   5: invokevirtual 48	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 31	com/microsoft/azure/sdk/iot/device/transport/IotHubSendTask:transport	Lcom/microsoft/azure/sdk/iot/device/transport/IotHubTransport;
    //   12: invokevirtual 53	com/microsoft/azure/sdk/iot/device/transport/IotHubTransport:sendMessages	()V
    //   15: aload_0
    //   16: getfield 31	com/microsoft/azure/sdk/iot/device/transport/IotHubSendTask:transport	Lcom/microsoft/azure/sdk/iot/device/transport/IotHubTransport;
    //   19: invokevirtual 56	com/microsoft/azure/sdk/iot/device/transport/IotHubTransport:invokeCallbacks	()V
    //   22: goto +15 -> 37
    //   25: astore_1
    //   26: getstatic 24	com/microsoft/azure/sdk/iot/device/transport/IotHubSendTask:log	Ll/f/b;
    //   29: ldc 58
    //   31: aload_1
    //   32: invokeinterface 64 3 0
    //   37: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	IotHubSendTask
    //   25	7	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	22	25	finally
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.IotHubSendTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */