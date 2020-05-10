package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.telemetry.Properties;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;

public class UiStartEvent
  extends BaseEvent
{
  public UiStartEvent()
  {
    names("ui_start_event");
    types("Microsoft.MSAL.ui_event");
  }
  
  public UiStartEvent isForcePrompt(boolean paramBoolean)
  {
    put("Microsoft.MSAL.force_prompt", String.valueOf(paramBoolean));
    return this;
  }
  
  public UiStartEvent putLoginHint(String paramString)
  {
    put("Microsoft.MSAL.login_hint", paramString);
    return this;
  }
  
  public UiStartEvent putUserAgent(AuthorizationAgent paramAuthorizationAgent)
  {
    if (paramAuthorizationAgent == null) {
      return this;
    }
    put("Microsoft.MSAL.user_agent", paramAuthorizationAgent.name());
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.events.UiStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */