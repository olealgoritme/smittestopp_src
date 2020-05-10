package com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices;

import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.net.HttpResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AccessToken;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResultFactory;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Configuration;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import java.util.concurrent.Future;

public class ActiveDirectoryFederationServices2012R2OAuth2Strategy
  extends OAuth2Strategy
{
  public ActiveDirectoryFederationServices2012R2OAuth2Strategy(OAuth2Configuration paramOAuth2Configuration, OAuth2StrategyParameters paramOAuth2StrategyParameters)
  {
    super(paramOAuth2Configuration, paramOAuth2StrategyParameters);
  }
  
  public BaseAccount createAccount(TokenResponse paramTokenResponse)
  {
    return null;
  }
  
  public AuthorizationRequest.Builder createAuthorizationRequestBuilder()
  {
    return null;
  }
  
  public AuthorizationRequest.Builder createAuthorizationRequestBuilder(IAccountRecord paramIAccountRecord)
  {
    return createAuthorizationRequestBuilder();
  }
  
  public TokenRequest createRefreshTokenRequest(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    return null;
  }
  
  public TokenRequest createTokenRequest(AuthorizationRequest paramAuthorizationRequest, AuthorizationResponse paramAuthorizationResponse, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    return null;
  }
  
  public AccessToken getAccessTokenFromResponse(TokenResponse paramTokenResponse)
  {
    return null;
  }
  
  public AuthorizationResultFactory getAuthorizationResultFactory()
  {
    throw new UnsupportedOperationException();
  }
  
  public String getIssuerCacheIdentifier(AuthorizationRequest paramAuthorizationRequest)
  {
    return null;
  }
  
  public RefreshToken getRefreshTokenFromResponse(TokenResponse paramTokenResponse)
  {
    return null;
  }
  
  public TokenResult getTokenResultFromHttpResponse(HttpResponse paramHttpResponse)
  {
    return null;
  }
  
  public Future<AuthorizationResult> requestAuthorization(AuthorizationRequest paramAuthorizationRequest, AuthorizationStrategy paramAuthorizationStrategy)
  {
    return super.requestAuthorization(paramAuthorizationRequest, paramAuthorizationStrategy);
  }
  
  public void validateAuthorizationRequest(AuthorizationRequest paramAuthorizationRequest) {}
  
  public void validateTokenRequest(TokenRequest paramTokenRequest) {}
  
  public void validateTokenResponse(TokenRequest paramTokenRequest, TokenResponse paramTokenResponse) {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.activedirectoryfederationservices.ActiveDirectoryFederationServices2012R2OAuth2Strategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */