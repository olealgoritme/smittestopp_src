package com.microsoft.identity.client.internal.controllers;

import android.content.Intent;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.net.HttpWebRequest;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.Authority.KnownAuthorityResult;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.cache.AccountDeletionRecord;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStatus;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.IResult;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.request.SdkType;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.LocalAuthenticationResult;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.internal.ui.AuthorizationStrategyFactory;
import e.a.a.a.a;
import java.util.List;
import java.util.concurrent.Future;

public class LocalMSALController
  extends BaseController
{
  public static final String TAG = "LocalMSALController";
  public AuthorizationRequest mAuthorizationRequest = null;
  public AuthorizationStrategy mAuthorizationStrategy = null;
  
  private AuthorizationResult performAuthorizationRequest(OAuth2Strategy paramOAuth2Strategy, AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    HttpWebRequest.throwIfNetworkNotAvailable(paramAcquireTokenOperationParameters.getAppContext());
    mAuthorizationStrategy = AuthorizationStrategyFactory.getInstance().getAuthorizationStrategy(paramAcquireTokenOperationParameters);
    paramAcquireTokenOperationParameters = getAuthorizationRequest(paramOAuth2Strategy, paramAcquireTokenOperationParameters);
    mAuthorizationRequest = paramAcquireTokenOperationParameters;
    return (AuthorizationResult)paramOAuth2Strategy.requestAuthorization(paramAcquireTokenOperationParameters, mAuthorizationStrategy).get();
  }
  
  public AcquireTokenResult acquireToken(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":acquireToken");
    Logger.verbose(((StringBuilder)localObject1).toString(), "Acquiring token...");
    Telemetry.emit(new ApiStartEvent().putProperties(paramAcquireTokenOperationParameters).putApiId("101"));
    localObject1 = new AcquireTokenResult();
    paramAcquireTokenOperationParameters.validate();
    addDefaultScopes(paramAcquireTokenOperationParameters);
    logParameters(TAG, paramAcquireTokenOperationParameters);
    HttpWebRequest.throwIfNetworkNotAvailable(paramAcquireTokenOperationParameters.getAppContext());
    Object localObject2 = Authority.getKnownAuthorityResult(paramAcquireTokenOperationParameters.getAuthority());
    if (((Authority.KnownAuthorityResult)localObject2).getKnown())
    {
      localObject2 = new OAuth2StrategyParameters();
      ((OAuth2StrategyParameters)localObject2).setContext(paramAcquireTokenOperationParameters.getAppContext());
      localObject2 = paramAcquireTokenOperationParameters.getAuthority().createOAuth2Strategy((OAuth2StrategyParameters)localObject2);
      Object localObject3 = performAuthorizationRequest((OAuth2Strategy)localObject2, paramAcquireTokenOperationParameters);
      ((AcquireTokenResult)localObject1).setAuthorizationResult((AuthorizationResult)localObject3);
      BaseController.logResult(TAG, (IResult)localObject3);
      if (((AuthorizationResult)localObject3).getAuthorizationStatus().equals(AuthorizationStatus.SUCCESS))
      {
        localObject3 = performTokenRequest((OAuth2Strategy)localObject2, mAuthorizationRequest, ((AuthorizationResult)localObject3).getAuthorizationResponse(), paramAcquireTokenOperationParameters);
        ((AcquireTokenResult)localObject1).setTokenResult((TokenResult)localObject3);
        if ((localObject3 != null) && (((TokenResult)localObject3).getSuccess()))
        {
          localObject2 = saveTokens((OAuth2Strategy)localObject2, mAuthorizationRequest, ((TokenResult)localObject3).getTokenResponse(), paramAcquireTokenOperationParameters.getTokenCache());
          ((AcquireTokenResult)localObject1).setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult((ICacheRecord)((List)localObject2).get(0), paramAcquireTokenOperationParameters.getAuthenticationScheme()), (List)localObject2, SdkType.MSAL));
        }
      }
      Telemetry.emit(new ApiEndEvent().putResult((AcquireTokenResult)localObject1).putApiId("101"));
      return (AcquireTokenResult)localObject1;
    }
    Telemetry.emit(new ApiEndEvent().putException(((Authority.KnownAuthorityResult)localObject2).getClientException()).putApiId("101"));
    throw ((Authority.KnownAuthorityResult)localObject2).getClientException();
  }
  
  public AcquireTokenResult acquireTokenSilent(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":acquireTokenSilent");
    Logger.verbose(((StringBuilder)localObject1).toString(), "Acquiring token silently...");
    Telemetry.emit(new ApiStartEvent().putProperties(paramAcquireTokenSilentOperationParameters).putApiId("103"));
    localObject1 = new AcquireTokenResult();
    paramAcquireTokenSilentOperationParameters.validate();
    addDefaultScopes(paramAcquireTokenSilentOperationParameters);
    Object localObject2 = paramAcquireTokenSilentOperationParameters.getTokenCache();
    Object localObject3 = getCachedAccountRecord(paramAcquireTokenSilentOperationParameters);
    Object localObject4 = paramAcquireTokenSilentOperationParameters.getAuthenticationScheme();
    Object localObject5 = new OAuth2StrategyParameters();
    ((OAuth2StrategyParameters)localObject5).setContext(paramAcquireTokenSilentOperationParameters.getAppContext());
    localObject5 = paramAcquireTokenSilentOperationParameters.getAuthority().createOAuth2Strategy((OAuth2StrategyParameters)localObject5);
    List localList = ((OAuth2TokenCache)localObject2).loadWithAggregatedAccountData(paramAcquireTokenSilentOperationParameters.getClientId(), TextUtils.join(" ", paramAcquireTokenSilentOperationParameters.getScopes()), (AccountRecord)localObject3, (AbstractAuthenticationScheme)localObject4);
    localObject3 = (ICacheRecord)localList.get(0);
    if ((!accessTokenIsNull((ICacheRecord)localObject3)) && (!refreshTokenIsNull((ICacheRecord)localObject3)) && (!paramAcquireTokenSilentOperationParameters.getForceRefresh()) && (isRequestAuthorityRealmSameAsATRealm(paramAcquireTokenSilentOperationParameters.getAuthority(), ((ICacheRecord)localObject3).getAccessToken())) && (((OAuth2Strategy)localObject5).validateCachedResult((AbstractAuthenticationScheme)localObject4, (ICacheRecord)localObject3)))
    {
      if (((ICacheRecord)localObject3).getAccessToken().isExpired())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(TAG);
        ((StringBuilder)localObject4).append(":acquireTokenSilent");
        Logger.warn(((StringBuilder)localObject4).toString(), "Access token is expired. Removing from cache...");
        ((OAuth2TokenCache)localObject2).removeCredential(((ICacheRecord)localObject3).getAccessToken());
        a.b(new StringBuilder(), TAG, ":acquireTokenSilent", "Renewing access token...");
        renewAccessToken(paramAcquireTokenSilentOperationParameters, (AcquireTokenResult)localObject1, (OAuth2TokenCache)localObject2, (OAuth2Strategy)localObject5, (ICacheRecord)localObject3);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(TAG);
        ((StringBuilder)localObject2).append(":acquireTokenSilent");
        Logger.verbose(((StringBuilder)localObject2).toString(), "Returning silent result");
        ((AcquireTokenResult)localObject1).setLocalAuthenticationResult(new LocalAuthenticationResult(finalizeCacheRecordForResult((ICacheRecord)localObject3, paramAcquireTokenSilentOperationParameters.getAuthenticationScheme()), localList, SdkType.MSAL));
      }
    }
    else
    {
      if (refreshTokenIsNull((ICacheRecord)localObject3)) {
        break label428;
      }
      a.b(new StringBuilder(), TAG, ":acquireTokenSilent", "No access token found, but RT is available.");
      renewAccessToken(paramAcquireTokenSilentOperationParameters, (AcquireTokenResult)localObject1, (OAuth2TokenCache)localObject2, (OAuth2Strategy)localObject5, (ICacheRecord)localObject3);
    }
    Telemetry.emit(new ApiEndEvent().putResult((AcquireTokenResult)localObject1).putApiId("103"));
    return (AcquireTokenResult)localObject1;
    label428:
    paramAcquireTokenSilentOperationParameters = new ClientException("no_tokens_found", "No refresh token was found. ");
    Telemetry.emit(new ApiEndEvent().putException(paramAcquireTokenSilentOperationParameters).putApiId("103"));
    throw paramAcquireTokenSilentOperationParameters;
  }
  
  public void completeAcquireToken(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":completeAcquireToken");
    Logger.verbose(localStringBuilder.toString(), "Completing acquire token...");
    Telemetry.emit(new ApiStartEvent().putApiId("1032").put("Microsoft.MSAL.result_code", String.valueOf(paramInt2)).put("Microsoft.MSAL.request_code", String.valueOf(paramInt1)));
    mAuthorizationStrategy.completeAuthorization(paramInt1, paramInt2, paramIntent);
    Telemetry.emit(new ApiEndEvent().putApiId("1032"));
  }
  
  public List<ICacheRecord> getAccounts(OperationParameters paramOperationParameters)
  {
    Telemetry.emit(new ApiStartEvent().putProperties(paramOperationParameters).putApiId("106"));
    paramOperationParameters = paramOperationParameters.getTokenCache().getAccountsWithAggregatedAccountData(null, paramOperationParameters.getClientId());
    Telemetry.emit(new ApiEndEvent().putApiId("106").put("Microsoft.MSAL.accounts_number", Integer.toString(paramOperationParameters.size())).put("_is_successful", "true"));
    return paramOperationParameters;
  }
  
  public List<ICacheRecord> getCurrentAccount(OperationParameters paramOperationParameters)
  {
    return getAccounts(paramOperationParameters);
  }
  
  public boolean getDeviceMode(OperationParameters paramOperationParameters)
  {
    a.c(new StringBuilder(), TAG, ":getDeviceMode", "LocalMSALController is not eligible to use the broker. Do not check sharedDevice mode and return false immediately.");
    return false;
  }
  
  public boolean removeAccount(OperationParameters paramOperationParameters)
  {
    Telemetry.emit(new ApiStartEvent().putProperties(paramOperationParameters).putApiId("107"));
    Object localObject1 = paramOperationParameters.getAccount();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = paramOperationParameters.getAccount().getRealm();
    } else {
      localObject1 = null;
    }
    OAuth2TokenCache localOAuth2TokenCache = paramOperationParameters.getTokenCache();
    String str1;
    if (paramOperationParameters.getAccount() == null) {
      str1 = null;
    } else {
      str1 = paramOperationParameters.getAccount().getEnvironment();
    }
    String str2 = paramOperationParameters.getClientId();
    if (paramOperationParameters.getAccount() == null) {
      paramOperationParameters = (OperationParameters)localObject2;
    } else {
      paramOperationParameters = paramOperationParameters.getAccount().getHomeAccountId();
    }
    boolean bool = localOAuth2TokenCache.removeAccount(str1, str2, paramOperationParameters, (String)localObject1).isEmpty() ^ true;
    Telemetry.emit(new ApiEndEvent().put("_is_successful", String.valueOf(bool)).putApiId("107"));
    return bool;
  }
  
  public boolean removeCurrentAccount(OperationParameters paramOperationParameters)
  {
    return removeAccount(paramOperationParameters);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.LocalMSALController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */