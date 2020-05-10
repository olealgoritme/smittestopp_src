package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessPolicyHandler;
import com.microsoft.azure.storage.SharedAccessPolicySerializer;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.LazySegmentedIterable;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageCredentialsHelper;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.xml.stream.XMLStreamException;

public final class CloudBlobContainer
{
  public CloudBlobClient blobServiceClient;
  public HashMap<String, String> metadata = new HashMap();
  public String name;
  public BlobContainerProperties properties = new BlobContainerProperties();
  public StorageUri storageUri;
  
  public CloudBlobContainer(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudBlobContainer(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
  }
  
  public CloudBlobContainer(String paramString, CloudBlobClient paramCloudBlobClient)
  {
    Utility.assertNotNull("client", paramCloudBlobClient);
    Utility.assertNotNull("containerName", paramString);
    storageUri = PathUtility.appendPathToUri(paramCloudBlobClient.getStorageUri(), paramString);
    name = paramString;
    blobServiceClient = paramCloudBlobClient;
  }
  
  public CloudBlobContainer(URI paramURI)
  {
    this(new StorageUri(paramURI));
  }
  
  public CloudBlobContainer(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, String> acquireLeaseImpl(final Integer paramInteger, final String paramString, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.ACQUIRE, paramInteger, paramString, null);
      }
      
      public String preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        return BlobResponse.getLeaseID(getConnection());
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private final StorageRequest<CloudBlobClient, CloudBlobContainer, Long> breakLeaseImpl(final Integer paramInteger, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.BREAK, null, null, paramInteger);
      }
      
      public Long preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        int i = getResult().getStatusCode();
        long l = -1L;
        if (i != 202)
        {
          setNonExceptionedRetryableFailure(true);
          return Long.valueOf(-1L);
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        paramAnonymousCloudBlobContainer = BlobResponse.getLeaseTime(getConnection());
        if (!Utility.isNullOrEmpty(paramAnonymousCloudBlobContainer)) {
          l = Long.parseLong(paramAnonymousCloudBlobContainer);
        }
        return Long.valueOf(l);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private final StorageRequest<CloudBlobClient, CloudBlobContainer, String> changeLeaseImpl(final String paramString, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.CHANGE, null, paramString, null);
      }
      
      public String preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        return BlobResponse.getLeaseID(getConnection());
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> createImpl(final BlobRequestOptions paramBlobRequestOptions, final BlobContainerPublicAccessType paramBlobContainerPublicAccessType)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.createContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramBlobContainerPublicAccessType);
      }
      
      public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 201)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobClient = BlobResponse.getBlobContainerAttributes(getConnection(), paramAnonymousCloudBlobClient.isUsePathStyleUris());
        properties = paramAnonymousCloudBlobClient.getProperties();
        name = paramAnonymousCloudBlobClient.getName();
        paramAnonymousCloudBlobClient = paramBlobContainerPublicAccessType;
        if (paramAnonymousCloudBlobClient != null) {
          properties.setPublicAccess(paramAnonymousCloudBlobClient);
        } else {
          properties.setPublicAccess(BlobContainerPublicAccessType.OFF);
        }
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        BlobRequest.addMetadata(paramAnonymousHttpURLConnection, metadata, paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> deleteImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.deleteContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getPrimaryUri(), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
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
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> downloadAttributesImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getContainerProperties(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobClient = BlobResponse.getBlobContainerAttributes(getConnection(), paramAnonymousCloudBlobClient.isUsePathStyleUris());
        metadata = paramAnonymousCloudBlobClient.getMetadata();
        properties = paramAnonymousCloudBlobClient.getProperties();
        name = paramAnonymousCloudBlobClient.getName();
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
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, BlobContainerPermissions> downloadPermissionsImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getAcl(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAccessCondition, paramAnonymousOperationContext);
      }
      
      public BlobContainerPermissions postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, BlobContainerPermissions paramAnonymousBlobContainerPermissions)
      {
        paramAnonymousCloudBlobContainer = SharedAccessPolicyHandler.getAccessIdentifiers(getConnection().getInputStream(), SharedAccessBlobPolicy.class);
        paramAnonymousCloudBlobClient = paramAnonymousCloudBlobContainer.keySet().iterator();
        while (paramAnonymousCloudBlobClient.hasNext())
        {
          paramAnonymousHttpURLConnection = (String)paramAnonymousCloudBlobClient.next();
          paramAnonymousBlobContainerPermissions.getSharedAccessPolicies().put(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobContainer.get(paramAnonymousHttpURLConnection));
        }
        return paramAnonymousBlobContainerPermissions;
      }
      
      public BlobContainerPermissions preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        paramAnonymousCloudBlobClient = CloudBlobContainer.getContainerAcl(BlobResponse.getAcl(getConnection()));
        properties.setPublicAccess(paramAnonymousCloudBlobClient.getPublicAccess());
        return paramAnonymousCloudBlobClient;
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
  private boolean exists(boolean paramBoolean, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    return ((Boolean)ExecutionEngine.executeWithRetry(blobServiceClient, this, existsImpl(paramBoolean, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext)).booleanValue();
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Boolean> existsImpl(final boolean paramBoolean, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getContainerProperties(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Boolean preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() == 200)
        {
          paramAnonymousCloudBlobClient = BlobResponse.getBlobContainerAttributes(getConnection(), paramAnonymousCloudBlobClient.isUsePathStyleUris());
          metadata = paramAnonymousCloudBlobClient.getMetadata();
          properties = paramAnonymousCloudBlobClient.getProperties();
          name = paramAnonymousCloudBlobClient.getName();
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
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, CloudBlob> getBlobReferenceFromServerImpl(final String paramString1, final StorageUri paramStorageUri, final String paramString2, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.getBlobProperties(getServiceClient().getCredentials().transformUri(paramStorageUri, paramAnonymousOperationContext).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, paramString2);
      }
      
      public CloudBlob preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobClient = BlobResponse.getBlobAttributes(getConnection(), paramStorageUri, paramString2);
        int i = paramAnonymousCloudBlobClient.getProperties().getBlobType().ordinal();
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              paramAnonymousCloudBlobContainer = paramAnonymousCloudBlobContainer.getAppendBlobReference(paramString1, paramString2);
            } else {
              throw new StorageException("IncorrectBlobType", "The response received is invalid or improperly formatted.", 306, null, null);
            }
          }
          else {
            paramAnonymousCloudBlobContainer = paramAnonymousCloudBlobContainer.getPageBlobReference(paramString1, paramString2);
          }
        }
        else {
          paramAnonymousCloudBlobContainer = paramAnonymousCloudBlobContainer.getBlockBlobReference(paramString1, paramString2);
        }
        properties = paramAnonymousCloudBlobClient.getProperties();
        metadata = paramAnonymousCloudBlobClient.getMetadata();
        return paramAnonymousCloudBlobContainer;
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
  
  public static BlobContainerPermissions getContainerAcl(String paramString)
  {
    BlobContainerPublicAccessType localBlobContainerPublicAccessType = BlobContainerPublicAccessType.parse(paramString);
    paramString = new BlobContainerPermissions();
    paramString.setPublicAccess(localBlobContainerPublicAccessType);
    return paramString;
  }
  
  private String getSharedAccessCanonicalName()
  {
    return String.format("/%s/%s/%s", new Object[] { "blob", getServiceClient().getCredentials().getAccountName(), getName() });
  }
  
  private StorageUri getTransformedAddress()
  {
    return blobServiceClient.getCredentials().transformUri(storageUri);
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, ResultSegment<ListBlobItem>> listBlobsSegmentedImpl(final String paramString, boolean paramBoolean, EnumSet<BlobListingDetails> paramEnumSet, Integer paramInteger, final BlobRequestOptions paramBlobRequestOptions, final SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    Utility.assertContinuationType(paramSegmentedStorageRequest.getToken(), ResultContinuationType.BLOB);
    Utility.assertNotNull("options", paramBlobRequestOptions);
    String str;
    if (paramBoolean) {
      str = null;
    } else {
      str = blobServiceClient.getDirectoryDelimiter();
    }
    paramString = new BlobListingContext(paramString, paramInteger, str, paramEnumSet);
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        BlobListingContext localBlobListingContext = paramString;
        if (paramSegmentedStorageRequest.getToken() != null) {
          paramAnonymousCloudBlobClient = paramSegmentedStorageRequest.getToken().getNextMarker();
        } else {
          paramAnonymousCloudBlobClient = null;
        }
        localBlobListingContext.setMarker(paramAnonymousCloudBlobClient);
        return BlobRequest.listBlobs(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramString);
      }
      
      public ResultSegment<ListBlobItem> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, ResultSegment<ListBlobItem> paramAnonymousResultSegment)
      {
        paramAnonymousCloudBlobContainer = BlobListHandler.getBlobList(paramAnonymousHttpURLConnection.getInputStream(), paramAnonymousCloudBlobContainer);
        if (paramAnonymousCloudBlobContainer.getNextMarker() != null)
        {
          paramAnonymousHttpURLConnection = new ResultContinuation();
          paramAnonymousHttpURLConnection.setNextMarker(paramAnonymousCloudBlobContainer.getNextMarker());
          paramAnonymousHttpURLConnection.setContinuationType(ResultContinuationType.BLOB);
          paramAnonymousHttpURLConnection.setTargetLocation(getResult().getTargetLocation());
        }
        else
        {
          paramAnonymousHttpURLConnection = null;
        }
        paramAnonymousHttpURLConnection = new ResultSegment(paramAnonymousCloudBlobContainer.getResults(), paramAnonymousCloudBlobContainer.getMaxResults(), paramAnonymousHttpURLConnection);
        paramSegmentedStorageRequest.setToken(paramAnonymousHttpURLConnection.getContinuationToken());
        return paramAnonymousHttpURLConnection;
      }
      
      public ResultSegment<ListBlobItem> preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
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
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, -1L, paramAnonymousOperationContext);
      }
    };
  }
  
  private void parseQueryAndVerify(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("completeUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      storageUri = PathUtility.stripURIQueryAndFragment(paramStorageUri);
      paramStorageUri = SharedAccessSignatureHelper.parseQuery(paramStorageUri);
      if ((paramStorageCredentials != null) && (paramStorageUri != null)) {
        throw new IllegalArgumentException("Cannot provide credentials as part of the address and as constructor parameter. Either pass in the address or use a different constructor.");
      }
      try
      {
        boolean bool = Utility.determinePathStyleFromUri(storageUri.getPrimaryUri());
        CloudBlobClient localCloudBlobClient = new com/microsoft/azure/storage/blob/CloudBlobClient;
        StorageUri localStorageUri = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials != null) {
          paramStorageUri = paramStorageCredentials;
        }
        localCloudBlobClient.<init>(localStorageUri, paramStorageUri);
        blobServiceClient = localCloudBlobClient;
        name = PathUtility.getContainerNameFromUri(storageUri.getPrimaryUri(), bool);
        return;
      }
      catch (URISyntaxException paramStorageUri)
      {
        throw Utility.generateNewUnexpectedStorageException(paramStorageUri);
      }
    }
    throw new IllegalArgumentException(String.format("Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramStorageUri.toString() }));
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> releaseLeaseImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.RELEASE, null, null, null);
      }
      
      public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> renewLeaseImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.leaseContainer(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, LeaseAction.RENEW, null, null, null);
      }
      
      public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200)
        {
          setNonExceptionedRetryableFailure(true);
          return null;
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        return null;
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  @DoesServiceRequest
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> uploadMetadataImpl(final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BlobRequest.setContainerMetadata(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition);
      }
      
      public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        if (getResult().getStatusCode() != 200) {
          setNonExceptionedRetryableFailure(true);
        }
        paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
        return null;
      }
      
      public void setHeaders(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        BlobRequest.addMetadata(paramAnonymousHttpURLConnection, metadata, paramAnonymousOperationContext);
      }
      
      public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
      {
        StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, 0L, paramAnonymousOperationContext);
      }
    };
  }
  
  private StorageRequest<CloudBlobClient, CloudBlobContainer, Void> uploadPermissionsImpl(final BlobContainerPermissions paramBlobContainerPermissions, final AccessCondition paramAccessCondition, final BlobRequestOptions paramBlobRequestOptions)
  {
    try
    {
      final Object localObject = new java/io/StringWriter;
      ((StringWriter)localObject).<init>();
      SharedAccessPolicySerializer.writeSharedAccessIdentifiersToStream(paramBlobContainerPermissions.getSharedAccessPolicies(), (StringWriter)localObject);
      localObject = ((StringWriter)localObject).toString().getBytes("UTF-8");
      paramBlobContainerPermissions = new StorageRequest(paramBlobRequestOptions, getStorageUri())
      {
        public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
        {
          setSendStream(new ByteArrayInputStream(localObject));
          setLength(Long.valueOf(localObject.length));
          return BlobRequest.setAcl(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramAccessCondition, paramBlobContainerPermissions.getPublicAccess());
        }
        
        public Void preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
        {
          if (getResult().getStatusCode() != 200)
          {
            setNonExceptionedRetryableFailure(true);
            return null;
          }
          paramAnonymousCloudBlobContainer.updatePropertiesFromResponse(getConnection());
          paramAnonymousCloudBlobContainer.getProperties().setPublicAccess(paramBlobContainerPermissions.getPublicAccess());
          return null;
        }
        
        public void signRequest(HttpURLConnection paramAnonymousHttpURLConnection, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
        {
          StorageRequest.signBlobQueueAndFileRequest(paramAnonymousHttpURLConnection, paramAnonymousCloudBlobClient, localObject.length, paramAnonymousOperationContext);
        }
      };
      return paramBlobContainerPermissions;
    }
    catch (UnsupportedEncodingException paramBlobContainerPermissions)
    {
      throw StorageException.translateClientException(paramBlobContainerPermissions);
    }
    catch (XMLStreamException paramBlobContainerPermissions)
    {
      throw StorageException.translateClientException(paramBlobContainerPermissions);
    }
    catch (IllegalArgumentException paramBlobContainerPermissions)
    {
      throw StorageException.translateClientException(paramBlobContainerPermissions);
    }
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
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    return (String)ExecutionEngine.executeWithRetry(blobServiceClient, this, acquireLeaseImpl(paramInteger, paramString, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
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
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
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
    Utility.assertNotNull("proposedLeaseId", paramString);
    Utility.assertNotNull("accessCondition", paramAccessCondition);
    Utility.assertNotNullOrEmpty("leaseID", paramAccessCondition.getLeaseID());
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    return (String)ExecutionEngine.executeWithRetry(blobServiceClient, this, changeLeaseImpl(paramString, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void create()
  {
    create(BlobContainerPublicAccessType.OFF, null, null);
  }
  
  @DoesServiceRequest
  public void create(BlobContainerPublicAccessType paramBlobContainerPublicAccessType, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramBlobContainerPublicAccessType != BlobContainerPublicAccessType.UNKNOWN)
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
      ExecutionEngine.executeWithRetry(blobServiceClient, this, createImpl(paramBlobRequestOptions, paramBlobContainerPublicAccessType), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "accessType", paramBlobContainerPublicAccessType }));
  }
  
  @DoesServiceRequest
  public void create(BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    create(BlobContainerPublicAccessType.OFF, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists()
  {
    return createIfNotExists(BlobContainerPublicAccessType.OFF, null, null);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists(BlobContainerPublicAccessType paramBlobContainerPublicAccessType, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramBlobContainerPublicAccessType != BlobContainerPublicAccessType.UNKNOWN)
    {
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
      if (exists(true, null, paramBlobRequestOptions, paramOperationContext)) {
        return false;
      }
      try
      {
        create(paramBlobContainerPublicAccessType, paramBlobRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramBlobContainerPublicAccessType)
      {
        if ((paramBlobContainerPublicAccessType.getHttpStatusCode() == 409) && ("ContainerAlreadyExists".equals(paramBlobContainerPublicAccessType.getErrorCode()))) {
          return false;
        }
        throw paramBlobContainerPublicAccessType;
      }
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "accessType", paramBlobContainerPublicAccessType }));
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists(BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return createIfNotExists(BlobContainerPublicAccessType.OFF, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public void delete()
  {
    delete(null, null, null);
  }
  
  @DoesServiceRequest
  public void delete(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, deleteImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists()
  {
    return deleteIfExists(null, null, null);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    if (exists(true, paramAccessCondition, paramBlobRequestOptions, paramOperationContext)) {
      try
      {
        delete(paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramAccessCondition)
      {
        if ((paramAccessCondition.getHttpStatusCode() == 404) && ("ContainerNotFound".equals(paramAccessCondition.getErrorCode()))) {
          return false;
        }
        throw paramAccessCondition;
      }
    }
    return false;
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
  
  public StorageRequest<ServiceClient, CloudBlobContainer, AccountInformation> downloadAccountInformationImpl(final RequestOptions paramRequestOptions)
  {
    new StorageRequest(paramRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(ServiceClient paramAnonymousServiceClient, CloudBlobContainer paramAnonymousCloudBlobContainer, OperationContext paramAnonymousOperationContext)
      {
        return BaseRequest.getAccountInfo(CloudBlobContainer.access$000(paramAnonymousCloudBlobContainer).getUri(getCurrentLocation()), paramRequestOptions, null, paramAnonymousOperationContext);
      }
      
      public AccountInformation preProcessResponse(CloudBlobContainer paramAnonymousCloudBlobContainer, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
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
  public void downloadAttributes()
  {
    downloadAttributes(null, null, null);
  }
  
  @DoesServiceRequest
  public void downloadAttributes(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadAttributesImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public BlobContainerPermissions downloadPermissions()
  {
    return downloadPermissions(null, null, null);
  }
  
  @DoesServiceRequest
  public BlobContainerPermissions downloadPermissions(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    return (BlobContainerPermissions)ExecutionEngine.executeWithRetry(blobServiceClient, this, downloadPermissionsImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean exists()
  {
    return exists(null, null, null);
  }
  
  @DoesServiceRequest
  public boolean exists(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return exists(false, paramAccessCondition, paramBlobRequestOptions, paramOperationContext);
  }
  
  public String generateSharedAccessSignature(SharedAccessBlobPolicy paramSharedAccessBlobPolicy, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessBlobPolicy, paramString, null, null);
  }
  
  public String generateSharedAccessSignature(SharedAccessBlobPolicy paramSharedAccessBlobPolicy, String paramString, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(blobServiceClient.getCredentials())) {
      return SharedAccessSignatureHelper.generateSharedAccessSignatureForBlobAndFile(paramSharedAccessBlobPolicy, null, paramString, "c", paramIPRange, paramSharedAccessProtocols, SharedAccessSignatureHelper.generateSharedAccessSignatureHashForBlobAndFile(paramSharedAccessBlobPolicy, null, paramString, getSharedAccessCanonicalName(), paramIPRange, paramSharedAccessProtocols, blobServiceClient)).toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public CloudAppendBlob getAppendBlobReference(String paramString)
  {
    return getAppendBlobReference(paramString, null);
  }
  
  public CloudAppendBlob getAppendBlobReference(String paramString1, String paramString2)
  {
    return new CloudAppendBlob(paramString1, paramString2, this);
  }
  
  @DoesServiceRequest
  public final CloudBlob getBlobReferenceFromServer(String paramString)
  {
    return getBlobReferenceFromServer(paramString, null, null, null, null);
  }
  
  @DoesServiceRequest
  public final CloudBlob getBlobReferenceFromServer(String paramString1, String paramString2, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    paramOperationContext = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    paramBlobRequestOptions = PathUtility.appendPathToUri(getStorageUri(), paramString1);
    return (CloudBlob)ExecutionEngine.executeWithRetry(blobServiceClient, this, getBlobReferenceFromServerImpl(paramString1, paramBlobRequestOptions, paramString2, paramAccessCondition, paramOperationContext), paramOperationContext.getRetryPolicyFactory(), localOperationContext);
  }
  
  public CloudBlockBlob getBlockBlobReference(String paramString)
  {
    return getBlockBlobReference(paramString, null);
  }
  
  public CloudBlockBlob getBlockBlobReference(String paramString1, String paramString2)
  {
    return new CloudBlockBlob(paramString1, paramString2, this);
  }
  
  public CloudBlobDirectory getDirectoryReference(String paramString)
  {
    Utility.assertNotNull("directoryName", paramString);
    String str = paramString;
    if (!paramString.isEmpty())
    {
      str = paramString;
      if (!paramString.endsWith(blobServiceClient.getDirectoryDelimiter())) {
        str = paramString.concat(blobServiceClient.getDirectoryDelimiter());
      }
    }
    return new CloudBlobDirectory(PathUtility.appendPathToUri(storageUri, str), str, blobServiceClient, this);
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CloudPageBlob getPageBlobReference(String paramString)
  {
    return getPageBlobReference(paramString, null);
  }
  
  public CloudPageBlob getPageBlobReference(String paramString1, String paramString2)
  {
    return new CloudPageBlob(paramString1, paramString2, this);
  }
  
  public BlobContainerProperties getProperties()
  {
    return properties;
  }
  
  public CloudBlobClient getServiceClient()
  {
    return blobServiceClient;
  }
  
  public StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  @DoesServiceRequest
  public Iterable<ListBlobItem> listBlobs()
  {
    return listBlobs(null, false, EnumSet.noneOf(BlobListingDetails.class), null, null);
  }
  
  @DoesServiceRequest
  public Iterable<ListBlobItem> listBlobs(String paramString)
  {
    return listBlobs(paramString, false);
  }
  
  @DoesServiceRequest
  public Iterable<ListBlobItem> listBlobs(String paramString, boolean paramBoolean)
  {
    return listBlobs(paramString, paramBoolean, EnumSet.noneOf(BlobListingDetails.class), null, null);
  }
  
  @DoesServiceRequest
  public Iterable<ListBlobItem> listBlobs(String paramString, boolean paramBoolean, EnumSet<BlobListingDetails> paramEnumSet, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    if ((!paramBoolean) && (paramEnumSet != null) && (paramEnumSet.contains(BlobListingDetails.SNAPSHOTS))) {
      throw new IllegalArgumentException("Listing snapshots is only supported in flat mode (no delimiter). Consider setting useFlatBlobListing to true.");
    }
    return new LazySegmentedIterable(listBlobsSegmentedImpl(paramString, paramBoolean, paramEnumSet, null, paramBlobRequestOptions, new SegmentedStorageRequest()), blobServiceClient, this, paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListBlobItem> listBlobsSegmented()
  {
    return listBlobsSegmented(null, false, EnumSet.noneOf(BlobListingDetails.class), null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListBlobItem> listBlobsSegmented(String paramString)
  {
    return listBlobsSegmented(paramString, false, EnumSet.noneOf(BlobListingDetails.class), null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListBlobItem> listBlobsSegmented(String paramString, boolean paramBoolean, EnumSet<BlobListingDetails> paramEnumSet, Integer paramInteger, ResultContinuation paramResultContinuation, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    Utility.assertContinuationType(paramResultContinuation, ResultContinuationType.BLOB);
    if ((!paramBoolean) && (paramEnumSet != null) && (paramEnumSet.contains(BlobListingDetails.SNAPSHOTS))) {
      throw new IllegalArgumentException("Listing snapshots is only supported in flat mode (no delimiter). Consider setting useFlatBlobListing to true.");
    }
    SegmentedStorageRequest localSegmentedStorageRequest = new SegmentedStorageRequest();
    localSegmentedStorageRequest.setToken(paramResultContinuation);
    return (ResultSegment)ExecutionEngine.executeWithRetry(blobServiceClient, this, listBlobsSegmentedImpl(paramString, paramBoolean, paramEnumSet, paramInteger, paramBlobRequestOptions, localSegmentedStorageRequest), paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  @DoesServiceRequest
  public Iterable<CloudBlobContainer> listContainers()
  {
    return blobServiceClient.listContainers();
  }
  
  @DoesServiceRequest
  public Iterable<CloudBlobContainer> listContainers(String paramString)
  {
    return blobServiceClient.listContainers(paramString);
  }
  
  @DoesServiceRequest
  public Iterable<CloudBlobContainer> listContainers(String paramString, ContainerListingDetails paramContainerListingDetails, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return blobServiceClient.listContainers(paramString, paramContainerListingDetails, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudBlobContainer> listContainersSegmented()
  {
    return blobServiceClient.listContainersSegmented();
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudBlobContainer> listContainersSegmented(String paramString)
  {
    return blobServiceClient.listContainersSegmented(paramString);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudBlobContainer> listContainersSegmented(String paramString, ContainerListingDetails paramContainerListingDetails, Integer paramInteger, ResultContinuation paramResultContinuation, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return blobServiceClient.listContainersSegmented(paramString, paramContainerListingDetails, paramInteger, paramResultContinuation, paramBlobRequestOptions, paramOperationContext);
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
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
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
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, renewLeaseImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public void setProperties(BlobContainerProperties paramBlobContainerProperties)
  {
    properties = paramBlobContainerProperties;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
  
  public void updatePropertiesFromResponse(HttpURLConnection paramHttpURLConnection)
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
  
  @DoesServiceRequest
  public void uploadMetadata()
  {
    uploadMetadata(null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadMetadata(AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
    ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadMetadataImpl(paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(BlobContainerPermissions paramBlobContainerPermissions)
  {
    uploadPermissions(paramBlobContainerPermissions, null, null, null);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(BlobContainerPermissions paramBlobContainerPermissions, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramBlobContainerPermissions.getPublicAccess() != BlobContainerPublicAccessType.UNKNOWN)
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, blobServiceClient);
      ExecutionEngine.executeWithRetry(blobServiceClient, this, uploadPermissionsImpl(paramBlobContainerPermissions, paramAccessCondition, paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "accessType", paramBlobContainerPermissions.getPublicAccess() }));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */