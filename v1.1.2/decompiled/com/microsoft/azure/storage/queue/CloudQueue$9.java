package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class CloudQueue$9
  extends StorageRequest<CloudQueueClient, CloudQueue, ArrayList<CloudQueueMessage>>
{
  public CloudQueue$9(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, QueueRequestOptions paramQueueRequestOptions, int paramInt1, int paramInt2)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    return QueueRequest.retrieveMessages(CloudQueue.access$000(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$numberOfMessages, val$visibilityTimeoutInSeconds);
  }
  
  public ArrayList<CloudQueueMessage> preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramOperationContext = QueueMessageHandler.readMessages(getConnection().getInputStream(), CloudQueue.access$100(paramCloudQueue));
    if (val$options.getEncryptionPolicy() != null)
    {
      paramCloudQueue = paramOperationContext.iterator();
      while (paramCloudQueue.hasNext())
      {
        paramCloudQueueClient = (CloudQueueMessage)paramCloudQueue.next();
        paramCloudQueueClient.setMessageContent(val$options.getEncryptionPolicy().decryptMessage(messageContent, val$options.requireEncryption()));
      }
    }
    return paramOperationContext;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.CloudQueue.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */