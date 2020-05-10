package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudQueue$11
  extends StorageRequest<CloudQueueClient, CloudQueue, Void>
{
  public CloudQueue$11(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, QueueRequestOptions paramQueueRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    return QueueRequest.setMetadata(CloudQueue.access$200(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public Void preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 204) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    QueueRequest.addMetadata(paramHttpURLConnection, CloudQueue.access$300(paramCloudQueue), paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.CloudQueue.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */