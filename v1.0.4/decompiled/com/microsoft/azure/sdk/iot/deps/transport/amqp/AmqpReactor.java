package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import k.a.b.a.g.d;

public class AmqpReactor
{
  public static final int REACTOR_TIMEOUT = 10;
  public final d reactor;
  
  public AmqpReactor(d paramd)
  {
    reactor = paramd;
  }
  
  public void run()
  {
    reactor.b(10L);
    reactor.start();
    while (reactor.process()) {}
    reactor.stop();
    reactor.process();
    reactor.a();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.AmqpReactor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */