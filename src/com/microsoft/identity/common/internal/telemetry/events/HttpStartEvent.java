package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.telemetry.Properties;
import java.net.URL;

public class HttpStartEvent
  extends BaseEvent
{
  public HttpStartEvent()
  {
    names("http_start_event");
    types("Microsoft.MSAL.http_event");
  }
  
  public HttpStartEvent putErrorDomain(String paramString)
  {
    put("Microsoft.MSAL.http_error_domain", paramString);
    return this;
  }
  
  public HttpStartEvent putMethod(String paramString)
  {
    put("Microsoft.MSAL.method", paramString);
    return this;
  }
  
  public HttpStartEvent putPath(URL paramURL)
  {
    if (paramURL == null) {
      return this;
    }
    put("Microsoft.MSAL.http_path", paramURL.toExternalForm());
    return this;
  }
  
  public HttpStartEvent putRequestIdHeader(String paramString)
  {
    put("Microsoft.MSAL.x_ms_request_id", paramString);
    return this;
  }
  
  public HttpStartEvent putRequestQueryParams(String paramString)
  {
    put("Microsoft.MSAL.query_params", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.events.HttpStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */