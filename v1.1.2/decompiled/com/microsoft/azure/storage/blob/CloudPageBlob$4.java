package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudPageBlob$4
  extends StorageRequest<CloudBlobClient, CloudPageBlob, Void>
{
  public CloudPageBlob$4(CloudPageBlob paramCloudPageBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, PageOperationType paramPageOperationType, byte[] paramArrayOfByte, long paramLong, OperationContext paramOperationContext, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, PageRange paramPageRange, String paramString)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudPageBlob paramCloudPageBlob, OperationContext paramOperationContext)
  {
    if (val$operationType == PageOperationType.UPDATE)
    {
      setSendStream(new ByteArrayInputStream(val$data));
      setLength(Long.valueOf(val$length));
    }
    return BlobRequest.putPage(paramCloudPageBlob.getTransformedAddress(val$opContext).getUri(getCurrentLocation()), val$options, val$opContext, val$accessCondition, val$pageRange, val$operationType);
  }
  
  public Void preProcessResponse(CloudPageBlob paramCloudPageBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudPageBlob.updateEtagAndLastModifiedFromResponse(getConnection());
    paramCloudPageBlob.updateSequenceNumberFromResponse(getConnection());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudPageBlob paramCloudPageBlob, OperationContext paramOperationContext)
  {
    if ((val$operationType == PageOperationType.UPDATE) && (val$options.getUseTransactionalContentMD5().booleanValue())) {
      paramHttpURLConnection.setRequestProperty("Content-MD5", val$md5);
    }
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (val$operationType == PageOperationType.UPDATE) {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, val$length, paramOperationContext);
    } else {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudPageBlob.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */