package com.microsoft.azure.sdk.iot.device.transport;

public class RetryDecision
{
  public final long duration;
  public final boolean shouldRetry;
  
  public RetryDecision(boolean paramBoolean, long paramLong)
  {
    duration = paramLong;
    shouldRetry = paramBoolean;
  }
  
  public long getDuration()
  {
    return duration;
  }
  
  public boolean shouldRetry()
  {
    return shouldRetry;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.RetryDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */