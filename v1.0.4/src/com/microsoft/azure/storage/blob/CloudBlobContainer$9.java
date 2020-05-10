package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudBlobContainer$9
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, Void>
{
  public CloudBlobContainer$9(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, BlobContainerPermissions paramBlobContainerPermissions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$aclBytes));
    setLength(Long.valueOf(val$aclBytes.length));
    return BlobRequest.setAcl(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, val$permissions.getPublicAccess());
  }
  
  public Void preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlobContainer.updatePropertiesFromResponse(getConnection());
    paramCloudBlobContainer.getProperties().setPublicAccess(val$permissions.getPublicAccess());
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, val$aclBytes.length, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobContainer.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */