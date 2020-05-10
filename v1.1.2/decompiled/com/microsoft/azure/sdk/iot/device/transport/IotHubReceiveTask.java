package com.microsoft.azure.sdk.iot.device.transport;

import l.f.b;
import l.f.c;

public final class IotHubReceiveTask
  implements Runnable
{
  public static final String THREAD_NAME = "azure-iot-sdk-IotHubReceiveTask";
  public static final b log = c.a(IotHubReceiveTask.class);
  public final IotHubTransport transport;
  
  public IotHubReceiveTask(IotHubTransport paramIotHubTransport)
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
    //   9: getfield 31	com/microsoft/azure/sdk/iot/device/transport/IotHubReceiveTask:transport	Lcom/microsoft/azure/sdk/iot/device/transport/IotHubTransport;
    //   12: invokevirtual 53	com/microsoft/azure/sdk/iot/device/transport/IotHubTransport:handleMessage	()V
    //   15: goto +15 -> 30
    //   18: astore_1
    //   19: getstatic 24	com/microsoft/azure/sdk/iot/device/transport/IotHubReceiveTask:log	Ll/f/b;
    //   22: ldc 55
    //   24: aload_1
    //   25: invokeinterface 61 3 0
    //   30: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	IotHubReceiveTask
    //   18	7	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	15	18	finally
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.IotHubReceiveTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */