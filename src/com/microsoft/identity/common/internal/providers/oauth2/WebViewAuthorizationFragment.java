package com.microsoft.identity.common.internal.providers.oauth2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.R.id;
import com.microsoft.identity.common.R.layout;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient;
import com.microsoft.identity.common.internal.ui.webview.WebViewUtil;
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
    mWebView.setOnTouchListener(new WebViewAuthorizationFragment.3(this));
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
    setUpWebView(paramLayoutInflater, new AzureActiveDirectoryWebViewClient(getActivity(), new WebViewAuthorizationFragment.AuthorizationCompletionCallback(this), new WebViewAuthorizationFragment.1(this), mRedirectUri));
    mWebView.post(new WebViewAuthorizationFragment.2(this));
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */