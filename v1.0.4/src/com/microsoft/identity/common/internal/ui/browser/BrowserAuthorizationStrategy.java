package com.microsoft.identity.common.internal.ui.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivity;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.result.ResultFuture;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import d.d.a.c;
import java.util.List;
import java.util.concurrent.Future;

public class BrowserAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest>
  extends AuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest>
{
  public static final String TAG = "BrowserAuthorizationStrategy";
  public GenericAuthorizationRequest mAuthorizationRequest;
  public ResultFuture<AuthorizationResult> mAuthorizationResultFuture;
  public List<BrowserDescriptor> mBrowserSafeList;
  public CustomTabsManager mCustomTabManager;
  public boolean mDisposed;
  public boolean mIsRequestFromBroker;
  public GenericOAuth2Strategy mOAuth2Strategy;
  
  public BrowserAuthorizationStrategy(Context paramContext, Activity paramActivity, Fragment paramFragment, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramFragment);
    mIsRequestFromBroker = paramBoolean;
  }
  
  private void checkNotDisposed()
  {
    if (!mDisposed) {
      return;
    }
    throw new IllegalStateException("Service has been disposed and rendered inoperable");
  }
  
  public void completeAuthorization(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      dispose();
      paramIntent = mOAuth2Strategy.getAuthorizationResultFactory().createAuthorizationResult(paramInt2, paramIntent, mAuthorizationRequest);
      mAuthorizationResultFuture.setResult(paramIntent);
    }
    else
    {
      String str = TAG;
      paramIntent = new StringBuilder();
      paramIntent.append("Unknown request code ");
      paramIntent.append(paramInt1);
      Logger.warnPII(str, paramIntent.toString());
    }
  }
  
  public void dispose()
  {
    if (mDisposed) {
      return;
    }
    CustomTabsManager localCustomTabsManager = mCustomTabManager;
    if (localCustomTabsManager != null) {
      localCustomTabsManager.unbind();
    }
    mDisposed = true;
  }
  
  public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericOAuth2Strategy paramGenericOAuth2Strategy)
  {
    checkNotDisposed();
    mOAuth2Strategy = paramGenericOAuth2Strategy;
    mAuthorizationRequest = paramGenericAuthorizationRequest;
    mAuthorizationResultFuture = new ResultFuture();
    Browser localBrowser = BrowserSelector.select(getApplicationContext(), mBrowserSafeList);
    if (localBrowser.isCustomTabsServiceSupported())
    {
      paramGenericOAuth2Strategy = new StringBuilder();
      paramGenericOAuth2Strategy.append(TAG);
      paramGenericOAuth2Strategy.append(":requestAuthorization");
      Logger.info(paramGenericOAuth2Strategy.toString(), "CustomTabsService is supported.");
      paramGenericOAuth2Strategy = new CustomTabsManager(getApplicationContext());
      mCustomTabManager = paramGenericOAuth2Strategy;
      paramGenericOAuth2Strategy.bind(localBrowser.getPackageName());
      paramGenericOAuth2Strategy = mCustomTabManager.getCustomTabsIntent().a;
    }
    else
    {
      paramGenericOAuth2Strategy = new StringBuilder();
      paramGenericOAuth2Strategy.append(TAG);
      paramGenericOAuth2Strategy.append(":requestAuthorization");
      Logger.warn(paramGenericOAuth2Strategy.toString(), "CustomTabsService is NOT supported");
      paramGenericOAuth2Strategy = new Intent("android.intent.action.VIEW");
    }
    paramGenericOAuth2Strategy.setPackage(localBrowser.getPackageName());
    paramGenericAuthorizationRequest = paramGenericAuthorizationRequest.getAuthorizationRequestAsHttpRequest();
    paramGenericOAuth2Strategy.setData(paramGenericAuthorizationRequest);
    paramGenericAuthorizationRequest = AuthorizationActivity.createStartIntent(getApplicationContext(), paramGenericOAuth2Strategy, paramGenericAuthorizationRequest.toString(), mAuthorizationRequest.getRedirectUri(), mAuthorizationRequest.getRequestHeaders(), AuthorizationAgent.BROWSER, true, true);
    if (mIsRequestFromBroker) {
      paramGenericAuthorizationRequest.setFlags(268468224);
    } else {
      paramGenericAuthorizationRequest.setFlags(268435456);
    }
    launchIntent(paramGenericAuthorizationRequest);
    return mAuthorizationResultFuture;
  }
  
  public void setBrowserSafeList(List<BrowserDescriptor> paramList)
  {
    mBrowserSafeList = paramList;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.browser.BrowserAuthorizationStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */