package com.microsoft.identity.common.internal.logging;

import java.util.HashMap;

public final class DiagnosticContext$1
  extends ThreadLocal<IRequestContext>
{
  public RequestContext initialValue()
  {
    RequestContext localRequestContext = new RequestContext();
    localRequestContext.put("correlation_id", "UNSET");
    return localRequestContext;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.logging.DiagnosticContext.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */