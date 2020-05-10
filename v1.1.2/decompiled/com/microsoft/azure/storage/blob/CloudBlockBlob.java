package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.Constants;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.MarkableFileStream;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.file.CloudFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.xml.stream.XMLStreamException;

public final class CloudBlockBlob
  extends CloudBlob
{
  public boolean isStreamWriteSizeModified = false;
  
  public CloudBlockBlob(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudBlockBlob(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    this(paramStorageUri, null, paramStorageCredentials);
  }
  
  public CloudBlockBlob(StorageUri paramStorageUri, String paramString, StorageCredentials paramStorageCredentials)
  {
    super(BlobType.BLOCK_BLOB, paramStorageUri, paramString, paramStorageCredentials);
  }
  
  public CloudBlockBlob(CloudBlockBlob paramCloudBlockBlob)
  {
    super(paramCloudBlockBlob);
  }
  
  public CloudBlockBlob(String paramString1, String paramString2, CloudBlobContainer paramCloudBlobContainer)
  {
    super(BlobType.BLOCK_BLOB, paramString1, paramString2, paramCloudBlobContainer);
  }
  
  public CloudBlockBlob(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudBlockBlob(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  public CloudBlockBlob(URI paramURI, String paramString, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramString, paramStorageCredentials);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> commitBlockListImpl(final Iterable<BlockEntry> paramIterable, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions, final OperationContext paramOperationContext)
  {
    try
    {
      paramOperationContext = BlockEntryListSerializer.writeBlockListToStream(paramIterable, paramOperationContext);
      paramIterable = new java/io/ByteArrayInputStream;
      paramIterable.<init>(paramOperationContext);
      paramOperationContext = Utility.analyzeStream(paramIterable, -1L, -1L, true, paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue());
      paramIterable = new StorageRequest(paramBlobRequestOptions, getStorageUri())
      {
        public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
        {
          setSendStream(paramIterable);
          setLength(Long.valueOf(paramOperationContext.getLength()));
          return BlobRequest.putBlockList(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, properties);
        }
        
        public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
        {
          if (getResult().getStatusCode() != 201)
          {
            setNonExceptionedRetryableFailure(true);
            return null;
          }
          paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
          getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
          return null;
        }
        
        public void recoveryAction(OperationContext paramAnonymousOperationContext)
        {
          paramIterable.reset();
          paramIterable.mark(268435456);
        }
        
        public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
        {
          BlobRequest.addMetadata(paramAnonymousHttpURLConnection, metadata, paramAnonymousOperationContext);
          if (paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) {
            paramAnonymousHttpURLConnection.setRequestProperty("Content-MD5", paramOperationContext.getMd5());
          }
        }
        
        public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
        {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, getLength().longValue(), paramAnonymousOperationContext);
        }
      };
      return paramIterable;
    }
    catch (IOException paramIterable)
    {
      throw StorageException.translateClientException(paramIterable);
    }
    catch (XMLStreamException paramIterable)
    {
      throw StorageException.translateClientException(paramIterable);
    }
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> createBlockFromURIImpl(final String paramString1, final URI paramURI, final Long paramLong1, final Long paramLong2, final String paramString2, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions, final OperationContext paramOperationContext)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.putBlock(paramAnonymousCloudBlob.getTransformedAddress(paramOperationContext).getUri(getCurrentLocation()), paramURI.toASCIIString(), paramLong1.longValue(), paramLong2, paramBlobRequestOptions, paramString2, paramOperationContext, paramAccessCondition, paramString1);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  private void createBlockFromURIInternal(String paramString1, URI paramURI, Long paramLong1, Long paramLong2, String paramString2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    ExecutionEngine.executeWithRetry(blobServiceClient, this, createBlockFromURIImpl(paramString1, paramURI, paramLong1, paramLong2, paramString2, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, ArrayList<BlockEntry>> downloadBlockListImpl(final BlockListingFilter paramBlockListingFilter, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getBlockList(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, snapshotID, paramBlockListingFilter);
      }
      
      public ArrayList<BlockEntry> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, ArrayList<BlockEntry> paramAnonymousArrayList)
      {
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudBlob.updateLengthFromResponse(getConnection());
        return BlockListHandler.getBlockList(getConnection().getInputStream());
      }
      
      public ArrayList<BlockEntry> preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
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
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> uploadBlockImpl(final String paramString1, final String paramString2, final InputStream paramInputStream, final long paramLong, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        setSendStream(paramInputStream);
        setLength(Long.valueOf(paramLong));
        return BlobRequest.putBlock(paramAnonymousCloudBlob.getTransformedAddress(paramBlobRequestOptions).getUri(getCurrentLocation()), paramAccessCondition, paramBlobRequestOptions, paramString1, paramString2);
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void recoveryAction(OperationContext paramAnonymousOperationContext)
      {
        paramInputStream.reset();
        paramInputStream.mark(268435456);
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        if (paramAccessCondition.getUseTransactionalContentMD5().booleanValue()) {
          paramAnonymousHttpURLConnection.setRequestProperty("Content-MD5", val$md5);
        }
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, paramLong, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  private void uploadBlockInternal(String paramString1, String paramString2, InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadBlockImpl(paramString1, paramString2, paramInputStream, paramLong, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private void uploadFromMultiStream(final Iterable<InputStream> paramIterable, AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions, final OperationContext paramOperationContext, List<BlockEntry> paramList)
  {
    int i = paramBlobRequestOptions.getConcurrentRequestCount().intValue();
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    ExecutorCompletionService localExecutorCompletionService = new ExecutorCompletionService(localThreadPoolExecutor);
    Iterator localIterator = paramIterable.iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      paramIterable = (InputStream)localIterator.next();
      i++;
      final String str = Base64.encode(String.format("Block_%05d", new Object[] { Integer.valueOf(i) }).getBytes());
      paramList.add(new BlockEntry(str));
      final long l;
      if ((paramIterable instanceof SubStream)) {
        l = ((SubStream)paramIterable).getLength();
      } else {
        l = streamWriteSizeInBytes;
      }
      localExecutorCompletionService.submit(new Callable()
      {
        public Void call()
        {
          uploadBlock(str, paramIterable, l, paramBlobRequestOptions, paramOperationContext, val$_operationContext);
          paramIterable.close();
          return null;
        }
      });
    }
    for (int j = 0; j < i; j++) {
      waitAny(localExecutorCompletionService);
    }
    try
    {
      localThreadPoolExecutor.shutdown();
      return;
    }
    finally
    {
      if (!localThreadPoolExecutor.isShutdown()) {
        localThreadPoolExecutor.shutdownNow();
      }
    }
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> uploadFullBlobImpl(final InputStream paramInputStream, final long paramLong, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        setSendStream(paramInputStream);
        setLength(Long.valueOf(paramLong));
        paramAnonymousCloudBlobClient = paramAnonymousCloudBlob.getTransformedAddress(paramBlobRequestOptions).getUri(getCurrentLocation());
        paramAnonymousOperationContext = paramAccessCondition;
        OperationContext localOperationContext = paramBlobRequestOptions;
        AccessCondition localAccessCondition = val$accessCondition;
        paramAnonymousCloudBlob = properties;
        return BlobRequest.putBlob(paramAnonymousCloudBlobClient, paramAnonymousOperationContext, localOperationContext, localAccessCondition, paramAnonymousCloudBlob, paramAnonymousCloudBlob.getBlobType(), getLength().longValue());
      }
      
      public Void preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void recoveryAction(OperationContext paramAnonymousOperationContext)
      {
        paramInputStream.reset();
        paramInputStream.mark(268435456);
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        BlobRequest.addMetadata(paramAnonymousHttpURLConnection, metadata, paramBlobRequestOptions);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, paramLong, paramAnonymousOperationContext);
      }
      
      public void validateStreamWrite(StreamMd5AndLength paramAnonymousStreamMd5AndLength)
      {
        if ((getLength() != null) && (getLength().longValue() != -1L) && (paramLong != paramAnonymousStreamMd5AndLength.getLength())) {
          throw new StorageException("InvalidInput", "An incorrect stream length was specified, resulting in an authentication failure. Please specify correct length, or -1.", 403, null, null);
        }
      }
    };
  }
  
  private void waitAny(ExecutorCompletionService<Void> paramExecutorCompletionService)
  {
    try
    {
      paramExecutorCompletionService.take().get();
      return;
    }
    catch (Exception localException)
    {
      paramExecutorCompletionService = localException.getCause();
      while (paramExecutorCompletionService != null) {
        if (!(paramExecutorCompletionService instanceof StorageException)) {
          paramExecutorCompletionService = paramExecutorCompletionService.getCause();
        } else {
          throw ((StorageException)paramExecutorCompletionService);
        }
      }
      throw Utility.initIOException(localException);
    }
  }
  
  @DoesServiceRequest
  public void commitBlockList(Iterable<BlockEntry> paramIterable)
  {
    commitBlockList(paramIterable, null, null, null);
  }
  
  @DoesServiceRequest
  public void commitBlockList(Iterable<BlockEntry> paramIterable, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, commitBlockListImpl(paramIterable, paramAccessCondition, paramBlobRequestOptions, localOperationContext), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void createBlockFromURI(String paramString, URI paramURI, Long paramLong1, Long paramLong2)
  {
    createBlockFromURI(paramString, paramURI, paramLong1, paramLong2, null, null, null, null);
  }
  
  @DoesServiceRequest
  public void createBlockFromURI(String paramString1, URI paramURI, Long paramLong1, Long paramLong2, String paramString2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("copySource", paramURI);
    assertNoWriteOperationForSnapshot();
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient);
    paramBlobRequestOptions.assertNoEncryptionPolicyOrStrictMode();
    if ((!Utility.isNullOrEmpty(paramString1)) && (Base64.validateIsBase64String(paramString1)))
    {
      if ((paramLong2 != null) && (paramLong2.longValue() > Constants.MAX_BLOCK_SIZE)) {
        throw new IllegalArgumentException("Invalid copy length, length must be less than or equal to 100 MB in size.");
      }
      createBlockFromURIInternal(paramString1, paramURI, paramLong1, paramLong2, paramString2, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
      return;
    }
    throw new IllegalArgumentException("Invalid blockID, blockID must be a valid Base64 String.");
  }
  
  @DoesServiceRequest
  public ArrayList<BlockEntry> downloadBlockList()
  {
    return downloadBlockList(BlockListingFilter.COMMITTED, null, null, null);
  }
  
  @DoesServiceRequest
  public ArrayList<BlockEntry> downloadBlockList(BlockListingFilter paramBlockListingFilter, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("blockListingFilter", paramBlockListingFilter);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient);
    return (ArrayList)ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadBlockListImpl(paramBlockListingFilter, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public String downloadText()
  {
    return downloadText(null, null, null, null);
  }
  
  public String downloadText(String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    download(localByteArrayOutputStream, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    if (paramString == null) {
      paramString = localByteArrayOutputStream.toString();
    } else {
      paramString = localByteArrayOutputStream.toString(paramString);
    }
    return paramString;
  }
  
  public boolean isStreamWriteSizeModified()
  {
    return isStreamWriteSizeModified;
  }
  
  public BlobOutputStream openOutputStream()
  {
    return openOutputStream(null, null, null);
  }
  
  public BlobOutputStream openOutputStream(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    assertNoWriteOperationForSnapshot();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient, false);
    paramBlobRequestOptions.assertPolicyIfRequired();
    if (paramBlobRequestOptions.getEncryptionPolicy() != null) {
      return new BlobEncryptStream(this, paramAccessCondition, paramBlobRequestOptions, localOperationContext, paramBlobRequestOptions.getEncryptionPolicy().createAndSetEncryptionContext(getMetadata(), false));
    }
    return new BlobOutputStreamInternal(this, paramAccessCondition, paramBlobRequestOptions, localOperationContext);
  }
  
  public void setStreamWriteSizeInBytes(int paramInt)
  {
    if ((paramInt <= Constants.MAX_BLOCK_SIZE) && (paramInt >= 16384))
    {
      streamWriteSizeInBytes = paramInt;
      isStreamWriteSizeModified = true;
      return;
    }
    throw new IllegalArgumentException("StreamWriteSizeInBytes");
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudBlockBlob paramCloudBlockBlob)
  {
    return startCopy(paramCloudBlockBlob, null, false, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudBlockBlob paramCloudBlockBlob, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceBlob", paramCloudBlockBlob);
    paramCloudBlockBlob.getSnapshotQualifiedUri();
    if ((paramCloudBlockBlob.getServiceClient() != null) && (paramCloudBlockBlob.getServiceClient().getCredentials() != null)) {
      paramCloudBlockBlob.getServiceClient().getCredentials().transformUri(paramCloudBlockBlob.getSnapshotQualifiedUri());
    }
    return startCopy(paramCloudBlockBlob, null, false, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudBlockBlob paramCloudBlockBlob, String paramString, boolean paramBoolean, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceBlob", paramCloudBlockBlob);
    URI localURI1 = paramCloudBlockBlob.getSnapshotQualifiedUri();
    URI localURI2 = localURI1;
    if (paramCloudBlockBlob.getServiceClient() != null)
    {
      localURI2 = localURI1;
      if (paramCloudBlockBlob.getServiceClient().getCredentials() != null) {
        localURI2 = paramCloudBlockBlob.getServiceClient().getCredentials().transformUri(paramCloudBlockBlob.getSnapshotQualifiedUri());
      }
    }
    return startCopy(localURI2, paramString, paramBoolean, null, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudFile paramCloudFile)
  {
    return startCopy(paramCloudFile, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudFile paramCloudFile, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceFile", paramCloudFile);
    return startCopy(paramCloudFile.getServiceClient().getCredentials().transformUri(paramCloudFile.getUri()), null, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong)
  {
    upload(paramInputStream, paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    boolean bool1 = paramLong < -1L;
    if (!bool1)
    {
      assertNoWriteOperationForSnapshot();
      if (paramOperationContext == null) {
        paramOperationContext = new OperationContext();
      }
      paramOperationContext.initialize();
      BlobRequestOptions localBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient);
      localBlobRequestOptions.assertPolicyIfRequired();
      StreamMd5AndLength localStreamMd5AndLength = new StreamMd5AndLength();
      localStreamMd5AndLength.setLength(paramLong);
      if ((!paramInputStream.markSupported()) && ((paramInputStream instanceof FileInputStream))) {
        paramInputStream = new MarkableFileStream((FileInputStream)paramInputStream);
      }
      boolean bool2 = paramInputStream.markSupported();
      int i = 1;
      int j;
      if ((bool2) && (localStreamMd5AndLength.getLength() <= localBlobRequestOptions.getSingleBlobPutThresholdInBytes().intValue())) {
        j = 0;
      } else {
        j = 1;
      }
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(268435456);
      }
      paramBlobRequestOptions = paramInputStream;
      if (j == 0)
      {
        paramBlobRequestOptions = paramInputStream;
        if (localBlobRequestOptions.getEncryptionPolicy() != null)
        {
          Cipher localCipher = localBlobRequestOptions.getEncryptionPolicy().createAndSetEncryptionContext(getMetadata(), false);
          paramBlobRequestOptions = new ByteArrayOutputStream()
          {
            public byte[] getByteArray()
            {
              return buf;
            }
          };
          long l = Utility.encryptStreamIfUnderThreshold(paramInputStream, paramBlobRequestOptions, localCipher, localStreamMd5AndLength.getLength(), localBlobRequestOptions.getSingleBlobPutThresholdInBytes().intValue() + 1);
          if (l >= 0L)
          {
            paramBlobRequestOptions = new ByteArrayInputStream(paramBlobRequestOptions.getByteArray());
            localStreamMd5AndLength.setLength(l);
          }
          else
          {
            j = 1;
            break label269;
          }
        }
      }
      paramInputStream = paramBlobRequestOptions;
      label269:
      if ((j == 0) && ((localStreamMd5AndLength.getLength() < 0L) || (localBlobRequestOptions.getStoreBlobContentMD5().booleanValue())))
      {
        localStreamMd5AndLength = Utility.analyzeStream(paramInputStream, localStreamMd5AndLength.getLength(), localBlobRequestOptions.getSingleBlobPutThresholdInBytes().intValue() + 1, true, localBlobRequestOptions.getStoreBlobContentMD5().booleanValue());
        if ((localStreamMd5AndLength.getMd5() != null) && (localBlobRequestOptions.getStoreBlobContentMD5().booleanValue())) {
          properties.setContentMD5(localStreamMd5AndLength.getMd5());
        }
        paramBlobRequestOptions = localStreamMd5AndLength;
        k = i;
        if (localStreamMd5AndLength.getLength() == -1L) {
          break label418;
        }
        paramBlobRequestOptions = localStreamMd5AndLength;
        if (localStreamMd5AndLength.getLength() > localBlobRequestOptions.getSingleBlobPutThresholdInBytes().intValue())
        {
          paramBlobRequestOptions = localStreamMd5AndLength;
          k = i;
          break label418;
        }
      }
      else
      {
        paramBlobRequestOptions = localStreamMd5AndLength;
      }
      int k = j;
      label418:
      if (k == 0)
      {
        uploadFullBlob(paramInputStream, paramBlobRequestOptions.getLength(), paramAccessCondition, localBlobRequestOptions, paramOperationContext);
      }
      else
      {
        double d = paramLong;
        j = (int)Math.ceil(d / streamWriteSizeInBytes);
        if ((bool1) && (j > 50000L)) {
          if (!isStreamWriteSizeModified())
          {
            j = (int)Math.ceil(d / 50000.0D);
            streamWriteSizeInBytes = j;
            Math.ceil(d / j);
          }
          else
          {
            throw new IOException("The total blocks for this upload exceeds the maximum allowable limit. Please increase the block size.");
          }
        }
        if ((localBlobRequestOptions.getEncryptionPolicy() == null) && (paramInputStream.markSupported()) && (streamWriteSizeInBytes >= Constants.MIN_LARGE_BLOCK_SIZE) && (!localBlobRequestOptions.getStoreBlobContentMD5().booleanValue())) {
          paramBlobRequestOptions.getLength();
        }
        paramAccessCondition = openOutputStream(paramAccessCondition, localBlobRequestOptions, paramOperationContext);
      }
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
    throw new IllegalArgumentException("Invalid stream length, specify -1 for unknown length stream, or a positive number of bytes.");
  }
  
  @DoesServiceRequest
  public void uploadBlock(String paramString, InputStream paramInputStream, long paramLong)
  {
    uploadBlock(paramString, paramInputStream, paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadBlock(String paramString, InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramLong >= -1L)
    {
      assertNoWriteOperationForSnapshot();
      if (paramOperationContext == null) {
        paramOperationContext = new OperationContext();
      }
      BlobRequestOptions localBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient);
      localBlobRequestOptions.assertNoEncryptionPolicyOrStrictMode();
      if ((!Utility.isNullOrEmpty(paramString)) && (Base64.validateIsBase64String(paramString)))
      {
        if ((!paramInputStream.markSupported()) && ((paramInputStream instanceof FileInputStream))) {
          paramInputStream = new MarkableFileStream((FileInputStream)paramInputStream);
        }
        if (paramInputStream.markSupported()) {
          paramInputStream.mark(268435456);
        }
        paramBlobRequestOptions = new StreamMd5AndLength();
        paramBlobRequestOptions.setLength(paramLong);
        if (!paramInputStream.markSupported())
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramBlobRequestOptions = Utility.writeToOutputStream(paramInputStream, localByteArrayOutputStream, paramLong, false, localBlobRequestOptions.getUseTransactionalContentMD5().booleanValue(), paramOperationContext, localBlobRequestOptions);
          paramInputStream = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
        }
        else if ((paramLong < 0L) || (localBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()))
        {
          paramBlobRequestOptions = Utility.analyzeStream(paramInputStream, paramLong, -1L, true, localBlobRequestOptions.getUseTransactionalContentMD5().booleanValue());
        }
        if (paramBlobRequestOptions.getLength() <= Constants.MAX_BLOCK_SIZE)
        {
          uploadBlockInternal(paramString, paramBlobRequestOptions.getMd5(), paramInputStream, paramBlobRequestOptions.getLength(), paramAccessCondition, localBlobRequestOptions, paramOperationContext);
          return;
        }
        throw new IllegalArgumentException("Invalid stream length, length must be less than or equal to 100 MB in size.");
      }
      throw new IllegalArgumentException("Invalid blockID, blockID must be a valid Base64 String.");
    }
    throw new IllegalArgumentException("Invalid stream length, specify -1 for unknown length stream, or a positive number of bytes.");
  }
  
  @DoesServiceRequest
  public final void uploadFullBlob(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    paramInputStream.mark(268435456);
    if ((paramLong >= 0L) && (paramLong <= 268435456L))
    {
      ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadFullBlobImpl(paramInputStream, paramLong, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
      return;
    }
    throw new IllegalArgumentException(String.format("Invalid stream length; stream must be between 0 and %s MB in length.", new Object[] { Integer.valueOf(256) }));
  }
  
  @DoesServiceRequest
  public void uploadStandardBlobTier(StandardBlobTier paramStandardBlobTier)
  {
    uploadStandardBlobTier(paramStandardBlobTier, null, null);
  }
  
  @DoesServiceRequest
  public void uploadStandardBlobTier(StandardBlobTier paramStandardBlobTier, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    Utility.assertNotNull("standardBlobTier", paramStandardBlobTier);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.BLOCK_BLOB, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadBlobTierImpl(paramStandardBlobTier.toString(), paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public void uploadText(String paramString)
  {
    uploadText(paramString, null, null, null, null);
  }
  
  public void uploadText(String paramString1, String paramString2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramString2 == null) {
      paramString1 = paramString1.getBytes();
    } else {
      paramString1 = paramString1.getBytes(paramString2);
    }
    uploadFromByteArray(paramString1, 0, paramString1.length, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlockBlob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */