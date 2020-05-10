package com.microsoft.identity.common.internal.telemetry.observers;

import java.util.Map;

public abstract interface ITelemetryAggregatedObserver
  extends ITelemetryObserver<Map<String, String>>
{
  public abstract void onReceived(Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.observers.ITelemetryAggregatedObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */