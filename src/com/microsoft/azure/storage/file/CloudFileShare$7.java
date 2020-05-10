package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFileShare$7
  extends StorageRequest<CloudFileClient, CloudFileShare, Boolean>
{
  public CloudFileShare$7(CloudFileShare paramCloudFileShare, RequestOptions paramRequestOptions, StorageUri paramStorageUri, boolean paramBoolean, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    return FileRequest.getShareProperties(CloudFileShare.access$000(paramCloudFileShare).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, snapshotID);
  }
  
  public Boolean preProcessResponse(CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() == 200)
    {
      CloudFileShare.access$200(paramCloudFileShare, getConnection());
      paramCloudFileClient = FileResponse.getFileShareAttributes(getConnection(), paramCloudFileClient.isUsePathStyleUris());
      CloudFileShare.access$102(paramCloudFileShare, paramCloudFileClient.getMetadata());
      properties = paramCloudFileClient.getProperties();
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
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileShare.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */