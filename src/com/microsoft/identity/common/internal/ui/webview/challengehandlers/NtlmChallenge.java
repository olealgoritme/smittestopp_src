package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

public class NtlmChallenge
{
  public HttpAuthHandler mHandler;
  public String mHost;
  public String mRealm;
  public WebView mView;
  
  public NtlmChallenge(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    mHandler = paramHttpAuthHandler;
    mView = paramWebView;
    mHost = paramString1;
    mRealm = paramString2;
  }
  
  public HttpAuthHandler getHandler()
  {
    return mHandler;
  }
  
  public String getHost()
  {
    return mHost;
  }
  
  public String getRealm()
  {
    return mRealm;
  }
  
  public WebView getView()
  {
    return mView;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallenge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */