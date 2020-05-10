package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class CloudQueue$1
  extends StorageRequest<CloudQueueClient, CloudQueue, Void>
{
  public CloudQueue$1(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, QueueRequestOptions paramQueueRequestOptions, int paramInt1, int paramInt2, CloudQueueMessage paramCloudQueueMessage)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$messageBytes));
    setLength(Long.valueOf(val$messageBytes.length));
    return QueueRequest.putMessage(CloudQueue.access$000(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$initialVisibilityDelayInSeconds, val$timeToLiveInSeconds);
  }
  
  public Void preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudQueue = (CloudQueueMessage)QueueMessageHandler.readMessages(getConnection().getInputStream(), CloudQueue.access$100(paramCloudQueue)).get(0);
    val$message.setInsertionTime(paramCloudQueue.getInsertionTime());
    val$message.setExpirationTime(paramCloudQueue.getExpirationTime());
    val$message.setNextVisibleTime(paramCloudQueue.getNextVisibleTime());
    val$message.setMessageId(paramCloudQueue.getMessageId());
    val$message.setPopReceipt(paramCloudQueue.getPopReceipt());
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, val$messageBytes.length, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */