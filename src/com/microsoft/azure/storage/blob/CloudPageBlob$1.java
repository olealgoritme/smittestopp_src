package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudPageBlob$1
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudPageBlob$1(CloudPageBlob paramCloudPageBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.putBlob(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, properties, BlobType.PAGE_BLOB, val$length, val$premiumBlobTier);
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
    paramCloudBlob.getProperties().setLength(val$length);
    paramCloudBlob.getProperties().setPremiumPageBlobTier(val$premiumBlobTier);
    if (val$premiumBlobTier != null) {
      paramCloudBlob.getProperties().setBlobTierInferred(Boolean.valueOf(false));
    }
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    BlobRequest.addMetadata(paramHttpURLConnection, metadata, paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudPageBlob.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */