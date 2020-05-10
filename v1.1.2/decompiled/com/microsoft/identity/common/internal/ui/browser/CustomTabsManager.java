package com.microsoft.identity.common.internal.ui.browser;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.microsoft.identity.common.internal.logging.Logger;
import d.d.a.a;
import d.d.a.c;
import d.d.a.d;
import d.d.a.e;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CustomTabsManager
{
  public static final long CUSTOM_TABS_MAX_CONNECTION_TIMEOUT = 1L;
  public static final String TAG = "CustomTabsManager";
  public final CountDownLatch mClientLatch;
  public final WeakReference<Context> mContextRef;
  public final AtomicReference<d.d.a.b> mCustomTabsClient;
  public c mCustomTabsIntent;
  public d mCustomTabsServiceConnection = new d()
  {
    public void onCustomTabsServiceConnected(ComponentName paramAnonymousComponentName, d.d.a.b paramAnonymousb)
    {
      Logger.info(CustomTabsManager.access$000(), "CustomTabsService is connected");
      if (paramAnonymousb != null) {}
      try
      {
        a.a(0L);
        CustomTabsManager.access$102(CustomTabsManager.this, true);
        CustomTabsManager.access$200(CustomTabsManager.this).set(paramAnonymousb);
        CustomTabsManager.access$300(CustomTabsManager.this).countDown();
        return;
        throw null;
      }
      catch (RemoteException paramAnonymousComponentName)
      {
        for (;;) {}
      }
    }
    
    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Logger.info(CustomTabsManager.access$000(), "CustomTabsService is disconnected");
      CustomTabsManager.access$102(CustomTabsManager.this, false);
      CustomTabsManager.access$200(CustomTabsManager.this).set(null);
      CustomTabsManager.access$300(CustomTabsManager.this).countDown();
    }
  };
  public boolean mCustomTabsServiceIsBound;
  
  public CustomTabsManager(Context paramContext)
  {
    mContextRef = new WeakReference(paramContext);
    mCustomTabsClient = new AtomicReference();
    mClientLatch = new CountDownLatch(1);
  }
  
  private e createSession(a parama)
  {
    d.d.a.b localb = getClient();
    if (localb == null)
    {
      Logger.warn(TAG, "Failed to create custom tabs session with null CustomTabClient.");
      return null;
    }
    parama = localb.a(parama);
    if (parama == null) {
      Logger.warn(TAG, "Failed to create custom tabs session through custom tabs client.");
    }
    return parama;
  }
  
  public void bind(String paramString)
  {
    try
    {
      if ((mContextRef.get() == null) || (!d.d.a.b.a((Context)mContextRef.get(), paramString, mCustomTabsServiceConnection)))
      {
        Logger.info(TAG, "Unable to bind custom tabs service");
        mClientLatch.countDown();
      }
      Object localObject = createSession(null);
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("android.intent.action.VIEW");
      if (localObject != null) {
        localIntent.setPackage(b.getPackageName());
      }
      Bundle localBundle = new android/os/Bundle;
      localBundle.<init>();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = a.asBinder();
      }
      localBundle.putBinder("android.support.customtabs.extra.SESSION", (IBinder)localObject);
      localIntent.putExtras(localBundle);
      localIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
      localIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
      localObject = new d/d/a/c;
      ((c)localObject).<init>(localIntent, null);
      mCustomTabsIntent = ((c)localObject);
      a.setPackage(paramString);
      return;
    }
    finally {}
  }
  
  public d.d.a.b getClient()
  {
    try
    {
      mClientLatch.await(1L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      Logger.info(TAG, "Interrupted while waiting for browser connection");
      mClientLatch.countDown();
    }
    return (d.d.a.b)mCustomTabsClient.get();
  }
  
  public c getCustomTabsIntent()
  {
    return mCustomTabsIntent;
  }
  
  public void unbind()
  {
    try
    {
      if ((mContextRef.get() != null) && (mCustomTabsServiceIsBound)) {
        ((Context)mContextRef.get()).unbindService(mCustomTabsServiceConnection);
      }
      mCustomTabsServiceIsBound = false;
      mCustomTabsClient.set(null);
      Logger.info(TAG, "CustomTabsService is unbound.");
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.browser.CustomTabsManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */