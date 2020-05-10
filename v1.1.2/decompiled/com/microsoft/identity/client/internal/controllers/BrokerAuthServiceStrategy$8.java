package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAuthServiceStrategy$8
  implements BrokerAuthServiceStrategy.AuthServiceOperation<Void>
{
  public BrokerAuthServiceStrategy$8(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy, OperationParameters paramOperationParameters) {}
  
  public String getOperationName()
  {
    return ":signOutFromSharedDeviceWithAuthService";
  }
  
  public Void perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    Bundle localBundle = this$0.mRequestAdapter.getRequestBundleForRemoveAccountFromSharedDevice(val$parameters);
    this$0.mResultAdapter.verifyRemoveAccountResultFromBundle(paramIMicrosoftAuthService.removeAccountFromSharedDevice(localBundle));
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */