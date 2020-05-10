package com.microsoft.identity.common.internal.telemetry.adapter;

public abstract interface ITelemetryAdapter<T>
{
  public abstract void process(T paramT);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.adapter.ITelemetryAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */