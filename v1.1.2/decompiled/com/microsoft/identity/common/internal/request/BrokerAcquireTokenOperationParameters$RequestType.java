package com.microsoft.identity.common.internal.request;

public enum BrokerAcquireTokenOperationParameters$RequestType
{
  static
  {
    BROKER_RT_REQUEST = new RequestType("BROKER_RT_REQUEST", 1);
    RequestType localRequestType = new RequestType("RESOLVE_INTERRUPT", 2);
    RESOLVE_INTERRUPT = localRequestType;
    $VALUES = new RequestType[] { REGULAR, BROKER_RT_REQUEST, localRequestType };
  }
  
  public BrokerAcquireTokenOperationParameters$RequestType() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.request.BrokerAcquireTokenOperationParameters.RequestType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */