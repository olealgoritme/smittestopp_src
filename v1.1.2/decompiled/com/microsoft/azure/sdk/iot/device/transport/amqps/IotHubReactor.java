package com.microsoft.azure.sdk.iot.device.transport.amqps;

import l.a.b.a.g.d;

public class IotHubReactor
{
  public final d reactor;
  
  public IotHubReactor(d paramd)
  {
    reactor = paramd;
  }
  
  public void run()
  {
    reactor.c(10L);
    reactor.start();
    while (reactor.process()) {}
    reactor.stop();
    reactor.process();
    reactor.a();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.amqps.IotHubReactor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */