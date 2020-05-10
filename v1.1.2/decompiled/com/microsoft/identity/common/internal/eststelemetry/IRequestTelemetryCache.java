package com.microsoft.identity.common.internal.eststelemetry;

public abstract interface IRequestTelemetryCache
{
  public abstract void clearAll();
  
  public abstract RequestTelemetry getRequestTelemetryFromCache();
  
  public abstract void saveRequestTelemetryToCache(RequestTelemetry paramRequestTelemetry);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.eststelemetry.IRequestTelemetryCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */