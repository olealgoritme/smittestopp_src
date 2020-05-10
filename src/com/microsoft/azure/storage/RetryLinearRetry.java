package com.microsoft.azure.storage;

public final class RetryLinearRetry
  extends RetryPolicy
  implements RetryPolicyFactory
{
  public RetryLinearRetry()
  {
    this(30000, 3);
  }
  
  public RetryLinearRetry(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public RetryPolicy createInstance(OperationContext paramOperationContext)
  {
    return new RetryLinearRetry(deltaBackoffIntervalInMs, maximumAttempts);
  }
  
  public RetryInfo evaluate(RetryContext paramRetryContext, OperationContext paramOperationContext)
  {
    boolean bool = evaluateLastAttemptAndSecondaryNotFound(paramRetryContext);
    if (paramRetryContext.getCurrentRetryCount() < maximumAttempts)
    {
      int i = paramRetryContext.getLastRequestResult().getStatusCode();
      if (((bool) || (i < 300) || (i >= 500) || (i == 408)) && (i != 501) && (i != 505)) {
        return evaluateRetryInfo(paramRetryContext, bool, Math.max(Math.min(deltaBackoffIntervalInMs, 90000), 3000));
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.RetryLinearRetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */