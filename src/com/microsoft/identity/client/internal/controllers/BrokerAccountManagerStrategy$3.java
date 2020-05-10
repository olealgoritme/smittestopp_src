package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAccountManagerStrategy$3
  implements BrokerAccountManagerStrategy.OperationInfo<AcquireTokenSilentOperationParameters, AcquireTokenResult>
{
  public BrokerAccountManagerStrategy$3(BrokerAccountManagerStrategy paramBrokerAccountManagerStrategy) {}
  
  public String getMethodName()
  {
    return ":acquireTokenSilentWithAccountManager";
  }
  
  public Bundle getRequestBundle(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    paramAcquireTokenSilentOperationParameters = this$0.mRequestAdapter.getRequestBundleForAcquireTokenSilent(paramAcquireTokenSilentOperationParameters);
    paramAcquireTokenSilentOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "ACQUIRE_TOKEN_SILENT");
    return paramAcquireTokenSilentOperationParameters;
  }
  
  public AcquireTokenResult getResultFromBundle(Bundle paramBundle)
  {
    return this$0.mResultAdapter.getAcquireTokenResultFromResultBundle(paramBundle);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */