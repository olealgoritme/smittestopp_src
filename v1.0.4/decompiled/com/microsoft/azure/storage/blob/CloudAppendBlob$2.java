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

public class CloudAppendBlob$2
  extends StorageRequest<CloudBlobClient, CloudAppendBlob, Long>
{
  public CloudAppendBlob$2(CloudAppendBlob paramCloudAppendBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, InputStream paramInputStream, long paramLong, OperationContext paramOperationContext, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, String paramString)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudAppendBlob paramCloudAppendBlob, OperationContext paramOperationContext)
  {
    setSendStream(val$sourceStream);
    setLength(Long.valueOf(val$length));
    return BlobRequest.appendBlock(paramCloudAppendBlob.getTransformedAddress(val$opContext).getUri(getCurrentLocation()), val$options, val$opContext, val$accessCondition);
  }
  
  public Long preProcessResponse(CloudAppendBlob paramCloudAppendBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    int i = getResult().getStatusCode();
    paramCloudBlobClient = null;
    if (i != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    if (getConnection().getHeaderField("x-ms-blob-append-offset") != null) {
      paramCloudBlobClient = Long.valueOf(Long.parseLong(getConnection().getHeaderField("x-ms-blob-append-offset")));
    }
    paramCloudAppendBlob.updateEtagAndLastModifiedFromResponse(getConnection());
    CloudAppendBlob.access$000(paramCloudAppendBlob, getConnection());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return paramCloudBlobClient;
  }
  
  public void recoveryAction(OperationContext paramOperationContext)
  {
    val$sourceStream.reset();
    val$sourceStream.mark(268435456);
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudAppendBlob paramCloudAppendBlob, OperationContext paramOperationContext)
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
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudAppendBlob.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */