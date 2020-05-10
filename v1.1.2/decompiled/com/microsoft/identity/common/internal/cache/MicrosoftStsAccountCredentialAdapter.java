package com.microsoft.identity.common.internal.cache;

import android.text.TextUtils;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import e.a.a.a.a;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class MicrosoftStsAccountCredentialAdapter
  implements IAccountCredentialAdapter<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken>
{
  public static final String TAG = "MicrosoftStsAccountCredentialAdapter";
  
  private long getCachedAt()
  {
    long l = System.currentTimeMillis();
    return TimeUnit.MILLISECONDS.toSeconds(l);
  }
  
  private String getCredentialType(String paramString)
  {
    CredentialType localCredentialType = CredentialType.AccessToken;
    if ("PoP".equalsIgnoreCase(paramString))
    {
      paramString = CredentialType.AccessToken_With_AuthScheme;
      return "AccessToken_With_AuthScheme";
    }
    return "AccessToken";
  }
  
  private long getExpiresOn(MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    long l = System.currentTimeMillis();
    l = TimeUnit.MILLISECONDS.toSeconds(l);
    return paramMicrosoftStsTokenResponse.getExpiresIn().longValue() + l;
  }
  
  private String getExtendedExpiresOn(MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    long l1 = System.currentTimeMillis();
    long l2 = TimeUnit.MILLISECONDS.toSeconds(l1);
    if (paramMicrosoftStsTokenResponse.getExtExpiresIn() == null) {
      l1 = 0L;
    } else {
      l1 = paramMicrosoftStsTokenResponse.getExtExpiresIn().longValue();
    }
    return String.valueOf(l2 + l1);
  }
  
  private String getRealm(MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    return paramMicrosoftStsOAuth2Strategy.createAccount(paramMicrosoftStsTokenResponse).getRealm();
  }
  
  private String getTarget(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = new HashSet(Arrays.asList(paramString1.split("\\s+")));
      paramString1.removeAll(BaseController.DEFAULT_SCOPES);
      paramString2 = paramString1.iterator();
      for (paramString1 = ""; paramString2.hasNext(); paramString1 = a.a(paramString1, (String)paramString2.next(), " ")) {}
      str = paramString1.trim();
    }
    return str;
  }
  
  public AccountRecord asAccount(MicrosoftAccount paramMicrosoftAccount)
  {
    return new AccountRecord(paramMicrosoftAccount);
  }
  
  public IdTokenRecord asIdToken(MicrosoftAccount paramMicrosoftAccount, MicrosoftRefreshToken paramMicrosoftRefreshToken)
  {
    long l = getCachedAt();
    IDToken localIDToken = paramMicrosoftAccount.getIDToken();
    IdTokenRecord localIdTokenRecord = new IdTokenRecord();
    localIdTokenRecord.setHomeAccountId(paramMicrosoftRefreshToken.getHomeAccountId());
    localIdTokenRecord.setEnvironment(paramMicrosoftRefreshToken.getEnvironment());
    localIdTokenRecord.setRealm(paramMicrosoftAccount.getRealm());
    paramMicrosoftAccount = CredentialType.IdToken;
    localIdTokenRecord.setCredentialType("IdToken");
    localIdTokenRecord.setClientId(paramMicrosoftRefreshToken.getClientId());
    localIdTokenRecord.setSecret(localIDToken.getRawIDToken());
    localIdTokenRecord.setCachedAt(String.valueOf(l));
    localIdTokenRecord.setAuthority(SchemaUtil.getAuthority(localIDToken));
    return localIdTokenRecord;
  }
  
  public RefreshTokenRecord asRefreshToken(MicrosoftRefreshToken paramMicrosoftRefreshToken)
  {
    RefreshTokenRecord localRefreshTokenRecord = new RefreshTokenRecord();
    localRefreshTokenRecord.setHomeAccountId(paramMicrosoftRefreshToken.getHomeAccountId());
    localRefreshTokenRecord.setEnvironment(paramMicrosoftRefreshToken.getEnvironment());
    CredentialType localCredentialType = CredentialType.RefreshToken;
    localRefreshTokenRecord.setCredentialType("RefreshToken");
    localRefreshTokenRecord.setClientId(paramMicrosoftRefreshToken.getClientId());
    localRefreshTokenRecord.setSecret(paramMicrosoftRefreshToken.getSecret());
    localRefreshTokenRecord.setTarget(paramMicrosoftRefreshToken.getTarget());
    localRefreshTokenRecord.setCachedAt(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
    localRefreshTokenRecord.setFamilyId(paramMicrosoftRefreshToken.getFamilyId());
    return localRefreshTokenRecord;
  }
  
  public AccessTokenRecord createAccessToken(MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    try
    {
      long l1 = getCachedAt();
      long l2 = getExpiresOn(paramMicrosoftStsTokenResponse);
      ClientInfo localClientInfo = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
      localClientInfo.<init>(paramMicrosoftStsTokenResponse.getClientInfo());
      AccessTokenRecord localAccessTokenRecord = new com/microsoft/identity/common/internal/dto/AccessTokenRecord;
      localAccessTokenRecord.<init>();
      localAccessTokenRecord.setCredentialType(getCredentialType(paramMicrosoftStsTokenResponse.getTokenType()));
      localAccessTokenRecord.setHomeAccountId(SchemaUtil.getHomeAccountId(localClientInfo));
      localAccessTokenRecord.setRealm(getRealm(paramMicrosoftStsOAuth2Strategy, paramMicrosoftStsTokenResponse));
      localAccessTokenRecord.setEnvironment(paramMicrosoftStsOAuth2Strategy.getIssuerCacheIdentifierFromTokenEndpoint());
      localAccessTokenRecord.setClientId(paramMicrosoftStsAuthorizationRequest.getClientId());
      localAccessTokenRecord.setTarget(getTarget(paramMicrosoftStsAuthorizationRequest.getScope(), paramMicrosoftStsTokenResponse.getScope()));
      localAccessTokenRecord.setCachedAt(String.valueOf(l1));
      localAccessTokenRecord.setExpiresOn(String.valueOf(l2));
      localAccessTokenRecord.setSecret(paramMicrosoftStsTokenResponse.getAccessToken());
      localAccessTokenRecord.setExtendedExpiresOn(getExtendedExpiresOn(paramMicrosoftStsTokenResponse));
      localAccessTokenRecord.setAuthority(paramMicrosoftStsOAuth2Strategy.getAuthorityFromTokenEndpoint());
      localAccessTokenRecord.setAccessTokenType(paramMicrosoftStsTokenResponse.getTokenType());
      if ("PoP".equalsIgnoreCase(paramMicrosoftStsTokenResponse.getTokenType())) {
        localAccessTokenRecord.setKid(paramMicrosoftStsOAuth2Strategy.getDeviceAtPopThumbprint());
      }
      return localAccessTokenRecord;
    }
    catch (ServiceException paramMicrosoftStsOAuth2Strategy)
    {
      throw new RuntimeException(paramMicrosoftStsOAuth2Strategy);
    }
  }
  
  public AccountRecord createAccount(MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    Logger.verbose(TAG, "Creating Account");
    return new AccountRecord(paramMicrosoftStsOAuth2Strategy.createAccount(paramMicrosoftStsTokenResponse));
  }
  
  public IdTokenRecord createIdToken(MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    try
    {
      ClientInfo localClientInfo = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
      localClientInfo.<init>(paramMicrosoftStsTokenResponse.getClientInfo());
      IdTokenRecord localIdTokenRecord = new com/microsoft/identity/common/internal/dto/IdTokenRecord;
      localIdTokenRecord.<init>();
      localIdTokenRecord.setHomeAccountId(SchemaUtil.getHomeAccountId(localClientInfo));
      localIdTokenRecord.setEnvironment(paramMicrosoftStsOAuth2Strategy.getIssuerCacheIdentifierFromTokenEndpoint());
      localIdTokenRecord.setRealm(getRealm(paramMicrosoftStsOAuth2Strategy, paramMicrosoftStsTokenResponse));
      localIdTokenRecord.setCredentialType(SchemaUtil.getCredentialTypeFromVersion(paramMicrosoftStsTokenResponse.getIdToken()));
      localIdTokenRecord.setClientId(paramMicrosoftStsAuthorizationRequest.getClientId());
      localIdTokenRecord.setSecret(paramMicrosoftStsTokenResponse.getIdToken());
      localIdTokenRecord.setAuthority(paramMicrosoftStsOAuth2Strategy.getAuthorityFromTokenEndpoint());
      return localIdTokenRecord;
    }
    catch (ServiceException paramMicrosoftStsOAuth2Strategy)
    {
      throw new RuntimeException(paramMicrosoftStsOAuth2Strategy);
    }
  }
  
  public RefreshTokenRecord createRefreshToken(MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest paramMicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse paramMicrosoftStsTokenResponse)
  {
    try
    {
      long l = getCachedAt();
      ClientInfo localClientInfo = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
      localClientInfo.<init>(paramMicrosoftStsTokenResponse.getClientInfo());
      RefreshTokenRecord localRefreshTokenRecord = new com/microsoft/identity/common/internal/dto/RefreshTokenRecord;
      localRefreshTokenRecord.<init>();
      CredentialType localCredentialType = CredentialType.RefreshToken;
      localRefreshTokenRecord.setCredentialType("RefreshToken");
      localRefreshTokenRecord.setEnvironment(paramMicrosoftStsOAuth2Strategy.getIssuerCacheIdentifierFromTokenEndpoint());
      localRefreshTokenRecord.setHomeAccountId(SchemaUtil.getHomeAccountId(localClientInfo));
      localRefreshTokenRecord.setClientId(paramMicrosoftStsAuthorizationRequest.getClientId());
      localRefreshTokenRecord.setSecret(paramMicrosoftStsTokenResponse.getRefreshToken());
      localRefreshTokenRecord.setFamilyId(paramMicrosoftStsTokenResponse.getFamilyId());
      localRefreshTokenRecord.setTarget(getTarget(paramMicrosoftStsAuthorizationRequest.getScope(), paramMicrosoftStsTokenResponse.getScope()));
      localRefreshTokenRecord.setCachedAt(String.valueOf(l));
      return localRefreshTokenRecord;
    }
    catch (ServiceException paramMicrosoftStsOAuth2Strategy)
    {
      throw new RuntimeException(paramMicrosoftStsOAuth2Strategy);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.MicrosoftStsAccountCredentialAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */