package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import k.a.b.a.d.a;
import k.a.b.a.d.f;
import k.a.b.a.d.h;
import k.a.b.a.d.n;
import k.f.b;
import k.f.c;

public class ErrorLoggingBaseHandler
  extends a
{
  public static final b log = c.a(ErrorLoggingBaseHandler.class);
  public ProtonJExceptionParser protonJExceptionParser;
  
  public void onConnectionRemoteClose(h paramh)
  {
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.U().J().equals(k.a.b.a.d.g.ACTIVE))
    {
      paramh = new ProtonJExceptionParser(paramh);
      protonJExceptionParser = paramh;
      if (paramh.getError() == null) {
        log.a("Amqp connection was closed remotely with an unknown exception");
      } else {
        log.d("Amqp connection was closed remotely with exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
      }
    }
    else
    {
      log.e("Amqp connection closed remotely after being closed locally");
    }
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.G().J().equals(k.a.b.a.d.g.ACTIVE))
    {
      ProtonJExceptionParser localProtonJExceptionParser = new ProtonJExceptionParser(paramh);
      protonJExceptionParser = localProtonJExceptionParser;
      if (localProtonJExceptionParser.getError() == null) {
        log.a("Amqp link {} was closed remotely", paramh.G().getName());
      } else if (paramh.G().getName() != null) {
        log.a("Amqp link {} was closed remotely with exception {} with description {}", new Object[] { paramh.G().getName(), protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription() });
      } else {
        log.d("Unknown amqp link was closed remotely with exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
      }
    }
    else
    {
      log.d("Amqp link {} closed remotely after being closed locally", paramh.G().getName());
    }
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    paramh = (k.a.b.a.d.g0.g)paramh;
    if (paramh.T().J().equals(k.a.b.a.d.g.ACTIVE))
    {
      paramh = new ProtonJExceptionParser(paramh);
      protonJExceptionParser = paramh;
      if (paramh.getError() == null) {
        log.a("Amqp session was closed remotely with an unknown exception");
      } else {
        log.d("Amqp session was closed remotely with exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
      }
    }
    else
    {
      log.e("Amqp session closed remotely after being closed locally");
    }
  }
  
  public void onTransportError(h paramh)
  {
    paramh = new ProtonJExceptionParser(paramh);
    protonJExceptionParser = paramh;
    if (paramh.getError() == null) {
      log.a("Amqp transport threw an unknown exception");
    } else {
      log.d("Amqp transport threw exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.amqp.ErrorLoggingBaseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */