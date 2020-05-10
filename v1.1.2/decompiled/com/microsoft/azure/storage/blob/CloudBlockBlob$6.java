package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.net.URI;

public class CloudBlockBlob$6
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudBlockBlob$6(CloudBlockBlob paramCloudBlockBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, OperationContext paramOperationContext, URI paramURI, Long paramLong1, Long paramLong2, BlobRequestOptions paramBlobRequestOptions, String paramString1, AccessCondition paramAccessCondition, String paramString2)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.putBlock(paramCloudBlob.getTransformedAddress(val$opContext).getUri(getCurrentLocation()), val$copySource.toASCIIString(), val$offset.longValue(), val$length, val$options, val$md5, val$opContext, val$accessCondition, val$blockId);
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
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlockBlob.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */