package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.SharedAccessPolicyHandler;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CloudQueue$13
  extends StorageRequest<CloudQueueClient, CloudQueue, QueuePermissions>
{
  public CloudQueue$13(CloudQueue paramCloudQueue, RequestOptions paramRequestOptions, StorageUri paramStorageUri, QueueRequestOptions paramQueueRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudQueueClient paramCloudQueueClient, CloudQueue paramCloudQueue, OperationContext paramOperationContext)
  {
    return QueueRequest.getAcl(CloudQueue.access$200(paramCloudQueue, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public QueuePermissions postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext, QueuePermissions paramQueuePermissions)
  {
    paramCloudQueue = SharedAccessPolicyHandler.getAccessIdentifiers(getConnection().getInputStream(), SharedAccessQueuePolicy.class);
    paramCloudQueueClient = paramCloudQueue.keySet().iterator();
    while (paramCloudQueueClient.hasNext())
    {
      paramHttpURLConnection = (String)paramCloudQueueClient.next();
      paramQueuePermissions.getSharedAccessPolicies().put(paramHttpURLConnection, paramCloudQueue.get(paramHttpURLConnection));
    }
    return paramQueuePermissions;
  }
  
  public QueuePermissions preProcessResponse(CloudQueue paramCloudQueue, CloudQueueClient paramCloudQueueClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    return new QueuePermissions();
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
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueue.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */