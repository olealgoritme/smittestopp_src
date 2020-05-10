package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> deleteImpl(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    boolean bool = "Tables".equals(paramString);
    String str;
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
    return new TableOperation.1(this, paramTableRequestOptions, paramCloudTableClient.getStorageUri(), paramTableRequestOptions, paramString, bool, str, paramOperationContext);
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
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> insertImpl(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    boolean bool = "Tables".equals(paramString);
    String str;
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
    Object localObject = new ByteArrayOutputStream();
    try
    {
      TableEntitySerializer.writeSingleEntityToStream((OutputStream)localObject, paramTableRequestOptions, entity, bool, paramOperationContext);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramCloudTableClient = new TableOperation.2(this, paramTableRequestOptions, paramCloudTableClient.getStorageUri(), (byte[])localObject, paramOperationContext, paramTableRequestOptions, paramString, bool, str);
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
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> mergeImpl(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNullOrEmpty("Merge requires a valid ETag (which may be the '*' wildcard).", getEntity().getEtag());
    Utility.assertNotNull("Merge requires a partition key.", getEntity().getPartitionKey());
    Utility.assertNotNull("Merge requires a row key.", getEntity().getRowKey());
    Object localObject = new ByteArrayOutputStream();
    try
    {
      TableEntitySerializer.writeSingleEntityToStream((OutputStream)localObject, paramTableRequestOptions, getEntity(), false, paramOperationContext);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramCloudTableClient = new TableOperation.3(this, paramTableRequestOptions, paramCloudTableClient.getStorageUri(), (byte[])localObject, paramOperationContext, paramTableRequestOptions, paramString);
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
  
  private StorageRequest<CloudTableClient, TableOperation, TableResult> updateImpl(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNullOrEmpty("Replace requires a valid ETag (which may be the '*' wildcard).", getEntity().getEtag());
    Utility.assertNotNull("Replace requires a partition key.", getEntity().getPartitionKey());
    Utility.assertNotNull("Replace requires a row key.", getEntity().getRowKey());
    Object localObject = new ByteArrayOutputStream();
    try
    {
      TableEntitySerializer.writeSingleEntityToStream((OutputStream)localObject, paramTableRequestOptions, getEntity(), false, paramOperationContext);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      paramCloudTableClient = new TableOperation.4(this, paramTableRequestOptions, paramCloudTableClient.getStorageUri(), (byte[])localObject, paramTableRequestOptions, paramString, paramOperationContext);
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
    Object localObject;
    if (paramString == TableOperationType.RETRIEVE)
    {
      localObject = (QueryTableOperation)this;
      paramString = ((QueryTableOperation)localObject).getPartitionKey();
      localObject = ((QueryTableOperation)localObject).getRowKey();
    }
    else
    {
      paramString = getEntity().getPartitionKey();
      localObject = getEntity().getRowKey();
    }
    return String.format("%s='%s',%s='%s'", new Object[] { "PartitionKey", paramString.replace("'", "''"), "RowKey", ((String)localObject).replace("'", "''") });
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
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */