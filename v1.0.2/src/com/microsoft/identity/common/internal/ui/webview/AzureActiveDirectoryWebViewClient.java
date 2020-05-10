package com.microsoft.identity.common.internal.ui.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.ClientCertAuthChallengeHandler;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IAuthorizationCompletionCallback;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeFactory;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AzureActiveDirectoryWebViewClient
  extends OAuth2WebViewClient
{
  public static final String ERROR = "error";
  public static final String ERROR_DESCRIPTION = "error_description";
  public static final String ERROR_SUBCODE = "error_subcode";
  public static final String TAG = AzureActiveDirectoryWebViewClient.class.getSimpleName();
  public final String mRedirectUrl;
  
  public AzureActiveDirectoryWebViewClient(Activity paramActivity, IAuthorizationCompletionCallback paramIAuthorizationCompletionCallback, OnPageLoadedCallback paramOnPageLoadedCallback, String paramString)
  {
    super(paramActivity, paramIAuthorizationCompletionCallback, paramOnPageLoadedCallback);
    mRedirectUrl = paramString;
  }
  
  private boolean handleUrl(WebView paramWebView, String paramString)
  {
    Object localObject = paramString.toLowerCase(Locale.US);
    if (isPkeyAuthUrl((String)localObject))
    {
      Logger.info(TAG, "WebView detected request for pkeyauth challenge.");
      try
      {
        localObject = new com/microsoft/identity/common/internal/ui/webview/challengehandlers/PKeyAuthChallengeFactory;
        ((PKeyAuthChallengeFactory)localObject).<init>();
        paramString = ((PKeyAuthChallengeFactory)localObject).getPKeyAuthChallenge(paramString);
        localObject = new com/microsoft/identity/common/internal/ui/webview/challengehandlers/PKeyAuthChallengeHandler;
        ((PKeyAuthChallengeHandler)localObject).<init>(paramWebView, getCompletionCallback());
        ((PKeyAuthChallengeHandler)localObject).processChallenge(paramString);
      }
      catch (ClientException paramString)
      {
        Logger.error(TAG, paramString.getErrorCode(), null);
        Logger.errorPII(TAG, paramString.getMessage(), paramString);
        returnError(paramString.getErrorCode(), paramString.getMessage());
        paramWebView.stopLoading();
      }
      return true;
    }
    if (isRedirectUrl((String)localObject))
    {
      Logger.info(TAG, "Navigation starts with the redirect uri.");
      return processRedirectUrl(paramWebView, paramString);
    }
    if (isWebsiteRequestUrl((String)localObject))
    {
      Logger.info(TAG, "It is an external website request");
      return processWebsiteRequest(paramWebView, paramString);
    }
    if (isInstallRequestUrl((String)localObject))
    {
      Logger.info(TAG, "It is an install request");
      return processInstallRequest(paramWebView, paramString);
    }
    Logger.info(TAG, "It is an invalid redirect uri.");
    return processInvalidUrl(paramWebView, paramString);
  }
  
  private boolean isBrokerRequest(Intent paramIntent)
  {
    boolean bool;
    if ((paramIntent != null) && (!StringExtensions.isNullOrBlank(paramIntent.getStringExtra("com.microsoft.aadbroker.adal.broker.request")))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isInstallRequestUrl(String paramString)
  {
    return paramString.startsWith("msauth://");
  }
  
  private boolean isPkeyAuthUrl(String paramString)
  {
    return paramString.startsWith("urn:http-auth:PKeyAuth".toLowerCase());
  }
  
  private boolean isRedirectUrl(String paramString)
  {
    return paramString.startsWith(mRedirectUrl.toLowerCase(Locale.US));
  }
  
  private boolean isWebsiteRequestUrl(String paramString)
  {
    return paramString.startsWith("browser://");
  }
  
  private void openLinkInBrowser(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("#openLinkInBrowser");
    Logger.info(localStringBuilder.toString(), "Try to open url link in browser");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString.replace("browser://", "https://")));
    if (paramString.resolveActivity(getActivity().getPackageManager()) != null) {
      getActivity().startActivity(paramString);
    } else {
      a.c(new StringBuilder(), TAG, "#openLinkInBrowser", "Unable to find an app to resolve the activity.");
    }
  }
  
  private boolean processInstallRequest(WebView paramWebView, String paramString)
  {
    Intent localIntent = new Intent();
    Object localObject = StringExtensions.getUrlParameters(paramString);
    paramString = (String)((HashMap)localObject).get("app_link");
    localObject = (String)((HashMap)localObject).get("username");
    if (TextUtils.isEmpty(paramString))
    {
      Logger.info(TAG, "Install link is null or empty, Return to caller with BROWSER_CODE_DEVICE_REGISTER");
      localIntent.putExtra("username", (String)localObject);
      getCompletionCallback().onChallengeResponseReceived(2007, localIntent);
      paramWebView.stopLoading();
      return true;
    }
    Logger.info(TAG, "Return to caller with BROKER_REQUEST_RESUME, and waiting for result.");
    getCompletionCallback().onChallengeResponseReceived(2006, localIntent);
    new Handler().postDelayed(new AzureActiveDirectoryWebViewClient.1(this, paramString, paramWebView), 1000L);
    return true;
  }
  
  private boolean processInvalidUrl(WebView paramWebView, String paramString)
  {
    if ((isBrokerRequest(getActivity().getIntent())) && (paramString.startsWith("msauth")))
    {
      Logger.error(TAG, "The RedirectUri is not as expected.", null);
      Logger.errorPII(TAG, String.format("Received %s and expected %s", new Object[] { paramString, mRedirectUrl }), null);
      returnError("The redirectUri for broker is invalid", String.format("The RedirectUri is not as expected. Received %s and expected %s", new Object[] { paramString, mRedirectUrl }));
      paramWebView.stopLoading();
      return true;
    }
    if (paramString.toLowerCase(Locale.US).equals("about:blank"))
    {
      Logger.verbose(TAG, "It is an blank page request");
      return true;
    }
    if (!paramString.toLowerCase(Locale.US).startsWith("https://"))
    {
      try
      {
        paramString = StringExtensions.removeQueryParameterFromUrl(paramString);
      }
      catch (URISyntaxException paramString)
      {
        paramString = "redacted";
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The webView was redirected to an unsafe URL: ");
      localStringBuilder.append(paramString);
      Logger.error(str, localStringBuilder.toString(), null);
      returnError("Redirect url scheme not SSL protected", "The webView was redirected to an unsafe URL.");
      paramWebView.stopLoading();
      return true;
    }
    return false;
  }
  
  private boolean processWebsiteRequest(WebView paramWebView, String paramString)
  {
    Object localObject1 = new PackageHelper(getActivity().getPackageManager());
    Object localObject2 = getActivity().getApplicationContext();
    if ((paramString.startsWith("browser://go.microsoft.com/fwlink/?LinkId=396941")) && (((PackageHelper)localObject1).isPackageInstalledAndEnabled((Context)localObject2, "com.microsoft.windowsintune.companyportal")) && (((PackageHelper)localObject1).isPackageInstalledAndEnabled((Context)localObject2, "com.microsoft.skype.teams.ipphone")) && ("fcg80qvoM1YMKJZibjBwQcDfOno=".equals(((PackageHelper)localObject1).getCurrentSignatureForPackage("com.microsoft.skype.teams.ipphone"))))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append("#processWebsiteRequest");
      Logger.info(((StringBuilder)localObject1).toString(), "It is a device CA request on IPPhone. Company Portal is installed.");
      try
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append(TAG);
        ((StringBuilder)localObject1).append("#processWebsiteRequest");
        Logger.verbose(((StringBuilder)localObject1).toString(), "Sending intent to launch the CompanyPortal.");
        localObject2 = new android/content/Intent;
        ((Intent)localObject2).<init>();
        localObject1 = new android/content/ComponentName;
        ((ComponentName)localObject1).<init>("com.microsoft.windowsintune.companyportal", "com.microsoft.windowsintune.companyportal.views.SplashActivity");
        ((Intent)localObject2).setComponent((ComponentName)localObject1);
        ((Intent)localObject2).addFlags(268468224);
        getActivity().startActivity((Intent)localObject2);
      }
      catch (SecurityException localSecurityException)
      {
        a.c(new StringBuilder(), TAG, "#processWebsiteRequest", "Failed to launch Company Portal, falling back to browser.");
        openLinkInBrowser(paramString);
      }
    }
    else
    {
      openLinkInBrowser(paramString);
    }
    paramWebView.stopLoading();
    paramWebView = new Intent();
    getCompletionCallback().onChallengeResponseReceived(2001, paramWebView);
    return true;
  }
  
  private void returnError(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.microsoft.aad.adal:BrowserErrorCode", paramString1);
    localIntent.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", paramString2);
    getCompletionCallback().onChallengeResponseReceived(2002, localIntent);
  }
  
  @TargetApi(21)
  public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
  {
    new ClientCertAuthChallengeHandler(getActivity()).processChallenge(paramClientCertRequest);
  }
  
  public boolean processRedirectUrl(WebView paramWebView, String paramString)
  {
    Object localObject = StringExtensions.getUrlParameters(paramString);
    if (!StringExtensions.isNullOrBlank((String)((Map)localObject).get("error")))
    {
      Logger.info(TAG, "Sending intent to cancel authentication activity");
      paramString = new Intent();
      paramString.putExtra("com.microsoft.aad.adal:BrowserErrorCode", (String)((Map)localObject).get("error"));
      paramString.putExtra("com.microsoft.aad.adal:BrowserErrorSubCode", (String)((Map)localObject).get("error_subcode"));
      if (!StringUtil.isEmpty((String)((Map)localObject).get("error_description"))) {
        paramString.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", (String)((Map)localObject).get("error_description"));
      } else {
        paramString.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", (String)((Map)localObject).get("error_subcode"));
      }
      if ((!StringUtil.isEmpty((String)((Map)localObject).get("error_subcode"))) && (((String)((Map)localObject).get("error_subcode")).equalsIgnoreCase("cancel"))) {
        getCompletionCallback().onChallengeResponseReceived(2001, paramString);
      } else {
        getCompletionCallback().onChallengeResponseReceived(2002, paramString);
      }
      paramWebView.stopLoading();
    }
    else
    {
      Logger.info(TAG, "It is pointing to redirect. Final url can be processed to get the code or error.");
      localObject = new Intent();
      ((Intent)localObject).putExtra("com.microsoft.identity.client.final.url", paramString);
      getCompletionCallback().onChallengeResponseReceived(2003, (Intent)localObject);
      paramWebView.stopLoading();
    }
    return true;
  }
  
  @TargetApi(24)
  public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    return handleUrl(paramWebView, paramWebResourceRequest.getUrl().toString());
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (!StringUtil.isEmpty(paramString)) {
      return handleUrl(paramWebView, paramString);
    }
    throw new IllegalArgumentException("Redirect to empty url in web view.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.AzureActiveDirectoryWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */