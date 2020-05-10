package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.Constants;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public final class CloudPageBlob
  extends CloudBlob
{
  public CloudPageBlob(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudPageBlob(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    this(paramStorageUri, null, paramStorageCredentials);
  }
  
  public CloudPageBlob(StorageUri paramStorageUri, String paramString, StorageCredentials paramStorageCredentials)
  {
    super(BlobType.PAGE_BLOB, paramStorageUri, paramString, paramStorageCredentials);
  }
  
  public CloudPageBlob(CloudPageBlob paramCloudPageBlob)
  {
    super(paramCloudPageBlob);
  }
  
  public CloudPageBlob(String paramString1, String paramString2, CloudBlobContainer paramCloudBlobContainer)
  {
    super(BlobType.PAGE_BLOB, paramString1, paramString2, paramCloudBlobContainer);
  }
  
  public CloudPageBlob(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudPageBlob(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  public CloudPageBlob(URI paramURI, String paramString, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramString, paramStorageCredentials);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlob, Void> createImpl(final long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.putBlob(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, properties, BlobType.PAGE_BLOB, paramLong, val$premiumBlobTier);
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
        paramAnonymousCloudBlob.getProperties().setLength(paramLong);
        paramAnonymousCloudBlob.getProperties().setPremiumPageBlobTier(val$premiumBlobTier);
        if (val$premiumBlobTier != null) {
          paramAnonymousCloudBlob.getProperties().setBlobTierInferred(Boolean.valueOf(false));
        }
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
  
  private StorageRequest<CloudBlobClient, CloudBlob, List<PageRangeDiff>> downloadPageRangesDiffImpl(final String paramString, final Long paramLong1, final Long paramLong2, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getPageRangesDiff(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, snapshotID, paramString, paramLong1, paramLong2);
      }
      
      public List<PageRangeDiff> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, List<PageRangeDiff> paramAnonymousList)
      {
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudBlob.updateLengthFromResponse(getConnection());
        return PageRangeDiffHandler.getPageRangesDiff(getConnection().getInputStream());
      }
      
      public List<PageRangeDiff> preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
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
  
  private StorageRequest<CloudBlobClient, CloudBlob, ArrayList<PageRange>> downloadPageRangesImpl(final Long paramLong1, final Long paramLong2, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlob paramAnonymousCloudBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getPageRanges(paramAnonymousCloudBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, snapshotID, paramLong1, paramLong2);
      }
      
      public ArrayList<PageRange> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, ArrayList<PageRange> paramAnonymousArrayList)
      {
        paramAnonymousCloudBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudBlob.updateLengthFromResponse(getConnection());
        return PageRangeHandler.getPageRanges(getConnection().getInputStream());
      }
      
      public ArrayList<PageRange> preProcessResponse(CloudBlob paramAnonymousCloudBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
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
  
  private BlobOutputStream openOutputStreamInternal(Long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    assertNoWriteOperationForSnapshot();
    paramOperationContext = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient, false);
    paramOperationContext.assertPolicyIfRequired();
    if (!paramOperationContext.getStoreBlobContentMD5().booleanValue())
    {
      paramBlobRequestOptions = null;
      if (paramOperationContext.getEncryptionPolicy() != null) {
        paramBlobRequestOptions = paramOperationContext.getEncryptionPolicy().createAndSetEncryptionContext(getMetadata(), true);
      }
      if (paramLong != null)
      {
        if (paramLong.longValue() % 512L == 0L) {
          create(paramLong.longValue(), paramPremiumPageBlobTier, paramAccessCondition, paramOperationContext, localOperationContext);
        } else {
          throw new IllegalArgumentException("Page blob length must be multiple of 512.");
        }
      }
      else
      {
        if (paramOperationContext.getEncryptionPolicy() != null) {
          break label211;
        }
        downloadAttributes(paramAccessCondition, paramOperationContext, localOperationContext);
        paramLong = Long.valueOf(getProperties().getLength());
      }
      paramPremiumPageBlobTier = paramAccessCondition;
      if (paramAccessCondition != null) {
        paramPremiumPageBlobTier = AccessCondition.generateLeaseCondition(paramAccessCondition.getLeaseID());
      }
      if (paramOperationContext.getEncryptionPolicy() != null) {
        return new BlobEncryptStream(this, paramLong.longValue(), paramPremiumPageBlobTier, paramOperationContext, localOperationContext, paramBlobRequestOptions);
      }
      return new BlobOutputStreamInternal(this, paramLong.longValue(), paramPremiumPageBlobTier, paramOperationContext, localOperationContext);
      label211:
      throw new IllegalArgumentException("Encryption is not supported for a blob that already exists. Please do not specify an encryption policy.");
    }
    throw new IllegalArgumentException("Blob level MD5 is not supported for page blobs.");
  }
  
  private StorageRequest<CloudBlobClient, CloudPageBlob, Void> putPagesImpl(final PageRange paramPageRange, final PageOperationType paramPageOperationType, final byte[] paramArrayOfByte, final long paramLong, final String paramString, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudPageBlob paramAnonymousCloudPageBlob, OperationContext paramAnonymousOperationContext)
      {
        if (paramPageOperationType == PageOperationType.UPDATE)
        {
          setSendStream(new ByteArrayInputStream(paramArrayOfByte));
          setLength(Long.valueOf(paramLong));
        }
        return BlobRequest.putPage(paramAnonymousCloudPageBlob.getTransformedAddress(paramBlobRequestOptions).getUri(getCurrentLocation()), paramAccessCondition, paramBlobRequestOptions, paramPageRange, paramString, paramPageOperationType);
      }
      
      public Void preProcessResponse(CloudPageBlob paramAnonymousCloudPageBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudPageBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudPageBlob.updateSequenceNumberFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudPageBlob paramAnonymousCloudPageBlob, OperationContext paramAnonymousOperationContext)
      {
        if ((paramPageOperationType == PageOperationType.UPDATE) && (paramAccessCondition.getUseTransactionalContentMD5().booleanValue())) {
          paramAnonymousHttpURLConnection.setRequestProperty("Content-MD5", val$md5);
        }
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (paramPageOperationType == PageOperationType.UPDATE) {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, paramLong, paramAnonymousOperationContext);
        } else {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
        }
      }
    };
  }
  
  @DoesServiceRequest
  private void putPagesInternal(PageRange paramPageRange, PageOperationType paramPageOperationType, byte[] paramArrayOfByte, long paramLong, String paramString, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    ExecutionEngine.executeWithRetry(blobServiceClient, this, putPagesImpl(paramPageRange, paramPageOperationType, paramArrayOfByte, paramLong, paramString, paramAccessCondition, paramBlobRequestOptions, paramOperationContext), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private StorageRequest<CloudBlobClient, CloudPageBlob, Void> resizeImpl(final long paramLong, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudPageBlob paramAnonymousCloudPageBlob, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.resize(paramAnonymousCloudPageBlob.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, Long.valueOf(paramLong));
      }
      
      public Void preProcessResponse(CloudPageBlob paramAnonymousCloudPageBlob, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudPageBlob.getProperties().setLength(paramLong);
        paramAnonymousCloudPageBlob.updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudPageBlob.updateSequenceNumberFromResponse(getConnection());
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  public void clearPages(long paramLong1, long paramLong2)
  {
    clearPages(paramLong1, paramLong2, null, null, null);
  }
  
  @DoesServiceRequest
  public void clearPages(long paramLong1, long paramLong2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramLong1 % 512L == 0L)
    {
      if (paramLong2 % 512L == 0L)
      {
        if (paramOperationContext == null) {
          paramOperationContext = new OperationContext();
        }
        paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
        paramBlobRequestOptions.assertNoEncryptionPolicyOrStrictMode();
        putPagesInternal(new PageRange(paramLong1, paramLong1 + paramLong2 - 1L), PageOperationType.CLEAR, null, paramLong2, null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
        return;
      }
      throw new IllegalArgumentException("Page blob length must be multiple of 512.");
    }
    throw new IllegalArgumentException("Page start offset must be multiple of 512.");
  }
  
  @DoesServiceRequest
  public void create(long paramLong)
  {
    create(paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void create(long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    create(paramLong, null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void create(long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    if (paramLong % 512L == 0L)
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
      ExecutionEngine.executeWithRetry(blobServiceClient, this, createImpl(paramLong, paramPremiumPageBlobTier, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IllegalArgumentException("Page blob length must be multiple of 512.");
  }
  
  @DoesServiceRequest
  public ArrayList<PageRange> downloadPageRanges()
  {
    return downloadPageRanges(null, null, null);
  }
  
  @DoesServiceRequest
  public ArrayList<PageRange> downloadPageRanges(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
    return (ArrayList)ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadPageRangesImpl(null, null, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public List<PageRange> downloadPageRanges(long paramLong, Long paramLong1)
  {
    return downloadPageRanges(paramLong, paramLong1, null, null, null);
  }
  
  @DoesServiceRequest
  public List<PageRange> downloadPageRanges(long paramLong, Long paramLong1, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if ((paramLong >= 0L) && ((paramLong1 == null) || (paramLong1.longValue() > 0L)))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
      return (List)ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadPageRangesImpl(Long.valueOf(paramLong), paramLong1, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
    }
    throw new IndexOutOfBoundsException();
  }
  
  @DoesServiceRequest
  public List<PageRangeDiff> downloadPageRangesDiff(String paramString)
  {
    return downloadPageRangesDiff(paramString, null, null, null, null, null);
  }
  
  @DoesServiceRequest
  public List<PageRangeDiff> downloadPageRangesDiff(String paramString, Long paramLong1, Long paramLong2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
    return (List)ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadPageRangesDiffImpl(paramString, paramLong1, paramLong2, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteExisting()
  {
    return openOutputStreamInternal(null, null, null, null, null);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteExisting(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(null, null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteNew(long paramLong)
  {
    return openOutputStreamInternal(Long.valueOf(paramLong), null, null, null, null);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteNew(long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(Long.valueOf(paramLong), null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public BlobOutputStream openWriteNew(long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(Long.valueOf(paramLong), paramPremiumPageBlobTier, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  public void resize(long paramLong)
  {
    resize(paramLong, null, null, null);
  }
  
  public void resize(long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    if (paramLong % 512L == 0L)
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
      ExecutionEngine.executeWithRetry(blobServiceClient, this, resizeImpl(paramLong, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IllegalArgumentException("Page blob length must be multiple of 512.");
  }
  
  public void setStreamWriteSizeInBytes(int paramInt)
  {
    if ((paramInt <= Constants.MAX_PAGE_WRITE_SIZE) && (paramInt >= 512) && (paramInt % 512 == 0))
    {
      streamWriteSizeInBytes = paramInt;
      return;
    }
    throw new IllegalArgumentException("StreamWriteSizeInBytes");
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudPageBlob paramCloudPageBlob)
  {
    return startCopy(paramCloudPageBlob, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudPageBlob paramCloudPageBlob, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return startCopy(paramCloudPageBlob, null, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudPageBlob paramCloudPageBlob, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceBlob", paramCloudPageBlob);
    URI localURI1 = paramCloudPageBlob.getSnapshotQualifiedUri();
    URI localURI2 = localURI1;
    if (paramCloudPageBlob.getServiceClient() != null)
    {
      localURI2 = localURI1;
      if (paramCloudPageBlob.getServiceClient().getCredentials() != null) {
        localURI2 = paramCloudPageBlob.getServiceClient().getCredentials().transformUri(paramCloudPageBlob.getSnapshotQualifiedUri());
      }
    }
    return startCopy(localURI2, paramPremiumPageBlobTier, paramAccessCondition1, paramAccessCondition2, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startIncrementalCopy(CloudPageBlob paramCloudPageBlob)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("snapshot", snapshotID);
    return startIncrementalCopy(localUriQueryBuilder.addToURI(paramCloudPageBlob.getTransformedAddress(null).getPrimaryUri()), null, null, null);
  }
  
  @DoesServiceRequest
  public final String startIncrementalCopy(CloudPageBlob paramCloudPageBlob, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("snapshot", snapshotID);
    return startIncrementalCopy(localUriQueryBuilder.addToURI(paramCloudPageBlob.getTransformedAddress(null).getPrimaryUri()), paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startIncrementalCopy(URI paramURI)
  {
    return startIncrementalCopy(paramURI, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startIncrementalCopy(URI paramURI, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceSnapshot", paramURI);
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, properties.getBlobType(), blobServiceClient);
    return (String)ExecutionEngine.executeWithRetry(blobServiceClient, this, startCopyImpl(paramURI, "", false, true, null, null, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public void updateSequenceNumberFromResponse(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-blob-sequence-number");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      getProperties().setPageBlobSequenceNumber(Long.valueOf(Long.parseLong(paramHttpURLConnection)));
    }
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong)
  {
    upload(paramInputStream, paramLong, null, null, null, null);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    upload(paramInputStream, paramLong, null, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
    paramBlobRequestOptions.assertPolicyIfRequired();
    if ((paramLong > 0L) && (paramLong % 512L == 0L))
    {
      if (!paramBlobRequestOptions.getStoreBlobContentMD5().booleanValue())
      {
        if (paramInputStream.markSupported()) {
          paramInputStream.mark(268435456);
        }
        paramPremiumPageBlobTier = openWriteNew(paramLong, paramPremiumPageBlobTier, paramAccessCondition, paramBlobRequestOptions, localOperationContext);
        try
        {
          paramPremiumPageBlobTier.write(paramInputStream, paramLong);
          return;
        }
        finally
        {
          paramPremiumPageBlobTier.close();
        }
      }
      throw new IllegalArgumentException("Blob level MD5 is not supported for page blobs.");
    }
    throw new IllegalArgumentException("Page blob length must be multiple of 512.");
  }
  
  public void uploadFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2);
    upload(paramArrayOfByte, paramInt2, paramPremiumPageBlobTier, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    paramArrayOfByte.close();
  }
  
  public void uploadFromFile(String paramString, PremiumPageBlobTier paramPremiumPageBlobTier, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramString = new File(paramString);
    long l = paramString.length();
    paramString = new BufferedInputStream(new FileInputStream(paramString));
    upload(paramString, l, paramPremiumPageBlobTier, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
    paramString.close();
  }
  
  @DoesServiceRequest
  public void uploadPages(InputStream paramInputStream, long paramLong1, long paramLong2)
  {
    uploadPages(paramInputStream, paramLong1, paramLong2, null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadPages(InputStream paramInputStream, long paramLong1, long paramLong2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramLong1 % 512L == 0L)
    {
      if ((paramLong2 != 0L) && (paramLong2 % 512L == 0L))
      {
        if (paramLong2 <= 4194304L)
        {
          assertNoWriteOperationForSnapshot();
          if (paramOperationContext == null) {
            paramOperationContext = new OperationContext();
          }
          paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
          paramBlobRequestOptions.assertNoEncryptionPolicyOrStrictMode();
          PageRange localPageRange = new PageRange(paramLong1, paramLong1 + paramLong2 - 1L);
          int i = (int)paramLong2;
          byte[] arrayOfByte = new byte[i];
          int j = 0;
          for (;;)
          {
            paramLong1 = j;
            if (paramLong1 >= paramLong2) {
              break;
            }
            j += paramInputStream.read(arrayOfByte, j, (int)Math.min(paramLong2 - paramLong1, 2147483647L));
          }
          if (paramBlobRequestOptions.getUseTransactionalContentMD5().booleanValue()) {
            try
            {
              paramInputStream = MessageDigest.getInstance("MD5");
              paramInputStream.update(arrayOfByte, 0, i);
              paramInputStream = Base64.encode(paramInputStream.digest());
            }
            catch (NoSuchAlgorithmException paramInputStream)
            {
              throw Utility.generateNewUnexpectedStorageException(paramInputStream);
            }
          } else {
            paramInputStream = null;
          }
          putPagesInternal(localPageRange, PageOperationType.UPDATE, arrayOfByte, paramLong2, paramInputStream, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
          return;
        }
        throw new IllegalArgumentException("Max write size is 4MB. Please specify a smaller range.");
      }
      throw new IllegalArgumentException("Page blob length must be multiple of 512.");
    }
    throw new IllegalArgumentException("Page start offset must be multiple of 512.");
  }
  
  @DoesServiceRequest
  public void uploadPremiumPageBlobTier(PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    uploadPremiumPageBlobTier(paramPremiumPageBlobTier, null, null);
  }
  
  @DoesServiceRequest
  public void uploadPremiumPageBlobTier(PremiumPageBlobTier paramPremiumPageBlobTier, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    assertNoWriteOperationForSnapshot();
    Utility.assertNotNull("premiumBlobTier", paramPremiumPageBlobTier);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.PAGE_BLOB, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadBlobTierImpl(paramPremiumPageBlobTier.toString(), paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
    properties.setPremiumPageBlobTier(paramPremiumPageBlobTier);
    properties.setBlobTierInferred(Boolean.valueOf(false));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudPageBlob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */