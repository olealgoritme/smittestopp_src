package com.microsoft.identity.common.internal.migration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.util.Pair;
import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.ADALUserInfo;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAccount;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import e.c.c.j;
import e.c.c.m;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AdalMigrationAdapter
  implements IMigrationAdapter<MicrosoftAccount, MicrosoftRefreshToken>
{
  public static final String KEY_MIGRATION_STATUS = "adal-migration-complete";
  public static final String MIGRATION_STATUS_SHARED_PREFERENCES = "com.microsoft.identity.client.migration_status";
  public static final String TAG = "AdalMigrationAdapter";
  public static final Object sLock = new Object();
  public final boolean mForceMigration;
  public final Map<String, String> mRedirectsMap;
  public final SharedPreferences mSharedPrefs;
  
  public AdalMigrationAdapter(Context paramContext, Map<String, String> paramMap, boolean paramBoolean)
  {
    mSharedPrefs = paramContext.getSharedPreferences("com.microsoft.identity.client.migration_status", 0);
    mRedirectsMap = paramMap;
    mForceMigration = paramBoolean;
  }
  
  public static MicrosoftAccount createAccount(ADALTokenCacheItem paramADALTokenCacheItem)
  {
    try
    {
      localObject1 = paramADALTokenCacheItem.getRawIdToken();
      Object localObject2 = paramADALTokenCacheItem.getUserInfo().getUserId();
      Object localObject3 = paramADALTokenCacheItem.getTenantId();
      Object localObject4 = new java/net/URL;
      ((URL)localObject4).<init>(paramADALTokenCacheItem.getAuthority());
      paramADALTokenCacheItem = ((URL)localObject4).getHost();
      localObject4 = new e/c/c/m;
      ((m)localObject4).<init>();
      ((m)localObject4).a("uid", ((m)localObject4).a(localObject2));
      ((m)localObject4).a("utid", ((m)localObject4).a(localObject3));
      localObject2 = ((j)localObject4).toString();
      localObject3 = new java/lang/String;
      ((String)localObject3).<init>(Base64.encode(((String)localObject2).getBytes(), 0));
      localObject2 = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/ClientInfo;
      ((ClientInfo)localObject2).<init>((String)localObject3);
      localObject3 = new com/microsoft/identity/common/internal/providers/oauth2/IDToken;
      ((IDToken)localObject3).<init>((String)localObject1);
      localObject1 = new com/microsoft/identity/common/internal/providers/microsoft/azureactivedirectory/AzureActiveDirectoryAccount;
      ((AzureActiveDirectoryAccount)localObject1).<init>((IDToken)localObject3, (ClientInfo)localObject2);
      ((MicrosoftAccount)localObject1).setEnvironment(paramADALTokenCacheItem);
      return (MicrosoftAccount)localObject1;
    }
    catch (ServiceException paramADALTokenCacheItem) {}catch (MalformedURLException paramADALTokenCacheItem) {}
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":createAccount");
    Logger.error(((StringBuilder)localObject1).toString(), "Failed to create Account", null);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(":createAccount");
    Logger.errorPII(((StringBuilder)localObject1).toString(), "Failed to create Account", paramADALTokenCacheItem);
    return null;
  }
  
  private Map<String, ADALTokenCacheItem> deserialize(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Gson localGson = new Gson();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localHashMap.put(localEntry.getKey(), localGson.a((String)localEntry.getValue(), ADALTokenCacheItem.class));
    }
    return localHashMap;
  }
  
  public static boolean loadCloudDiscoveryMetadata()
  {
    if (!AzureActiveDirectory.isInitialized()) {
      try
      {
        AzureActiveDirectory.performCloudDiscovery();
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG);
        localStringBuilder.append(":loadCloudDiscoveryMetadata");
        Logger.error(localStringBuilder.toString(), "Failed to load instance discovery metadata", localIOException);
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public List<Pair<MicrosoftAccount, MicrosoftRefreshToken>> adapt(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sLock)
    {
      if ((!getMigrationStatus()) && (!mForceMigration) && (loadCloudDiscoveryMetadata()))
      {
        paramMap = deserialize(paramMap);
        localArrayList.addAll(TokenCacheItemMigrationAdapter.migrateTokens(mRedirectsMap, paramMap.values()));
        setMigrationStatus(true);
      }
      return localArrayList;
    }
  }
  
  public boolean getMigrationStatus()
  {
    return mSharedPrefs.getBoolean("adal-migration-complete", false);
  }
  
  @SuppressLint({"ApplySharedPref"})
  public void setMigrationStatus(boolean paramBoolean)
  {
    mSharedPrefs.edit().putBoolean("adal-migration-complete", paramBoolean).commit();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.migration.AdalMigrationAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */