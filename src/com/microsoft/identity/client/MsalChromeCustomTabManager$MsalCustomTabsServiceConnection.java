package com.microsoft.identity.client;

import android.content.ComponentName;
import android.os.RemoteException;
import d.d.a.d;
import d.d.a.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

public class MsalChromeCustomTabManager$MsalCustomTabsServiceConnection
  extends d
{
  public d.d.a.b mCustomTabsClient;
  public boolean mCustomTabsServiceIsBound;
  public e mCustomTabsSession;
  public final WeakReference<CountDownLatch> mLatchWeakReference;
  
  public MsalChromeCustomTabManager$MsalCustomTabsServiceConnection(CountDownLatch paramCountDownLatch)
  {
    mLatchWeakReference = new WeakReference(paramCountDownLatch);
  }
  
  private void unbindCustomTabsService()
  {
    mCustomTabsClient = null;
    mCustomTabsServiceIsBound = false;
  }
  
  public boolean getCustomTabsServiceIsBound()
  {
    return mCustomTabsServiceIsBound;
  }
  
  public e getCustomTabsSession()
  {
    return mCustomTabsSession;
  }
  
  public void onCustomTabsServiceConnected(ComponentName paramComponentName, d.d.a.b paramb)
  {
    paramComponentName = (CountDownLatch)mLatchWeakReference.get();
    mCustomTabsServiceIsBound = true;
    mCustomTabsClient = paramb;
    if (paramb != null)
    {
      try
      {
        a.a(0L);
      }
      catch (RemoteException paramb) {}
      mCustomTabsSession = mCustomTabsClient.a(null);
      if (paramComponentName != null) {
        paramComponentName.countDown();
      }
      return;
    }
    throw null;
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    unbindCustomTabsService();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MsalChromeCustomTabManager.MsalCustomTabsServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */