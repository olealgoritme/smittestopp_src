package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;

public class BrokerMsalController$4
  implements BrokerMsalController.BrokerOperationInfo<OperationParameters, Boolean>
{
  public BrokerMsalController$4(BrokerMsalController paramBrokerMsalController) {}
  
  public String getMethodName()
  {
    return ":removeAccount";
  }
  
  public String getTelemetryApiId()
  {
    return "207";
  }
  
  public Boolean perform(BrokerBaseStrategy paramBrokerBaseStrategy, OperationParameters paramOperationParameters)
  {
    paramBrokerBaseStrategy.removeBrokerAccount(paramOperationParameters);
    return Boolean.valueOf(true);
  }
  
  public void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, Boolean paramBoolean) {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerMsalController.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */