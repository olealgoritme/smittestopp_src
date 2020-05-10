package com.microsoft.identity.client.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import java.util.List;

public class BrokerAuthServiceStrategy$4
  implements BrokerAuthServiceStrategy.AuthServiceOperation<List<ICacheRecord>>
{
  public BrokerAuthServiceStrategy$4(BrokerAuthServiceStrategy paramBrokerAuthServiceStrategy, OperationParameters paramOperationParameters) {}
  
  public String getOperationName()
  {
    return ":getBrokerAccountsWithAuthService";
  }
  
  public List<ICacheRecord> perform(IMicrosoftAuthService paramIMicrosoftAuthService)
  {
    Bundle localBundle = this$0.mRequestAdapter.getRequestBundleForGetAccounts(val$parameters);
    return this$0.mResultAdapter.getAccountsFromResultBundle(paramIMicrosoftAuthService.getAccounts(localBundle));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */