package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFile$10
  extends StorageRequest<CloudFileClient, CloudFile, Void>
{
  public CloudFile$10(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    return FileRequest.setFileMetadata(paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition);
  }
  
  public Void preProcessResponse(CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    FileRequest.addMetadata(paramHttpURLConnection, CloudFile.access$000(paramCloudFile), paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFile.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */