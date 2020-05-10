package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlob$2
  extends StorageRequest<CloudBlobClient, CloudBlob, String>
{
  public CloudBlob$2(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, Integer paramInteger, String paramString)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.leaseBlob(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, LeaseAction.ACQUIRE, val$leaseTimeInSeconds, val$proposedLeaseId, null);
  }
  
  public String preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    this$0.updateEtagAndLastModifiedFromResponse(getConnection());
    properties.setLeaseStatus(LeaseStatus.LOCKED);
    return BlobResponse.getLeaseID(getConnection());
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlob.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */