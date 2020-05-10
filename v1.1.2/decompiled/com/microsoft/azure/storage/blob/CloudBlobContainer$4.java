package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
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

public class CloudBlobContainer$4
  extends StorageRequest<CloudBlobClient, CloudBlobContainer, BlobContainerPermissions>
{
  public CloudBlobContainer$4(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BlobRequest.getAcl(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, val$accessCondition, paramOperationContext);
  }
  
  public BlobContainerPermissions postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext, BlobContainerPermissions paramBlobContainerPermissions)
  {
    paramCloudBlobContainer = SharedAccessPolicyHandler.getAccessIdentifiers(getConnection().getInputStream(), SharedAccessBlobPolicy.class);
    paramCloudBlobClient = paramCloudBlobContainer.keySet().iterator();
    while (paramCloudBlobClient.hasNext())
    {
      paramHttpURLConnection = (String)paramCloudBlobClient.next();
      paramBlobContainerPermissions.getSharedAccessPolicies().put(paramHttpURLConnection, paramCloudBlobContainer.get(paramHttpURLConnection));
    }
    return paramBlobContainerPermissions;
  }
  
  public BlobContainerPermissions preProcessResponse(CloudBlobContainer paramCloudBlobContainer, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    paramCloudBlobContainer.updatePropertiesFromResponse(getConnection());
    paramCloudBlobClient = CloudBlobContainer.getContainerAcl(BlobResponse.getAcl(getConnection()));
    properties.setPublicAccess(paramCloudBlobClient.getPublicAccess());
    return paramCloudBlobClient;
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
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobContainer.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */