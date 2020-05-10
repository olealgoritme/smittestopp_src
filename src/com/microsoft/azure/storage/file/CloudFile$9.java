package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudFile$9
  extends StorageRequest<CloudFileClient, CloudFile, Void>
{
  public CloudFile$9(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRangeOperationType paramFileRangeOperationType, byte[] paramArrayOfByte, long paramLong, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, FileRange paramFileRange, String paramString)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    if (val$operationType == FileRangeOperationType.UPDATE)
    {
      setSendStream(new ByteArrayInputStream(val$data));
      setLength(Long.valueOf(val$length));
    }
    return FileRequest.putRange(paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), val$options, val$opContext, val$accessCondition, val$range, val$operationType);
  }
  
  public Void preProcessResponse(CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 201)
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    paramCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
    getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
    return null;
  }
  
  public void setHeaders(HttpURLConnection paramHttpURLConnection, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    if ((val$operationType == FileRangeOperationType.UPDATE) && (val$options.getUseTransactionalContentMD5().booleanValue())) {
      paramHttpURLConnection.setRequestProperty("Content-MD5", val$md5);
    }
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (val$operationType == FileRangeOperationType.UPDATE) {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, val$length, paramOperationContext);
    } else {
      StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, 0L, paramOperationContext);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFile.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */