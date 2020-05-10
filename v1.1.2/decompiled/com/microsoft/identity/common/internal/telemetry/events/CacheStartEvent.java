package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.telemetry.Properties;

public class CacheStartEvent
  extends BaseEvent
{
  public CacheStartEvent()
  {
    names("cache_start_event");
    types("Microsoft.MSAL.cache_event");
  }
  
  public CacheStartEvent isAt(boolean paramBoolean)
  {
    put("Microsoft.MSAL.is_at", String.valueOf(paramBoolean));
    return this;
  }
  
  public CacheStartEvent isFrt(boolean paramBoolean)
  {
    put("Microsoft.MSAL.is_frt", String.valueOf(paramBoolean));
    return this;
  }
  
  public CacheStartEvent isMrrt(boolean paramBoolean)
  {
    put("Microsoft.MSAL.is_mrrt", String.valueOf(paramBoolean));
    return this;
  }
  
  public CacheStartEvent isRt(boolean paramBoolean)
  {
    put("Microsoft.MSAL.is_rt", String.valueOf(paramBoolean));
    return this;
  }
  
  public CacheStartEvent putTokenType(String paramString)
  {
    put("Microsoft.MSAL.token_type", paramString);
    return this;
  }
  
  public CacheStartEvent putWipeApp(boolean paramBoolean)
  {
    put("Microsoft.MSAL.wipe_app", String.valueOf(paramBoolean));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.events.CacheStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */