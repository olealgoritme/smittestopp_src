package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;

public class CloudBlobContainer$13
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, Long>
{
  public CloudBlobContainer$13(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, Integer paramInteger)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, LeaseAction.BREAK, null, null, val$breakPeriodInSeconds);
  }
  
  public Long preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    int i = getResult().getStatusCode();
    long l = -1L;
    if (i != 202)
    {
      setNonExceptionedRetryableFailure(true);
      return Long.valueOf(-1L);
    }
    paramCloudBlobContainer.updatePropertiesFromResponse(getConnection());
    paramCloudBlobContainer = BlobResponse.getLeaseTime(getConnection());
    if (!Utility.isNullOrEmpty(paramCloudBlobContainer)) {
      l = Long.parseLong(paramCloudBlobContainer);
    }
    return Long.valueOf(l);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobContainer.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */