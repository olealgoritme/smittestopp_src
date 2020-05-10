package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import com.microsoft.azure.sdk.iot.deps.util.CustomLogger;
import java.util.concurrent.Callable;
import k.a.b.a.d.m;

public class AmqpsConnection$ReactorRunner
  implements Callable
{
  public static final String THREAD_NAME = "azure-iot-sdk-ReactorRunner";
  public final AmqpReactor amqpReactor;
  public final CustomLogger logger;
  
  public AmqpsConnection$ReactorRunner(AmqpsConnection paramAmqpsConnection, AmqpReactor paramAmqpReactor, CustomLogger paramCustomLogger)
  {
    amqpReactor = paramAmqpReactor;
    logger = paramCustomLogger;
  }
  
  public Object call()
  {
    Thread.currentThread().setName("azure-iot-sdk-ReactorRunner");
    try
    {
      amqpReactor.run();
      return null;
    }
    catch (m localm)
    {
      logger.LogError(localm);
      throw localm;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.AmqpsConnection.ReactorRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */