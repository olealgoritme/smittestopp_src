package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobContainer$15
  extends StorageRequest<ServiceClient, CloudBlobContainer, AccountInformation>
{
  public CloudBlobContainer$15(CloudBlobContainer paramCloudBlobContainer, RequestOptions paramRequestOptions1, StorageUri paramStorageUri, RequestOptions paramRequestOptions2)
  {
    super(paramRequestOptions1, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(ServiceClient paramServiceClient, CloudBlobContainer paramCloudBlobContainer, OperationContext paramOperationContext)
  {
    return BaseRequest.getAccountInfo(CloudBlobContainer.access$000(paramCloudBlobContainer).getUri(getCurrentLocation()), val$options, null, paramOperationContext);
  }
  
  public AccountInformation preProcessResponse(CloudBlobContainer paramCloudBlobContainer, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    return BlobResponse.getAccountInformation(getConnection());
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramServiceClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobContainer.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */