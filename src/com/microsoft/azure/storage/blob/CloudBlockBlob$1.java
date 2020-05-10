package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudBlockBlob$1
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudBlockBlob$1(CloudBlockBlob paramCloudBlockBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, ByteArrayInputStream paramByteArrayInputStream, StreamMd5AndLength paramStreamMd5AndLength, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    setSendStream(val$blockListInputStream);
    setLength(Long.valueOf(val$descriptor.getLength()));
    return BlobRequest.putBlockList(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, properties);
  }
  
  public Void preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return null;
  }
  
  public void recoveryAction(OperationContext paramOperationContext)
  {
    val$blockListInputStream.reset();
    val$blockListInputStream.mark(268435456);
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    BlobRequest.addMetadata(paramHttpURLConnection, metadata, paramOperationContext);
    if (val$options.getUseTransactionalContentMD5().booleanValue()) {
      paramHttpURLConnection.setRequestProperty("Content-MD5", val$descriptor.getMd5());
    }
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, getLength().longValue(), paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlockBlob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */