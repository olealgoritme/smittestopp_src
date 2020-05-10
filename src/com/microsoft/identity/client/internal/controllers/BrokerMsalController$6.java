package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import java.util.List;

public class BrokerMsalController$6
  implements BrokerMsalController.BrokerOperationInfo<OperationParameters, List<ICacheRecord>>
{
  public BrokerMsalController$6(BrokerMsalController paramBrokerMsalController) {}
  
  public String getMethodName()
  {
    return ":getCurrentAccount";
  }
  
  public String getTelemetryApiId()
  {
    return "205";
  }
  
  public List<ICacheRecord> perform(BrokerBaseStrategy paramBrokerBaseStrategy, OperationParameters paramOperationParameters)
  {
    return paramBrokerBaseStrategy.getCurrentAccountInSharedDevice(paramOperationParameters);
  }
  
  public void putValueInSuccessEvent(ApiEndEvent paramApiEndEvent, List<ICacheRecord> paramList)
  {
    paramApiEndEvent.put("Microsoft.MSAL.accounts_number", Integer.toString(paramList.size()));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerMsalController.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */