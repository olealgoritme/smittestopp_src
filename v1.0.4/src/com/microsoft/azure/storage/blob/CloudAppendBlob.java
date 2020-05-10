package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.Constants;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import com.microsoft.azure.storage.core.Utility;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;

public final class CloudAppendBlob
  extends CloudBlob
{
  public CloudAppendBlob(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudAppendBlob(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    this(paramStorageUri, null, paramStorageCredentials);
  }
  
  public CloudAppendBlob(StorageUri paramStorageUri, String paramString, StorageCredentials paramStorageCredentials)
  {
    super(BlobType.APPEND_BLOB, paramStorageUri, paramString, paramStorageCredentials);
  }
  
  public CloudAppendBlob(CloudAppendBlob paramCloudAppendBlob)
  {
    super(paramCloudAppendBlob);
  }
  
  public CloudAppendBlob(String paramString1, String paramString2, CloudBlobContainer paramCloudBlobContainer)
  {
    super(BlobType.APPEND_BLOB, paramString1, paramString2, paramCloudBlobContainer);
  }
  
  public CloudAppendBlob(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudAppendBlob(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  public CloudAppendBlob(URI paramURI, String paramString, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramString, paramStorageCredentials);
  }
  
  private StorageRequest<CloudBlobClient, CloudAppendBlob, Long> appendBlockImpl(String paramString, InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return new CloudAppendBlob.2(this, paramBlobRequestOptions, getStorageUri(), paramInputStream, paramLong, paramOperationContext, paramBlobRequestOptions, paramAccessCondition, paramString);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> createImpl(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudAppendBlob.1(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition);
  }
  
  private BlobOutputStream openOutputStreamInternal(boolean paramBoolean, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramOperationContext = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.APPEND_BLOB, blobServiceClient, false);
    paramOperationContext.assertPolicyIfRequired();
    paramBlobRequestOptions = null;
    if (paramOperationContext.getEncryptionPolicy() != null) {
      paramBlobRequestOptions = paramOperationContext.getEncryptionPolicy().createAndSetEncryptionContext(getMetadata(), false);
    }
    if (paramBoolean)
    {
      createOrReplace(paramAccessCondition, paramOperationContext, localOperationContext);
    }
    else
    {
      if (paramOperationContext.getStoreBlobContentMD5().booleanValue()) {
        break label198;
      }
      if (paramOperationContext.getEncryptionPolicy() != null) {
        break label188;
      }
      downloadAttributes(paramAccessCondition, paramOperationContext, localOperationContext);
    }
    AccessCondition localAccessCondition = new AccessCondition();
    if (paramAccessCondition != null)
    {
      localAccessCondition.setLeaseID(paramAccessCondition.getLeaseID());
      localAccessCondition.setIfAppendPositionEqual(paramAccessCondition.getIfAppendPositionEqual());
      localAccessCondition.setIfMaxSizeLessThanOrEqual(paramAccessCondition.getIfMaxSizeLessThanOrEqual());
    }
    if (paramOperationContext.getEncryptionPolicy() != null) {
      return new BlobEncryptStream(this, localAccessCondition, paramOperationContext, localOperationContext, paramBlobRequestOptions);
    }
    return new BlobOutputStreamInternal(this, localAccessCondition, paramOperationContext, localOperationContext);
    label188:
    throw new IllegalArgumentException("Encryption is not supported for a blob that already exists. Please do not specify an encryption policy.");
    label198:
    throw new IllegalArgumentException("MD5 cannot be calculated for an existing append blob because it would require reading the existing data. Please disable StoreFileContentMD5.");
  }
  
  private void updateCommittedBlockCountFromResponse(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-blob-committed-block-count");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      getProperties().setAppendBlobCommittedBlockCount(Integer.valueOf(Integer.parseInt(paramHttpURLConnection)));
    }
  }
  
  @DoesServiceRequest
  public void append(InputStream paramInputStream, long paramLong)
  {
    append(paramInputStream, paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void append(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.APPEND_BLOB, blobServiceClient);
    if (paramInputStream.markSupported()) {
      paramInputStream.mark(268435456);
    }
    paramAccessCondition = openWriteExisting(paramAccessCondition, paramBlobRequestOptions, localOperationContext);
    try
    {
      paramAccessCondition.write(paramInputStream, paramLong);
      return;
    }
    finally
    {
      paramAccessCondition.close();
    }
  }
  
  @DoesServiceRequest
  public Long appendBlock(InputStream paramInputStream, long paramLong)
  {
    return appendBlock(paramInputStream, paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public Long appendBlock(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramLong >= -1L)
    {
      assertNoWriteOperationForSnapshot();
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      BlobRequestOptions localBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.APPEND_BLOB, blobServiceClient);
      localBlobRequestOptions.assertNoEncryptionPolicyOrStrictMode();
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(268435456);
      }
      paramOperationContext = new StreamMd5AndLength();
      paramOperationContext.setLength(paramLong);
      if (!paramInputStream.markSupported())
      {
        paramBlobRequestOptions = new ByteArrayOutputStream();
        paramOperationContext = Utility.writeToOutputStream(paramInputStream, paramBlobRequestOptions, paramLong, false, localBlobRequestOptions.getUseTransactionalContentMD5().booleanValue(), localOperationContext, localBlobRequestOptions);
        paramBlobRequestOptions = new ByteArrayInputStream(paramBlobRequestOptions.toByteArray());
      }
      do
      {
        paramInputStream = paramBlobRequestOptions;
        break label178;
        if (paramLong < 0L) {
          break;
        }
        paramBlobRequestOptions = paramInputStream;
      } while (!localBlobRequestOptions.getUseTransactionalContentMD5().booleanValue());
      boolean bool = localBlobRequestOptions.getUseTransactionalContentMD5().booleanValue();
      paramOperationContext = Utility.analyzeStream(paramInputStream, paramLong, -1L, true, bool);
      label178:
      if (paramOperationContext.getLength() <= 4194304L)
      {
        paramInputStream = appendBlockImpl(paramOperationContext.getMd5(), paramInputStream, paramOperationContext.getLength(), paramAccessCondition, localBlobRequestOptions, localOperationContext);
        return (Long)ExecutionEngine.executeWithRetry(blobServiceClient, this, paramInputStream, localBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
      }
      throw new IllegalArgumentException("Invalid stream length, length must be less than or equal to 4 MB in size.");
    }
    throw new IllegalArgumentException("Invalid stream length, specify -1 for unknown length stream, or a positive number of bytes.");
  }
  
  public void appendFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    appendFromByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, null);
  }
  
  public void appendFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2);
    append(paramArrayOfByte, paramInt2, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    paramArrayOfByte.close();
  }
  
  public void appendFromFile(String paramString)
  {
    appendFromFile(paramString, null, null, null);
  }
  
  public void appendFromFile(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramString = new File(paramString);
    long l = paramString.length();
    paramString = new BufferedInputStream(new FileInputStream(paramString));
    append(paramString, l, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    paramString.close();
  }
  
  public void appendText(String paramString)
  {
    appendText(paramString, null, null, null, null);
  }
  
  public void appendText(String paramString1, String paramString2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramString2 == null) {
      paramString1 = paramString1.getBytes();
    } else {
      paramString1 = paramString1.getBytes(paramString2);
    }
    appendFromByteArray(paramString1, 0, paramString1.length, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void createOrReplace()
  {
    createOrReplace(null, null, null);
  }
  
  @DoesServiceRequest
  public void createOrReplace(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.APPEND_BLOB, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, createImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteExisting()
  {
    return openWriteExisting(null, null, null);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteExisting(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(false, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteNew()
  {
    return openWriteNew(null, null, null);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteNew(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(true, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  public void setStreamWriteSizeInBytes(int paramInt)
  {
    if ((paramInt <= Constants.MAX_APPEND_BLOCK_SIZE) && (paramInt >= 16384))
    {
      streamWriteSizeInBytes = paramInt;
      return;
    }
    throw new IllegalArgumentException("StreamWriteSizeInBytes");
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudAppendBlob paramCloudAppendBlob)
  {
    return startCopy(paramCloudAppendBlob, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudAppendBlob paramCloudAppendBlob, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceBlob", paramCloudAppendBlob);
    URI localURI1 = paramCloudAppendBlob.getSnapshotQualifiedUri();
    URI localURI2 = localURI1;
    if (paramCloudAppendBlob.getServiceClient() != null)
    {
      localURI2 = localURI1;
      if (paramCloudAppendBlob.getServiceClient().getCredentials() != null) {
        localURI2 = paramCloudAppendBlob.getServiceClient().getCredentials().transformUri(paramCloudAppendBlob.getSnapshotQualifiedUri());
      }
    }
    return startCopy(localURI2, null, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong)
  {
    upload(paramInputStream, paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.APPEND_BLOB, blobServiceClient);
    if (paramInputStream.markSupported()) {
      paramInputStream.mark(268435456);
    }
    paramAccessCondition = openWriteNew(paramAccessCondition, paramBlobRequestOptions, localOperationContext);
    try
    {
      paramAccessCondition.write(paramInputStream, paramLong);
      return;
    }
    finally
    {
      paramAccessCondition.close();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudAppendBlob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */