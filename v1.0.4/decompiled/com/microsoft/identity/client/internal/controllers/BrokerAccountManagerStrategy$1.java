package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAccountManagerStrategy$1
  implements BrokerAccountManagerStrategy.OperationInfo<OperationParameters, Void>
{
  public BrokerAccountManagerStrategy$1(BrokerAccountManagerStrategy paramBrokerAccountManagerStrategy) {}
  
  public String getMethodName()
  {
    return ":helloWithAccountManager";
  }
  
  public Bundle getRequestBundle(OperationParameters paramOperationParameters)
  {
    paramOperationParameters = this$0.mRequestAdapter.getRequestBundleForHello(paramOperationParameters);
    paramOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "HELLO");
    return paramOperationParameters;
  }
  
  public Void getResultFromBundle(Bundle paramBundle)
  {
    this$0.mResultAdapter.verifyHelloFromResultBundle(paramBundle);
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */