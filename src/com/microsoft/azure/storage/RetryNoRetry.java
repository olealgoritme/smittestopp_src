package com.microsoft.azure.storage;

public final class RetryNoRetry
  extends RetryPolicy
  implements RetryPolicyFactory
{
  public static RetryNoRetry instance = new RetryNoRetry();
  
  public static RetryNoRetry getInstance()
  {
    return instance;
  }
  
  public RetryPolicy createInstance(OperationContext paramOperationContext)
  {
    return getInstance();
  }
  
  public RetryInfo evaluate(RetryContext paramRetryContext, OperationContext paramOperationContext)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.RetryNoRetry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */