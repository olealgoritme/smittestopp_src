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
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Supplied key: [");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("]");
    Logger.verbosePII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = getCredentialTypeForCredentialCacheKey(paramString);
    localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CredentialType matched: [");
    localStringBuilder.append(localObject1);
    localStringBuilder.append("]");
    Logger.verbose((String)localObject2, localStringBuilder.toString());
    return getTargetClassForCredentialType(paramString, (CredentialType)localObject1);
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
    localObject2 = TAG;
    localObject1 = a.a("Returning [");
    ((StringBuilder)localObject1).append(localHashMap.size());
    ((StringBuilder)localObject1).append("] Accounts w/ keys...");
    Logger.verbose((String)localObject2, ((StringBuilder)localObject1).toString());
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
      localObject2 = new HashSet();
      localObject1 = CredentialType.valueSet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((HashSet)localObject2).add(((String)((Iterator)localObject1).next()).toLowerCase(Locale.US));
      }
      localObject1 = null;
      Iterator localIterator = ((HashSet)localObject2).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localIterator.next();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("-");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("-");
        if (paramString.contains(((StringBuilder)localObject3).toString()))
        {
          Logger.verbose(TAG, "Cache key is a Credential type...");
          localObject3 = CredentialType.AccessToken;
          if (((String)localObject2).equalsIgnoreCase("AccessToken"))
          {
            localObject2 = CredentialType.AccessToken;
            break;
          }
          localObject3 = CredentialType.AccessToken_With_AuthScheme;
          if (((String)localObject2).equalsIgnoreCase("AccessToken_With_AuthScheme"))
          {
            localObject2 = CredentialType.AccessToken_With_AuthScheme;
            break;
          }
          localObject3 = CredentialType.RefreshToken;
          if (((String)localObject2).equalsIgnoreCase("RefreshToken"))
          {
            localObject2 = CredentialType.RefreshToken;
            break;
          }
          localObject3 = CredentialType.IdToken;
          if (((String)localObject2).equalsIgnoreCase("IdToken"))
          {
            localObject2 = CredentialType.IdToken;
            break;
          }
          localObject3 = CredentialType.V1IdToken;
          if (((String)localObject2).equalsIgnoreCase("V1IdToken"))
          {
            localObject2 = CredentialType.V1IdToken;
            break;
          }
          Logger.warn(TAG, "Unexpected credential type.");
        }
      }
      localObject1 = TAG;
      paramString = new StringBuilder();
      paramString.append("Cache key was type: [");
      paramString.append(localObject2);
      paramString.append("]");
      Logger.verbose((String)localObject1, paramString.toString());
      return (CredentialType)localObject2;
    }
    throw new IllegalArgumentException("Param [cacheKey] cannot be null.");
  }
  
  private Map<String, Credential> getCredentialsWithKeys()
  {
    Logger.verbose(TAG, "Loading Credentials with keys...");
    Object localObject1 = mSharedPreferencesFileManager.getAll();
    HashMap localHashMap = new HashMap();
    Object localObject2 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (String)((Map.Entry)localObject3).getKey();
      if (isCredential((String)localObject1))
      {
        localObject3 = (Credential)mCacheValueDelegate.fromCacheValue(((Map.Entry)localObject3).getValue().toString(), credentialClassForType((String)localObject1));
        if (localObject3 == null) {
          Logger.warn(TAG, CREDENTIAL_DESERIALIZATION_FAILED);
        } else {
          localHashMap.put(localObject1, localObject3);
        }
      }
    }
    localObject1 = TAG;
    localObject2 = a.a("Loaded [");
    ((StringBuilder)localObject2).append(localHashMap.size());
    ((StringBuilder)localObject2).append("] Credentials...");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    return localHashMap;
  }
  
  private boolean isAccount(String paramString)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Evaluating cache key: [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Logger.verbosePII((String)localObject, localStringBuilder.toString());
    boolean bool;
    if (getCredentialTypeForCredentialCacheKey(paramString) == null) {
      bool = true;
    } else {
      bool = false;
    }
    paramString = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isAccount? [");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("]");
    Logger.verbose(paramString, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  private boolean isCredential(String paramString)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Evaluating cache key: [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Logger.verbosePII(str, localStringBuilder.toString());
    boolean bool;
    if (getCredentialTypeForCredentialCacheKey(paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    str = TAG;
    paramString = new StringBuilder();
    paramString.append("isCredential? [");
    paramString.append(bool);
    paramString.append("]");
    Logger.verbose(str, paramString.toString());
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
      String str = TAG;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Found [");
      ((StringBuilder)localObject1).append(localArrayList.size());
      ((StringBuilder)localObject1).append("] Accounts...");
      Logger.info(str, ((StringBuilder)localObject1).toString());
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
    paramString1 = getAccountsFilteredByInternal(paramString1, paramString2, paramString3, getAccounts());
    paramString2 = TAG;
    paramString3 = a.a("Found [");
    paramString3.append(paramString1.size());
    paramString3.append("] matching Accounts...");
    Logger.info(paramString2, paramString3.toString());
    return paramString1;
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
      localObject2 = getCredentialTypeForCredentialCacheKey(paramString);
      Object localObject3 = null;
      if (localObject2 != null) {
        localObject1 = getTargetClassForCredentialType(paramString, (CredentialType)localObject2);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        localObject2 = (Credential)mCacheValueDelegate.fromCacheValue(mSharedPreferencesFileManager.getString(paramString), (Class)localObject1);
      } else {
        localObject2 = null;
      }
      if (localObject2 == null)
      {
        Logger.warn(TAG, CREDENTIAL_DESERIALIZATION_FAILED);
      }
      else if (((AccessTokenRecord.class == localObject1) && (EMPTY_AT.equals(localObject2))) || ((RefreshTokenRecord.class == localObject1) && (EMPTY_RT.equals(localObject2))) || ((IdTokenRecord.class == localObject1) && (EMPTY_ID.equals(localObject2))))
      {
        Logger.warn(TAG, "The returned Credential was uninitialized. Removing...");
        mSharedPreferencesFileManager.remove(paramString);
        localObject2 = localObject3;
      }
      return (Credential)localObject2;
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
    paramCredentialType = getCredentialsFilteredByInternal(paramString1, paramString2, paramCredentialType, paramString3, paramString4, paramString5, paramString6, getCredentials());
    paramString2 = TAG;
    paramString1 = a.a("Found [");
    paramString1.append(paramCredentialType.size());
    paramString1.append("] matching Credentials...");
    Logger.info(paramString2, paramString1.toString());
    return paramCredentialType;
  }
  
  public boolean removeAccount(AccountRecord paramAccountRecord)
  {
    Logger.info(TAG, "Removing Account...");
    if (paramAccountRecord != null)
    {
      Object localObject = getAccountsWithKeys();
      boolean bool1 = false;
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        String str = TAG;
        StringBuilder localStringBuilder = a.a("Inspecting: [");
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("]");
        Logger.verbosePII(str, localStringBuilder.toString());
      } while (!((IAccountRecord)((Map.Entry)localObject).getValue()).equals(paramAccountRecord));
      mSharedPreferencesFileManager.remove((String)((Map.Entry)localObject).getKey());
      boolean bool2 = true;
      localObject = TAG;
      paramAccountRecord = new StringBuilder();
      paramAccountRecord.append("Account was removed? [");
      paramAccountRecord.append(bool2);
      paramAccountRecord.append("]");
      Logger.info((String)localObject, paramAccountRecord.toString());
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
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
        localObject = TAG;
        StringBuilder localStringBuilder = a.a("Inspecting: [");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("]");
        Logger.verbosePII((String)localObject, localStringBuilder.toString());
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
      String str1 = TAG;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Account type: [");
      localStringBuilder.append(paramAccountRecord.getClass().getSimpleName());
      localStringBuilder.append("]");
      Logger.verbose(str1, localStringBuilder.toString());
      str1 = mCacheValueDelegate.generateCacheKey(paramAccountRecord);
      String str2 = TAG;
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Generated cache key: [");
      localStringBuilder.append(str1);
      localStringBuilder.append("]");
      Logger.verbosePII(str2, localStringBuilder.toString());
      paramAccountRecord = mCacheValueDelegate.generateCacheValue(paramAccountRecord);
      mSharedPreferencesFileManager.putString(str1, paramAccountRecord);
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
 * Qualified Name:     com.microsoft.identity.common.internal.cache.SharedPreferencesAccountCredentialCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */