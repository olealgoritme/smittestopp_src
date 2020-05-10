package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Pair;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.HttpRequest;
import com.microsoft.identity.common.internal.net.HttpResponse;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import com.microsoft.identity.common.internal.platform.Device;
import com.microsoft.identity.common.internal.platform.IDevicePopManager;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResponse;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenErrorResponse;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.providers.oauth2.IResult;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfiguration;
import com.microsoft.identity.common.internal.providers.oauth2.PkceChallenge;
import com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import com.microsoft.identity.common.internal.telemetry.CliTelemInfo;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeFactory;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler;
import com.microsoft.identity.common.internal.util.HeaderSerializationUtil;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class MicrosoftStsOAuth2Strategy
  extends OAuth2Strategy<MicrosoftStsAccessToken, MicrosoftStsAccount, MicrosoftStsAuthorizationRequest, MicrosoftStsAuthorizationRequest.Builder, AuthorizationStrategy, MicrosoftStsOAuth2Configuration, OAuth2StrategyParameters, MicrosoftStsAuthorizationResponse, MicrosoftStsRefreshToken, MicrosoftStsTokenRequest, MicrosoftStsTokenResponse, TokenResult, AuthorizationResult>
{
  public static final String TAG = "MicrosoftStsOAuth2Strategy";
  
  public MicrosoftStsOAuth2Strategy(MicrosoftStsOAuth2Configuration paramMicrosoftStsOAuth2Configuration, OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    super(paramMicrosoftStsOAuth2Configuration, paramOAuth2StrategyParameters);
    setTokenEndpoint(paramMicrosoftStsOAuth2Configuration.getTokenEndpoint().toString());
  }
  
  public static boolean authSchemeIsPoP(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    return "PoP".equals(paramAbstractAuthenticationScheme.getName());
  }
  
  private String buildCloudSpecificTokenEndpoint(MicrosoftStsAuthorizationResponse paramMicrosoftStsAuthorizationResponse)
  {
    if (!StringUtil.isEmpty(paramMicrosoftStsAuthorizationResponse.getCloudInstanceHostName())) {
      return Uri.parse(mTokenEndpoint).buildUpon().authority(paramMicrosoftStsAuthorizationResponse.getCloudInstanceHostName()).build().toString();
    }
    return mTokenEndpoint;
  }
  
  private boolean cachedAccessTokenKidMatchesKeystoreKid(String paramString)
  {
    String str = getDeviceAtPopThumbprint();
    if (StringExtensions.isNullOrBlank(str)) {
      return false;
    }
    return str.equals(paramString);
  }
  
  private String getCloudSpecificTokenEndpoint(MicrosoftAuthorizationRequest paramMicrosoftAuthorizationRequest, MicrosoftAuthorizationResponse paramMicrosoftAuthorizationResponse)
  {
    if (StringUtil.isEmpty(paramMicrosoftAuthorizationResponse.getCloudInstanceHostName())) {
      return mTokenEndpoint;
    }
    paramMicrosoftAuthorizationRequest = ((MicrosoftStsOAuth2Configuration)mConfig).getOpenIdWellKnownConfig(paramMicrosoftAuthorizationResponse.getCloudInstanceHostName(), paramMicrosoftAuthorizationRequest.getAuthority().getPath());
    if ((paramMicrosoftAuthorizationRequest != null) && (paramMicrosoftAuthorizationRequest.getTokenEndpoint() != null))
    {
      paramMicrosoftAuthorizationRequest = paramMicrosoftAuthorizationRequest.getTokenEndpoint();
    }
    else
    {
      a.b(new StringBuilder(), TAG, ":getCloudSpecificTokenEndpoint", "Token Endpoint not obtained from well known config. Building token endpoint manually.");
      paramMicrosoftAuthorizationRequest = buildCloudSpecificTokenEndpoint((MicrosoftStsAuthorizationResponse)paramMicrosoftAuthorizationResponse);
    }
    return paramMicrosoftAuthorizationRequest;
  }
  
  private String getIssuerCacheIdentifierFromAuthority(URL paramURL)
  {
    Object localObject = AzureActiveDirectory.getAzureActiveDirectoryCloud(paramURL);
    if (localObject != null)
    {
      paramURL = ((AzureActiveDirectoryCloud)localObject).getPreferredCacheHostName();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":getIssuerCacheIdentifierFromAuthority");
      Logger.info(((StringBuilder)localObject).toString(), "Using preferred cache host name...");
      String str = a.a(new StringBuilder(), TAG, ":getIssuerCacheIdentifierFromAuthority");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Preferred cache hostname: [");
      ((StringBuilder)localObject).append(paramURL);
      ((StringBuilder)localObject).append("]");
      Logger.infoPII(str, ((StringBuilder)localObject).toString());
      return paramURL;
    }
    return paramURL.getHost();
  }
  
  private HttpResponse performPKeyAuthRequest(HttpResponse paramHttpResponse, MicrosoftStsTokenRequest paramMicrosoftStsTokenRequest)
  {
    paramMicrosoftStsTokenRequest = ObjectMapper.serializeObjectToFormUrlEncoded(paramMicrosoftStsTokenRequest);
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("client-request-id", DiagnosticContext.getRequestContext().get("correlation_id"));
    localTreeMap.putAll(Device.getPlatformIdParameters());
    paramHttpResponse = (String)((List)paramHttpResponse.getHeaders().get("WWW-Authenticate")).get(0);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append("#performPkeyAuthRequest");
    Logger.info(((StringBuilder)localObject1).toString(), "Device certificate challenge request. ");
    localObject1 = a.a(new StringBuilder(), TAG, "#performPkeyAuthRequest");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Challenge header: ");
    ((StringBuilder)localObject2).append(paramHttpResponse);
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject2 = new com/microsoft/identity/common/internal/ui/webview/challengehandlers/PKeyAuthChallengeFactory;
      ((PKeyAuthChallengeFactory)localObject2).<init>();
      localObject1 = StringExtensions.getUrl(mTokenEndpoint);
      localTreeMap.putAll(PKeyAuthChallengeHandler.getChallengeHeader(((PKeyAuthChallengeFactory)localObject2).getPKeyAuthChallenge(paramHttpResponse, ((URL)localObject1).toString())));
      localTreeMap.putAll(EstsTelemetry.getInstance().getTelemetryHeaders());
      paramHttpResponse = HttpRequest.sendPost((URL)localObject1, localTreeMap, paramMicrosoftStsTokenRequest.getBytes("UTF-8"), "application/x-www-form-urlencoded");
      return paramHttpResponse;
    }
    catch (UnsupportedEncodingException paramHttpResponse)
    {
      throw new ClientException("unsupported_encoding", "Unsupported encoding", paramHttpResponse);
    }
  }
  
  private void setTokenRequestCorrelationId(MicrosoftStsTokenRequest paramMicrosoftStsTokenRequest)
  {
    try
    {
      paramMicrosoftStsTokenRequest.setCorrelationId(UUID.fromString((String)DiagnosticContext.getRequestContext().get("correlation_id")));
    }
    catch (IllegalArgumentException paramMicrosoftStsTokenRequest)
    {
      Logger.error("MicrosoftSTSOAuth2Strategy", "Correlation id on diagnostic context is not a UUID.", paramMicrosoftStsTokenRequest);
    }
  }
  
  private void validateAuthScheme(MicrosoftStsTokenRequest paramMicrosoftStsTokenRequest, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    paramMicrosoftStsTokenRequest = paramMicrosoftStsTokenRequest.getTokenType();
    paramMicrosoftStsTokenResponse = paramMicrosoftStsTokenResponse.getTokenType();
    if ((paramMicrosoftStsTokenRequest != null) && (!paramMicrosoftStsTokenRequest.equalsIgnoreCase(paramMicrosoftStsTokenResponse)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected: [");
      localStringBuilder.append(paramMicrosoftStsTokenRequest);
      localStringBuilder.append("]\nActual: [");
      localStringBuilder.append(paramMicrosoftStsTokenResponse);
      localStringBuilder.append("]");
      throw new ClientException("auth_scheme_mismatch", localStringBuilder.toString());
    }
  }
  
  public MicrosoftStsAccount createAccount(MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    a.b(new StringBuilder(), TAG, ":createAccount", "Creating account from TokenResponse...");
    try
    {
      localObject = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
      ((IDToken)localObject).<init>(paramMicrosoftStsTokenResponse.getIdToken());
      paramMicrosoftStsTokenResponse = new ClientInfo(paramMicrosoftStsTokenResponse.getClientInfo());
      paramMicrosoftStsTokenResponse = new MicrosoftStsAccount((IDToken)localObject, paramMicrosoftStsTokenResponse);
      paramMicrosoftStsTokenResponse.setEnvironment(getIssuerCacheIdentifierFromTokenEndpoint());
      return paramMicrosoftStsTokenResponse;
    }
    catch (ServiceException paramMicrosoftStsTokenResponse)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":createAccount");
      Logger.error(((StringBuilder)localObject).toString(), "Failed to construct IDToken or ClientInfo", null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":createAccount");
      Logger.errorPII(((StringBuilder)localObject).toString(), "Failed with Exception", paramMicrosoftStsTokenResponse);
      throw new RuntimeException();
    }
  }
  
  public MicrosoftStsAuthorizationRequest.Builder createAuthorizationRequestBuilder()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":createAuthorizationRequestBuilder");
    Logger.info(((StringBuilder)localObject1).toString(), "Creating AuthorizationRequestBuilder...");
    localObject1 = new MicrosoftStsAuthorizationRequest.Builder();
    ((MicrosoftAuthorizationRequest.Builder)localObject1).setAuthority(((MicrosoftStsOAuth2Configuration)mConfig).getAuthorityUrl());
    if (((MicrosoftStsOAuth2Configuration)mConfig).getSlice() != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":createAuthorizationRequestBuilder");
      Logger.info(((StringBuilder)localObject2).toString(), "Setting slice params...");
      ((MicrosoftAuthorizationRequest.Builder)localObject1).setSlice(((MicrosoftStsOAuth2Configuration)mConfig).getSlice());
    }
    Object localObject2 = Device.getPlatformIdParameters();
    ((MicrosoftAuthorizationRequest.Builder)localObject1).setLibraryName((String)((Map)localObject2).get("x-client-SKU"));
    ((MicrosoftAuthorizationRequest.Builder)localObject1).setLibraryVersion((String)((Map)localObject2).get("x-client-Ver"));
    ((MicrosoftAuthorizationRequest.Builder)localObject1).setFlightParameters(((MicrosoftStsOAuth2Configuration)mConfig).getFlightParameters());
    ((MicrosoftAuthorizationRequest.Builder)localObject1).setMultipleCloudAware(((MicrosoftStsOAuth2Configuration)mConfig).getMultipleCloudsSupported());
    return (MicrosoftStsAuthorizationRequest.Builder)localObject1;
  }
  
  public MicrosoftStsAuthorizationRequest.Builder createAuthorizationRequestBuilder(IAccountRecord paramIAccountRecord)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":createAuthorizationRequestBuilder");
    Logger.info(((StringBuilder)localObject1).toString(), "Creating AuthorizationRequestBuilder");
    localObject1 = createAuthorizationRequestBuilder();
    if (paramIAccountRecord != null)
    {
      paramIAccountRecord = StringUtil.getTenantInfo(paramIAccountRecord.getHomeAccountId());
      if ((!StringExtensions.isNullOrBlank((String)first)) && (!StringExtensions.isNullOrBlank((String)second)))
      {
        ((MicrosoftStsAuthorizationRequest.Builder)localObject1).setUid((String)first);
        ((MicrosoftStsAuthorizationRequest.Builder)localObject1).setUtid((String)second);
        Object localObject2 = a.a(new StringBuilder(), TAG, ":createAuthorizationRequestBuilder");
        Object localObject3 = a.a("Builder w/ uid: [");
        ((StringBuilder)localObject3).append((String)first);
        ((StringBuilder)localObject3).append("]");
        Logger.infoPII((String)localObject2, ((StringBuilder)localObject3).toString());
        localObject3 = a.a(new StringBuilder(), TAG, ":createAuthorizationRequestBuilder");
        localObject2 = a.a("Builder w/ utid: [");
        ((StringBuilder)localObject2).append((String)second);
        ((StringBuilder)localObject2).append("]");
        Logger.infoPII((String)localObject3, ((StringBuilder)localObject2).toString());
      }
    }
    return (MicrosoftStsAuthorizationRequest.Builder)localObject1;
  }
  
  public MicrosoftStsTokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":createRefreshTokenRequest");
    Logger.verbose(((StringBuilder)localObject).toString(), "Creating refresh token request");
    localObject = new MicrosoftStsTokenRequest();
    ((TokenRequest)localObject).setGrantType("refresh_token");
    if ("PoP".equals(paramAbstractAuthenticationScheme.getName()))
    {
      ((TokenRequest)localObject).setTokenType("pop");
      paramAbstractAuthenticationScheme = Device.getDevicePoPManagerInstance();
      if (!paramAbstractAuthenticationScheme.asymmetricKeyExists()) {
        paramAbstractAuthenticationScheme.generateAsymmetricKey(mStrategyParameters.getContext());
      }
      ((TokenRequest)localObject).setRequestConfirmation(paramAbstractAuthenticationScheme.getRequestConfirmation());
    }
    return (MicrosoftStsTokenRequest)localObject;
  }
  
  public MicrosoftStsTokenRequest createTokenRequest(MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest, MicrosoftStsAuthorizationResponse paramMicrosoftStsAuthorizationResponse, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    a.b(new StringBuilder(), TAG, ":createTokenRequest", "Creating TokenRequest...");
    if ((((MicrosoftStsOAuth2Configuration)mConfig).getMultipleCloudsSupported()) || (paramMicrosoftStsAuthorizationRequest.getMultipleCloudAware().booleanValue()))
    {
      Logger.verbose(TAG, "get cloud specific authority based on authorization response.");
      setTokenEndpoint(getCloudSpecificTokenEndpoint(paramMicrosoftStsAuthorizationRequest, paramMicrosoftStsAuthorizationResponse));
    }
    MicrosoftStsTokenRequest localMicrosoftStsTokenRequest = new MicrosoftStsTokenRequest();
    localMicrosoftStsTokenRequest.setCodeVerifier(paramMicrosoftStsAuthorizationRequest.getPkceChallenge().getCodeVerifier());
    localMicrosoftStsTokenRequest.setCode(paramMicrosoftStsAuthorizationResponse.getCode());
    localMicrosoftStsTokenRequest.setRedirectUri(paramMicrosoftStsAuthorizationRequest.getRedirectUri());
    localMicrosoftStsTokenRequest.setClientId(paramMicrosoftStsAuthorizationRequest.getClientId());
    localMicrosoftStsTokenRequest.setScope(paramMicrosoftStsAuthorizationRequest.getTokenScope());
    localMicrosoftStsTokenRequest.setClaims(paramMicrosoftStsAuthorizationRequest.getClaims());
    localMicrosoftStsTokenRequest.setGrantType("authorization_code");
    setTokenRequestCorrelationId(localMicrosoftStsTokenRequest);
    if ("PoP".equals(paramAbstractAuthenticationScheme.getName())) {
      if (mStrategyParameters.getContext() != null)
      {
        localMicrosoftStsTokenRequest.setTokenType("pop");
        paramMicrosoftStsAuthorizationResponse = Device.getDevicePoPManagerInstance();
        if (!paramMicrosoftStsAuthorizationResponse.asymmetricKeyExists())
        {
          paramMicrosoftStsAuthorizationRequest = paramMicrosoftStsAuthorizationResponse.generateAsymmetricKey(mStrategyParameters.getContext());
          String str = TAG;
          paramAbstractAuthenticationScheme = new StringBuilder();
          paramAbstractAuthenticationScheme.append("Generated new PoP asymmetric key with thumbprint: ");
          paramAbstractAuthenticationScheme.append(paramMicrosoftStsAuthorizationRequest);
          Logger.verbosePII(str, paramAbstractAuthenticationScheme.toString());
        }
        localMicrosoftStsTokenRequest.setRequestConfirmation(paramMicrosoftStsAuthorizationResponse.getRequestConfirmation());
      }
      else
      {
        paramMicrosoftStsAuthorizationRequest = new StringBuilder();
        paramMicrosoftStsAuthorizationRequest.append(MicrosoftStsOAuth2Strategy.class.getSimpleName());
        paramMicrosoftStsAuthorizationRequest.append("Cannot execute PoP request sans Context");
        throw new ClientException(paramMicrosoftStsAuthorizationRequest.toString());
      }
    }
    return localMicrosoftStsTokenRequest;
  }
  
  public MicrosoftStsAccessToken getAccessTokenFromResponse(MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":getAccessTokenFromResponse");
    Logger.verbose(localStringBuilder.toString(), "Getting AT from TokenResponse...");
    return new MicrosoftStsAccessToken(paramMicrosoftStsTokenResponse);
  }
  
  public AuthorizationResultFactory getAuthorizationResultFactory()
  {
    return new MicrosoftStsAuthorizationResultFactory();
  }
  
  public String getDeviceAtPopThumbprint()
  {
    Object localObject1 = null;
    String str;
    try
    {
      IDevicePopManager localIDevicePopManager = Device.getDevicePoPManagerInstance();
    }
    catch (ClientException localClientException1)
    {
      Logger.error(TAG, localClientException1.getMessage(), localClientException1);
      str = null;
    }
    Object localObject2;
    if (str != null)
    {
      if (str.asymmetricKeyExists()) {
        try
        {
          str = str.getAsymmetricKeyThumbprint();
        }
        catch (ClientException localClientException2)
        {
          Logger.error(TAG, "Key exists. But failed to load thumbprint.", localClientException2);
          throw new RuntimeException(localClientException2);
        }
      } else {
        throw new RuntimeException("Symmetric keys do not exist.");
      }
    }
    else
    {
      Logger.warn(TAG, "DevicePopManager does not exist.");
      localObject2 = localObject1;
    }
    return (String)localObject2;
  }
  
  public String getIssuerCacheIdentifier(MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest)
  {
    Object localObject = paramMicrosoftStsAuthorizationRequest.getAuthority();
    paramMicrosoftStsAuthorizationRequest = AzureActiveDirectory.getAzureActiveDirectoryCloud((URL)localObject);
    if (paramMicrosoftStsAuthorizationRequest != null)
    {
      paramMicrosoftStsAuthorizationRequest = paramMicrosoftStsAuthorizationRequest.getPreferredCacheHostName();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":getIssuerCacheIdentifier");
      Logger.info(((StringBuilder)localObject).toString(), "Using preferred cache host name...");
      localObject = a.a(new StringBuilder(), TAG, ":getIssuerCacheIdentifier");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Preferred cache hostname: [");
      localStringBuilder.append(paramMicrosoftStsAuthorizationRequest);
      localStringBuilder.append("]");
      Logger.infoPII((String)localObject, localStringBuilder.toString());
      return paramMicrosoftStsAuthorizationRequest;
    }
    return ((URL)localObject).getHost();
  }
  
  public String getIssuerCacheIdentifierFromTokenEndpoint()
  {
    String str = null;
    Object localObject;
    try
    {
      localObject = new java/net/URL;
      ((URL)localObject).<init>(mTokenEndpoint);
    }
    catch (MalformedURLException localMalformedURLException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(":getIssuerCacheIdentifierFromTokenEndpoint");
      Logger.error(((StringBuilder)localObject).toString(), "Getting issuer cache identifier from token endpoint failed due to malformed URL (mTokenEndpoint)...", localMalformedURLException);
      localObject = null;
    }
    if (localObject != null) {
      str = getIssuerCacheIdentifierFromAuthority((URL)localObject);
    }
    return str;
  }
  
  public MicrosoftStsRefreshToken getRefreshTokenFromResponse(MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":getRefreshTokenFromResponse");
    Logger.verbose(localStringBuilder.toString(), "Getting RT from TokenResponse...");
    return new MicrosoftStsRefreshToken(paramMicrosoftStsTokenResponse);
  }
  
  public TokenResult getTokenResultFromHttpResponse(HttpResponse paramHttpResponse)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":getTokenResultFromHttpResponse");
    Logger.verbose(((StringBuilder)localObject1).toString(), "Getting TokenResult from HttpResponse...");
    int i = paramHttpResponse.getStatusCode();
    localObject1 = null;
    if (i >= 400)
    {
      localObject2 = (TokenErrorResponse)ObjectMapper.deserializeJsonStringToObject(paramHttpResponse.getBody(), MicrosoftTokenErrorResponse.class);
      ((TokenErrorResponse)localObject2).setStatusCode(paramHttpResponse.getStatusCode());
      if (paramHttpResponse.getHeaders() != null) {
        ((TokenErrorResponse)localObject2).setResponseHeadersJson(HeaderSerializationUtil.toJson(paramHttpResponse.getHeaders()));
      }
      ((TokenErrorResponse)localObject2).setResponseBody(paramHttpResponse.getBody());
    }
    else
    {
      localObject1 = (MicrosoftStsTokenResponse)ObjectMapper.deserializeJsonStringToObject(paramHttpResponse.getBody(), MicrosoftStsTokenResponse.class);
      localObject2 = null;
    }
    Object localObject2 = new TokenResult((TokenResponse)localObject1, (TokenErrorResponse)localObject2);
    BaseController.logResult(TAG, (IResult)localObject2);
    if (paramHttpResponse.getHeaders() != null)
    {
      paramHttpResponse = (List)paramHttpResponse.getHeaders().get("x-ms-clitelem");
      if ((paramHttpResponse != null) && (!paramHttpResponse.isEmpty()))
      {
        paramHttpResponse = CliTelemInfo.fromXMsCliTelemHeader((String)paramHttpResponse.get(0));
        ((TokenResult)localObject2).setCliTelemInfo(paramHttpResponse);
        if ((localObject1 != null) && (paramHttpResponse != null))
        {
          ((MicrosoftTokenResponse)localObject1).setSpeRing(paramHttpResponse.getSpeRing());
          ((MicrosoftTokenResponse)localObject1).setRefreshTokenAge(paramHttpResponse.getRefreshTokenAge());
          ((MicrosoftTokenResponse)localObject1).setCliTelemErrorCode(paramHttpResponse.getServerErrorCode());
          ((MicrosoftTokenResponse)localObject1).setCliTelemSubErrorCode(paramHttpResponse.getServerSubErrorCode());
        }
      }
    }
    return (TokenResult)localObject2;
  }
  
  public HttpResponse performTokenRequest(MicrosoftStsTokenRequest paramMicrosoftStsTokenRequest)
  {
    HttpResponse localHttpResponse = super.performTokenRequest(paramMicrosoftStsTokenRequest);
    if ((localHttpResponse.getStatusCode() == 401) && (localHttpResponse.getHeaders() != null) && (localHttpResponse.getHeaders().containsKey("WWW-Authenticate")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":performTokenRequest");
      Logger.info(localStringBuilder.toString(), "Receiving device certificate challenge request. ");
      return performPKeyAuthRequest(localHttpResponse, paramMicrosoftStsTokenRequest);
    }
    return localHttpResponse;
  }
  
  public void validateAuthorizationRequest(MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest) {}
  
  public boolean validateCachedResult(AbstractAuthenticationScheme paramAbstractAuthenticationScheme, ICacheRecord paramICacheRecord)
  {
    super.validateCachedResult(paramAbstractAuthenticationScheme, paramICacheRecord);
    if (authSchemeIsPoP(paramAbstractAuthenticationScheme)) {
      return cachedAccessTokenKidMatchesKeystoreKid(paramICacheRecord.getAccessToken().getKid());
    }
    return true;
  }
  
  public void validateTokenRequest(MicrosoftStsTokenRequest paramMicrosoftStsTokenRequest) {}
  
  public void validateTokenResponse(MicrosoftStsTokenRequest paramMicrosoftStsTokenRequest, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    validateAuthScheme(paramMicrosoftStsTokenRequest, paramMicrosoftStsTokenResponse);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */