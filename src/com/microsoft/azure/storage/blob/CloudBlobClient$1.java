package com.microsoft.azure.storage.blob;

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

public class CloudBlobClient$1
  extends StorageRequest<CloudBlobClient, Void, ResultSegment<CloudBlobContainer>>
{
  public CloudBlobClient$1(CloudBlobClient paramCloudBlobClient, RequestOptions paramRequestOptions, StorageUri paramStorageUri, SegmentedStorageRequest paramSegmentedStorageRequest, ListingContext paramListingContext, BlobRequestOptions paramBlobRequestOptions, ContainerListingDetails paramContainerListingDetails)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, Void paramVoid, OperationContext paramOperationContext)
  {
    ListingContext localListingContext = val$listingContext;
    if (val$segmentedRequest.getToken() != null) {
      paramVoid = val$segmentedRequest.getToken().getNextMarker();
    } else {
      paramVoid = null;
    }
    localListingContext.setMarker(paramVoid);
    return BlobRequest.listContainers(paramCloudBlobClient.getCredentials().transformUri(paramCloudBlobClient.getStorageUri()).getUri(getCurrentLocation()), val$options, paramOperationContext, val$listingContext, val$detailsIncluded);
  }
  
  public ResultSegment<CloudBlobContainer> postProcessResponse(HttpURLConnection paramHttpURLConnection, Void paramVoid, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext, ResultSegment<CloudBlobContainer> paramResultSegment)
  {
    paramVoid = ContainerListHandler.getContainerList(getConnection().getInputStream(), paramCloudBlobClient);
    if (paramVoid.getNextMarker() != null)
    {
      paramHttpURLConnection = new ResultContinuation();
      paramHttpURLConnection.setNextMarker(paramVoid.getNextMarker());
      paramHttpURLConnection.setContinuationType(ResultContinuationType.CONTAINER);
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
  
  public ResultSegment<CloudBlobContainer> preProcessResponse(Void paramVoid, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
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
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */