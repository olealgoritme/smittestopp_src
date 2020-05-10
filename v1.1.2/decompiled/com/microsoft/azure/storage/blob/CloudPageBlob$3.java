package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.List;

public class CloudPageBlob$3
  extends StorageRequest<CloudBlobClient, CloudBlob, List<PageRangeDiff>>
{
  public CloudPageBlob$3(CloudPageBlob paramCloudPageBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, String paramString, Long paramLong1, Long paramLong2)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    return BlobRequest.getPageRangesDiff(paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, snapshotID, val$previousSnapshot, val$offset, val$length);
  }
  
  public List<PageRangeDiff> postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext, List<PageRangeDiff> paramList)
  {
    paramCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
    paramCloudBlob.updateLengthFromResponse(getConnection());
    return PageRangeDiffHandler.getPageRangesDiff(getConnection().getInputStream());
  }
  
  public List<PageRangeDiff> preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudBlobClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudPageBlob.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */