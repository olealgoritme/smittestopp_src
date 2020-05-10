package com.microsoft.azure.storage;

public final class RequestCompletedEvent
  extends BaseEvent
{
  public RequestCompletedEvent(OperationContext paramOperationContext, Object paramObject, RequestResult paramRequestResult)
  {
    super(paramOperationContext, paramObject, paramRequestResult);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.RequestCompletedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */