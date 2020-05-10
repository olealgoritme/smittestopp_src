package com.microsoft.identity.common.internal.telemetry.observers;

import java.util.List;
import java.util.Map;

public abstract interface ITelemetryDefaultObserver
  extends ITelemetryObserver<List<Map<String, String>>>
{
  public abstract void onReceived(List<Map<String, String>> paramList);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.observers.ITelemetryDefaultObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */