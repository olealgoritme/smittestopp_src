package com.microsoft.identity.common.internal.migration;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.authscheme.BearerAuthenticationSchemeInternal;
import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.internal.cache.BrokerOAuth2TokenCache;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.cache.ITokenCacheItem;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenResponse;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Configuration;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsRefreshToken;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsTokenRequest;
import com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse;
import com.microsoft.identity.common.internal.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.internal.providers.oauth2.TokenResult;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenCacheItemMigrationAdapter
{
  public static final String COMMON = "/common";
  public static final String DEFAULT_SCOPES = "openid profile offline_access";
  public static final String RESOURCE_DEFAULT_SCOPE = "/.default";
  public static final String TAG = "TokenCacheItemMigrationAdapter";
  public static final ExecutorService sBackgroundExecutor = ;
  
  public static MicrosoftStsAuthorizationRequest createAuthRequest(MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, ICacheRecord paramICacheRecord, String paramString1, String paramString2, String paramString3, UUID paramUUID)
  {
    return ((MicrosoftStsAuthorizationRequest.Builder)((MicrosoftStsAuthorizationRequest.Builder)((MicrosoftStsAuthorizationRequest.Builder)((MicrosoftStsAuthorizationRequest.Builder)paramMicrosoftStsOAuth2Strategy.createAuthorizationRequestBuilder(paramICacheRecord.getAccount()).setClientId(paramString1)).setRedirectUri(paramString2)).setCorrelationId(paramUUID)).setScope(paramString3)).build();
  }
  
  public static MicrosoftStsTokenRequest createTokenRequest(String paramString1, String paramString2, String paramString3, String paramString4, MicrosoftStsOAuth2Strategy paramMicrosoftStsOAuth2Strategy, UUID paramUUID, String paramString5)
  {
    paramMicrosoftStsOAuth2Strategy = paramMicrosoftStsOAuth2Strategy.createRefreshTokenRequest(new BearerAuthenticationSchemeInternal());
    paramMicrosoftStsOAuth2Strategy.setClientId(paramString1);
    paramMicrosoftStsOAuth2Strategy.setScope(paramString2);
    paramMicrosoftStsOAuth2Strategy.setCorrelationId(paramUUID);
    paramMicrosoftStsOAuth2Strategy.setRefreshToken(paramString3);
    paramMicrosoftStsOAuth2Strategy.setRedirectUri(paramString4);
    paramMicrosoftStsOAuth2Strategy.setIdTokenVersion(paramString5);
    return paramMicrosoftStsOAuth2Strategy;
  }
  
  public static List<ADALTokenCacheItem> filterDuplicateTokens(Collection<ADALTokenCacheItem> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      ADALTokenCacheItem localADALTokenCacheItem = (ADALTokenCacheItem)paramCollection.next();
      if (localADALTokenCacheItem.getResource() == null)
      {
        Logger.warn(TAG, "Skipping resourceless token.");
      }
      else
      {
        if (localHashMap.get(localADALTokenCacheItem.getRefreshToken()) == null) {
          localHashMap.put(localADALTokenCacheItem.getRefreshToken(), localADALTokenCacheItem);
        }
        if ((localHashMap.get(localADALTokenCacheItem.getRefreshToken()) != null) && (localADALTokenCacheItem.getAuthority().contains("/common"))) {
          localHashMap.put(localADALTokenCacheItem.getRefreshToken(), localADALTokenCacheItem);
        }
      }
    }
    localArrayList.addAll(localHashMap.values());
    return localArrayList;
  }
  
  public static ADALTokenCacheItem findFrt(List<ADALTokenCacheItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ADALTokenCacheItem)localIterator.next();
      if ((!StringExtensions.isNullOrBlank(paramList.getRefreshToken())) && (!StringExtensions.isNullOrBlank(paramList.getFamilyClientId())))
      {
        a.b(new StringBuilder(), TAG, ":findFrt", "Frt found.");
        return paramList;
      }
    }
    paramList = null;
    return paramList;
  }
  
  public static ADALTokenCacheItem findMrrt(List<ADALTokenCacheItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ADALTokenCacheItem)localIterator.next();
      if ((!StringExtensions.isNullOrBlank(paramList.getRefreshToken())) && (paramList.getIsMultiResourceRefreshToken()))
      {
        a.b(new StringBuilder(), TAG, ":findMrrt", "Mrrt found.");
        return paramList;
      }
    }
    paramList = null;
    return paramList;
  }
  
  public static ADALTokenCacheItem findRt(List<ADALTokenCacheItem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (ADALTokenCacheItem)localIterator.next();
      if (!StringExtensions.isNullOrBlank(paramList.getRefreshToken()))
      {
        a.b(new StringBuilder(), TAG, ":findRt", "RT found.");
        return paramList;
      }
    }
    paramList = null;
    return paramList;
  }
  
  public static String getScopeFromResource(String paramString)
  {
    return a.b(paramString, "/.default");
  }
  
  public static String getScopesForTokenRequest(String paramString)
  {
    return a.b(getScopeFromResource(paramString), " openid profile offline_access");
  }
  
  public static void logTokenResultError(UUID paramUUID, TokenResult paramTokenResult)
  {
    paramTokenResult = paramTokenResult.getErrorResponse();
    String str1 = TAG;
    String str2 = paramUUID.toString();
    StringBuilder localStringBuilder = a.a("Status code: [");
    localStringBuilder.append(paramTokenResult.getStatusCode());
    localStringBuilder.append("]");
    Logger.warn(str1, str2, localStringBuilder.toString());
    str1 = TAG;
    paramUUID = paramUUID.toString();
    localStringBuilder = a.a("Error description: [");
    localStringBuilder.append(paramTokenResult.getErrorDescription());
    localStringBuilder.append("]");
    Logger.warn(str1, paramUUID, localStringBuilder.toString());
  }
  
  public static List<Pair<MicrosoftAccount, MicrosoftRefreshToken>> migrateTokens(Map<String, String> paramMap, Collection<ADALTokenCacheItem> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    if (AdalMigrationAdapter.loadCloudDiscoveryMetadata())
    {
      Object localObject = preferentiallySelectTokens(splitTokensByClientId(filterDuplicateTokens(paramCollection)));
      paramCollection = new ArrayList();
      localObject = ((Map)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramCollection.addAll((List)((Iterator)localObject).next());
      }
      localArrayList.addAll(renewTokens(paramMap, paramCollection));
    }
    return localArrayList;
  }
  
  public static Map<String, List<ADALTokenCacheItem>> preferentiallySelectTokens(Map<String, List<ADALTokenCacheItem>> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      String str = (String)paramMap.getKey();
      List localList = (List)paramMap.getValue();
      Object localObject = findFrt(localList);
      paramMap = (Map<String, List<ADALTokenCacheItem>>)localObject;
      if (localObject == null)
      {
        paramMap = new StringBuilder();
        paramMap.append(TAG);
        paramMap.append(":preferentiallySelectTokens");
        Logger.verbose(paramMap.toString(), "FRT was null. Try MRRT.");
        paramMap = findMrrt(localList);
      }
      localObject = paramMap;
      if (paramMap == null)
      {
        paramMap = new StringBuilder();
        paramMap.append(TAG);
        paramMap.append(":preferentiallySelectTokens");
        Logger.verbose(paramMap.toString(), "MRRT was null. Try RT.");
        localObject = findRt(localList);
      }
      if (localObject != null)
      {
        if (localHashMap.get(str) == null) {
          localHashMap.put(str, new ArrayList());
        }
        ((List)localHashMap.get(str)).add(localObject);
      }
      else
      {
        a.c(new StringBuilder(), TAG, ":preferentiallySelectTokens", "Refresh token could not be located.");
      }
    }
    return localHashMap;
  }
  
  public static Pair<MicrosoftAccount, MicrosoftRefreshToken> renewToken(String paramString, ITokenCacheItem paramITokenCacheItem)
  {
    boolean bool = StringExtensions.isNullOrBlank(paramString);
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (!bool) {
      try
      {
        localObject2 = paramITokenCacheItem.getAuthority();
        Object localObject3 = paramITokenCacheItem.getClientId();
        String str = paramITokenCacheItem.getRefreshToken();
        MicrosoftStsOAuth2Configuration localMicrosoftStsOAuth2Configuration = new com/microsoft/identity/common/internal/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Configuration;
        localMicrosoftStsOAuth2Configuration.<init>();
        Object localObject4 = new java/net/URL;
        ((URL)localObject4).<init>((String)localObject2);
        localMicrosoftStsOAuth2Configuration.setAuthorityUrl((URL)localObject4);
        localObject4 = UUID.randomUUID();
        if (TextUtils.isEmpty(paramITokenCacheItem.getResource())) {}
        for (paramITokenCacheItem = "openid profile offline_access";; paramITokenCacheItem = getScopesForTokenRequest(paramITokenCacheItem.getResource())) {
          break;
        }
        OAuth2StrategyParameters localOAuth2StrategyParameters = new com/microsoft/identity/common/internal/providers/oauth2/OAuth2StrategyParameters;
        localOAuth2StrategyParameters.<init>();
        MicrosoftStsOAuth2Strategy localMicrosoftStsOAuth2Strategy = new com/microsoft/identity/common/internal/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Strategy;
        localMicrosoftStsOAuth2Strategy.<init>(localMicrosoftStsOAuth2Configuration, localOAuth2StrategyParameters);
        paramString = localMicrosoftStsOAuth2Strategy.requestToken(createTokenRequest((String)localObject3, paramITokenCacheItem, str, paramString, localMicrosoftStsOAuth2Strategy, (UUID)localObject4, "2"));
        if (paramString.getSuccess())
        {
          paramITokenCacheItem = (MicrosoftStsTokenResponse)paramString.getTokenResponse();
          paramITokenCacheItem.setClientId((String)localObject3);
          localObject3 = localMicrosoftStsOAuth2Strategy.createAccount(paramITokenCacheItem);
          paramString = new com/microsoft/identity/common/internal/providers/microsoft/microsoftsts/MicrosoftStsRefreshToken;
          paramString.<init>(paramITokenCacheItem);
          paramITokenCacheItem = new java/net/URL;
          paramITokenCacheItem.<init>((String)localObject2);
          paramString.setEnvironment(AzureActiveDirectory.getAzureActiveDirectoryCloud(paramITokenCacheItem).getPreferredCacheHostName());
          localObject2 = new android/util/Pair;
          ((Pair)localObject2).<init>(localObject3, paramString);
        }
        else
        {
          Logger.warn(TAG, ((UUID)localObject4).toString(), "TokenRequest was unsuccessful.");
          localObject2 = localObject1;
          if (paramString.getErrorResponse() != null)
          {
            logTokenResultError((UUID)localObject4, paramString);
            localObject2 = localObject1;
          }
        }
      }
      catch (Exception paramString)
      {
        Logger.errorPII(TAG, "Failed to request new refresh token...", paramString);
        localObject2 = localObject1;
      }
    }
    return (Pair<MicrosoftAccount, MicrosoftRefreshToken>)localObject2;
  }
  
  public static List<Pair<MicrosoftAccount, MicrosoftRefreshToken>> renewTokens(Map<String, String> paramMap, List<ADALTokenCacheItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramList.size();
    CountDownLatch localCountDownLatch = new CountDownLatch(i);
    for (int j = 0; j < i; j++) {
      sBackgroundExecutor.submit(new TokenCacheItemMigrationAdapter.1(paramList, j, paramMap, localArrayList, localCountDownLatch));
    }
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException paramMap)
    {
      Logger.error(TAG, "Interrupted while requesting tokens...", paramMap);
      Thread.currentThread().interrupt();
    }
    return localArrayList;
  }
  
  public static Map<String, List<ADALTokenCacheItem>> splitTokensByClientId(List<ADALTokenCacheItem> paramList)
  {
    Object localObject1 = a.a(new StringBuilder(), TAG, ":splitTokensByClientId");
    Object localObject2 = a.a("Splitting [");
    ((StringBuilder)localObject2).append(paramList.size());
    ((StringBuilder)localObject2).append("] cache items.");
    Logger.verbose((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = new HashMap();
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramList = (ADALTokenCacheItem)((Iterator)localObject1).next();
      if (((HashMap)localObject2).get(paramList.getClientId()) == null) {
        ((HashMap)localObject2).put(paramList.getClientId(), new ArrayList());
      }
      ((List)((HashMap)localObject2).get(paramList.getClientId())).add(paramList);
    }
    return (Map<String, List<ADALTokenCacheItem>>)localObject2;
  }
  
  public static boolean tryFociTokenWithGivenClientId(BrokerOAuth2TokenCache paramBrokerOAuth2TokenCache, String paramString1, String paramString2, ICacheRecord paramICacheRecord)
  {
    Object localObject1 = new MicrosoftStsOAuth2Configuration();
    Object localObject2 = new Uri.Builder();
    Object localObject3 = paramICacheRecord.getAccount().getRealm();
    Object localObject4 = ((Uri.Builder)localObject2).scheme("https").authority(paramICacheRecord.getRefreshToken().getEnvironment());
    Object localObject5 = localObject3;
    if (StringUtil.isEmpty((String)localObject3)) {
      localObject5 = "common";
    }
    ((Uri.Builder)localObject4).appendPath((String)localObject5);
    ((AzureActiveDirectoryOAuth2Configuration)localObject1).setAuthorityUrl(new URL(((Uri.Builder)localObject2).build().toString()));
    localObject5 = new MicrosoftStsOAuth2Strategy((MicrosoftStsOAuth2Configuration)localObject1, new OAuth2StrategyParameters());
    Object localObject6 = paramICacheRecord.getRefreshToken().getSecret();
    localObject1 = paramICacheRecord.getRefreshToken().getTarget();
    localObject3 = UUID.randomUUID();
    localObject2 = a.a(new StringBuilder(), TAG, ":tryFociTokenWithGivenClientId");
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("Create the token request with correlationId [");
    ((StringBuilder)localObject4).append(localObject3);
    ((StringBuilder)localObject4).append("]");
    Logger.verbose((String)localObject2, ((StringBuilder)localObject4).toString());
    localObject6 = createTokenRequest(paramString1, (String)localObject1, (String)localObject6, paramString2, (MicrosoftStsOAuth2Strategy)localObject5, (UUID)localObject3, "2");
    localObject4 = a.a(new StringBuilder(), TAG, ":tryFociTokenWithGivenClientId");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Start refreshing token with correlationId [");
    ((StringBuilder)localObject2).append(localObject3);
    ((StringBuilder)localObject2).append("]");
    Logger.verbose((String)localObject4, ((StringBuilder)localObject2).toString());
    localObject2 = ((OAuth2Strategy)localObject5).requestToken((TokenRequest)localObject6);
    localObject6 = a.a(new StringBuilder(), TAG, ":tryFociTokenWithGivenClientId");
    localObject4 = a.a("Is the client ID able to use the foci? [");
    ((StringBuilder)localObject4).append(((TokenResult)localObject2).getSuccess());
    ((StringBuilder)localObject4).append("] with correlationId [");
    ((StringBuilder)localObject4).append(localObject3);
    ((StringBuilder)localObject4).append("]");
    Logger.verbose((String)localObject6, ((StringBuilder)localObject4).toString());
    if (((TokenResult)localObject2).getSuccess())
    {
      localObject3 = createAuthRequest((MicrosoftStsOAuth2Strategy)localObject5, paramICacheRecord, paramString1, paramString2, (String)localObject1, (UUID)localObject3);
      paramString2 = a.a(new StringBuilder(), TAG, ":tryFociTokenWithGivenClientId");
      paramICacheRecord = new StringBuilder();
      paramICacheRecord.append("Saving records to cache with client id");
      paramICacheRecord.append(paramString1);
      Logger.verbose(paramString2, paramICacheRecord.toString());
      paramBrokerOAuth2TokenCache.save((OAuth2Strategy)localObject5, (AuthorizationRequest)localObject3, (MicrosoftTokenResponse)((TokenResult)localObject2).getTokenResponse());
    }
    return ((TokenResult)localObject2).getSuccess();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */