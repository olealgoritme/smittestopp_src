package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.adal.internal.cache.StorageHelper;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.authscheme.AbstractAuthenticationScheme;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.dto.IRefreshTokenRecord;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResponse;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.CacheEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.CacheStartEvent;
import e.a.a.a.a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MsalOAuth2TokenCache<GenericOAuth2Strategy extends OAuth2Strategy, GenericAuthorizationRequest extends AuthorizationRequest, GenericTokenResponse extends TokenResponse, GenericAccount extends BaseAccount, GenericRefreshToken extends RefreshToken>
  extends OAuth2TokenCache<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse>
  implements IShareSingleSignOnState<GenericAccount, GenericRefreshToken>
{
  public static final String TAG = "MsalOAuth2TokenCache";
  public final IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> mAccountCredentialAdapter;
  public IAccountCredentialCache mAccountCredentialCache;
  
  public MsalOAuth2TokenCache(Context paramContext, IAccountCredentialCache paramIAccountCredentialCache, IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> paramIAccountCredentialAdapter)
  {
    super(paramContext);
    paramContext = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(paramContext, localStringBuilder.toString());
    mAccountCredentialCache = paramIAccountCredentialCache;
    mAccountCredentialAdapter = paramIAccountCredentialAdapter;
  }
  
  private boolean accountHasCredential(AccountRecord paramAccountRecord, List<Credential> paramList)
  {
    String str = paramAccountRecord.getHomeAccountId();
    paramAccountRecord = paramAccountRecord.getEnvironment();
    Object localObject = a.a(new StringBuilder(), TAG, ":accountHasCredential");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomeAccountId: [");
    localStringBuilder.append(str);
    localStringBuilder.append("]\nEnvironment: [");
    localStringBuilder.append(paramAccountRecord);
    localStringBuilder.append("]");
    Logger.verbosePII((String)localObject, localStringBuilder.toString());
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (Credential)((Iterator)localObject).next();
      if ((str.equals(paramList.getHomeAccountId())) && (paramAccountRecord.equals(paramList.getEnvironment())))
      {
        paramAccountRecord = new StringBuilder();
        paramAccountRecord.append(TAG);
        paramAccountRecord.append(":accountHasCredential");
        Logger.info(paramAccountRecord.toString(), "Credentials located for account.");
        return true;
      }
    }
    return false;
  }
  
  public static MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> create(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append(":create");
    Logger.verbose(localStringBuilder.toString(), "Creating MsalOAuth2TokenCache");
    return new MsalOAuth2TokenCache(paramContext, new SharedPreferencesAccountCredentialCache(new CacheKeyValueDelegate(), new SharedPreferencesFileManager(paramContext, "com.microsoft.identity.client.account_credential_cache", new StorageHelper(paramContext))), new MicrosoftStsAccountCredentialAdapter());
  }
  
  private void deleteAccessTokensWithIntersectingScopes(AccessTokenRecord paramAccessTokenRecord)
  {
    Object localObject1 = mAccountCredentialCache.getCredentialsFilteredBy(paramAccessTokenRecord.getHomeAccountId(), paramAccessTokenRecord.getEnvironment(), CredentialType.fromString(paramAccessTokenRecord.getCredentialType()), paramAccessTokenRecord.getClientId(), paramAccessTokenRecord.getRealm(), null, paramAccessTokenRecord.getAccessTokenType());
    Object localObject2 = a.a(new StringBuilder(), TAG, ":", "deleteAccessTokensWithIntersectingScopes");
    StringBuilder localStringBuilder = a.a("Inspecting ");
    localStringBuilder.append(((List)localObject1).size());
    localStringBuilder.append(" accessToken[s].");
    Logger.verbose((String)localObject2, localStringBuilder.toString());
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Credential localCredential = (Credential)((Iterator)localObject2).next();
      if (scopesIntersect(paramAccessTokenRecord, (AccessTokenRecord)localCredential, true))
      {
        localObject1 = a.a(new StringBuilder(), TAG, ":", "deleteAccessTokensWithIntersectingScopes");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Removing credential: ");
        localStringBuilder.append(localCredential);
        Logger.infoPII((String)localObject1, localStringBuilder.toString());
        mAccountCredentialCache.removeCredential(localCredential);
      }
    }
  }
  
  private CredentialType getAccessTokenCredentialTypeForAuthenticationScheme(AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    if ("Bearer".equalsIgnoreCase(paramAbstractAuthenticationScheme.getName())) {
      return CredentialType.AccessToken;
    }
    return CredentialType.AccessToken_With_AuthScheme;
  }
  
  private boolean isAccessTokenSchemaCompliant(AccessTokenRecord paramAccessTokenRecord)
  {
    String str1 = paramAccessTokenRecord.getCredentialType();
    String str2 = paramAccessTokenRecord.getHomeAccountId();
    String str3 = paramAccessTokenRecord.getEnvironment();
    String str4 = paramAccessTokenRecord.getClientId();
    String[] arrayOfString = { "target", paramAccessTokenRecord.getTarget() };
    String str5 = paramAccessTokenRecord.getCachedAt();
    String str6 = paramAccessTokenRecord.getExpiresOn();
    paramAccessTokenRecord = paramAccessTokenRecord.getSecret();
    return isSchemaCompliant(AccessTokenRecord.class, new String[][] { { "credential_type", str1 }, { "home_account_id", str2 }, { "environment", str3 }, { "client_id", str4 }, arrayOfString, { "cached_at", str5 }, { "expires_on", str6 }, { "secret", paramAccessTokenRecord } });
  }
  
  private boolean isAccountSchemaCompliant(AccountRecord paramAccountRecord)
  {
    return isSchemaCompliant(AccountRecord.class, new String[][] { { "home_account_id", paramAccountRecord.getHomeAccountId() }, { "environment", paramAccountRecord.getEnvironment() }, { "local_account_id", paramAccountRecord.getLocalAccountId() }, { "username", paramAccountRecord.getUsername() }, { "authority_type", paramAccountRecord.getAuthorityType() } });
  }
  
  private boolean isIdTokenSchemaCompliant(IdTokenRecord paramIdTokenRecord)
  {
    String str = paramIdTokenRecord.getHomeAccountId();
    String[] arrayOfString1 = { "environment", paramIdTokenRecord.getEnvironment() };
    String[] arrayOfString2 = { "credential_type", paramIdTokenRecord.getCredentialType() };
    String[] arrayOfString3 = { "client_id", paramIdTokenRecord.getClientId() };
    paramIdTokenRecord = new String[] { "secret", paramIdTokenRecord.getSecret() };
    return isSchemaCompliant(IdTokenRecord.class, new String[][] { { "home_account_id", str }, arrayOfString1, arrayOfString2, arrayOfString3, paramIdTokenRecord });
  }
  
  private boolean isRefreshTokenSchemaCompliant(RefreshTokenRecord paramRefreshTokenRecord)
  {
    return isSchemaCompliant(RefreshTokenRecord.class, new String[][] { { "credential_type", paramRefreshTokenRecord.getCredentialType() }, { "environment", paramRefreshTokenRecord.getEnvironment() }, { "home_account_id", paramRefreshTokenRecord.getHomeAccountId() }, { "client_id", paramRefreshTokenRecord.getClientId() }, { "secret", paramRefreshTokenRecord.getSecret() } });
  }
  
  public static boolean isSchemaCompliant(Class<?> paramClass, String[][] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = 0;
    boolean bool = true;
    Object localObject1;
    while (j < i)
    {
      localObject1 = paramArrayOfString[j];
      if ((bool) && (!StringExtensions.isNullOrBlank(localObject1[1]))) {
        bool = true;
      } else {
        bool = false;
      }
      j++;
    }
    if (!bool)
    {
      localObject1 = a.a(new StringBuilder(), TAG, ":", "isSchemaCompliant");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramClass.getSimpleName());
      ((StringBuilder)localObject2).append(" does not contain all required fields.");
      Logger.warn((String)localObject1, ((StringBuilder)localObject2).toString());
      i = paramArrayOfString.length;
      for (j = 0; j < i; j++)
      {
        paramClass = paramArrayOfString[j];
        localObject2 = a.a(new StringBuilder(), TAG, ":", "isSchemaCompliant");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramClass[0]);
        ((StringBuilder)localObject1).append(" is null? [");
        ((StringBuilder)localObject1).append(StringExtensions.isNullOrBlank(paramClass[1]));
        ((StringBuilder)localObject1).append("]");
        Logger.warn((String)localObject2, ((StringBuilder)localObject1).toString());
      }
    }
    return bool;
  }
  
  private List<ICacheRecord> mergeCacheRecordWithOtherTenantCacheRecords(ICacheRecord paramICacheRecord)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramICacheRecord);
    Object localObject = new ArrayList(getAllTenantAccountsForAccountByClientId(paramICacheRecord.getRefreshToken().getClientId(), paramICacheRecord.getAccount()));
    if (!((ArrayList)localObject).isEmpty())
    {
      ((ArrayList)localObject).remove(0);
      Iterator localIterator = ((ArrayList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (AccountRecord)localIterator.next();
        localArrayList.add(getSparseCacheRecordForAccount(paramICacheRecord.getRefreshToken().getClientId(), (AccountRecord)localObject));
      }
    }
    return localArrayList;
  }
  
  private int removeCredentialsOfTypeForAccount(String paramString1, String paramString2, CredentialType paramCredentialType, AccountRecord paramAccountRecord, boolean paramBoolean)
  {
    IAccountCredentialCache localIAccountCredentialCache = mAccountCredentialCache;
    String str = paramAccountRecord.getHomeAccountId();
    if (paramBoolean) {
      paramAccountRecord = null;
    } else {
      paramAccountRecord = paramAccountRecord.getRealm();
    }
    paramString1 = localIAccountCredentialCache.getCredentialsFilteredBy(str, paramString1, paramCredentialType, paramString2, paramAccountRecord, null, null).iterator();
    int i = 0;
    while (paramString1.hasNext())
    {
      paramString2 = (Credential)paramString1.next();
      if (mAccountCredentialCache.removeCredential(paramString2)) {
        i++;
      }
    }
    return i;
  }
  
  private int removeRefreshTokensForAccount(AccountRecord paramAccountRecord, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {
      paramString2 = null;
    }
    return removeCredentialsOfTypeForAccount(paramString1, paramString2, CredentialType.RefreshToken, paramAccountRecord, true);
  }
  
  private void saveAccounts(AccountRecord... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      AccountRecord localAccountRecord = paramVarArgs[j];
      mAccountCredentialCache.saveAccount(localAccountRecord);
    }
  }
  
  private Set<String> scopesAsSet(AccessTokenRecord paramAccessTokenRecord)
  {
    HashSet localHashSet = new HashSet();
    paramAccessTokenRecord = paramAccessTokenRecord.getTarget();
    if (!StringExtensions.isNullOrBlank(paramAccessTokenRecord)) {
      localHashSet.addAll(Arrays.asList(paramAccessTokenRecord.split("\\s+")));
    }
    return localHashSet;
  }
  
  private boolean scopesIntersect(AccessTokenRecord paramAccessTokenRecord1, AccessTokenRecord paramAccessTokenRecord2, boolean paramBoolean)
  {
    paramAccessTokenRecord1 = scopesAsSet(paramAccessTokenRecord1);
    paramAccessTokenRecord2 = scopesAsSet(paramAccessTokenRecord2);
    if (paramBoolean)
    {
      paramAccessTokenRecord1.removeAll(BaseController.DEFAULT_SCOPES);
      paramAccessTokenRecord2.removeAll(BaseController.DEFAULT_SCOPES);
    }
    boolean bool = false;
    Object localObject = paramAccessTokenRecord2.iterator();
    do
    {
      paramBoolean = bool;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramAccessTokenRecord2 = (String)((Iterator)localObject).next();
    } while (!paramAccessTokenRecord1.contains(paramAccessTokenRecord2));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append("scopesIntersect");
    Logger.info(((StringBuilder)localObject).toString(), "Scopes intersect.");
    String str = a.a(new StringBuilder(), TAG, ":", "scopesIntersect");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAccessTokenRecord1.toString());
    ((StringBuilder)localObject).append(" contains [");
    ((StringBuilder)localObject).append(paramAccessTokenRecord2);
    ((StringBuilder)localObject).append("]");
    Logger.infoPII(str, ((StringBuilder)localObject).toString());
    paramBoolean = true;
    return paramBoolean;
  }
  
  private void setToCacheRecord(CacheRecord paramCacheRecord, IdTokenRecord paramIdTokenRecord)
  {
    Object localObject = CredentialType.fromString(paramIdTokenRecord.getCredentialType());
    if (localObject != null) {
      if (CredentialType.V1IdToken == localObject)
      {
        paramCacheRecord.setV1IdToken(paramIdTokenRecord);
      }
      else if (CredentialType.IdToken == localObject)
      {
        paramCacheRecord.setIdToken(paramIdTokenRecord);
      }
      else
      {
        paramCacheRecord = a.a(new StringBuilder(), TAG, ":setToCacheRecord");
        localObject = a.a("Unrecognized IdToken type: ");
        ((StringBuilder)localObject).append(paramIdTokenRecord.getCredentialType());
        Logger.warn(paramCacheRecord, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void clearAll()
  {
    a.c(new StringBuilder(), TAG, ":clearAll", "Clearing cache.");
    mAccountCredentialCache.clearAll();
  }
  
  public AccountRecord getAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = a.a(new StringBuilder(), TAG, ":getAccount");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Environment: [");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("]\nClientId: [");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]\nHomeAccountId: [");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("]\nRealm: [");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("]");
    Logger.verbosePII(str, localStringBuilder.toString());
    paramString2 = getAccounts(paramString1, paramString2);
    paramString1 = a.a(new StringBuilder(), TAG, ":getAccount");
    localStringBuilder = a.a("Found ");
    localStringBuilder.append(paramString2.size());
    localStringBuilder.append(" accounts");
    Logger.info(paramString1, localStringBuilder.toString());
    paramString1 = paramString2.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (AccountRecord)paramString1.next();
      if ((paramString3.equals(paramString2.getHomeAccountId())) && ((paramString4 == null) || (paramString4.equals(paramString2.getRealm())))) {
        return paramString2;
      }
    }
    a.c(new StringBuilder(), TAG, ":getAccount", "No matching account found.");
    return null;
  }
  
  public AccountRecord getAccountByHomeAccountId(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = getAccounts(paramString1, paramString2);
    String str = a.a(new StringBuilder(), TAG, ":getAccountByHomeAccountId");
    paramString1 = new StringBuilder();
    paramString1.append("homeAccountId: [");
    paramString1.append(paramString3);
    paramString1.append("]");
    Logger.verbosePII(str, paramString1.toString());
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      paramString1 = (AccountRecord)paramString2.next();
      if (paramString3.equals(paramString1.getHomeAccountId())) {
        return paramString1;
      }
    }
    return null;
  }
  
  public AccountRecord getAccountByLocalAccountId(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getAccounts(paramString1, paramString2);
    paramString2 = a.a(new StringBuilder(), TAG, ":getAccountByLocalAccountId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocalAccountId: [");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("]");
    Logger.verbosePII(paramString2, localStringBuilder.toString());
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (AccountRecord)paramString1.next();
      if (paramString3.equals(paramString2.getLocalAccountId())) {
        return paramString2;
      }
    }
    return null;
  }
  
  public IAccountCredentialAdapter<GenericOAuth2Strategy, GenericAuthorizationRequest, GenericTokenResponse, GenericAccount, GenericRefreshToken> getAccountCredentialAdapter()
  {
    return mAccountCredentialAdapter;
  }
  
  public IAccountCredentialCache getAccountCredentialCache()
  {
    return mAccountCredentialCache;
  }
  
  public ICacheRecord getAccountWithAggregatedAccountDataByLocalAccountId(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getAccountByLocalAccountId(paramString1, paramString2, paramString3);
    if (paramString1 != null)
    {
      paramString3 = getIdTokensForAccountRecord(paramString2, paramString1);
      paramString2 = new CacheRecord();
      paramString2.setAccount(paramString1);
      paramString3 = paramString3.iterator();
      for (;;)
      {
        paramString1 = paramString2;
        if (!paramString3.hasNext()) {
          break;
        }
        setToCacheRecord(paramString2, (IdTokenRecord)paramString3.next());
      }
    }
    paramString1 = null;
    return paramString1;
  }
  
  public List<AccountRecord> getAccounts(String paramString1, String paramString2)
  {
    Object localObject1 = a.a(new StringBuilder(), TAG, ":getAccounts");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Environment: [");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("]\nClientId: [");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("]");
    Logger.verbosePII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new ArrayList();
    List localList = mAccountCredentialCache.getAccountsFilteredBy(null, paramString1, null);
    localObject1 = a.a(new StringBuilder(), TAG, ":getAccounts");
    StringBuilder localStringBuilder = a.a("Found ");
    localStringBuilder.append(localList.size());
    localStringBuilder.append(" accounts for this environment");
    Logger.verbose((String)localObject1, localStringBuilder.toString());
    localObject1 = mAccountCredentialCache.getCredentialsFilteredBy(null, paramString1, CredentialType.IdToken, paramString2, null, null, null);
    ((List)localObject1).addAll(mAccountCredentialCache.getCredentialsFilteredBy(null, paramString1, CredentialType.V1IdToken, paramString2, null, null, null));
    paramString2 = localList.iterator();
    while (paramString2.hasNext())
    {
      paramString1 = (AccountRecord)paramString2.next();
      if (accountHasCredential(paramString1, (List)localObject1)) {
        ((ArrayList)localObject2).add(paramString1);
      }
    }
    paramString2 = a.a(new StringBuilder(), TAG, ":getAccounts");
    paramString1 = a.a("Found ");
    paramString1.append(((ArrayList)localObject2).size());
    paramString1.append(" accounts for this clientId");
    Logger.verbose(paramString2, paramString1.toString());
    return Collections.unmodifiableList((List)localObject2);
  }
  
  public List<AccountRecord> getAccountsByUsername(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = getAccounts(paramString1, paramString2);
    Iterator localIterator = paramString1.iterator();
    while (localIterator.hasNext())
    {
      paramString2 = (AccountRecord)localIterator.next();
      if (paramString2.getUsername().equalsIgnoreCase(paramString3)) {
        localArrayList.add(paramString2);
      }
    }
    paramString3 = a.a(new StringBuilder(), TAG, ":getAccountsByUsername");
    paramString2 = a.a("Found ");
    paramString2.append(paramString1.size());
    paramString2.append(" accounts matching username.");
    Logger.verbose(paramString3, paramString2.toString());
    return localArrayList;
  }
  
  public List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = getAccounts(paramString1, paramString2).iterator();
    while (paramString1.hasNext())
    {
      AccountRecord localAccountRecord = (AccountRecord)paramString1.next();
      Object localObject = getIdTokensForAccountRecord(paramString2, localAccountRecord);
      CacheRecord localCacheRecord = new CacheRecord();
      localCacheRecord.setAccount(localAccountRecord);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        setToCacheRecord(localCacheRecord, (IdTokenRecord)((Iterator)localObject).next());
      }
      localArrayList.add(localCacheRecord);
    }
    paramString2 = a.a(new StringBuilder(), TAG, ":getAccountsWithAggregatedAccountData");
    paramString1 = a.a("Found ");
    paramString1.append(localArrayList.size());
    paramString1.append(" accounts with IdTokens");
    Logger.verbose(paramString2, paramString1.toString());
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<ICacheRecord> getAccountsWithAggregatedAccountData(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = getAccount(paramString1, paramString2, paramString3, null);
    if (paramString1 != null)
    {
      paramString1 = getAllTenantAccountsForAccountByClientId(paramString2, paramString1).iterator();
      while (paramString1.hasNext()) {
        localArrayList.add(getSparseCacheRecordForAccount(paramString2, (AccountRecord)paramString1.next()));
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Set<String> getAllClientIds()
  {
    HashSet localHashSet = new HashSet();
    Object localObject = mAccountCredentialCache.getCredentials().iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet.add(((Credential)((Iterator)localObject).next()).getClientId());
    }
    localObject = a.a(new StringBuilder(), TAG, ":getAllClientIds");
    StringBuilder localStringBuilder = a.a("Found [");
    localStringBuilder.append(localHashSet.size());
    localStringBuilder.append("] clientIds/");
    Logger.verbose((String)localObject, localStringBuilder.toString());
    return localHashSet;
  }
  
  public List<AccountRecord> getAllTenantAccountsForAccountByClientId(String paramString, AccountRecord paramAccountRecord)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAccountRecord);
    List localList = mAccountCredentialCache.getAccountsFilteredBy(paramAccountRecord.getHomeAccountId(), paramAccountRecord.getEnvironment(), null);
    Iterator localIterator = getAccounts(paramAccountRecord.getEnvironment(), paramString).iterator();
    while (localIterator.hasNext())
    {
      paramString = (AccountRecord)localIterator.next();
      if ((localList.contains(paramString)) && (!paramAccountRecord.equals(paramString))) {
        localArrayList.add(paramString);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<IdTokenRecord> getIdTokensForAccountRecord(String paramString, AccountRecord paramAccountRecord)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = mAccountCredentialCache.getCredentialsFilteredBy(paramAccountRecord.getHomeAccountId(), paramAccountRecord.getEnvironment(), CredentialType.IdToken, paramString, paramAccountRecord.getRealm(), null, null);
    localList.addAll(mAccountCredentialCache.getCredentialsFilteredBy(paramAccountRecord.getHomeAccountId(), paramAccountRecord.getEnvironment(), CredentialType.V1IdToken, paramString, paramAccountRecord.getRealm(), null, null));
    paramString = localList.iterator();
    while (paramString.hasNext())
    {
      paramAccountRecord = (Credential)paramString.next();
      if ((paramAccountRecord instanceof IdTokenRecord)) {
        localArrayList.add((IdTokenRecord)paramAccountRecord);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public GenericRefreshToken getSingleSignOnState(GenericAccount paramGenericAccount)
  {
    throw new UnsupportedOperationException("Unimplemented!");
  }
  
  public ICacheRecord getSparseCacheRecordForAccount(String paramString, AccountRecord paramAccountRecord)
  {
    paramString = getIdTokensForAccountRecord(paramString, paramAccountRecord);
    if (paramString.size() > CredentialType.ID_TOKEN_TYPES.length)
    {
      String str = a.a(new StringBuilder(), TAG, ":getSparseCacheRecordForAccount");
      localObject = a.a("Found more IdTokens than expected.\nFound: [");
      ((StringBuilder)localObject).append(paramString.size());
      ((StringBuilder)localObject).append("]");
      Logger.warn(str, ((StringBuilder)localObject).toString());
    }
    Object localObject = new CacheRecord();
    ((CacheRecord)localObject).setAccount(paramAccountRecord);
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      setToCacheRecord((CacheRecord)localObject, (IdTokenRecord)paramString.next());
    }
    return (ICacheRecord)localObject;
  }
  
  public ICacheRecord load(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    Telemetry.emit(new CacheStartEvent());
    boolean bool = "MSSTS".equals(paramAccountRecord.getAuthorityType());
    List localList = mAccountCredentialCache.getCredentialsFilteredBy(paramAccountRecord.getHomeAccountId(), paramAccountRecord.getEnvironment(), getAccessTokenCredentialTypeForAuthenticationScheme(paramAbstractAuthenticationScheme), paramString1, paramAccountRecord.getRealm(), paramString2, paramAbstractAuthenticationScheme.getName());
    IAccountCredentialCache localIAccountCredentialCache = mAccountCredentialCache;
    String str = paramAccountRecord.getHomeAccountId();
    Object localObject1 = paramAccountRecord.getEnvironment();
    Object localObject2 = CredentialType.RefreshToken;
    Object localObject3 = null;
    if (bool) {
      paramAbstractAuthenticationScheme = null;
    } else {
      paramAbstractAuthenticationScheme = paramAccountRecord.getRealm();
    }
    if (bool) {
      paramString2 = null;
    }
    localObject1 = localIAccountCredentialCache.getCredentialsFilteredBy(str, (String)localObject1, (CredentialType)localObject2, paramString1, paramAbstractAuthenticationScheme, paramString2, null);
    localObject2 = mAccountCredentialCache.getCredentialsFilteredBy(paramAccountRecord.getHomeAccountId(), paramAccountRecord.getEnvironment(), CredentialType.IdToken, paramString1, paramAccountRecord.getRealm(), null, null);
    paramAbstractAuthenticationScheme = mAccountCredentialCache.getCredentialsFilteredBy(paramAccountRecord.getHomeAccountId(), paramAccountRecord.getEnvironment(), CredentialType.V1IdToken, paramString1, paramAccountRecord.getRealm(), null, null);
    paramString2 = new CacheRecord();
    paramString2.setAccount(paramAccountRecord);
    if (localList.isEmpty()) {
      paramString1 = null;
    } else {
      paramString1 = (AccessTokenRecord)localList.get(0);
    }
    paramString2.setAccessToken(paramString1);
    if (((List)localObject1).isEmpty()) {
      paramString1 = null;
    } else {
      paramString1 = (RefreshTokenRecord)((List)localObject1).get(0);
    }
    paramString2.setRefreshToken(paramString1);
    if (((List)localObject2).isEmpty()) {
      paramString1 = null;
    } else {
      paramString1 = (IdTokenRecord)((List)localObject2).get(0);
    }
    paramString2.setIdToken(paramString1);
    if (paramAbstractAuthenticationScheme.isEmpty()) {
      paramString1 = (String)localObject3;
    } else {
      paramString1 = (IdTokenRecord)paramAbstractAuthenticationScheme.get(0);
    }
    paramString2.setV1IdToken(paramString1);
    Telemetry.emit(new CacheEndEvent().putCacheRecordStatus(paramString2));
    return paramString2;
  }
  
  public List<ICacheRecord> loadWithAggregatedAccountData(String paramString1, String paramString2, AccountRecord paramAccountRecord, AbstractAuthenticationScheme paramAbstractAuthenticationScheme)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      localArrayList.add(load(paramString1, paramString2, paramAccountRecord, paramAbstractAuthenticationScheme));
      paramString1 = getAccountsWithAggregatedAccountData(paramAccountRecord.getEnvironment(), paramString1, paramAccountRecord.getHomeAccountId()).iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (ICacheRecord)paramString1.next();
        if (!paramAccountRecord.equals(paramString2.getAccount())) {
          localArrayList.add(paramString2);
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public AccountDeletionRecord removeAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = a.a(new StringBuilder(), TAG, ":removeAccount");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Environment: [");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("]\nClientId: [");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("]\nHomeAccountId: [");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append("]\nRealm: [");
    ((StringBuilder)localObject2).append(paramString4);
    ((StringBuilder)localObject2).append("]");
    Logger.verbosePII((String)localObject1, ((StringBuilder)localObject2).toString());
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      localObject1 = getAccount(paramString1, paramString2, paramString3, paramString4);
      if (localObject1 != null)
      {
        boolean bool;
        if (paramString4 == null) {
          bool = true;
        } else {
          bool = false;
        }
        paramString4 = a.a(new StringBuilder(), TAG, ":removeAccount");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("IsRealmAgnostic? ");
        ((StringBuilder)localObject2).append(bool);
        Logger.verbose(paramString4, ((StringBuilder)localObject2).toString());
        int i = removeCredentialsOfTypeForAccount(paramString1, paramString2, CredentialType.AccessToken, (AccountRecord)localObject1, bool);
        int j = removeCredentialsOfTypeForAccount(paramString1, paramString2, CredentialType.AccessToken_With_AuthScheme, (AccountRecord)localObject1, bool);
        int k = removeCredentialsOfTypeForAccount(paramString1, paramString2, CredentialType.RefreshToken, (AccountRecord)localObject1, bool);
        int m = removeCredentialsOfTypeForAccount(paramString1, paramString2, CredentialType.IdToken, (AccountRecord)localObject1, bool);
        int n = removeCredentialsOfTypeForAccount(paramString1, paramString2, CredentialType.V1IdToken, (AccountRecord)localObject1, bool);
        paramString2 = new ArrayList();
        if (bool)
        {
          paramString1 = mAccountCredentialCache.getAccountsFilteredBy(paramString3, paramString1, null).iterator();
          while (paramString1.hasNext())
          {
            paramString3 = (AccountRecord)paramString1.next();
            if (mAccountCredentialCache.removeAccount(paramString3)) {
              paramString2.add(paramString3);
            }
          }
        }
        if (mAccountCredentialCache.removeAccount((AccountRecord)localObject1)) {
          paramString2.add(localObject1);
        }
        localObject1 = new String[] { "Access tokens (with authscheme)", String.valueOf(j) };
        localObject2 = new String[] { "Refresh tokens", String.valueOf(k) };
        String[] arrayOfString = { "Id tokens (v1)", String.valueOf(n) };
        n = paramString2.size();
        for (j = 0; j < 6; j++)
        {
          paramString3 = new String[][] { { "Access tokens", String.valueOf(i) }, localObject1, localObject2, arrayOfString, { "Id tokens (v2)", String.valueOf(m) }, { "Accounts", String.valueOf(n) } }[j];
          paramString1 = a.a(new StringBuilder(), TAG, ":removeAccount");
          paramString4 = new StringBuilder();
          paramString4.append(paramString3[0]);
          paramString4.append(" removed: [");
          paramString4.append(paramString3[1]);
          paramString4.append("]");
          Logger.info(paramString1, paramString4.toString());
        }
        return new AccountDeletionRecord(paramString2);
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append(TAG);
    paramString1.append(":removeAccount");
    Logger.warn(paramString1.toString(), "Insufficient filtering provided for account removal - preserving Account.");
    return new AccountDeletionRecord(null);
  }
  
  public boolean removeCredential(Credential paramCredential)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(":removeCredential");
    Logger.info(((StringBuilder)localObject).toString(), "Removing credential...");
    localObject = a.a(new StringBuilder(), TAG, ":removeCredential");
    StringBuilder localStringBuilder = a.a("ClientId: [");
    localStringBuilder.append(paramCredential.getClientId());
    localStringBuilder.append("]\nCredentialType: [");
    localStringBuilder.append(paramCredential.getCredentialType());
    localStringBuilder.append("]\nCachedAt: [");
    localStringBuilder.append(paramCredential.getCachedAt());
    localStringBuilder.append("]\nEnvironment: [");
    localStringBuilder.append(paramCredential.getEnvironment());
    localStringBuilder.append("]\nHomeAccountId: [");
    localStringBuilder.append(paramCredential.getHomeAccountId());
    localStringBuilder.append("]\nIsExpired?: [");
    localStringBuilder.append(paramCredential.isExpired());
    localStringBuilder.append("]");
    Logger.verbosePII((String)localObject, localStringBuilder.toString());
    return mAccountCredentialCache.removeCredential(paramCredential);
  }
  
  public void removeRefreshTokenIfNeeded(AccountRecord paramAccountRecord, RefreshTokenRecord paramRefreshTokenRecord)
  {
    boolean bool1 = StringExtensions.isNullOrBlank(paramRefreshTokenRecord.getFamilyId()) ^ true;
    Object localObject1 = a.a(new StringBuilder(), TAG, ":removeRefreshTokenIfNeeded");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("isFamilyRefreshToken? [");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append("]");
    Logger.info((String)localObject1, ((StringBuilder)localObject2).toString());
    boolean bool2 = "MSSTS".equals(paramAccountRecord.getAuthorityType());
    localObject2 = a.a(new StringBuilder(), TAG, ":removeRefreshTokenIfNeeded");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isMultiResourceCapable? [");
    ((StringBuilder)localObject1).append(bool2);
    ((StringBuilder)localObject1).append("]");
    Logger.info((String)localObject2, ((StringBuilder)localObject1).toString());
    if ((bool1) || (bool2))
    {
      int i = removeRefreshTokensForAccount(paramAccountRecord, bool1, paramAccountRecord.getEnvironment(), paramRefreshTokenRecord.getClientId());
      paramAccountRecord = a.a(new StringBuilder(), TAG, ":removeRefreshTokenIfNeeded");
      paramRefreshTokenRecord = new StringBuilder();
      paramRefreshTokenRecord.append("Refresh tokens removed: [");
      paramRefreshTokenRecord.append(i);
      paramRefreshTokenRecord.append("]");
      Logger.info(paramAccountRecord, paramRefreshTokenRecord.toString());
      if (i > 1) {
        a.c(new StringBuilder(), TAG, ":removeRefreshTokenIfNeeded", "Multiple refresh tokens found for Account.");
      }
    }
  }
  
  public ICacheRecord save(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord)
  {
    a.b(new StringBuilder(), TAG, ":save", "Importing AccountRecord, IdTokenRecord (direct)");
    boolean bool1 = isAccountSchemaCompliant(paramAccountRecord);
    boolean bool2 = isIdTokenSchemaCompliant(paramIdTokenRecord);
    CacheRecord localCacheRecord = new CacheRecord();
    if ((bool1) && (bool2))
    {
      saveAccounts(new AccountRecord[] { paramAccountRecord });
      saveCredentialsInternal(new Credential[] { paramIdTokenRecord });
      localCacheRecord.setAccount(paramAccountRecord);
      paramAccountRecord = CredentialType.V1IdToken;
      if ("V1IdToken".equalsIgnoreCase(paramIdTokenRecord.getCredentialType())) {
        localCacheRecord.setV1IdToken(paramIdTokenRecord);
      } else {
        localCacheRecord.setIdToken(paramIdTokenRecord);
      }
    }
    else
    {
      if (!bool1) {
        paramAccountRecord = "[(Account)";
      } else {
        paramAccountRecord = "[";
      }
      paramIdTokenRecord = paramAccountRecord;
      if (!bool2) {
        paramIdTokenRecord = a.b(paramAccountRecord, "(ID)");
      }
      String str = a.b(paramIdTokenRecord, "]");
      paramIdTokenRecord = a.a(new StringBuilder(), TAG, ":save");
      paramAccountRecord = new StringBuilder();
      paramAccountRecord.append("Skipping persistence of non-compliant credentials: ");
      paramAccountRecord.append(str);
      Logger.warn(paramIdTokenRecord, paramAccountRecord.toString());
    }
    return localCacheRecord;
  }
  
  public ICacheRecord save(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord, AccessTokenRecord paramAccessTokenRecord)
  {
    boolean bool1 = isAccountSchemaCompliant(paramAccountRecord);
    boolean bool2 = isIdTokenSchemaCompliant(paramIdTokenRecord);
    boolean bool3 = isAccessTokenSchemaCompliant(paramAccessTokenRecord);
    if (bool1)
    {
      if (bool2)
      {
        if (bool3)
        {
          a.b(new StringBuilder(), TAG, ":save (broker 3 arg)", "Accounts/Credentials are valid.... proceeding");
          saveAccounts(new AccountRecord[] { paramAccountRecord });
          saveCredentialsInternal(new Credential[] { paramIdTokenRecord, paramAccessTokenRecord });
          CacheRecord localCacheRecord = new CacheRecord();
          localCacheRecord.setAccount(paramAccountRecord);
          localCacheRecord.setAccessToken(paramAccessTokenRecord);
          paramAccountRecord = CredentialType.V1IdToken;
          if ("V1IdToken".equalsIgnoreCase(paramIdTokenRecord.getCredentialType())) {
            localCacheRecord.setV1IdToken(paramIdTokenRecord);
          } else {
            localCacheRecord.setIdToken(paramIdTokenRecord);
          }
          return localCacheRecord;
        }
        throw new ClientException("Credential is missing schema-required fields.", "[(AT)]");
      }
      throw new ClientException("Credential is missing schema-required fields.", "[(ID)]");
    }
    throw new ClientException("Account is missing schema-required fields.");
  }
  
  public ICacheRecord save(GenericOAuth2Strategy paramGenericOAuth2Strategy, GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericTokenResponse paramGenericTokenResponse)
  {
    AccountRecord localAccountRecord = mAccountCredentialAdapter.createAccount(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse);
    AccessTokenRecord localAccessTokenRecord = mAccountCredentialAdapter.createAccessToken(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse);
    RefreshTokenRecord localRefreshTokenRecord = mAccountCredentialAdapter.createRefreshToken(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse);
    paramGenericAuthorizationRequest = mAccountCredentialAdapter.createIdToken(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse);
    validateCacheArtifacts(localAccountRecord, localAccessTokenRecord, localRefreshTokenRecord, paramGenericAuthorizationRequest);
    removeRefreshTokenIfNeeded(localAccountRecord, localRefreshTokenRecord);
    saveAccounts(new AccountRecord[] { localAccountRecord });
    saveCredentialsInternal(new Credential[] { localAccessTokenRecord, localRefreshTokenRecord, paramGenericAuthorizationRequest });
    paramGenericOAuth2Strategy = new CacheRecord();
    paramGenericOAuth2Strategy.setAccount(localAccountRecord);
    paramGenericOAuth2Strategy.setAccessToken(localAccessTokenRecord);
    paramGenericOAuth2Strategy.setRefreshToken(localRefreshTokenRecord);
    setToCacheRecord(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest);
    return paramGenericOAuth2Strategy;
  }
  
  public List<ICacheRecord> saveAndLoadAggregatedAccountData(AccountRecord paramAccountRecord, IdTokenRecord paramIdTokenRecord, AccessTokenRecord paramAccessTokenRecord)
  {
    return mergeCacheRecordWithOtherTenantCacheRecords(save(paramAccountRecord, paramIdTokenRecord, paramAccessTokenRecord));
  }
  
  public List<ICacheRecord> saveAndLoadAggregatedAccountData(GenericOAuth2Strategy paramGenericOAuth2Strategy, GenericAuthorizationRequest paramGenericAuthorizationRequest, GenericTokenResponse paramGenericTokenResponse)
  {
    try
    {
      paramGenericOAuth2Strategy = mergeCacheRecordWithOtherTenantCacheRecords(save(paramGenericOAuth2Strategy, paramGenericAuthorizationRequest, paramGenericTokenResponse));
      return paramGenericOAuth2Strategy;
    }
    finally {}
  }
  
  public void saveCredentialsInternal(Credential... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Credential localCredential = paramVarArgs[j];
      if ((localCredential instanceof AccessTokenRecord)) {
        deleteAccessTokensWithIntersectingScopes((AccessTokenRecord)localCredential);
      }
      mAccountCredentialCache.saveCredential(localCredential);
    }
  }
  
  public void setSingleSignOnState(GenericAccount paramGenericAccount, GenericRefreshToken paramGenericRefreshToken)
  {
    AccountRecord localAccountRecord = mAccountCredentialAdapter.asAccount(paramGenericAccount);
    RefreshTokenRecord localRefreshTokenRecord = mAccountCredentialAdapter.asRefreshToken(paramGenericRefreshToken);
    paramGenericAccount = mAccountCredentialAdapter.asIdToken(paramGenericAccount, paramGenericRefreshToken);
    validateCacheArtifacts(localAccountRecord, null, localRefreshTokenRecord, paramGenericAccount);
    boolean bool1 = StringExtensions.isNullOrBlank(paramGenericRefreshToken.getFamilyId()) ^ true;
    boolean bool2 = "MSSTS".equals(localAccountRecord.getAuthorityType());
    if ((bool1) || (bool2))
    {
      int i = removeRefreshTokensForAccount(localAccountRecord, bool1, localAccountRecord.getEnvironment(), localRefreshTokenRecord.getClientId());
      String str = a.a(new StringBuilder(), TAG, "setSingleSignOnState");
      paramGenericRefreshToken = new StringBuilder();
      paramGenericRefreshToken.append("Refresh tokens removed: [");
      paramGenericRefreshToken.append(i);
      paramGenericRefreshToken.append("]");
      Logger.info(str, paramGenericRefreshToken.toString());
      if (i > 1) {
        a.c(new StringBuilder(), TAG, "setSingleSignOnState", "Multiple refresh tokens found for Account.");
      }
    }
    saveAccounts(new AccountRecord[] { localAccountRecord });
    saveCredentialsInternal(new Credential[] { paramGenericAccount, localRefreshTokenRecord });
  }
  
  public void validateCacheArtifacts(AccountRecord paramAccountRecord, AccessTokenRecord paramAccessTokenRecord, RefreshTokenRecord paramRefreshTokenRecord, IdTokenRecord paramIdTokenRecord)
  {
    a.b(new StringBuilder(), TAG, ":validateCacheArtifacts", "Validating cache artifacts...");
    boolean bool1 = isAccountSchemaCompliant(paramAccountRecord);
    int i;
    if ((paramAccessTokenRecord != null) && (!isAccessTokenSchemaCompliant(paramAccessTokenRecord))) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool2 = isRefreshTokenSchemaCompliant(paramRefreshTokenRecord);
    boolean bool3 = isIdTokenSchemaCompliant(paramIdTokenRecord);
    if (bool1)
    {
      if ((i != 0) && (bool2) && (bool3)) {
        return;
      }
      if (i == 0) {
        paramAccessTokenRecord = "[(AT)";
      } else {
        paramAccessTokenRecord = "[";
      }
      paramAccountRecord = paramAccessTokenRecord;
      if (!bool2) {
        paramAccountRecord = a.b(paramAccessTokenRecord, "(RT)");
      }
      paramAccessTokenRecord = paramAccountRecord;
      if (!bool3) {
        paramAccessTokenRecord = a.b(paramAccountRecord, "(ID)");
      }
      throw new ClientException("Credential is missing schema-required fields.", a.b(paramAccessTokenRecord, "]"));
    }
    throw new ClientException("Account is missing schema-required fields.");
  }
  
  public void validateNonNull(Object paramObject, String paramString)
  {
    paramString = a.b(paramString, " passed in is Null");
    if (paramObject != null) {
      return;
    }
    Logger.warn(TAG, paramString);
    throw new ClientException(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.MsalOAuth2TokenCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */