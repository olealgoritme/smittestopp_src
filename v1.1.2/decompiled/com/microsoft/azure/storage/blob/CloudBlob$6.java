package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.HashMap;

public class CloudBlob$6
  extends StorageRequest<CloudBlobClient, CloudBlob, CloudBlob>
{
  public CloudBlob$6(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, HashMap paramHashMap)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.snapshot(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition);
  }
  
  public CloudBlob preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    int i = getResult().getStatusCode();
    paramCloudBlobClient = null;
    if (i != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramOperationContext = BlobResponse.getSnapshotTime(getConnection());
    if ((paramCloudBlob instanceof CloudBlockBlob)) {
      paramCloudBlobClient = new CloudBlockBlob(paramCloudBlob.getName(), paramOperationContext, this$0.getContainer());
    } else if ((paramCloudBlob instanceof CloudPageBlob)) {
      paramCloudBlobClient = new CloudPageBlob(paramCloudBlob.getName(), paramOperationContext, this$0.getContainer());
    } else if ((paramCloudBlob instanceof CloudAppendBlob)) {
      paramCloudBlobClient = new CloudAppendBlob(paramCloudBlob.getName(), paramOperationContext, this$0.getContainer());
    }
    paramCloudBlobClient.setProperties(properties);
    paramOperationContext = val$metadata;
    if (paramOperationContext != null) {
      paramCloudBlob = paramOperationContext;
    } else {
      paramCloudBlob = metadata;
    }
    paramCloudBlobClient.setMetadata(paramCloudBlob);
    paramCloudBlobClient.updateEtagAndLastModifiedFromResponse(getConnection());
    return paramCloudBlobClient;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    paramCloudBlob = val$metadata;
    if (paramCloudBlob != null) {
      BlobRequest.addMetadata(paramHttpURLConnection, paramCloudBlob, paramOperationContext);
    }
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlob.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */