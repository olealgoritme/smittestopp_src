package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAuthServiceStrategy$1
  implements BrokerAuthServiceStrategy.AuthServiceOperation<Void>
{
  public BrokerAuthServiceStrategy$1(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy, OperationParameters paramOperationParameters) {}
  
  public String getOperationName()
  {
    return ":helloWithMicrosoftAuthService";
  }
  
  public Void perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    Bundle localBundle = this$0.mRequestAdapter.getRequestBundleForHello(val$parameters);
    this$0.mResultAdapter.verifyHelloFromResultBundle(paramIMicrosoftAuthService.hello(localBundle));
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */