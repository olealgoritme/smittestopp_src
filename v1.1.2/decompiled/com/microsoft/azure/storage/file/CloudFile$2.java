package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.net.URI;

public class CloudFile$2
  extends StorageRequest<CloudFileClient, CloudFile, String>
{
  public CloudFile$2(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, URI paramURI)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    return FileRequest.copyFrom(paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, paramOperationContext, val$sourceAccessCondition, val$destinationAccessCondition, val$source.toASCIIString());
  }
  
  public String preProcessResponse(CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 202)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
    CloudFile.access$100(paramCloudFile).setCopyState(FileResponse.getCopyState(getConnection()));
    return CloudFile.access$100(paramCloudFile).getCopyState().getCopyId();
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    FileRequest.addMetadata(paramHttpURLConnection, CloudFile.access$000(paramCloudFile), paramOperationContext);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFile.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */