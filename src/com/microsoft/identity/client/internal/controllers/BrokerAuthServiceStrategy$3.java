package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAuthServiceStrategy$3
  implements BrokerAuthServiceStrategy.AuthServiceOperation<AcquireTokenResult>
{
  public BrokerAuthServiceStrategy$3(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy, AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters) {}
  
  public String getOperationName()
  {
    return ":acquireTokenSilentWithAuthService";
  }
  
  public AcquireTokenResult perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    Bundle localBundle = this$0.mRequestAdapter.getRequestBundleForAcquireTokenSilent(val$parameters);
    return this$0.mResultAdapter.getAcquireTokenResultFromResultBundle(paramIMicrosoftAuthService.acquireTokenSilently(localBundle));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */