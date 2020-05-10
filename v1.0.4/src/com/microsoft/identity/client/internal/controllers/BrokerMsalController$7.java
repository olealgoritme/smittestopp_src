package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;

public class BrokerMsalController$7
  implements BrokerMsalController.BrokerOperationInfo<OperationParameters, Boolean>
{
  public BrokerMsalController$7(BrokerMsalController paramBrokerMsalController) {}
  
  public String getMethodName()
  {
    return ":removeCurrentAccount";
  }
  
  public String getTelemetryApiId()
  {
    return "208";
  }
  
  public Boolean perform(BrokerBaseStrategy paramBrokerBaseStrategy, OperationParameters paramOperationParameters)
  {
    paramBrokerBaseStrategy.signOutFromSharedDevice(paramOperationParameters);
    return Boolean.valueOf(true);
  }
  
  public void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, Boolean paramBoolean) {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerMsalController.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */