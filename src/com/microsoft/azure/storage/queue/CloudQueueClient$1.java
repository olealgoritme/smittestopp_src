package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;

public class CloudQueueClient$1
  extends StorageRequest<CloudQueueClient, Void, ResultSegment<CloudQueue>>
{
  public CloudQueueClient$1(CloudQueueClient paramCloudQueueClient, RequestOptions paramRequestOptions, StorageUri paramStorageUri, SegmentedStorageRequest paramSegmentedStorageRequest, ListingContext paramListingContext, QueueRequestOptions paramQueueRequestOptions, QueueListingDetails paramQueueListingDetails)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, Void paramVoid, OperationContext paramOperationContext)
  {
    ListingContext localListingContext = val$listingContext;
    if (val$segmentedRequest.getToken() != null) {
      paramVoid = val$segmentedRequest.getToken().getNextMarker();
    } else {
      paramVoid = null;
    }
    localListingContext.setMarker(paramVoid);
    return QueueRequest.list(CloudQueueClient.access$000(this$0).transformUri(paramCloudQueueClient.getStorageUri().getUri(getCurrentLocation())), val$options, paramOperationContext, val$listingContext, val$detailsIncluded);
  }
  
  public ResultSegment<CloudQueue> postProcessResponse(HttpURLConnection paramHttpURLConnection, Void paramVoid, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext, ResultSegment<CloudQueue> paramResultSegment)
  {
    paramVoid = QueueListHandler.getQueues(paramHttpURLConnection.getInputStream(), paramCloudQueueClient);
    if (paramVoid.getNextMarker() != null)
    {
      paramHttpURLConnection = new ResultContinuation();
      paramHttpURLConnection.setNextMarker(paramVoid.getNextMarker());
      paramHttpURLConnection.setContinuationType(ResultContinuationType.QUEUE);
      paramHttpURLConnection.setTargetLocation(getResult().getTargetLocation());
    }
    else
    {
      paramHttpURLConnection = null;
    }
    paramHttpURLConnection = new ResultSegment(paramVoid.getResults(), paramVoid.getMaxResults(), paramHttpURLConnection);
    val$segmentedRequest.setToken(paramHttpURLConnection.getContinuationToken());
    return paramHttpURLConnection;
  }
  
  public ResultSegment<CloudQueue> preProcessResponse(Void paramVoid, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(Utility.getListingLocationMode(val$segmentedRequest.getToken()));
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueueClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */