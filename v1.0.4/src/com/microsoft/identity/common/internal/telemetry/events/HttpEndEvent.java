package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.telemetry.Properties;

public class HttpEndEvent
  extends BaseEvent
{
  public HttpEndEvent()
  {
    names("http_end_event");
    types("Microsoft.MSAL.http_event");
  }
  
  public HttpEndEvent putStatusCode(int paramInt)
  {
    put("Microsoft.MSAL.response_code", String.valueOf(paramInt));
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.events.HttpEndEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */