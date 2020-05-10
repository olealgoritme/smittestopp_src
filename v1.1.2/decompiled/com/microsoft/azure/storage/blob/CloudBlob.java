package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageLocation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.RequestLocationMode;
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
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> abortCopyImpl(final String paramString, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    Utility.assertNotNull("copyId", paramString);
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.abortCopy(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, paramString);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 202) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, String> acquireLeaseImpl(final Integer paramInteger, final String paramString, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.ACQUIRE, paramInteger, paramString, null);
      }
      
      public String preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        updateEtagAndLastModifiedFromResponse(getConnection());
        properties.setLeaseStatus(LeaseStatus.LOCKED);
        return BlobResponse.getLeaseID(getConnection());
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Long> breakLeaseImpl(final Integer paramInteger, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.BREAK, null, null, paramInteger);
      }
      
      public Long preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        int i = getResult().getStatusCode();
        long l = -1L;
        if (i != 202)
        {
          setNonExceptionedRetryableFailure(true);
          return Long.valueOf(-1L);
        }
        updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudBlobClient = BlobResponse.getLeaseTime(getConnection());
        properties.setLeaseStatus(LeaseStatus.UNLOCKED);
        if (!Utility.isNullOrEmpty(paramAnonymousCloudBlobClient)) {
          l = Long.parseLong(paramAnonymousCloudBlobClient);
        }
        return Long.valueOf(l);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, String> changeLeaseImpl(final String paramString, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.CHANGE, null, paramString, null);
      }
      
      public String preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        updateEtagAndLastModifiedFromResponse(getConnection());
        return BlobResponse.getLeaseID(getConnection());
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, CloudBlob> createSnapshotImpl(final HashMap<String, String> paramHashMap, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.snapshot(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public CloudBlob preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        int i = getResult().getStatusCode();
        paramAnonymousCloudBlobClient = null;
        if (i != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousOperationContext = BlobResponse.getSnapshotTime(getConnection());
        if ((paramAnonymousCloudBlob instanceof CloudBlockBlob)) {
          paramAnonymousCloudBlobClient = new CloudBlockBlob(paramAnonymousCloudBlob.getName(), paramAnonymousOperationContext, getContainer());
        } else if ((paramAnonymousCloudBlob instanceof CloudPageBlob)) {
          paramAnonymousCloudBlobClient = new CloudPageBlob(paramAnonymousCloudBlob.getName(), paramAnonymousOperationContext, getContainer());
        } else if ((paramAnonymousCloudBlob instanceof CloudAppendBlob)) {
          paramAnonymousCloudBlobClient = new CloudAppendBlob(paramAnonymousCloudBlob.getName(), paramAnonymousOperationContext, getContainer());
        }
        paramAnonymousCloudBlobClient.setProperties(properties);
        paramAnonymousOperationContext = paramHashMap;
        if (paramAnonymousOperationContext != null) {
          paramAnonymousCloudBlob = paramAnonymousOperationContext;
        } else {
          paramAnonymousCloudBlob = metadata;
        }
        paramAnonymousCloudBlobClient.setMetadata(paramAnonymousCloudBlob);
        paramAnonymousCloudBlobClient.updateEtagAndLastModifiedFromResponse(getConnection());
        return paramAnonymousCloudBlobClient;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        paramAnonymousCloudBlob = paramHashMap;
        if (paramAnonymousCloudBlob != null) {
          BlobRequest.addMetadata(paramAnonymousHttpURLConnection, paramAnonymousCloudBlob, paramAnonymousOperationContext);
        }
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
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
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> deleteImpl(final DeleteSnapshotsOption paramDeleteSnapshotsOption, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.deleteBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, snapshotID, paramDeleteSnapshotsOption);
      }
      
      public Void postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, Void paramAnonymousVoid)
      {
        if (getResult().getStatusCode() == 202) {
          deleted = true;
        }
        return null;
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 202) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> downloadAttributesImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getBlobProperties(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, snapshotID);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobClient = BlobResponse.getBlobAttributes(getConnection(), paramAnonymousCloudBlob.getStorageUri(), snapshotID);
        if (paramAnonymousCloudBlobClient.getProperties().getBlobType() == properties.getBlobType())
        {
          properties = paramAnonymousCloudBlobClient.getProperties();
          metadata = paramAnonymousCloudBlobClient.getMetadata();
          return null;
        }
        throw new StorageException("IncorrectBlobType", String.format("Incorrect Blob type, please use the correct Blob type to access a blob on the server. Expected %s, actual %s.", new Object[] { properties.getBlobType(), paramAnonymousCloudBlobClient.getProperties().getBlobType() }), 306, null, null);
      }
      
      public void setRequestLocationMode()
      {
        setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  private final StorageRequest<CloudBlobClient, CloudBlob, Integer> downloadToStreamImpl(final Long paramLong1, final Long paramLong2, final OutputStream paramOutputStream, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    paramBlobRequestOptions.assertPolicyIfRequired();
    final long l1;
    if (paramLong1 == null) {
      l1 = 0L;
    } else {
      l1 = paramLong1.longValue();
    }
    final boolean bool1 = true;
    final boolean bool2;
    if (paramLong1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    final Long localLong1 = null;
    final int i;
    final Long localLong2;
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
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        if (getOffset() == null) {
          setOffset(paramLong1);
        }
        if (getLength() == null) {
          setLength(localLong2);
        }
        if (getETagLockCondition() != null) {
          paramAnonymousCloudBlobClient = getETagLockCondition();
        } else {
          paramAnonymousCloudBlobClient = paramAccessCondition;
        }
        URI localURI = paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation());
        BlobRequestOptions localBlobRequestOptions = paramBlobRequestOptions;
        paramAnonymousCloudBlob = snapshotID;
        Long localLong1 = getOffset();
        Long localLong2 = getLength();
        boolean bool;
        if ((paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (!getArePropertiesPopulated())) {
          bool = true;
        } else {
          bool = false;
        }
        return BlobRequest.getBlob(localURI, localBlobRequestOptions, paramAnonymousOperationContext, paramAnonymousCloudBlobClient, paramAnonymousCloudBlob, localLong1, localLong2, bool);
      }
      
      /* Error */
      public Integer postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, Integer paramAnonymousInteger)
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
        //   4: invokevirtual 129	com/microsoft/azure/storage/blob/BlobRequestOptions:getDisableContentMD5Validation	()Ljava/lang/Boolean;
        //   7: invokevirtual 110	java/lang/Boolean:booleanValue	()Z
        //   10: ifne +19 -> 29
        //   13: aload_0
        //   14: invokevirtual 133	com/microsoft/azure/storage/core/StorageRequest:getContentMD5	()Ljava/lang/String;
        //   17: invokestatic 139	com/microsoft/azure/storage/core/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
        //   20: ifne +9 -> 29
        //   23: iconst_1
        //   24: istore 6
        //   26: goto +6 -> 32
        //   29: iconst_0
        //   30: istore 6
        //   32: iload 6
        //   34: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   37: astore 7
        //   39: aload_1
        //   40: ldc -111
        //   42: invokevirtual 151	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
        //   45: invokestatic 157	java/lang/Long:parseLong	(Ljava/lang/String;)J
        //   48: lstore 8
        //   50: aload 4
        //   52: ldc -97
        //   54: iconst_1
        //   55: anewarray 161	java/lang/Object
        //   58: dup
        //   59: iconst_0
        //   60: lload 8
        //   62: invokestatic 164	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   65: aastore
        //   66: invokestatic 170	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   69: invokestatic 176	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
        //   72: new 178	com/microsoft/azure/storage/core/NetworkInputStream
        //   75: dup
        //   76: aload_1
        //   77: invokevirtual 182	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   80: lload 8
        //   82: invokespecial 185	com/microsoft/azure/storage/core/NetworkInputStream:<init>	(Ljava/io/InputStream;J)V
        //   85: astore_3
        //   86: aload_0
        //   87: getfield 44	com/microsoft/azure/storage/blob/CloudBlob$10:val$userStream	Ljava/io/OutputStream;
        //   90: astore_1
        //   91: aload_0
        //   92: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
        //   95: invokevirtual 189	com/microsoft/azure/storage/blob/BlobRequestOptions:getEncryptionPolicy	()Lcom/microsoft/azure/storage/blob/BlobEncryptionPolicy;
        //   98: ifnull +86 -> 184
        //   101: aload_0
        //   102: getfield 44	com/microsoft/azure/storage/blob/CloudBlob$10:val$userStream	Ljava/io/OutputStream;
        //   105: astore 5
        //   107: aload_0
        //   108: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
        //   111: astore 10
        //   113: aload_2
        //   114: getfield 193	com/microsoft/azure/storage/blob/CloudBlob:metadata	Ljava/util/HashMap;
        //   117: astore 11
        //   119: aload_2
        //   120: getfield 197	com/microsoft/azure/storage/blob/CloudBlob:properties	Lcom/microsoft/azure/storage/blob/BlobProperties;
        //   123: invokevirtual 202	com/microsoft/azure/storage/blob/BlobProperties:getLength	()J
        //   126: lstore 8
        //   128: aload_0
        //   129: getfield 46	com/microsoft/azure/storage/blob/CloudBlob$10:val$isRangeGet	Z
        //   132: istore 12
        //   134: aload_0
        //   135: getfield 48	com/microsoft/azure/storage/blob/CloudBlob$10:val$endOffsetFinal	Ljava/lang/Long;
        //   138: astore 13
        //   140: aload_0
        //   141: getfield 50	com/microsoft/azure/storage/blob/CloudBlob$10:val$userSpecifiedLength	Ljava/lang/Long;
        //   144: astore 14
        //   146: aload_0
        //   147: getfield 52	com/microsoft/azure/storage/blob/CloudBlob$10:val$discardFirstFinal	I
        //   150: istore 15
        //   152: aload_0
        //   153: getfield 54	com/microsoft/azure/storage/blob/CloudBlob$10:val$bufferIVFinal	Z
        //   156: istore 6
        //   158: aload_2
        //   159: aload 5
        //   161: aload 10
        //   163: aload 11
        //   165: lload 8
        //   167: iload 12
        //   169: aload 13
        //   171: aload 14
        //   173: iload 15
        //   175: iload 6
        //   177: invokestatic 208	com/microsoft/azure/storage/blob/BlobEncryptionPolicy:wrapUserStreamWithDecryptStream	(Lcom/microsoft/azure/storage/blob/CloudBlob;Ljava/io/OutputStream;Lcom/microsoft/azure/storage/blob/BlobRequestOptions;Ljava/util/Map;JZLjava/lang/Long;Ljava/lang/Long;IZ)Ljava/io/OutputStream;
        //   180: astore_2
        //   181: goto +5 -> 186
        //   184: aload_1
        //   185: astore_2
        //   186: aload_3
        //   187: astore 5
        //   189: aload_2
        //   190: astore_1
        //   191: aload 5
        //   193: aload_2
        //   194: ldc2_w 209
        //   197: iconst_0
        //   198: aload 7
        //   200: invokevirtual 110	java/lang/Boolean:booleanValue	()Z
        //   203: aload 4
        //   205: aload_0
        //   206: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
        //   209: iconst_1
        //   210: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   213: aload_0
        //   214: aload_0
        //   215: invokevirtual 214	com/microsoft/azure/storage/core/StorageRequest:getCurrentDescriptor	()Lcom/microsoft/azure/storage/core/StreamMd5AndLength;
        //   218: invokestatic 218	com/microsoft/azure/storage/core/Utility:writeToOutputStream	(Ljava/io/InputStream;Ljava/io/OutputStream;JZZLcom/microsoft/azure/storage/OperationContext;Lcom/microsoft/azure/storage/RequestOptions;Ljava/lang/Boolean;Lcom/microsoft/azure/storage/core/StorageRequest;Lcom/microsoft/azure/storage/core/StreamMd5AndLength;)Lcom/microsoft/azure/storage/core/StreamMd5AndLength;
        //   221: astore 4
        //   223: aload_2
        //   224: astore_1
        //   225: aload 7
        //   227: invokevirtual 110	java/lang/Boolean:booleanValue	()Z
        //   230: ifeq +73 -> 303
        //   233: aload_2
        //   234: astore_1
        //   235: aload_0
        //   236: invokevirtual 133	com/microsoft/azure/storage/core/StorageRequest:getContentMD5	()Ljava/lang/String;
        //   239: aload 4
        //   241: invokevirtual 223	com/microsoft/azure/storage/core/StreamMd5AndLength:getMd5	()Ljava/lang/String;
        //   244: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   247: ifeq +6 -> 253
        //   250: goto +53 -> 303
        //   253: aload_2
        //   254: astore_1
        //   255: new 229	com/microsoft/azure/storage/StorageException
        //   258: astore 5
        //   260: aload_2
        //   261: astore_1
        //   262: aload 5
        //   264: ldc -25
        //   266: ldc -23
        //   268: iconst_2
        //   269: anewarray 161	java/lang/Object
        //   272: dup
        //   273: iconst_0
        //   274: aload_0
        //   275: invokevirtual 133	com/microsoft/azure/storage/core/StorageRequest:getContentMD5	()Ljava/lang/String;
        //   278: aastore
        //   279: dup
        //   280: iconst_1
        //   281: aload 4
        //   283: invokevirtual 223	com/microsoft/azure/storage/core/StreamMd5AndLength:getMd5	()Ljava/lang/String;
        //   286: aastore
        //   287: invokestatic 170	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   290: sipush 306
        //   293: aconst_null
        //   294: aconst_null
        //   295: invokespecial 236	com/microsoft/azure/storage/StorageException:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/microsoft/azure/storage/StorageExtendedErrorInformation;Ljava/lang/Exception;)V
        //   298: aload_2
        //   299: astore_1
        //   300: aload 5
        //   302: athrow
        //   303: aload 5
        //   305: invokevirtual 240	com/microsoft/azure/storage/core/NetworkInputStream:close	()V
        //   308: aload_0
        //   309: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
        //   312: invokevirtual 189	com/microsoft/azure/storage/blob/BlobRequestOptions:getEncryptionPolicy	()Lcom/microsoft/azure/storage/blob/BlobEncryptionPolicy;
        //   315: ifnull +7 -> 322
        //   318: aload_2
        //   319: invokevirtual 243	java/io/OutputStream:close	()V
        //   322: aconst_null
        //   323: areturn
        //   324: astore_2
        //   325: goto +4 -> 329
        //   328: astore_2
        //   329: aload_3
        //   330: invokevirtual 240	com/microsoft/azure/storage/core/NetworkInputStream:close	()V
        //   333: aload_0
        //   334: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
        //   337: invokevirtual 189	com/microsoft/azure/storage/blob/BlobRequestOptions:getEncryptionPolicy	()Lcom/microsoft/azure/storage/blob/BlobEncryptionPolicy;
        //   340: ifnull +7 -> 347
        //   343: aload_1
        //   344: invokevirtual 243	java/io/OutputStream:close	()V
        //   347: aload_2
        //   348: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	349	0	this	10
        //   0	349	1	paramAnonymousHttpURLConnection	HttpURLConnection
        //   0	349	2	paramAnonymousCloudBlob	CloudBlob
        //   0	349	3	paramAnonymousCloudBlobClient	CloudBlobClient
        //   0	349	4	paramAnonymousOperationContext	OperationContext
        //   0	349	5	paramAnonymousInteger	Integer
        //   24	152	6	bool1	boolean
        //   37	189	7	localBoolean	Boolean
        //   48	118	8	l	long
        //   111	51	10	localBlobRequestOptions	BlobRequestOptions
        //   117	47	11	localHashMap	HashMap
        //   132	36	12	bool2	boolean
        //   138	32	13	localLong1	Long
        //   144	28	14	localLong2	Long
        //   150	24	15	i	int
        // Exception table:
        //   from	to	target	type
        //   158	181	324	finally
        //   191	223	324	finally
        //   225	233	324	finally
        //   235	250	324	finally
        //   255	260	324	finally
        //   262	298	324	finally
        //   300	303	324	finally
        //   91	158	328	finally
      }
      
      public Integer preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if ((getResult().getStatusCode() != 206) && (getResult().getStatusCode() != 200))
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        if (!getArePropertiesPopulated())
        {
          paramAnonymousCloudBlobClient = BlobResponse.getBlobAttributes(getConnection(), paramAnonymousCloudBlob.getStorageUri(), snapshotID);
          properties = paramAnonymousCloudBlobClient.getProperties();
          metadata = paramAnonymousCloudBlobClient.getMetadata();
          paramAnonymousCloudBlobClient = getConnection().getHeaderField("Content-MD5");
          if ((!paramBlobRequestOptions.getDisableContentMD5Validation().booleanValue()) && (paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (Utility.isNullOrEmpty(paramAnonymousCloudBlobClient))) {
            throw new StorageException("MissingContentMD5Header", "ContentMD5 header is missing in the response.", 306, null, null);
          }
          setContentMD5(paramAnonymousCloudBlobClient);
          setLockedETag(properties.getEtag());
          setArePropertiesPopulated(true);
        }
        if (getResult().getTargetLocation() == StorageLocation.PRIMARY) {
          paramAnonymousCloudBlob = RequestLocationMode.PRIMARY_ONLY;
        } else {
          paramAnonymousCloudBlob = RequestLocationMode.SECONDARY_ONLY;
        }
        setRequestLocationMode(paramAnonymousCloudBlob);
        return null;
      }
      
      public void recoveryAction(OperationContext paramAnonymousOperationContext)
      {
        if ((!paramBlobRequestOptions.getSkipEtagLocking()) && (getETagLockCondition() == null) && (!Utility.isNullOrEmpty(getLockedETag())))
        {
          paramAnonymousOperationContext = new AccessCondition();
          paramAnonymousOperationContext.setIfMatch(getLockedETag());
          AccessCondition localAccessCondition = paramAccessCondition;
          if (localAccessCondition != null) {
            paramAnonymousOperationContext.setLeaseID(localAccessCondition.getLeaseID());
          }
          setETagLockCondition(paramAnonymousOperationContext);
        }
        if (getCurrentRequestByteCount() > 0L)
        {
          long l = l1;
          setOffset(Long.valueOf(getCurrentRequestByteCount() + l));
          paramAnonymousOperationContext = localLong2;
          if (paramAnonymousOperationContext != null) {
            setLength(Long.valueOf(paramAnonymousOperationContext.longValue() - getCurrentRequestByteCount()));
          }
        }
      }
      
      public void setRequestLocationMode()
      {
        setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
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
  
  private StorageRequest<CloudBlobClient, CloudBlob, Boolean> existsImpl(final boolean paramBoolean, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getBlobProperties(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, snapshotID);
      }
      
      public Boolean preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() == 200)
        {
          paramAnonymousCloudBlobClient = BlobResponse.getBlobAttributes(getConnection(), paramAnonymousCloudBlob.getStorageUri(), snapshotID);
          properties = paramAnonymousCloudBlobClient.getProperties();
          metadata = paramAnonymousCloudBlobClient.getMetadata();
          return Boolean.valueOf(true);
        }
        if (getResult().getStatusCode() == 404) {
          return Boolean.valueOf(false);
        }
        setNonExceptionedRetryableFailure(true);
        return Boolean.valueOf(false);
      }
      
      public void setRequestLocationMode()
      {
        RequestLocationMode localRequestLocationMode;
        if (paramBoolean) {
          localRequestLocationMode = RequestLocationMode.PRIMARY_ONLY;
        } else {
          localRequestLocationMode = RequestLocationMode.PRIMARY_OR_SECONDARY;
        }
        setRequestLocationMode(localRequestLocationMode);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
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
      Object localObject = PathUtility.parseQueryString(paramStorageUri.getQuery());
      paramStorageUri = (String[])((HashMap)localObject).get("snapshot");
      if ((paramStorageUri != null) && (paramStorageUri.length > 0)) {
        snapshotID = paramStorageUri[0];
      }
      paramStorageUri = SharedAccessSignatureHelper.parseQuery((HashMap)localObject);
      if ((paramStorageCredentials != null) && (paramStorageUri != null)) {
        throw new IllegalArgumentException("Cannot provide credentials as part of the address and as constructor parameter. Either pass in the address or use a different constructor.");
      }
      try
      {
        boolean bool = Utility.determinePathStyleFromUri(storageUri.getPrimaryUri());
        CloudBlobClient localCloudBlobClient = new com/microsoft/azure/storage/blob/CloudBlobClient;
        localObject = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials == null) {
          paramStorageCredentials = paramStorageUri;
        }
        localCloudBlobClient.<init>((StorageUri)localObject, paramStorageCredentials);
        blobServiceClient = localCloudBlobClient;
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
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> releaseLeaseImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.RELEASE, null, null, null);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        updateEtagAndLastModifiedFromResponse(getConnection());
        properties.setLeaseStatus(LeaseStatus.UNLOCKED);
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> renewLeaseImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.RENEW, null, null, null);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        updateEtagAndLastModifiedFromResponse(getConnection());
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> undeleteImpl(final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.undeleteBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext);
      }
      
      public Void postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, Void paramAnonymousVoid)
      {
        if (getResult().getStatusCode() == 200) {
          deleted = false;
        }
        return null;
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> uploadMetadataImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.setBlobMetadata(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        BlobRequest.addMetadata(paramAnonymousHttpURLConnection, metadata, paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> uploadPropertiesImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.setBlobProperties(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, properties);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
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
  
  public StorageRequest<ServiceClient, CloudBlob, AccountInformation> downloadAccountInformationImpl(final RequestOptions paramRequestOptions)
  {
    new StorageRequest(paramRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(ServiceClient paramAnonymousServiceClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BaseRequest.getAccountInfo(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramRequestOptions, null, paramAnonymousOperationContext);
      }
      
      public AccountInformation preProcessResponse(CloudBlob paramAnonymousCloudBlob, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        return BlobResponse.getAccountInformation(getConnection());
      }
      
      public void setRequestLocationMode()
      {
        setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousServiceClient, -1L, paramAnonymousOperationContext);
      }
    };
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
  
  public StorageRequest<CloudBlobClient, CloudBlob, String> startCopyImpl(final URI paramURI, final String paramString, final boolean paramBoolean1, final boolean paramBoolean2, final PremiumPageBlobTier paramPremiumPageBlobTier, final AccessCondition paramAccessCondition1, final AccessCondition paramAccessCondition2, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.copyFrom(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition1, paramAccessCondition2, paramURI.toASCIIString(), snapshotID, paramBoolean2, paramBoolean1, paramString, paramPremiumPageBlobTier);
      }
      
      public String preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 202)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        properties.setCopyState(BlobResponse.getCopyState(getConnection()));
        properties.setPremiumPageBlobTier(paramPremiumPageBlobTier);
        if (paramPremiumPageBlobTier != null) {
          properties.setBlobTierInferred(Boolean.valueOf(false));
        }
        return properties.getCopyState().getCopyId();
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        BlobRequest.addMetadata(paramAnonymousHttpURLConnection, metadata, paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
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
  
  public StorageRequest<CloudBlobClient, CloudBlob, Void> uploadBlobTierImpl(final String paramString, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.setBlobTier(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramString);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if ((getResult().getStatusCode() != 200) && (getResult().getStatusCode() != 202))
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        paramAnonymousCloudBlob.getProperties().setBlobTierInferred(Boolean.valueOf(false));
        if (paramAnonymousCloudBlob.getProperties().getBlobType() == BlobType.BLOCK_BLOB)
        {
          paramAnonymousCloudBlobClient = StandardBlobTier.parse(paramString);
          paramAnonymousCloudBlob.getProperties().setRehydrationStatus(null);
          if (getResult().getStatusCode() == 200) {
            paramAnonymousCloudBlob.getProperties().setStandardBlobTier(paramAnonymousCloudBlobClient);
          } else if (paramAnonymousCloudBlobClient.equals(StandardBlobTier.COOL)) {
            paramAnonymousCloudBlob.getProperties().setStandardBlobTier(StandardBlobTier.ARCHIVE);
          } else if (paramAnonymousCloudBlobClient.equals(StandardBlobTier.HOT)) {
            paramAnonymousCloudBlob.getProperties().setStandardBlobTier(StandardBlobTier.ARCHIVE);
          }
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
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
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */