package com.microsoft.azure.storage.file;

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

public class CloudFileDirectory$6
  extends StorageRequest<CloudFileClient, CloudFileDirectory, ResultSegment<ListFileItem>>
{
  public CloudFileDirectory$6(CloudFileDirectory paramCloudFileDirectory, RequestOptions paramRequestOptions, StorageUri paramStorageUri, SegmentedStorageRequest paramSegmentedStorageRequest, ListingContext paramListingContext, FileRequestOptions paramFileRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileDirectory paramCloudFileDirectory, OperationContext paramOperationContext)
  {
    ListingContext localListingContext = val$listingContext;
    if (val$segmentedRequest.getToken() != null) {
      paramCloudFileClient = val$segmentedRequest.getToken().getNextMarker();
    } else {
      paramCloudFileClient = null;
    }
    localListingContext.setMarker(paramCloudFileClient);
    return FileRequest.listFilesAndDirectories(CloudFileDirectory.access$000(paramCloudFileDirectory).getUri(getCurrentLocation()), val$options, paramOperationContext, val$listingContext, getSharesnapshotID);
  }
  
  public ResultSegment<ListFileItem> postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudFileDirectory paramCloudFileDirectory, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext, ResultSegment<ListFileItem> paramResultSegment)
  {
    paramCloudFileDirectory = FileListHandler.getFileAndDirectoryList(getConnection().getInputStream(), paramCloudFileDirectory);
    if (paramCloudFileDirectory.getNextMarker() != null)
    {
      paramHttpURLConnection = new ResultContinuation();
      paramHttpURLConnection.setNextMarker(paramCloudFileDirectory.getNextMarker());
      paramHttpURLConnection.setContinuationType(ResultContinuationType.FILE);
      paramHttpURLConnection.setTargetLocation(getResult().getTargetLocation());
    }
    else
    {
      paramHttpURLConnection = null;
    }
    paramHttpURLConnection = new ResultSegment(paramCloudFileDirectory.getResults(), paramCloudFileDirectory.getMaxResults(), paramHttpURLConnection);
    val$segmentedRequest.setToken(paramHttpURLConnection.getContinuationToken());
    return paramHttpURLConnection;
  }
  
  public ResultSegment<ListFileItem> preProcessResponse(CloudFileDirectory paramCloudFileDirectory, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
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
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileDirectory.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */