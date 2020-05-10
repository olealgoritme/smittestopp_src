package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;

public class BrokerMsalController$2
  implements BrokerMsalController.BrokerOperationInfo<AcquireTokenSilentOperationParameters, AcquireTokenResult>
{
  public BrokerMsalController$2(BrokerMsalController paramBrokerMsalController) {}
  
  public String getMethodName()
  {
    return ":acquireTokenSilent";
  }
  
  public String getTelemetryApiId()
  {
    return "203";
  }
  
  public AcquireTokenResult perform(BrokerBaseStrategy paramBrokerBaseStrategy, AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    return paramBrokerBaseStrategy.acquireTokenSilent(paramAcquireTokenSilentOperationParameters);
  }
  
  public void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, AcquireTokenResult paramAcquireTokenResult)
  {
    paramApiEndEvent.putResult(paramAcquireTokenResult);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerMsalController.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */