package com.microsoft.identity.common.internal.providers.oauth2;

import android.net.Uri;
import android.text.TextUtils;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.HttpRequest;
import com.microsoft.identity.common.internal.net.HttpResponse;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import com.microsoft.identity.common.internal.platform.Device;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenRequest;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Future;

public abstract class OAuth2Strategy<GenericAccessToken extends AccessToken, GenericAccount extends BaseAccount, GenericAuthorizationRequest extends AuthorizationRequest, GenericAuthorizationRequestBuilder extends AuthorizationRequest.Builder, GenericAuthorizationStrategy extends AuthorizationStrategy, GenericOAuth2Configuration extends OAuth2Configuration, GenericOAuth2StrategyParameters extends OAuth2StrategyParameters, GenericAuthorizationResponse extends AuthorizationResponse, GenericRefreshToken extends RefreshToken, GenericTokenRequest extends TokenRequest, GenericTokenResponse extends TokenResponse, GenericTokenResult extends TokenResult, GenericAuthorizationResult extends AuthorizationResult>
{
  public static final String TAG = "OAuth2Strategy";
  public static final String TOKEN_REQUEST_CONTENT_TYPE = "application/x-www-form-urlencoded";
  public String mAuthorizationEndpoint;
  public final GenericOAuth2Configuration mConfig;
  public Uri mIssuer;
  public final GenericOAuth2StrategyParameters mStrategyParameters;
  public String mTokenEndpoint;
  
  public OAuth2Strategy(GenericOAuth2Configuration paramGenericOAuth2Configuration, GenericOAuth2StrategyParameters paramGenericOAuth2StrategyParameters)
  {
    mConfig = paramGenericOAuth2Configuration;
    mStrategyParameters = paramGenericOAuth2StrategyParameters;
  }
  
  public abstract GenericAccount createAccount(GenericTokenResponse paramGenericTokenResponse);
  
  public abstract GenericAuthorizationRequestBuilder createAuthorizationRequestBuilder();
  
  public abstract GenericAuthorizationRequestBuilder createAuthorizationRequestBuilder(IAccountRecord paramIAccountRecord);
  
  public abstract GenericTokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme paramAbstractAuthenticationScheme);
  
  public abstract GenericTokenRequest createTokenRequest(GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericAuthorizationResponse paramGenericAuthorizationResponse, AbstractAuthenticationScheme paramAbstractAuthenticationScheme);
  
  public abstract GenericAccessToken getAccessTokenFromResponse(GenericTokenResponse paramGenericTokenResponse);
  
  public String getAuthorityFromTokenEndpoint()
  {
    return mTokenEndpoint.toLowerCase().replace("oauth2/v2.0/token", "");
  }
  
  public abstract AuthorizationResultFactory getAuthorizationResultFactory();
  
  public Uri getIssuer()
  {
    return mIssuer;
  }
  
  public abstract String getIssuerCacheIdentifier(GenericAuthorizationRequest paramGenericAuthorizationRequest);
  
  public GenericOAuth2Configuration getOAuth2Configuration()
  {
    return mConfig;
  }
  
  public abstract GenericRefreshToken getRefreshTokenFromResponse(GenericTokenResponse paramGenericTokenResponse);
  
  public abstract GenericTokenResult getTokenResultFromHttpResponse(HttpResponse paramHttpResponse);
  
  public HttpResponse performTokenRequest(GenericTokenRequest paramGenericTokenRequest)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":performTokenRequest");
    Logger.verbose(((StringBuilder)localObject).toString(), "Performing token request...");
    localObject = ObjectMapper.serializeObjectToFormUrlEncoded(paramGenericTokenRequest);
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("client-request-id", DiagnosticContext.getRequestContext().get("correlation_id"));
    if ((paramGenericTokenRequest instanceof MicrosoftTokenRequest))
    {
      paramGenericTokenRequest = (MicrosoftTokenRequest)paramGenericTokenRequest;
      if (!TextUtils.isEmpty(paramGenericTokenRequest.getBrokerVersion())) {
        localTreeMap.put("x-client-brkrver", paramGenericTokenRequest.getBrokerVersion());
      }
    }
    localTreeMap.putAll(Device.getPlatformIdParameters());
    localTreeMap.putAll(EstsTelemetry.getInstance().getTelemetryHeaders());
    return HttpRequest.sendPost(new URL(mTokenEndpoint), localTreeMap, ((String)localObject).getBytes("UTF-8"), "application/x-www-form-urlencoded");
  }
  
  public Future<AuthorizationResult> requestAuthorization(GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericAuthorizationStrategy paramGenericAuthorizationStrategy)
  {
    validateAuthorizationRequest(paramGenericAuthorizationRequest);
    try
    {
      paramGenericAuthorizationRequest = paramGenericAuthorizationStrategy.requestAuthorization(paramGenericAuthorizationRequest, this);
    }
    catch (UnsupportedEncodingException|ClientException paramGenericAuthorizationRequest)
    {
      paramGenericAuthorizationRequest = null;
    }
    return paramGenericAuthorizationRequest;
  }
  
  public GenericTokenResult requestToken(GenericTokenRequest paramGenericTokenRequest)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":requestToken");
    Logger.verbose(((StringBuilder)localObject).toString(), "Requesting token...");
    validateTokenRequest(paramGenericTokenRequest);
    localObject = getTokenResultFromHttpResponse(performTokenRequest(paramGenericTokenRequest));
    if (((TokenResult)localObject).getSuccess()) {
      validateTokenResponse(paramGenericTokenRequest, ((TokenResult)localObject).getSuccessResponse());
    }
    return (GenericTokenResult)localObject;
  }
  
  public final void setAuthorizationEndpoint(String paramString)
  {
    mAuthorizationEndpoint = paramString;
  }
  
  public final void setIssuer(Uri paramUri)
  {
    mIssuer = paramUri;
  }
  
  public final void setTokenEndpoint(String paramString)
  {
    mTokenEndpoint = paramString;
  }
  
  public abstract void validateAuthorizationRequest(GenericAuthorizationRequest paramGenericAuthorizationRequest);
  
  public boolean validateCachedResult(AbstractAuthenticationScheme paramAbstractAuthenticationScheme, ICacheRecord paramICacheRecord)
  {
    return true;
  }
  
  public abstract void validateTokenRequest(GenericTokenRequest paramGenericTokenRequest);
  
  public abstract void validateTokenResponse(GenericTokenRequest paramGenericTokenRequest, GenericTokenResponse paramGenericTokenResponse);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */