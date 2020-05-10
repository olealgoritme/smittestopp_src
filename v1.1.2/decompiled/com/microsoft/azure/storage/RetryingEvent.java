package com.microsoft.azure.storage;

public final class RetryingEvent
  extends BaseEvent
{
  public final RetryContext retryContext;
  
  public RetryingEvent(OperationContext paramOperationContext, Object paramObject, RequestResult paramRequestResult, RetryContext paramRetryContext)
  {
    super(paramOperationContext, paramObject, paramRequestResult);
    retryContext = paramRetryContext;
  }
  
  public RetryContext getRetryContext()
  {
    return retryContext;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.RetryingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */