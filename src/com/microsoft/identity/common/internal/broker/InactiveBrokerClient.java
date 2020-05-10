package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.Intent;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;

public class InactiveBrokerClient
{
  public static final String BROKER_ACCOUNT_SERVICE_CLASS_NAME = "com.microsoft.aad.adal.BrokerAccountService";
  public static final String BROKER_ACCOUNT_SERVICE_INTENT_FILTER = "com.microsoft.workaccount.BrokerAccount";
  public static final String TAG = "InactiveBrokerClient";
  public Boolean mBound = Boolean.valueOf(false);
  public BrokerAccountServiceConnection mBrokerAccountServiceConnection;
  public Context mContext;
  public String mInactiveBrokerPackageName;
  
  public InactiveBrokerClient(Context paramContext, BrokerData paramBrokerData)
  {
    mContext = paramContext;
    mInactiveBrokerPackageName = packageName;
  }
  
  private Intent getIntentForBrokerAccountService()
  {
    Intent localIntent = new Intent("com.microsoft.workaccount.BrokerAccount");
    localIntent.setPackage(mInactiveBrokerPackageName);
    localIntent.setClassName(mInactiveBrokerPackageName, "com.microsoft.aad.adal.BrokerAccountService");
    return localIntent;
  }
  
  public BrokerAccountServiceFuture connect()
  {
    BrokerAccountServiceFuture localBrokerAccountServiceFuture = new BrokerAccountServiceFuture();
    mBrokerAccountServiceConnection = new BrokerAccountServiceConnection(localBrokerAccountServiceFuture);
    mBound = Boolean.valueOf(mContext.bindService(getIntentForBrokerAccountService(), mBrokerAccountServiceConnection, 1));
    String str = a.a(new StringBuilder(), TAG, "connect");
    StringBuilder localStringBuilder = a.a("The status for BrokerAccountService bindService call is: ");
    localStringBuilder.append(Boolean.valueOf(mBound.booleanValue()));
    Logger.verbose(str, localStringBuilder.toString());
    if (mBound.booleanValue()) {
      return localBrokerAccountServiceFuture;
    }
    throw new ClientException("Service is unavailable or does not support binding. BrokerAccountService.");
  }
  
  public void disconnect()
  {
    if (mBound.booleanValue())
    {
      mContext.unbindService(mBrokerAccountServiceConnection);
      mBound = Boolean.valueOf(false);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.InactiveBrokerClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */