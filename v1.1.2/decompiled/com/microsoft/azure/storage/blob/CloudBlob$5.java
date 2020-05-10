package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.net.URI;

public class CloudBlob$5
  extends StorageRequest<CloudBlobClient, CloudBlob, String>
{
  public CloudBlob$5(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, URI paramURI, boolean paramBoolean1, boolean paramBoolean2, String paramString, PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.copyFrom(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$sourceAccessCondition, val$destinationAccessCondition, val$source.toASCIIString(), snapshotID, val$incrementalCopy, val$syncCopy, val$contentMd5, val$premiumPageBlobTier);
  }
  
  public String preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 202)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
    properties.setCopyState(BlobResponse.getCopyState(getConnection()));
    properties.setPremiumPageBlobTier(val$premiumPageBlobTier);
    if (val$premiumPageBlobTier != null) {
      properties.setBlobTierInferred(Boolean.valueOf(false));
    }
    return properties.getCopyState().getCopyId();
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
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlob.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */