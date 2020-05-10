package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class CloudBlockBlob$5
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudBlockBlob$5(CloudBlockBlob paramCloudBlockBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, InputStream paramInputStream, long paramLong, OperationContext paramOperationContext, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, String paramString1, String paramString2)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    setSendStream(val$sourceStream);
    setLength(Long.valueOf(val$length));
    return BlobRequest.putBlock(paramCloudBlob.getTransformedAddress(val$opContext).getUri(getCurrentLocation()), val$options, val$opContext, val$accessCondition, val$blockId);
  }
  
  public Void preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return null;
  }
  
  public void recoveryAction(OperationContext paramOperationContext)
  {
    val$sourceStream.reset();
    val$sourceStream.mark(268435456);
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    if (val$options.getUseTransactionalContentMD5().booleanValue()) {
      paramHttpURLConnection.setRequestProperty("Content-MD5", val$md5);
    }
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, val$length, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlockBlob.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */