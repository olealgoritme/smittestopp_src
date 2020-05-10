package com.microsoft.azure.storage;

public abstract class BaseEvent
{
  public final Object connectionObject;
  public final OperationContext opContext;
  public final RequestResult requestResult;
  
  public BaseEvent(OperationContext paramOperationContext, Object paramObject, RequestResult paramRequestResult)
  {
    opContext = paramOperationContext;
    connectionObject = paramObject;
    requestResult = paramRequestResult;
  }
  
  public Object getConnectionObject()
  {
    return connectionObject;
  }
  
  public OperationContext getOpContext()
  {
    return opContext;
  }
  
  public RequestResult getRequestResult()
  {
    return requestResult;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.BaseEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */