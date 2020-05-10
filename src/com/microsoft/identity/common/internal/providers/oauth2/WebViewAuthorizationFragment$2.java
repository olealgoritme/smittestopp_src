package com.microsoft.identity.common.internal.providers.oauth2;

import android.webkit.WebView;
import android.widget.ProgressBar;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;

public class WebViewAuthorizationFragment$2
  implements Runnable
{
  public WebViewAuthorizationFragment$2(WebViewAuthorizationFragment paramWebViewAuthorizationFragment) {}
  
  public void run()
  {
    WebViewAuthorizationFragment.access$200(this$0).loadUrl("about:blank");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(WebViewAuthorizationFragment.access$300());
    localStringBuilder.append("#onCreateView");
    Logger.info(localStringBuilder.toString(), "Launching embedded WebView for acquiring auth code.");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(WebViewAuthorizationFragment.access$300());
    localStringBuilder.append("#onCreateView");
    String str = localStringBuilder.toString();
    localStringBuilder = a.a("The start url is ");
    localStringBuilder.append(WebViewAuthorizationFragment.access$400(this$0));
    Logger.infoPII(str, localStringBuilder.toString());
    WebViewAuthorizationFragment.access$200(this$0).loadUrl(WebViewAuthorizationFragment.access$400(this$0), WebViewAuthorizationFragment.access$500(this$0));
    WebViewAuthorizationFragment.access$000(this$0).setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */