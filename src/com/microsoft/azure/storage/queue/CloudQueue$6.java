package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudQueue$6
  extends StorageRequest<CloudQueueClient, CloudQueue, Void>
{
  public CloudQueue$6(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, QueueRequestOptions paramQueueRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    return QueueRequest.downloadAttributes(CloudQueue.access$200(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public Void preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    CloudQueue.access$302(paramCloudQueue, BaseResponse.getMetadata(getConnection()));
    CloudQueue.access$502(paramCloudQueue, QueueResponse.getApproximateMessageCount(getConnection()));
    return null;
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueue.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */