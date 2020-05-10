package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobContainer$1
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, Void>
{
  public CloudBlobContainer$1(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, BlobContainerPublicAccessType paramBlobContainerPublicAccessType)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.createContainer(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessType);
  }
  
  public Void preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlobClient = BlobResponse.getBlobContainerAttributes(getConnection(), paramCloudBlobClient.isUsePathStyleUris());
    properties = paramCloudBlobClient.getProperties();
    name = paramCloudBlobClient.getName();
    paramCloudBlobClient = val$accessType;
    if (paramCloudBlobClient != null) {
      properties.setPublicAccess(paramCloudBlobClient);
    } else {
      properties.setPublicAccess(BlobContainerPublicAccessType.OFF);
    }
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
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobContainer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */