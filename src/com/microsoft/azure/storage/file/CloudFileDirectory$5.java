package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFileDirectory$5
  extends StorageRequest<CloudFileClient, CloudFileDirectory, Void>
{
  public CloudFileDirectory$5(CloudFileDirectory paramCloudFileDirectory, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileDirectory paramCloudFileDirectory, OperationContext paramOperationContext)
  {
    return FileRequest.getDirectoryProperties(CloudFileDirectory.access$000(paramCloudFileDirectory).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, getSharesnapshotID);
  }
  
  public Void preProcessResponse(CloudFileDirectory paramCloudFileDirectory, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudFileClient = FileResponse.getFileDirectoryAttributes(getConnection(), paramCloudFileClient.isUsePathStyleUris());
    paramCloudFileDirectory.setMetadata(paramCloudFileClient.getMetadata());
    paramCloudFileDirectory.setProperties(paramCloudFileClient.getProperties());
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
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileDirectory.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */