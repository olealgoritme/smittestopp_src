package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class ServiceClient$3
  extends StorageRequest<ServiceClient, Void, Void>
{
  public ServiceClient$3(ServiceClient paramServiceClient, RequestOptions paramRequestOptions1, StorageUri paramStorageUri, ByteArrayInputStream paramByteArrayInputStream, StreamMd5AndLength paramStreamMd5AndLength, RequestOptions paramRequestOptions2, boolean paramBoolean)
  {
    super(paramRequestOptions1, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(ServiceClient paramServiceClient, Void paramVoid, OperationContext paramOperationContext)
  {
    setSendStream(val$sendStream);
    setLength(Long.valueOf(val$descriptor.getLength()));
    return BaseRequest.setServiceProperties(this$0.credentials.transformUri(paramServiceClient.getEndpoint()), val$options, null, paramOperationContext);
  }
  
  public Void preProcessResponse(Void paramVoid, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 202) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void recoveryAction(OperationContext paramOperationContext)
  {
    val$sendStream.reset();
    val$sendStream.mark(268435456);
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, Void paramVoid, OperationContext paramOperationContext)
  {
    paramHttpURLConnection.setRequestProperty("Content-MD5", val$descriptor.getMd5());
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, ServiceClient paramServiceClient, OperationContext paramOperationContext)
  {
    if (val$signAsTable) {
      StorageRequest.signTableRequest(paramHttpURLConnection, paramServiceClient, val$descriptor.getLength(), paramOperationContext);
    } else {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramServiceClient, val$descriptor.getLength(), paramOperationContext);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ServiceClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */