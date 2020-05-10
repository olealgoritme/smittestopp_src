package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.webkit.HttpAuthHandler;
import android.webkit.WebView;

public final class ChallengeFactory
{
  public static NtlmChallenge getNtlmChallenge(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    return new NtlmChallenge(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.ChallengeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */