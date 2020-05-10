package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFileDirectory$1
  extends StorageRequest<CloudFileClient, CloudFileDirectory, Void>
{
  public CloudFileDirectory$1(CloudFileDirectory paramCloudFileDirectory, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileDirectory paramCloudFileDirectory, OperationContext paramOperationContext)
  {
    return FileRequest.createDirectory(CloudFileDirectory.access$000(paramCloudFileDirectory).getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public Void preProcessResponse(CloudFileDirectory paramCloudFileDirectory, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudFileDirectory.setProperties(FileResponse.getFileDirectoryAttributes(getConnection(), paramCloudFileClient.isUsePathStyleUris()).getProperties());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudFileDirectory paramCloudFileDirectory, OperationContext paramOperationContext)
  {
    FileRequest.addMetadata(paramHttpURLConnection, paramCloudFileDirectory.getMetadata(), paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileDirectory.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */