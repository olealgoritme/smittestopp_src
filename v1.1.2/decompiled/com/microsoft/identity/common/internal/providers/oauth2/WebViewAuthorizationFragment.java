package com.microsoft.identity.common.internal.providers.oauth2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.R.id;
import com.microsoft.identity.common.R.layout;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient;
import com.microsoft.identity.common.internal.ui.webview.OnPageLoadedCallback;
import com.microsoft.identity.common.internal.ui.webview.WebViewUtil;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IAuthorizationCompletionCallback;
import e.a.a.a.a;
import java.util.HashMap;

public class WebViewAuthorizationFragment
  extends AuthorizationFragment
{
  public static final String PKEYAUTH_STATUS = "pkeyAuthStatus";
  public static final String TAG = WebViewAuthorizationFragment.class.getSimpleName();
  public Intent mAuthIntent;
  public String mAuthorizationRequestUrl;
  public boolean mPkeyAuthStatus = false;
  public String mPostPageLoadedUrl;
  public ProgressBar mProgressBar;
  public String mRedirectUri;
  public HashMap<String, String> mRequestHeaders;
  public WebView mWebView;
  public boolean webViewZoomControlsEnabled;
  public boolean webViewZoomEnabled;
  
  private HashMap<String, String> getRequestHeaders(Bundle paramBundle)
  {
    try
    {
      paramBundle = (HashMap)paramBundle.getSerializable("com.microsoft.identity.request.headers");
      return paramBundle;
    }
    catch (Exception paramBundle) {}
    return null;
  }
  
  @SuppressLint({"SetJavaScriptEnabled", "ClickableViewAccessibility"})
  private void setUpWebView(View paramView, AzureActiveDirectoryWebViewClient paramAzureActiveDirectoryWebViewClient)
  {
    paramView = (WebView)paramView.findViewById(R.id.common_auth_webview);
    mWebView = paramView;
    String str = paramView.getSettings().getUserAgentString();
    paramView = mWebView.getSettings();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" PKeyAuth/1.0");
    paramView.setUserAgentString(localStringBuilder.toString());
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.requestFocus(130);
    mWebView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        int i = paramAnonymousMotionEvent.getAction();
        if (((i == 0) || (i == 1)) && (!paramAnonymousView.hasFocus())) {
          paramAnonymousView.requestFocus();
        }
        return false;
      }
    });
    mWebView.getSettings().setLoadWithOverviewMode(true);
    mWebView.getSettings().setDomStorageEnabled(true);
    mWebView.getSettings().setUseWideViewPort(true);
    mWebView.getSettings().setBuiltInZoomControls(webViewZoomControlsEnabled);
    mWebView.getSettings().setSupportZoom(webViewZoomEnabled);
    mWebView.setVisibility(4);
    mWebView.setWebViewClient(paramAzureActiveDirectoryWebViewClient);
  }
  
  public void extractState(Bundle paramBundle)
  {
    super.extractState(paramBundle);
    mAuthIntent = ((Intent)paramBundle.getParcelable("com.microsoft.identity.auth.intent"));
    mPkeyAuthStatus = paramBundle.getBoolean("pkeyAuthStatus", false);
    mAuthorizationRequestUrl = paramBundle.getString("com.microsoft.identity.request.url");
    mRedirectUri = paramBundle.getString("com.microsoft.identity.request.redirect.uri");
    mRequestHeaders = getRequestHeaders(paramBundle);
    mPostPageLoadedUrl = paramBundle.getString("com.microsoft.identity.post.page.loaded.url");
    webViewZoomEnabled = paramBundle.getBoolean("com.microsoft.identity.web.view.zoom.enabled", true);
    webViewZoomControlsEnabled = paramBundle.getBoolean("com.microsoft.identity.web.view.zoom.controls.enabled", true);
  }
  
  public boolean onBackPressed()
  {
    Logger.info(TAG, "Back button is pressed");
    WebView localWebView = mWebView;
    if ((localWebView != null) && (localWebView.canGoBack()))
    {
      if (!mWebView.canGoBackOrForward(-2)) {
        cancelAuthorization(true);
      } else {
        mWebView.goBack();
      }
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WebViewUtil.setDataDirectorySuffix(getActivity().getApplicationContext());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.common_activity_authentication, paramViewGroup, false);
    mProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(R.id.common_auth_webview_progressbar));
    setUpWebView(paramLayoutInflater, new AzureActiveDirectoryWebViewClient(getActivity(), new AuthorizationCompletionCallback(), new OnPageLoadedCallback()
    {
      public void onPageLoaded()
      {
        WebViewAuthorizationFragment.access$000(WebViewAuthorizationFragment.this).setVisibility(4);
        if (!StringExtensions.isNullOrBlank(WebViewAuthorizationFragment.access$100(WebViewAuthorizationFragment.this))) {
          WebViewAuthorizationFragment.access$200(WebViewAuthorizationFragment.this).loadUrl(WebViewAuthorizationFragment.access$100(WebViewAuthorizationFragment.this));
        }
      }
    }, mRedirectUri));
    mWebView.post(new Runnable()
    {
      public void run()
      {
        WebViewAuthorizationFragment.access$200(WebViewAuthorizationFragment.this).loadUrl("about:blank");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(WebViewAuthorizationFragment.access$300());
        ((StringBuilder)localObject).append("#onCreateView");
        Logger.info(((StringBuilder)localObject).toString(), "Launching embedded WebView for acquiring auth code.");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(WebViewAuthorizationFragment.access$300());
        ((StringBuilder)localObject).append("#onCreateView");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = a.a("The start url is ");
        localStringBuilder.append(WebViewAuthorizationFragment.access$400(WebViewAuthorizationFragment.this));
        Logger.infoPII((String)localObject, localStringBuilder.toString());
        WebViewAuthorizationFragment.access$200(WebViewAuthorizationFragment.this).loadUrl(WebViewAuthorizationFragment.access$400(WebViewAuthorizationFragment.this), WebViewAuthorizationFragment.access$500(WebViewAuthorizationFragment.this));
        WebViewAuthorizationFragment.access$000(WebViewAuthorizationFragment.this).setVisibility(0);
      }
    });
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("com.microsoft.identity.auth.intent", mAuthIntent);
    paramBundle.putBoolean("pkeyAuthStatus", mPkeyAuthStatus);
    paramBundle.putString("com.microsoft.identity.request.redirect.uri", mRedirectUri);
    paramBundle.putString("com.microsoft.identity.request.url", mAuthorizationRequestUrl);
    paramBundle.putSerializable("com.microsoft.identity.request.headers", mRequestHeaders);
    paramBundle.putSerializable("com.microsoft.identity.post.page.loaded.url", mPostPageLoadedUrl);
    paramBundle.putSerializable("com.microsoft.identity.post.page.loaded.url", mPostPageLoadedUrl);
    paramBundle.putBoolean("com.microsoft.identity.web.view.zoom.controls.enabled", webViewZoomControlsEnabled);
    paramBundle.putBoolean("com.microsoft.identity.web.view.zoom.enabled", webViewZoomEnabled);
  }
  
  public class AuthorizationCompletionCallback
    implements IAuthorizationCompletionCallback
  {
    public AuthorizationCompletionCallback() {}
    
    public void onChallengeResponseReceived(int paramInt, Intent paramIntent)
    {
      String str = WebViewAuthorizationFragment.access$300();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onChallengeResponseReceived:");
      localStringBuilder.append(paramInt);
      Logger.info(str, null, localStringBuilder.toString());
      sendResult(paramInt, paramIntent);
      finish();
    }
    
    public void setPKeyAuthStatus(boolean paramBoolean)
    {
      WebViewAuthorizationFragment.access$602(WebViewAuthorizationFragment.this, paramBoolean);
      String str = WebViewAuthorizationFragment.access$300();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPKeyAuthStatus:");
      localStringBuilder.append(paramBoolean);
      Logger.info(str, null, localStringBuilder.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */