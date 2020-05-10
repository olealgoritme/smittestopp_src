package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobContainer$5
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, Boolean>
{
  public CloudBlobContainer$5(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, boolean paramBoolean, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.getContainerProperties(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition);
  }
  
  public Boolean preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() == 200)
    {
      paramCloudBlobClient = BlobResponse.getBlobContainerAttributes(getConnection(), paramCloudBlobClient.isUsePathStyleUris());
      metadata = paramCloudBlobClient.getMetadata();
      properties = paramCloudBlobClient.getProperties();
      name = paramCloudBlobClient.getName();
      return Boolean.valueOf(true);
    }
    if (getResult().getStatusCode() == 404) {
      return Boolean.valueOf(false);
    }
    setNonExceptionedRetryableFailure(true);
    return Boolean.valueOf(false);
  }
  
  public void setRequestLocationMode()
  {
    RequestLocationMode localRequestLocationMode;
    if (val$primaryOnly) {
      localRequestLocationMode = RequestLocationMode.PRIMARY_ONLY;
    } else {
      localRequestLocationMode = RequestLocationMode.PRIMARY_OR_SECONDARY;
    }
    setRequestLocationMode(localRequestLocationMode);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobContainer.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */