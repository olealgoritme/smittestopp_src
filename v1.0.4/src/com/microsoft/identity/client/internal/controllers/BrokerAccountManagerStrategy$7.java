package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import java.util.List;

public class BrokerAccountManagerStrategy$7
  implements BrokerAccountManagerStrategy.OperationInfo<OperationParameters, List<ICacheRecord>>
{
  public BrokerAccountManagerStrategy$7(BrokerAccountManagerStrategy paramBrokerAccountManagerStrategy) {}
  
  public String getMethodName()
  {
    return ":getCurrentAccountInSharedDeviceWithAccountManager";
  }
  
  public Bundle getRequestBundle(OperationParameters paramOperationParameters)
  {
    paramOperationParameters = this$0.mRequestAdapter.getRequestBundleForGetAccounts(paramOperationParameters);
    paramOperationParameters.putString("com.microsoft.broker_accountmanager_operation_key", "GET_CURRENT_ACCOUNT");
    return paramOperationParameters;
  }
  
  public List<ICacheRecord> getResultFromBundle(Bundle paramBundle)
  {
    return this$0.mResultAdapter.getAccountsFromResultBundle(paramBundle);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAccountManagerStrategy.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */