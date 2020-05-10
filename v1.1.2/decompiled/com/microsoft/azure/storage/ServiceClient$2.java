package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class ServiceClient$2
  extends StorageRequest<ServiceClient, Void, ServiceStats>
{
  public ServiceClient$2(ServiceClient paramServiceClient, RequestOptions paramRequestOptions1, StorageUri paramStorageUri, RequestOptions paramRequestOptions2, boolean paramBoolean)
  {
    super(paramRequestOptions1, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(ServiceClient paramServiceClient, Void paramVoid, OperationContext paramOperationContext)
  {
    return BaseRequest.getServiceStats(this$0.credentials.transformUri(paramServiceClient.getStorageUri().getUri(getCurrentLocation())), val$options, null, paramOperationContext);
  }
  
  public ServiceStats postProcessResponse(HttpURLConnection paramHttpURLConnection, Void paramVoid, ServiceClient paramServiceClient, OperationContext paramOperationContext, ServiceStats paramServiceStats)
  {
    return ServiceStatsHandler.readServiceStatsFromStream(paramHttpURLConnection.getInputStream());
  }
  
  public ServiceStats preProcessResponse(Void paramVoid, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void setRequestLocationMode()
  {
    applyLocationModeToRequest();
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
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
 * Qualified Name:     com.microsoft.azure.storage.ServiceClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */