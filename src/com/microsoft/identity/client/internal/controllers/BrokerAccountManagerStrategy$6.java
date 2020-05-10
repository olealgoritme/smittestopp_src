package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;

public class BrokerAccountManagerStrategy$6
  implements BrokerAccountManagerStrategy.OperationInfo<OperationParameters, Boolean>
{
  public BrokerAccountManagerStrategy$6(BrokerAccountManagerStrategy paramBrokerAccountManagerStrategy) {}
  
  public String getMethodName()
  {
    return ":getDeviceModeWithAccountManager";
  }
  
  public Bundle getRequestBundle(OperationParameters paramOperationParameters)
  {
    paramOperationParameters = new Bundle();
    paramOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_DEVICE_MODE");
    return paramOperationParameters;
  }
  
  public Boolean getResultFromBundle(Bundle paramBundle)
  {
    return Boolean.valueOf(this$0.mResultAdapter.getDeviceModeFromResultBundle(paramBundle));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */