package com.microsoft.identity.common.internal.ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.ChallengeFactory;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.NtlmChallengeHandler;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;

public abstract class OAuth2WebViewClient
  extends WebViewClient
{
  public static final String TAG = OAuth2WebViewClient.class.getSimpleName();
  public final Activity mActivity;
  public final IAuthorizationCompletionCallback mCompletionCallback;
  public final OnPageLoadedCallback mPageLoadedCallback;
  
  public OAuth2WebViewClient(Activity paramActivity, IAuthorizationCompletionCallback paramIAuthorizationCompletionCallback, OnPageLoadedCallback paramOnPageLoadedCallback)
  {
    mActivity = paramActivity;
    mCompletionCallback = paramIAuthorizationCompletionCallback;
    mPageLoadedCallback = paramOnPageLoadedCallback;
  }
  
  private void checkStartUrl(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
    {
      Logger.info(TAG, "onPageStarted: Null url for page to load.");
      return;
    }
    Object localObject1 = Uri.parse(paramString);
    Object localObject2;
    if (((Uri)localObject1).isOpaque())
    {
      Logger.info(TAG, "onPageStarted: Non-hierarchical loading uri.");
      localObject2 = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start url: ");
      ((StringBuilder)localObject1).append(paramString);
      Logger.infoPII((String)localObject2, ((StringBuilder)localObject1).toString());
    }
    else if (StringUtil.isEmpty(((Uri)localObject1).getQueryParameter("code")))
    {
      localObject2 = TAG;
      paramString = a.a("Host: ");
      paramString.append(((Uri)localObject1).getHost());
      paramString.append(" Path: ");
      paramString.append(((Uri)localObject1).getPath());
      Logger.infoPII((String)localObject2, paramString.toString());
    }
    else
    {
      Logger.info(TAG, "Auth code is returned for the loading url.");
      paramString = TAG;
      localObject2 = a.a("Host: ");
      ((StringBuilder)localObject2).append(((Uri)localObject1).getHost());
      ((StringBuilder)localObject2).append(" Path: ");
      ((StringBuilder)localObject2).append(((Uri)localObject1).getPath());
      Logger.infoPII(paramString, ((StringBuilder)localObject2).toString());
    }
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public IAuthorizationCompletionCallback getCompletionCallback()
  {
    return mCompletionCallback;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    mPageLoadedCallback.onPageLoaded();
    paramWebView.setVisibility(0);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    checkStartUrl(paramString);
    Logger.info(TAG, "WebView starts loading.");
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    paramWebView.stopLoading();
    paramWebView = new Intent();
    paramString2 = new StringBuilder();
    paramString2.append("Error Code:");
    paramString2.append(paramInt);
    paramWebView.putExtra("com.microsoft.aad.adal:BrowserErrorCode", paramString2.toString());
    paramWebView.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", paramString1);
    mCompletionCallback.onChallengeResponseReceived(2002, paramWebView);
  }
  
  public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
  {
    Logger.info(TAG, "Receive the http auth request. Start the dialog to ask for creds. ");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Host:");
    localStringBuilder.append(paramString1);
    Logger.infoPII(str, localStringBuilder.toString());
    paramWebView = ChallengeFactory.getNtlmChallenge(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
    new NtlmChallengeHandler(mActivity, mCompletionCallback).processChallenge(paramWebView);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    paramSslErrorHandler.cancel();
    paramWebView = new Intent();
    paramWebView.putExtra("com.microsoft.aad.adal:BrowserErrorCode", "Code:-11");
    paramWebView.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", paramSslError.toString());
    mCompletionCallback.onChallengeResponseReceived(2002, paramWebView);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.OAuth2WebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */