package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class CloudQueue$8
  extends StorageRequest<CloudQueueClient, CloudQueue, ArrayList<CloudQueueMessage>>
{
  public CloudQueue$8(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, QueueRequestOptions paramQueueRequestOptions, int paramInt)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    return QueueRequest.peekMessages(CloudQueue.access$000(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$numberOfMessages);
  }
  
  public ArrayList<CloudQueueMessage> preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudQueue = QueueMessageHandler.readMessages(getConnection().getInputStream(), CloudQueue.access$100(paramCloudQueue));
    if (val$options.getEncryptionPolicy() != null)
    {
      paramCloudQueueClient = paramCloudQueue.iterator();
      while (paramCloudQueueClient.hasNext())
      {
        paramOperationContext = (CloudQueueMessage)paramCloudQueueClient.next();
        paramOperationContext.setMessageContent(val$options.getEncryptionPolicy().decryptMessage(messageContent, val$options.requireEncryption()));
      }
    }
    return paramCloudQueue;
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
 * Qualified Name:     com.microsoft.azure.storage.queue.CloudQueue.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */