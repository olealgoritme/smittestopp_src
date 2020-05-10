package com.microsoft.identity.common.internal.ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

public class AzureActiveDirectoryWebViewClient$1
  implements Runnable
{
  public AzureActiveDirectoryWebViewClient$1(AzureActiveDirectoryWebViewClient paramAzureActiveDirectoryWebViewClient, String paramString, WebView paramWebView) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(val$installLink.replace("browser://", "https://")));
    this$0.getActivity().startActivity(localIntent);
    val$view.stopLoading();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */