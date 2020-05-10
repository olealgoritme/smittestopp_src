package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;

public class CloudBlob$14
  extends StorageRequest<CloudBlobClient, CloudBlob, Void>
{
  public CloudBlob$14(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, String paramString)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.setBlobTier(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$blobTierString);
  }
  
  public Void preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if ((getResult().getStatusCode() != 200) && (getResult().getStatusCode() != 202))
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    paramCloudBlob.getProperties().setBlobTierInferred(Boolean.valueOf(false));
    if (paramCloudBlob.getProperties().getBlobType() == BlobType.BLOCK_BLOB)
    {
      paramCloudBlobClient = StandardBlobTier.parse(val$blobTierString);
      paramCloudBlob.getProperties().setRehydrationStatus(null);
      if (getResult().getStatusCode() == 200) {
        paramCloudBlob.getProperties().setStandardBlobTier(paramCloudBlobClient);
      } else if (paramCloudBlobClient.equals(StandardBlobTier.COOL)) {
        paramCloudBlob.getProperties().setStandardBlobTier(StandardBlobTier.ARCHIVE);
      } else if (paramCloudBlobClient.equals(StandardBlobTier.HOT)) {
        paramCloudBlob.getProperties().setStandardBlobTier(StandardBlobTier.ARCHIVE);
      }
    }
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlob.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */