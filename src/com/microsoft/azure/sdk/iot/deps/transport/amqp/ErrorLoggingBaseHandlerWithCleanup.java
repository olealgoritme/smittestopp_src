package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import k.a.b.a.d.a;
import k.a.b.a.d.f;
import k.a.b.a.d.h;
import k.a.b.a.d.n;
import k.a.b.a.g.d;
import k.f.b;
import k.f.c;

public class ErrorLoggingBaseHandlerWithCleanup
  extends ErrorLoggingBaseHandler
{
  public static final b log = c.a(ErrorLoggingBaseHandlerWithCleanup.class);
  
  public void onConnectionLocalClose(h paramh)
  {
    super.onConnectionLocalClose(paramh);
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.U().e() == k.a.b.a.d.g.CLOSED)
    {
      log.e("Stopping reactor now that amqp connection is closed locally and remotely");
      paramh.b().stop();
    }
  }
  
  public void onConnectionLocalOpen(h paramh)
  {
    super.onConnectionLocalOpen(paramh);
    log.e("Amqp Connection opened locally");
  }
  
  public void onConnectionRemoteClose(h paramh)
  {
    super.onConnectionRemoteClose(paramh);
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.U().J() == k.a.b.a.d.g.CLOSED)
    {
      log.e("Stopping reactor now that connection is closed locally and remotely");
      paramh.b().stop();
    }
    else
    {
      log.b("Closing amqp connection locally since amqp connection was closed remotely");
      paramh.U().close();
    }
  }
  
  public void onConnectionRemoteOpen(h paramh)
  {
    super.onConnectionRemoteOpen(paramh);
    log.b("Amqp Connection opened remotely");
  }
  
  public void onLinkLocalClose(h paramh)
  {
    super.onLinkLocalClose(paramh);
    log.b("Closing amqp session locally since amqp link was closed locally");
    ((k.a.b.a.d.g0.g)paramh).T().close();
  }
  
  public void onLinkLocalOpen(h paramh)
  {
    super.onLinkLocalOpen(paramh);
    log.d("Amqp Link with name {} opened locally", ((k.a.b.a.d.g0.g)paramh).G().getName());
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    super.onLinkRemoteClose(paramh);
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.G().J() == k.a.b.a.d.g.ACTIVE)
    {
      log.b("Closing amqp link locally since amqp link was closed remotely");
      paramh.G().close();
    }
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    super.onLinkRemoteOpen(paramh);
    log.e("Amqp Link with name {} opened remotely", ((k.a.b.a.d.g0.g)paramh).G().getName());
  }
  
  public void onSessionLocalClose(h paramh)
  {
    super.onSessionLocalClose(paramh);
    log.b("Closing amqp connection locally since amqp session was closed locally");
    ((k.a.b.a.d.g0.g)paramh).U().close();
  }
  
  public void onSessionLocalOpen(h paramh)
  {
    super.onSessionLocalOpen(paramh);
    log.e("Amqp Session opened locally");
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    super.onSessionRemoteClose(paramh);
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.T().J() == k.a.b.a.d.g.ACTIVE)
    {
      log.b("Closing amqp session locally since amqp session was closed remotely");
      paramh.T().close();
    }
  }
  
  public void onSessionRemoteOpen(h paramh)
  {
    super.onSessionRemoteOpen(paramh);
    log.b("Amqp Session opened remotely");
  }
  
  public void onTransportError(h paramh)
  {
    super.onTransportError(paramh);
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.U() != null)
    {
      log.b("Closing amqp connection locally since amqp transport error was thrown");
      paramh.U().close();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.ErrorLoggingBaseHandlerWithCleanup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */