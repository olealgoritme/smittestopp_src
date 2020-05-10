package com.microsoft.azure.sdk.iot.device.transport.amqps;

import com.microsoft.azure.sdk.iot.device.DeviceClientConfig;
import com.microsoft.azure.sdk.iot.device.auth.IotHubSasTokenAuthenticationProvider;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import k.a.b.a.d.a;
import k.a.b.a.d.g0.g;
import k.a.b.a.d.h;
import k.a.b.a.g.d;
import k.f.b;
import k.f.c;

public class AmqpSasTokenRenewalHandler
  extends a
{
  public static final b log = c.a(AmqpSasTokenRenewalHandler.class);
  public AmqpsSessionManager amqpsSessionManager;
  public DeviceClientConfig config;
  public int retryPeriodMilliseconds = 5000;
  
  public AmqpSasTokenRenewalHandler(AmqpsSessionManager paramAmqpsSessionManager, DeviceClientConfig paramDeviceClientConfig)
  {
    amqpsSessionManager = paramAmqpsSessionManager;
    config = paramDeviceClientConfig;
  }
  
  public void onTimerTask(h paramh)
  {
    try
    {
      log.e("AmqpSasTokenRenewalHandler OnTimerTask called, sending authentication message");
      amqpsSessionManager.authenticate();
      g localg = (g)paramh;
      localg.b().a(config.getSasTokenAuthentication().getMillisecondsBeforeProactiveRenewal(), this);
    }
    catch (TransportException localTransportException)
    {
      if (localTransportException.isRetryable())
      {
        log.b("Failed to send authentication message, trying again in {} milliseconds", Integer.valueOf(retryPeriodMilliseconds), localTransportException);
        ((g)paramh).b().a(retryPeriodMilliseconds, this);
      }
      else
      {
        log.e("Failed to send authentication message, unable to try again", localTransportException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.amqps.AmqpSasTokenRenewalHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */