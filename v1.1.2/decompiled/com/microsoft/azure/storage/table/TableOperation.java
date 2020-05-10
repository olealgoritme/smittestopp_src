package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.HashMap;

public class TableOperation
{
  public boolean echoContent;
  public TableEntity entity;
  public TableOperationType opType = null;
  
  public TableOperation() {}
  
  public TableOperation(TableEntity paramTableEntity, TableOperationType paramTableOperationType)
  {
    this(paramTableEntity, paramTableOperationType, false);
  }
  
  public TableOperation(TableEntity paramTableEntity, TableOperationType paramTableOperationType, boolean paramBoolean)
  {
    entity = paramTableEntity;
    opType = paramTableOperationType;
    echoContent = paramBoolean;
  }
  
  public static TableOperation delete(TableEntity paramTableEntity)
  {
    Utility.assertNotNull("entity", paramTableEntity);
    Utility.assertNotNullOrEmpty("entity etag", paramTableEntity.getEtag());
    return new TableOperation(paramTableEntity, TableOperationType.DELETE);
  }
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> deleteImpl(CloudTableClient paramCloudTableClient, final String paramString, final TableRequestOptions paramTableRequestOptions, final OperationContext paramOperationContext)
  {
    final boolean bool = "Tables".equals(paramString);
    final String str;
    if (bool) {
      str = ((EntityProperty)getEntity().writeEntity(paramOperationContext).get("TableName")).getValueAsString();
    } else {
      str = null;
    }
    if (!bool)
    {
      Utility.assertNotNullOrEmpty("Delete requires a valid ETag (which may be the '*' wildcard).", getEntity().getEtag());
      Utility.assertNotNull("Delete requires a partition key.", getEntity().getPartitionKey());
      Utility.assertNotNull("Delete requires a row key.", getEntity().getRowKey());
    }
    new StorageRequest(paramTableRequestOptions, paramCloudTableClient.getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudTableClient paramAnonymousCloudTableClient, TableOperation paramAnonymousTableOperation, OperationContext paramAnonymousOperationContext)
      {
        return TableRequest.delete(paramAnonymousCloudTableClient.getTransformedEndPoint(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramTableRequestOptions, null, paramAnonymousOperationContext, paramString, generateRequestIdentity(bool, str), paramAnonymousTableOperation.getEntity().getEtag());
      }
      
      public StorageExtendedErrorInformation parseErrorDetails()
      {
        return TableStorageErrorDeserializer.parseErrorDetails(this);
      }
      
      public TableResult preProcessResponse(TableOperation paramAnonymousTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() == 204) {
          return paramAnonymousTableOperation.parseResponse(null, getResult().getStatusCode(), null, paramOperationContext, paramTableRequestOptions);
        }
        throw TableServiceException.generateTableServiceException(getResult(), paramAnonymousTableOperation, getConnection().getErrorStream(), paramTableRequestOptions.getTablePayloadFormat());
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudTableClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  public static TableOperation insert(TableEntity paramTableEntity)
  {
    return insert(paramTableEntity, false);
  }
  
  public static TableOperation insert(TableEntity paramTableEntity, boolean paramBoolean)
  {
    Utility.assertNotNull("entity", paramTableEntity);
    return new TableOperation(paramTableEntity, TableOperationType.INSERT, paramBoolean);
  }
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> insertImpl(CloudTableClient paramCloudTableClient, final String paramString, final TableRequestOptions paramTableRequestOptions, final OperationContext paramOperationContext)
  {
    final boolean bool = "Tables".equals(paramString);
    final String str;
    if (bool) {
      str = ((EntityProperty)getEntity().writeEntity(paramOperationContext).get("TableName")).getValueAsString();
    } else {
      str = null;
    }
    if (!bool)
    {
      Utility.assertNotNull("Insert requires a partition key.", getEntity().getPartitionKey());
      Utility.assertNotNull("Insert requires a row key.", getEntity().getRowKey());
    }
    final Object localObject = new ByteArrayOutputStream();
    try
    {
      TableEntitySerializer.writeSingleEntityToStream((OutputStream)localObject, paramTableRequestOptions, entity, bool, paramOperationContext);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramCloudTableClient = new StorageRequest(paramTableRequestOptions, paramCloudTableClient.getStorageUri())
      {
        public HttpURLConnection buildRequest(CloudTableClient paramAnonymousCloudTableClient, TableOperation paramAnonymousTableOperation, OperationContext paramAnonymousOperationContext)
        {
          setSendStream(new ByteArrayInputStream(localObject));
          setLength(Long.valueOf(localObject.length));
          URI localURI = paramAnonymousCloudTableClient.getTransformedEndPoint(paramOperationContext).getUri(getCurrentLocation());
          TableRequestOptions localTableRequestOptions = paramTableRequestOptions;
          paramAnonymousOperationContext = paramOperationContext;
          String str1 = paramString;
          String str2 = generateRequestIdentity(bool, str);
          if (TableOperation.access$000(paramAnonymousTableOperation) != TableOperationType.INSERT) {
            paramAnonymousCloudTableClient = paramAnonymousTableOperation.getEntity().getEtag();
          } else {
            paramAnonymousCloudTableClient = null;
          }
          return TableRequest.insert(localURI, localTableRequestOptions, null, paramAnonymousOperationContext, str1, str2, paramAnonymousCloudTableClient, paramAnonymousTableOperation.getEchoContent(), TableOperation.access$000(paramAnonymousTableOperation).getUpdateType());
        }
        
        public StorageExtendedErrorInformation parseErrorDetails()
        {
          return TableStorageErrorDeserializer.parseErrorDetails(this);
        }
        
        public TableResult postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, TableOperation paramAnonymousTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext, TableResult paramAnonymousTableResult)
        {
          paramAnonymousHttpURLConnection = paramAnonymousTableResult;
          if (TableOperation.access$000(paramAnonymousTableOperation) == TableOperationType.INSERT)
          {
            paramAnonymousHttpURLConnection = paramAnonymousTableResult;
            if (paramAnonymousTableOperation.getEchoContent()) {
              paramAnonymousHttpURLConnection = paramAnonymousTableOperation.parseResponse(getConnection().getInputStream(), getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramOperationContext, paramTableRequestOptions);
            }
          }
          return paramAnonymousHttpURLConnection;
        }
        
        public TableResult preProcessResponse(TableOperation paramAnonymousTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
        {
          if (TableOperation.access$000(paramAnonymousTableOperation) == TableOperationType.INSERT)
          {
            if ((paramAnonymousTableOperation.getEchoContent()) && (getResult().getStatusCode() == 201)) {
              return new TableResult();
            }
            if ((!paramAnonymousTableOperation.getEchoContent()) && (getResult().getStatusCode() == 204)) {
              return paramAnonymousTableOperation.parseResponse(null, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramOperationContext, paramTableRequestOptions);
            }
          }
          else if (getResult().getStatusCode() == 204)
          {
            return paramAnonymousTableOperation.parseResponse(null, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramOperationContext, paramTableRequestOptions);
          }
          throw TableServiceException.generateTableServiceException(getResult(), paramAnonymousTableOperation, getConnection().getErrorStream(), paramTableRequestOptions.getTablePayloadFormat());
        }
        
        public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
        {
          StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudTableClient, -1L, paramAnonymousOperationContext);
        }
      };
      return paramCloudTableClient;
    }
    catch (IOException paramCloudTableClient)
    {
      throw StorageException.translateClientException(paramCloudTableClient);
    }
  }
  
  public static TableOperation insertOrMerge(TableEntity paramTableEntity)
  {
    Utility.assertNotNull("entity", paramTableEntity);
    return new TableOperation(paramTableEntity, TableOperationType.INSERT_OR_MERGE);
  }
  
  public static TableOperation insertOrReplace(TableEntity paramTableEntity)
  {
    Utility.assertNotNull("entity", paramTableEntity);
    return new TableOperation(paramTableEntity, TableOperationType.INSERT_OR_REPLACE);
  }
  
  public static TableOperation merge(TableEntity paramTableEntity)
  {
    Utility.assertNotNull("entity", paramTableEntity);
    Utility.assertNotNullOrEmpty("entity etag", paramTableEntity.getEtag());
    return new TableOperation(paramTableEntity, TableOperationType.MERGE);
  }
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> mergeImpl(CloudTableClient paramCloudTableClient, final String paramString, final TableRequestOptions paramTableRequestOptions, final OperationContext paramOperationContext)
  {
    Utility.assertNotNullOrEmpty("Merge requires a valid ETag (which may be the '*' wildcard).", getEntity().getEtag());
    Utility.assertNotNull("Merge requires a partition key.", getEntity().getPartitionKey());
    Utility.assertNotNull("Merge requires a row key.", getEntity().getRowKey());
    final Object localObject = new ByteArrayOutputStream();
    try
    {
      TableEntitySerializer.writeSingleEntityToStream((OutputStream)localObject, paramTableRequestOptions, getEntity(), false, paramOperationContext);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramCloudTableClient = new StorageRequest(paramTableRequestOptions, paramCloudTableClient.getStorageUri())
      {
        public HttpURLConnection buildRequest(CloudTableClient paramAnonymousCloudTableClient, TableOperation paramAnonymousTableOperation, OperationContext paramAnonymousOperationContext)
        {
          setSendStream(new ByteArrayInputStream(localObject));
          setLength(Long.valueOf(localObject.length));
          return TableRequest.merge(paramAnonymousCloudTableClient.getTransformedEndPoint(paramOperationContext).getUri(getCurrentLocation()), paramTableRequestOptions, null, paramOperationContext, paramString, generateRequestIdentity(false, null), paramAnonymousTableOperation.getEntity().getEtag());
        }
        
        public StorageExtendedErrorInformation parseErrorDetails()
        {
          return TableStorageErrorDeserializer.parseErrorDetails(this);
        }
        
        public TableResult preProcessResponse(TableOperation paramAnonymousTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
        {
          if (getResult().getStatusCode() == 204) {
            return paramAnonymousTableOperation.parseResponse(null, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramOperationContext, paramTableRequestOptions);
          }
          throw TableServiceException.generateTableServiceException(getResult(), paramAnonymousTableOperation, getConnection().getErrorStream(), paramTableRequestOptions.getTablePayloadFormat());
        }
        
        public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
        {
          StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudTableClient, -1L, paramAnonymousOperationContext);
        }
      };
      return paramCloudTableClient;
    }
    catch (IOException paramCloudTableClient)
    {
      throw StorageException.translateClientException(paramCloudTableClient);
    }
  }
  
  private TableResult performDelete(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    return (TableResult)ExecutionEngine.executeWithRetry(paramCloudTableClient, this, deleteImpl(paramCloudTableClient, paramString, paramTableRequestOptions, paramOperationContext), paramTableRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private TableResult performInsert(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    return (TableResult)ExecutionEngine.executeWithRetry(paramCloudTableClient, this, insertImpl(paramCloudTableClient, paramString, paramTableRequestOptions, paramOperationContext), paramTableRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private TableResult performMerge(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    return (TableResult)ExecutionEngine.executeWithRetry(paramCloudTableClient, this, mergeImpl(paramCloudTableClient, paramString, paramTableRequestOptions, paramOperationContext), paramTableRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private TableResult performUpdate(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    return (TableResult)ExecutionEngine.executeWithRetry(paramCloudTableClient, this, updateImpl(paramCloudTableClient, paramString, paramTableRequestOptions, paramOperationContext), paramTableRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  public static TableOperation replace(TableEntity paramTableEntity)
  {
    Utility.assertNotNullOrEmpty("entity etag", paramTableEntity.getEtag());
    return new TableOperation(paramTableEntity, TableOperationType.REPLACE);
  }
  
  public static TableOperation retrieve(String paramString1, String paramString2, EntityResolver<?> paramEntityResolver)
  {
    paramString1 = new QueryTableOperation(paramString1, paramString2);
    paramString1.setResolver(paramEntityResolver);
    return paramString1;
  }
  
  public static TableOperation retrieve(String paramString1, String paramString2, Class<? extends TableEntity> paramClass)
  {
    paramString1 = new QueryTableOperation(paramString1, paramString2);
    paramString1.setClazzType(paramClass);
    return paramString1;
  }
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> updateImpl(CloudTableClient paramCloudTableClient, final String paramString, final TableRequestOptions paramTableRequestOptions, final OperationContext paramOperationContext)
  {
    Utility.assertNotNullOrEmpty("Replace requires a valid ETag (which may be the '*' wildcard).", getEntity().getEtag());
    Utility.assertNotNull("Replace requires a partition key.", getEntity().getPartitionKey());
    Utility.assertNotNull("Replace requires a row key.", getEntity().getRowKey());
    final Object localObject = new ByteArrayOutputStream();
    try
    {
      TableEntitySerializer.writeSingleEntityToStream((OutputStream)localObject, paramTableRequestOptions, getEntity(), false, paramOperationContext);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramCloudTableClient = new StorageRequest(paramTableRequestOptions, paramCloudTableClient.getStorageUri())
      {
        public HttpURLConnection buildRequest(CloudTableClient paramAnonymousCloudTableClient, TableOperation paramAnonymousTableOperation, OperationContext paramAnonymousOperationContext)
        {
          setSendStream(new ByteArrayInputStream(localObject));
          setLength(Long.valueOf(localObject.length));
          return TableRequest.update(paramAnonymousCloudTableClient.getTransformedEndPoint(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramTableRequestOptions, null, paramAnonymousOperationContext, paramString, generateRequestIdentity(false, null), paramAnonymousTableOperation.getEntity().getEtag());
        }
        
        public StorageExtendedErrorInformation parseErrorDetails()
        {
          return TableStorageErrorDeserializer.parseErrorDetails(this);
        }
        
        public TableResult preProcessResponse(TableOperation paramAnonymousTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
        {
          if (getResult().getStatusCode() == 204) {
            return paramAnonymousTableOperation.parseResponse(null, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramOperationContext, paramTableRequestOptions);
          }
          throw TableServiceException.generateTableServiceException(getResult(), paramAnonymousTableOperation, getConnection().getErrorStream(), paramTableRequestOptions.getTablePayloadFormat());
        }
        
        public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
        {
          StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudTableClient, -1L, paramAnonymousOperationContext);
        }
      };
      return paramCloudTableClient;
    }
    catch (IOException paramCloudTableClient)
    {
      throw StorageException.translateClientException(paramCloudTableClient);
    }
  }
  
  public TableResult execute(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramTableRequestOptions = TableRequestOptions.populateAndApplyDefaults(paramTableRequestOptions, paramCloudTableClient);
    Utility.assertNotNullOrEmpty("TableName", paramString);
    if ((getOperationType() != TableOperationType.INSERT) && (getOperationType() != TableOperationType.INSERT_OR_MERGE) && (getOperationType() != TableOperationType.INSERT_OR_REPLACE))
    {
      if (getOperationType() == TableOperationType.DELETE) {
        return performDelete(paramCloudTableClient, paramString, paramTableRequestOptions, localOperationContext);
      }
      if (getOperationType() == TableOperationType.MERGE) {
        return performMerge(paramCloudTableClient, paramString, paramTableRequestOptions, localOperationContext);
      }
      if (getOperationType() == TableOperationType.REPLACE) {
        return performUpdate(paramCloudTableClient, paramString, paramTableRequestOptions, localOperationContext);
      }
      if (getOperationType() == TableOperationType.RETRIEVE) {
        return ((QueryTableOperation)this).performRetrieve(paramCloudTableClient, paramString, paramTableRequestOptions, localOperationContext);
      }
      throw new IllegalArgumentException("Unknown table operation.");
    }
    return performInsert(paramCloudTableClient, paramString, paramTableRequestOptions, localOperationContext);
  }
  
  public String generateRequestIdentity(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      return String.format("'%s'", new Object[] { paramString.replace("'", "''") });
    }
    paramString = opType;
    if (paramString == TableOperationType.INSERT) {
      return "";
    }
    String str;
    if (paramString == TableOperationType.RETRIEVE)
    {
      paramString = (QueryTableOperation)this;
      str = paramString.getPartitionKey();
      paramString = paramString.getRowKey();
    }
    else
    {
      str = getEntity().getPartitionKey();
      paramString = getEntity().getRowKey();
    }
    return String.format("%s='%s',%s='%s'", new Object[] { "PartitionKey", str.replace("'", "''"), "RowKey", paramString.replace("'", "''") });
  }
  
  public String generateRequestIdentityWithTable(String paramString)
  {
    return String.format("%s(%s)", new Object[] { paramString, generateRequestIdentity(false, null) });
  }
  
  public boolean getEchoContent()
  {
    return echoContent;
  }
  
  public final TableEntity getEntity()
  {
    try
    {
      TableEntity localTableEntity = entity;
      return localTableEntity;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final TableOperationType getOperationType()
  {
    try
    {
      TableOperationType localTableOperationType = opType;
      return localTableOperationType;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public TableResult parseResponse(InputStream paramInputStream, int paramInt, String paramString, OperationContext paramOperationContext, TableRequestOptions paramTableRequestOptions)
  {
    if ((opType == TableOperationType.INSERT) && (echoContent))
    {
      paramInputStream = TableDeserializer.parseSingleOpResponse(paramInputStream, paramTableRequestOptions, paramInt, null, null, paramOperationContext);
      paramInputStream.setEtag(paramString);
      paramInputStream.updateResultObject(getEntity());
    }
    else
    {
      paramOperationContext = new TableResult(paramInt);
      paramOperationContext.setResult(getEntity());
      paramInputStream = paramOperationContext;
      if (opType != TableOperationType.DELETE)
      {
        paramInputStream = paramOperationContext;
        if (paramString != null)
        {
          paramOperationContext.setEtag(paramString);
          paramOperationContext.updateResultObject(getEntity());
          paramInputStream = paramOperationContext;
        }
      }
    }
    return paramInputStream;
  }
  
  public void setEchoContent(boolean paramBoolean)
  {
    echoContent = paramBoolean;
  }
  
  public final void setEntity(TableEntity paramTableEntity)
  {
    try
    {
      entity = paramTableEntity;
      return;
    }
    finally
    {
      paramTableEntity = finally;
      throw paramTableEntity;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */