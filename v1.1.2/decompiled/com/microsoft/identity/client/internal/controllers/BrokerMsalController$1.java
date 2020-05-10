package com.microsoft.identity.client.internal.controllers;

import android.content.Intent;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;

public class BrokerMsalController$1
  implements BrokerMsalController.BrokerOperationInfo<AcquireTokenOperationParameters, Intent>
{
  public BrokerMsalController$1(BrokerMsalController paramBrokerMsalController) {}
  
  public String getMethodName()
  {
    return ":getBrokerAuthorizationIntent";
  }
  
  public String getTelemetryApiId()
  {
    return null;
  }
  
  public Intent perform(BrokerBaseStrategy paramBrokerBaseStrategy, AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    return paramBrokerBaseStrategy.getBrokerAuthorizationIntent(paramAcquireTokenOperationParameters);
  }
  
  public void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, Intent paramIntent) {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerMsalController.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */