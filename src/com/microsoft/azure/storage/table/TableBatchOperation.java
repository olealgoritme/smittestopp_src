package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class TableBatchOperation
  extends ArrayList<TableOperation>
{
  public static final long serialVersionUID = -1192644463287355790L;
  public boolean containsWrites = false;
  public boolean hasQuery = false;
  public String partitionKey = null;
  
  private void checkResetEntityLocks()
  {
    if (size() == 0)
    {
      partitionKey = null;
      hasQuery = false;
      containsWrites = false;
    }
  }
  
  private void checkSingleQueryPerBatch(TableOperation paramTableOperation, int paramInt)
  {
    if (!hasQuery)
    {
      TableOperationType localTableOperationType1 = paramTableOperation.getOperationType();
      TableOperationType localTableOperationType2 = TableOperationType.RETRIEVE;
      boolean bool = true;
      if (localTableOperationType1 == localTableOperationType2) {
        if (paramInt <= 0) {
          hasQuery = true;
        } else {
          throw new IllegalArgumentException("A batch transaction with a retrieve operation cannot contain any other operations.");
        }
      }
      if (paramTableOperation.getOperationType() == TableOperationType.RETRIEVE) {
        bool = false;
      }
      containsWrites = bool;
      return;
    }
    throw new IllegalArgumentException("A batch transaction with a retrieve operation cannot contain any other operations.");
  }
  
  private StorageRequest<CloudTableClient, TableBatchOperation, ArrayList<TableResult>> executeImpl(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    String str1 = String.format("batch_%s", new Object[] { UUID.randomUUID().toString() });
    String str2 = String.format("changeset_%s", new Object[] { UUID.randomUUID().toString() });
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      MimeHelper.writeBatchToStream(localByteArrayOutputStream, paramTableRequestOptions, paramString, paramCloudTableClient.getTransformedEndPoint(paramOperationContext).getPrimaryUri(), this, str1, str2, paramOperationContext);
      paramString = localByteArrayOutputStream.toByteArray();
      paramCloudTableClient = new TableBatchOperation.1(this, paramTableRequestOptions, paramCloudTableClient.getStorageUri(), paramString, paramTableRequestOptions, str1, paramOperationContext);
      return paramCloudTableClient;
    }
    catch (URISyntaxException paramCloudTableClient)
    {
      throw StorageException.translateClientException(paramCloudTableClient);
    }
    catch (IOException paramCloudTableClient)
    {
      throw StorageException.translateClientException(paramCloudTableClient);
    }
  }
  
  private void lockToPartitionKey(String paramString)
  {
    if (partitionKey == null) {
      partitionKey = paramString;
    } else {
      if ((paramString.length() != paramString.length()) || (!partitionKey.equals(paramString))) {
        break label38;
      }
    }
    return;
    label38:
    throw new IllegalArgumentException("All entities in a given batch must have the same partition key.");
  }
  
  public void add(int paramInt, TableOperation paramTableOperation)
  {
    Utility.assertNotNull("element", paramTableOperation);
    checkSingleQueryPerBatch(paramTableOperation, size());
    if (paramTableOperation.getOperationType() == TableOperationType.RETRIEVE) {
      lockToPartitionKey(((QueryTableOperation)paramTableOperation).getPartitionKey());
    } else {
      lockToPartitionKey(paramTableOperation.getEntity().getPartitionKey());
    }
    super.add(paramInt, paramTableOperation);
  }
  
  public boolean add(TableOperation paramTableOperation)
  {
    Utility.assertNotNull("element", paramTableOperation);
    checkSingleQueryPerBatch(paramTableOperation, size());
    if (paramTableOperation.getOperationType() == TableOperationType.RETRIEVE) {
      lockToPartitionKey(((QueryTableOperation)paramTableOperation).getPartitionKey());
    } else {
      lockToPartitionKey(paramTableOperation.getEntity().getPartitionKey());
    }
    return super.add(paramTableOperation);
  }
  
  public boolean addAll(int paramInt, Collection<? extends TableOperation> paramCollection)
  {
    int i = size();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      TableOperation localTableOperation = (TableOperation)localIterator.next();
      Utility.assertNotNull("operation", localTableOperation);
      checkSingleQueryPerBatch(localTableOperation, i);
      if (localTableOperation.getEntity() == null) {
        lockToPartitionKey(((QueryTableOperation)localTableOperation).getPartitionKey());
      } else {
        lockToPartitionKey(localTableOperation.getEntity().getPartitionKey());
      }
      i++;
    }
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends TableOperation> paramCollection)
  {
    int i = size();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      TableOperation localTableOperation = (TableOperation)localIterator.next();
      Utility.assertNotNull("operation", localTableOperation);
      checkSingleQueryPerBatch(localTableOperation, i);
      if (localTableOperation.getEntity() == null) {
        lockToPartitionKey(((QueryTableOperation)localTableOperation).getPartitionKey());
      } else {
        lockToPartitionKey(localTableOperation.getEntity().getPartitionKey());
      }
      i++;
    }
    return super.addAll(paramCollection);
  }
  
  public void clear()
  {
    super.clear();
    checkResetEntityLocks();
  }
  
  public void delete(TableEntity paramTableEntity)
  {
    lockToPartitionKey(paramTableEntity.getPartitionKey());
    add(TableOperation.delete(paramTableEntity));
  }
  
  public ArrayList<TableResult> execute(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNullOrEmpty("TableName", paramString);
    if (size() != 0) {
      return (ArrayList)ExecutionEngine.executeWithRetry(paramCloudTableClient, this, executeImpl(paramCloudTableClient, paramString, paramTableRequestOptions, paramOperationContext), paramTableRequestOptions.getRetryPolicyFactory(), paramOperationContext);
    }
    throw new IllegalArgumentException("Cannot execute an empty batch operation.");
  }
  
  public void insert(TableEntity paramTableEntity)
  {
    insert(paramTableEntity, false);
  }
  
  public void insert(TableEntity paramTableEntity, boolean paramBoolean)
  {
    lockToPartitionKey(paramTableEntity.getPartitionKey());
    add(TableOperation.insert(paramTableEntity, paramBoolean));
  }
  
  public void insertOrMerge(TableEntity paramTableEntity)
  {
    lockToPartitionKey(paramTableEntity.getPartitionKey());
    add(TableOperation.insertOrMerge(paramTableEntity));
  }
  
  public void insertOrReplace(TableEntity paramTableEntity)
  {
    lockToPartitionKey(paramTableEntity.getPartitionKey());
    add(TableOperation.insertOrReplace(paramTableEntity));
  }
  
  public void merge(TableEntity paramTableEntity)
  {
    lockToPartitionKey(paramTableEntity.getPartitionKey());
    add(TableOperation.merge(paramTableEntity));
  }
  
  public TableOperation remove(int paramInt)
  {
    TableOperation localTableOperation = (TableOperation)super.remove(paramInt);
    checkResetEntityLocks();
    return localTableOperation;
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = super.remove(paramObject);
    checkResetEntityLocks();
    return bool;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = super.removeAll(paramCollection);
    checkResetEntityLocks();
    return bool;
  }
  
  public void removeRange(int paramInt1, int paramInt2)
  {
    super.removeRange(paramInt1, paramInt2);
    checkResetEntityLocks();
  }
  
  public void replace(TableEntity paramTableEntity)
  {
    lockToPartitionKey(paramTableEntity.getPartitionKey());
    add(TableOperation.replace(paramTableEntity));
  }
  
  public void retrieve(String paramString1, String paramString2, EntityResolver<?> paramEntityResolver)
  {
    lockToPartitionKey(paramString1);
    add(TableOperation.retrieve(paramString1, paramString2, paramEntityResolver));
  }
  
  public void retrieve(String paramString1, String paramString2, Class<? extends TableEntity> paramClass)
  {
    lockToPartitionKey(paramString1);
    add(TableOperation.retrieve(paramString1, paramString2, paramClass));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableBatchOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */