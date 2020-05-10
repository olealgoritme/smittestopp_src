package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.DeleteRetentionPolicy;
import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.ServiceProperties;
import com.microsoft.azure.storage.ServiceStats;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.LazySegmentedIterable;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
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
  
  private StorageRequest<CloudBlobClient, Void, ResultSegment<CloudBlobContainer>> listContainersWithPrefixSegmentedImpl(String paramString, ContainerListingDetails paramContainerListingDetails, Integer paramInteger, BlobRequestOptions paramBlobRequestOptions, SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    Utility.assertContinuationType(paramSegmentedStorageRequest.getToken(), ResultContinuationType.CONTAINER);
    paramString = new ListingContext(paramString, paramInteger);
    return new CloudBlobClient.1(this, paramBlobRequestOptions, getStorageUri(), paramSegmentedStorageRequest, paramString, paramBlobRequestOptions, paramContainerListingDetails);
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
  
  public StorageRequest<ServiceClient, Void, AccountInformation> downloadAccountInformationImpl(RequestOptions paramRequestOptions)
  {
    return new CloudBlobClient.2(this, paramRequestOptions, getStorageUri(), paramRequestOptions);
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
 * Qualified Name:     base.com.microsoft.azure.storage.blob.CloudBlobClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */