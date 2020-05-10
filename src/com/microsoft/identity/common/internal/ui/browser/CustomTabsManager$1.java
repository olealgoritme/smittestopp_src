package com.microsoft.identity.common.internal.ui.browser;

import android.content.ComponentName;
import android.os.RemoteException;
import com.microsoft.identity.common.internal.logging.Logger;
import d.d.a.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class CustomTabsManager$1
  extends d
{
  public CustomTabsManager$1(CustomTabsManager paramCustomTabsManager) {}
  
  public void onCustomTabsServiceConnected(ComponentName paramComponentName, d.d.a.b paramb)
  {
    Logger.info(CustomTabsManager.access$000(), "CustomTabsService is connected");
    if (paramb != null) {}
    try
    {
      a.a(0L);
      CustomTabsManager.access$102(this$0, true);
      CustomTabsManager.access$200(this$0).set(paramb);
      CustomTabsManager.access$300(this$0).countDown();
      return;
      throw null;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;) {}
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Logger.info(CustomTabsManager.access$000(), "CustomTabsService is disconnected");
    CustomTabsManager.access$102(this$0, false);
    CustomTabsManager.access$200(this$0).set(null);
    CustomTabsManager.access$300(this$0).countDown();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.browser.CustomTabsManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */