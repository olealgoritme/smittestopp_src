package com.microsoft.identity.common.internal.cache;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.google.gson.Gson;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.adal.internal.cache.CacheKey;
import com.microsoft.identity.common.adal.internal.cache.DateTimeAdapter;
import com.microsoft.identity.common.adal.internal.cache.StorageHelper;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import e.a.a.a.a;
import e.c.c.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ADALOAuth2TokenCache
  extends OAuth2TokenCache<AzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse>
  implements IShareSingleSignOnState
{
  public static final String ERR_UNSUPPORTED_OPERATION = "This method is unsupported.";
  public static final String SHARED_PREFERENCES_FILENAME = "com.microsoft.aad.adal.cache";
  public static final String TAG = "ADALOAuth2TokenCache";
  public Gson mGson;
  public ISharedPreferencesFileManager mISharedPreferencesFileManager;
  public List<IShareSingleSignOnState<MicrosoftAccount, MicrosoftRefreshToken>> mSharedSSOCaches;
  
  public ADALOAuth2TokenCache(Context paramContext)
  {
    super(paramContext);
    paramContext = new e();
    paramContext.a(Date.class, new DateTimeAdapter());
    mGson = paramContext.a();
    String str = TAG;
    paramContext = a.a("Init: ");
    paramContext.append(TAG);
    Logger.verbose(str, paramContext.toString());
    validateSecretKeySetting();
    initializeSharedPreferencesFileManager("com.microsoft.aad.adal.cache");
    mSharedSSOCaches = new ArrayList();
  }
  
  public ADALOAuth2TokenCache(Context paramContext, List<IShareSingleSignOnState<MicrosoftAccount, MicrosoftRefreshToken>> paramList)
  {
    super(paramContext);
    Object localObject = new e();
    ((e)localObject).a(Date.class, new DateTimeAdapter());
    mGson = ((e)localObject).a();
    String str = TAG;
    localObject = a.a("Init: ");
    ((StringBuilder)localObject).append(TAG);
    Logger.verbose(str, ((StringBuilder)localObject).toString());
    str = TAG;
    localObject = a.a("Context is an Application? [");
    ((StringBuilder)localObject).append(paramContext instanceof Application);
    ((StringBuilder)localObject).append("]");
    Logger.info(str, ((StringBuilder)localObject).toString());
    validateSecretKeySetting();
    initializeSharedPreferencesFileManager("com.microsoft.aad.adal.cache");
    mSharedSSOCaches = paramList;
  }
  
  public static void logTokenCacheItem(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    Logger.info(TAG, "Logging TokenCacheItem");
    Object localObject1 = TAG;
    Object localObject2 = a.a("resource: [");
    ((StringBuilder)localObject2).append(paramADALTokenCacheItem.getResource());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = TAG;
    localObject2 = a.a("authority: [");
    ((StringBuilder)localObject2).append(paramADALTokenCacheItem.getAuthority());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = TAG;
    localObject1 = a.a("clientId: [");
    ((StringBuilder)localObject1).append(paramADALTokenCacheItem.getClientId());
    ((StringBuilder)localObject1).append("]");
    Logger.infoPII((String)localObject2, ((StringBuilder)localObject1).toString());
    localObject1 = TAG;
    localObject2 = a.a("expiresOn: [");
    ((StringBuilder)localObject2).append(paramADALTokenCacheItem.getExpiresOn());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = TAG;
    localObject1 = a.a("isMrrt: [");
    ((StringBuilder)localObject1).append(paramADALTokenCacheItem.getIsMultiResourceRefreshToken());
    ((StringBuilder)localObject1).append("]");
    Logger.infoPII((String)localObject2, ((StringBuilder)localObject1).toString());
    localObject2 = TAG;
    localObject1 = a.a("tenantId: [");
    ((StringBuilder)localObject1).append(paramADALTokenCacheItem.getTenantId());
    ((StringBuilder)localObject1).append("]");
    Logger.infoPII((String)localObject2, ((StringBuilder)localObject1).toString());
    localObject1 = TAG;
    localObject2 = a.a("foci: [");
    ((StringBuilder)localObject2).append(paramADALTokenCacheItem.getFamilyClientId());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = TAG;
    localObject2 = a.a("extendedExpires: [");
    ((StringBuilder)localObject2).append(paramADALTokenCacheItem.getExtendedExpiresOn());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = TAG;
    localObject1 = a.a("speRing: [");
    ((StringBuilder)localObject1).append(paramADALTokenCacheItem.getSpeRing());
    ((StringBuilder)localObject1).append("]");
    Logger.infoPII((String)localObject2, ((StringBuilder)localObject1).toString());
  }
  
  private void setItem(String paramString, ADALTokenCacheItem paramADALTokenCacheItem)
  {
    Logger.info(TAG, "Setting item to cache");
    paramADALTokenCacheItem = mGson.a(paramADALTokenCacheItem);
    mISharedPreferencesFileManager.putString(paramString, paramADALTokenCacheItem);
  }
  
  private void setItemToCacheForUser(String paramString1, String paramString2, String paramString3, ADALTokenCacheItem paramADALTokenCacheItem, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":");
    localStringBuilder.append("setItemToCacheForUser");
    Logger.info(localStringBuilder.toString(), "Setting cacheitem for RT entry.");
    setItem(CacheKey.createCacheKeyForRTEntry(paramString1, paramString2, paramString3, paramString4), paramADALTokenCacheItem);
    if (paramADALTokenCacheItem.getIsMultiResourceRefreshToken())
    {
      paramString2 = new StringBuilder();
      paramString2.append(TAG);
      paramString2.append(":");
      paramString2.append("setItemToCacheForUser");
      Logger.info(paramString2.toString(), "CacheItem is an MRRT.");
      setItem(CacheKey.createCacheKeyForMRRT(paramString1, paramString3, paramString4), ADALTokenCacheItem.getAsMRRTTokenCacheItem(paramADALTokenCacheItem));
    }
    if (!StringExtensions.isNullOrBlank(paramADALTokenCacheItem.getFamilyClientId()))
    {
      paramString2 = new StringBuilder();
      paramString2.append(TAG);
      paramString2.append(":");
      paramString2.append("setItemToCacheForUser");
      Logger.info(paramString2.toString(), "CacheItem is an FRT.");
      setItem(CacheKey.createCacheKeyForFRT(paramString1, paramADALTokenCacheItem.getFamilyClientId(), paramString4), ADALTokenCacheItem.getAsFRTTokenCacheItem(paramADALTokenCacheItem));
    }
  }
  
  private void validateSecretKeySetting()
  {
    Logger.verbose(TAG, "Validating secret key settings.");
    AuthenticationSettings.INSTANCE.getSecretKeyData();
  }
  
  public void clearAll()
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public AccountRecord getAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public AccountRecord getAccountByHomeAccountId(String paramString1, String paramString2, String paramString3)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public AccountRecord getAccountByLocalAccountId(String paramString1, String paramString2, String paramString3)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String paramString1, String paramString2, String paramString3)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public List<AccountRecord> getAccounts(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2, String paramString3)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public Set<String> getAllClientIds()
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String paramString, AccountRecord paramAccountRecord)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public List<IdTokenRecord> getIdTokensForAccountRecord(String paramString, AccountRecord paramAccountRecord)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public RefreshToken getSingleSignOnState(BaseAccount paramBaseAccount)
  {
    Logger.warn(TAG, "getSingleSignOnState was called, but is not implemented.");
    return null;
  }
  
  public void initializeSharedPreferencesFileManager(String paramString)
  {
    Logger.verbose(TAG, "Initializing SharedPreferencesFileManager");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Initializing with name: ");
    localStringBuilder.append(paramString);
    Logger.verbosePII(str, localStringBuilder.toString());
    mISharedPreferencesFileManager = new SharedPreferencesFileManager(getContext(), paramString, new StorageHelper(getContext()));
  }
  
  public ICacheRecord load(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public List<ICacheRecord> loadWithAggregatedAccountData(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public AccountDeletionRecord removeAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public boolean removeCredential(Credential paramCredential)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public ICacheRecord save(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public ICacheRecord save(AzureActiveDirectoryOAuth2Strategy paramAzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":");
    ((StringBuilder)localObject1).append("save");
    Logger.info(((StringBuilder)localObject1).toString(), "Saving Tokens...");
    Object localObject2 = paramAzureActiveDirectoryOAuth2Strategy.getIssuerCacheIdentifier(paramAzureActiveDirectoryAuthorizationRequest);
    AzureActiveDirectoryAccount localAzureActiveDirectoryAccount = paramAzureActiveDirectoryOAuth2Strategy.createAccount(paramAzureActiveDirectoryTokenResponse);
    String str1 = Uri.parse((String)localObject2).getAuthority();
    localAzureActiveDirectoryAccount.setEnvironment(str1);
    localObject1 = paramAzureActiveDirectoryOAuth2Strategy.getRefreshTokenFromResponse(paramAzureActiveDirectoryTokenResponse);
    ((MicrosoftRefreshToken)localObject1).setEnvironment(str1);
    Logger.info(TAG, "Constructing new ADALTokenCacheItem");
    paramAzureActiveDirectoryOAuth2Strategy = new ADALTokenCacheItem(paramAzureActiveDirectoryOAuth2Strategy, paramAzureActiveDirectoryAuthorizationRequest, paramAzureActiveDirectoryTokenResponse);
    logTokenCacheItem(paramAzureActiveDirectoryOAuth2Strategy);
    paramAzureActiveDirectoryTokenResponse = new StringBuilder();
    paramAzureActiveDirectoryTokenResponse.append(TAG);
    paramAzureActiveDirectoryTokenResponse.append(":");
    paramAzureActiveDirectoryTokenResponse.append("save");
    Logger.info(paramAzureActiveDirectoryTokenResponse.toString(), "Setting items to cache for user...");
    paramAzureActiveDirectoryTokenResponse = localAzureActiveDirectoryAccount.getCacheIdentifiers().iterator();
    while (paramAzureActiveDirectoryTokenResponse.hasNext())
    {
      String str2 = (String)paramAzureActiveDirectoryTokenResponse.next();
      str1 = paramAzureActiveDirectoryAuthorizationRequest.getScope();
      String str3 = paramAzureActiveDirectoryAuthorizationRequest.getClientId();
      Object localObject3 = a.a(new StringBuilder(), TAG, ":", "save");
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("issuerCacheIdentifier: [");
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append("]");
      Logger.infoPII((String)localObject3, ((StringBuilder)localObject4).toString());
      localObject4 = a.a(new StringBuilder(), TAG, ":", "save");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("scope: [");
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append("]");
      Logger.infoPII((String)localObject4, ((StringBuilder)localObject3).toString());
      localObject4 = a.a(new StringBuilder(), TAG, ":", "save");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("clientId: [");
      ((StringBuilder)localObject3).append(str3);
      ((StringBuilder)localObject3).append("]");
      Logger.infoPII((String)localObject4, ((StringBuilder)localObject3).toString());
      localObject3 = a.a(new StringBuilder(), TAG, ":", "save");
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("cacheIdentifier: [");
      ((StringBuilder)localObject4).append(str2);
      ((StringBuilder)localObject4).append("]");
      Logger.infoPII((String)localObject3, ((StringBuilder)localObject4).toString());
      setItemToCacheForUser((String)localObject2, str1, str3, paramAzureActiveDirectoryOAuth2Strategy, str2);
    }
    setItemToCacheForUser((String)localObject2, paramAzureActiveDirectoryAuthorizationRequest.getScope(), paramAzureActiveDirectoryAuthorizationRequest.getClientId(), paramAzureActiveDirectoryOAuth2Strategy, null);
    paramAzureActiveDirectoryOAuth2Strategy = new StringBuilder();
    paramAzureActiveDirectoryOAuth2Strategy.append(TAG);
    paramAzureActiveDirectoryOAuth2Strategy.append(":");
    paramAzureActiveDirectoryOAuth2Strategy.append("save");
    Logger.info(paramAzureActiveDirectoryOAuth2Strategy.toString(), "Syncing SSO state to caches...");
    paramAzureActiveDirectoryOAuth2Strategy = mSharedSSOCaches.iterator();
    while (paramAzureActiveDirectoryOAuth2Strategy.hasNext())
    {
      paramAzureActiveDirectoryAuthorizationRequest = (IShareSingleSignOnState)paramAzureActiveDirectoryOAuth2Strategy.next();
      try
      {
        paramAzureActiveDirectoryAuthorizationRequest.setSingleSignOnState(localAzureActiveDirectoryAccount, (RefreshToken)localObject1);
      }
      catch (ClientException paramAzureActiveDirectoryAuthorizationRequest)
      {
        paramAzureActiveDirectoryTokenResponse = TAG;
        localObject2 = a.a("Exception setting single sign on state for account ");
        ((StringBuilder)localObject2).append(localAzureActiveDirectoryAccount.getUsername());
        Logger.errorPII(paramAzureActiveDirectoryTokenResponse, ((StringBuilder)localObject2).toString(), paramAzureActiveDirectoryAuthorizationRequest);
      }
    }
    return null;
  }
  
  public List<ICacheRecord> saveAndLoadAggregatedAccountData(AzureActiveDirectoryOAuth2Strategy paramAzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryAuthorizationRequest paramAzureActiveDirectoryAuthorizationRequest, AzureActiveDirectoryTokenResponse paramAzureActiveDirectoryTokenResponse)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public void setSingleSignOnState(BaseAccount paramBaseAccount, RefreshToken paramRefreshToken)
  {
    Logger.warn(TAG, "setSingleSignOnState was called, but is not implemented.");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.ADALOAuth2TokenCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */