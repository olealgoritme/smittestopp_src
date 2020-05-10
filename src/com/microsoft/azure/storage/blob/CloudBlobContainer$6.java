package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobContainer$6
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, CloudBlob>
{
  public CloudBlobContainer$6(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri1, StorageUri paramStorageUri2, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, String paramString1, String paramString2)
  {
    super(paramRequestOptions, paramStorageUri1);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.getBlobProperties(this$0.getServiceClient().getCredentials().transformUri(val$blobUri, paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, val$snapshotID);
  }
  
  public CloudBlob preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlobClient = BlobResponse.getBlobAttributes(getConnection(), val$blobUri, val$snapshotID);
    int i = paramCloudBlobClient.getProperties().getBlobType().ordinal();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          paramCloudBlobContainer = paramCloudBlobContainer.getAppendBlobReference(val$blobName, val$snapshotID);
        } else {
          throw new StorageException("IncorrectBlobType", "The response received is invalid or improperly formatted.", 306, null, null);
        }
      }
      else {
        paramCloudBlobContainer = paramCloudBlobContainer.getPageBlobReference(val$blobName, val$snapshotID);
      }
    }
    else {
      paramCloudBlobContainer = paramCloudBlobContainer.getBlockBlobReference(val$blobName, val$snapshotID);
    }
    properties = paramCloudBlobClient.getProperties();
    metadata = paramCloudBlobClient.getMetadata();
    return paramCloudBlobContainer;
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobContainer.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */