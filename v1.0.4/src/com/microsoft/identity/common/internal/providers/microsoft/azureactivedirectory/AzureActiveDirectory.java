package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.authorities.Environment;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.net.HttpRequest;
import com.microsoft.identity.common.internal.net.HttpResponse;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.internal.providers.IdentityProvider;
import com.microsoft.identity.common.internal.providers.oauth2.OAuth2StrategyParameters;
import e.c.c.x.a;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AzureActiveDirectory
  extends IdentityProvider<AzureActiveDirectoryOAuth2Strategy, AzureActiveDirectoryOAuth2Configuration>
{
  public static final String AAD_INSTANCE_DISCOVERY_ENDPOINT = "/common/discovery/instance";
  public static final String API_VERSION = "api-version";
  public static final String API_VERSION_VALUE = "1.1";
  public static final String AUTHORIZATION_ENDPOINT = "authorization_endpoint";
  public static final String AUTHORIZATION_ENDPOINT_VALUE = "https://login.microsoftonline.com/common/oauth2/v2.0/authorize";
  public static final String METADATA = "metadata";
  public static final String TENANT_DISCOVERY_ENDPOINT = "tenant_discovery_endpoint";
  public static ConcurrentMap<String, AzureActiveDirectoryCloud> sAadClouds = new ConcurrentHashMap();
  public static Environment sEnvironment = Environment.Production;
  public static boolean sIsInitialized = false;
  
  public static List<AzureActiveDirectoryCloud> deserializeClouds(String paramString)
  {
    Type localType = new AzureActiveDirectory.1().getType();
    return (List)new Gson().a(paramString, localType);
  }
  
  public static AzureActiveDirectoryCloud getAzureActiveDirectoryCloud(URL paramURL)
  {
    return (AzureActiveDirectoryCloud)sAadClouds.get(paramURL.getHost().toLowerCase(Locale.US));
  }
  
  public static AzureActiveDirectoryCloud getAzureActiveDirectoryCloudFromHostName(String paramString)
  {
    return (AzureActiveDirectoryCloud)sAadClouds.get(paramString.toLowerCase(Locale.US));
  }
  
  public static List<AzureActiveDirectoryCloud> getClouds()
  {
    if (sAadClouds != null) {
      return new ArrayList(sAadClouds.values());
    }
    return new ArrayList();
  }
  
  public static String getDefaultCloudUrl()
  {
    if (sEnvironment == Environment.PreProduction) {
      return "https://login.windows-ppe.net";
    }
    return "https://login.microsoftonline.com";
  }
  
  public static Environment getEnvironment()
  {
    return sEnvironment;
  }
  
  public static Set<String> getHosts()
  {
    ConcurrentMap localConcurrentMap = sAadClouds;
    if (localConcurrentMap != null) {
      return localConcurrentMap.keySet();
    }
    return null;
  }
  
  public static boolean hasCloudHost(URL paramURL)
  {
    return sAadClouds.containsKey(paramURL.getHost().toLowerCase(Locale.US));
  }
  
  public static void initializeCloudMetadata(String paramString, Map<String, String> paramMap)
  {
    boolean bool = paramMap.containsKey("tenant_discovery_endpoint");
    paramMap = (String)paramMap.get("metadata");
    if (!bool)
    {
      sAadClouds.put(paramString, new AzureActiveDirectoryCloud(false));
      return;
    }
    if (StringExtensions.isNullOrBlank(paramMap))
    {
      sAadClouds.put(paramString, new AzureActiveDirectoryCloud(paramString, paramString));
      return;
    }
    paramMap = deserializeClouds(paramMap).iterator();
    while (paramMap.hasNext())
    {
      paramString = (AzureActiveDirectoryCloud)paramMap.next();
      paramString.setIsValidated(true);
      Iterator localIterator = paramString.getHostAliases().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        sAadClouds.put(str.toLowerCase(Locale.US), paramString);
      }
    }
    sIsInitialized = true;
  }
  
  public static boolean isInitialized()
  {
    return sIsInitialized;
  }
  
  public static boolean isValidCloudHost(URL paramURL)
  {
    boolean bool;
    if ((hasCloudHost(paramURL)) && (getAzureActiveDirectoryCloud(paramURL).isValidated())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void performCloudDiscovery()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getDefaultCloudUrl());
    ((StringBuilder)localObject1).append("/common/discovery/instance");
    Object localObject2 = Uri.parse(((StringBuilder)localObject1).toString()).buildUpon().appendQueryParameter("api-version", "1.1").appendQueryParameter("authorization_endpoint", "https://login.microsoftonline.com/common/oauth2/v2.0/authorize").build();
    localObject1 = new HashMap();
    ((HashMap)localObject1).putAll(EstsTelemetry.getInstance().getTelemetryHeaders());
    localObject1 = HttpRequest.sendGet(new URL(((Uri)localObject2).toString()), (Map)localObject1);
    if (((HttpResponse)localObject1).getStatusCode() >= 400)
    {
      Log.d("Discovery", "Error getting cloud information");
    }
    else
    {
      HttpCache.flush();
      Iterator localIterator = ((AzureActiveDirectoryInstanceResponse)ObjectMapper.deserializeJsonStringToObject(((HttpResponse)localObject1).getBody(), AzureActiveDirectoryInstanceResponse.class)).getClouds().iterator();
      while (localIterator.hasNext())
      {
        AzureActiveDirectoryCloud localAzureActiveDirectoryCloud = (AzureActiveDirectoryCloud)localIterator.next();
        localAzureActiveDirectoryCloud.setIsValidated(true);
        localObject2 = localAzureActiveDirectoryCloud.getHostAliases().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (String)((Iterator)localObject2).next();
          sAadClouds.put(((String)localObject1).toLowerCase(Locale.US), localAzureActiveDirectoryCloud);
        }
      }
    }
    sIsInitialized = true;
  }
  
  public static void putCloud(String paramString, AzureActiveDirectoryCloud paramAzureActiveDirectoryCloud)
  {
    sAadClouds.put(paramString.toLowerCase(Locale.US), paramAzureActiveDirectoryCloud);
  }
  
  public static void setEnvironment(Environment paramEnvironment)
  {
    if (paramEnvironment != sEnvironment)
    {
      sIsInitialized = false;
      sEnvironment = paramEnvironment;
    }
  }
  
  public AzureActiveDirectoryOAuth2Strategy createOAuth2Strategy(AzureActiveDirectoryOAuth2Configuration paramAzureActiveDirectoryOAuth2Configuration)
  {
    return new AzureActiveDirectoryOAuth2Strategy(paramAzureActiveDirectoryOAuth2Configuration, new OAuth2StrategyParameters());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */