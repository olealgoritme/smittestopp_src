package com.microsoft.appcenter.utils;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;

public class NetworkStateHelper$1
  extends ConnectivityManager.NetworkCallback
{
  public NetworkStateHelper$1(NetworkStateHelper paramNetworkStateHelper) {}
  
  public void onAvailable(Network paramNetwork)
  {
    NetworkStateHelper.access$000(this$0, paramNetwork);
  }
  
  public void onLost(Network paramNetwork)
  {
    NetworkStateHelper.access$100(this$0, paramNetwork);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.NetworkStateHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */