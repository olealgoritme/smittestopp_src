package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobContainer$10
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, String>
{
  public CloudBlobContainer$10(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, Integer paramInteger, String paramString)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, LeaseAction.ACQUIRE, val$leaseTimeInSeconds, val$proposedLeaseId, null);
  }
  
  public String preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlobContainer.updatePropertiesFromResponse(getConnection());
    return BlobResponse.getLeaseID(getConnection());
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobContainer.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */