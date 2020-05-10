package com.microsoft.azure.storage;

import java.util.Random;

public final class RetryExponentialRetry
  extends RetryPolicy
  implements RetryPolicyFactory
{
  public final Random randRef = new Random();
  public int resolvedMaxBackoff = 90000;
  public int resolvedMinBackoff = 3000;
  
  public RetryExponentialRetry()
  {
    this(30000, 3);
  }
  
  public RetryExponentialRetry(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public RetryExponentialRetry(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt2, paramInt4);
    resolvedMinBackoff = paramInt1;
    resolvedMaxBackoff = paramInt3;
  }
  
  public RetryPolicy createInstance(OperationContext paramOperationContext)
  {
    return new RetryExponentialRetry(resolvedMinBackoff, deltaBackoffIntervalInMs, resolvedMaxBackoff, maximumAttempts);
  }
  
  public RetryInfo evaluate(RetryContext paramRetryContext, OperationContext paramOperationContext)
  {
    boolean bool = evaluateLastAttemptAndSecondaryNotFound(paramRetryContext);
    if (paramRetryContext.getCurrentRetryCount() < maximumAttempts)
    {
      int i = paramRetryContext.getLastRequestResult().getStatusCode();
      if (((bool) || (i < 300) || (i >= 500) || (i == 408)) && (i != 501) && (i != 505))
      {
        double d1 = Math.pow(2.0D, paramRetryContext.getCurrentRetryCount());
        i = deltaBackoffIntervalInMs;
        int j = (int)(i * 0.8D);
        double d2 = randRef.nextInt((int)(i * 1.2D) - (int)(i * 0.8D)) + j;
        return evaluateRetryInfo(paramRetryContext, bool, (int)Math.round(Math.min(resolvedMinBackoff + (d1 - 1.0D) * d2, resolvedMaxBackoff)));
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RetryExponentialRetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */