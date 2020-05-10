package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;

public class CloudBlob$3
  extends StorageRequest<CloudBlobClient, CloudBlob, Long>
{
  public CloudBlob$3(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, Integer paramInteger)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.leaseBlob(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, LeaseAction.BREAK, null, null, val$breakPeriodInSeconds);
  }
  
  public Long preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    int i = getResult().getStatusCode();
    long l = -1L;
    if (i != 202)
    {
      setNonExceptionedRetryableFailure(true);
      return Long.valueOf(-1L);
    }
    this$0.updateEtagAndLastModifiedFromResponse(getConnection());
    paramCloudBlobClient = BlobResponse.getLeaseTime(getConnection());
    properties.setLeaseStatus(LeaseStatus.UNLOCKED);
    if (!Utility.isNullOrEmpty(paramCloudBlobClient)) {
      l = Long.parseLong(paramCloudBlobClient);
    }
    return Long.valueOf(l);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlob.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */