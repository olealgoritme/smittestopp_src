package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class CloudFileShare$5
  extends StorageRequest<CloudFileClient, CloudFileShare, CloudFileShare>
{
  public CloudFileShare$5(CloudFileShare paramCloudFileShare, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition, HashMap paramHashMap)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    return FileRequest.snapshotShare(CloudFileShare.access$000(paramCloudFileShare).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition);
  }
  
  public CloudFileShare preProcessResponse(CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramOperationContext = FileResponse.getSnapshotTime(getConnection());
    paramOperationContext = new CloudFileShare(paramCloudFileShare.getName(), paramOperationContext, paramCloudFileClient);
    paramOperationContext.setProperties(new FileShareProperties(properties));
    paramCloudFileClient = val$metadata;
    if (paramCloudFileClient != null) {
      paramCloudFileShare = paramCloudFileClient;
    } else {
      paramCloudFileShare = CloudFileShare.access$100(paramCloudFileShare);
    }
    paramOperationContext.setMetadata(paramCloudFileShare);
    CloudFileShare.access$200(paramOperationContext, getConnection());
    return paramOperationContext;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    paramCloudFileShare = val$metadata;
    if (paramCloudFileShare != null) {
      FileRequest.addMetadata(paramHttpURLConnection, paramCloudFileShare, paramOperationContext);
    }
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileShare.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */