package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class CloudBlockBlob$4
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudBlockBlob$4(CloudBlockBlob paramCloudBlockBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, InputStream paramInputStream, long paramLong, OperationContext paramOperationContext, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    setSendStream(val$sourceStream);
    setLength(Long.valueOf(val$length));
    paramCloudBlobClient = paramCloudBlob.getTransformedAddress(val$opContext).getUri(getCurrentLocation());
    paramOperationContext = val$options;
    OperationContext localOperationContext = val$opContext;
    AccessCondition localAccessCondition = val$accessCondition;
    paramCloudBlob = properties;
    return BlobRequest.putBlob(paramCloudBlobClient, paramOperationContext, localOperationContext, localAccessCondition, paramCloudBlob, paramCloudBlob.getBlobType(), getLength().longValue());
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
    val$sourceStream.reset();
    val$sourceStream.mark(268435456);
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    BlobRequest.addMetadata(paramHttpURLConnection, metadata, val$opContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, val$length, paramOperationContext);
  }
  
  public void validateStreamWrite(StreamMd5AndLength paramStreamMd5AndLength)
  {
    if ((getLength() != null) && (getLength().longValue() != -1L) && (val$length != paramStreamMd5AndLength.getLength())) {
      throw new StorageException("InvalidInput", "An incorrect stream length was specified, resulting in an authentication failure. Please specify correct length, or -1.", 403, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlockBlob.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */