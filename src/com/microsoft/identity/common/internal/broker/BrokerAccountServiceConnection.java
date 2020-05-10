package com.microsoft.identity.common.internal.broker;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.microsoft.aad.adal.IBrokerAccountService;
import com.microsoft.aad.adal.IBrokerAccountService.Stub;
import com.microsoft.identity.common.internal.logging.Logger;

public class BrokerAccountServiceConnection
  implements ServiceConnection
{
  public static final String TAG = MicrosoftAuthServiceConnection.class.getSimpleName();
  public IBrokerAccountService mBrokerAccountService;
  public BrokerAccountServiceFuture mBrokerAccountServiceFuture;
  
  public BrokerAccountServiceConnection(BrokerAccountServiceFuture paramBrokerAccountServiceFuture)
  {
    mBrokerAccountServiceFuture = paramBrokerAccountServiceFuture;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Logger.verbose(TAG, "BrokerAccountService is connected.");
    paramComponentName = IBrokerAccountService.Stub.asInterface(paramIBinder);
    mBrokerAccountService = paramComponentName;
    mBrokerAccountServiceFuture.setBrokerAccountService(paramComponentName);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Logger.verbose(TAG, "BrokerAccountService is disconnected.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.BrokerAccountServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */