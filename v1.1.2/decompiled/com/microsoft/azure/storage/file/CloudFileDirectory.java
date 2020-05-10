package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsSharedAccessSignature;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.LazySegmentedIterable;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public final class CloudFileDirectory
  implements ListFileItem
{
  public CloudFileClient fileServiceClient;
  public HashMap<String, String> metadata = new HashMap();
  public String name;
  public CloudFileDirectory parent;
  public FileDirectoryProperties properties = new FileDirectoryProperties();
  public CloudFileShare share;
  public StorageUri storageUri;
  
  public CloudFileDirectory(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudFileDirectory(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
  }
  
  public CloudFileDirectory(StorageUri paramStorageUri, String paramString, CloudFileShare paramCloudFileShare)
  {
    Utility.assertNotNull("uri", paramStorageUri);
    Utility.assertNotNull("directoryName", paramString);
    Utility.assertNotNull("share", paramCloudFileShare);
    name = paramString;
    fileServiceClient = paramCloudFileShare.getServiceClient();
    share = paramCloudFileShare;
    storageUri = paramStorageUri;
  }
  
  public CloudFileDirectory(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudFileDirectory(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private StorageRequest<CloudFileClient, CloudFileDirectory, Void> createDirectoryImpl(final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.createDirectory(CloudFileDirectory.access$000(paramAnonymousCloudFileDirectory).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext);
      }
      
      public Void preProcessResponse(CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFileDirectory.setProperties(FileResponse.getFileDirectoryAttributes(getConnection(), paramAnonymousCloudFileClient.isUsePathStyleUris()).getProperties());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        FileRequest.addMetadata(paramAnonymousHttpURLConnection, paramAnonymousCloudFileDirectory.getMetadata(), paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudFileClient, CloudFileDirectory, Void> deleteDirectoryImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.deleteDirectory(CloudFileDirectory.access$000(paramAnonymousCloudFileDirectory).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
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
  
  private StorageRequest<CloudFileClient, CloudFileDirectory, Void> downloadAttributesImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.getDirectoryProperties(CloudFileDirectory.access$000(paramAnonymousCloudFileDirectory).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, getSharesnapshotID);
      }
      
      public Void preProcessResponse(CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudFileClient = FileResponse.getFileDirectoryAttributes(getConnection(), paramAnonymousCloudFileClient.isUsePathStyleUris());
        paramAnonymousCloudFileDirectory.setMetadata(paramAnonymousCloudFileClient.getMetadata());
        paramAnonymousCloudFileDirectory.setProperties(paramAnonymousCloudFileClient.getProperties());
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
  private boolean exists(boolean paramBoolean, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return ((Boolean)ExecutionEngine.executeWithRetry(fileServiceClient, this, existsImpl(paramBoolean, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext)).booleanValue();
  }
  
  private StorageRequest<CloudFileClient, CloudFileDirectory, Boolean> existsImpl(final boolean paramBoolean, final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.getDirectoryProperties(CloudFileDirectory.access$000(paramAnonymousCloudFileDirectory).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition, getSharesnapshotID);
      }
      
      public Boolean preProcessResponse(CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() == 200)
        {
          CloudFileDirectory.access$100(paramAnonymousCloudFileDirectory, getConnection());
          paramAnonymousCloudFileClient = FileResponse.getFileDirectoryAttributes(getConnection(), paramAnonymousCloudFileClient.isUsePathStyleUris());
          paramAnonymousCloudFileDirectory.setMetadata(paramAnonymousCloudFileClient.getMetadata());
          paramAnonymousCloudFileDirectory.setProperties(paramAnonymousCloudFileClient.getProperties());
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
  
  private StorageUri getTransformedAddress()
  {
    return fileServiceClient.getCredentials().transformUri(storageUri);
  }
  
  private StorageRequest<CloudFileClient, CloudFileDirectory, ResultSegment<ListFileItem>> listFilesAndDirectoriesSegmentedImpl(final String paramString, Integer paramInteger, final FileRequestOptions paramFileRequestOptions, final SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    Utility.assertContinuationType(paramSegmentedStorageRequest.getToken(), ResultContinuationType.FILE);
    paramString = new ListingContext(paramString, paramInteger);
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        ListingContext localListingContext = paramString;
        if (paramSegmentedStorageRequest.getToken() != null) {
          paramAnonymousCloudFileClient = paramSegmentedStorageRequest.getToken().getNextMarker();
        } else {
          paramAnonymousCloudFileClient = null;
        }
        localListingContext.setMarker(paramAnonymousCloudFileClient);
        return FileRequest.listFilesAndDirectories(CloudFileDirectory.access$000(paramAnonymousCloudFileDirectory).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramString, getSharesnapshotID);
      }
      
      public ResultSegment<ListFileItem> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext, ResultSegment<ListFileItem> paramAnonymousResultSegment)
      {
        paramAnonymousCloudFileDirectory = FileListHandler.getFileAndDirectoryList(getConnection().getInputStream(), paramAnonymousCloudFileDirectory);
        if (paramAnonymousCloudFileDirectory.getNextMarker() != null)
        {
          paramAnonymousHttpURLConnection = new ResultContinuation();
          paramAnonymousHttpURLConnection.setNextMarker(paramAnonymousCloudFileDirectory.getNextMarker());
          paramAnonymousHttpURLConnection.setContinuationType(ResultContinuationType.FILE);
          paramAnonymousHttpURLConnection.setTargetLocation(getResult().getTargetLocation());
        }
        else
        {
          paramAnonymousHttpURLConnection = null;
        }
        paramAnonymousHttpURLConnection = new ResultSegment(paramAnonymousCloudFileDirectory.getResults(), paramAnonymousCloudFileDirectory.getMaxResults(), paramAnonymousHttpURLConnection);
        paramSegmentedStorageRequest.setToken(paramAnonymousHttpURLConnection.getContinuationToken());
        return paramAnonymousHttpURLConnection;
      }
      
      public ResultSegment<ListFileItem> preProcessResponse(CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        return null;
      }
      
      public void setRequestLocationMode()
      {
        setRequestLocationMode(Utility.getListingLocationMode(paramSegmentedStorageRequest.getToken()));
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, -1L, paramAnonymousOperationContext);
      }
    };
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
        name = PathUtility.getDirectoryNameFromURI(storageUri.getPrimaryUri(), bool);
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
  
  private void updatePropertiesFromResponse(HttpURLConnection paramHttpURLConnection)
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
  
  private StorageRequest<CloudFileClient, CloudFileDirectory, Void> uploadMetadataImpl(final AccessCondition paramAccessCondition, final FileRequestOptions paramFileRequestOptions)
  {
    new StorageRequest(paramFileRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudFileClient paramAnonymousCloudFileClient, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        return FileRequest.setDirectoryMetadata(CloudFileDirectory.access$000(paramAnonymousCloudFileDirectory).getUri(getCurrentLocation()), paramFileRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudFileDirectory paramAnonymousCloudFileDirectory, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        CloudFileDirectory.access$100(paramAnonymousCloudFileDirectory, getConnection());
        getResult().setRequestServiceEncrypted(BaseResponse.isServerRequestEncrypted(getConnection()));
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileDirectory paramAnonymousCloudFileDirectory, OperationContext paramAnonymousOperationContext)
      {
        FileRequest.addMetadata(paramAnonymousHttpURLConnection, paramAnonymousCloudFileDirectory.getMetadata(), paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudFileClient paramAnonymousCloudFileClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudFileClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  public void create()
  {
    create(null, null);
  }
  
  @DoesServiceRequest
  public void create(FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, createDirectoryImpl(paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists()
  {
    return createIfNotExists(null, null);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists(FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    getShare().assertNoSnapshot();
    if (exists(true, null, paramFileRequestOptions, paramOperationContext)) {
      return false;
    }
    try
    {
      create(paramFileRequestOptions, paramOperationContext);
      return true;
    }
    catch (StorageException paramFileRequestOptions)
    {
      if ((paramFileRequestOptions.getHttpStatusCode() == 409) && ("ResourceAlreadyExists".equals(paramFileRequestOptions.getErrorCode()))) {
        return false;
      }
      throw paramFileRequestOptions;
    }
  }
  
  @DoesServiceRequest
  public void delete()
  {
    delete(null, null, null);
  }
  
  @DoesServiceRequest
  public void delete(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    getShare().assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, deleteDirectoryImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists()
  {
    return deleteIfExists(null, null, null);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
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
  public void downloadAttributes()
  {
    downloadAttributes(null, null, null);
  }
  
  @DoesServiceRequest
  public void downloadAttributes(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadAttributesImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean exists()
  {
    return exists(null, null, null);
  }
  
  @DoesServiceRequest
  public boolean exists(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return exists(false, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  public CloudFileDirectory getDirectoryReference(String paramString)
  {
    Utility.assertNotNullOrEmpty("itemName", paramString);
    return new CloudFileDirectory(PathUtility.appendPathToUri(storageUri, paramString), paramString, getShare());
  }
  
  public CloudFile getFileReference(String paramString)
  {
    Utility.assertNotNullOrEmpty("fileName", paramString);
    return new CloudFile(PathUtility.appendPathToUri(storageUri, paramString), paramString, getShare());
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CloudFileDirectory getParent()
  {
    if (parent == null)
    {
      String str = CloudFile.getParentNameFromURI(getStorageUri(), getShare());
      if (str != null) {
        parent = new CloudFileDirectory(PathUtility.appendPathToUri(getShare().getStorageUri(), str), getServiceClient().getCredentials());
      }
    }
    return parent;
  }
  
  public FileDirectoryProperties getProperties()
  {
    return properties;
  }
  
  public CloudFileClient getServiceClient()
  {
    return fileServiceClient;
  }
  
  public CloudFileShare getShare()
  {
    if (share == null) {
      share = fileServiceClient.getShareReference(PathUtility.getShareNameFromUri(getUri(), fileServiceClient.isUsePathStyleUris()));
    }
    return share;
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  @DoesServiceRequest
  public Iterable<ListFileItem> listFilesAndDirectories()
  {
    return listFilesAndDirectories(null, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<ListFileItem> listFilesAndDirectories(FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return listFilesAndDirectories(null, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public Iterable<ListFileItem> listFilesAndDirectories(String paramString, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return new LazySegmentedIterable(listFilesAndDirectoriesSegmentedImpl(paramString, null, paramFileRequestOptions, new SegmentedStorageRequest()), fileServiceClient, this, paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListFileItem> listFilesAndDirectoriesSegmented()
  {
    return listFilesAndDirectoriesSegmented(null, null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListFileItem> listFilesAndDirectoriesSegmented(Integer paramInteger, ResultContinuation paramResultContinuation, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return listFilesAndDirectoriesSegmented(null, paramInteger, paramResultContinuation, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListFileItem> listFilesAndDirectoriesSegmented(String paramString, Integer paramInteger, ResultContinuation paramResultContinuation, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    Utility.assertContinuationType(paramResultContinuation, ResultContinuationType.FILE);
    paramOperationContext = new SegmentedStorageRequest();
    paramOperationContext.setToken(paramResultContinuation);
    return (ResultSegment)ExecutionEngine.executeWithRetry(fileServiceClient, this, listFilesAndDirectoriesSegmentedImpl(paramString, paramInteger, paramFileRequestOptions, paramOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public final void setProperties(FileDirectoryProperties paramFileDirectoryProperties)
  {
    properties = paramFileDirectoryProperties;
  }
  
  public final void setShare(CloudFileShare paramCloudFileShare)
  {
    share = paramCloudFileShare;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
  
  @DoesServiceRequest
  public void uploadMetadata()
  {
    uploadMetadata(null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadMetadata(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
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
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileDirectory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */