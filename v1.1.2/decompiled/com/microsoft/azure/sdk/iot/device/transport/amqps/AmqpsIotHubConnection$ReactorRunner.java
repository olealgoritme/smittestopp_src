package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubListener;
import java.util.concurrent.Callable;
import l.a.b.a.d.m;

public class AmqpsIotHubConnection$ReactorRunner
  implements Callable
{
  public static final String THREAD_NAME = "azure-iot-sdk-ReactorRunner";
  public String connectionId;
  public final IotHubReactor iotHubReactor;
  public final IotHubListener listener;
  
  public AmqpsIotHubConnection$ReactorRunner(AmqpsIotHubConnection paramAmqpsIotHubConnection, IotHubReactor paramIotHubReactor, IotHubListener paramIotHubListener, String paramString)
  {
    listener = paramIotHubListener;
    iotHubReactor = paramIotHubReactor;
    connectionId = paramString;
  }
  
  public Object call()
  {
    try
    {
      Thread.currentThread().setName("azure-iot-sdk-ReactorRunner");
      iotHubReactor.run();
    }
    catch (m localm)
    {
      listener.onConnectionLost(new TransportException(localm), connectionId);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpsIotHubConnection.ReactorRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */