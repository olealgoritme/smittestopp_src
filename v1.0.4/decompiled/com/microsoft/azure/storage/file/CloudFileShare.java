package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessPolicySerializer;
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
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.xml.stream.XMLStreamException;

public final class CloudFileShare
{
  public CloudFileClient fileServiceClient;
  public HashMap<String, String> metadata = new HashMap();
  public String name = null;
  public FileShareProperties properties = new FileShareProperties();
  public String snapshotID;
  public StorageUri storageUri;
  
  public CloudFileShare(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudFileShare(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
  }
  
  public CloudFileShare(String paramString1, String paramString2, CloudFileClient paramCloudFileClient)
  {
    Utility.assertNotNull("client", paramCloudFileClient);
    Utility.assertNotNull("shareName", paramString1);
    storageUri = PathUtility.appendPathToUri(paramCloudFileClient.getStorageUri(), paramString1);
    name = paramString1;
    snapshotID = paramString2;
    fileServiceClient = paramCloudFileClient;
  }
  
  public CloudFileShare(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudFileShare(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, Void> createImpl(FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.1(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions);
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, CloudFileShare> createSnapshotImpl(HashMap<String, String> paramHashMap, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.5(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions, paramAccessCondition, paramHashMap);
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, Void> deleteImpl(DeleteShareSnapshotsOption paramDeleteShareSnapshotsOption, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.2(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions, paramAccessCondition, paramDeleteShareSnapshotsOption);
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, Void> downloadAttributesImpl(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.3(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions, paramAccessCondition);
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, FileSharePermissions> downloadPermissionsImpl(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.4(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions, paramAccessCondition);
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
  
  private StorageRequest<CloudFileClient, CloudFileShare, Boolean> existsImpl(boolean paramBoolean, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.7(this, paramFileRequestOptions, getStorageUri(), paramBoolean, paramFileRequestOptions, paramAccessCondition);
  }
  
  private String getSharedAccessCanonicalName()
  {
    return String.format("/%s/%s/%s", new Object[] { "file", getServiceClient().getCredentials().getAccountName(), getName() });
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, ShareStats> getStatsImpl(FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.6(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions);
  }
  
  private StorageUri getTransformedAddress()
  {
    return fileServiceClient.getCredentials().transformUri(storageUri);
  }
  
  private void parseQueryAndVerify(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("completeUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      storageUri = PathUtility.stripURIQueryAndFragment(paramStorageUri);
      Object localObject = (String[])PathUtility.parseQueryString(paramStorageUri.getQuery()).get("sharesnapshot");
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
        CloudFileClient localCloudFileClient = new com/microsoft/azure/storage/file/CloudFileClient;
        localObject = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials == null) {
          paramStorageCredentials = paramStorageUri;
        }
        localCloudFileClient.<init>((StorageUri)localObject, paramStorageCredentials);
        fileServiceClient = localCloudFileClient;
        name = PathUtility.getShareNameFromUri(storageUri.getPrimaryUri(), bool);
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
    if (getProperties() == null) {
      properties = new FileShareProperties();
    }
    getProperties().setEtag(paramHttpURLConnection.getHeaderField("ETag"));
    if (0L != paramHttpURLConnection.getLastModified())
    {
      Calendar localCalendar = Calendar.getInstance(Utility.LOCALE_US);
      localCalendar.setTimeZone(Utility.UTC_ZONE);
      localCalendar.setTime(new Date(paramHttpURLConnection.getLastModified()));
      getProperties().setLastModified(localCalendar.getTime());
    }
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, Void> uploadMetadataImpl(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.8(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions, paramAccessCondition);
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, Void> uploadPermissionsImpl(FileSharePermissions paramFileSharePermissions, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    try
    {
      StringWriter localStringWriter = new java/io/StringWriter;
      localStringWriter.<init>();
      SharedAccessPolicySerializer.writeSharedAccessIdentifiersToStream(paramFileSharePermissions.getSharedAccessPolicies(), localStringWriter);
      paramFileSharePermissions = localStringWriter.toString().getBytes("UTF-8");
      paramFileSharePermissions = new CloudFileShare.10(this, paramFileRequestOptions, getStorageUri(), paramFileSharePermissions, paramFileRequestOptions, paramAccessCondition);
      return paramFileSharePermissions;
    }
    catch (UnsupportedEncodingException paramFileSharePermissions)
    {
      throw StorageException.translateException(null, paramFileSharePermissions, null);
    }
    catch (XMLStreamException paramFileSharePermissions)
    {
      throw StorageException.translateException(null, paramFileSharePermissions, null);
    }
    catch (IllegalArgumentException paramFileSharePermissions)
    {
      throw StorageException.translateException(null, paramFileSharePermissions, null);
    }
  }
  
  private StorageRequest<CloudFileClient, CloudFileShare, Void> uploadPropertiesImpl(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions)
  {
    return new CloudFileShare.9(this, paramFileRequestOptions, getStorageUri(), paramFileRequestOptions, paramAccessCondition);
  }
  
  public void assertNoSnapshot()
  {
    if (!isSnapshot()) {
      return;
    }
    throw new IllegalArgumentException("Cannot perform this operation on a share representing a snapshot.");
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
    assertNoSnapshot();
    paramOperationContext = properties;
    if ((paramOperationContext != null) && (paramOperationContext.getShareQuota() != null)) {
      Utility.assertInBounds("Share Quota", properties.getShareQuota().intValue(), 1L, 5120L);
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, createImpl(paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
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
      if ((paramFileRequestOptions.getHttpStatusCode() == 409) && ("ShareAlreadyExists".equals(paramFileRequestOptions.getErrorCode()))) {
        return false;
      }
      throw paramFileRequestOptions;
    }
  }
  
  @DoesServiceRequest
  public final CloudFileShare createSnapshot()
  {
    return createSnapshot(null, null, null, null);
  }
  
  @DoesServiceRequest
  public final CloudFileShare createSnapshot(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return createSnapshot(null, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public final CloudFileShare createSnapshot(HashMap<String, String> paramHashMap, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    assertNoSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return (CloudFileShare)ExecutionEngine.executeWithRetry(fileServiceClient, this, createSnapshotImpl(paramHashMap, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void delete()
  {
    delete(DeleteShareSnapshotsOption.NONE, null, null, null);
  }
  
  @DoesServiceRequest
  public void delete(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    delete(DeleteShareSnapshotsOption.NONE, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void delete(DeleteShareSnapshotsOption paramDeleteShareSnapshotsOption, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, deleteImpl(paramDeleteShareSnapshotsOption, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists()
  {
    return deleteIfExists(DeleteShareSnapshotsOption.NONE, null, null, null);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return deleteIfExists(DeleteShareSnapshotsOption.NONE, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists(DeleteShareSnapshotsOption paramDeleteShareSnapshotsOption, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    if (exists(true, paramAccessCondition, paramFileRequestOptions, paramOperationContext)) {
      try
      {
        delete(paramDeleteShareSnapshotsOption, paramAccessCondition, paramFileRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramDeleteShareSnapshotsOption)
      {
        if ((paramDeleteShareSnapshotsOption.getHttpStatusCode() == 404) && ("ShareNotFound".equals(paramDeleteShareSnapshotsOption.getErrorCode()))) {
          return false;
        }
        throw paramDeleteShareSnapshotsOption;
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
  public FileSharePermissions downloadPermissions()
  {
    return downloadPermissions(null, null, null);
  }
  
  @DoesServiceRequest
  public FileSharePermissions downloadPermissions(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return (FileSharePermissions)ExecutionEngine.executeWithRetry(fileServiceClient, this, downloadPermissionsImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
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
  
  public String generateSharedAccessSignature(SharedAccessFilePolicy paramSharedAccessFilePolicy, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessFilePolicy, paramString, null, null);
  }
  
  public String generateSharedAccessSignature(SharedAccessFilePolicy paramSharedAccessFilePolicy, String paramString, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(fileServiceClient.getCredentials())) {
      return SharedAccessSignatureHelper.generateSharedAccessSignatureForBlobAndFile(paramSharedAccessFilePolicy, null, paramString, "s", paramIPRange, paramSharedAccessProtocols, SharedAccessSignatureHelper.generateSharedAccessSignatureHashForBlobAndFile(paramSharedAccessFilePolicy, null, paramString, getSharedAccessCanonicalName(), paramIPRange, paramSharedAccessProtocols, fileServiceClient)).toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public FileShareProperties getProperties()
  {
    return properties;
  }
  
  public final URI getQualifiedUri()
  {
    if (isSnapshot()) {
      return PathUtility.addToQuery(getUri(), String.format("sharesnapshot=%s", new Object[] { snapshotID }));
    }
    return fileServiceClient.getCredentials().transformUri(getUri());
  }
  
  public CloudFileDirectory getRootDirectoryReference()
  {
    return new CloudFileDirectory(storageUri, "", this);
  }
  
  public CloudFileClient getServiceClient()
  {
    return fileServiceClient;
  }
  
  public final String getSnapshot()
  {
    return snapshotID;
  }
  
  @DoesServiceRequest
  public ShareStats getStats()
  {
    return getStats(null, null);
  }
  
  @DoesServiceRequest
  public ShareStats getStats(FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    assertNoSnapshot();
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    return (ShareStats)ExecutionEngine.executeWithRetry(fileServiceClient, this, getStatsImpl(paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public URI getUri()
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
  
  public void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public void setProperties(FileShareProperties paramFileShareProperties)
  {
    properties = paramFileShareProperties;
  }
  
  @DoesServiceRequest
  public void uploadMetadata()
  {
    uploadMetadata(null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadMetadata(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    assertNoSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, uploadMetadataImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(FileSharePermissions paramFileSharePermissions)
  {
    uploadPermissions(paramFileSharePermissions, null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(FileSharePermissions paramFileSharePermissions, AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    assertNoSnapshot();
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, uploadPermissionsImpl(paramFileSharePermissions, paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public final void uploadProperties()
  {
    uploadProperties(null, null, null);
  }
  
  @DoesServiceRequest
  public final void uploadProperties(AccessCondition paramAccessCondition, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    assertNoSnapshot();
    Object localObject = properties;
    if ((localObject != null) && (((FileShareProperties)localObject).getShareQuota() != null)) {
      Utility.assertInBounds("Share Quota", properties.getShareQuota().intValue(), 1L, 5120L);
    }
    localObject = paramOperationContext;
    if (paramOperationContext == null) {
      localObject = new OperationContext();
    }
    ((OperationContext)localObject).initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, fileServiceClient);
    ExecutionEngine.executeWithRetry(fileServiceClient, this, uploadPropertiesImpl(paramAccessCondition, paramFileRequestOptions), paramFileRequestOptions.getRetryPolicyFactory(), (OperationContext)localObject);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileShare
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */