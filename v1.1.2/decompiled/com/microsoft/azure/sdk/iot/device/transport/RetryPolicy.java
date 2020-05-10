package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;

public abstract interface RetryPolicy
{
  public abstract RetryDecision getRetryDecision(int paramInt, TransportException paramTransportException);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.RetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */