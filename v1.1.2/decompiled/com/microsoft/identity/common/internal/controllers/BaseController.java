package com.microsoft.identity.common.internal.controllers;

import android.content.Intent;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.net.HttpWebRequest;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.Authority.KnownAuthorityResult;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.authscheme.ITokenAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.IErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.IResult;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.internal.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.BrokerAcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.request.SdkType;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.LocalAuthenticationResult;
import com.microsoft.identity.common.internal.telemetry.CliTelemInfo;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.CacheEndEvent;
import e.a.a.a.a;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public abstract class BaseController
{
  public static final Set<String> DEFAULT_SCOPES;
  public static final String TAG = "BaseController";
  
  static
  {
    HashSet localHashSet = new HashSet();
    DEFAULT_SCOPES = localHashSet;
    localHashSet.add("openid");
    DEFAULT_SCOPES.add("offline_access");
    DEFAULT_SCOPES.add("profile");
  }
  
  public static void logExposedFieldsOfObject(String paramString, Object paramObject)
  {
    paramString = a.a(paramString, ":");
    paramString.append(paramObject.getClass().getSimpleName());
    Logger.info(paramString.toString(), ObjectMapper.serializeExposedFieldsOfObjectToJsonString(paramObject));
  }
  
  public static void logResult(String paramString, IResult paramIResult)
  {
    paramString = a.a(paramString, ":");
    paramString.append(paramIResult.getClass().getSimpleName());
    paramString = paramString.toString();
    StringBuilder localStringBuilder;
    if (paramIResult.getSuccess())
    {
      Logger.info(paramString, "Success Result");
      logExposedFieldsOfObject(paramString, paramIResult.getSuccessResponse());
    }
    else
    {
      Logger.warn(paramString, "Failure Result");
      if (paramIResult.getErrorResponse() != null)
      {
        if (paramIResult.getErrorResponse().getError() != null)
        {
          localStringBuilder = a.a("Error: ");
          localStringBuilder.append(paramIResult.getErrorResponse().getError());
          Logger.warn(paramString, localStringBuilder.toString());
        }
        if (paramIResult.getErrorResponse().getErrorDescription() != null)
        {
          localStringBuilder = a.a("Description: ");
          localStringBuilder.append(paramIResult.getErrorResponse().getErrorDescription());
          Logger.warnPII(paramString, localStringBuilder.toString());
        }
        logExposedFieldsOfObject(paramString, paramIResult.getErrorResponse());
      }
    }
    if ((paramIResult instanceof AuthorizationResult))
    {
      paramIResult = (AuthorizationResult)paramIResult;
      if (paramIResult.getAuthorizationStatus() != null)
      {
        localStringBuilder = a.a("Authorization Status: ");
        localStringBuilder.append(paramIResult.getAuthorizationStatus().toString());
        Logger.info(paramString, localStringBuilder.toString());
      }
    }
  }
  
  public boolean accessTokenIsNull(ICacheRecord paramICacheRecord)
  {
    boolean bool;
    if (paramICacheRecord.getAccessToken() == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract AcquireTokenResult acquireToken(AcquireTokenOperationParameters paramAcquireTokenOperationParameters);
  
  public abstract AcquireTokenResult acquireTokenSilent(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters);
  
  public void addDefaultScopes(OperationParameters paramOperationParameters)
  {
    Set localSet = paramOperationParameters.getScopes();
    localSet.addAll(DEFAULT_SCOPES);
    localSet.removeAll(Arrays.asList(new String[] { "", null }));
    paramOperationParameters.setScopes(localSet);
  }
  
  public abstract void completeAcquireToken(int paramInt1, int paramInt2, Intent paramIntent);
  
  public ICacheRecord finalizeCacheRecordForResult(ICacheRecord paramICacheRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    if ((paramAbstractAuthenticationScheme instanceof ITokenAuthenticationSchemeInternal))
    {
      paramAbstractAuthenticationScheme = (ITokenAuthenticationSchemeInternal)paramAbstractAuthenticationScheme;
      paramICacheRecord.getAccessToken().setSecret(paramAbstractAuthenticationScheme.getAccessTokenForScheme(paramICacheRecord.getAccessToken().getSecret()));
    }
    return paramICacheRecord;
  }
  
  public abstract List<ICacheRecord> getAccounts(OperationParameters paramOperationParameters);
  
  public AuthorizationRequest getAuthorizationRequest(OAuth2Strategy paramOAuth2Strategy, OperationParameters paramOperationParameters)
  {
    paramOAuth2Strategy = paramOAuth2Strategy.createAuthorizationRequestBuilder(paramOperationParameters.getAccount());
    initializeAuthorizationRequestBuilder(paramOAuth2Strategy, paramOperationParameters);
    return paramOAuth2Strategy.build();
  }
  
  public AccountRecord getCachedAccountRecord(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    if (paramAcquireTokenSilentOperationParameters.getAccount() != null)
    {
      boolean bool = "B2C".equalsIgnoreCase(paramAcquireTokenSilentOperationParameters.getAuthority().getAuthorityTypeString());
      String str1 = paramAcquireTokenSilentOperationParameters.getClientId();
      String str2 = paramAcquireTokenSilentOperationParameters.getAccount().getHomeAccountId();
      Object localObject = paramAcquireTokenSilentOperationParameters.getAccount().getLocalAccountId();
      if (bool) {
        paramAcquireTokenSilentOperationParameters = paramAcquireTokenSilentOperationParameters.getTokenCache().getAccountByHomeAccountId(null, str1, str2);
      } else {
        paramAcquireTokenSilentOperationParameters = paramAcquireTokenSilentOperationParameters.getTokenCache().getAccountByLocalAccountId(null, str1, (String)localObject);
      }
      if (paramAcquireTokenSilentOperationParameters != null) {
        return paramAcquireTokenSilentOperationParameters;
      }
      paramAcquireTokenSilentOperationParameters = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No accounts found for clientId [");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(", ]");
      Logger.info(paramAcquireTokenSilentOperationParameters, ((StringBuilder)localObject).toString(), null);
      paramAcquireTokenSilentOperationParameters = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No accounts found for clientId, homeAccountId: [");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append("]");
      Logger.errorPII(paramAcquireTokenSilentOperationParameters, ((StringBuilder)localObject).toString(), null);
      throw new ClientException("no_account_found", "No cached accounts found for the supplied homeAccountId");
    }
    throw new ClientException("no_account_found", "No cached accounts found for the supplied homeAccountId and clientId");
  }
  
  public abstract List<ICacheRecord> getCurrentAccount(OperationParameters paramOperationParameters);
  
  public abstract boolean getDeviceMode(OperationParameters paramOperationParameters);
  
  public boolean idTokenIsNull(ICacheRecord paramICacheRecord, SdkType paramSdkType)
  {
    if (paramSdkType == SdkType.ADAL) {
      paramICacheRecord = paramICacheRecord.getV1IdToken();
    } else {
      paramICacheRecord = paramICacheRecord.getIdToken();
    }
    boolean bool;
    if (paramICacheRecord == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final AuthorizationRequest.Builder initializeAuthorizationRequestBuilder(AuthorizationRequest.Builder paramBuilder, OperationParameters paramOperationParameters)
  {
    Object localObject;
    try
    {
      UUID localUUID = UUID.fromString((String)DiagnosticContext.getRequestContext().get("correlation_id"));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Logger.error(TAG, "correlation id from diagnostic context is not a UUID", localIllegalArgumentException);
      localObject = null;
    }
    paramBuilder.setClientId(paramOperationParameters.getClientId()).setRedirectUri(paramOperationParameters.getRedirectUri()).setCorrelationId((UUID)localObject);
    if ((paramOperationParameters instanceof AcquireTokenOperationParameters))
    {
      AcquireTokenOperationParameters localAcquireTokenOperationParameters = (AcquireTokenOperationParameters)paramOperationParameters;
      if ((localAcquireTokenOperationParameters.getAuthority() instanceof AzureActiveDirectoryAuthority))
      {
        localObject = (AzureActiveDirectoryAuthority)localAcquireTokenOperationParameters.getAuthority();
        ((MicrosoftAuthorizationRequest.Builder)paramBuilder).setAuthority(((AzureActiveDirectoryAuthority)localObject).getAuthorityURL()).setMultipleCloudAware(mMultipleCloudsSupported).setSlice(mSlice);
      }
      if ((paramBuilder instanceof MicrosoftStsAuthorizationRequest.Builder)) {
        ((MicrosoftStsAuthorizationRequest.Builder)paramBuilder).setTokenScope(TextUtils.join(" ", paramOperationParameters.getScopes()));
      }
      if (localAcquireTokenOperationParameters.getExtraScopesToConsent() != null) {
        paramOperationParameters.getScopes().addAll(localAcquireTokenOperationParameters.getExtraScopesToConsent());
      }
      paramBuilder.setLoginHint(localAcquireTokenOperationParameters.getLoginHint()).setExtraQueryParams(localAcquireTokenOperationParameters.getExtraQueryStringParameters()).setPrompt(localAcquireTokenOperationParameters.getOpenIdConnectPromptParameter().toString()).setClaims(paramOperationParameters.getClaimsRequestJson()).setRequestHeaders(localAcquireTokenOperationParameters.getRequestHeaders()).setWebViewZoomEnabled(localAcquireTokenOperationParameters.isWebViewZoomEnabled()).setWebViewZoomControlsEnabled(localAcquireTokenOperationParameters.isWebViewZoomControlsEnabled());
      if ((!StringExtensions.isNullOrBlank(localAcquireTokenOperationParameters.getLoginHint())) && (localAcquireTokenOperationParameters.getOpenIdConnectPromptParameter() == OpenIdConnectPromptParameter.SELECT_ACCOUNT)) {
        paramBuilder.setPrompt(null);
      }
    }
    paramBuilder.setScope(TextUtils.join(" ", paramOperationParameters.getScopes()));
    return paramBuilder;
  }
  
  public boolean isMsaAccount(MicrosoftTokenResponse paramMicrosoftTokenResponse)
  {
    return "9188040d-6c67-4c5b-b112-36a304b66dad".equalsIgnoreCase(SchemaUtil.getTenantId(paramMicrosoftTokenResponse.getClientInfo(), paramMicrosoftTokenResponse.getIdToken()));
  }
  
  public boolean isRequestAuthorityRealmSameAsATRealm(Authority paramAuthority, AccessTokenRecord paramAccessTokenRecord)
  {
    if ((paramAuthority instanceof AzureActiveDirectoryAuthority))
    {
      AzureActiveDirectoryAuthority localAzureActiveDirectoryAuthority = (AzureActiveDirectoryAuthority)paramAuthority;
      if (AzureActiveDirectoryAudience.isHomeTenantAlias(localAzureActiveDirectoryAuthority.getAudience().getTenantId())) {
        return paramAccessTokenRecord.getHomeAccountId().split(java.util.regex.Pattern.quote("."))[1].equalsIgnoreCase(paramAccessTokenRecord.getRealm());
      }
      return localAzureActiveDirectoryAuthority.getAudience().getTenantUuidForAlias(paramAuthority.getAuthorityURL().toString()).equalsIgnoreCase(paramAccessTokenRecord.getRealm());
    }
    return true;
  }
  
  public void logParameters(String paramString, Object paramObject)
  {
    paramString = a.a(paramString, ":");
    paramString.append(paramObject.getClass().getSimpleName());
    paramString = paramString.toString();
    if (Logger.getAllowPii()) {
      Logger.infoPII(paramString, ObjectMapper.serializeObjectToJsonString(paramObject));
    } else {
      Logger.info(paramString, ObjectMapper.serializeExposedFieldsOfObjectToJsonString(paramObject));
    }
  }
  
  public TokenResult performSilentTokenRequest(OAuth2Strategy paramOAuth2Strategy, AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":performSilentTokenRequest");
    Logger.info(((StringBuilder)localObject).toString(), "Requesting tokens...");
    HttpWebRequest.throwIfNetworkNotAvailable(paramAcquireTokenSilentOperationParameters.getAppContext());
    localObject = Authority.getKnownAuthorityResult(paramAcquireTokenSilentOperationParameters.getAuthority());
    if (((Authority.KnownAuthorityResult)localObject).getKnown())
    {
      localObject = paramOAuth2Strategy.createRefreshTokenRequest(paramAcquireTokenSilentOperationParameters.getAuthenticationScheme());
      ((TokenRequest)localObject).setClientId(paramAcquireTokenSilentOperationParameters.getClientId());
      ((TokenRequest)localObject).setScope(TextUtils.join(" ", paramAcquireTokenSilentOperationParameters.getScopes()));
      ((TokenRequest)localObject).setRefreshToken(paramAcquireTokenSilentOperationParameters.getRefreshToken().getSecret());
      if ((localObject instanceof MicrosoftTokenRequest)) {
        ((MicrosoftTokenRequest)localObject).setClaims(paramAcquireTokenSilentOperationParameters.getClaimsRequestJson());
      }
      if (paramAcquireTokenSilentOperationParameters.getSdkType() == SdkType.ADAL) {
        ((MicrosoftTokenRequest)localObject).setIdTokenVersion("1");
      }
      if ((paramAcquireTokenSilentOperationParameters instanceof BrokerAcquireTokenSilentOperationParameters)) {
        ((MicrosoftTokenRequest)localObject).setBrokerVersion(((BrokerAcquireTokenSilentOperationParameters)paramAcquireTokenSilentOperationParameters).getBrokerVersion());
      }
      if (!StringExtensions.isNullOrBlank(((TokenRequest)localObject).getScope()))
      {
        paramAcquireTokenSilentOperationParameters = a.a(new StringBuilder(), TAG, ":performSilentTokenRequest");
        StringBuilder localStringBuilder = a.a("Scopes: [");
        localStringBuilder.append(((TokenRequest)localObject).getScope());
        localStringBuilder.append("]");
        Logger.infoPII(paramAcquireTokenSilentOperationParameters, localStringBuilder.toString());
      }
      return paramOAuth2Strategy.requestToken((TokenRequest)localObject);
    }
    throw ((Authority.KnownAuthorityResult)localObject).getClientException();
  }
  
  public TokenResult performTokenRequest(OAuth2Strategy paramOAuth2Strategy, AuthorizationRequest paramAuthorizationRequest, AuthorizationResponse paramAuthorizationResponse, AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    HttpWebRequest.throwIfNetworkNotAvailable(paramAcquireTokenOperationParameters.getAppContext());
    paramAuthorizationRequest = paramOAuth2Strategy.createTokenRequest(paramAuthorizationRequest, paramAuthorizationResponse, paramAcquireTokenOperationParameters.getAuthenticationScheme());
    paramAuthorizationResponse = new StringBuilder();
    paramAuthorizationResponse.append(TAG);
    paramAuthorizationResponse.append(":performTokenRequest");
    logExposedFieldsOfObject(paramAuthorizationResponse.toString(), paramAuthorizationRequest);
    paramOAuth2Strategy = paramOAuth2Strategy.requestToken(paramAuthorizationRequest);
    logResult(TAG, paramOAuth2Strategy);
    return paramOAuth2Strategy;
  }
  
  public boolean refreshTokenIsNull(ICacheRecord paramICacheRecord)
  {
    boolean bool;
    if (paramICacheRecord.getRefreshToken() == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean removeAccount(OperationParameters paramOperationParameters);
  
  public abstract boolean removeCurrentAccount(OperationParameters paramOperationParameters);
  
  public void renewAccessToken(AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters, AcquireTokenResult paramAcquireTokenResult, OAuth2TokenCache paramOAuth2TokenCache, OAuth2Strategy paramOAuth2Strategy, ICacheRecord paramICacheRecord)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":renewAccessToken");
    Logger.info(localStringBuilder.toString(), "Renewing access token...");
    paramAcquireTokenSilentOperationParameters.setRefreshToken(paramICacheRecord.getRefreshToken());
    logParameters(TAG, paramAcquireTokenSilentOperationParameters);
    paramICacheRecord = performSilentTokenRequest(paramOAuth2Strategy, paramAcquireTokenSilentOperationParameters);
    paramAcquireTokenResult.setTokenResult(paramICacheRecord);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":renewAccessToken");
    logResult(localStringBuilder.toString(), paramICacheRecord);
    if (paramICacheRecord.getSuccess())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":renewAccessToken");
      Logger.info(localStringBuilder.toString(), "Token request was successful");
      paramOAuth2TokenCache = paramOAuth2TokenCache.saveAndLoadAggregatedAccountData(paramOAuth2Strategy, getAuthorizationRequest(paramOAuth2Strategy, paramAcquireTokenSilentOperationParameters), paramICacheRecord.getTokenResponse());
      paramOAuth2TokenCache = new LocalAuthenticationResult(finalizeCacheRecordForResult((ICacheRecord)paramOAuth2TokenCache.get(0), paramAcquireTokenSilentOperationParameters.getAuthenticationScheme()), paramOAuth2TokenCache, SdkType.MSAL);
      if (paramICacheRecord.getCliTelemInfo() != null)
      {
        paramAcquireTokenSilentOperationParameters = paramICacheRecord.getCliTelemInfo();
        paramOAuth2TokenCache.setSpeRing(paramAcquireTokenSilentOperationParameters.getSpeRing());
        paramOAuth2TokenCache.setRefreshTokenAge(paramAcquireTokenSilentOperationParameters.getRefreshTokenAge());
        Telemetry.emit(new CacheEndEvent().putSpeInfo(paramICacheRecord.getCliTelemInfo().getSpeRing()));
      }
      else
      {
        Telemetry.emit(new CacheEndEvent());
      }
      paramAcquireTokenResult.setLocalAuthenticationResult(paramOAuth2TokenCache);
    }
  }
  
  public List<ICacheRecord> saveTokens(OAuth2Strategy paramOAuth2Strategy, AuthorizationRequest paramAuthorizationRequest, TokenResponse paramTokenResponse, OAuth2TokenCache paramOAuth2TokenCache)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":saveTokens");
    Logger.info(localStringBuilder.toString(), "Saving tokens...");
    return paramOAuth2TokenCache.saveAndLoadAggregatedAccountData(paramOAuth2Strategy, paramAuthorizationRequest, paramTokenResponse);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.BaseController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */