package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class QueryTableOperation$1
  extends StorageRequest<CloudTableClient, QueryTableOperation, TableResult>
{
  public QueryTableOperation$1(QueryTableOperation paramQueryTableOperation, RequestOptions paramRequestOptions, StorageUri paramStorageUri, TableRequestOptions paramTableRequestOptions, String paramString, boolean paramBoolean)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, QueryTableOperation paramQueryTableOperation, OperationContext paramOperationContext)
  {
    return TableRequest.query(paramCloudTableClient.getTransformedEndPoint(paramOperationContext).getUri(getCurrentLocation()), val$options, null, paramOperationContext, val$tableName, this$0.generateRequestIdentity(val$isTableEntry, paramQueryTableOperation.getPartitionKey()), null);
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public TableResult postProcessResponse(HttpURLConnection paramHttpURLConnection, QueryTableOperation paramQueryTableOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext, TableResult paramTableResult)
  {
    if (getResult().getStatusCode() == 404) {
      return new TableResult(getResult().getStatusCode());
    }
    paramHttpURLConnection = paramHttpURLConnection.getInputStream();
    return this$0.parseResponse(paramHttpURLConnection, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), paramOperationContext, val$options);
  }
  
  public TableResult preProcessResponse(QueryTableOperation paramQueryTableOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if ((getResult().getStatusCode() != 200) && (getResult().getStatusCode() != 404)) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void setRequestLocationMode()
  {
    RequestLocationMode localRequestLocationMode;
    if (this$0.isPrimaryOnlyRetrieve()) {
      localRequestLocationMode = RequestLocationMode.PRIMARY_ONLY;
    } else {
      localRequestLocationMode = RequestLocationMode.PRIMARY_OR_SECONDARY;
    }
    setRequestLocationMode(localRequestLocationMode);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    StorageRequest.signTableRequest(paramHttpURLConnection, paramCloudTableClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.QueryTableOperation.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */