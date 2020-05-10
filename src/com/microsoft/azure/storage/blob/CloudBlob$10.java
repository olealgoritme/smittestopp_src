package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageLocation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;

public class CloudBlob$10
  extends StorageRequest<CloudBlobClient, CloudBlob, Integer>
{
  public CloudBlob$10(CloudBlob paramCloudBlob, RequestOptions paramRequestOptions, StorageUri paramStorageUri, Long paramLong1, Long paramLong2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OutputStream paramOutputStream, boolean paramBoolean1, Long paramLong3, Long paramLong4, int paramInt, boolean paramBoolean2, long paramLong)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudBlobClient paramCloudBlobClient, CloudBlob paramCloudBlob, OperationContext paramOperationContext)
  {
    if (getOffset() == null) {
      setOffset(val$offsetFinal);
    }
    if (getLength() == null) {
      setLength(val$lengthFinal);
    }
    if (getETagLockCondition() != null) {
      paramCloudBlobClient = getETagLockCondition();
    } else {
      paramCloudBlobClient = val$accessCondition;
    }
    URI localURI = paramCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation());
    BlobRequestOptions localBlobRequestOptions = val$options;
    String str = snapshotID;
    Long localLong = getOffset();
    paramCloudBlob = getLength();
    boolean bool;
    if ((val$options.getUseTransactionalContentMD5().booleanValue()) && (!getArePropertiesPopulated())) {
      bool = true;
    } else {
      bool = false;
    }
    return BlobRequest.getBlob(localURI, localBlobRequestOptions, paramOperationContext, paramCloudBlobClient, str, localLong, paramCloudBlob, bool);
  }
  
  /* Error */
  public Integer postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext, Integer paramInteger)
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
    //   105: astore 10
    //   107: aload_0
    //   108: getfield 42	com/microsoft/azure/storage/blob/CloudBlob$10:val$options	Lcom/microsoft/azure/storage/blob/BlobRequestOptions;
    //   111: astore 11
    //   113: aload_2
    //   114: getfield 193	com/microsoft/azure/storage/blob/CloudBlob:metadata	Ljava/util/HashMap;
    //   117: astore 5
    //   119: aload_2
    //   120: getfield 197	com/microsoft/azure/storage/blob/CloudBlob:properties	Lcom/microsoft/azure/storage/blob/BlobProperties;
    //   123: invokevirtual 202	com/microsoft/azure/storage/blob/BlobProperties:getLength	()J
    //   126: lstore 8
    //   128: aload_0
    //   129: getfield 46	com/microsoft/azure/storage/blob/CloudBlob$10:val$isRangeGet	Z
    //   132: istore 6
    //   134: aload_0
    //   135: getfield 48	com/microsoft/azure/storage/blob/CloudBlob$10:val$endOffsetFinal	Ljava/lang/Long;
    //   138: astore 12
    //   140: aload_0
    //   141: getfield 50	com/microsoft/azure/storage/blob/CloudBlob$10:val$userSpecifiedLength	Ljava/lang/Long;
    //   144: astore 13
    //   146: aload_0
    //   147: getfield 52	com/microsoft/azure/storage/blob/CloudBlob$10:val$discardFirstFinal	I
    //   150: istore 14
    //   152: aload_0
    //   153: getfield 54	com/microsoft/azure/storage/blob/CloudBlob$10:val$bufferIVFinal	Z
    //   156: istore 15
    //   158: aload_2
    //   159: aload 10
    //   161: aload 11
    //   163: aload 5
    //   165: lload 8
    //   167: iload 6
    //   169: aload 12
    //   171: aload 13
    //   173: iload 14
    //   175: iload 15
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
    //   0	349	1	paramHttpURLConnection	HttpURLConnection
    //   0	349	2	paramCloudBlob	CloudBlob
    //   0	349	3	paramCloudBlobClient	CloudBlobClient
    //   0	349	4	paramOperationContext	OperationContext
    //   0	349	5	paramInteger	Integer
    //   24	144	6	bool1	boolean
    //   37	189	7	localBoolean	Boolean
    //   48	118	8	l	long
    //   105	55	10	localOutputStream	OutputStream
    //   111	51	11	localBlobRequestOptions	BlobRequestOptions
    //   138	32	12	localLong1	Long
    //   144	28	13	localLong2	Long
    //   150	24	14	i	int
    //   156	20	15	bool2	boolean
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
  
  public Integer preProcessResponse(CloudBlob paramCloudBlob, CloudBlobClient paramCloudBlobClient, OperationContext paramOperationContext)
  {
    if ((getResult().getStatusCode() != 206) && (getResult().getStatusCode() != 200))
    {
      setNonExceptionedRetryableFailure(true);
      return null;
    }
    if (!getArePropertiesPopulated())
    {
      paramCloudBlobClient = BlobResponse.getBlobAttributes(getConnection(), paramCloudBlob.getStorageUri(), snapshotID);
      properties = paramCloudBlobClient.getProperties();
      metadata = paramCloudBlobClient.getMetadata();
      paramCloudBlobClient = getConnection().getHeaderField("Content-MD5");
      if ((!val$options.getDisableContentMD5Validation().booleanValue()) && (val$options.getUseTransactionalContentMD5().booleanValue()) && (Utility.isNullOrEmpty(paramCloudBlobClient))) {
        throw new StorageException("MissingContentMD5Header", "ContentMD5 header is missing in the response.", 306, null, null);
      }
      setContentMD5(paramCloudBlobClient);
      setLockedETag(properties.getEtag());
      setArePropertiesPopulated(true);
    }
    if (getResult().getTargetLocation() == StorageLocation.PRIMARY) {
      paramCloudBlob = RequestLocationMode.PRIMARY_ONLY;
    } else {
      paramCloudBlob = RequestLocationMode.SECONDARY_ONLY;
    }
    setRequestLocationMode(paramCloudBlob);
    return null;
  }
  
  public void recoveryAction(OperationContext paramOperationContext)
  {
    if ((!val$options.getSkipEtagLocking()) && (getETagLockCondition() == null) && (!Utility.isNullOrEmpty(getLockedETag())))
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
      paramOperationContext = val$lengthFinal;
      if (paramOperationContext != null) {
        setLength(Long.valueOf(paramOperationContext.longValue() - getCurrentRequestByteCount()));
      }
    }
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
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlob.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */