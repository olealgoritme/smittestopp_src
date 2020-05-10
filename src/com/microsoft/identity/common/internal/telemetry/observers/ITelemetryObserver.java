package com.microsoft.identity.common.internal.telemetry.observers;

public abstract interface ITelemetryObserver<T>
{
  public abstract void onReceived(T paramT);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.telemetry.observers.ITelemetryObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */