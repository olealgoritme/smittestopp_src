package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import com.microsoft.identity.common.adal.internal.cache.StorageHelper;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
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
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import e.a.a.a.a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrokerOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends MicrosoftTokenResponse, GenericAccount extends MicrosoftAccount, GenericRefreshToken extends MicrosoftRefreshToken>
  extends OAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse>
{
  public static final String TAG = "BrokerOAuth2TokenCache";
  public static final String UNCHECKED = "unchecked";
  public final IBrokerApplicationMetadataCache mApplicationMetadataCache;
  public final int mCallingProcessUid;
  public BrokerOAuth2TokenCache.ProcessUidCacheFactory mDelegate = null;
  public final MicrosoftFamilyOAuth2TokenCache mFociCache;
  
  public BrokerOAuth2TokenCache(Context paramContext, int paramInt, IBrokerApplicationMetadataCache paramIBrokerApplicationMetadataCache)
  {
    super(paramContext);
    String str = a.a(new StringBuilder(), TAG, "ctor");
    StringBuilder localStringBuilder = a.a("Init::");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mCallingProcessUid = paramInt;
    mFociCache = initializeFociCache(paramContext);
    mApplicationMetadataCache = paramIBrokerApplicationMetadataCache;
  }
  
  public BrokerOAuth2TokenCache(Context paramContext, int paramInt, IBrokerApplicationMetadataCache paramIBrokerApplicationMetadataCache, BrokerOAuth2TokenCache.ProcessUidCacheFactory paramProcessUidCacheFactory, MicrosoftFamilyOAuth2TokenCache paramMicrosoftFamilyOAuth2TokenCache)
  {
    super(paramContext);
    String str = a.a(new StringBuilder(), TAG, "ctor");
    paramContext = a.a("Init::");
    paramContext.append(TAG);
    Logger.verbose(str, paramContext.toString());
    mDelegate = paramProcessUidCacheFactory;
    mApplicationMetadataCache = paramIBrokerApplicationMetadataCache;
    mCallingProcessUid = paramInt;
    mFociCache = paramMicrosoftFamilyOAuth2TokenCache;
  }
  
  public static <T extends MsalOAuth2TokenCache> T getTokenCache(Context paramContext, ISharedPreferencesFileManager paramISharedPreferencesFileManager, boolean paramBoolean)
  {
    paramISharedPreferencesFileManager = new SharedPreferencesAccountCredentialCache(new CacheKeyValueDelegate(), paramISharedPreferencesFileManager);
    MicrosoftStsAccountCredentialAdapter localMicrosoftStsAccountCredentialAdapter = new MicrosoftStsAccountCredentialAdapter();
    if (paramBoolean) {
      paramContext = new MicrosoftFamilyOAuth2TokenCache(paramContext, paramISharedPreferencesFileManager, localMicrosoftStsAccountCredentialAdapter);
    } else {
      paramContext = new MsalOAuth2TokenCache(paramContext, paramISharedPreferencesFileManager, localMicrosoftStsAccountCredentialAdapter);
    }
    return paramContext;
  }
  
  private MsalOAuth2TokenCache getTokenCacheForClient(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = mApplicationMetadataCache.getMetadata(paramString1, paramString2, paramInt);
    if (paramString1 != null)
    {
      boolean bool;
      if (paramString1.getFoci() != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramString1 = a.a(new StringBuilder(), TAG, ":getTokenCacheForClient");
      paramString2 = new StringBuilder();
      paramString2.append("is Foci? [");
      paramString2.append(bool);
      paramString2.append("]");
      Logger.verbose(paramString1, paramString2.toString());
      if (bool) {
        paramString1 = mFociCache;
      } else {
        paramString1 = initializeProcessUidCache(getContext(), paramInt);
      }
    }
    else
    {
      paramString1 = null;
    }
    if (paramString1 == null) {
      a.c(new StringBuilder(), TAG, ":getTokenCacheForClient", "Could not locate a cache for this app.");
    }
    return paramString1;
  }
  
  private List<OAuth2TokenCache> getTokenCachesForClientId(String paramString)
  {
    Object localObject1 = mApplicationMetadataCache.getAll();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (BrokerApplicationMetadata)((Iterator)localObject1).next();
      if (paramString.equals(((AbstractApplicationMetadata)localObject2).getClientId())) {
        if ((((BrokerApplicationMetadata)localObject2).getFoci() != null) && (i == 0))
        {
          localArrayList.add(mFociCache);
          i = 1;
        }
        else
        {
          localObject2 = getTokenCacheForClient(((AbstractApplicationMetadata)localObject2).getClientId(), ((AbstractApplicationMetadata)localObject2).getEnvironment(), mCallingProcessUid);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static MicrosoftFamilyOAuth2TokenCache initializeFociCache(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":initializeFociCache");
    Logger.verbose(localStringBuilder.toString(), "Initializing foci cache");
    return (MicrosoftFamilyOAuth2TokenCache)getTokenCache(paramContext, new SharedPreferencesFileManager(paramContext, "com.microsoft.identity.client.account_credential_cache.foci-1", new StorageHelper(paramContext)), true);
  }
  
  private MsalOAuth2TokenCache initializeProcessUidCache(Context paramContext, int paramInt)
  {
    a.b(new StringBuilder(), TAG, ":initializeProcessUidCache", "Initializing uid cache.");
    if (mDelegate != null)
    {
      a.c(new StringBuilder(), TAG, ":initializeProcessUidCache", "Using swapped delegate cache.");
      return mDelegate.getTokenCache(paramContext, paramInt);
    }
    StorageHelper localStorageHelper = new StorageHelper(paramContext);
    return getTokenCache(paramContext, new SharedPreferencesFileManager(paramContext, SharedPreferencesAccountCredentialCache.getBrokerUidSequesteredFilename(paramInt), localStorageHelper), false);
  }
  
  private AccountDeletionRecord removeAccountInternal(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    Object localObject1 = mApplicationMetadataCache.getAll();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      BrokerApplicationMetadata localBrokerApplicationMetadata = (BrokerApplicationMetadata)((Iterator)localObject1).next();
      String str = localBrokerApplicationMetadata.getClientId();
      Object localObject2 = localBrokerApplicationMetadata.getEnvironment();
      int i;
      if (paramBoolean) {
        i = localBrokerApplicationMetadata.getUid();
      } else {
        i = mCallingProcessUid;
      }
      localObject2 = getTokenCacheForClient(str, (String)localObject2, i);
      if (localObject2 != null) {
        localArrayList.add(((MsalOAuth2TokenCache)localObject2).removeAccount(paramString1, paramString2, paramString3, paramString4));
      }
    }
    paramString1 = new ArrayList();
    paramString2 = localArrayList.iterator();
    while (paramString2.hasNext()) {
      paramString1.addAll((AccountDeletionRecord)paramString2.next());
    }
    paramString2 = a.a(new StringBuilder(), TAG, ":removeAccountInternal");
    paramString3 = a.a("Deleted [");
    paramString3.append(paramString1.size());
    paramString3.append("] AccountRecords.");
    Logger.info(paramString2, paramString3.toString());
    return new AccountDeletionRecord(paramString1);
  }
  
  private void updateApplicationMetadataCache(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    BrokerApplicationMetadata localBrokerApplicationMetadata = new BrokerApplicationMetadata();
    localBrokerApplicationMetadata.setClientId(paramString1);
    localBrokerApplicationMetadata.setEnvironment(paramString2);
    localBrokerApplicationMetadata.setFoci(paramString3);
    localBrokerApplicationMetadata.setUid(paramInt);
    paramString2 = a.a(new StringBuilder(), TAG, ":updateApplicationMetadataCache");
    paramString3 = new StringBuilder();
    paramString3.append("Adding cache entry for clientId: [");
    paramString3.append(paramString1);
    paramString3.append("]");
    Logger.verbose(paramString2, paramString3.toString());
    boolean bool = mApplicationMetadataCache.insert(localBrokerApplicationMetadata);
    paramString1 = a.a(new StringBuilder(), TAG, ":updateApplicationMetadataCache");
    paramString2 = new StringBuilder();
    paramString2.append("Cache updated successfully? [");
    paramString2.append(bool);
    paramString2.append("]");
    Logger.info(paramString1, paramString2.toString());
  }
  
  public void clearAll()
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public AccountRecord getAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1;
    Object localObject2;
    if (paramString1 != null)
    {
      localObject1 = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        a.b(new StringBuilder(), TAG, ":getAccount", "Target cache was null. Using FOCI cache.");
        localObject2 = mFociCache;
      }
      paramString1 = ((MsalOAuth2TokenCache)localObject2).getAccount(paramString1, paramString2, paramString3, paramString4);
    }
    else
    {
      localObject1 = getTokenCachesForClientId(paramString2).iterator();
      for (localObject2 = null; (localObject2 == null) && (((Iterator)localObject1).hasNext()); localObject2 = ((OAuth2TokenCache)((Iterator)localObject1).next()).getAccount(paramString1, paramString2, paramString3, paramString4)) {}
      paramString1 = (String)localObject2;
    }
    return paramString1;
  }
  
  public AccountRecord getAccountByHomeAccountId(String paramString1, String paramString2, String paramString3)
  {
    a.b(new StringBuilder(), TAG, "getAccountByHomeAccountId", "Loading account by home account id.");
    if (paramString1 != null)
    {
      localObject1 = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      localObject2 = a.a(new StringBuilder(), TAG, "getAccountByHomeAccountId");
      StringBuilder localStringBuilder = a.a("Loading from FOCI cache? [");
      boolean bool;
      if (localObject1 == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      Logger.info((String)localObject2, localStringBuilder.toString());
      if (localObject1 != null) {
        return ((MsalOAuth2TokenCache)localObject1).getAccountByHomeAccountId(paramString1, paramString2, paramString3);
      }
      return mFociCache.getAccountByHomeAccountId(paramString1, paramString2, paramString3);
    }
    Object localObject2 = null;
    Object localObject1 = getTokenCachesForClientId(paramString2).iterator();
    while ((localObject2 == null) && (((Iterator)localObject1).hasNext())) {
      localObject2 = ((OAuth2TokenCache)((Iterator)localObject1).next()).getAccountByHomeAccountId(paramString1, paramString2, paramString3);
    }
    return (AccountRecord)localObject2;
  }
  
  public AccountRecord getAccountByLocalAccountId(String paramString1, String paramString2, String paramString3)
  {
    a.b(new StringBuilder(), TAG, ":getAccountByLocalAccountId", "Loading account by local account id.");
    if (paramString1 != null)
    {
      localObject1 = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      String str = a.a(new StringBuilder(), TAG, ":getAccountByLocalAccountId");
      localObject2 = a.a("Loading from FOCI cache? [");
      boolean bool;
      if (localObject1 == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      Logger.info(str, ((StringBuilder)localObject2).toString());
      if (localObject1 != null) {
        return ((MsalOAuth2TokenCache)localObject1).getAccountByLocalAccountId(paramString1, paramString2, paramString3);
      }
      return mFociCache.getAccountByLocalAccountId(paramString1, paramString2, paramString3);
    }
    Object localObject1 = null;
    Object localObject2 = getTokenCachesForClientId(paramString2).iterator();
    while ((localObject1 == null) && (((Iterator)localObject2).hasNext())) {
      localObject1 = ((OAuth2TokenCache)((Iterator)localObject2).next()).getAccountByLocalAccountId(paramString1, paramString2, paramString3);
    }
    return (AccountRecord)localObject1;
  }
  
  public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null)
    {
      localObject1 = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      String str = a.a(new StringBuilder(), TAG, ":getAccountWithAggregatedAccountDataByLocalAccountId");
      localObject2 = a.a("Loading from FOCI cache? [");
      boolean bool;
      if (localObject1 == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      Logger.info(str, ((StringBuilder)localObject2).toString());
      if (localObject1 != null) {
        return ((MsalOAuth2TokenCache)localObject1).getAccountWithAggregatedAccountDataByLocalAccountId(paramString1, paramString2, paramString3);
      }
      return mFociCache.getAccountWithAggregatedAccountDataByLocalAccountId(paramString1, paramString2, paramString3);
    }
    Object localObject1 = null;
    Object localObject2 = getTokenCachesForClientId(paramString2).iterator();
    while ((localObject1 == null) && (((Iterator)localObject2).hasNext())) {
      localObject1 = ((OAuth2TokenCache)((Iterator)localObject2).next()).getAccountWithAggregatedAccountDataByLocalAccountId(paramString1, paramString2, paramString3);
    }
    return (ICacheRecord)localObject1;
  }
  
  public List<AccountRecord> getAccounts()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = mApplicationMetadataCache.getAll().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (BrokerApplicationMetadata)((Iterator)localObject2).next();
      localObject3 = getTokenCacheForClient(((AbstractApplicationMetadata)localObject3).getClientId(), ((AbstractApplicationMetadata)localObject3).getEnvironment(), ((AbstractApplicationMetadata)localObject3).getUid());
      if (localObject3 != null) {
        ((AbstractCollection)localObject1).addAll(((MsalOAuth2TokenCache)localObject3).getAccountCredentialCache().getAccounts());
      }
    }
    ((AbstractCollection)localObject1).addAll(mFociCache.getAccountCredentialCache().getAccounts());
    localObject1 = new ArrayList((Collection)localObject1);
    localObject2 = a.a(new StringBuilder(), TAG, ":getAccounts");
    Object localObject3 = a.a("Found [");
    ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
    ((StringBuilder)localObject3).append("] accounts.");
    Logger.verbose((String)localObject2, ((StringBuilder)localObject3).toString());
    return (List<AccountRecord>)localObject1;
  }
  
  public List<AccountRecord> getAccounts(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (paramString1 != null)
    {
      localObject = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      if (localObject != null) {
        localArrayList.addAll(((MsalOAuth2TokenCache)localObject).getAccounts(paramString1, paramString2));
      } else {
        a.c(new StringBuilder(), TAG, ":getAccounts (2 param)", "No caches to inspect.");
      }
    }
    else
    {
      localObject = getTokenCachesForClientId(paramString2).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.addAll(((OAuth2TokenCache)((Iterator)localObject).next()).getAccounts(paramString1, paramString2));
      }
      paramString1 = a.a(new StringBuilder(), TAG, ":getAccounts (2 param)");
      paramString2 = a.a("Found [");
      paramString2.append(localArrayList.size());
      paramString2.append("] accounts.");
      Logger.verbose(paramString1, paramString2.toString());
    }
    return localArrayList;
  }
  
  public List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2)
  {
    Object localObject1;
    Object localObject2;
    if (paramString1 != null)
    {
      localObject1 = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        a.b(new StringBuilder(), TAG, ":getAccountsWithAggregatedAccountData", "Falling back to FoCI cache...");
        localObject2 = mFociCache;
      }
      paramString1 = ((MsalOAuth2TokenCache)localObject2).getAccountsWithAggregatedAccountData(paramString1, paramString2);
    }
    else
    {
      localObject1 = getTokenCachesForClientId(paramString2);
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject2).addAll(((OAuth2TokenCache)((Iterator)localObject1).next()).getAccountsWithAggregatedAccountData(paramString1, paramString2));
      }
      paramString1 = (String)localObject2;
    }
    return paramString1;
  }
  
  public List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1;
    Object localObject2;
    if (paramString1 != null)
    {
      localObject1 = getTokenCacheForClient(paramString2, paramString1, mCallingProcessUid);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        a.b(new StringBuilder(), TAG, ":getAccountsWithAggregatedAccountData", "Falling back to FoCI cache...");
        localObject2 = mFociCache;
      }
      paramString1 = ((MsalOAuth2TokenCache)localObject2).getAccountsWithAggregatedAccountData(paramString1, paramString2, paramString3);
    }
    else
    {
      localObject1 = getTokenCachesForClientId(paramString2);
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject2).addAll(((OAuth2TokenCache)((Iterator)localObject1).next()).getAccountsWithAggregatedAccountData(paramString1, paramString2, paramString3));
      }
      paramString1 = (String)localObject2;
    }
    return paramString1;
  }
  
  public Set<String> getAllClientIds()
  {
    return mApplicationMetadataCache.getAllClientIds();
  }
  
  public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String paramString, AccountRecord paramAccountRecord)
  {
    return getTokenCacheForClient(paramString, paramAccountRecord.getEnvironment(), mCallingProcessUid).getAllTenantAccountsForAccountByClientId(paramString, paramAccountRecord);
  }
  
  public List<ICacheRecord> getFociCacheRecords()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = mApplicationMetadataCache.getAllFociApplicationMetadata().iterator();
    while (localIterator1.hasNext())
    {
      BrokerApplicationMetadata localBrokerApplicationMetadata = (BrokerApplicationMetadata)localIterator1.next();
      Iterator localIterator2 = mFociCache.getAccounts(localBrokerApplicationMetadata.getEnvironment(), localBrokerApplicationMetadata.getClientId()).iterator();
      while (localIterator2.hasNext())
      {
        Object localObject1 = (AccountRecord)localIterator2.next();
        Object localObject2 = ((AccountRecord)localObject1).getHomeAccountId();
        Object localObject3 = ((AccountRecord)localObject1).getEnvironment();
        String str1 = localBrokerApplicationMetadata.getClientId();
        String str2 = ((AccountRecord)localObject1).getRealm();
        Object localObject4 = mFociCache.getAccountCredentialCache().getCredentialsFilteredBy((String)localObject2, (String)localObject3, CredentialType.RefreshToken, str1, null, null, null);
        Object localObject5 = mFociCache.getAccountCredentialCache().getCredentialsFilteredBy((String)localObject2, (String)localObject3, CredentialType.V1IdToken, str1, str2, null, null);
        localObject2 = mFociCache.getAccountCredentialCache().getCredentialsFilteredBy((String)localObject2, (String)localObject3, CredentialType.IdToken, str1, str2, null, null);
        if (!((List)localObject4).isEmpty())
        {
          localObject3 = new CacheRecord();
          ((CacheRecord)localObject3).setAccount((AccountRecord)localObject1);
          ((CacheRecord)localObject3).setRefreshToken((RefreshTokenRecord)((List)localObject4).get(0));
          if (!((List)localObject5).isEmpty())
          {
            localObject4 = a.a(new StringBuilder(), TAG, ":getFociCacheRecords");
            localObject1 = a.a("Found [");
            ((StringBuilder)localObject1).append(((List)localObject5).size());
            ((StringBuilder)localObject1).append("] V1IdTokens");
            Logger.verbose((String)localObject4, ((StringBuilder)localObject1).toString());
            ((CacheRecord)localObject3).setV1IdToken((IdTokenRecord)((List)localObject5).get(0));
          }
          else
          {
            a.c(new StringBuilder(), TAG, ":getFociCacheRecords", "No V1IdTokens exist for this account.");
          }
          if (!((List)localObject2).isEmpty())
          {
            localObject4 = a.a(new StringBuilder(), TAG, ":getFociCacheRecords");
            localObject5 = a.a("Found [");
            ((StringBuilder)localObject5).append(((List)localObject2).size());
            ((StringBuilder)localObject5).append("] IdTokens");
            Logger.verbose((String)localObject4, ((StringBuilder)localObject5).toString());
            ((CacheRecord)localObject3).setIdToken((IdTokenRecord)((List)localObject2).get(0));
          }
          else
          {
            a.c(new StringBuilder(), TAG, ":getFociCacheRecords", "No IdTokens exist for this account.");
          }
          localArrayList.add(localObject3);
        }
      }
    }
    return localArrayList;
  }
  
  public List<IdTokenRecord> getIdTokensForAccountRecord(String paramString, AccountRecord paramAccountRecord)
  {
    String str = paramAccountRecord.getEnvironment();
    if (paramString != null) {
      return getTokenCacheForClient(paramString, str, mCallingProcessUid).getIdTokensForAccountRecord(paramString, paramAccountRecord);
    }
    throw new UnsupportedOperationException("Aggregating IdTokens across ClientIds is not supported - do you have a feature request?");
  }
  
  public boolean isClientIdKnownToCache(String paramString)
  {
    return getAllClientIds().contains(paramString);
  }
  
  public ICacheRecord load(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    a.b(new StringBuilder(), TAG, ":load", "Performing lookup in app-specific cache.");
    Object localObject1 = mApplicationMetadataCache.getMetadata(paramString1, paramAccountRecord.getEnvironment(), mCallingProcessUid);
    boolean bool1 = true;
    boolean bool2;
    if (localObject1 != null)
    {
      if (((BrokerApplicationMetadata)localObject1).getFoci() != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localObject1 = a.a(new StringBuilder(), TAG, ":load");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("App is known foci? ");
      ((StringBuilder)localObject2).append(bool2);
      Logger.info((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    else
    {
      bool2 = false;
    }
    MsalOAuth2TokenCache localMsalOAuth2TokenCache = getTokenCacheForClient(paramString1, paramAccountRecord.getEnvironment(), mCallingProcessUid);
    if ((localMsalOAuth2TokenCache != null) && (!bool2)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    Object localObject2 = a.a(new StringBuilder(), TAG, ":load");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Loading from FOCI cache? [");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append("]");
    Logger.info((String)localObject2, ((StringBuilder)localObject1).toString());
    if (bool2) {
      paramString1 = mFociCache.loadByFamilyId(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme);
    } else {
      paramString1 = localMsalOAuth2TokenCache.load(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme);
    }
    if (paramString1.getRefreshToken() != null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    paramAccountRecord = a.a(new StringBuilder(), TAG, ":load");
    paramString2 = new StringBuilder();
    paramString2.append("Result found? [");
    paramString2.append(bool2);
    paramString2.append("]");
    Logger.verbose(paramAccountRecord, paramString2.toString());
    return paramString1;
  }
  
  public List<ICacheRecord> loadWithAggregatedAccountData(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    try
    {
      Object localObject1 = mApplicationMetadataCache.getMetadata(paramString1, paramAccountRecord.getEnvironment(), mCallingProcessUid);
      boolean bool1 = true;
      boolean bool2;
      if (localObject1 != null)
      {
        if (((BrokerApplicationMetadata)localObject1).getFoci() != null) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append(TAG);
        ((StringBuilder)localObject1).append(":loadWithAggregatedAccountData");
        localObject2 = ((StringBuilder)localObject1).toString();
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("App is known foci? ");
        ((StringBuilder)localObject1).append(bool2);
        Logger.info((String)localObject2, ((StringBuilder)localObject1).toString());
      }
      else
      {
        bool2 = false;
      }
      localObject1 = getTokenCacheForClient(paramString1, paramAccountRecord.getEnvironment(), mCallingProcessUid);
      int i;
      if (localObject1 == null) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(":loadWithAggregatedAccountData");
      String str = ((StringBuilder)localObject2).toString();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("Loading from FOCI cache? [");
      boolean bool3;
      if ((!bool2) && (i == 0)) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      ((StringBuilder)localObject2).append(bool3);
      ((StringBuilder)localObject2).append("]");
      Logger.info(str, ((StringBuilder)localObject2).toString());
      if (i != 0)
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        ((ArrayList)localObject1).add(mFociCache.loadByFamilyId(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme));
        paramString1 = (String)localObject1;
      }
      else if (bool2)
      {
        paramString1 = mFociCache.loadByFamilyIdWithAggregatedAccountData(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme);
      }
      else
      {
        paramString1 = ((MsalOAuth2TokenCache)localObject1).loadWithAggregatedAccountData(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme);
      }
      if ((!paramString1.isEmpty()) && (((ICacheRecord)paramString1.get(0)).getRefreshToken() != null)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>();
      paramString2.append(TAG);
      paramString2.append(":loadWithAggregatedAccountData");
      paramString2 = paramString2.toString();
      paramAccountRecord = new java/lang/StringBuilder;
      paramAccountRecord.<init>();
      paramAccountRecord.append("Result found? [");
      paramAccountRecord.append(bool2);
      paramAccountRecord.append("]");
      Logger.verbose(paramString2, paramAccountRecord.toString());
      return paramString1;
    }
    finally {}
  }
  
  public AccountDeletionRecord removeAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return removeAccountInternal(paramString1, paramString2, paramString3, paramString4, false);
  }
  
  public AccountDeletionRecord removeAccountFromDevice(AccountRecord paramAccountRecord)
  {
    if (paramAccountRecord != null)
    {
      Object localObject1 = mApplicationMetadataCache.getAllClientIds();
      String str = a.a(new StringBuilder(), TAG, ":removeAccountFromDevice");
      Object localObject2 = a.a("Found [");
      ((StringBuilder)localObject2).append(((Set)localObject1).size());
      ((StringBuilder)localObject2).append("] client ids.");
      Logger.info(str, ((StringBuilder)localObject2).toString());
      localObject2 = new ArrayList();
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        ((ArrayList)localObject2).add(removeAccountInternal(paramAccountRecord.getEnvironment(), str, paramAccountRecord.getHomeAccountId(), null, true));
      }
      paramAccountRecord = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramAccountRecord.addAll((AccountDeletionRecord)((Iterator)localObject2).next());
      }
      localObject1 = a.a(new StringBuilder(), TAG, ":removeAccountFromDevice");
      localObject2 = a.a("Deleted [");
      ((StringBuilder)localObject2).append(paramAccountRecord.size());
      ((StringBuilder)localObject2).append("] AccountRecords.");
      Logger.info((String)localObject1, ((StringBuilder)localObject2).toString());
      return new AccountDeletionRecord(paramAccountRecord);
    }
    paramAccountRecord = new StringBuilder();
    paramAccountRecord.append(TAG);
    paramAccountRecord.append(":removeAccountFromDevice");
    Logger.error(paramAccountRecord.toString(), "Illegal arg. Cannot delete a null AccountRecord!", null);
    throw new IllegalArgumentException("AccountRecord may not be null.");
  }
  
  public boolean removeCredential(Credential paramCredential)
  {
    Object localObject = getTokenCacheForClient(paramCredential.getClientId(), paramCredential.getEnvironment(), mCallingProcessUid);
    boolean bool;
    if (localObject != null)
    {
      bool = ((MsalOAuth2TokenCache)localObject).removeCredential(paramCredential);
    }
    else
    {
      a.c(new StringBuilder(), TAG, ":removeCredential", "Could not remove credential. Cache not found.");
      bool = false;
    }
    localObject = a.a(new StringBuilder(), TAG, ":removeCredential");
    paramCredential = new StringBuilder();
    paramCredential.append("Credential removed? [");
    paramCredential.append(bool);
    paramCredential.append("]");
    Logger.verbose((String)localObject, paramCredential.toString());
    return bool;
  }
  
  public ICacheRecord save(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord)
  {
    throw new UnsupportedOperationException("This method is unsupported.");
  }
  
  public ICacheRecord save(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord, AccessTokenRecord paramAccessTokenRecord, String paramString)
  {
    boolean bool = StringExtensions.isNullOrBlank(paramString) ^ true;
    Object localObject1 = a.a(new StringBuilder(), TAG, ":save");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Saving to FOCI cache? [");
    ((StringBuilder)localObject2).append(bool);
    ((StringBuilder)localObject2).append("]");
    Logger.info((String)localObject1, ((StringBuilder)localObject2).toString());
    if (bool)
    {
      paramAccountRecord = mFociCache.save(paramAccountRecord, paramIdTokenRecord, paramAccessTokenRecord);
    }
    else
    {
      localObject2 = getTokenCacheForClient(paramIdTokenRecord.getClientId(), paramIdTokenRecord.getEnvironment(), mCallingProcessUid);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(TAG);
        ((StringBuilder)localObject1).append(":save");
        Logger.warn(((StringBuilder)localObject1).toString(), "Existing cache not found. A new one will be created.");
        localObject1 = initializeProcessUidCache(getContext(), mCallingProcessUid);
      }
      paramAccountRecord = ((MsalOAuth2TokenCache)localObject1).save(paramAccountRecord, paramIdTokenRecord, paramAccessTokenRecord);
    }
    updateApplicationMetadataCache(paramAccountRecord.getAccessToken().getClientId(), paramAccountRecord.getAccessToken().getEnvironment(), paramString, mCallingProcessUid);
    return paramAccountRecord;
  }
  
  public ICacheRecord save(GenericOAuth2Strategy paramGenericOAuth2Strategy, GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericTokenResponse paramGenericTokenResponse)
  {
    boolean bool = StringExtensions.isNullOrBlank(paramGenericTokenResponse.getFamilyId()) ^ true;
    if (bool)
    {
      localObject1 = a.a(new StringBuilder(), TAG, ":save");
      localObject2 = a.a("Received FOCI value: [");
      ((StringBuilder)localObject2).append(paramGenericTokenResponse.getFamilyId());
      ((StringBuilder)localObject2).append("]");
      Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = a.a(new StringBuilder(), TAG, ":save");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Saving to FOCI cache? [");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append("]");
    Logger.info((String)localObject2, ((StringBuilder)localObject1).toString());
    if (bool)
    {
      localObject2 = mFociCache;
    }
    else
    {
      localObject1 = getTokenCacheForClient(paramGenericAuthorizationRequest.getClientId(), paramGenericOAuth2Strategy.getIssuerCacheIdentifier(paramGenericAuthorizationRequest), mCallingProcessUid);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(TAG);
        ((StringBuilder)localObject2).append(":save");
        Logger.warn(((StringBuilder)localObject2).toString(), "Existing cache not found. A new one will be created.");
        localObject2 = initializeProcessUidCache(getContext(), mCallingProcessUid);
      }
    }
    paramGenericOAuth2Strategy = ((MsalOAuth2TokenCache)localObject2).save(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse);
    updateApplicationMetadataCache(paramGenericOAuth2Strategy.getRefreshToken().getClientId(), paramGenericOAuth2Strategy.getRefreshToken().getEnvironment(), paramGenericOAuth2Strategy.getRefreshToken().getFamilyId(), mCallingProcessUid);
    return paramGenericOAuth2Strategy;
  }
  
  /* Error */
  public List<ICacheRecord> saveAndLoadAggregatedAccountData(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord, AccessTokenRecord paramAccessTokenRecord, String paramString, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: aload_2
    //   7: aload_3
    //   8: aload 4
    //   10: invokevirtual 578	com/microsoft/identity/common/internal/cache/BrokerOAuth2TokenCache:save	(Lcom/microsoft/identity/common/internal/dto/AccountRecord;Lcom/microsoft/identity/common/internal/dto/IdTokenRecord;Lcom/microsoft/identity/common/internal/dto/AccessTokenRecord;Ljava/lang/String;)Lcom/microsoft/identity/common/internal/cache/ICacheRecord;
    //   13: astore_3
    //   14: aload_3
    //   15: invokeinterface 548 1 0
    //   20: invokevirtual 515	com/microsoft/identity/common/internal/dto/Credential:getClientId	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_3
    //   25: invokeinterface 548 1 0
    //   30: invokevirtual 583	com/microsoft/identity/common/internal/dto/AccessTokenRecord:getTarget	()Ljava/lang/String;
    //   33: astore_2
    //   34: aload_0
    //   35: aload_1
    //   36: aload_3
    //   37: invokeinterface 548 1 0
    //   42: invokevirtual 516	com/microsoft/identity/common/internal/dto/Credential:getEnvironment	()Ljava/lang/String;
    //   45: aload_0
    //   46: getfield 65	com/microsoft/identity/common/internal/cache/BrokerOAuth2TokenCache:mCallingProcessUid	I
    //   49: invokespecial 180	com/microsoft/identity/common/internal/cache/BrokerOAuth2TokenCache:getTokenCacheForClient	(Ljava/lang/String;Ljava/lang/String;I)Lcom/microsoft/identity/common/internal/cache/MsalOAuth2TokenCache;
    //   52: aload_1
    //   53: aload_2
    //   54: aload_3
    //   55: invokeinterface 586 1 0
    //   60: aload 5
    //   62: invokevirtual 488	com/microsoft/identity/common/internal/cache/MsalOAuth2TokenCache:loadWithAggregatedAccountData	(Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/common/internal/dto/AccountRecord;Lcom/microsoft/identity/common/internal/authscheme/AbstractAuthenticationScheme;)Ljava/util/List;
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: areturn
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	BrokerOAuth2TokenCache
    //   0	82	1	paramAccountRecord	AccountRecord
    //   0	82	2	paramIdTokenRecord	IdTokenRecord
    //   0	82	3	paramAccessTokenRecord	AccessTokenRecord
    //   0	82	4	paramString	String
    //   0	82	5	paramAbstractAuthenticationScheme	AbstractAuthenticationScheme
    // Exception table:
    //   from	to	target	type
    //   4	68	72	finally
    //   73	75	72	finally
    //   2	4	77	finally
    //   75	77	77	finally
  }
  
  public List<ICacheRecord> saveAndLoadAggregatedAccountData(GenericOAuth2Strategy paramGenericOAuth2Strategy, GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericTokenResponse paramGenericTokenResponse)
  {
    try
    {
      boolean bool;
      if (!StringExtensions.isNullOrBlank(paramGenericTokenResponse.getFamilyId())) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append(":saveAndLoadAggregatedAccountData");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("Saving to FOCI cache? [");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("]");
      Logger.info((String)localObject1, ((StringBuilder)localObject2).toString());
      if (bool)
      {
        localObject1 = mFociCache;
      }
      else
      {
        localObject2 = getTokenCacheForClient(paramGenericAuthorizationRequest.getClientId(), paramGenericOAuth2Strategy.getIssuerCacheIdentifier(paramGenericAuthorizationRequest), mCallingProcessUid);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append(TAG);
          ((StringBuilder)localObject1).append(":saveAndLoadAggregatedAccountData");
          Logger.warn(((StringBuilder)localObject1).toString(), "Existing cache not found. A new one will be created.");
          localObject1 = initializeProcessUidCache(getContext(), mCallingProcessUid);
        }
      }
      paramGenericAuthorizationRequest = ((MsalOAuth2TokenCache)localObject1).saveAndLoadAggregatedAccountData(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse);
      paramGenericOAuth2Strategy = (ICacheRecord)paramGenericAuthorizationRequest.get(0);
      updateApplicationMetadataCache(paramGenericOAuth2Strategy.getRefreshToken().getClientId(), paramGenericOAuth2Strategy.getRefreshToken().getEnvironment(), paramGenericOAuth2Strategy.getRefreshToken().getFamilyId(), mCallingProcessUid);
      return paramGenericAuthorizationRequest;
    }
    finally {}
  }
  
  public void setSingleSignOnState(String paramString, GenericAccount paramGenericAccount, GenericRefreshToken paramGenericRefreshToken)
  {
    boolean bool = paramGenericRefreshToken.getIsFamilyRefreshToken();
    int i = Integer.valueOf(paramString).intValue();
    if (bool)
    {
      a.b(new StringBuilder(), TAG, ":setSingleSignOnState", "Saving tokens to foci cache.");
      paramString = mFociCache;
    }
    else
    {
      MsalOAuth2TokenCache localMsalOAuth2TokenCache = getTokenCacheForClient(paramGenericRefreshToken.getClientId(), paramGenericRefreshToken.getEnvironment(), mCallingProcessUid);
      paramString = localMsalOAuth2TokenCache;
      if (localMsalOAuth2TokenCache == null)
      {
        paramString = new StringBuilder();
        paramString.append(TAG);
        paramString.append(":setSingleSignOnState");
        Logger.verbose(paramString.toString(), "Existing cache could not be found. Creating a new one...");
        paramString = initializeProcessUidCache(getContext(), i);
      }
    }
    try
    {
      paramString.setSingleSignOnState(paramGenericAccount, paramGenericRefreshToken);
      updateApplicationMetadataCache(paramGenericRefreshToken.getClientId(), paramGenericRefreshToken.getEnvironment(), paramGenericRefreshToken.getFamilyId(), i);
    }
    catch (ClientException paramString)
    {
      a.c(new StringBuilder(), TAG, ":setSingleSignOnState", "Failed to save account/refresh token. Skipping.");
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.BrokerOAuth2TokenCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */