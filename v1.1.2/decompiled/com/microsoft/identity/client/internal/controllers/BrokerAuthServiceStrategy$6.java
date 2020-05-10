package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAuthServiceStrategy$6
  implements BrokerAuthServiceStrategy.AuthServiceOperation<Boolean>
{
  public BrokerAuthServiceStrategy$6(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy) {}
  
  public String getOperationName()
  {
    return ":getDeviceModeWithAuthService";
  }
  
  public Boolean perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    return Boolean.valueOf(this$0.mResultAdapter.getDeviceModeFromResultBundle(paramIMicrosoftAuthService.getDeviceMode()));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */