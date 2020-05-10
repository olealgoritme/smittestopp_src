package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import java.util.List;

public class BrokerAuthServiceStrategy$7
  implements BrokerAuthServiceStrategy.AuthServiceOperation<List<ICacheRecord>>
{
  public BrokerAuthServiceStrategy$7(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy, OperationParameters paramOperationParameters) {}
  
  public String getOperationName()
  {
    return ":getCurrentAccountInSharedDeviceWithAuthService";
  }
  
  public List<ICacheRecord> perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    Bundle localBundle = this$0.mRequestAdapter.getRequestBundleForGetAccounts(val$parameters);
    return this$0.mResultAdapter.getAccountsFromResultBundle(paramIMicrosoftAuthService.getCurrentAccount(localBundle));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */