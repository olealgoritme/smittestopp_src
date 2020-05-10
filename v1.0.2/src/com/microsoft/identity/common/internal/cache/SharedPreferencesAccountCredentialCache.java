package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.CredentialType;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SharedPreferencesAccountCredentialCache
  extends AbstractAccountCredentialCache
{
  public static final String ACCOUNT_RECORD_DESERIALIZATION_FAILED;
  public static final String BROKER_FOCI_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.account_credential_cache.foci-1";
  public static final String CREDENTIAL_DESERIALIZATION_FAILED;
  public static final String DEFAULT_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES = "com.microsoft.identity.client.account_credential_cache";
  public static final String DESERIALIZATION_FAILED = "Deserialization failed. Skipping ";
  public static final AccountRecord EMPTY_ACCOUNT = new AccountRecord();
  public static final AccessTokenRecord EMPTY_AT = new AccessTokenRecord();
  public static final IdTokenRecord EMPTY_ID;
  public static final RefreshTokenRecord EMPTY_RT = new RefreshTokenRecord();
  public static final String TAG = "SharedPreferencesAccountCredentialCache";
  public final ICacheKeyValueDelegate mCacheValueDelegate;
  public final ISharedPreferencesFileManager mSharedPreferencesFileManager;
  
  static
  {
    EMPTY_ID = new IdTokenRecord();
    StringBuilder localStringBuilder = a.a("Deserialization failed. Skipping ");
    localStringBuilder.append(AccountRecord.class.getSimpleName());
    ACCOUNT_RECORD_DESERIALIZATION_FAILED = localStringBuilder.toString();
    localStringBuilder = a.a("Deserialization failed. Skipping ");
    localStringBuilder.append(Credential.class.getSimpleName());
    CREDENTIAL_DESERIALIZATION_FAILED = localStringBuilder.toString();
  }
  
  public SharedPreferencesAccountCredentialCache(ICacheKeyValueDelegate paramICacheKeyValueDelegate, ISharedPreferencesFileManager paramISharedPreferencesFileManager)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mSharedPreferencesFileManager = paramISharedPreferencesFileManager;
    mCacheValueDelegate = paramICacheKeyValueDelegate;
  }
  
  private Class<? extends Credential> credentialClassForType(String paramString)
  {
    Logger.verbose(TAG, "Resolving class for key/CredentialType...");
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Supplied key: [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Logger.verbosePII(str, localStringBuilder.toString());
    CredentialType localCredentialType = getCredentialTypeForCredentialCacheKey(paramString);
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("CredentialType matched: [");
    localStringBuilder.append(localCredentialType);
    localStringBuilder.append("]");
    Logger.verbose(str, localStringBuilder.toString());
    return getTargetClassForCredentialType(paramString, localCredentialType);
  }
  
  private Map<String, AccountRecord> getAccountsWithKeys()
  {
    Logger.verbose(TAG, "Loading Accounts + keys...");
    Object localObject1 = mSharedPreferencesFileManager.getAll();
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (String)((Map.Entry)localObject3).getKey();
      if (isAccount((String)localObject1))
      {
        localObject3 = (AccountRecord)mCacheValueDelegate.fromCacheValue(((Map.Entry)localObject3).getValue().toString(), AccountRecord.class);
        if (localObject3 == null) {
          Logger.warn(TAG, ACCOUNT_RECORD_DESERIALIZATION_FAILED);
        } else {
          localHashMap.put(localObject1, localObject3);
        }
      }
    }
    localObject1 = TAG;
    localObject2 = a.a("Returning [");
    ((StringBuilder)localObject2).append(localHashMap.size());
    ((StringBuilder)localObject2).append("] Accounts w/ keys...");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    return localHashMap;
  }
  
  public static String getBrokerUidSequesteredFilename(int paramInt)
  {
    return a.a("com.microsoft.identity.client.account_credential_cache.uid-", paramInt);
  }
  
  public static CredentialType getCredentialTypeForCredentialCacheKey(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      Object localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Evaluating cache key for CredentialType [");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("]");
      Logger.verbosePII((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = new HashSet();
      localObject2 = CredentialType.valueSet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HashSet)localObject1).add(((String)((Iterator)localObject2).next()).toLowerCase(Locale.US));
      }
      localObject2 = null;
      Iterator localIterator = ((HashSet)localObject1).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (String)localIterator.next();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("-");
        if (paramString.contains(((StringBuilder)localObject3).toString()))
        {
          Logger.verbose(TAG, "Cache key is a Credential type...");
          localObject3 = CredentialType.AccessToken;
          if (((String)localObject1).equalsIgnoreCase("AccessToken"))
          {
            localObject1 = CredentialType.AccessToken;
            break;
          }
          localObject3 = CredentialType.AccessToken_With_AuthScheme;
          if (((String)localObject1).equalsIgnoreCase("AccessToken_With_AuthScheme"))
          {
            localObject1 = CredentialType.AccessToken_With_AuthScheme;
            break;
          }
          localObject3 = CredentialType.RefreshToken;
          if (((String)localObject1).equalsIgnoreCase("RefreshToken"))
          {
            localObject1 = CredentialType.RefreshToken;
            break;
          }
          localObject3 = CredentialType.IdToken;
          if (((String)localObject1).equalsIgnoreCase("IdToken"))
          {
            localObject1 = CredentialType.IdToken;
            break;
          }
          localObject3 = CredentialType.V1IdToken;
          if (((String)localObject1).equalsIgnoreCase("V1IdToken"))
          {
            localObject1 = CredentialType.V1IdToken;
            break;
          }
          Logger.warn(TAG, "Unexpected credential type.");
        }
      }
      paramString = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Cache key was type: [");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      Logger.verbose(paramString, ((StringBuilder)localObject2).toString());
      return (CredentialType)localObject1;
    }
    throw new IllegalArgumentException("Param [cacheKey] cannot be null.");
  }
  
  private Map<String, Credential> getCredentialsWithKeys()
  {
    Logger.verbose(TAG, "Loading Credentials with keys...");
    Object localObject1 = mSharedPreferencesFileManager.getAll();
    HashMap localHashMap = new HashMap();
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (String)((Map.Entry)localObject2).getKey();
      if (isCredential((String)localObject3))
      {
        localObject2 = (Credential)mCacheValueDelegate.fromCacheValue(((Map.Entry)localObject2).getValue().toString(), credentialClassForType((String)localObject3));
        if (localObject2 == null) {
          Logger.warn(TAG, CREDENTIAL_DESERIALIZATION_FAILED);
        } else {
          localHashMap.put(localObject3, localObject2);
        }
      }
    }
    localObject1 = TAG;
    Object localObject3 = a.a("Loaded [");
    ((StringBuilder)localObject3).append(localHashMap.size());
    ((StringBuilder)localObject3).append("] Credentials...");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject3).toString());
    return localHashMap;
  }
  
  private boolean isAccount(String paramString)
  {
    String str = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Evaluating cache key: [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.verbosePII(str, ((StringBuilder)localObject).toString());
    boolean bool;
    if (getCredentialTypeForCredentialCacheKey(paramString) == null) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = TAG;
    paramString = new StringBuilder();
    paramString.append("isAccount? [");
    paramString.append(bool);
    paramString.append("]");
    Logger.verbose((String)localObject, paramString.toString());
    return bool;
  }
  
  private boolean isCredential(String paramString)
  {
    String str = TAG;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Evaluating cache key: [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.verbosePII(str, ((StringBuilder)localObject).toString());
    boolean bool;
    if (getCredentialTypeForCredentialCacheKey(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = TAG;
    paramString = new StringBuilder();
    paramString.append("isCredential? [");
    paramString.append(bool);
    paramString.append("]");
    Logger.verbose((String)localObject, paramString.toString());
    return bool;
  }
  
  public void clearAll()
  {
    Logger.info(TAG, "Clearing all SharedPreferences entries...");
    mSharedPreferencesFileManager.clear();
    Logger.info(TAG, "SharedPreferences cleared.");
  }
  
  public AccountRecord getAccount(String paramString)
  {
    try
    {
      Logger.verbose(TAG, "Loading Account by key...");
      AccountRecord localAccountRecord1 = (AccountRecord)mCacheValueDelegate.fromCacheValue(mSharedPreferencesFileManager.getString(paramString), AccountRecord.class);
      AccountRecord localAccountRecord2;
      if (localAccountRecord1 == null)
      {
        Logger.warn(TAG, ACCOUNT_RECORD_DESERIALIZATION_FAILED);
        localAccountRecord2 = localAccountRecord1;
      }
      else
      {
        localAccountRecord2 = localAccountRecord1;
        if (EMPTY_ACCOUNT.equals(localAccountRecord1))
        {
          Logger.warn(TAG, "The returned Account was uninitialized. Removing...");
          mSharedPreferencesFileManager.remove(paramString);
          localAccountRecord2 = null;
        }
      }
      return localAccountRecord2;
    }
    finally {}
  }
  
  public List<AccountRecord> getAccounts()
  {
    try
    {
      Logger.verbose(TAG, "Loading Accounts...(no arg)");
      Object localObject1 = getAccountsWithKeys();
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(((Map)localObject1).values());
      localObject1 = TAG;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Found [");
      localStringBuilder.append(localArrayList.size());
      localStringBuilder.append("] Accounts...");
      Logger.info((String)localObject1, localStringBuilder.toString());
      return localArrayList;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public List<AccountRecord> getAccountsFilteredBy(String paramString1, String paramString2, String paramString3)
  {
    Logger.verbose(TAG, "Loading Accounts...");
    paramString3 = getAccountsFilteredByInternal(paramString1, paramString2, paramString3, getAccounts());
    paramString1 = TAG;
    paramString2 = a.a("Found [");
    paramString2.append(paramString3.size());
    paramString2.append("] matching Accounts...");
    Logger.info(paramString1, paramString2.toString());
    return paramString3;
  }
  
  public Credential getCredential(String paramString)
  {
    try
    {
      Logger.verbose(TAG, "getCredential()");
      Object localObject1 = TAG;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("Using cache key: [");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("]");
      Logger.verbosePII((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = getCredentialTypeForCredentialCacheKey(paramString);
      Object localObject3 = null;
      if (localObject1 != null) {
        localObject2 = getTargetClassForCredentialType(paramString, (CredentialType)localObject1);
      } else {
        localObject2 = null;
      }
      if (localObject2 != null) {
        localObject1 = (Credential)mCacheValueDelegate.fromCacheValue(mSharedPreferencesFileManager.getString(paramString), (Class)localObject2);
      } else {
        localObject1 = null;
      }
      if (localObject1 == null)
      {
        Logger.warn(TAG, CREDENTIAL_DESERIALIZATION_FAILED);
      }
      else if (((AccessTokenRecord.class == localObject2) && (EMPTY_AT.equals(localObject1))) || ((RefreshTokenRecord.class == localObject2) && (EMPTY_RT.equals(localObject1))) || ((IdTokenRecord.class == localObject2) && (EMPTY_ID.equals(localObject1))))
      {
        Logger.warn(TAG, "The returned Credential was uninitialized. Removing...");
        mSharedPreferencesFileManager.remove(paramString);
        paramString = (String)localObject3;
        break label200;
      }
      paramString = (String)localObject1;
      label200:
      return paramString;
    }
    finally {}
  }
  
  public List<Credential> getCredentials()
  {
    try
    {
      Logger.verbose(TAG, "Loading Credentials...");
      ArrayList localArrayList = new ArrayList(getCredentialsWithKeys().values());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public List<Credential> getCredentialsFilteredBy(String paramString1, String paramString2, CredentialType paramCredentialType, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Logger.verbose(TAG, "getCredentialsFilteredBy()");
    paramString2 = getCredentialsFilteredByInternal(paramString1, paramString2, paramCredentialType, paramString3, paramString4, paramString5, paramString6, getCredentials());
    paramString1 = TAG;
    paramCredentialType = a.a("Found [");
    paramCredentialType.append(paramString2.size());
    paramCredentialType.append("] matching Credentials...");
    Logger.info(paramString1, paramCredentialType.toString());
    return paramString2;
  }
  
  public boolean removeAccount(AccountRecord paramAccountRecord)
  {
    Logger.info(TAG, "Removing Account...");
    if (paramAccountRecord != null)
    {
      Object localObject = getAccountsWithKeys();
      boolean bool1 = false;
      localObject = ((Map)localObject).entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = TAG;
        StringBuilder localStringBuilder = a.a("Inspecting: [");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("]");
        Logger.verbosePII(str, localStringBuilder.toString());
      } while (!((IAccountRecord)localEntry.getValue()).equals(paramAccountRecord));
      mSharedPreferencesFileManager.remove((String)localEntry.getKey());
      boolean bool2 = true;
      paramAccountRecord = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Account was removed? [");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("]");
      Logger.info(paramAccountRecord, ((StringBuilder)localObject).toString());
      return bool2;
    }
    throw new IllegalArgumentException("Param [accountToRemove] cannot be null.");
  }
  
  public boolean removeCredential(Credential paramCredential)
  {
    Logger.info(TAG, "Removing Credential...");
    if (paramCredential != null)
    {
      Object localObject = getCredentialsWithKeys();
      boolean bool1 = false;
      localObject = ((Map)localObject).entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = TAG;
        StringBuilder localStringBuilder = a.a("Inspecting: [");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("]");
        Logger.verbosePII(str, localStringBuilder.toString());
      } while (!((Credential)localEntry.getValue()).equals(paramCredential));
      mSharedPreferencesFileManager.remove((String)localEntry.getKey());
      boolean bool2 = true;
      localObject = TAG;
      paramCredential = new StringBuilder();
      paramCredential.append("Credential was removed? [");
      paramCredential.append(bool2);
      paramCredential.append("]");
      Logger.info((String)localObject, paramCredential.toString());
      return bool2;
    }
    throw new IllegalArgumentException("Param [credentialToRemove] cannot be null.");
  }
  
  public void saveAccount(AccountRecord paramAccountRecord)
  {
    try
    {
      Logger.verbose(TAG, "Saving Account...");
      String str = TAG;
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("Account type: [");
      ((StringBuilder)localObject).append(paramAccountRecord.getClass().getSimpleName());
      ((StringBuilder)localObject).append("]");
      Logger.verbose(str, ((StringBuilder)localObject).toString());
      localObject = mCacheValueDelegate.generateCacheKey(paramAccountRecord);
      str = TAG;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Generated cache key: [");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      Logger.verbosePII(str, localStringBuilder.toString());
      paramAccountRecord = mCacheValueDelegate.generateCacheValue(paramAccountRecord);
      mSharedPreferencesFileManager.putString((String)localObject, paramAccountRecord);
      return;
    }
    finally
    {
      paramAccountRecord = finally;
      throw paramAccountRecord;
    }
  }
  
  public void saveCredential(Credential paramCredential)
  {
    try
    {
      Logger.verbose(TAG, "Saving credential...");
      String str1 = mCacheValueDelegate.generateCacheKey(paramCredential);
      String str2 = TAG;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Generated cache key: [");
      localStringBuilder.append(str1);
      localStringBuilder.append("]");
      Logger.verbosePII(str2, localStringBuilder.toString());
      paramCredential = mCacheValueDelegate.generateCacheValue(paramCredential);
      mSharedPreferencesFileManager.putString(str1, paramCredential);
      return;
    }
    finally
    {
      paramCredential = finally;
      throw paramCredential;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.cache.SharedPreferencesAccountCredentialCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */