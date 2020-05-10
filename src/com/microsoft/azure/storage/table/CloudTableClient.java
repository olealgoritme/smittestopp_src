package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.ServiceProperties;
import com.microsoft.azure.storage.ServiceStats;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsAnonymous;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.LazySegmentedIterable;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.URI;

public final class CloudTableClient
  extends ServiceClient
{
  public TableRequestOptions defaultRequestOptions = new TableRequestOptions();
  public final EntityResolver<String> tableNameResolver = new CloudTableClient.1(this);
  
  public CloudTableClient(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    super(paramStorageUri, paramStorageCredentials);
    if ((paramStorageCredentials != null) && (!paramStorageCredentials.getClass().equals(StorageCredentialsAnonymous.class)))
    {
      TableRequestOptions.applyDefaults(defaultRequestOptions);
      return;
    }
    throw new IllegalArgumentException("StorageCredentials cannot be null or anonymous for this service.");
  }
  
  public CloudTableClient(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  public static void addEncryptionProperties(TableQuery<?> paramTableQuery)
  {
    if (paramTableQuery.getColumns() != null)
    {
      String[] arrayOfString = new String[paramTableQuery.getColumns().length + 2];
      System.arraycopy(paramTableQuery.getColumns(), 0, arrayOfString, 2, paramTableQuery.getColumns().length);
      arrayOfString[0] = "_ClientEncryptionMetadata1";
      arrayOfString[1] = "_ClientEncryptionMetadata2";
      paramTableQuery.setColumns(arrayOfString);
    }
  }
  
  private <T extends TableEntity, R> StorageRequest<CloudTableClient, TableQuery<T>, ResultSegment<T>> executeQuerySegmentedCoreImpl(TableQuery<T> paramTableQuery, EntityResolver<R> paramEntityResolver, TableRequestOptions paramTableRequestOptions, SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    if (paramEntityResolver == null) {
      Utility.assertNotNull("Query requires a valid class type or resolver.", paramTableQuery.getClazzType());
    }
    paramTableRequestOptions.assertPolicyIfRequired();
    if (paramTableRequestOptions.getEncryptionPolicy() != null) {
      addEncryptionProperties(paramTableQuery);
    }
    return new CloudTableClient.2(this, paramTableRequestOptions, getStorageUri(), paramSegmentedStorageRequest, paramTableRequestOptions, paramTableQuery);
  }
  
  private <T extends TableEntity, R> StorageRequest<CloudTableClient, TableQuery<T>, ResultSegment<R>> executeQuerySegmentedWithResolverCoreImpl(TableQuery<T> paramTableQuery, EntityResolver<R> paramEntityResolver, TableRequestOptions paramTableRequestOptions, SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    if (paramEntityResolver == null) {
      Utility.assertNotNull("Query requires a valid class type or resolver.", paramTableQuery.getClazzType());
    }
    if (paramTableRequestOptions.getEncryptionPolicy() != null) {
      addEncryptionProperties(paramTableQuery);
    }
    return new CloudTableClient.3(this, paramTableRequestOptions, getStorageUri(), paramSegmentedStorageRequest, paramTableRequestOptions, paramTableQuery, paramEntityResolver);
  }
  
  private TableQuery<TableServiceEntity> generateListTablesQuery(String paramString)
  {
    TableQuery localTableQuery1 = TableQuery.from(TableServiceEntity.class);
    localTableQuery1.setSourceTableName("Tables");
    TableQuery localTableQuery2 = localTableQuery1;
    if (!Utility.isNullOrEmpty(paramString)) {
      localTableQuery2 = localTableQuery1.where(String.format("(%s ge '%s') and (%s lt '%s{')", new Object[] { "TableName", paramString, "TableName", paramString }));
    }
    return localTableQuery2;
  }
  
  @DoesServiceRequest
  public final ServiceProperties downloadServiceProperties()
  {
    return downloadServiceProperties(null, null);
  }
  
  @DoesServiceRequest
  public final ServiceProperties downloadServiceProperties(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, this);
    return (ServiceProperties)ExecutionEngine.executeWithRetry(this, null, downloadServicePropertiesImpl(paramTableRequestOptions, true), paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public <T extends TableEntity, R> ResultSegment<?> executeQuerySegmentedImpl(TableQuery<T> paramTableQuery, EntityResolver<R> paramEntityResolver, ResultContinuation paramResultContinuation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, this);
    Utility.assertContinuationType(paramResultContinuation, ResultContinuationType.TABLE);
    paramTableRequestOptions = new SegmentedStorageRequest();
    paramTableRequestOptions.setToken(paramResultContinuation);
    return (ResultSegment)ExecutionEngine.executeWithRetry(this, paramTableQuery, executeQuerySegmentedWithResolverCoreImpl(paramTableQuery, paramEntityResolver, paramOperationContext, paramTableRequestOptions), paramOperationContext.getRetryPolicyFactory(), localOperationContext);
  }
  
  public <T extends TableEntity, R> Iterable<?> generateIteratorForQuery(TableQuery<T> paramTableQuery, EntityResolver<R> paramEntityResolver, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = new SegmentedStorageRequest();
    if (paramEntityResolver == null) {
      return new LazySegmentedIterable(executeQuerySegmentedCoreImpl(paramTableQuery, paramEntityResolver, paramTableRequestOptions, paramOperationContext), this, paramTableQuery, paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
    }
    return new LazySegmentedIterable(executeQuerySegmentedWithResolverCoreImpl(paramTableQuery, paramEntityResolver, paramTableRequestOptions, paramOperationContext), this, paramTableQuery, paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public TableRequestOptions getDefaultRequestOptions()
  {
    return defaultRequestOptions;
  }
  
  @DoesServiceRequest
  public ServiceStats getServiceStats()
  {
    return getServiceStats(null, null);
  }
  
  @DoesServiceRequest
  public ServiceStats getServiceStats(TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, this);
    return (ServiceStats)ExecutionEngine.executeWithRetry(this, null, getServiceStatsImpl(paramTableRequestOptions, true), paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public CloudTable getTableReference(String paramString)
  {
    return new CloudTable(paramString, this);
  }
  
  public final StorageUri getTransformedEndPoint(OperationContext paramOperationContext)
  {
    return getCredentials().transformUri(getStorageUri(), paramOperationContext);
  }
  
  public boolean isUsePathStyleUris()
  {
    return super.isUsePathStyleUris();
  }
  
  @DoesServiceRequest
  public Iterable<String> listTables()
  {
    return listTables(null);
  }
  
  @DoesServiceRequest
  public Iterable<String> listTables(String paramString)
  {
    return listTables(paramString, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<String> listTables(String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, this);
    paramTableRequestOptions.clearEncryption();
    return generateIteratorForQuery(generateListTablesQuery(paramString), tableNameResolver, paramTableRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<String> listTablesSegmented()
  {
    return listTablesSegmented(null);
  }
  
  @DoesServiceRequest
  public ResultSegment<String> listTablesSegmented(String paramString)
  {
    return listTablesSegmented(paramString, null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<String> listTablesSegmented(String paramString, Integer paramInteger, ResultContinuation paramResultContinuation, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    if (paramInteger != null) {
      Utility.assertGreaterThanOrEqual("maxResults", paramInteger.intValue(), 1L);
    }
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, this);
    paramTableRequestOptions.clearEncryption();
    return executeQuerySegmentedImpl(generateListTablesQuery(paramString).take(paramInteger), tableNameResolver, paramResultContinuation, paramTableRequestOptions, paramOperationContext);
  }
  
  public void setDefaultRequestOptions(TableRequestOptions paramTableRequestOptions)
  {
    Utility.assertNotNull("defaultRequestOptions", paramTableRequestOptions);
    defaultRequestOptions = paramTableRequestOptions;
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(ServiceProperties paramServiceProperties)
  {
    uploadServiceProperties(paramServiceProperties, null, null);
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(ServiceProperties paramServiceProperties, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    if (Utility.isNullOrEmpty(paramServiceProperties.getDefaultServiceVersion()))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, this);
      Utility.assertNotNull("properties", paramServiceProperties);
      ExecutionEngine.executeWithRetry(this, null, uploadServicePropertiesImpl(paramServiceProperties, paramTableRequestOptions, localOperationContext, true), paramTableRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IllegalArgumentException("DefaultServiceVersion can only be set for the Blob service.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.CloudTableClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */