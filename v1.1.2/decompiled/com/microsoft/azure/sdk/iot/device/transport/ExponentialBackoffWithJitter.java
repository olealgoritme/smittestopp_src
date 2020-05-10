package com.microsoft.azure.sdk.iot.device.transport;

import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import java.security.SecureRandom;

public class ExponentialBackoffWithJitter
  implements RetryPolicy
{
  public long deltaBackoff = 100L;
  public boolean firstFastRetry = true;
  public long maxBackoff = 10000L;
  public long minBackoff = 100L;
  public SecureRandom random = new SecureRandom();
  public int retryCount = Integer.MAX_VALUE;
  
  public ExponentialBackoffWithJitter() {}
  
  public ExponentialBackoffWithJitter(int paramInt, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if (paramInt > 0)
    {
      retryCount = paramInt;
      minBackoff = paramLong1;
      maxBackoff = paramLong2;
      deltaBackoff = paramLong3;
      firstFastRetry = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("retryCount cannot be less than or equal to 0.");
  }
  
  public RetryDecision getRetryDecision(int paramInt, TransportException paramTransportException)
  {
    if ((paramInt == 0) && (firstFastRetry)) {
      return new RetryDecision(true, 0L);
    }
    if (paramInt < retryCount)
    {
      long l = deltaBackoff;
      int i = (int)(l * 0.8D);
      int j = (int)(l * 1.2D);
      l = random.nextInt(j - i);
      l = (int)((Math.pow(2.0D, paramInt) - 1.0D) * (l + i));
      return new RetryDecision(true, (int)Math.min(minBackoff + l, maxBackoff));
    }
    return new RetryDecision(false, 0L);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.ExponentialBackoffWithJitter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */