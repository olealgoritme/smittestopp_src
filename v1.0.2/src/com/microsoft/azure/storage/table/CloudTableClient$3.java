package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class CloudTableClient$3
  extends StorageRequest<CloudTableClient, TableQuery<T>, ResultSegment<R>>
{
  public CloudTableClient$3(CloudTableClient paramCloudTableClient, RequestOptions paramRequestOptions, StorageUri paramStorageUri, SegmentedStorageRequest paramSegmentedStorageRequest, TableRequestOptions paramTableRequestOptions, TableQuery paramTableQuery, EntityResolver paramEntityResolver)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, TableQuery<T> paramTableQuery, OperationContext paramOperationContext)
  {
    return TableRequest.query(paramCloudTableClient.getTransformedEndPoint(paramOperationContext).getUri(getCurrentLocation()), val$options, val$queryToExecute.generateQueryBuilder(), paramOperationContext, val$queryToExecute.getSourceTableName(), null, val$segmentedRequest.getToken());
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public ResultSegment<R> postProcessResponse(HttpURLConnection paramHttpURLConnection, TableQuery<T> paramTableQuery, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext, ResultSegment<R> paramResultSegment)
  {
    paramTableQuery = TableDeserializer.parseQueryResponse(paramHttpURLConnection.getInputStream(), val$options, val$queryToExecute.getClazzType(), val$resolver, paramOperationContext);
    paramCloudTableClient = TableResponse.getTableContinuationFromResponse(paramHttpURLConnection);
    if (paramCloudTableClient != null) {
      paramCloudTableClient.setTargetLocation(getResult().getTargetLocation());
    }
    val$segmentedRequest.setToken(paramCloudTableClient);
    paramHttpURLConnection = results;
    int i;
    if (val$queryToExecute.getTakeCount() == null) {
      i = results.size();
    } else {
      i = val$queryToExecute.getTakeCount().intValue();
    }
    return new ResultSegment(paramHttpURLConnection, Integer.valueOf(i), paramCloudTableClient);
  }
  
  public ResultSegment<R> preProcessResponse(TableQuery<T> paramTableQuery, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() == 200) {
      return null;
    }
    throw TableServiceException.generateTableServiceException(getResult(), null, getConnection().getErrorStream(), val$options.getTablePayloadFormat());
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(Utility.getListingLocationMode(val$segmentedRequest.getToken()));
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    StorageRequest.signTableRequest(paramHttpURLConnection, paramCloudTableClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.CloudTableClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */