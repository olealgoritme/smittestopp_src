package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import android.net.Uri;
import android.net.Uri.Builder;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.HttpResponse;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenErrorResponse;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import e.a.a.a.a;
import java.net.URL;

public class AzureActiveDirectoryOAuth2Strategy
  extends OAuth2Strategy<AzureActiveDirectoryAccessToken, AzureActiveDirectoryAccount, AzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryAuthorizationRequest.Builder, AuthorizationStrategy, AzureActiveDirectoryOAuth2Configuration, OAuth2StrategyParameters, AzureActiveDirectoryAuthorizationResponse, AzureActiveDirectoryRefreshToken, AzureActiveDirectoryTokenRequest, AzureActiveDirectoryTokenResponse, TokenResult, AuthorizationResult>
{
  public static final String TAG = "AzureActiveDirectoryOAuth2Strategy";
  
  public AzureActiveDirectoryOAuth2Strategy(AzureActiveDirectoryOAuth2Configuration paramAzureActiveDirectoryOAuth2Configuration, OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    super(paramAzureActiveDirectoryOAuth2Configuration, paramOAuth2StrategyParameters);
    String str = TAG;
    paramOAuth2StrategyParameters = a.a("Init: ");
    paramOAuth2StrategyParameters.append(TAG);
    Logger.verbose(str, paramOAuth2StrategyParameters.toString());
    if (paramAzureActiveDirectoryOAuth2Configuration.getAuthorityUrl() != null)
    {
      paramOAuth2StrategyParameters = new StringBuilder();
      paramOAuth2StrategyParameters.append(paramAzureActiveDirectoryOAuth2Configuration.getAuthorityUrl().toString());
      paramOAuth2StrategyParameters.append("/oauth2/token");
      setTokenEndpoint(paramOAuth2StrategyParameters.toString());
    }
    else
    {
      setTokenEndpoint("https://login.microsoftonline.com/microsoft.com/oauth2/token");
    }
  }
  
  public AzureActiveDirectoryAccount createAccount(AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    try
    {
      Logger.info(TAG, "Constructing IDToken from response");
      IDToken localIDToken = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
      localIDToken.<init>(paramAzureActiveDirectoryTokenResponse.getIdToken());
      Logger.info(TAG, "Constructing ClientInfo from response");
      paramAzureActiveDirectoryTokenResponse = new ClientInfo(paramAzureActiveDirectoryTokenResponse.getClientInfo());
      paramAzureActiveDirectoryTokenResponse = new AzureActiveDirectoryAccount(localIDToken, paramAzureActiveDirectoryTokenResponse);
      Logger.info(TAG, "Account created");
      Logger.infoPII(TAG, paramAzureActiveDirectoryTokenResponse.toString());
      return paramAzureActiveDirectoryTokenResponse;
    }
    catch (ServiceException paramAzureActiveDirectoryTokenResponse)
    {
      Logger.error(a.a(new StringBuilder(), TAG, ":", "createAccount"), "Failed to construct IDToken or ClientInfo", null);
      Logger.errorPII(a.a(new StringBuilder(), TAG, ":", "createAccount"), "Failed with Exception", paramAzureActiveDirectoryTokenResponse);
      throw new RuntimeException();
    }
  }
  
  public AzureActiveDirectoryAuthorizationRequest.Builder createAuthorizationRequestBuilder()
  {
    return new AzureActiveDirectoryAuthorizationRequest.Builder();
  }
  
  public AzureActiveDirectoryAuthorizationRequest.Builder createAuthorizationRequestBuilder(IAccountRecord paramIAccountRecord)
  {
    return createAuthorizationRequestBuilder();
  }
  
  public AzureActiveDirectoryTokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    return null;
  }
  
  public AzureActiveDirectoryTokenRequest createTokenRequest(AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryAuthorizationResponse paramAzureActiveDirectoryAuthorizationResponse, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    return null;
  }
  
  public AzureActiveDirectoryAccessToken getAccessTokenFromResponse(AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    return new AzureActiveDirectoryAccessToken(paramAzureActiveDirectoryTokenResponse);
  }
  
  public AuthorizationResultFactory getAuthorizationResultFactory()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getIssuerCacheIdentifier(AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest)
  {
    Object localObject1 = AzureActiveDirectory.getAzureActiveDirectoryCloud(paramAzureActiveDirectoryAuthorizationRequest.getAuthority());
    if ((localObject1 == null) && (!((AzureActiveDirectoryOAuth2Configuration)getOAuth2Configuration()).isAuthorityHostValidationEnabled()))
    {
      localObject2 = a.a(new StringBuilder(), TAG, ":", "getIssuerCacheIdentifier");
      localObject1 = a.a("Discovery data does not include cloud authority and validation is off. Returning passed in Authority: ");
      ((StringBuilder)localObject1).append(paramAzureActiveDirectoryAuthorizationRequest.getAuthority().toString());
      Logger.warn((String)localObject2, ((StringBuilder)localObject1).toString());
      return paramAzureActiveDirectoryAuthorizationRequest.getAuthority().toString();
    }
    if ((!((AzureActiveDirectoryCloud)localObject1).isValidated()) && (((AzureActiveDirectoryOAuth2Configuration)getOAuth2Configuration()).isAuthorityHostValidationEnabled()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append("getIssuerCacheIdentifier");
      Logger.warn(((StringBuilder)localObject2).toString(), "Authority host validation has been enabled. This data hasn't been validated, though.");
    }
    if ((!((AzureActiveDirectoryCloud)localObject1).isValidated()) && (!((AzureActiveDirectoryOAuth2Configuration)getOAuth2Configuration()).isAuthorityHostValidationEnabled()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append("getIssuerCacheIdentifier");
      Logger.warn(((StringBuilder)localObject2).toString(), "Authority host validation not specified...but there is no cloud...Hence just return the passed in Authority");
      return paramAzureActiveDirectoryAuthorizationRequest.getAuthority().toString();
    }
    Logger.info(TAG, "Building authority URI");
    localObject1 = Uri.parse(paramAzureActiveDirectoryAuthorizationRequest.getAuthority().toString()).buildUpon().authority(((AzureActiveDirectoryCloud)localObject1).getPreferredCacheHostName()).build().toString();
    paramAzureActiveDirectoryAuthorizationRequest = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Issuer cache identifier created: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    Logger.infoPII(paramAzureActiveDirectoryAuthorizationRequest, ((StringBuilder)localObject2).toString());
    return (String)localObject1;
  }
  
  public AzureActiveDirectoryRefreshToken getRefreshTokenFromResponse(AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    return new AzureActiveDirectoryRefreshToken(paramAzureActiveDirectoryTokenResponse);
  }
  
  public TokenResult getTokenResultFromHttpResponse(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.getStatusCode();
    Object localObject1 = null;
    if (i >= 400)
    {
      Object localObject2 = a.a(new StringBuilder(), TAG, ":", "getTokenResultFromHttpResponse");
      StringBuilder localStringBuilder = a.a("Status code was: ");
      localStringBuilder.append(paramHttpResponse.getStatusCode());
      Logger.warn((String)localObject2, localStringBuilder.toString());
      localObject2 = (TokenErrorResponse)ObjectMapper.deserializeJsonStringToObject(paramHttpResponse.getBody(), MicrosoftTokenErrorResponse.class);
      paramHttpResponse = (HttpResponse)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      paramHttpResponse = (TokenResponse)ObjectMapper.deserializeJsonStringToObject(paramHttpResponse.getBody(), AzureActiveDirectoryTokenResponse.class);
      localObject1 = null;
    }
    return new TokenResult(paramHttpResponse, (TokenErrorResponse)localObject1);
  }
  
  public void validateAuthorizationRequest(AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest) {}
  
  public void validateTokenRequest(AzureActiveDirectoryTokenRequest paramAzureActiveDirectoryTokenRequest) {}
  
  public void validateTokenResponse(AzureActiveDirectoryTokenRequest paramAzureActiveDirectoryTokenRequest, AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse) {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Strategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */