package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.internal.telemetry.Properties;

public class BrokerStartEvent
  extends BaseEvent
{
  public BrokerStartEvent()
  {
    names("broker_start_event");
    types("Microsoft.MSAL.broker_event");
  }
  
  public BrokerStartEvent putAction(String paramString)
  {
    put("Microsoft.MSAL.broker_action", paramString);
    return this;
  }
  
  public BrokerStartEvent putStrategy(String paramString)
  {
    put("Microsoft.MSAL.broker_strategy", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.events.BrokerStartEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */