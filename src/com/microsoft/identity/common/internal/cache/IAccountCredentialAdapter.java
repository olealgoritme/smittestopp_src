package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;

public abstract interface IAccountCredentialAdapter<T extends OAuth2Strategy, U extends AuthorizationRequest, V extends TokenResponse, W extends BaseAccount, X extends RefreshToken>
{
  public abstract AccountRecord asAccount(W paramW);
  
  public abstract IdTokenRecord asIdToken(W paramW, X paramX);
  
  public abstract RefreshTokenRecord asRefreshToken(X paramX);
  
  public abstract AccessTokenRecord createAccessToken(T paramT, U paramU, V paramV);
  
  public abstract AccountRecord createAccount(T paramT, U paramU, V paramV);
  
  public abstract IdTokenRecord createIdToken(T paramT, U paramU, V paramV);
  
  public abstract RefreshTokenRecord createRefreshToken(T paramT, U paramU, V paramV);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.IAccountCredentialAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */