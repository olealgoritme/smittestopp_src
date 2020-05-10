package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.net.HttpURLConnection;

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
  
  private StorageRequest<CloudTableClient, QueryTableOperation, TableResult> retrieveImpl(CloudTableClient paramCloudTableClient, final String paramString, final TableRequestOptions paramTableRequestOptions)
  {
    final boolean bool = "Tables".equals(paramString);
    if (getClazzType() != null) {
      Utility.checkNullaryCtor(getClazzType());
    } else {
      Utility.assertNotNull("Query requires a valid class type or resolver.", getResolver());
    }
    new StorageRequest(paramTableRequestOptions, paramCloudTableClient.getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudTableClient paramAnonymousCloudTableClient, QueryTableOperation paramAnonymousQueryTableOperation, OperationContext paramAnonymousOperationContext)
      {
        return TableRequest.query(paramAnonymousCloudTableClient.getTransformedEndPoint(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramTableRequestOptions, null, paramAnonymousOperationContext, paramString, generateRequestIdentity(bool, paramAnonymousQueryTableOperation.getPartitionKey()), null);
      }
      
      public StorageExtendedErrorInformation parseErrorDetails()
      {
        return TableStorageErrorDeserializer.parseErrorDetails(this);
      }
      
      public TableResult postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, QueryTableOperation paramAnonymousQueryTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext, TableResult paramAnonymousTableResult)
      {
        if (getResult().getStatusCode() == 404) {
          return new TableResult(getResult().getStatusCode());
        }
        paramAnonymousHttpURLConnection = paramAnonymousHttpURLConnection.getInputStream();
        return parseResponse(paramAnonymousHttpURLConnection, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramAnonymousOperationContext, paramTableRequestOptions);
      }
      
      public TableResult preProcessResponse(QueryTableOperation paramAnonymousQueryTableOperation, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
      {
        if ((getResult().getStatusCode() != 200) && (getResult().getStatusCode() != 404)) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void setRequestLocationMode()
      {
        RequestLocationMode localRequestLocationMode;
        if (isPrimaryOnlyRetrieve()) {
          localRequestLocationMode = RequestLocationMode.PRIMARY_ONLY;
        } else {
          localRequestLocationMode = RequestLocationMode.PRIMARY_OR_SECONDARY;
        }
        setRequestLocationMode(localRequestLocationMode);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudTableClient paramAnonymousCloudTableClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signTableRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudTableClient, -1L, paramAnonymousOperationContext);
      }
    };
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
 * Qualified Name:     com.microsoft.azure.storage.table.QueryTableOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */