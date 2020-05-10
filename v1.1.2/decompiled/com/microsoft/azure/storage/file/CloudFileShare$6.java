package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFileShare$6
  extends StorageRequest<CloudFileClient, CloudFileShare, ShareStats>
{
  public CloudFileShare$6(CloudFileShare paramCloudFileShare, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    return FileRequest.getShareStats(CloudFileShare.access$000(paramCloudFileShare).getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public ShareStats postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext, ShareStats paramShareStats)
  {
    return ShareStatsHandler.readShareStatsFromStream(paramHttpURLConnection.getInputStream());
  }
  
  public ShareStats preProcessResponse(CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    CloudFileShare.access$200(paramCloudFileShare, getConnection());
    return null;
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileShare.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */