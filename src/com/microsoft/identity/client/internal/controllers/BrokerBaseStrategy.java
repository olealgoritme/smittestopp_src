package com.microsoft.identity.client.internal.controllers;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.microsoft.identity.common.internal.broker.BrokerRequest;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import java.util.List;

public abstract class BrokerBaseStrategy
{
  public final MsalBrokerRequestAdapter mRequestAdapter = new MsalBrokerRequestAdapter();
  public final MsalBrokerResultAdapter mResultAdapter = new MsalBrokerResultAdapter();
  
  public abstract AcquireTokenResult acquireTokenSilent(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters);
  
  public Intent completeInteractiveRequestIntent(Intent paramIntent, AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    paramIntent.putExtra("broker_request_v2", MsalBrokerRequestAdapter.sRequestAdapterGsonInstance.a(mRequestAdapter.brokerRequestFromAcquireTokenParameters(paramAcquireTokenOperationParameters), BrokerRequest.class));
    return paramIntent;
  }
  
  public abstract List<ICacheRecord> getBrokerAccounts(OperationParameters paramOperationParameters);
  
  public abstract Intent getBrokerAuthorizationIntent(AcquireTokenOperationParameters paramAcquireTokenOperationParameters);
  
  public abstract List<ICacheRecord> getCurrentAccountInSharedDevice(OperationParameters paramOperationParameters);
  
  public abstract boolean getDeviceMode(OperationParameters paramOperationParameters);
  
  public Handler getPreferredHandler()
  {
    if ((Looper.myLooper() != null) && (Looper.getMainLooper() != Looper.myLooper())) {
      return new Handler(Looper.myLooper());
    }
    return new Handler(Looper.getMainLooper());
  }
  
  public abstract void hello(OperationParameters paramOperationParameters);
  
  public abstract void removeBrokerAccount(OperationParameters paramOperationParameters);
  
  public abstract void signOutFromSharedDevice(OperationParameters paramOperationParameters);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.BrokerBaseStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */