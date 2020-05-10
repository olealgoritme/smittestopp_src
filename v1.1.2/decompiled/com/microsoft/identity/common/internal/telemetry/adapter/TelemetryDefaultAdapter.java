package com.microsoft.identity.common.internal.telemetry.adapter;

import com.microsoft.identity.common.internal.telemetry.observers.ITelemetryDefaultObserver;
import java.util.List;
import java.util.Map;

public final class TelemetryDefaultAdapter
  implements ITelemetryAdapter<List<Map<String, String>>>
{
  public ITelemetryDefaultObserver mObserver;
  
  public TelemetryDefaultAdapter(ITelemetryDefaultObserver paramITelemetryDefaultObserver)
  {
    mObserver = paramITelemetryDefaultObserver;
  }
  
  public ITelemetryDefaultObserver getObserver()
  {
    return mObserver;
  }
  
  public void process(List<Map<String, String>> paramList)
  {
    ITelemetryDefaultObserver localITelemetryDefaultObserver = mObserver;
    if (localITelemetryDefaultObserver == null) {
      return;
    }
    localITelemetryDefaultObserver.onReceived(paramList);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.adapter.TelemetryDefaultAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */