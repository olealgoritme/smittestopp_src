package com.microsoft.appcenter.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest.Builder;
import e.a.a.a.a;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class NetworkStateHelper
  implements Closeable
{
  @SuppressLint({"StaticFieldLeak"})
  public static NetworkStateHelper sSharedInstance;
  public final AtomicBoolean mConnected = new AtomicBoolean();
  public final ConnectivityManager mConnectivityManager;
  public NetworkStateHelper.ConnectivityReceiver mConnectivityReceiver;
  public final Context mContext;
  public final Set<NetworkStateHelper.Listener> mListeners = new CopyOnWriteArraySet();
  public ConnectivityManager.NetworkCallback mNetworkCallback;
  
  public NetworkStateHelper(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
    mConnectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    reopen();
  }
  
  private IntentFilter getOldIntentFilter()
  {
    return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
  }
  
  public static NetworkStateHelper getSharedInstance(Context paramContext)
  {
    try
    {
      if (sSharedInstance == null)
      {
        NetworkStateHelper localNetworkStateHelper = new com/microsoft/appcenter/utils/NetworkStateHelper;
        localNetworkStateHelper.<init>(paramContext);
        sSharedInstance = localNetworkStateHelper;
      }
      paramContext = sSharedInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void handleNetworkStateUpdate()
  {
    boolean bool = isAnyNetworkConnected();
    if (mConnected.compareAndSet(bool ^ true, bool)) {
      notifyNetworkStateUpdated(bool);
    }
  }
  
  private boolean isAnyNetworkConnected()
  {
    Network[] arrayOfNetwork = mConnectivityManager.getAllNetworks();
    if (arrayOfNetwork == null) {
      return false;
    }
    int i = arrayOfNetwork.length;
    for (int j = 0; j < i; j++)
    {
      Object localObject = arrayOfNetwork[j];
      localObject = mConnectivityManager.getNetworkInfo((Network)localObject);
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
        return true;
      }
    }
    return false;
  }
  
  private void notifyNetworkStateUpdated(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = a.a("Network has been ");
    if (paramBoolean) {
      localObject = "connected.";
    } else {
      localObject = "disconnected.";
    }
    localStringBuilder.append((String)localObject);
    AppCenterLog.debug("AppCenter", localStringBuilder.toString());
    Object localObject = mListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((NetworkStateHelper.Listener)((Iterator)localObject).next()).onNetworkStateUpdated(paramBoolean);
    }
  }
  
  private void onNetworkAvailable(Network paramNetwork)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Network ");
    localStringBuilder.append(paramNetwork);
    localStringBuilder.append(" is available.");
    AppCenterLog.debug("AppCenter", localStringBuilder.toString());
    if (mConnected.compareAndSet(false, true)) {
      notifyNetworkStateUpdated(true);
    }
  }
  
  private void onNetworkLost(Network paramNetwork)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Network ");
    ((StringBuilder)localObject).append(paramNetwork);
    ((StringBuilder)localObject).append(" is lost.");
    AppCenterLog.debug("AppCenter", ((StringBuilder)localObject).toString());
    localObject = mConnectivityManager.getAllNetworks();
    if ((localObject != null) && (localObject.length != 0)) {
      if (!Arrays.equals((Object[])localObject, new Network[] { paramNetwork }))
      {
        i = 0;
        break label79;
      }
    }
    int i = 1;
    label79:
    if ((i != 0) && (mConnected.compareAndSet(true, false))) {
      notifyNetworkStateUpdated(false);
    }
  }
  
  public static void unsetInstance()
  {
    try
    {
      sSharedInstance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void addListener(NetworkStateHelper.Listener paramListener)
  {
    mListeners.add(paramListener);
  }
  
  public void close()
  {
    mConnected.set(false);
    mConnectivityManager.unregisterNetworkCallback(mNetworkCallback);
  }
  
  public boolean isNetworkConnected()
  {
    boolean bool;
    if ((!mConnected.get()) && (!isAnyNetworkConnected())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void removeListener(NetworkStateHelper.Listener paramListener)
  {
    mListeners.remove(paramListener);
  }
  
  public void reopen()
  {
    try
    {
      NetworkRequest.Builder localBuilder = new android/net/NetworkRequest$Builder;
      localBuilder.<init>();
      localBuilder.addCapability(12);
      NetworkStateHelper.1 local1 = new com/microsoft/appcenter/utils/NetworkStateHelper$1;
      local1.<init>(this);
      mNetworkCallback = local1;
      mConnectivityManager.registerNetworkCallback(localBuilder.build(), mNetworkCallback);
    }
    catch (RuntimeException localRuntimeException)
    {
      AppCenterLog.error("AppCenter", "Cannot access network state information.", localRuntimeException);
      mConnected.set(true);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.NetworkStateHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */