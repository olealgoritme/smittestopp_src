package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.internal.logging.Logger;
import d.d.a.b;
import d.d.a.c;
import d.d.a.c.a;
import d.d.a.d;
import d.i.b.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MsalChromeCustomTabManager
{
  public static final long CUSTOM_TABS_MAX_CONNECTION_TIMEOUT = 1L;
  public static final String TAG = "MsalChromeCustomTabManager";
  public String mChromePackageWithCustomTabSupport;
  public c mCustomTabsIntent;
  public MsalChromeCustomTabManager.MsalCustomTabsServiceConnection mCustomTabsServiceConnection;
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
        CountDownLatch localCountDownLatch = new java/util/concurrent/CountDownLatch;
        localCountDownLatch.<init>(1);
        Object localObject1 = new com/microsoft/identity/client/MsalChromeCustomTabManager$MsalCustomTabsServiceConnection;
        ((MsalChromeCustomTabManager.MsalCustomTabsServiceConnection)localObject1).<init>(localCountDownLatch);
        mCustomTabsServiceConnection = ((MsalChromeCustomTabManager.MsalCustomTabsServiceConnection)localObject1);
        b.a(mParentActivity, mChromePackageWithCustomTabSupport, (d)localObject1);
        if (waitForServiceConnectionToEstablish(localCountDownLatch))
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
        MsalChromeCustomTabManager.MsalCustomTabsServiceConnection.access$000(mCustomTabsServiceConnection);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MsalChromeCustomTabManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */