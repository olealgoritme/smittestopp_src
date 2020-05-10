package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.telemetry.Properties;

public class UiEndEvent
  extends BaseEvent
{
  public UiEndEvent()
  {
    names("ui_end_event");
    types("Microsoft.MSAL.ui_event");
  }
  
  public UiEndEvent isUiCancelled()
  {
    put("Microsoft.MSAL.ui_cancelled", Boolean.TRUE.toString());
    return this;
  }
  
  public UiEndEvent isUiComplete()
  {
    put("Microsoft.MSAL.ui_complete", Boolean.TRUE.toString());
    return this;
  }
  
  public UiEndEvent isUserCancelled()
  {
    put("Microsoft.MSAL.user_cancel", Boolean.TRUE.toString());
    return this;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.events.UiEndEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */