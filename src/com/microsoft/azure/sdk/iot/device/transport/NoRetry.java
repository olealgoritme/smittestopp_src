package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;

public class NoRetry
  implements RetryPolicy
{
  public RetryDecision getRetryDecision(int paramInt, TransportException paramTransportException)
  {
    return new RetryDecision(false, 0L);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.NoRetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */