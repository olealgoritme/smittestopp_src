package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import e.a.a.a.a;
import java.util.List;

public class MsalCppOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken>
  extends MsalOAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken>
{
  public static final String TAG = "com.microsoft.identity.common.internal.cache.MsalCppOAuth2TokenCache";
  
  public MsalCppOAuth2TokenCache(Context paramContext, IAccountCredentialCache paramIAccountCredentialCache, IAccountCredentialAdapter paramIAccountCredentialAdapter)
  {
    super(paramContext, paramIAccountCredentialCache, paramIAccountCredentialAdapter);
  }
  
  public static MsalCppOAuth2TokenCache create(Context paramContext)
  {
    MsalOAuth2TokenCache localMsalOAuth2TokenCache = MsalOAuth2TokenCache.create(paramContext);
    return new MsalCppOAuth2TokenCache(paramContext, localMsalOAuth2TokenCache.getAccountCredentialCache(), localMsalOAuth2TokenCache.getAccountCredentialAdapter());
  }
  
  public void clearCache()
  {
    try
    {
      getAccountCredentialCache().clearAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public AccountRecord getAccount(String paramString1, String paramString2, String paramString3)
  {
    validateNonNull(paramString1, "homeAccountId");
    validateNonNull(paramString2, "environment");
    validateNonNull(paramString3, "realm");
    Object localObject = getAccountCredentialCache().getAccountsFilteredBy(paramString1, paramString2, paramString3);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      return (AccountRecord)((List)localObject).get(0);
    }
    String str = a.a(new StringBuilder(), TAG, ":getAccount");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No account found for the passing in homeAccountId: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" environment: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" realm: ");
    ((StringBuilder)localObject).append(paramString3);
    Logger.info(str, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public List<AccountRecord> getAllAccounts()
  {
    return getAccountCredentialCache().getAccounts();
  }
  
  public AccountDeletionRecord removeAccount(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      validateNonNull(paramString1, "homeAccountId");
      validateNonNull(paramString3, "realm");
      List localList = getAccountCredentialCache().getCredentialsFilteredBy(paramString1, paramString2, CredentialType.RefreshToken, null, paramString3, null, "Bearer");
      if ((localList != null) && (!localList.isEmpty()))
      {
        paramString1 = removeAccount(paramString2, ((Credential)localList.get(0)).getClientId(), paramString1, paramString3);
        return paramString1;
      }
      paramString1 = new AccountDeletionRecord(null);
      return paramString1;
    }
    finally {}
  }
  
  public void saveAccountRecord(AccountRecord paramAccountRecord)
  {
    try
    {
      getAccountCredentialCache().saveAccount(paramAccountRecord);
      return;
    }
    finally
    {
      paramAccountRecord = finally;
      throw paramAccountRecord;
    }
  }
  
  public void saveCredentials(AccountRecord paramAccountRecord, Credential... paramVarArgs)
  {
    if (paramVarArgs != null) {}
    try
    {
      if (paramVarArgs.length != 0)
      {
        int i = paramVarArgs.length;
        int j = 0;
        RefreshTokenRecord localRefreshTokenRecord = null;
        Object localObject1 = null;
        Object localObject3;
        for (Object localObject2 = localObject1; j < i; localObject2 = localObject3)
        {
          Credential localCredential = paramVarArgs[j];
          Object localObject4;
          if ((localCredential instanceof AccessTokenRecord))
          {
            localObject3 = (AccessTokenRecord)localCredential;
            localObject4 = localObject1;
          }
          else if ((localCredential instanceof IdTokenRecord))
          {
            localObject4 = (IdTokenRecord)localCredential;
            localObject3 = localObject2;
          }
          else
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if ((localCredential instanceof RefreshTokenRecord))
            {
              localRefreshTokenRecord = (RefreshTokenRecord)localCredential;
              localObject3 = localObject2;
              localObject4 = localObject1;
            }
          }
          j++;
          localObject1 = localObject4;
        }
        validateNonNull(paramAccountRecord, "AccountRecord");
        validateNonNull(localRefreshTokenRecord, "RefreshTokenRecord");
        validateNonNull(localObject1, "IdTokenRecord");
        validateCacheArtifacts(paramAccountRecord, (AccessTokenRecord)localObject2, localRefreshTokenRecord, (IdTokenRecord)localObject1);
        removeRefreshTokenIfNeeded(paramAccountRecord, localRefreshTokenRecord);
        saveCredentialsInternal(paramVarArgs);
        return;
      }
      paramAccountRecord = new com/microsoft/identity/common/exception/ClientException;
      paramAccountRecord.<init>("Credential array passed in is null or empty");
      throw paramAccountRecord;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.MsalCppOAuth2TokenCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */