package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudFileShare$10
  extends StorageRequest<CloudFileClient, CloudFileShare, Void>
{
  public CloudFileShare$10(CloudFileShare paramCloudFileShare, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$aclBytes));
    setLength(Long.valueOf(val$aclBytes.length));
    return FileRequest.setAcl(CloudFileShare.access$000(paramCloudFileShare).getUri(getCurrentLocation()), val$options, paramOperationContext, val$accessCondition);
  }
  
  public Void preProcessResponse(CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    CloudFileShare.access$200(paramCloudFileShare, getConnection());
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, val$aclBytes.length, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileShare.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */