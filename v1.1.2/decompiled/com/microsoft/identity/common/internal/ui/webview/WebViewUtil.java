package com.microsoft.identity.common.internal.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.WebView;
import e.a.a.a.a;

public class WebViewUtil
{
  public static final String TAG = "WebViewUtil";
  
  public static CookieManager getCookieManager(Context paramContext)
  {
    setDataDirectorySuffix(paramContext);
    return CookieManager.getInstance();
  }
  
  public static void removeCookiesFromWebView(Context paramContext)
  {
    paramContext = getCookieManager(paramContext);
    paramContext.removeAllCookies(null);
    paramContext.flush();
  }
  
  public static void removeSessionCookiesFromWebView(Context paramContext)
  {
    paramContext = getCookieManager(paramContext);
    paramContext.removeAllCookies(null);
    paramContext.flush();
  }
  
  public static void setAcceptCookie(boolean paramBoolean, Context paramContext)
  {
    getCookieManager(paramContext).setAcceptCookie(paramBoolean);
  }
  
  @SuppressLint({"NewApi"})
  public static void setDataDirectorySuffix(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      try
      {
        if (ProcessUtil.isRunningOnAuthService(paramContext)) {
          WebView.setDataDirectorySuffix("auth");
        }
      }
      catch (IllegalStateException paramContext)
      {
        a.c(new StringBuilder(), TAG, ":setDataDirectorySuffix", "WebView is already initialized. IllegalStateException is expected when setDataDirectorySuffix() is invoked");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.WebViewUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */