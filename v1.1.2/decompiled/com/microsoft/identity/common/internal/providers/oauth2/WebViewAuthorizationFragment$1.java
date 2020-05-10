package com.microsoft.identity.common.internal.providers.oauth2;

import android.webkit.WebView;
import android.widget.ProgressBar;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.ui.webview.OnPageLoadedCallback;

public class WebViewAuthorizationFragment$1
  implements OnPageLoadedCallback
{
  public WebViewAuthorizationFragment$1(WebViewAuthorizationFragment paramWebViewAuthorizationFragment) {}
  
  public void onPageLoaded()
  {
    WebViewAuthorizationFragment.access$000(this$0).setVisibility(4);
    if (!StringExtensions.isNullOrBlank(WebViewAuthorizationFragment.access$100(this$0))) {
      WebViewAuthorizationFragment.access$200(this$0).loadUrl(WebViewAuthorizationFragment.access$100(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */