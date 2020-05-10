package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.telemetry.Properties;
import java.util.Map;

public class BaseEvent
  extends Properties
{
  public BaseEvent()
  {
    occurs(Long.valueOf(System.currentTimeMillis()));
    correlationId((String)DiagnosticContext.getRequestContext().get("correlation_id"));
  }
  
  public BaseEvent correlationId(String paramString)
  {
    put("Microsoft.MSAL.correlation_id", paramString);
    return this;
  }
  
  public BaseEvent names(String paramString)
  {
    put("Microsoft.MSAL.event_name", paramString);
    return this;
  }
  
  public BaseEvent occurs(Long paramLong)
  {
    if (paramLong == null) {
      put("Microsoft.MSAL.occur_time", String.valueOf(System.currentTimeMillis()));
    } else {
      put("Microsoft.MSAL.occur_time", paramLong.toString());
    }
    return this;
  }
  
  public BaseEvent types(String paramString)
  {
    put("Microsoft.MSAL.event_type", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.events.BaseEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */