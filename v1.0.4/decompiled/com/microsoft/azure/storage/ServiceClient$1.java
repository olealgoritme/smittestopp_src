package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class ServiceClient$1
  extends StorageRequest<ServiceClient, Void, ServiceProperties>
{
  public ServiceClient$1(ServiceClient paramServiceClient, RequestOptions paramRequestOptions1, StorageUri paramStorageUri, RequestOptions paramRequestOptions2, boolean paramBoolean)
  {
    super(paramRequestOptions1, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(ServiceClient paramServiceClient, Void paramVoid, OperationContext paramOperationContext)
  {
    return BaseRequest.getServiceProperties(this$0.credentials.transformUri(paramServiceClient.getEndpoint()), val$options, null, paramOperationContext);
  }
  
  public ServiceProperties postProcessResponse(HttpURLConnection paramHttpURLConnection, Void paramVoid, ServiceClient paramServiceClient, OperationContext paramOperationContext, ServiceProperties paramServiceProperties)
  {
    return ServicePropertiesHandler.readServicePropertiesFromStream(paramHttpURLConnection.getInputStream());
  }
  
  public ServiceProperties preProcessResponse(Void paramVoid, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    if (val$signAsTable) {
      StorageRequest.signTableRequest(paramHttpURLConnection, paramServiceClient, -1L, paramOperationContext);
    } else {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramServiceClient, -1L, paramOperationContext);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ServiceClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */