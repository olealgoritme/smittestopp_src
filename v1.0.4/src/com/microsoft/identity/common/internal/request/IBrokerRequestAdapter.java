package com.microsoft.identity.common.internal.request;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.microsoft.identity.common.internal.broker.BrokerRequest;

public abstract interface IBrokerRequestAdapter
{
  public abstract BrokerAcquireTokenOperationParameters brokerInteractiveParametersFromActivity(Activity paramActivity);
  
  public abstract BrokerRequest brokerRequestFromAcquireTokenParameters(AcquireTokenOperationParameters paramAcquireTokenOperationParameters);
  
  public abstract BrokerRequest brokerRequestFromSilentOperationParameters(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters);
  
  public abstract BrokerAcquireTokenSilentOperationParameters brokerSilentParametersFromBundle(Bundle paramBundle, Context paramContext, Account paramAccount);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.IBrokerRequestAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */