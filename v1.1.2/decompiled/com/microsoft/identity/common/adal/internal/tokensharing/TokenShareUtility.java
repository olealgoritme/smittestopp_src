package com.microsoft.identity.common.adal.internal.tokensharing;

import android.net.Uri;
import android.util.Pair;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.cache.ITokenCacheItem;
import com.microsoft.identity.common.internal.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IdTokenRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.migration.AdalMigrationAdapter;
import com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import e.e.a.e;
import e.e.a.g;
import e.e.a.h;
import e.e.a.p;
import e.e.a.q;
import e.e.b.c;
import e.e.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TokenShareUtility
  implements ITokenShareInternal
{
  public static final String AUDIENCE_PATH_CONSUMERS = "/consumers";
  public static final String TAG = "TokenShareUtility";
  public static final Map<String, String> sClaimRemapper = new HashMap();
  public static final String sHomeTenantAuthority = "https://login.windows.net/common";
  public final String mClientId;
  public final String mDefaultAuthority;
  public final String mRedirectUri;
  public final MsalOAuth2TokenCache mTokenCache;
  
  static
  {
    applyV1ToV2Mappings();
  }
  
  public TokenShareUtility(String paramString1, String paramString2, String paramString3, MsalOAuth2TokenCache paramMsalOAuth2TokenCache)
  {
    mClientId = paramString1;
    mRedirectUri = paramString2;
    mDefaultAuthority = paramString3;
    mTokenCache = paramMsalOAuth2TokenCache;
  }
  
  public static ADALTokenCacheItem adapt(IdTokenRecord paramIdTokenRecord, RefreshTokenRecord paramRefreshTokenRecord)
  {
    ADALTokenCacheItem localADALTokenCacheItem = new ADALTokenCacheItem();
    localADALTokenCacheItem.setClientId(paramRefreshTokenRecord.getClientId());
    localADALTokenCacheItem.setRefreshToken(paramRefreshTokenRecord.getSecret());
    localADALTokenCacheItem.setRawIdToken(mintV1IdTokenFromRawV2IdToken(paramIdTokenRecord.getSecret()));
    localADALTokenCacheItem.setFamilyClientId(paramRefreshTokenRecord.getFamilyId());
    if (isFromHomeTenant(paramIdTokenRecord)) {
      paramIdTokenRecord = "https://login.windows.net/common";
    } else {
      paramIdTokenRecord = paramIdTokenRecord.getAuthority();
    }
    localADALTokenCacheItem.setAuthority(paramIdTokenRecord);
    return localADALTokenCacheItem;
  }
  
  public static void applyV1ToV2Mappings()
  {
    sClaimRemapper.put("preferred_username", "upn");
  }
  
  private ADALTokenCacheItem createTokenCacheItem(String paramString1, String paramString2)
  {
    ADALTokenCacheItem localADALTokenCacheItem = new ADALTokenCacheItem();
    localADALTokenCacheItem.setAuthority(paramString2);
    localADALTokenCacheItem.setClientId(mClientId);
    localADALTokenCacheItem.setRefreshToken(paramString1);
    return localADALTokenCacheItem;
  }
  
  private AccountRecord getAccountRecordForIdentifier(String paramString)
  {
    AccountRecord localAccountRecord1 = mTokenCache.getAccountByLocalAccountId(null, mClientId, paramString);
    AccountRecord localAccountRecord2 = localAccountRecord1;
    if (localAccountRecord1 == null)
    {
      paramString = mTokenCache.getAccountsByUsername(null, mClientId, paramString);
      localAccountRecord2 = localAccountRecord1;
      if (!paramString.isEmpty()) {
        localAccountRecord2 = (AccountRecord)paramString.get(0);
      }
    }
    if (localAccountRecord2 != null) {
      return localAccountRecord2;
    }
    throw new ClientException("token_cache_item_not_found");
  }
  
  private ICacheRecord getCacheRecordForIdentifier(String paramString)
  {
    paramString = getAccountRecordForIdentifier(paramString);
    return mTokenCache.load(mClientId, null, paramString, new BearerAuthenticationSchemeInternal());
  }
  
  public static boolean isFromHomeTenant(IdTokenRecord paramIdTokenRecord)
  {
    String str = paramIdTokenRecord.getHomeAccountId();
    boolean bool1 = false;
    boolean bool2;
    try
    {
      paramIdTokenRecord = (String)IDToken.parseJWT(paramIdTokenRecord.getSecret()).get("oid");
      if (paramIdTokenRecord != null)
      {
        bool2 = str.contains(paramIdTokenRecord);
      }
      else
      {
        paramIdTokenRecord = new java/lang/StringBuilder;
        paramIdTokenRecord.<init>();
        paramIdTokenRecord.append(TAG);
        paramIdTokenRecord.append(":isFromHomeTenant");
        Logger.warn(paramIdTokenRecord.toString(), "OID claims was missing from token.");
        bool2 = bool1;
      }
    }
    catch (ServiceException paramIdTokenRecord)
    {
      e.a.a.a.a.c(new StringBuilder(), TAG, ":isFromHomeTenant", "Failed to parse IdToken.");
      bool2 = bool1;
    }
    return bool2;
  }
  
  public static String mintV1IdTokenFromRawV2IdToken(String paramString)
  {
    paramString = IDToken.parseJWT(paramString);
    Object localObject = new LinkedHashMap();
    Iterator localIterator = paramString.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramString = (Map.Entry)localIterator.next();
      String str = (String)paramString.getKey();
      paramString = paramString.getValue();
      if ("ver".equals(str)) {
        paramString = "1";
      }
      ((HashMap)localObject).put(remap(str), paramString);
    }
    paramString = new c((Map)localObject, null);
    paramString = new d(new q(h.y, null, null, null, null), paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(z.a().x);
    ((StringBuilder)localObject).append('.');
    ((StringBuilder)localObject).append(x.a().x);
    ((StringBuilder)localObject).append('.');
    return ((StringBuilder)localObject).toString();
  }
  
  public static String remap(String paramString)
  {
    String str = (String)sClaimRemapper.get(paramString);
    if (str != null) {
      paramString = str;
    }
    return paramString;
  }
  
  private void saveResult(Pair<MicrosoftAccount, MicrosoftRefreshToken> paramPair)
  {
    if (paramPair != null) {
      mTokenCache.setSingleSignOnState((BaseAccount)first, (RefreshToken)second);
    }
  }
  
  private void throwIfCacheRecordIncomplete(String paramString, ICacheRecord paramICacheRecord)
  {
    if ((paramICacheRecord.getRefreshToken() != null) && (paramICacheRecord.getIdToken() != null)) {
      return;
    }
    String str = e.a.a.a.a.a(new StringBuilder(), TAG, ":throwIfCacheRecordIncomplete");
    paramICacheRecord = new StringBuilder();
    paramICacheRecord.append("That's strange, we had an AccountRecord for identifier: ");
    paramICacheRecord.append(paramString);
    paramICacheRecord.append(" but couldn't find tokens for them.");
    Logger.warn(str, paramICacheRecord.toString());
    throw new ClientException("token_cache_item_not_found");
  }
  
  public String getMsaFamilyRefreshToken(String paramString)
  {
    ICacheRecord localICacheRecord = getCacheRecordForIdentifier(paramString);
    throwIfCacheRecordIncomplete(paramString, localICacheRecord);
    return localICacheRecord.getRefreshToken().getSecret();
  }
  
  public String getOrgIdFamilyRefreshToken(String paramString)
  {
    ICacheRecord localICacheRecord = getCacheRecordForIdentifier(paramString);
    throwIfCacheRecordIncomplete(paramString, localICacheRecord);
    return SSOStateSerializer.serialize(adapt(localICacheRecord.getIdToken(), localICacheRecord.getRefreshToken()));
  }
  
  public void saveMsaFamilyRefreshToken(final String paramString)
  {
    saveResult((Pair)TokenCacheItemMigrationAdapter.sBackgroundExecutor.submit(new Callable()
    {
      public Pair<MicrosoftAccount, MicrosoftRefreshToken> call()
      {
        Object localObject = Uri.parse(TokenShareUtility.access$300(TokenShareUtility.this)).getPath();
        if (localObject != null) {
          localObject = TokenShareUtility.access$300(TokenShareUtility.this).replace((CharSequence)localObject, "/consumers");
        } else {
          localObject = TokenShareUtility.access$300(TokenShareUtility.this);
        }
        localObject = TokenShareUtility.access$400(TokenShareUtility.this, paramString, (String)localObject);
        if (!AdalMigrationAdapter.loadCloudDiscoveryMetadata())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TokenShareUtility.access$100());
          ((StringBuilder)localObject).append("saveMsaFamilyRefreshToken");
          Logger.warn(((StringBuilder)localObject).toString(), "Failed to load cloud metadata, aborting.");
          return null;
        }
        return TokenCacheItemMigrationAdapter.renewToken(TokenShareUtility.access$200(TokenShareUtility.this), (ITokenCacheItem)localObject);
      }
    }).get());
  }
  
  public void saveOrgIdFamilyRefreshToken(final String paramString)
  {
    saveResult((Pair)TokenCacheItemMigrationAdapter.sBackgroundExecutor.submit(new Callable()
    {
      public Pair<MicrosoftAccount, MicrosoftRefreshToken> call()
      {
        Object localObject = SSOStateSerializer.deserialize(paramString);
        ((ADALTokenCacheItem)localObject).setClientId(TokenShareUtility.access$000(TokenShareUtility.this));
        ((ADALTokenCacheItem)localObject).setResource(null);
        if (!AdalMigrationAdapter.loadCloudDiscoveryMetadata())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TokenShareUtility.access$100());
          ((StringBuilder)localObject).append("saveOrgIdFamilyRefreshToken");
          Logger.warn(((StringBuilder)localObject).toString(), "Failed to load cloud metadata, aborting.");
          return null;
        }
        return TokenCacheItemMigrationAdapter.renewToken(TokenShareUtility.access$200(TokenShareUtility.this), (ITokenCacheItem)localObject);
      }
    }).get());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */