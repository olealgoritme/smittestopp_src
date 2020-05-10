package com.microsoft.azure.storage;

import com.microsoft.azure.storage.analytics.CloudAnalyticsClient;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageCredentialsHelper;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.file.CloudFileClient;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.table.CloudTableClient;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class CloudStorageAccount
{
  public static final String ACCOUNT_KEY_NAME = "AccountKey";
  public static final String ACCOUNT_NAME_NAME = "AccountName";
  public static final String ACCOUNT_TOKEN_NAME = "AccountToken";
  public static final String BLOB_ENDPOINT_NAME = "BlobEndpoint";
  public static final String BLOB_SECONDARY_ENDPOINT_NAME = "BlobSecondaryEndpoint";
  public static final String DEFAULT_DNS = "core.windows.net";
  public static final String DEFAULT_ENDPOINTS_PROTOCOL_NAME = "DefaultEndpointsProtocol";
  public static final String DEVELOPMENT_STORAGE_PRIMARY_ENDPOINT_FORMAT = "%s://%s:%s/%s";
  public static final String DEVELOPMENT_STORAGE_PROXY_URI_NAME = "DevelopmentStorageProxyUri";
  public static final String DEVELOPMENT_STORAGE_SECONDARY_ENDPOINT_FORMAT = "%s://%s:%s/%s-secondary";
  public static final String DEVSTORE_ACCOUNT_KEY = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
  public static final String DEVSTORE_ACCOUNT_NAME = "devstoreaccount1";
  public static final String DNS_NAME_FORMAT = "%s.%s";
  public static final String ENDPOINT_SUFFIX_NAME = "EndpointSuffix";
  public static final String FILE_ENDPOINT_NAME = "FileEndpoint";
  public static final String FILE_SECONDARY_ENDPOINT_NAME = "FileSecondaryEndpoint";
  public static final String PRIMARY_ENDPOINT_FORMAT = "%s://%s.%s";
  public static final String QUEUE_ENDPOINT_NAME = "QueueEndpoint";
  public static final String QUEUE_SECONDARY_ENDPOINT_NAME = "QueueSecondaryEndpoint";
  public static final String SECONDARY_ENDPOINT_FORMAT = "%s://%s%s.%s";
  public static final String SECONDARY_LOCATION_ACCOUNT_SUFFIX = "-secondary";
  public static final String SHARED_ACCESS_SIGNATURE_NAME = "SharedAccessSignature";
  public static final String TABLE_ENDPOINT_NAME = "TableEndpoint";
  public static final String TABLE_SECONDARY_ENDPOINT_NAME = "TableSecondaryEndpoint";
  public static final String USE_DEVELOPMENT_STORAGE_NAME = "UseDevelopmentStorage";
  public static ConnectionStringFilter validCredentials = matchesOne(new ConnectionStringFilter[] { matchesAll(new ConnectionStringFilter[] { allRequired(new String[] { "AccountName", "AccountKey" }), none(new String[] { "SharedAccessSignature" }) }), matchesAll(new ConnectionStringFilter[] { allRequired(new String[] { "SharedAccessSignature" }), optional(new String[] { "AccountName" }), none(new String[] { "AccountKey" }) }), none(new String[] { "AccountName", "AccountKey", "SharedAccessSignature" }) });
  public String accountName;
  public final StorageUri blobStorageUri;
  public StorageCredentials credentials;
  public String endpointSuffix;
  public final StorageUri fileStorageUri;
  public boolean isBlobEndpointDefault = false;
  public boolean isDevStoreAccount = false;
  public boolean isFileEndpointDefault = false;
  public boolean isQueueEndpointDefault = false;
  public boolean isTableEndpointDefault = false;
  public final StorageUri queueStorageUri;
  public final StorageUri tableStorageUri;
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials)
  {
    this(paramStorageCredentials, false, null);
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, StorageUri paramStorageUri1, StorageUri paramStorageUri2, StorageUri paramStorageUri3)
  {
    this(paramStorageCredentials, paramStorageUri1, paramStorageUri2, paramStorageUri3, null);
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, StorageUri paramStorageUri1, StorageUri paramStorageUri2, StorageUri paramStorageUri3, StorageUri paramStorageUri4)
  {
    credentials = paramStorageCredentials;
    blobStorageUri = paramStorageUri1;
    fileStorageUri = paramStorageUri4;
    queueStorageUri = paramStorageUri2;
    tableStorageUri = paramStorageUri3;
    endpointSuffix = null;
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, URI paramURI1, URI paramURI2, URI paramURI3)
  {
    this(paramStorageCredentials, new StorageUri(paramURI1), new StorageUri(paramURI2), new StorageUri(paramURI3), null);
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, URI paramURI1, URI paramURI2, URI paramURI3, URI paramURI4)
  {
    this(paramStorageCredentials, new StorageUri(paramURI1), new StorageUri(paramURI2), new StorageUri(paramURI3), new StorageUri(paramURI4));
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, boolean paramBoolean)
  {
    this(paramStorageCredentials, paramBoolean, null);
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, boolean paramBoolean, String paramString)
  {
    this(paramStorageCredentials, paramBoolean, paramString, null);
  }
  
  public CloudStorageAccount(StorageCredentials paramStorageCredentials, boolean paramBoolean, String paramString1, String paramString2)
  {
    Utility.assertNotNull("storageCredentials", paramStorageCredentials);
    String str;
    if (Utility.isNullOrEmpty(paramString2))
    {
      str = paramStorageCredentials.getAccountName();
    }
    else
    {
      str = paramString2;
      if (!Utility.isNullOrEmpty(paramStorageCredentials.getAccountName())) {
        if (paramString2.equals(paramStorageCredentials.getAccountName())) {
          str = paramString2;
        } else {
          throw new IllegalArgumentException("The account name does not match the existing account name on the credentials.");
        }
      }
    }
    if (paramBoolean) {
      paramString2 = "https";
    } else {
      paramString2 = "http";
    }
    credentials = paramStorageCredentials;
    blobStorageUri = getDefaultStorageUri(paramString2, str, getDNS("blob", paramString1));
    fileStorageUri = getDefaultStorageUri(paramString2, str, getDNS("file", paramString1));
    queueStorageUri = getDefaultStorageUri(paramString2, str, getDNS("queue", paramString1));
    tableStorageUri = getDefaultStorageUri(paramString2, str, getDNS("table", paramString1));
    endpointSuffix = paramString1;
    isBlobEndpointDefault = true;
    isFileEndpointDefault = true;
    isQueueEndpointDefault = true;
    isTableEndpointDefault = true;
  }
  
  public static ConnectionStringFilter allRequired(String... paramVarArgs)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        paramAnonymousMap = new HashMap(paramAnonymousMap);
        String[] arrayOfString = val$settingNames;
        int i = arrayOfString.length;
        int j = 0;
        while (j < i)
        {
          String str = arrayOfString[j];
          if (paramAnonymousMap.containsKey(str))
          {
            paramAnonymousMap.remove(str);
            j++;
          }
          else
          {
            return null;
          }
        }
        return paramAnonymousMap;
      }
    };
  }
  
  public static ConnectionStringFilter atLeastOne(String... paramVarArgs)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        HashMap localHashMap = new HashMap(paramAnonymousMap);
        int i = 0;
        paramAnonymousMap = Boolean.valueOf(false);
        String[] arrayOfString = val$settingNames;
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (localHashMap.containsKey(str))
          {
            localHashMap.remove(str);
            paramAnonymousMap = Boolean.valueOf(true);
          }
          i++;
        }
        if (paramAnonymousMap.booleanValue()) {
          paramAnonymousMap = localHashMap;
        } else {
          paramAnonymousMap = null;
        }
        return paramAnonymousMap;
      }
    };
  }
  
  public static String getDNS(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "core.windows.net";
    }
    return String.format("%s.%s", new Object[] { paramString1, str });
  }
  
  public static StorageUri getDefaultStorageUri(String paramString1, String paramString2, String paramString3)
  {
    if (!Utility.isNullOrEmpty(paramString1))
    {
      if (!Utility.isNullOrEmpty(paramString2)) {
        return new StorageUri(new URI(String.format("%s://%s.%s", new Object[] { paramString1, paramString2, paramString3 })), new URI(String.format("%s://%s%s.%s", new Object[] { paramString1, paramString2, "-secondary", paramString3 })));
      }
      throw new IllegalArgumentException("The account name is null or empty.");
    }
    throw new IllegalArgumentException("The protocol to use is null. Please specify whether to use http or https.");
  }
  
  public static CloudStorageAccount getDevelopmentStorageAccount()
  {
    Object localObject = null;
    try
    {
      CloudStorageAccount localCloudStorageAccount = getDevelopmentStorageAccount(null);
      localObject = localCloudStorageAccount;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;) {}
    }
    return (CloudStorageAccount)localObject;
  }
  
  public static CloudStorageAccount getDevelopmentStorageAccount(URI paramURI)
  {
    String str;
    if (paramURI == null)
    {
      str = "http";
      paramURI = "127.0.0.1";
    }
    else
    {
      str = paramURI.getScheme();
      paramURI = paramURI.getHost();
    }
    StorageCredentialsAccountAndKey localStorageCredentialsAccountAndKey = new StorageCredentialsAccountAndKey("devstoreaccount1", "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==");
    URI localURI1 = new URI(String.format("%s://%s:%s/%s", new Object[] { str, paramURI, "10000", "devstoreaccount1" }));
    URI localURI2 = new URI(String.format("%s://%s:%s/%s", new Object[] { str, paramURI, "10001", "devstoreaccount1" }));
    URI localURI3 = new URI(String.format("%s://%s:%s/%s", new Object[] { str, paramURI, "10002", "devstoreaccount1" }));
    URI localURI4 = new URI(String.format("%s://%s:%s/%s-secondary", new Object[] { str, paramURI, "10000", "devstoreaccount1" }));
    URI localURI5 = new URI(String.format("%s://%s:%s/%s-secondary", new Object[] { str, paramURI, "10001", "devstoreaccount1" }));
    paramURI = new URI(String.format("%s://%s:%s/%s-secondary", new Object[] { str, paramURI, "10002", "devstoreaccount1" }));
    paramURI = new CloudStorageAccount(localStorageCredentialsAccountAndKey, new StorageUri(localURI1, localURI4), new StorageUri(localURI2, localURI5), new StorageUri(localURI3, paramURI), null);
    isDevStoreAccount = true;
    return paramURI;
  }
  
  public static StorageUri getStorageUri(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3, Boolean paramBoolean)
  {
    paramString2 = settingOrDefault(paramMap, paramString2);
    paramString3 = settingOrDefault(paramMap, paramString3);
    if ((paramString3 != null) && (paramString2 != null)) {
      return new StorageUri(new URI(paramString2), new URI(paramString3));
    }
    if (paramString2 != null) {
      return new StorageUri(new URI(paramString2));
    }
    if (paramBoolean.booleanValue()) {
      return getDefaultStorageUri((String)paramMap.get("DefaultEndpointsProtocol"), (String)paramMap.get("AccountName"), getDNS(paramString1, (String)paramMap.get("EndpointSuffix")));
    }
    return null;
  }
  
  public static Boolean isValidEndpointPair(String paramString1, String paramString2)
  {
    boolean bool;
    if ((paramString1 == null) && (paramString2 != null)) {
      bool = false;
    } else {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public static ConnectionStringFilter matchesAll(ConnectionStringFilter... paramVarArgs)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        paramAnonymousMap = new HashMap(paramAnonymousMap);
        for (CloudStorageAccount.ConnectionStringFilter localConnectionStringFilter : val$filters)
        {
          if (paramAnonymousMap == null) {
            break;
          }
          paramAnonymousMap = localConnectionStringFilter.apply(paramAnonymousMap);
        }
        return paramAnonymousMap;
      }
    };
  }
  
  public static ConnectionStringFilter matchesExactly(ConnectionStringFilter paramConnectionStringFilter)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        paramAnonymousMap = new HashMap(paramAnonymousMap);
        paramAnonymousMap = val$filter.apply(paramAnonymousMap);
        if ((paramAnonymousMap != null) && (paramAnonymousMap.isEmpty())) {
          return paramAnonymousMap;
        }
        return null;
      }
    };
  }
  
  public static ConnectionStringFilter matchesOne(ConnectionStringFilter... paramVarArgs)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        CloudStorageAccount.ConnectionStringFilter[] arrayOfConnectionStringFilter = val$filters;
        int i = arrayOfConnectionStringFilter.length;
        int j = 0;
        Object localObject2;
        for (Object localObject1 = null; j < i; localObject1 = localObject2)
        {
          Map localMap = arrayOfConnectionStringFilter[j].apply(new HashMap(paramAnonymousMap));
          localObject2 = localObject1;
          if (localMap != null) {
            if (localObject1 == null) {
              localObject2 = localMap;
            } else {
              return null;
            }
          }
          j++;
        }
        return (Map<String, String>)localObject1;
      }
    };
  }
  
  public static Boolean matchesSpecification(Map<String, String> paramMap, ConnectionStringFilter... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    while (j < i)
    {
      paramMap = paramVarArgs[j].apply(paramMap);
      if (paramMap == null) {
        return localBoolean;
      }
      j++;
    }
    if (paramMap.isEmpty()) {
      return Boolean.valueOf(true);
    }
    return localBoolean;
  }
  
  public static ConnectionStringFilter none(String... paramVarArgs)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        HashMap localHashMap = new HashMap(paramAnonymousMap);
        int i = 0;
        paramAnonymousMap = Boolean.valueOf(false);
        String[] arrayOfString = val$settingNames;
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (localHashMap.containsKey(str))
          {
            localHashMap.remove(str);
            paramAnonymousMap = Boolean.valueOf(true);
          }
          i++;
        }
        if (paramAnonymousMap.booleanValue()) {
          localHashMap = null;
        }
        return localHashMap;
      }
    };
  }
  
  public static ConnectionStringFilter optional(String... paramVarArgs)
  {
    new ConnectionStringFilter()
    {
      public Map<String, String> apply(Map<String, String> paramAnonymousMap)
      {
        HashMap localHashMap = new HashMap(paramAnonymousMap);
        for (paramAnonymousMap : val$settingNames) {
          if (localHashMap.containsKey(paramAnonymousMap)) {
            localHashMap.remove(paramAnonymousMap);
          }
        }
        return localHashMap;
      }
    };
  }
  
  public static CloudStorageAccount parse(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = Utility.parseAccountString(paramString);
      Iterator localIterator = paramString.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        if ((((Map.Entry)localObject).getValue() == null) || (((String)((Map.Entry)localObject).getValue()).equals(""))) {
          throw new IllegalArgumentException("Invalid connection string.");
        }
      }
      Object localObject = tryConfigureDevStore(paramString);
      if (localObject != null) {
        return (CloudStorageAccount)localObject;
      }
      paramString = tryConfigureServiceAccount(paramString);
      if (paramString != null) {
        return paramString;
      }
      throw new IllegalArgumentException("Invalid connection string.");
    }
    throw new IllegalArgumentException("Invalid connection string.");
  }
  
  public static String settingOrDefault(Map<String, String> paramMap, String paramString)
  {
    if (paramMap.containsKey(paramString)) {
      paramMap = (String)paramMap.get(paramString);
    } else {
      paramMap = null;
    }
    return paramMap;
  }
  
  public static CloudStorageAccount tryConfigureDevStore(Map<String, String> paramMap)
  {
    boolean bool = matchesSpecification(paramMap, new ConnectionStringFilter[] { allRequired(new String[] { "UseDevelopmentStorage" }), optional(new String[] { "DevelopmentStorageProxyUri" }) }).booleanValue();
    URI localURI = null;
    if (bool)
    {
      if (Boolean.parseBoolean((String)paramMap.get("UseDevelopmentStorage")))
      {
        if (paramMap.containsKey("DevelopmentStorageProxyUri")) {
          localURI = new URI((String)paramMap.get("DevelopmentStorageProxyUri"));
        }
        return getDevelopmentStorageAccount(localURI);
      }
      throw new IllegalArgumentException("Invalid connection string, the UseDevelopmentStorage key must always be paired with 'true'.  Remove the flag entirely otherwise.");
    }
    return null;
  }
  
  public static CloudStorageAccount tryConfigureServiceAccount(Map<String, String> paramMap)
  {
    Object localObject1 = optional(new String[] { "BlobEndpoint", "BlobSecondaryEndpoint", "QueueEndpoint", "QueueSecondaryEndpoint", "TableEndpoint", "TableSecondaryEndpoint", "FileEndpoint", "FileSecondaryEndpoint" });
    Object localObject2 = atLeastOne(new String[] { "BlobEndpoint", "QueueEndpoint", "TableEndpoint", "FileEndpoint" });
    Object localObject3 = optional(new String[] { "BlobSecondaryEndpoint", "QueueSecondaryEndpoint", "TableSecondaryEndpoint", "FileSecondaryEndpoint" });
    localObject1 = matchesExactly(matchesAll(new ConnectionStringFilter[] { matchesOne(new ConnectionStringFilter[] { matchesAll(new ConnectionStringFilter[] { allRequired(new String[] { "AccountKey" }) }), allRequired(new String[] { "SharedAccessSignature" }) }), allRequired(new String[] { "AccountName" }), localObject1, optional(new String[] { "DefaultEndpointsProtocol", "EndpointSuffix" }) }));
    localObject3 = matchesExactly(matchesAll(new ConnectionStringFilter[] { validCredentials, localObject2, localObject3 }));
    localObject2 = matchesSpecification(paramMap, new ConnectionStringFilter[] { localObject1 });
    localObject1 = matchesSpecification(paramMap, new ConnectionStringFilter[] { localObject3 });
    if ((((Boolean)localObject2).booleanValue()) || (((Boolean)localObject1).booleanValue()))
    {
      if ((((Boolean)localObject2).booleanValue()) && (!paramMap.containsKey("DefaultEndpointsProtocol"))) {
        paramMap.put("DefaultEndpointsProtocol", "https");
      }
      String str1 = settingOrDefault(paramMap, "BlobEndpoint");
      String str2 = settingOrDefault(paramMap, "QueueEndpoint");
      localObject1 = settingOrDefault(paramMap, "TableEndpoint");
      localObject3 = settingOrDefault(paramMap, "FileEndpoint");
      String str3 = settingOrDefault(paramMap, "BlobSecondaryEndpoint");
      String str4 = settingOrDefault(paramMap, "QueueSecondaryEndpoint");
      String str5 = settingOrDefault(paramMap, "TableSecondaryEndpoint");
      String str6 = settingOrDefault(paramMap, "FileSecondaryEndpoint");
      if ((isValidEndpointPair(str1, str3).booleanValue()) && (isValidEndpointPair(str2, str4).booleanValue()) && (isValidEndpointPair((String)localObject1, str5).booleanValue()) && (isValidEndpointPair((String)localObject3, str6).booleanValue()))
      {
        localObject2 = new CloudStorageAccount(StorageCredentials.tryParseCredentials(paramMap), getStorageUri(paramMap, "blob", "BlobEndpoint", "BlobSecondaryEndpoint", (Boolean)localObject2), getStorageUri(paramMap, "queue", "QueueEndpoint", "QueueSecondaryEndpoint", (Boolean)localObject2), getStorageUri(paramMap, "table", "TableEndpoint", "TableSecondaryEndpoint", (Boolean)localObject2), getStorageUri(paramMap, "file", "FileEndpoint", "FileSecondaryEndpoint", (Boolean)localObject2));
        boolean bool;
        if (str1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        isBlobEndpointDefault = bool;
        if (localObject3 == null) {
          bool = true;
        } else {
          bool = false;
        }
        isFileEndpointDefault = bool;
        if (str2 == null) {
          bool = true;
        } else {
          bool = false;
        }
        isQueueEndpointDefault = bool;
        if (localObject1 == null) {
          bool = true;
        } else {
          bool = false;
        }
        isTableEndpointDefault = bool;
        endpointSuffix = settingOrDefault(paramMap, "EndpointSuffix");
        accountName = settingOrDefault(paramMap, "AccountName");
        return (CloudStorageAccount)localObject2;
      }
    }
    return null;
  }
  
  public CloudAnalyticsClient createCloudAnalyticsClient()
  {
    if (getBlobStorageUri() != null)
    {
      if (getTableStorageUri() != null)
      {
        if (credentials != null) {
          return new CloudAnalyticsClient(getBlobStorageUri(), getTableStorageUri(), getCredentials());
        }
        throw new IllegalArgumentException("No credentials provided.");
      }
      throw new IllegalArgumentException("No table endpoint configured.");
    }
    throw new IllegalArgumentException("No blob endpoint configured.");
  }
  
  public CloudBlobClient createCloudBlobClient()
  {
    if (getBlobStorageUri() != null)
    {
      if (credentials != null) {
        return new CloudBlobClient(getBlobStorageUri(), getCredentials());
      }
      throw new IllegalArgumentException("No credentials provided.");
    }
    throw new IllegalArgumentException("No blob endpoint configured.");
  }
  
  public CloudFileClient createCloudFileClient()
  {
    if (getFileStorageUri() != null)
    {
      StorageCredentials localStorageCredentials = credentials;
      if (localStorageCredentials != null)
      {
        if (StorageCredentialsHelper.canCredentialsGenerateClient(localStorageCredentials)) {
          return new CloudFileClient(getFileStorageUri(), getCredentials());
        }
        throw new IllegalArgumentException("CloudBlobClient, CloudQueueClient and CloudTableClient require credentials that can sign a request.");
      }
      throw new IllegalArgumentException("No credentials provided.");
    }
    throw new IllegalArgumentException("No file endpoint configured.");
  }
  
  public CloudQueueClient createCloudQueueClient()
  {
    if (getQueueStorageUri() != null)
    {
      StorageCredentials localStorageCredentials = credentials;
      if (localStorageCredentials != null)
      {
        if (StorageCredentialsHelper.canCredentialsGenerateClient(localStorageCredentials)) {
          return new CloudQueueClient(getQueueStorageUri(), getCredentials());
        }
        throw new IllegalArgumentException("CloudBlobClient, CloudQueueClient and CloudTableClient require credentials that can sign a request.");
      }
      throw new IllegalArgumentException("No credentials provided.");
    }
    throw new IllegalArgumentException("No queue endpoint configured.");
  }
  
  public CloudTableClient createCloudTableClient()
  {
    if (getTableStorageUri() != null)
    {
      StorageCredentials localStorageCredentials = credentials;
      if (localStorageCredentials != null)
      {
        if (StorageCredentialsHelper.canCredentialsGenerateClient(localStorageCredentials)) {
          return new CloudTableClient(getTableStorageUri(), getCredentials());
        }
        throw new IllegalArgumentException("CloudBlobClient, CloudQueueClient and CloudTableClient require credentials that can sign a request.");
      }
      throw new IllegalArgumentException("No credentials provided.");
    }
    throw new IllegalArgumentException("No table endpoint configured.");
  }
  
  public String generateSharedAccessSignature(SharedAccessAccountPolicy paramSharedAccessAccountPolicy)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(getCredentials())) {
      return SharedAccessSignatureHelper.generateSharedAccessSignatureForAccount(paramSharedAccessAccountPolicy, SharedAccessSignatureHelper.generateSharedAccessSignatureHashForAccount(credentials.getAccountName(), paramSharedAccessAccountPolicy, getCredentials())).toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public URI getBlobEndpoint()
  {
    StorageUri localStorageUri = blobStorageUri;
    if (localStorageUri == null) {
      return null;
    }
    return localStorageUri.getPrimaryUri();
  }
  
  public StorageUri getBlobStorageUri()
  {
    return blobStorageUri;
  }
  
  public StorageCredentials getCredentials()
  {
    return credentials;
  }
  
  public String getEndpointSuffix()
  {
    return endpointSuffix;
  }
  
  public URI getFileEndpoint()
  {
    StorageUri localStorageUri = fileStorageUri;
    if (localStorageUri == null) {
      return null;
    }
    return localStorageUri.getPrimaryUri();
  }
  
  public StorageUri getFileStorageUri()
  {
    return fileStorageUri;
  }
  
  public URI getQueueEndpoint()
  {
    StorageUri localStorageUri = queueStorageUri;
    if (localStorageUri == null) {
      return null;
    }
    return localStorageUri.getPrimaryUri();
  }
  
  public StorageUri getQueueStorageUri()
  {
    return queueStorageUri;
  }
  
  public URI getTableEndpoint()
  {
    StorageUri localStorageUri = tableStorageUri;
    if (localStorageUri == null) {
      return null;
    }
    return localStorageUri.getPrimaryUri();
  }
  
  public StorageUri getTableStorageUri()
  {
    return tableStorageUri;
  }
  
  public void setCredentials(StorageCredentials paramStorageCredentials)
  {
    credentials = paramStorageCredentials;
  }
  
  public String toString()
  {
    return toString(false);
  }
  
  public String toString(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (isDevStoreAccount)
    {
      localArrayList.add(String.format("%s=true", new Object[] { "UseDevelopmentStorage" }));
      if (!getBlobEndpoint().toString().equals("http://127.0.0.1:10000/devstoreaccount1")) {
        localArrayList.add(String.format("%s=%s://%s/", new Object[] { "DevelopmentStorageProxyUri", getBlobEndpoint().getScheme(), getBlobEndpoint().getHost() }));
      }
    }
    else
    {
      localObject = endpointSuffix;
      if (localObject != null) {
        localArrayList.add(String.format("%s=%s", new Object[] { "EndpointSuffix", localObject }));
      }
      if (getBlobStorageUri() != null)
      {
        if (isBlobEndpointDefault) {
          i = 1;
        } else {
          localArrayList.add(String.format("%s=%s", new Object[] { "BlobEndpoint", getBlobEndpoint() }));
        }
      }
      else {
        i = 0;
      }
      int j = i;
      if (getQueueStorageUri() != null) {
        if (isQueueEndpointDefault)
        {
          j = 1;
        }
        else
        {
          localArrayList.add(String.format("%s=%s", new Object[] { "QueueEndpoint", getQueueEndpoint() }));
          j = i;
        }
      }
      int i = j;
      if (getTableStorageUri() != null) {
        if (isTableEndpointDefault)
        {
          i = 1;
        }
        else
        {
          localArrayList.add(String.format("%s=%s", new Object[] { "TableEndpoint", getTableEndpoint() }));
          i = j;
        }
      }
      j = i;
      if (getFileStorageUri() != null) {
        if (isFileEndpointDefault)
        {
          j = 1;
        }
        else
        {
          localArrayList.add(String.format("%s=%s", new Object[] { "FileEndpoint", getFileEndpoint() }));
          j = i;
        }
      }
      if (j != 0) {
        localArrayList.add(String.format("%s=%s", new Object[] { "DefaultEndpointsProtocol", getBlobEndpoint().getScheme() }));
      }
      if (getCredentials() != null) {
        localArrayList.add(getCredentials().toString(paramBoolean));
      }
      if ((accountName != null) && ((getCredentials() == null) || (getCredentials().getAccountName() == null))) {
        localArrayList.add(String.format("%s=%s", new Object[] { "AccountName", accountName }));
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((String)((Iterator)localObject).next());
      localStringBuilder.append(';');
    }
    if (localArrayList.size() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public static abstract interface ConnectionStringFilter
  {
    public abstract Map<String, String> apply(Map<String, String> paramMap);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.CloudStorageAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */