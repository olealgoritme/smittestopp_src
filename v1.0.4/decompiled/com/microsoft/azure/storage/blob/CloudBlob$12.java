package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlob$12
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudBlob$12(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.leaseBlob(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, LeaseAction.RELEASE, null, null, null);
  }
  
  public Void preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    this$0.updateEtagAndLastModifiedFromResponse(getConnection());
    properties.setLeaseStatus(LeaseStatus.UNLOCKED);
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlob.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */