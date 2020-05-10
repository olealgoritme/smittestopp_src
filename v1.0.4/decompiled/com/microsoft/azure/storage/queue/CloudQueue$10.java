package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.util.EnumSet;

public class CloudQueue$10
  extends StorageRequest<CloudQueueClient, CloudQueue, Void>
{
  public CloudQueue$10(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, EnumSet paramEnumSet, String paramString, CloudQueueMessage paramCloudQueueMessage, QueueRequestOptions paramQueueRequestOptions, int paramInt)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    if (val$messageUpdateFields.contains(MessageUpdateFields.CONTENT))
    {
      paramCloudQueueClient = QueueMessageSerializer.generateMessageRequestBody(val$stringToSend);
      setSendStream(new ByteArrayInputStream(paramCloudQueueClient));
      setLength(Long.valueOf(paramCloudQueueClient.length));
    }
    return QueueRequest.updateMessage(CloudQueue.access$400(paramCloudQueue, val$message.getId(), paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$message.getPopReceipt(), val$visibilityTimeoutInSeconds);
  }
  
  public Void preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 204)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    val$message.setPopReceipt(getConnection().getHeaderField("x-ms-popreceipt"));
    val$message.setNextVisibleTime(Utility.parseRFC1123DateFromStringInGMT(getConnection().getHeaderField("x-ms-time-next-visible")));
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (val$messageUpdateFields.contains(MessageUpdateFields.CONTENT))
    {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, getLength().longValue(), paramOperationContext);
    }
    else
    {
      paramHttpURLConnection.setFixedLengthStreamingMode(0);
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudQueueClient, 0L, paramOperationContext);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueue.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */