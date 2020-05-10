package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFileShare$1
  extends StorageRequest<CloudFileClient, CloudFileShare, Void>
{
  public CloudFileShare$1(CloudFileShare paramCloudFileShare, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    return FileRequest.createShare(CloudFileShare.access$000(paramCloudFileShare).getUri(getCurrentLocation()), val$options, paramOperationContext, paramCloudFileShare.getProperties());
  }
  
  public Void preProcessResponse(CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramOperationContext = FileResponse.getFileShareAttributes(getConnection(), paramCloudFileClient.isUsePathStyleUris());
    paramCloudFileClient = properties.getShareQuota();
    paramOperationContext = paramOperationContext.getProperties();
    properties = paramOperationContext;
    paramOperationContext.setShareQuota(paramCloudFileClient);
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    FileRequest.addMetadata(paramHttpURLConnection, CloudFileShare.access$100(paramCloudFileShare), paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileShare.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */