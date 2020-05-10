package com.microsoft.identity.common.internal.broker;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.List;

public class MicrosoftAuthClient
{
  public static final String MICROSOFT_AUTH_SERVICE_CLASS_NAME = "com.microsoft.identity.client.MicrosoftAuthService";
  public static final String MICROSOFT_AUTH_SERVICE_INTENT_FILTER = "com.microsoft.identity.client.MicrosoftAuth";
  public static final String TAG = "MicrosoftAuthClient";
  public Boolean mBound = Boolean.valueOf(false);
  public Context mContext;
  public MicrosoftAuthServiceConnection mMicrosoftAuthServiceConnection;
  public Intent mMicrosoftAuthServiceIntent;
  
  public MicrosoftAuthClient(Context paramContext)
  {
    mContext = paramContext;
    mMicrosoftAuthServiceIntent = getIntentForAuthService(paramContext);
  }
  
  private String getCurrentActiveBrokerPackageName(Context paramContext)
  {
    for (AuthenticatorDescription localAuthenticatorDescription : AccountManager.get(paramContext).getAuthenticatorTypes()) {
      if ((type.equals("com.microsoft.workaccount")) && (isMicrosoftAuthServiceSupported(paramContext.getPackageManager(), packageName))) {
        return packageName;
      }
    }
    return null;
  }
  
  private boolean isMicrosoftAuthServiceSupported(PackageManager paramPackageManager, String paramString)
  {
    Intent localIntent = new Intent("com.microsoft.identity.client.MicrosoftAuth");
    localIntent.setPackage(paramString);
    localIntent.setClassName(paramString, "com.microsoft.identity.client.MicrosoftAuthService");
    boolean bool1 = false;
    paramPackageManager = paramPackageManager.queryIntentServices(localIntent, 0);
    boolean bool2 = bool1;
    if (paramPackageManager != null)
    {
      bool2 = bool1;
      if (paramPackageManager.size() > 0) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public MicrosoftAuthServiceFuture connect()
  {
    MicrosoftAuthServiceFuture localMicrosoftAuthServiceFuture = new MicrosoftAuthServiceFuture();
    Object localObject = new MicrosoftAuthServiceConnection(localMicrosoftAuthServiceFuture);
    mMicrosoftAuthServiceConnection = ((MicrosoftAuthServiceConnection)localObject);
    mBound = Boolean.valueOf(mContext.bindService(mMicrosoftAuthServiceIntent, (ServiceConnection)localObject, 1));
    String str = a.a(new StringBuilder(), TAG, "connect");
    localObject = a.a("The status for MicrosoftAuthService bindService call is: ");
    ((StringBuilder)localObject).append(Boolean.valueOf(mBound.booleanValue()));
    Logger.info(str, ((StringBuilder)localObject).toString());
    if (mBound.booleanValue()) {
      return localMicrosoftAuthServiceFuture;
    }
    throw new ClientException("Service is unavailable or does not support binding.  Microsoft Auth Service.");
  }
  
  public void disconnect()
  {
    if (mBound.booleanValue())
    {
      mContext.unbindService(mMicrosoftAuthServiceConnection);
      mBound = Boolean.valueOf(false);
    }
  }
  
  public Intent getIntentForAuthService(Context paramContext)
  {
    String str = getCurrentActiveBrokerPackageName(paramContext);
    if ((str != null) && (str.length() != 0))
    {
      paramContext = new Intent("com.microsoft.identity.client.MicrosoftAuth");
      paramContext.setPackage(str);
      paramContext.setClassName(str, "com.microsoft.identity.client.MicrosoftAuthService");
      return paramContext;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.MicrosoftAuthClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */