package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFile$8
  extends StorageRequest<CloudFileClient, CloudFile, Boolean>
{
  public CloudFile$8(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, boolean paramBoolean, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    return FileRequest.getFileProperties(paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, getSharesnapshotID);
  }
  
  public Boolean preProcessResponse(CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() == 200)
    {
      paramCloudFileClient = FileResponse.getFileAttributes(getConnection(), paramCloudFile.getStorageUri());
      CloudFile.access$102(paramCloudFile, paramCloudFileClient.getProperties());
      CloudFile.access$002(paramCloudFile, paramCloudFileClient.getMetadata());
      return Boolean.valueOf(true);
    }
    if (getResult().getStatusCode() == 404) {
      return Boolean.valueOf(false);
    }
    setNonExceptionedRetryableFailure(true);
    return Boolean.valueOf(false);
  }
  
  public void setRequestLocationMode()
  {
    RequestLocationMode localRequestLocationMode;
    if (val$primaryOnly) {
      localRequestLocationMode = RequestLocationMode.PRIMARY_ONLY;
    } else {
      localRequestLocationMode = RequestLocationMode.PRIMARY_OR_SECONDARY;
    }
    setRequestLocationMode(localRequestLocationMode);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFile.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */