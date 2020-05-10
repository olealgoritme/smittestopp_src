package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import l.a.b.a.d.a;
import l.a.b.a.d.f;
import l.a.b.a.d.h;
import l.a.b.a.d.n;
import l.f.b;
import l.f.c;

public class ErrorLoggingBaseHandler
  extends a
{
  public static final b log = c.a(ErrorLoggingBaseHandler.class);
  public ProtonJExceptionParser protonJExceptionParser;
  
  public void onConnectionRemoteClose(h paramh)
  {
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.T().t().equals(l.a.b.a.d.g.ACTIVE))
    {
      paramh = new ProtonJExceptionParser(paramh);
      protonJExceptionParser = paramh;
      if (paramh.getError() == null) {
        log.a("Amqp connection was closed remotely with an unknown exception");
      } else {
        log.e("Amqp connection was closed remotely with exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
      }
    }
    else
    {
      log.d("Amqp connection closed remotely after being closed locally");
    }
  }
  
  public void onLinkRemoteClose(h paramh)
  {
    l.a.b.a.d.g0.g localg = (l.a.b.a.d.g0.g)paramh;
    if (localg.r().t().equals(l.a.b.a.d.g.ACTIVE))
    {
      paramh = new ProtonJExceptionParser(localg);
      protonJExceptionParser = paramh;
      if (paramh.getError() == null) {
        log.a("Amqp link {} was closed remotely", localg.r().getName());
      } else if (localg.r().getName() != null) {
        log.c("Amqp link {} was closed remotely with exception {} with description {}", new Object[] { localg.r().getName(), protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription() });
      } else {
        log.e("Unknown amqp link was closed remotely with exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
      }
    }
    else
    {
      log.d("Amqp link {} closed remotely after being closed locally", localg.r().getName());
    }
  }
  
  public void onSessionRemoteClose(h paramh)
  {
    paramh = (l.a.b.a.d.g0.g)paramh;
    if (paramh.y().t().equals(l.a.b.a.d.g.ACTIVE))
    {
      paramh = new ProtonJExceptionParser(paramh);
      protonJExceptionParser = paramh;
      if (paramh.getError() == null) {
        log.a("Amqp session was closed remotely with an unknown exception");
      } else {
        log.e("Amqp session was closed remotely with exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
      }
    }
    else
    {
      log.d("Amqp session closed remotely after being closed locally");
    }
  }
  
  public void onTransportError(h paramh)
  {
    paramh = new ProtonJExceptionParser(paramh);
    protonJExceptionParser = paramh;
    if (paramh.getError() == null) {
      log.a("Amqp transport threw an unknown exception");
    } else {
      log.e("Amqp transport threw exception {} with description {}", protonJExceptionParser.getError(), protonJExceptionParser.getErrorDescription());
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.ErrorLoggingBaseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */