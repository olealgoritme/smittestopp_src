package com.microsoft.identity.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.internal.logging.Logger;
import d.d.a.c;
import d.d.a.c.a;
import d.d.a.d;
import d.d.a.e;
import d.i.b.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MsalChromeCustomTabManager
{
  public static final long CUSTOM_TABS_MAX_CONNECTION_TIMEOUT = 1L;
  public static final String TAG = "MsalChromeCustomTabManager";
  public String mChromePackageWithCustomTabSupport;
  public c mCustomTabsIntent;
  public MsalCustomTabsServiceConnection mCustomTabsServiceConnection;
  public Activity mParentActivity;
  
  public MsalChromeCustomTabManager(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      mParentActivity = paramActivity;
      mChromePackageWithCustomTabSupport = MsalUtils.getChromePackageWithCustomTabSupport(paramActivity.getApplicationContext());
      return;
    }
    throw new IllegalArgumentException("Activity parameter cannot be null");
  }
  
  private boolean waitForServiceConnectionToEstablish(CountDownLatch paramCountDownLatch)
  {
    boolean bool = false;
    try
    {
      if ((paramCountDownLatch.await(1L, TimeUnit.SECONDS) ^ true)) {
        Logger.warn(TAG, "Connection to CustomTabs timed out. Skipping warmup.");
      } else {
        bool = true;
      }
    }
    catch (InterruptedException paramCountDownLatch)
    {
      Logger.error(TAG, "Failed to connect to CustomTabs. Skipping warmup.", paramCountDownLatch);
    }
    return bool;
  }
  
  public void bindCustomTabsService()
  {
    try
    {
      if (mChromePackageWithCustomTabSupport != null)
      {
        Object localObject1 = new java/util/concurrent/CountDownLatch;
        ((CountDownLatch)localObject1).<init>(1);
        MsalCustomTabsServiceConnection localMsalCustomTabsServiceConnection = new com/microsoft/identity/client/MsalChromeCustomTabManager$MsalCustomTabsServiceConnection;
        localMsalCustomTabsServiceConnection.<init>((CountDownLatch)localObject1);
        mCustomTabsServiceConnection = localMsalCustomTabsServiceConnection;
        d.d.a.b.a(mParentActivity, mChromePackageWithCustomTabSupport, localMsalCustomTabsServiceConnection);
        if (waitForServiceConnectionToEstablish((CountDownLatch)localObject1))
        {
          localObject1 = new d/d/a/c$a;
          ((c.a)localObject1).<init>(mCustomTabsServiceConnection.getCustomTabsSession());
        }
        else
        {
          localObject1 = new c.a(null);
        }
        a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
        localObject1 = ((c.a)localObject1).a();
        mCustomTabsIntent = ((c)localObject1);
        a.setPackage(mChromePackageWithCustomTabSupport);
      }
      return;
    }
    finally {}
  }
  
  public void launchChromeTabOrBrowserForUrl(String paramString)
  {
    if ((mChromePackageWithCustomTabSupport != null) && (mCustomTabsIntent != null))
    {
      Logger.info(TAG, "ChromeCustomTab support is available, launching chrome tab.");
      c localc = mCustomTabsIntent;
      Activity localActivity = mParentActivity;
      paramString = Uri.parse(paramString);
      a.setData(paramString);
      a.a(localActivity, a, b);
    }
    else
    {
      Logger.info(TAG, "Chrome tab support is not available, launching chrome browser.");
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setPackage(MsalUtils.getChromePackage(mParentActivity.getApplicationContext()));
      paramString.addCategory("android.intent.category.BROWSABLE");
      mParentActivity.startActivity(paramString);
    }
  }
  
  public void unbindCustomTabsService()
  {
    try
    {
      if ((mCustomTabsServiceConnection != null) && (mCustomTabsServiceConnection.getCustomTabsServiceIsBound()))
      {
        mParentActivity.unbindService(mCustomTabsServiceConnection);
        MsalCustomTabsServiceConnection.access$000(mCustomTabsServiceConnection);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void verifyChromeTabOrBrowser()
  {
    if (mChromePackageWithCustomTabSupport == null) {
      Logger.warn(TAG, "Custom tab is not supported by Chrome.");
    } else {
      if (MsalUtils.getChromePackage(mParentActivity.getApplicationContext()) == null) {
        break label32;
      }
    }
    return;
    label32:
    Logger.warn(TAG, "Chrome is not installed.");
    throw new MsalClientException("chrome_not_installed", "Chrome is not installed.");
  }
  
  public static class MsalCustomTabsServiceConnection
    extends d
  {
    public d.d.a.b mCustomTabsClient;
    public boolean mCustomTabsServiceIsBound;
    public e mCustomTabsSession;
    public final WeakReference<CountDownLatch> mLatchWeakReference;
    
    public MsalCustomTabsServiceConnection(CountDownLatch paramCountDownLatch)
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.MsalChromeCustomTabManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */