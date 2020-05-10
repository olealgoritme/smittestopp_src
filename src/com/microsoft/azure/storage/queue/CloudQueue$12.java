package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudQueue$12
  extends StorageRequest<CloudQueueClient, CloudQueue, Void>
{
  public CloudQueue$12(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, QueueRequestOptions paramQueueRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$aclBytes));
    setLength(Long.valueOf(val$aclBytes.length));
    return QueueRequest.setAcl(CloudQueue.access$200(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext);
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
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, val$aclBytes.length, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueue.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */