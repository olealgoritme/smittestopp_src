package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.Constants;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsSharedAccessSignature;
import com.microsoft.azure.storage.StorageErrorCode;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageLocation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.core.Base64;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.Logger;
import com.microsoft.azure.storage.core.NetworkInputStream;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageCredentialsHelper;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.StreamMd5AndLength;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.core.WrappedByteArrayOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class CloudFile
  implements ListFileItem
{
  public CloudFileClient fileServiceClient;
  public HashMap<String, String> metadata = new HashMap();
  public String name;
  public CloudFileDirectory parent;
  public FileProperties properties = new FileProperties();
  public CloudFileShare share;
  public StorageUri storageUri;
  public int streamMinimumReadSizeInBytes = 4194304;
  public int streamWriteSizeInBytes = 4194304;
  
  public CloudFile(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudFile(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
  }
  
  public CloudFile(StorageUri paramStorageUri, String paramString, CloudFileShare paramCloudFileShare)
  {
    Utility.assertNotNull("uri", paramStorageUri);
    Utility.assertNotNull("fileName", paramString);
    Utility.assertNotNull("share", paramCloudFileShare);
    name = paramString;
    fileServiceClient = paramCloudFileShare.getServiceClient();
    share = paramCloudFileShare;
    storageUri = paramStorageUri;
  }
  
  public CloudFile(CloudFile paramCloudFile)
  {
    metadata = new HashMap();
    properties = new FileProperties(properties);
    Object localObject = metadata;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        metadata.put(str, metadata.get(str));
      }
    }
    storageUri = storageUri;
    share = share;
    parent = parent;
    fileServiceClient = fileServiceClient;
    name = name;
    setStreamMinimumReadSizeInBytes(paramCloudFile.getStreamMinimumReadSizeInBytes());
    setStreamWriteSizeInBytes(paramCloudFile.getStreamWriteSizeInBytes());
  }
  
  public CloudFile(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudFile(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> abortCopyImpl(final String paramString, final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    Utility.assertNotNull("copyId", paramString);
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.abortCopy(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, paramString);
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 202) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> createImpl(final long paramLong, final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.putFile(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, CloudFile.access$100(paramAnonymousCloudFile), paramLong);
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        FileRequest.addMetadata(paramAnonymousHttpURLConnection, CloudFile.access$000(paramAnonymousCloudFile), paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
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
  
  private StorageRequest<CloudFileClient, CloudFile, Void> deleteImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.deleteFile(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 202) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> downloadAttributesImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.getFileProperties(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, getSharesnapshotID);
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFileClient = FileResponse.getFileAttributes(getConnection(), paramAnonymousCloudFile.getStorageUri());
        CloudFile.access$102(paramAnonymousCloudFile, paramAnonymousCloudFileClient.getProperties());
        CloudFile.access$002(paramAnonymousCloudFile, paramAnonymousCloudFileClient.getMetadata());
        return null;
      }
      
      public void setRequestLocationMode()
      {
        setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFile, ArrayList<FileRange>> downloadFileRangesImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.getFileRanges(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, getSharesnapshotID);
      }
      
      public ArrayList<FileRange> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext, ArrayList<FileRange> paramAnonymousArrayList)
      {
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        paramAnonymousCloudFile.updateLengthFromResponse(getConnection());
        return FileRangeHandler.getFileRanges(getConnection().getInputStream());
      }
      
      public ArrayList<FileRange> preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
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
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  private final StorageRequest<CloudFileClient, CloudFile, Integer> downloadToStreamImpl(final Long paramLong1, final Long paramLong2, final OutputStream paramOutputStream, final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    final long l;
    if (paramLong1 == null) {
      l = 0L;
    } else {
      l = paramLong1.longValue();
    }
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        if (getOffset() == null) {
          setOffset(paramLong1);
        }
        if (getLength() == null) {
          setLength(paramLong2);
        }
        URI localURI = paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation());
        FileRequestOptions localFileRequestOptions = paramFileRequestOptions;
        paramAnonymousCloudFileClient = paramAccessCondition;
        String str = getSharesnapshotID;
        Long localLong = getOffset();
        paramAnonymousCloudFile = getLength();
        boolean bool;
        if ((paramFileRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (!getArePropertiesPopulated())) {
          bool = true;
        } else {
          bool = false;
        }
        return FileRequest.getFile(localURI, localFileRequestOptions, paramAnonymousOperationContext, paramAnonymousCloudFileClient, str, localLong, paramAnonymousCloudFile, bool);
      }
      
      public Integer postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext, Integer paramAnonymousInteger)
      {
        boolean bool;
        if ((!paramFileRequestOptions.getDisableContentMD5Validation().booleanValue()) && (!Utility.isNullOrEmpty(getContentMD5()))) {
          bool = true;
        } else {
          bool = false;
        }
        paramAnonymousCloudFile = Boolean.valueOf(bool);
        long l = Long.parseLong(paramAnonymousHttpURLConnection.getHeaderField("Content-Length"));
        Logger.info(paramAnonymousOperationContext, String.format("Creating a NetworkInputStream and expecting to read %s bytes.", new Object[] { Long.valueOf(l) }));
        paramAnonymousHttpURLConnection = new NetworkInputStream(paramAnonymousHttpURLConnection.getInputStream(), l);
        try
        {
          paramAnonymousCloudFileClient = Utility.writeToOutputStream(paramAnonymousHttpURLConnection, paramOutputStream, -1L, false, paramAnonymousCloudFile.booleanValue(), paramAnonymousOperationContext, paramFileRequestOptions, Boolean.valueOf(true), this, getCurrentDescriptor());
          if ((paramAnonymousCloudFile.booleanValue()) && (!getContentMD5().equals(paramAnonymousCloudFileClient.getMd5())))
          {
            paramAnonymousCloudFile = new com/microsoft/azure/storage/StorageException;
            paramAnonymousCloudFile.<init>("InvalidMd5", String.format("File hash mismatch (integrity check failed), Expected value is %s, retrieved %s.", new Object[] { getContentMD5(), paramAnonymousCloudFileClient.getMd5() }), 306, null, null);
            throw paramAnonymousCloudFile;
          }
          return null;
        }
        finally
        {
          paramAnonymousHttpURLConnection.close();
        }
      }
      
      public Integer preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if ((getResult().getStatusCode() != 206) && (getResult().getStatusCode() != 200))
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        if (!getArePropertiesPopulated())
        {
          paramAnonymousCloudFileClient = FileResponse.getFileAttributes(getConnection(), paramAnonymousCloudFile.getStorageUri());
          CloudFile.access$102(paramAnonymousCloudFile, paramAnonymousCloudFileClient.getProperties());
          CloudFile.access$002(paramAnonymousCloudFile, paramAnonymousCloudFileClient.getMetadata());
          setContentMD5(getConnection().getHeaderField("Content-MD5"));
          if ((!paramFileRequestOptions.getDisableContentMD5Validation().booleanValue()) && (paramFileRequestOptions.getUseTransactionalContentMD5().booleanValue()) && (Utility.isNullOrEmpty(getContentMD5()))) {
            throw new StorageException("MissingContentMD5Header", "ContentMD5 header is missing in the response.", 306, null, null);
          }
          setLockedETag(CloudFile.access$100(paramAnonymousCloudFile).getEtag());
          setArePropertiesPopulated(true);
        }
        else if ((getLockedETag() != null) && (!getLockedETag().equals(CloudFile.access$100(paramAnonymousCloudFile).getEtag())))
        {
          paramAnonymousCloudFile = StorageErrorCode.CONDITION_FAILED;
          throw new StorageException("CONDITION_FAILED", "The conditionals specified for this operation did not match server.", 412, null, null);
        }
        if (getResult().getTargetLocation() == StorageLocation.PRIMARY) {
          paramAnonymousCloudFile = RequestLocationMode.PRIMARY_ONLY;
        } else {
          paramAnonymousCloudFile = RequestLocationMode.SECONDARY_ONLY;
        }
        setRequestLocationMode(paramAnonymousCloudFile);
        return null;
      }
      
      public void recoveryAction(OperationContext paramAnonymousOperationContext)
      {
        if ((getETagLockCondition() == null) && (!Utility.isNullOrEmpty(getLockedETag())))
        {
          AccessCondition localAccessCondition = new AccessCondition();
          localAccessCondition.setIfMatch(getLockedETag());
          paramAnonymousOperationContext = paramAccessCondition;
          if (paramAnonymousOperationContext != null) {
            localAccessCondition.setLeaseID(paramAnonymousOperationContext.getLeaseID());
          }
          setETagLockCondition(localAccessCondition);
        }
        if (getCurrentRequestByteCount() > 0L)
        {
          long l = l;
          setOffset(Long.valueOf(getCurrentRequestByteCount() + l));
          paramAnonymousOperationContext = paramLong2;
          if (paramAnonymousOperationContext != null) {
            setLength(Long.valueOf(paramAnonymousOperationContext.longValue() - getCurrentRequestByteCount()));
          }
        }
      }
      
      public void setRequestLocationMode()
      {
        setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  private final boolean exists(boolean paramBoolean, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return ((Boolean)ExecutionEngine.executeWithRetry(fileServiceClient, this, existsImpl(paramBoolean, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext)).booleanValue();
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Boolean> existsImpl(final boolean paramBoolean, final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.getFileProperties(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, getSharesnapshotID);
      }
      
      public Boolean preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() == 200)
        {
          paramAnonymousCloudFileClient = FileResponse.getFileAttributes(getConnection(), paramAnonymousCloudFile.getStorageUri());
          CloudFile.access$102(paramAnonymousCloudFile, paramAnonymousCloudFileClient.getProperties());
          CloudFile.access$002(paramAnonymousCloudFile, paramAnonymousCloudFileClient.getMetadata());
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
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  public static String getParentNameFromURI(StorageUri paramStorageUri, CloudFileShare paramCloudFileShare)
  {
    Utility.assertNotNull("resourceAddress", paramStorageUri);
    Utility.assertNotNull("share", paramCloudFileShare);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCloudFileShare.getName());
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    paramCloudFileShare = Utility.safeRelativize(paramCloudFileShare.getStorageUri().getPrimaryUri(), paramStorageUri.getPrimaryUri());
    paramStorageUri = paramCloudFileShare;
    if (paramCloudFileShare.endsWith("/")) {
      paramStorageUri = paramCloudFileShare.substring(0, paramCloudFileShare.length() - 1);
    }
    boolean bool = Utility.isNullOrEmpty(paramStorageUri);
    paramCloudFileShare = "";
    if (bool)
    {
      paramStorageUri = null;
    }
    else
    {
      int i = paramStorageUri.lastIndexOf("/");
      if (i < 0)
      {
        paramStorageUri = paramCloudFileShare;
      }
      else
      {
        paramStorageUri = paramStorageUri.substring(0, i);
        if ((paramStorageUri != null) && (paramStorageUri.equals(localObject))) {
          paramStorageUri = paramCloudFileShare;
        }
      }
    }
    return paramStorageUri;
  }
  
  private FileOutputStream openOutputStreamInternal(Long paramLong, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    paramOperationContext = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient, false);
    if (paramLong != null)
    {
      create(paramLong.longValue(), paramAccessCondition, paramOperationContext, localOperationContext);
    }
    else
    {
      if (paramOperationContext.getStoreFileContentMD5().booleanValue()) {
        break label119;
      }
      downloadAttributes(paramAccessCondition, paramOperationContext, localOperationContext);
      paramLong = Long.valueOf(getProperties().getLength());
    }
    paramFileRequestOptions = paramAccessCondition;
    if (paramAccessCondition != null) {
      paramFileRequestOptions = AccessCondition.generateLeaseCondition(paramAccessCondition.getLeaseID());
    }
    return new FileOutputStream(this, paramLong.longValue(), paramFileRequestOptions, paramOperationContext, localOperationContext);
    label119:
    throw new IllegalArgumentException("MD5 cannot be calculated for an existing file because it would require reading the existing data. Please disable StoreFileContentMD5.");
  }
  
  private void parseQueryAndVerify(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("completeUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      storageUri = PathUtility.stripURIQueryAndFragment(paramStorageUri);
      StorageCredentialsSharedAccessSignature localStorageCredentialsSharedAccessSignature = SharedAccessSignatureHelper.parseQuery(paramStorageUri);
      if ((paramStorageCredentials != null) && (localStorageCredentialsSharedAccessSignature != null)) {
        throw new IllegalArgumentException("Cannot provide credentials as part of the address and as constructor parameter. Either pass in the address or use a different constructor.");
      }
      try
      {
        boolean bool = Utility.determinePathStyleFromUri(storageUri.getPrimaryUri());
        CloudFileClient localCloudFileClient = new com/microsoft/azure/storage/file/CloudFileClient;
        StorageUri localStorageUri = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials == null) {
          paramStorageCredentials = localStorageCredentialsSharedAccessSignature;
        }
        localCloudFileClient.<init>(localStorageUri, paramStorageCredentials);
        fileServiceClient = localCloudFileClient;
        name = PathUtility.getFileNameFromURI(storageUri.getPrimaryUri(), bool);
        paramStorageUri = (String[])PathUtility.parseQueryString(paramStorageUri.getQuery()).get("sharesnapshot");
        if ((paramStorageUri != null) && (paramStorageUri.length > 0)) {
          getSharesnapshotID = paramStorageUri[0];
        }
        return;
      }
      catch (URISyntaxException paramStorageUri)
      {
        throw Utility.generateNewUnexpectedStorageException(paramStorageUri);
      }
    }
    throw new IllegalArgumentException(String.format("Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramStorageUri.toString() }));
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> putRangeImpl(final FileRange paramFileRange, final FileRangeOperationType paramFileRangeOperationType, final byte[] paramArrayOfByte, final long paramLong, final String paramString, final AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, final OperationContext paramOperationContext)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        if (paramFileRangeOperationType == FileRangeOperationType.UPDATE)
        {
          setSendStream(new ByteArrayInputStream(paramArrayOfByte));
          setLength(Long.valueOf(paramLong));
        }
        return FileRequest.putRange(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramOperationContext, paramAccessCondition, paramFileRange, paramString, paramFileRangeOperationType);
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        if ((paramFileRangeOperationType == FileRangeOperationType.UPDATE) && (paramOperationContext.getUseTransactionalContentMD5().booleanValue())) {
          paramAnonymousHttpURLConnection.setRequestProperty("Content-MD5", val$md5);
        }
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (paramFileRangeOperationType == FileRangeOperationType.UPDATE) {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, paramLong, paramAnonymousOperationContext);
        } else {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
        }
      }
    };
  }
  
  @DoesServiceRequest
  private void putRangeInternal(FileRange paramFileRange, FileRangeOperationType paramFileRangeOperationType, byte[] paramArrayOfByte, long paramLong, String paramString, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    ExecutionEngine.executeWithRetry(fileServiceClient, this, putRangeImpl(paramFileRange, paramFileRangeOperationType, paramArrayOfByte, paramLong, paramString, paramAccessCondition, paramFileRequestOptions, paramOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> resizeImpl(final long paramLong, final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.resize(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, Long.valueOf(paramLong));
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFile.getProperties().setLength(paramLong);
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFile, String> startCopyImpl(final URI paramURI, final AccessCondition paramAccessCondition1, final AccessCondition paramAccessCondition2, final FileRequestOptions paramFileRequestOptions)
  {
    if ((paramAccessCondition1 != null) && (!Utility.isNullOrEmpty(paramAccessCondition1.getLeaseID()))) {
      throw new IllegalArgumentException("A lease condition cannot be specified on the source of a copy.");
    }
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.copyFrom(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition1, paramAccessCondition2, paramURI.toASCIIString());
      }
      
      public String preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 202)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        CloudFile.access$100(paramAnonymousCloudFile).setCopyState(FileResponse.getCopyState(getConnection()));
        return CloudFile.access$100(paramAnonymousCloudFile).getCopyState().getCopyId();
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        FileRequest.addMetadata(paramAnonymousHttpURLConnection, CloudFile.access$000(paramAnonymousCloudFile), paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> uploadMetadataImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.setFileMetadata(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        FileRequest.addMetadata(paramAnonymousHttpURLConnection, CloudFile.access$000(paramAnonymousCloudFile), paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFile, Void> uploadPropertiesImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFile paramAnonymousCloudFile, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.setFileProperties(paramAnonymousCloudFile.getTransformedAddress(paramAnonymousOperationContext).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, CloudFile.access$100(paramAnonymousCloudFile));
      }
      
      public Void preProcessResponse(CloudFile paramAnonymousCloudFile, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFile.updateEtagAndLastModifiedFromResponse(getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  public final void abortCopy(String paramString)
  {
    abortCopy(paramString, null, null, null);
  }
  
  @DoesServiceRequest
  public final void abortCopy(String paramString, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, abortCopyImpl(paramString, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void clearRange(long paramLong1, long paramLong2)
  {
    clearRange(paramLong1, paramLong2, null, null, null);
  }
  
  @DoesServiceRequest
  public void clearRange(long paramLong1, long paramLong2, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    putRangeInternal(new FileRange(paramLong1, paramLong1 + paramLong2 - 1L), FileRangeOperationType.CLEAR, null, paramLong2, null, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void create(long paramLong)
  {
    create(paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void create(long paramLong, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, createImpl(paramLong, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void delete()
  {
    delete(null, null, null);
  }
  
  @DoesServiceRequest
  public final void delete(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, deleteImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final boolean deleteIfExists()
  {
    return deleteIfExists(null, null, null);
  }
  
  @DoesServiceRequest
  public final boolean deleteIfExists(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    getShare().assertNoSnapshot();
    if (exists(true, paramAccessCondition, paramFileRequestOptions, paramOperationContext)) {
      try
      {
        delete(paramAccessCondition, paramFileRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramAccessCondition)
      {
        if ((paramAccessCondition.getHttpStatusCode() == 404) && ("ResourceNotFound".equals(paramAccessCondition.getErrorCode()))) {
          return false;
        }
        throw paramAccessCondition;
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
  public final void download(OutputStream paramOutputStream, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadToStreamImpl(null, null, paramOutputStream, paramAccessCondition, paramFileRequestOptions, localOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void downloadAttributes()
  {
    downloadAttributes(null, null, null);
  }
  
  @DoesServiceRequest
  public final void downloadAttributes(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadAttributesImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public ArrayList<FileRange> downloadFileRanges()
  {
    return downloadFileRanges(null, null, null);
  }
  
  @DoesServiceRequest
  public ArrayList<FileRange> downloadFileRanges(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return (ArrayList)ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadFileRangesImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void downloadRange(long paramLong, Long paramLong1, OutputStream paramOutputStream)
  {
    downloadRange(paramLong, paramLong1, paramOutputStream, null, null, null);
  }
  
  @DoesServiceRequest
  public final void downloadRange(long paramLong, Long paramLong1, OutputStream paramOutputStream, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    if ((paramLong >= 0L) && ((paramLong1 == null) || (paramLong1.longValue() > 0L)))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
      ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadToStreamImpl(Long.valueOf(paramLong), paramLong1, paramOutputStream, paramAccessCondition, paramFileRequestOptions, localOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  @DoesServiceRequest
  public final int downloadRangeInternal(long paramLong, Long paramLong1, byte[] paramArrayOfByte, int paramInt, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    if ((paramInt >= 0) && (paramLong >= 0L) && ((paramLong1 == null) || (paramLong1.longValue() > 0L)))
    {
      if (paramOperationContext == null) {
        paramOperationContext = new OperationContext();
      }
      paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
      paramArrayOfByte = new WrappedByteArrayOutputStream(paramArrayOfByte, paramInt);
      ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadToStreamImpl(Long.valueOf(paramLong), paramLong1, paramArrayOfByte, paramAccessCondition, paramFileRequestOptions, paramOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), paramOperationContext);
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
  public final int downloadRangeToByteArray(long paramLong, Long paramLong1, byte[] paramArrayOfByte, int paramInt, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("buffer", paramArrayOfByte);
    if ((paramLong1 != null) && (paramLong1.longValue() + paramInt > paramArrayOfByte.length)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    return downloadRangeInternal(paramLong, paramLong1, paramArrayOfByte, paramInt, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  public String downloadText()
  {
    return downloadText(null, null, null, null);
  }
  
  public String downloadText(String paramString, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    download(localByteArrayOutputStream, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
    if (paramString == null) {
      paramString = localByteArrayOutputStream.toString();
    } else {
      paramString = localByteArrayOutputStream.toString(paramString);
    }
    return paramString;
  }
  
  @DoesServiceRequest
  public final int downloadToByteArray(byte[] paramArrayOfByte, int paramInt)
  {
    return downloadToByteArray(paramArrayOfByte, paramInt, null, null, null);
  }
  
  @DoesServiceRequest
  public final int downloadToByteArray(byte[] paramArrayOfByte, int paramInt, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
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
        paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
        paramArrayOfByte = new WrappedByteArrayOutputStream(paramArrayOfByte, paramInt);
        ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadToStreamImpl(null, null, paramArrayOfByte, paramAccessCondition, paramFileRequestOptions, localOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
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
  
  public void downloadToFile(String paramString, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new java.io.FileOutputStream(paramString));
    try
    {
      download(localBufferedOutputStream, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
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
  public final boolean exists(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return exists(false, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  public String generateSharedAccessSignature(SharedAccessFilePolicy paramSharedAccessFilePolicy, SharedAccessFileHeaders paramSharedAccessFileHeaders, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessFilePolicy, paramSharedAccessFileHeaders, paramString, null, null);
  }
  
  public String generateSharedAccessSignature(SharedAccessFilePolicy paramSharedAccessFilePolicy, SharedAccessFileHeaders paramSharedAccessFileHeaders, String paramString, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(fileServiceClient.getCredentials())) {
      return SharedAccessSignatureHelper.generateSharedAccessSignatureForBlobAndFile(paramSharedAccessFilePolicy, paramSharedAccessFileHeaders, paramString, "f", paramIPRange, paramSharedAccessProtocols, SharedAccessSignatureHelper.generateSharedAccessSignatureHashForBlobAndFile(paramSharedAccessFilePolicy, paramSharedAccessFileHeaders, paramString, getCanonicalName(), paramIPRange, paramSharedAccessProtocols, fileServiceClient)).toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public String generateSharedAccessSignature(SharedAccessFilePolicy paramSharedAccessFilePolicy, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessFilePolicy, null, paramString);
  }
  
  public String getCanonicalName()
  {
    StringBuilder localStringBuilder = new StringBuilder("/");
    localStringBuilder.append("file");
    String str = getUri().getRawPath();
    if (fileServiceClient.isUsePathStyleUris()) {
      localStringBuilder.append(str);
    } else {
      localStringBuilder.append(PathUtility.getCanonicalPathFromCredentials(getServiceClient().getCredentials(), str));
    }
    return localStringBuilder.toString();
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
  
  public final CloudFileDirectory getParent()
  {
    if (parent == null)
    {
      String str = getParentNameFromURI(getStorageUri(), getShare());
      if (str != null) {
        parent = new CloudFileDirectory(PathUtility.appendPathToUri(share.getStorageUri(), str), getServiceClient().getCredentials());
      }
    }
    return parent;
  }
  
  public final FileProperties getProperties()
  {
    return properties;
  }
  
  public final CloudFileClient getServiceClient()
  {
    return fileServiceClient;
  }
  
  public final CloudFileShare getShare()
  {
    if (share == null) {
      share = new CloudFileShare(PathUtility.getShareURI(getStorageUri(), fileServiceClient.isUsePathStyleUris()), fileServiceClient.getCredentials());
    }
    return share;
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
    return fileServiceClient.getCredentials().transformUri(getStorageUri(), paramOperationContext);
  }
  
  public final URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  @DoesServiceRequest
  public final FileInputStream openRead()
  {
    return openRead(null, null, null);
  }
  
  @DoesServiceRequest
  public final FileInputStream openRead(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    return new FileInputStream(this, paramAccessCondition, FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient, false), localOperationContext);
  }
  
  @DoesServiceRequest
  public FileOutputStream openWriteExisting()
  {
    return openOutputStreamInternal(null, null, null, null);
  }
  
  @DoesServiceRequest
  public FileOutputStream openWriteExisting(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(null, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public FileOutputStream openWriteNew(long paramLong)
  {
    return openOutputStreamInternal(Long.valueOf(paramLong), null, null, null);
  }
  
  @DoesServiceRequest
  public FileOutputStream openWriteNew(long paramLong, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return openOutputStreamInternal(Long.valueOf(paramLong), paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  public void resize(long paramLong)
  {
    resize(paramLong, null, null, null);
  }
  
  public void resize(long paramLong, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, resizeImpl(paramLong, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public final void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public final void setProperties(FileProperties paramFileProperties)
  {
    properties = paramFileProperties;
  }
  
  public final void setShare(CloudFileShare paramCloudFileShare)
  {
    share = paramCloudFileShare;
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
  
  public void setStreamWriteSizeInBytes(int paramInt)
  {
    if ((paramInt <= Constants.MAX_FILE_WRITE_SIZE) && (paramInt >= Constants.MIN_PERMITTED_FILE_WRITE_SIZE))
    {
      streamWriteSizeInBytes = paramInt;
      return;
    }
    throw new IllegalArgumentException("StreamWriteSizeInBytes");
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudBlob paramCloudBlob)
  {
    return startCopy(paramCloudBlob, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudBlob paramCloudBlob, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceBlob", paramCloudBlob);
    URI localURI1 = paramCloudBlob.getSnapshotQualifiedUri();
    URI localURI2 = localURI1;
    if (paramCloudBlob.getServiceClient() != null)
    {
      localURI2 = localURI1;
      if (paramCloudBlob.getServiceClient().getCredentials() != null) {
        localURI2 = paramCloudBlob.getServiceClient().getCredentials().transformUri(paramCloudBlob.getSnapshotQualifiedUri());
      }
    }
    return startCopy(localURI2, paramAccessCondition1, paramAccessCondition2, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudFile paramCloudFile)
  {
    return startCopy(paramCloudFile, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(CloudFile paramCloudFile, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("sourceFile", paramCloudFile);
    return startCopy(paramCloudFile.getTransformedAddress(paramOperationContext).getPrimaryUri(), paramAccessCondition1, paramAccessCondition2, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final String startCopy(URI paramURI)
  {
    return startCopy(paramURI, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final String startCopy(URI paramURI, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return (String)ExecutionEngine.executeWithRetry(fileServiceClient, this, startCopyImpl(paramURI, paramAccessCondition1, paramAccessCondition2, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
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
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-content-length");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      getProperties().setLength(Long.parseLong(paramHttpURLConnection));
    }
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong)
  {
    upload(paramInputStream, paramLong, null, null, null);
  }
  
  @DoesServiceRequest
  public void upload(InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    if (paramLong >= 0L)
    {
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(268435456);
      }
      paramAccessCondition = openWriteNew(paramLong, paramAccessCondition, paramFileRequestOptions, localOperationContext);
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
    throw new IllegalArgumentException("File length must be greater than or equal to 0 bytes.");
  }
  
  public void uploadFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    uploadFromByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, null);
  }
  
  public void uploadFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, paramInt1, paramInt2);
    upload(paramArrayOfByte, paramInt2, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
    paramArrayOfByte.close();
  }
  
  public void uploadFromFile(String paramString)
  {
    uploadFromFile(paramString, null, null, null);
  }
  
  public void uploadFromFile(String paramString, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    paramString = new File(paramString);
    long l = paramString.length();
    paramString = new BufferedInputStream(new java.io.FileInputStream(paramString));
    upload(paramString, l, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
    paramString.close();
  }
  
  @DoesServiceRequest
  public final void uploadMetadata()
  {
    uploadMetadata(null, null, null);
  }
  
  @DoesServiceRequest
  public final void uploadMetadata(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, uploadMetadataImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void uploadProperties()
  {
    uploadProperties(null, null, null);
  }
  
  @DoesServiceRequest
  public final void uploadProperties(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, uploadPropertiesImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void uploadRange(InputStream paramInputStream, long paramLong1, long paramLong2)
  {
    uploadRange(paramInputStream, paramLong1, paramLong2, null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadRange(InputStream paramInputStream, long paramLong1, long paramLong2, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    FileRange localFileRange = new FileRange(paramLong1, paramLong1 + paramLong2 - 1L);
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
    if (paramFileRequestOptions.getUseTransactionalContentMD5().booleanValue()) {
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
    putRangeInternal(localFileRange, FileRangeOperationType.UPDATE, arrayOfByte, paramLong2, paramInputStream, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  public void uploadText(String paramString)
  {
    uploadText(paramString, null, null, null, null);
  }
  
  public void uploadText(String paramString1, String paramString2, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    if (paramString2 == null) {
      paramString1 = paramString1.getBytes();
    } else {
      paramString1 = paramString1.getBytes(paramString2);
    }
    uploadFromByteArray(paramString1, 0, paramString1.length, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */