package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.ArrayList;

public class CloudFile$5
  extends StorageRequest<CloudFileClient, CloudFile, ArrayList<FileRange>>
{
  public CloudFile$5(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    return FileRequest.getFileRanges(paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition, getSharesnapshotID);
  }
  
  public ArrayList<FileRange> postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext, ArrayList<FileRange> paramArrayList)
  {
    paramCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
    paramCloudFile.updateLengthFromResponse(getConnection());
    return FileRangeHandler.getFileRanges(getConnection().getInputStream());
  }
  
  public ArrayList<FileRange> preProcessResponse(CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
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
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFile.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */