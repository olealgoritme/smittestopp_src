package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobContainer$8
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, Void>
{
  public CloudBlobContainer$8(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.setContainerMetadata(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition);
  }
  
  public Void preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    paramCloudBlobContainer.updatePropertiesFromResponse(getConnection());
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    BlobRequest.addMetadata(paramHttpURLConnection, metadata, paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobContainer.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */