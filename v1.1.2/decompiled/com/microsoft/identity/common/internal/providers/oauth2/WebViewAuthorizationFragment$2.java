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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(WebViewAuthorizationFragment.access$300());
    ((StringBuilder)localObject).append("#onCreateView");
    Logger.info(((StringBuilder)localObject).toString(), "Launching embedded WebView for acquiring auth code.");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(WebViewAuthorizationFragment.access$300());
    ((StringBuilder)localObject).append("#onCreateView");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = a.a("The start url is ");
    localStringBuilder.append(WebViewAuthorizationFragment.access$400(this$0));
    Logger.infoPII((String)localObject, localStringBuilder.toString());
    WebViewAuthorizationFragment.access$200(this$0).loadUrl(WebViewAuthorizationFragment.access$400(this$0), WebViewAuthorizationFragment.access$500(this$0));
    WebViewAuthorizationFragment.access$000(this$0).setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */