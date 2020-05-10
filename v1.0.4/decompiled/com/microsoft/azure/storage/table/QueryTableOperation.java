package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;

public class QueryTableOperation
  extends TableOperation
{
  public Class<? extends TableEntity> clazzType;
  public boolean isPrimaryOnlyRetrieve = false;
  public String partitionKey;
  public EntityResolver<?> resolver;
  public String rowKey;
  
  public QueryTableOperation()
  {
    super(null, TableOperationType.RETRIEVE);
  }
  
  public QueryTableOperation(String paramString1, String paramString2)
  {
    super(null, TableOperationType.RETRIEVE);
    Utility.assertNotNull("partitionKey", paramString1);
    partitionKey = paramString1;
    rowKey = paramString2;
  }
  
  private StorageRequest<CloudTableClient, QueryTableOperation, TableResult> retrieveImpl(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions)
  {
    boolean bool = "Tables".equals(paramString);
    if (getClazzType() != null) {
      Utility.checkNullaryCtor(getClazzType());
    } else {
      Utility.assertNotNull("Query requires a valid class type or resolver.", getResolver());
    }
    return new QueryTableOperation.1(this, paramTableRequestOptions, paramCloudTableClient.getStorageUri(), paramTableRequestOptions, paramString, bool);
  }
  
  public Class<? extends TableEntity> getClazzType()
  {
    return clazzType;
  }
  
  public String getPartitionKey()
  {
    return partitionKey;
  }
  
  public EntityResolver<?> getResolver()
  {
    return resolver;
  }
  
  public String getRowKey()
  {
    return rowKey;
  }
  
  public final boolean isPrimaryOnlyRetrieve()
  {
    return isPrimaryOnlyRetrieve;
  }
  
  public TableResult parseResponse(InputStream paramInputStream, int paramInt, String paramString, OperationContext paramOperationContext, TableRequestOptions paramTableRequestOptions)
  {
    paramInputStream = TableDeserializer.parseSingleOpResponse(paramInputStream, paramTableRequestOptions, paramInt, getClazzType(), getResolver(), paramOperationContext);
    paramInputStream.setEtag(paramString);
    return paramInputStream;
  }
  
  public TableResult performRetrieve(CloudTableClient paramCloudTableClient, String paramString, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    paramTableRequestOptions.assertPolicyIfRequired();
    return (TableResult)ExecutionEngine.executeWithRetry(paramCloudTableClient, this, retrieveImpl(paramCloudTableClient, paramString, paramTableRequestOptions), paramTableRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  public void setClazzType(Class<? extends TableEntity> paramClass)
  {
    Utility.assertNotNull("clazzType", paramClass);
    Utility.checkNullaryCtor(paramClass);
    clazzType = paramClass;
  }
  
  public void setPartitionKey(String paramString)
  {
    partitionKey = paramString;
  }
  
  public void setPrimaryOnlyRetrieve(boolean paramBoolean)
  {
    isPrimaryOnlyRetrieve = paramBoolean;
  }
  
  public void setResolver(EntityResolver<?> paramEntityResolver)
  {
    Utility.assertNotNull("Query requires a valid class type or resolver.", paramEntityResolver);
    resolver = paramEntityResolver;
  }
  
  public void setRowKey(String paramString)
  {
    rowKey = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.QueryTableOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */