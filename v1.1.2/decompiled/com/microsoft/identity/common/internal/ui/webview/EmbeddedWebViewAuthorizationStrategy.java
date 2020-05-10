package com.microsoft.identity.common.internal.ui.webview;

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
import e.a.a.a.a;
import java.util.concurrent.Future;

public class EmbeddedWebViewAuthorizationStrategy<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest>
  extends AuthorizationStrategy<GenericOAuth2Strategy, GenericAuthorizationRequest>
{
  public static final String TAG = "EmbeddedWebViewAuthorizationStrategy";
  public GenericAuthorizationRequest mAuthorizationRequest;
  public ResultFuture<AuthorizationResult> mAuthorizationResultFuture;
  public GenericOAuth2Strategy mOAuth2Strategy;
  
  public EmbeddedWebViewAuthorizationStrategy(Context paramContext, Activity paramActivity, Fragment paramFragment)
  {
    super(paramContext, paramActivity, paramFragment);
  }
  
  public void completeAuthorization(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 1001)
    {
      localObject = mOAuth2Strategy;
      if ((localObject != null) && (mAuthorizationResultFuture != null))
      {
        paramIntent = ((OAuth2Strategy)localObject).getAuthorizationResultFactory().createAuthorizationResult(paramInt2, paramIntent, mAuthorizationRequest);
        mAuthorizationResultFuture.setResult(paramIntent);
      }
      else
      {
        localObject = TAG;
        StringBuilder localStringBuilder = a.a("SDK Cancel triggering before request is sent out. Potentially due to an stale activity state, oAuth2Strategy null ? [");
        paramIntent = mOAuth2Strategy;
        boolean bool1 = true;
        boolean bool2;
        if (paramIntent == null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localStringBuilder.append(bool2);
        localStringBuilder.append("]mAuthorizationResultFuture ? [");
        if (mAuthorizationResultFuture == null) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
        localStringBuilder.append(bool2);
        localStringBuilder.append("]");
        Logger.warn((String)localObject, localStringBuilder.toString());
      }
    }
    else
    {
      localObject = TAG;
      paramIntent = new StringBuilder();
      paramIntent.append("Unknown request code ");
      paramIntent.append(paramInt1);
      Logger.warnPII((String)localObject, paramIntent.toString());
    }
  }
  
  public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericOAuth2Strategy paramGenericOAuth2Strategy)
  {
    mAuthorizationResultFuture = new ResultFuture();
    mOAuth2Strategy = paramGenericOAuth2Strategy;
    mAuthorizationRequest = paramGenericAuthorizationRequest;
    Logger.info(TAG, "Perform the authorization request with embedded webView.");
    paramGenericAuthorizationRequest = paramGenericAuthorizationRequest.getAuthorizationRequestAsHttpRequest();
    launchIntent(AuthorizationActivity.createStartIntent(getApplicationContext(), null, paramGenericAuthorizationRequest.toString(), mAuthorizationRequest.getRedirectUri(), mAuthorizationRequest.getRequestHeaders(), AuthorizationAgent.WEBVIEW, mAuthorizationRequest.isWebViewZoomEnabled(), mAuthorizationRequest.isWebViewZoomControlsEnabled()));
    return mAuthorizationResultFuture;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.EmbeddedWebViewAuthorizationStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */