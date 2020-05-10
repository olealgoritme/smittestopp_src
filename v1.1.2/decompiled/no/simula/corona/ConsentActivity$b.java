package no.simula.corona;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import i.k.b.g;

public final class ConsentActivity$b
  extends WebViewClient
{
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (paramWebView != null)
    {
      if (paramString != null)
      {
        paramWebView = (ProgressBar)a.a(R.id.progressBar);
        g.a(paramWebView, "progressBar");
        paramWebView.setVisibility(8);
        paramWebView = (LinearLayout)a.a(R.id.actionsLayout);
        g.a(paramWebView, "actionsLayout");
        paramWebView.setVisibility(0);
        return;
      }
      g.a("url");
      throw null;
    }
    g.a("view");
    throw null;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
    Object localObject = null;
    if (paramWebView != null)
    {
      Context localContext = paramWebView.getContext();
      paramWebView = (WebView)localObject;
      if (paramWebResourceRequest != null) {
        paramWebView = paramWebResourceRequest.getUrl();
      }
      localContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.valueOf(paramWebView))));
      return true;
    }
    g.a();
    throw null;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    super.shouldOverrideUrlLoading(paramWebView, paramString);
    if (paramWebView != null)
    {
      paramWebView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
    g.a();
    throw null;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ConsentActivity.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */