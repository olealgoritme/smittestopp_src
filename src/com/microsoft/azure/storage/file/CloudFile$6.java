package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageErrorCode;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageLocation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.Logger;
import com.microsoft.azure.storage.core.NetworkInputStream;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import com.microsoft.azure.storage.core.Utility;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;

public class CloudFile$6
  extends StorageRequest<CloudFileClient, CloudFile, Integer>
{
  public CloudFile$6(CloudFile paramCloudFile, RequestOptions paramRequestOptions, StorageUri paramStorageUri, Long paramLong1, Long paramLong2, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition, OutputStream paramOutputStream, long paramLong)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFile paramCloudFile, OperationContext paramOperationContext)
  {
    if (getOffset() == null) {
      setOffset(val$fileOffset);
    }
    if (getLength() == null) {
      setLength(val$length);
    }
    URI localURI = paramCloudFile.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation());
    FileRequestOptions localFileRequestOptions = val$options;
    paramCloudFileClient = val$accessCondition;
    String str = getSharesnapshotID;
    paramCloudFile = getOffset();
    Long localLong = getLength();
    boolean bool;
    if ((val$options.getUseTransactionalContentMD5().booleanValue()) && (!getArePropertiesPopulated())) {
      bool = true;
    } else {
      bool = false;
    }
    return FileRequest.getFile(localURI, localFileRequestOptions, paramOperationContext, paramCloudFileClient, str, paramCloudFile, localLong, bool);
  }
  
  public Integer postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext, Integer paramInteger)
  {
    boolean bool;
    if ((!val$options.getDisableContentMD5Validation().booleanValue()) && (!Utility.isNullOrEmpty(getContentMD5()))) {
      bool = true;
    } else {
      bool = false;
    }
    paramCloudFile = Boolean.valueOf(bool);
    long l = Long.parseLong(paramHttpURLConnection.getHeaderField("Content-Length"));
    Logger.info(paramOperationContext, String.format("Creating a NetworkInputStream and expecting to read %s bytes.", new Object[] { Long.valueOf(l) }));
    paramHttpURLConnection = new NetworkInputStream(paramHttpURLConnection.getInputStream(), l);
    try
    {
      paramCloudFileClient = Utility.writeToOutputStream(paramHttpURLConnection, val$outStream, -1L, false, paramCloudFile.booleanValue(), paramOperationContext, val$options, Boolean.valueOf(true), this, getCurrentDescriptor());
      if ((paramCloudFile.booleanValue()) && (!getContentMD5().equals(paramCloudFileClient.getMd5())))
      {
        paramCloudFile = new com/microsoft/azure/storage/StorageException;
        paramCloudFile.<init>("InvalidMd5", String.format("File hash mismatch (integrity check failed), Expected value is %s, retrieved %s.", new Object[] { getContentMD5(), paramCloudFileClient.getMd5() }), 306, null, null);
        throw paramCloudFile;
      }
      return null;
    }
    finally
    {
      paramHttpURLConnection.close();
    }
  }
  
  public Integer preProcessResponse(CloudFile paramCloudFile, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if ((getResult().getStatusCode() != 206) && (getResult().getStatusCode() != 200))
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    if (!getArePropertiesPopulated())
    {
      paramCloudFileClient = FileResponse.getFileAttributes(getConnection(), paramCloudFile.getStorageUri());
      CloudFile.access$102(paramCloudFile, paramCloudFileClient.getProperties());
      CloudFile.access$002(paramCloudFile, paramCloudFileClient.getMetadata());
      setContentMD5(getConnection().getHeaderField("Content-MD5"));
      if ((!val$options.getDisableContentMD5Validation().booleanValue()) && (val$options.getUseTransactionalContentMD5().booleanValue()) && (Utility.isNullOrEmpty(getContentMD5()))) {
        throw new StorageException("MissingContentMD5Header", "ContentMD5 header is missing in the response.", 306, null, null);
      }
      setLockedETag(CloudFile.access$100(paramCloudFile).getEtag());
      setArePropertiesPopulated(true);
    }
    else if ((getLockedETag() != null) && (!getLockedETag().equals(CloudFile.access$100(paramCloudFile).getEtag())))
    {
      paramCloudFile = StorageErrorCode.CONDITION_FAILED;
      throw new StorageException("CONDITION_FAILED", "The conditionals specified for this operation did not match server.", 412, null, null);
    }
    if (getResult().getTargetLocation() == StorageLocation.PRIMARY) {
      paramCloudFile = RequestLocationMode.PRIMARY_ONLY;
    } else {
      paramCloudFile = RequestLocationMode.SECONDARY_ONLY;
    }
    setRequestLocationMode(paramCloudFile);
    return null;
  }
  
  public void recoveryAction(OperationContext paramOperationContext)
  {
    if ((getETagLockCondition() == null) && (!Utility.isNullOrEmpty(getLockedETag())))
    {
      AccessCondition localAccessCondition = new AccessCondition();
      localAccessCondition.setIfMatch(getLockedETag());
      paramOperationContext = val$accessCondition;
      if (paramOperationContext != null) {
        localAccessCondition.setLeaseID(paramOperationContext.getLeaseID());
      }
      setETagLockCondition(localAccessCondition);
    }
    if (getCurrentRequestByteCount() > 0L)
    {
      long l = val$startingOffset;
      setOffset(Long.valueOf(getCurrentRequestByteCount() + l));
      paramOperationContext = val$length;
      if (paramOperationContext != null) {
        setLength(Long.valueOf(paramOperationContext.longValue() - getCurrentRequestByteCount()));
      }
    }
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
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFile.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */