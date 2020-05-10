package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;

public class BrokerMsalController$5
  implements BrokerMsalController.BrokerOperationInfo<OperationParameters, Boolean>
{
  public BrokerMsalController$5(BrokerMsalController paramBrokerMsalController) {}
  
  public String getMethodName()
  {
    return ":getDeviceMode";
  }
  
  public String getTelemetryApiId()
  {
    return "204";
  }
  
  public Boolean perform(BrokerBaseStrategy paramBrokerBaseStrategy, OperationParameters paramOperationParameters)
  {
    return Boolean.valueOf(paramBrokerBaseStrategy.getDeviceMode(paramOperationParameters));
  }
  
  public void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, Boolean paramBoolean)
  {
    paramApiEndEvent.put("Microsoft.MSAL.is_device_shared", Boolean.toString(paramBoolean.booleanValue()));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerMsalController.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */