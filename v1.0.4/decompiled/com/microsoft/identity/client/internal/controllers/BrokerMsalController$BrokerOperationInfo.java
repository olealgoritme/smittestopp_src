package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;

public abstract interface BrokerMsalController$BrokerOperationInfo<T extends OperationParameters, U>
{
  public abstract String getMethodName();
  
  public abstract String getTelemetryApiId();
  
  public abstract U perform(BrokerBaseStrategy paramBrokerBaseStrategy, T paramT);
  
  public abstract void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, U paramU);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerMsalController.BrokerOperationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */