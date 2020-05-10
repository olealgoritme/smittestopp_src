package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import l.a.b.a.d.a;
import l.a.b.a.d.f;
import l.a.b.a.d.h;
import l.a.b.a.d.n;
import l.a.b.a.g.d;
import l.f.b;
import l.f.c;

public class ErrorLoggingBaseHandlerWithCleanup
  extends ErrorLoggingBaseHandler
{
  public static final b log = c.a(ErrorLoggingBaseHandlerWithCleanup.class);
  
  public void onConnectionLocalClose(h paramh)
  {
    super.onConnectionLocalClose(paramh);
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.T().e() == l.a.b.a.d.g.CLOSED)
    {
      log.d("Stopping reactor now that amqp connection is closed locally and remotely");
      paramh.b().stop();
    }
  }
  
  public void onConnectionLocalOpen(h paramh)
  {
    super.onConnectionLocalOpen(paramh);
    log.d("Amqp Connection opened locally");
  }
  
  public void onConnectionRemoteClose(h paramh)
  {
    super.onConnectionRemoteClose(paramh);
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.T().t() == l.a.b.a.d.g.CLOSED)
    {
      log.d("Stopping reactor now that connection is closed locally and remotely");
      paramh.b().stop();
    }
    else
    {
      log.e("Closing amqp connection locally since amqp connection was closed remotely");
      paramh.T().close();
    }
  }
  
  public void onConnectionRemoteOpen(h paramh)
  {
    super.onConnectionRemoteOpen(paramh);
    log.e("Amqp Connection opened remotely");
  }
  
  public void onLinkLocalClose(h paramh)
  {
    super.onLinkLocalClose(paramh);
    log.e("Closing amqp session locally since amqp link was closed locally");
    ((l.a.b.a.d.g0.g)paramh).y().close();
  }
  
  public void onLinkLocalOpen(h paramh)
  {
    super.onLinkLocalOpen(paramh);
    log.d("Amqp Link with name {} opened locally", ((l.a.b.a.d.g0.g)paramh).r().getName());
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    super.onLinkRemoteClose(paramh);
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.r().t() == l.a.b.a.d.g.ACTIVE)
    {
      log.e("Closing amqp link locally since amqp link was closed remotely");
      paramh.r().close();
    }
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    super.onLinkRemoteOpen(paramh);
    log.e("Amqp Link with name {} opened remotely", ((l.a.b.a.d.g0.g)paramh).r().getName());
  }
  
  public void onSessionLocalClose(h paramh)
  {
    super.onSessionLocalClose(paramh);
    log.e("Closing amqp connection locally since amqp session was closed locally");
    ((l.a.b.a.d.g0.g)paramh).T().close();
  }
  
  public void onSessionLocalOpen(h paramh)
  {
    super.onSessionLocalOpen(paramh);
    log.d("Amqp Session opened locally");
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    super.onSessionRemoteClose(paramh);
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.y().t() == l.a.b.a.d.g.ACTIVE)
    {
      log.e("Closing amqp session locally since amqp session was closed remotely");
      paramh.y().close();
    }
  }
  
  public void onSessionRemoteOpen(h paramh)
  {
    super.onSessionRemoteOpen(paramh);
    log.e("Amqp Session opened remotely");
  }
  
  public void onTransportError(h paramh)
  {
    super.onTransportError(paramh);
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.T() != null)
    {
      log.e("Closing amqp connection locally since amqp transport error was thrown");
      paramh.T().close();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.ErrorLoggingBaseHandlerWithCleanup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */