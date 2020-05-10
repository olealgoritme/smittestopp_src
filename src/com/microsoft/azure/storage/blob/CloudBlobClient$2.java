package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlobClient$2
  extends StorageRequest<ServiceClient, Void, AccountInformation>
{
  public CloudBlobClient$2(CloudBlobClient paramCloudBlobClient, RequestOptions paramRequestOptions1, StorageUri paramStorageUri, RequestOptions paramRequestOptions2)
  {
    super(paramRequestOptions1, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(ServiceClient paramServiceClient, Void paramVoid, OperationContext paramOperationContext)
  {
    return BaseRequest.getAccountInfo(CloudBlobClient.access$000(this$0).transformUri(paramServiceClient.getStorageUri().getUri(getCurrentLocation())), val$options, null, paramOperationContext);
  }
  
  public AccountInformation preProcessResponse(Void paramVoid, ServiceClient paramServiceClient, OperationContext paramOperationContext)
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
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */