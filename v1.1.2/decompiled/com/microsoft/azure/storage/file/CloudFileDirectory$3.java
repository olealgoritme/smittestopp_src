package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFileDirectory$3
  extends StorageRequest<CloudFileClient, CloudFileDirectory, Boolean>
{
  public CloudFileDirectory$3(CloudFileDirectory paramCloudFileDirectory, RequestOptions paramRequestOptions, StorageUri paramStorageUri, boolean paramBoolean, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileDirectory paramCloudFileDirectory, OperationContext paramOperationContext)
  {
    return FileRequest.getDirectoryProperties(CloudFileDirectory.access$000(paramCloudFileDirectory).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, getSharesnapshotID);
  }
  
  public Boolean preProcessResponse(CloudFileDirectory paramCloudFileDirectory, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() == 200)
    {
      CloudFileDirectory.access$100(paramCloudFileDirectory, getConnection());
      paramCloudFileClient = FileResponse.getFileDirectoryAttributes(getConnection(), paramCloudFileClient.isUsePathStyleUris());
      paramCloudFileDirectory.setMetadata(paramCloudFileClient.getMetadata());
      paramCloudFileDirectory.setProperties(paramCloudFileClient.getProperties());
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
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileDirectory.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */