package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessPolicySerializer;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageCredentialsHelper;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import javax.xml.stream.XMLStreamException;

public final class CloudTable
{
  public String name;
  public StorageUri storageUri;
  public CloudTableClient tableServiceClient;
  
  public CloudTable(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudTable(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
  }
  
  public CloudTable(String paramString, CloudTableClient paramCloudTableClient)
  {
    Utility.assertNotNull("client", paramCloudTableClient);
    Utility.assertNotNull("tableName", paramString);
    storageUri = PathUtility.appendPathToUri(paramCloudTableClient.getStorageUri(), paramString);
    name = paramString;
    tableServiceClient = paramCloudTableClient;
  }
  
  public CloudTable(URI paramURI)
  {
    this(new StorageUri(paramURI, null));
  }
  
  public CloudTable(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI, null), paramStorageCredentials);
  }
  
  private StorageRequest<CloudTableClient, CloudTable, TablePermissions> downloadPermissionsImpl(TableRequestOptions paramTableRequestOptions)
  {
    return new CloudTable.2(this, paramTableRequestOptions, getStorageUri(), paramTableRequestOptions);
  }
  
  @DoesServiceRequest
  private boolean exists(boolean paramBoolean, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    paramOperationContext.clearEncryption();
    Utility.assertNotNullOrEmpty("tableName", name);
    paramTableRequestOptions = (QueryTableOperation)TableOperation.retrieve(name, null, DynamicTableEntity.class);
    paramTableRequestOptions.setPrimaryOnlyRetrieve(paramBoolean);
    paramTableRequestOptions = paramTableRequestOptions.execute(tableServiceClient, "Tables", paramOperationContext, localOperationContext);
    if (paramTableRequestOptions.getHttpStatusCode() == 200) {
      return true;
    }
    if (paramTableRequestOptions.getHttpStatusCode() == 404) {
      return false;
    }
    throw new StorageException("OutOfRangeInput", "Unexpected http status code received.", paramTableRequestOptions.getHttpStatusCode(), null, null);
  }
  
  private String getSharedAccessCanonicalName()
  {
    return String.format("/%s/%s/%s", new Object[] { "table", getServiceClient().getCredentials().getAccountName(), getName().toLowerCase(Locale.ENGLISH) });
  }
  
  private void parseQueryAndVerify(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("completeUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      storageUri = PathUtility.stripURIQueryAndFragment(paramStorageUri);
      paramStorageUri = SharedAccessSignatureHelper.parseQuery(paramStorageUri);
      if ((paramStorageCredentials != null) && (paramStorageUri != null)) {
        throw new IllegalArgumentException("Cannot provide credentials as part of the address and as constructor parameter. Either pass in the address or use a different constructor.");
      }
      try
      {
        boolean bool = Utility.determinePathStyleFromUri(storageUri.getPrimaryUri());
        CloudTableClient localCloudTableClient = new com/microsoft/azure/storage/table/CloudTableClient;
        StorageUri localStorageUri = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials == null) {
          paramStorageCredentials = paramStorageUri;
        }
        localCloudTableClient.<init>(localStorageUri, paramStorageCredentials);
        tableServiceClient = localCloudTableClient;
        name = PathUtility.getTableNameFromUri(storageUri.getPrimaryUri(), bool);
        return;
      }
      catch (URISyntaxException paramStorageUri)
      {
        throw Utility.generateNewUnexpectedStorageException(paramStorageUri);
      }
    }
    throw new IllegalArgumentException(String.format("Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramStorageUri.toString() }));
  }
  
  private StorageRequest<CloudTableClient, CloudTable, Void> uploadPermissionsImpl(TablePermissions paramTablePermissions, TableRequestOptions paramTableRequestOptions)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      SharedAccessPolicySerializer.writeSharedAccessIdentifiersToStream(paramTablePermissions.getSharedAccessPolicies(), localStringWriter);
      paramTablePermissions = localStringWriter.toString().getBytes("UTF-8");
      paramTablePermissions = new CloudTable.1(this, paramTableRequestOptions, getStorageUri(), paramTablePermissions, paramTableRequestOptions);
      return paramTablePermissions;
    }
    catch (UnsupportedEncodingException paramTablePermissions)
    {
      throw StorageException.translateClientException(paramTablePermissions);
    }
    catch (XMLStreamException paramTablePermissions)
    {
      throw StorageException.translateClientException(paramTablePermissions);
    }
    catch (IllegalArgumentException paramTablePermissions)
    {
      throw StorageException.translateClientException(paramTablePermissions);
    }
  }
  
  @DoesServiceRequest
  public void create()
  {
    create(null, null);
  }
  
  @DoesServiceRequest
  public void create(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    paramOperationContext.clearEncryption();
    Utility.assertNotNullOrEmpty("tableName", name);
    paramTableRequestOptions = new DynamicTableEntity();
    paramTableRequestOptions.getProperties().put("TableName", new EntityProperty(name));
    TableOperation.insert(paramTableRequestOptions).execute(tableServiceClient, "Tables", paramOperationContext, localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists()
  {
    return createIfNotExists(null, null);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    if (exists(true, paramTableRequestOptions, paramOperationContext)) {
      return false;
    }
    try
    {
      create(paramTableRequestOptions, paramOperationContext);
      return true;
    }
    catch (StorageException paramTableRequestOptions)
    {
      if ((paramTableRequestOptions.getHttpStatusCode() == 409) && ("TableAlreadyExists".equals(paramTableRequestOptions.getErrorCode()))) {
        return false;
      }
      throw paramTableRequestOptions;
    }
  }
  
  @DoesServiceRequest
  public void delete()
  {
    delete(null, null);
  }
  
  @DoesServiceRequest
  public void delete(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    Utility.assertNotNullOrEmpty("tableName", name);
    paramTableRequestOptions = new DynamicTableEntity();
    paramTableRequestOptions.getProperties().put("TableName", new EntityProperty(name));
    new TableOperation(paramTableRequestOptions, TableOperationType.DELETE).execute(tableServiceClient, "Tables", paramOperationContext, localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists()
  {
    return deleteIfExists(null, null);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    if (exists(true, paramTableRequestOptions, paramOperationContext)) {
      try
      {
        delete(paramTableRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramTableRequestOptions)
      {
        if ((paramTableRequestOptions.getHttpStatusCode() == 404) && ("ResourceNotFound".equals(paramTableRequestOptions.getErrorCode()))) {
          return false;
        }
        throw paramTableRequestOptions;
      }
    }
    return false;
  }
  
  @DoesServiceRequest
  public TablePermissions downloadPermissions()
  {
    return downloadPermissions(null, null);
  }
  
  @DoesServiceRequest
  public TablePermissions downloadPermissions(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    return (TablePermissions)ExecutionEngine.executeWithRetry(tableServiceClient, this, downloadPermissionsImpl(paramTableRequestOptions), paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public TableResult execute(TableOperation paramTableOperation)
  {
    return execute(paramTableOperation, null, null);
  }
  
  @DoesServiceRequest
  public TableResult execute(TableOperation paramTableOperation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("operation", paramTableOperation);
    return paramTableOperation.execute(getServiceClient(), getName(), paramTableRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public <T extends TableEntity> Iterable<T> execute(TableQuery<T> paramTableQuery)
  {
    return execute(paramTableQuery, null, null);
  }
  
  @DoesServiceRequest
  public <R> Iterable<R> execute(TableQuery<?> paramTableQuery, EntityResolver<R> paramEntityResolver)
  {
    return execute(paramTableQuery, paramEntityResolver, null, null);
  }
  
  @DoesServiceRequest
  public <R> Iterable<R> execute(TableQuery<?> paramTableQuery, EntityResolver<R> paramEntityResolver, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("query", paramTableQuery);
    Utility.assertNotNull("Query requires a valid class type or resolver.", paramEntityResolver);
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, getServiceClient());
    paramTableQuery.setSourceTableName(getName());
    return getServiceClient().generateIteratorForQuery(paramTableQuery, paramEntityResolver, paramTableRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public <T extends TableEntity> Iterable<T> execute(TableQuery<T> paramTableQuery, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("query", paramTableQuery);
    Utility.assertNotNull("Query requires a valid class type or resolver.", paramTableQuery.getClazzType());
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, getServiceClient());
    paramTableQuery.setSourceTableName(getName());
    return getServiceClient().generateIteratorForQuery(paramTableQuery, null, paramTableRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ArrayList<TableResult> execute(TableBatchOperation paramTableBatchOperation)
  {
    return execute(paramTableBatchOperation, null, null);
  }
  
  @DoesServiceRequest
  public ArrayList<TableResult> execute(TableBatchOperation paramTableBatchOperation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("batch", paramTableBatchOperation);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, getServiceClient());
    return paramTableBatchOperation.execute(getServiceClient(), getName(), paramTableRequestOptions, localOperationContext);
  }
  
  @DoesServiceRequest
  public <T extends TableEntity> ResultSegment<T> executeSegmented(TableQuery<T> paramTableQuery, ResultContinuation paramResultContinuation)
  {
    return executeSegmented(paramTableQuery, paramResultContinuation, null, null);
  }
  
  @DoesServiceRequest
  public <T extends TableEntity> ResultSegment<T> executeSegmented(TableQuery<T> paramTableQuery, ResultContinuation paramResultContinuation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("query", paramTableQuery);
    paramTableQuery.setSourceTableName(getName());
    return getServiceClient().executeQuerySegmentedImpl(paramTableQuery, null, paramResultContinuation, paramTableRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public <R> ResultSegment<R> executeSegmented(TableQuery<?> paramTableQuery, EntityResolver<R> paramEntityResolver, ResultContinuation paramResultContinuation)
  {
    return executeSegmented(paramTableQuery, paramEntityResolver, paramResultContinuation, null, null);
  }
  
  @DoesServiceRequest
  public <R> ResultSegment<R> executeSegmented(TableQuery<?> paramTableQuery, EntityResolver<R> paramEntityResolver, ResultContinuation paramResultContinuation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("Query requires a valid class type or resolver.", paramEntityResolver);
    paramTableQuery.setSourceTableName(getName());
    return getServiceClient().executeQuerySegmentedImpl(paramTableQuery, paramEntityResolver, paramResultContinuation, paramTableRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public boolean exists()
  {
    return exists(null, null);
  }
  
  @DoesServiceRequest
  public boolean exists(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    return exists(false, paramTableRequestOptions, paramOperationContext);
  }
  
  public String generateSharedAccessSignature(SharedAccessTablePolicy paramSharedAccessTablePolicy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return generateSharedAccessSignature(paramSharedAccessTablePolicy, paramString1, paramString2, paramString3, paramString4, paramString5, null, null);
  }
  
  public String generateSharedAccessSignature(SharedAccessTablePolicy paramSharedAccessTablePolicy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(tableServiceClient.getCredentials()))
    {
      String str = SharedAccessSignatureHelper.generateSharedAccessSignatureHashForTable(paramSharedAccessTablePolicy, paramString1, getSharedAccessCanonicalName(), paramIPRange, paramSharedAccessProtocols, paramString2, paramString3, paramString4, paramString5, tableServiceClient);
      return SharedAccessSignatureHelper.generateSharedAccessSignatureForTable(paramSharedAccessTablePolicy, paramString2, paramString3, paramString4, paramString5, paramString1, paramIPRange, paramSharedAccessProtocols, name, str).toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public String getName()
  {
    return name;
  }
  
  public CloudTableClient getServiceClient()
  {
    return tableServiceClient;
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  @DoesServiceRequest
  public void uploadPermissions(TablePermissions paramTablePermissions)
  {
    uploadPermissions(paramTablePermissions, null, null);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(TablePermissions paramTablePermissions, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, tableServiceClient);
    ExecutionEngine.executeWithRetry(tableServiceClient, this, uploadPermissionsImpl(paramTablePermissions, paramTableRequestOptions), paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.CloudTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */