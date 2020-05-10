package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;

public class CloudBlobContainer$7
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, ResultSegment<ListBlobItem>>
{
  public CloudBlobContainer$7(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, SegmentedStorageRequest paramSegmentedStorageRequest, BlobListingContext paramBlobListingContext, BlobRequestOptions paramBlobRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    BlobListingContext localBlobListingContext = val$listingContext;
    if (val$segmentedRequest.getToken() != null) {
      paramCloudBlobClient = val$segmentedRequest.getToken().getNextMarker();
    } else {
      paramCloudBlobClient = null;
    }
    localBlobListingContext.setMarker(paramCloudBlobClient);
    return BlobRequest.listBlobs(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$listingContext);
  }
  
  public ResultSegment<ListBlobItem> postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext, ResultSegment<ListBlobItem> paramResultSegment)
  {
    paramCloudBlobContainer = BlobListHandler.getBlobList(paramHttpURLConnection.getInputStream(), paramCloudBlobContainer);
    if (paramCloudBlobContainer.getNextMarker() != null)
    {
      paramHttpURLConnection = new ResultContinuation();
      paramHttpURLConnection.setNextMarker(paramCloudBlobContainer.getNextMarker());
      paramHttpURLConnection.setContinuationType(ResultContinuationType.BLOB);
      paramHttpURLConnection.setTargetLocation(getResult().getTargetLocation());
    }
    else
    {
      paramHttpURLConnection = null;
    }
    paramHttpURLConnection = new ResultSegment(paramCloudBlobContainer.getResults(), paramCloudBlobContainer.getMaxResults(), paramHttpURLConnection);
    val$segmentedRequest.setToken(paramHttpURLConnection.getContinuationToken());
    return paramHttpURLConnection;
  }
  
  public ResultSegment<ListBlobItem> preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
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
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobContainer.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */