package com.microsoft.azure.storage.file;

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
import java.util.EnumSet;

public class CloudFileClient$1
  extends StorageRequest<CloudFileClient, Void, ResultSegment<CloudFileShare>>
{
  public CloudFileClient$1(CloudFileClient paramCloudFileClient, RequestOptions paramRequestOptions, StorageUri paramStorageUri, SegmentedStorageRequest paramSegmentedStorageRequest, ListingContext paramListingContext, FileRequestOptions paramFileRequestOptions, EnumSet paramEnumSet)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, Void paramVoid, OperationContext paramOperationContext)
  {
    ListingContext localListingContext = val$listingContext;
    if (val$segmentedRequest.getToken() != null) {
      paramVoid = val$segmentedRequest.getToken().getNextMarker();
    } else {
      paramVoid = null;
    }
    localListingContext.setMarker(paramVoid);
    return FileRequest.listShares(paramCloudFileClient.getCredentials().transformUri(paramCloudFileClient.getStorageUri()).getUri(getCurrentLocation()), val$options, paramOperationContext, val$listingContext, val$detailsIncluded);
  }
  
  public ResultSegment<CloudFileShare> postProcessResponse(HttpURLConnection paramHttpURLConnection, Void paramVoid, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext, ResultSegment<CloudFileShare> paramResultSegment)
  {
    paramVoid = ShareListHandler.getShareList(getConnection().getInputStream(), paramCloudFileClient);
    if (paramVoid.getNextMarker() != null)
    {
      paramHttpURLConnection = new ResultContinuation();
      paramHttpURLConnection.setNextMarker(paramVoid.getNextMarker());
      paramHttpURLConnection.setContinuationType(ResultContinuationType.SHARE);
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
  
  public ResultSegment<CloudFileShare> preProcessResponse(Void paramVoid, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
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
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */