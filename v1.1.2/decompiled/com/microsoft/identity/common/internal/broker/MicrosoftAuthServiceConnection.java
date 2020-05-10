package com.microsoft.identity.common.internal.broker;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.client.IMicrosoftAuthService.Stub;
import com.microsoft.identity.common.internal.logging.Logger;

public class MicrosoftAuthServiceConnection
  implements ServiceConnection
{
  public static final String TAG = MicrosoftAuthServiceConnection.class.getSimpleName();
  public IMicrosoftAuthService mMicrosoftAuthService;
  public MicrosoftAuthServiceFuture mMicrosoftAuthServiceFuture;
  
  public MicrosoftAuthServiceConnection(MicrosoftAuthServiceFuture paramMicrosoftAuthServiceFuture)
  {
    mMicrosoftAuthServiceFuture = paramMicrosoftAuthServiceFuture;
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Logger.info(TAG, "MicrosoftAuthService is connected.");
    paramComponentName = IMicrosoftAuthService.Stub.asInterface(paramIBinder);
    mMicrosoftAuthService = paramComponentName;
    mMicrosoftAuthServiceFuture.setMicrosoftAuthService(paramComponentName);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Logger.info(TAG, "MicrosoftAuthService is disconnected.");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.broker.MicrosoftAuthServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */