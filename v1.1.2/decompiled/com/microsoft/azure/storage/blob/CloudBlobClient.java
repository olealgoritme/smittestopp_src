package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.DeleteRetentionPolicy;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.ServiceProperties;
import com.microsoft.azure.storage.ServiceStats;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.LazySegmentedIterable;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.net.URI;

public final class CloudBlobClient
  extends ServiceClient
{
  public BlobRequestOptions defaultRequestOptions;
  public String directoryDelimiter = "/";
  
  public CloudBlobClient(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudBlobClient(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    super(paramStorageUri, paramStorageCredentials);
    paramStorageUri = new BlobRequestOptions();
    defaultRequestOptions = paramStorageUri;
    BlobRequestOptions.applyDefaults(paramStorageUri, BlobType.UNSPECIFIED);
  }
  
  public CloudBlobClient(URI paramURI)
  {
    this(new StorageUri(paramURI), null);
  }
  
  public CloudBlobClient(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private Iterable<CloudBlobContainer> listContainersWithPrefix(String paramString, ContainerListingDetails paramContainerListingDetails, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, this);
    return new LazySegmentedIterable(listContainersWithPrefixSegmentedImpl(paramString, paramContainerListingDetails, null, paramBlobRequestOptions, new SegmentedStorageRequest()), this, null, paramBlobRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private ResultSegment<CloudBlobContainer> listContainersWithPrefixSegmented(String paramString, ContainerListingDetails paramContainerListingDetails, Integer paramInteger, ResultContinuation paramResultContinuation, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, this);
    Utility.assertContinuationType(paramResultContinuation, ResultContinuationType.CONTAINER);
    paramBlobRequestOptions = new SegmentedStorageRequest();
    paramBlobRequestOptions.setToken(paramResultContinuation);
    return (ResultSegment)ExecutionEngine.executeWithRetry(this, null, listContainersWithPrefixSegmentedImpl(paramString, paramContainerListingDetails, paramInteger, paramOperationContext, paramBlobRequestOptions), paramOperationContext.getRetryPolicyFactory(), localOperationContext);
  }
  
  private StorageRequest<CloudBlobClient, Void, ResultSegment<CloudBlobContainer>> listContainersWithPrefixSegmentedImpl(final String paramString, final ContainerListingDetails paramContainerListingDetails, Integer paramInteger, final BlobRequestOptions paramBlobRequestOptions, final SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    Utility.assertContinuationType(paramSegmentedStorageRequest.getToken(), ResultContinuationType.CONTAINER);
    paramString = new ListingContext(paramString, paramInteger);
    new StorageRequest(paramBlobRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(CloudBlobClient paramAnonymousCloudBlobClient, Void paramAnonymousVoid, OperationContext paramAnonymousOperationContext)
      {
        ListingContext localListingContext = paramString;
        if (paramSegmentedStorageRequest.getToken() != null) {
          paramAnonymousVoid = paramSegmentedStorageRequest.getToken().getNextMarker();
        } else {
          paramAnonymousVoid = null;
        }
        localListingContext.setMarker(paramAnonymousVoid);
        return BlobRequest.listContainers(paramAnonymousCloudBlobClient.getCredentials().transformUri(paramAnonymousCloudBlobClient.getStorageUri()).getUri(getCurrentLocation()), paramBlobRequestOptions, paramAnonymousOperationContext, paramString, paramContainerListingDetails);
      }
      
      public ResultSegment<CloudBlobContainer> postProcessResponse(HttpURLConnection paramAnonymousHttpURLConnection, Void paramAnonymousVoid, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext, ResultSegment<CloudBlobContainer> paramAnonymousResultSegment)
      {
        paramAnonymousVoid = ContainerListHandler.getContainerList(getConnection().getInputStream(), paramAnonymousCloudBlobClient);
        if (paramAnonymousVoid.getNextMarker() != null)
        {
          paramAnonymousHttpURLConnection = new ResultContinuation();
          paramAnonymousHttpURLConnection.setNextMarker(paramAnonymousVoid.getNextMarker());
          paramAnonymousHttpURLConnection.setContinuationType(ResultContinuationType.CONTAINER);
          paramAnonymousHttpURLConnection.setTargetLocation(getResult().getTargetLocation());
        }
        else
        {
          paramAnonymousHttpURLConnection = null;
        }
        paramAnonymousHttpURLConnection = new ResultSegment(paramAnonymousVoid.getResults(), paramAnonymousVoid.getMaxResults(), paramAnonymousHttpURLConnection);
        paramSegmentedStorageRequest.setToken(paramAnonymousHttpURLConnection.getContinuationToken());
        return paramAnonymousHttpURLConnection;
      }
      
      public ResultSegment<CloudBlobContainer> preProcessResponse(Void paramAnonymousVoid, CloudBlobClient paramAnonymousCloudBlobClient, OperationContext paramAnonymousOperationContext)
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
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, this);
    return (AccountInformation)ExecutionEngine.executeWithRetry(this, null, downloadAccountInformationImpl(paramBlobRequestOptions), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public StorageRequest<ServiceClient, Void, AccountInformation> downloadAccountInformationImpl(final RequestOptions paramRequestOptions)
  {
    new StorageRequest(paramRequestOptions, getStorageUri())
    {
      public HttpURLConnection buildRequest(ServiceClient paramAnonymousServiceClient, Void paramAnonymousVoid, OperationContext paramAnonymousOperationContext)
      {
        return BaseRequest.getAccountInfo(CloudBlobClient.access$000(CloudBlobClient.this).transformUri(paramAnonymousServiceClient.getStorageUri().getUri(getCurrentLocation())), paramRequestOptions, null, paramAnonymousOperationContext);
      }
      
      public AccountInformation preProcessResponse(Void paramAnonymousVoid, ServiceClient paramAnonymousServiceClient, OperationContext paramAnonymousOperationContext)
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
  public final ServiceProperties downloadServiceProperties()
  {
    return downloadServiceProperties(null, null);
  }
  
  @DoesServiceRequest
  public final ServiceProperties downloadServiceProperties(BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, this);
    return (ServiceProperties)ExecutionEngine.executeWithRetry(this, null, downloadServicePropertiesImpl(paramBlobRequestOptions, false), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public CloudBlobContainer getContainerReference(String paramString)
  {
    return new CloudBlobContainer(paramString, this);
  }
  
  public BlobRequestOptions getDefaultRequestOptions()
  {
    return defaultRequestOptions;
  }
  
  public String getDirectoryDelimiter()
  {
    return directoryDelimiter;
  }
  
  @DoesServiceRequest
  public ServiceStats getServiceStats()
  {
    return getServiceStats(null, null);
  }
  
  @DoesServiceRequest
  public ServiceStats getServiceStats(BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, this);
    return (ServiceStats)ExecutionEngine.executeWithRetry(this, null, getServiceStatsImpl(paramBlobRequestOptions, false), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public boolean isUsePathStyleUris()
  {
    return super.isUsePathStyleUris();
  }
  
  @DoesServiceRequest
  public Iterable<CloudBlobContainer> listContainers()
  {
    return listContainersWithPrefix(null, ContainerListingDetails.NONE, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudBlobContainer> listContainers(String paramString)
  {
    return listContainersWithPrefix(paramString, ContainerListingDetails.NONE, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudBlobContainer> listContainers(String paramString, ContainerListingDetails paramContainerListingDetails, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return listContainersWithPrefix(paramString, paramContainerListingDetails, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudBlobContainer> listContainersSegmented()
  {
    return listContainersSegmented(null, ContainerListingDetails.NONE, null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudBlobContainer> listContainersSegmented(String paramString)
  {
    return listContainersWithPrefixSegmented(paramString, ContainerListingDetails.NONE, null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudBlobContainer> listContainersSegmented(String paramString, ContainerListingDetails paramContainerListingDetails, Integer paramInteger, ResultContinuation paramResultContinuation, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return listContainersWithPrefixSegmented(paramString, paramContainerListingDetails, paramInteger, paramResultContinuation, paramBlobRequestOptions, paramOperationContext);
  }
  
  public void setDefaultRequestOptions(BlobRequestOptions paramBlobRequestOptions)
  {
    Utility.assertNotNull("defaultRequestOptions", paramBlobRequestOptions);
    defaultRequestOptions = paramBlobRequestOptions;
  }
  
  public void setDirectoryDelimiter(String paramString)
  {
    Utility.assertNotNullOrEmpty("directoryDelimiter", paramString);
    directoryDelimiter = paramString;
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(ServiceProperties paramServiceProperties)
  {
    uploadServiceProperties(paramServiceProperties, null, null);
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(ServiceProperties paramServiceProperties, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramBlobRequestOptions = BlobRequestOptions.populateAndApplyDefaults(paramBlobRequestOptions, BlobType.UNSPECIFIED, this);
    Utility.assertNotNull("properties", paramServiceProperties);
    if ((paramServiceProperties.getDeleteRetentionPolicy() != null) && (paramServiceProperties.getDeleteRetentionPolicy().getEnabled())) {
      Utility.assertNotNull("RetentionIntervalInDays", paramServiceProperties.getDeleteRetentionPolicy().getRetentionIntervalInDays());
    }
    ExecutionEngine.executeWithRetry(this, null, uploadServicePropertiesImpl(paramServiceProperties, paramBlobRequestOptions, localOperationContext, false), paramBlobRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */