package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudFile$11
  extends StorageRequest<CloudFileClient, CloudFile, Void>
{
  public CloudFile$11(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    return FileRequest.setFileProperties(paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, CloudFile.access$100(paramCloudFile));
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
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFile.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */