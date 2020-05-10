package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAccountManagerStrategy$5
  implements BrokerAccountManagerStrategy.OperationInfo<OperationParameters, Void>
{
  public BrokerAccountManagerStrategy$5(BrokerAccountManagerStrategy paramBrokerAccountManagerStrategy) {}
  
  public String getMethodName()
  {
    return ":removeBrokerAccountWithAccountManager";
  }
  
  public Bundle getRequestBundle(OperationParameters paramOperationParameters)
  {
    paramOperationParameters = this$0.mRequestAdapter.getRequestBundleForRemoveAccount(paramOperationParameters);
    paramOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "REMOVE_ACCOUNT");
    return paramOperationParameters;
  }
  
  public Void getResultFromBundle(Bundle paramBundle)
  {
    this$0.mResultAdapter.verifyRemoveAccountResultFromBundle(paramBundle);
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */