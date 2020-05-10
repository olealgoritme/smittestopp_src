package com.microsoft.identity.common.internal.ui.browser;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BrowserSelector
{
  public static final String SCHEME_HTTP = "http";
  public static final String SCHEME_HTTPS = "https";
  public static final String TAG = "BrowserSelector";
  
  public static List<Browser> getAllBrowsers(Context paramContext)
  {
    Object localObject1 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramContext.getPackageManager();
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      i = 65600;
    } else {
      i = 64;
    }
    localObject1 = ((PackageManager)localObject2).queryIntentActivities((Intent)localObject1, i).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (ResolveInfo)((Iterator)localObject1).next();
      if (isFullBrowser((ResolveInfo)localObject3)) {
        try
        {
          localObject3 = ((PackageManager)localObject2).getPackageInfo(activityInfo.packageName, 64);
          Browser localBrowser;
          if (isCustomTabsServiceSupported(paramContext, (PackageInfo)localObject3))
          {
            localBrowser = new com/microsoft/identity/common/internal/ui/browser/Browser;
            localBrowser.<init>((PackageInfo)localObject3, Boolean.valueOf(true));
            localArrayList.add(localBrowser);
          }
          else
          {
            localBrowser = new com/microsoft/identity/common/internal/ui/browser/Browser;
            localBrowser.<init>((PackageInfo)localObject3, Boolean.valueOf(false));
            localArrayList.add(localBrowser);
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      }
    }
    paramContext = TAG;
    localObject2 = a.a("Found ");
    ((StringBuilder)localObject2).append(localArrayList.size());
    ((StringBuilder)localObject2).append(" browsers.");
    Logger.verbose(paramContext, null, ((StringBuilder)localObject2).toString());
    return localArrayList;
  }
  
  public static boolean isCustomTabsServiceSupported(Context paramContext, PackageInfo paramPackageInfo)
  {
    Object localObject = new StringBuilder("android");
    ((StringBuilder)localObject).append(".support.customtabs.action.CustomTabsService");
    localObject = new Intent(((StringBuilder)localObject).toString());
    ((Intent)localObject).setPackage(packageName);
    paramContext = paramContext.getPackageManager();
    boolean bool1 = false;
    paramContext = paramContext.queryIntentServices((Intent)localObject, 0);
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      bool2 = bool1;
      if (!paramContext.isEmpty()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static boolean isFullBrowser(ResolveInfo paramResolveInfo)
  {
    if ((filter.hasAction("android.intent.action.VIEW")) && (filter.hasCategory("android.intent.category.BROWSABLE")) && (filter.schemesIterator() != null))
    {
      if (filter.authoritiesIterator() != null) {
        return false;
      }
      paramResolveInfo = filter.schemesIterator();
      int i = 0;
      int j = 0;
      while (paramResolveInfo.hasNext())
      {
        String str = (String)paramResolveInfo.next();
        boolean bool1 = i | "http".equals(str);
        boolean bool2 = j | "https".equals(str);
        i = bool1;
        j = bool2;
        if (bool1)
        {
          i = bool1;
          j = bool2;
          if (bool2) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static Browser select(Context paramContext, List<BrowserDescriptor> paramList)
  {
    paramContext = getAllBrowsers(paramContext);
    Logger.verbose(TAG, "Select the browser to launch.");
    Iterator localIterator;
    do
    {
      localObject = paramContext.iterator();
      while (!localIterator.hasNext())
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramContext = (Browser)((Iterator)localObject).next();
        localIterator = paramList.iterator();
      }
    } while (!((BrowserDescriptor)localIterator.next()).matches(paramContext));
    Object localObject = TAG;
    paramList = a.a("Browser's package name: ");
    paramList.append(paramContext.getPackageName());
    paramList.append(" version: ");
    paramList.append(paramContext.getVersion());
    Logger.info((String)localObject, paramList.toString());
    return paramContext;
    Logger.error(TAG, "No available browser installed on the device.", null);
    throw new ClientException("No available browser installed on the device.", "No available browser installed on the device.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.browser.BrowserSelector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */