package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudQueue$5
  extends StorageRequest<CloudQueueClient, CloudQueue, Void>
{
  public CloudQueue$5(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, String paramString1, QueueRequestOptions paramQueueRequestOptions, String paramString2)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    return QueueRequest.deleteMessage(CloudQueue.access$400(paramCloudQueue, val$messageId, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$messagePopReceipt);
  }
  
  public Void preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 204) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.CloudQueue.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */