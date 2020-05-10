package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageCredentialsHelper;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.core.WrappedByteArrayOutputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public abstract class CloudBlob
  implements ListBlobItem
{
  public CloudBlobClient blobServiceClient;
  public CloudBlobContainer container;
  public boolean deleted;
  public HashMap<String, String> metadata = new HashMap();
  public String name;
  public CloudBlobDirectory parent;
  public BlobProperties properties;
  public String snapshotID;
  public StorageUri storageUri;
  public int streamMinimumReadSizeInBytes = 4194304;
  public int streamWriteSizeInBytes = 4194304;
  
  public CloudBlob(BlobType paramBlobType, StorageUri paramStorageUri, String paramString, StorageCredentials paramStorageCredentials)
  {
    properties = new BlobProperties(paramBlobType);
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
    if (paramString != null) {
      if (snapshotID == null) {
        snapshotID = paramString;
      } else {
        throw new IllegalArgumentException("Snapshot query parameter is already defined in the blob URI. Either pass in a snapshotTime parameter or use a full URL with a snapshot query parameter.");
      }
    }
  }
  
  public CloudBlob(BlobType paramBlobType, String paramString1, String paramString2, CloudBlobContainer paramCloudBlobContainer)
  {
    Utility.assertNotNullOrEmpty("blobName", paramString1);
    Utility.assertNotNull("container", paramCloudBlobContainer);
    storageUri = PathUtility.appendPathToUri(paramCloudBlobContainer.getStorageUri(), paramString1);
    name = paramString1;
    blobServiceClient = paramCloudBlobContainer.getServiceClient();
    container = paramCloudBlobContainer;
    snapshotID = paramString2;
    properties = new BlobProperties(paramBlobType);
  }
  
  public CloudBlob(CloudBlob paramCloudBlob)
  {
    properties = new BlobProperties(properties);
    if (metadata != null)
    {
      metadata = new HashMap();
      Iterator localIterator = metadata.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        metadata.put(str, metadata.get(str));
      }
    }
    snapshotID = snapshotID;
    storageUri = storageUri;
    container = container;
    parent = parent;
    blobServiceClient = blobServiceClient;
    name = name;
    setStreamMinimumReadSizeInBytes(paramCloudBlob.getStreamMinimumReadSizeInBytes());
    setStreamWriteSizeInBytes(paramCloudBlob.getStreamWriteSizeInBytes());
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> abortCopyImpl(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    Utility.assertNotNull("copyId", paramString);
    return new CloudBlob.1(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition, paramString);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, String> acquireLeaseImpl(Integer paramInteger, String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.2(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition, paramInteger, paramString);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Long> breakLeaseImpl(Integer paramInteger, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.3(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition, paramInteger);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, String> changeLeaseImpl(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.4(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition, paramString);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, CloudBlob> createSnapshotImpl(HashMap<String, String> paramHashMap, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.6(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition, paramHashMap);
  }
  
  private void deleteEmptyFileOnException(OutputStream paramOutputStream, String paramString)
  {
    try
    {
      paramOutputStream.close();
      paramOutputStream = new java/io/File;
      paramOutputStream.<init>(paramString);
      paramOutputStream.delete();
      return;
    }
    catch (Exception paramOutputStream)
    {
      for (;;) {}
    }
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> deleteImpl(DeleteSnapshotsOption paramDeleteSnapshotsOption, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.7(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition, paramDeleteSnapshotsOption);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> downloadAttributesImpl(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.9(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition);
  }
  
  @DoesServiceRequest
  private final StorageRequest<CloudBlobClient, CloudBlob, Integer> downloadToStreamImpl(Long paramLong1, Long paramLong2, OutputStream paramOutputStream, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    paramBlobRequestOptions.assertPolicyIfRequired();
    long l1;
    if (paramLong1 == null) {
      l1 = 0L;
    } else {
      l1 = paramLong1.longValue();
    }
    boolean bool1 = true;
    boolean bool2;
    if (paramLong1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Long localLong1 = null;
    int i;
    Long localLong2;
    if ((bool2) && (paramBlobRequestOptions.getEncryptionPolicy() != null))
    {
      if (paramLong2 != null)
      {
        long l2 = paramLong1.longValue();
        localLong1 = Long.valueOf(paramLong2.longValue() + l2 - 1L);
        l2 = localLong1.longValue();
        localLong1 = Long.valueOf(15L - localLong1.longValue() % 16L + l2);
      }
      i = (int)(paramLong1.longValue() % 16L);
      paramLong1 = Long.valueOf(paramLong1.longValue() - i);
      if (paramLong1.longValue() > 15L) {
        paramLong1 = Long.valueOf(paramLong1.longValue() - 16L);
      } else {
        bool1 = false;
      }
      if (localLong1 != null) {
        localLong2 = Long.valueOf(localLong1.longValue() - paramLong1.longValue() + 1L);
      } else {
        localLong2 = paramLong2;
      }
    }
    else
    {
      localLong2 = paramLong2;
      localLong1 = null;
      i = 0;
      bool1 = false;
    }
    return new CloudBlob.10(this, paramBlobRequestOptions, getStorageUri(), paramLong1, localLong2, paramAccessCondition, paramBlobRequestOptions, paramOutputStream, bool2, localLong1, paramLong2, i, bool1, l1);
  }
  
  @DoesServiceRequest
  private final boolean exists(boolean paramBoolean, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return ((Boolean)ExecutionEngine.executeWithRetry(blobServiceClient, this, existsImpl(paramBoolean, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext)).booleanValue();
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Boolean> existsImpl(boolean paramBoolean, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.11(this, paramBlobRequestOptions, getStorageUri(), paramBoolean, paramBlobRequestOptions, paramAccessCondition);
  }
  
  public static String getParentNameFromURI(StorageUri paramStorageUri, String paramString, CloudBlobContainer paramCloudBlobContainer)
  {
    Utility.assertNotNull("resourceAddress", paramStorageUri);
    Utility.assertNotNull("container", paramCloudBlobContainer);
    Utility.assertNotNullOrEmpty("delimiter", paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCloudBlobContainer.getName());
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    paramCloudBlobContainer = Utility.safeRelativize(paramCloudBlobContainer.getStorageUri().getPrimaryUri(), paramStorageUri.getPrimaryUri());
    paramStorageUri = paramCloudBlobContainer;
    if (paramCloudBlobContainer.endsWith(paramString)) {
      paramStorageUri = paramCloudBlobContainer.substring(0, paramCloudBlobContainer.length() - paramString.length());
    }
    boolean bool = Utility.isNullOrEmpty(paramStorageUri);
    paramCloudBlobContainer = "";
    if (bool)
    {
      paramStorageUri = null;
    }
    else
    {
      int i = paramStorageUri.lastIndexOf(paramString);
      if (i < 0)
      {
        paramStorageUri = paramCloudBlobContainer;
      }
      else
      {
        paramStorageUri = paramStorageUri.substring(0, paramString.length() + i);
        if ((paramStorageUri != null) && (paramStorageUri.equals(localObject))) {
          paramStorageUri = paramCloudBlobContainer;
        }
      }
    }
    return paramStorageUri;
  }
  
  private void parseQueryAndVerify(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("completeUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      storageUri = PathUtility.stripURIQueryAndFragment(paramStorageUri);
      paramStorageUri = PathUtility.parseQueryString(paramStorageUri.getQuery());
      Object localObject = (String[])paramStorageUri.get("snapshot");
      if ((localObject != null) && (localObject.length > 0)) {
        snapshotID = localObject[0];
      }
      paramStorageUri = SharedAccessSignatureHelper.parseQuery(paramStorageUri);
      if ((paramStorageCredentials != null) && (paramStorageUri != null)) {
        throw new IllegalArgumentException("Cannot provide credentials as part of the address and as constructor parameter. Either pass in the address or use a different constructor.");
      }
      try
      {
        boolean bool = Utility.determinePathStyleFromUri(storageUri.getPrimaryUri());
        localObject = new com/microsoft/azure/storage/blob/CloudBlobClient;
        StorageUri localStorageUri = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials == null) {
          paramStorageCredentials = paramStorageUri;
        }
        ((CloudBlobClient)localObject).<init>(localStorageUri, paramStorageCredentials);
        blobServiceClient = ((CloudBlobClient)localObject);
        name = PathUtility.getBlobNameFromURI(storageUri.getPrimaryUri(), bool);
        return;
      }
      catch (URISyntaxException paramStorageUri)
      {
        throw Utility.generateNewUnexpectedStorageException(paramStorageUri);
      }
    }
    throw new IllegalArgumentException(String.format("Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramStorageUri.toString() }));
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> releaseLeaseImpl(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.12(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> renewLeaseImpl(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.13(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> undeleteImpl(BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.8(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> uploadMetadataImpl(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.15(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> uploadPropertiesImpl(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.16(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition);
  }
  
  @DoesServiceRequest
  public final void abortCopy(String paramString)
  {
    abortCopy(paramString, null, null, null);
  }
  
  @DoesServiceRequest
  public final void abortCopy(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, abortCopyImpl(paramString, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final String acquireLease()
  {
    return acquireLease(null, null);
  }
  
  @DoesServiceRequest
  public final String acquireLease(Integer paramInteger, String paramString)
  {
    return acquireLease(paramInteger, paramString, null, null, null);
  }
  
  @DoesServiceRequest
  public final String acquireLease(Integer paramInteger, String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return (String)ExecutionEngine.executeWithRetry(blobServiceClient, this, acquireLeaseImpl(paramInteger, paramString, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public final void assertCorrectBlobType()
  {
    if (((this instanceof CloudBlockBlob)) && (properties.getBlobType() != BlobType.BLOCK_BLOB)) {
      throw new StorageException("IncorrectBlobType", String.format("Incorrect Blob type, please use the correct Blob type to access a blob on the server. Expected %s, actual %s.", new Object[] { BlobType.BLOCK_BLOB, properties.getBlobType() }), 306, null, null);
    }
    if (((this instanceof CloudPageBlob)) && (properties.getBlobType() != BlobType.PAGE_BLOB)) {
      throw new StorageException("IncorrectBlobType", String.format("Incorrect Blob type, please use the correct Blob type to access a blob on the server. Expected %s, actual %s.", new Object[] { BlobType.PAGE_BLOB, properties.getBlobType() }), 306, null, null);
    }
    if (((this instanceof CloudAppendBlob)) && (properties.getBlobType() != BlobType.APPEND_BLOB)) {
      throw new StorageException("IncorrectBlobType", String.format("Incorrect Blob type, please use the correct Blob type to access a blob on the server. Expected %s, actual %s.", new Object[] { BlobType.APPEND_BLOB, properties.getBlobType() }), 306, null, null);
    }
  }
  
  public void assertNoWriteOperationForSnapshot()
  {
    if (!isSnapshot()) {
      return;
    }
    throw new IllegalArgumentException("Cannot perform this operation on a blob representing a snapshot.");
  }
  
  @DoesServiceRequest
  public final long breakLease(Integer paramInteger)
  {
    return breakLease(paramInteger, null, null, null);
  }
  
  @DoesServiceRequest
  public final long breakLease(Integer paramInteger, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    if (paramInteger != null) {
      Utility.assertGreaterThanOrEqual("breakPeriodInSeconds", paramInteger.intValue(), 0L);
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return ((Long)ExecutionEngine.executeWithRetry(blobServiceClient, this, breakLeaseImpl(paramInteger, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext)).longValue();
  }
  
  @DoesServiceRequest
  public final String changeLease(String paramString, AccessCondition paramAccessCondition)
  {
    return changeLease(paramString, paramAccessCondition, null, null);
  }
  
  @DoesServiceRequest
  public final String changeLease(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("accessCondition", paramAccessCondition);
    Utility.assertNotNullOrEmpty("leaseID", paramAccessCondition.getLeaseID());
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return (String)ExecutionEngine.executeWithRetry(blobServiceClient, this, changeLeaseImpl(paramString, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final CloudBlob createSnapshot()
  {
    return createSnapshot(null, null, null, null);
  }
  
  @DoesServiceRequest
  public final CloudBlob createSnapshot(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return createSnapshot(null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final CloudBlob createSnapshot(HashMap<String, String> paramHashMap, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return (CloudBlob)ExecutionEngine.executeWithRetry(blobServiceClient, this, createSnapshotImpl(paramHashMap, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void delete()
  {
    delete(DeleteSnapshotsOption.NONE, null, null, null);
  }
  
  @DoesServiceRequest
  public final void delete(DeleteSnapshotsOption paramDeleteSnapshotsOption, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("deleteSnapshotsOption", paramDeleteSnapshotsOption);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, deleteImpl(paramDeleteSnapshotsOption, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final boolean deleteIfExists()
  {
    return deleteIfExists(DeleteSnapshotsOption.NONE, null, null, null);
  }
  
  @DoesServiceRequest
  public final boolean deleteIfExists(DeleteSnapshotsOption paramDeleteSnapshotsOption, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    if (exists(true, paramAccessCondition, paramBlobRequestOptions, paramOperationContext)) {
      try
      {
        delete(paramDeleteSnapshotsOption, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramDeleteSnapshotsOption)
      {
        if ((paramDeleteSnapshotsOption.getHttpStatusCode() == 404) && ("BlobNotFound".equals(paramDeleteSnapshotsOption.getErrorCode()))) {
          return false;
        }
        throw paramDeleteSnapshotsOption;
      }
    }
    return false;
  }
  
  @DoesServiceRequest
  public final void download(OutputStream paramOutputStream)
  {
    download(paramOutputStream, null, null, null);
  }
  
  @DoesServiceRequest
  public final void download(OutputStream paramOutputStream, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadToStreamImpl(null, null, paramOutputStream, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public AccountInformation downloadAccountInfo()
  {
    return downloadAccountInfo(null, null);
  }
  
  @DoesServiceRequest
  public AccountInformation downloadAccountInfo(BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    return (AccountInformation)ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadAccountInformationImpl(paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public StorageRequest<ServiceClient, CloudBlob, AccountInformation> downloadAccountInformationImpl(RequestOptions paramRequestOptions)
  {
    return new CloudBlob.17(this, paramRequestOptions, getStorageUri(), paramRequestOptions);
  }
  
  @DoesServiceRequest
  public final void downloadAttributes()
  {
    downloadAttributes(null, null, null);
  }
  
  @DoesServiceRequest
  public final void downloadAttributes(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadAttributesImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void downloadRange(long paramLong, Long paramLong1, OutputStream paramOutputStream)
  {
    downloadRange(paramLong, paramLong1, paramOutputStream, null, null, null);
  }
  
  @DoesServiceRequest
  public final void downloadRange(long paramLong, Long paramLong1, OutputStream paramOutputStream, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if ((paramLong >= 0L) && ((paramLong1 == null) || (paramLong1.longValue() > 0L)))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
      if ((paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (paramLong1 != null) && (paramLong1.longValue() > 4194304L)) {
        throw new IllegalArgumentException("Cannot specify x-ms-range-get-content-md5 header on ranges larger than 4 MB. Either use a BlobReadStream via openRead, or disable TransactionalMD5 via the BlobRequestOptions.");
      }
      ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadToStreamImpl(Long.valueOf(paramLong), paramLong1, paramOutputStream, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  @DoesServiceRequest
  public final int downloadRangeInternal(long paramLong, Long paramLong1, byte[] paramArrayOfByte, int paramInt, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if ((paramInt >= 0) && (paramLong >= 0L) && ((paramLong1 == null) || (paramLong1.longValue() > 0L)))
    {
      if (paramOperationContext == null) {
        paramOperationContext = new OperationContext();
      }
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
      if ((paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (paramLong1 != null) && (paramLong1.longValue() > 4194304L)) {
        throw new IllegalArgumentException("Cannot specify x-ms-range-get-content-md5 header on ranges larger than 4 MB. Either use a BlobReadStream via openRead, or disable TransactionalMD5 via the BlobRequestOptions.");
      }
      paramArrayOfByte = new WrappedByteArrayOutputStream(paramArrayOfByte, paramInt);
      ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadToStreamImpl(Long.valueOf(paramLong), paramLong1, paramArrayOfByte, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
      return paramArrayOfByte.getPosition();
    }
    throw new IndexOutOfBoundsException();
  }
  
  @DoesServiceRequest
  public final int downloadRangeToByteArray(long paramLong, Long paramLong1, byte[] paramArrayOfByte, int paramInt)
  {
    return downloadRangeToByteArray(paramLong, paramLong1, paramArrayOfByte, paramInt, null, null, null);
  }
  
  @DoesServiceRequest
  public final int downloadRangeToByteArray(long paramLong, Long paramLong1, byte[] paramArrayOfByte, int paramInt, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("buffer", paramArrayOfByte);
    if ((paramLong1 != null) && (paramLong1.longValue() + paramInt > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    return downloadRangeInternal(paramLong, paramLong1, paramArrayOfByte, paramInt, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final int downloadToByteArray(byte[] paramArrayOfByte, int paramInt)
  {
    return downloadToByteArray(paramArrayOfByte, paramInt, null, null, null);
  }
  
  @DoesServiceRequest
  public final int downloadToByteArray(byte[] paramArrayOfByte, int paramInt, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("buffer", paramArrayOfByte);
    if (paramInt >= 0)
    {
      if (paramInt < paramArrayOfByte.length)
      {
        OperationContext localOperationContext = paramOperationContext;
        if (paramOperationContext == null) {
          localOperationContext = new OperationContext();
        }
        localOperationContext.initialize();
        paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
        paramArrayOfByte = new WrappedByteArrayOutputStream(paramArrayOfByte, paramInt);
        ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadToStreamImpl(null, null, paramArrayOfByte, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
        return paramArrayOfByte.getPosition();
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IndexOutOfBoundsException();
  }
  
  public void downloadToFile(String paramString)
  {
    downloadToFile(paramString, null, null, null);
  }
  
  public void downloadToFile(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramString));
    try
    {
      download(localBufferedOutputStream, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
      localBufferedOutputStream.close();
      return;
    }
    catch (IOException paramAccessCondition)
    {
      deleteEmptyFileOnException(localBufferedOutputStream, paramString);
      throw paramAccessCondition;
    }
    catch (StorageException paramAccessCondition)
    {
      deleteEmptyFileOnException(localBufferedOutputStream, paramString);
      throw paramAccessCondition;
    }
  }
  
  @DoesServiceRequest
  public final boolean exists()
  {
    return exists(null, null, null);
  }
  
  @DoesServiceRequest
  public final boolean exists(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return exists(false, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  public String generateSharedAccessSignature(SharedAccessBlobPolicy paramSharedAccessBlobPolicy, SharedAccessBlobHeaders paramSharedAccessBlobHeaders, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessBlobPolicy, paramSharedAccessBlobHeaders, paramString, null, null);
  }
  
  public String generateSharedAccessSignature(SharedAccessBlobPolicy paramSharedAccessBlobPolicy, SharedAccessBlobHeaders paramSharedAccessBlobHeaders, String paramString, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(blobServiceClient.getCredentials()))
    {
      if (!isSnapshot()) {
        return SharedAccessSignatureHelper.generateSharedAccessSignatureForBlobAndFile(paramSharedAccessBlobPolicy, paramSharedAccessBlobHeaders, paramString, "b", paramIPRange, paramSharedAccessProtocols, SharedAccessSignatureHelper.generateSharedAccessSignatureHashForBlobAndFile(paramSharedAccessBlobPolicy, paramSharedAccessBlobHeaders, paramString, getCanonicalName(true), paramIPRange, paramSharedAccessProtocols, blobServiceClient)).toString();
      }
      throw new IllegalArgumentException("Cannot create Shared Access Signature via references to blob snapshots. Please perform the given operation on the root blob instead.");
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public String generateSharedAccessSignature(SharedAccessBlobPolicy paramSharedAccessBlobPolicy, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessBlobPolicy, null, paramString);
  }
  
  public String getCanonicalName(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("/");
    localStringBuilder.append("blob");
    if (blobServiceClient.isUsePathStyleUris()) {
      localStringBuilder.append(getUri().getRawPath());
    } else {
      localStringBuilder.append(PathUtility.getCanonicalPathFromCredentials(blobServiceClient.getCredentials(), getUri().getRawPath()));
    }
    if ((!paramBoolean) && (snapshotID != null))
    {
      localStringBuilder.append("?snapshot=");
      localStringBuilder.append(snapshotID);
    }
    return localStringBuilder.toString();
  }
  
  public final CloudBlobContainer getContainer()
  {
    if (container == null) {
      container = new CloudBlobContainer(PathUtility.getContainerURI(getStorageUri(), blobServiceClient.isUsePathStyleUris()), blobServiceClient.getCredentials());
    }
    return container;
  }
  
  public CopyState getCopyState()
  {
    return properties.getCopyState();
  }
  
  public final HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public final String getName()
  {
    return name;
  }
  
  public final CloudBlobDirectory getParent()
  {
    if (parent == null)
    {
      String str = getParentNameFromURI(getStorageUri(), blobServiceClient.getDirectoryDelimiter(), getContainer());
      if (str != null) {
        parent = new CloudBlobDirectory(PathUtility.appendPathToUri(container.getStorageUri(), str), str, blobServiceClient, getContainer());
      }
    }
    return parent;
  }
  
  public final BlobProperties getProperties()
  {
    return properties;
  }
  
  @Deprecated
  public final StorageUri getQualifiedStorageUri()
  {
    if (isSnapshot())
    {
      StorageUri localStorageUri = PathUtility.addToQuery(getStorageUri(), String.format("snapshot=%s", new Object[] { snapshotID }));
      return blobServiceClient.getCredentials().transformUri(localStorageUri);
    }
    return blobServiceClient.getCredentials().transformUri(getStorageUri());
  }
  
  @Deprecated
  public final URI getQualifiedUri()
  {
    if (isSnapshot()) {
      return PathUtility.addToQuery(getUri(), String.format("snapshot=%s", new Object[] { snapshotID }));
    }
    return blobServiceClient.getCredentials().transformUri(getUri());
  }
  
  public final CloudBlobClient getServiceClient()
  {
    return blobServiceClient;
  }
  
  public final String getSnapshotID()
  {
    return snapshotID;
  }
  
  public final StorageUri getSnapshotQualifiedStorageUri()
  {
    if (isSnapshot()) {
      return PathUtility.addToQuery(getStorageUri(), String.format("snapshot=%s", new Object[] { snapshotID }));
    }
    return getStorageUri();
  }
  
  public final URI getSnapshotQualifiedUri()
  {
    if (isSnapshot()) {
      return PathUtility.addToQuery(getUri(), String.format("snapshot=%s", new Object[] { snapshotID }));
    }
    return getUri();
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public final int getStreamMinimumReadSizeInBytes()
  {
    return streamMinimumReadSizeInBytes;
  }
  
  public final int getStreamWriteSizeInBytes()
  {
    return streamWriteSizeInBytes;
  }
  
  public final StorageUri getTransformedAddress(OperationContext paramOperationContext)
  {
    return blobServiceClient.getCredentials().transformUri(getStorageUri(), paramOperationContext);
  }
  
  public final URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  public final boolean isSnapshot()
  {
    boolean bool;
    if (snapshotID != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @DoesServiceRequest
  public final BlobInputStream openInputStream()
  {
    return openInputStream(0L, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final BlobInputStream openInputStream(long paramLong, Long paramLong1, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if ((paramLong >= 0L) && ((paramLong1 == null) || (paramLong1.longValue() > 0L)))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      return new BlobInputStream(paramLong, paramLong1, this, paramAccessCondition, BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient, false), localOperationContext);
    }
    throw new IndexOutOfBoundsException();
  }
  
  @DoesServiceRequest
  public final BlobInputStream openInputStream(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return openInputStream(0L, null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final void releaseLease(AccessCondition paramAccessCondition)
  {
    releaseLease(paramAccessCondition, null, null);
  }
  
  @DoesServiceRequest
  public final void releaseLease(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("accessCondition", paramAccessCondition);
    Utility.assertNotNullOrEmpty("leaseID", paramAccessCondition.getLeaseID());
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, releaseLeaseImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void renewLease(AccessCondition paramAccessCondition)
  {
    renewLease(paramAccessCondition, null, null);
  }
  
  @DoesServiceRequest
  public final void renewLease(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("accessCondition", paramAccessCondition);
    Utility.assertNotNullOrEmpty("leaseID", paramAccessCondition.getLeaseID());
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, renewLeaseImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public final void setContainer(CloudBlobContainer paramCloudBlobContainer)
  {
    container = paramCloudBlobContainer;
  }
  
  public final void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public final void setProperties(BlobProperties paramBlobProperties)
  {
    properties = paramBlobProperties;
  }
  
  public final void setSnapshotID(String paramString)
  {
    snapshotID = paramString;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
  
  public void setStreamMinimumReadSizeInBytes(int paramInt)
  {
    if (paramInt >= 16384)
    {
      streamMinimumReadSizeInBytes = paramInt;
      return;
    }
    throw new IllegalArgumentException("MinimumReadSize");
  }
  
  public abstract void setStreamWriteSizeInBytes(int paramInt);
  
  @DoesServiceRequest
  public final String startCopy(URI paramURI)
  {
    return startCopy(paramURI, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(URI paramURI, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return startCopy(paramURI, null, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(URI paramURI, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return startCopy(paramURI, null, false, paramPremiumPageBlobTier, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(URI paramURI, String paramString, boolean paramBoolean, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return (String)ExecutionEngine.executeWithRetry(blobServiceClient, this, startCopyImpl(paramURI, paramString, paramBoolean, false, paramPremiumPageBlobTier, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  public StorageRequest<CloudBlobClient, CloudBlob, String> startCopyImpl(URI paramURI, String paramString, boolean paramBoolean1, boolean paramBoolean2, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.5(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramAccessCondition1, paramAccessCondition2, paramURI, paramBoolean2, paramBoolean1, paramString, paramPremiumPageBlobTier);
  }
  
  @DoesServiceRequest
  public final void undelete()
  {
    undelete(null, null);
  }
  
  @DoesServiceRequest
  public final void undelete(BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, undeleteImpl(paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public void updateEtagAndLastModifiedFromResponse(HttpURLConnection paramHttpURLConnection)
  {
    getProperties().setEtag(paramHttpURLConnection.getHeaderField("ETag"));
    if (0L != paramHttpURLConnection.getLastModified())
    {
      Calendar localCalendar = Calendar.getInstance(Utility.LOCALE_US);
      localCalendar.setTimeZone(Utility.UTC_ZONE);
      localCalendar.setTime(new Date(paramHttpURLConnection.getLastModified()));
      getProperties().setLastModified(localCalendar.getTime());
    }
  }
  
  public void updateLengthFromResponse(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-blob-content-length");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      getProperties().setLength(Long.parseLong(paramHttpURLConnection));
    }
  }
  
  @DoesServiceRequest
  public abstract void upload(InputStream paramInputStream, long paramLong);
  
  @DoesServiceRequest
  public abstract void upload(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext);
  
  public StorageRequest<CloudBlobClient, CloudBlob, Void> uploadBlobTierImpl(String paramString, BlobRequestOptions paramBlobRequestOptions)
  {
    return new CloudBlob.14(this, paramBlobRequestOptions, getStorageUri(), paramBlobRequestOptions, paramString);
  }
  
  public void uploadFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    uploadFromByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, null);
  }
  
  public void uploadFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2);
    upload(paramArrayOfByte, paramInt2, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    paramArrayOfByte.close();
  }
  
  public void uploadFromFile(String paramString)
  {
    uploadFromFile(paramString, null, null, null);
  }
  
  public void uploadFromFile(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramString = new File(paramString);
    long l = paramString.length();
    paramString = new FileInputStream(paramString);
    upload(paramString, l, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    paramString.close();
  }
  
  @DoesServiceRequest
  public final void uploadMetadata()
  {
    uploadMetadata(null, null, null);
  }
  
  @DoesServiceRequest
  public final void uploadMetadata(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadMetadataImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void uploadProperties()
  {
    uploadProperties(null, null, null);
  }
  
  @DoesServiceRequest
  public final void uploadProperties(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadPropertiesImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */