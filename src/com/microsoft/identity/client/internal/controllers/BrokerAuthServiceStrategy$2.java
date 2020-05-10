package com.microsoft.identity.client.internal.controllers;

import android.content.Intent;
import com.microsoft.identity.client.IMicrosoftAuthService;

public class BrokerAuthServiceStrategy$2
  implements BrokerAuthServiceStrategy.AuthServiceOperation<Intent>
{
  public BrokerAuthServiceStrategy$2(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy) {}
  
  public String getOperationName()
  {
    return ":getBrokerAuthorizationIntentFromAuthService";
  }
  
  public Intent perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    return paramIMicrosoftAuthService.getIntentForInteractiveRequest();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */