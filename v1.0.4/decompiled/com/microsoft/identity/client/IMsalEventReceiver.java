package com.microsoft.identity.client;

import java.util.List;
import java.util.Map;

public abstract interface IMsalEventReceiver
{
  public abstract void onEventsReceived(List<Map<String, String>> paramList);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.IMsalEventReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */