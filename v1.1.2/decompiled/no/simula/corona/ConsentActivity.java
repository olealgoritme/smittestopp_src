package no.simula.corona;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import d.b.a.h;
import i.k.b.g;
import java.util.HashMap;

public final class ConsentActivity
  extends h
{
  public HashMap A;
  
  public View a(int paramInt)
  {
    if (A == null) {
      A = new HashMap();
    }
    View localView1 = (View)A.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      A.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  public void onBackPressed()
  {
    finishAffinity();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558428);
    paramBundle = (WebView)a(R.id.privacy_policy);
    g.a(paramBundle, "privacy_policy");
    paramBundle.setWebViewClient(new b(this));
    ((WebView)a(R.id.privacy_policy)).setBackgroundColor(Color.parseColor("#F1EFEA"));
    ((WebView)a(R.id.privacy_policy)).loadUrl("file:///android_asset/consent.html");
    ((Button)a(R.id.confirmConsent)).setOnClickListener(new a(0, this));
    ((Button)a(R.id.denyConsent)).setOnClickListener(new a(1, this));
  }
  
  public static final class a
    implements View.OnClickListener
  {
    public a(int paramInt, Object paramObject) {}
    
    public final void onClick(View paramView)
    {
      int i = x;
      if (i != 0)
      {
        if (i == 1)
        {
          ConsentActivity.b((ConsentActivity)jdField_this);
          return;
        }
        throw null;
      }
      ConsentActivity.a((ConsentActivity)jdField_this);
    }
  }
  
  public static final class b
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
}

/* Location:
 * Qualified Name:     no.simula.corona.ConsentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */