package com.microsoft.azure.storage.queue;

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
import com.microsoft.azure.storage.StorageCredentialsAnonymous;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.LazySegmentedIterable;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.SegmentedStorageRequest;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.Utility;
import java.net.URI;

public final class CloudQueueClient
  extends ServiceClient
{
  public QueueRequestOptions defaultRequestOptions = new QueueRequestOptions();
  
  public CloudQueueClient(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    super(paramStorageUri, paramStorageCredentials);
    if ((paramStorageCredentials != null) && (!paramStorageCredentials.getClass().equals(StorageCredentialsAnonymous.class)))
    {
      QueueRequestOptions.applyDefaults(defaultRequestOptions);
      return;
    }
    throw new IllegalArgumentException("StorageCredentials cannot be null or anonymous for this service.");
  }
  
  public CloudQueueClient(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI, null), paramStorageCredentials);
  }
  
  private StorageRequest<CloudQueueClient, Void, ResultSegment<CloudQueue>> listQueuesSegmentedImpl(String paramString, QueueListingDetails paramQueueListingDetails, Integer paramInteger, QueueRequestOptions paramQueueRequestOptions, SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    Utility.assertContinuationType(paramSegmentedStorageRequest.getToken(), ResultContinuationType.QUEUE);
    paramString = new ListingContext(paramString, paramInteger);
    return new CloudQueueClient.1(this, paramQueueRequestOptions, getStorageUri(), paramSegmentedStorageRequest, paramString, paramQueueRequestOptions, paramQueueListingDetails);
  }
  
  @DoesServiceRequest
  public final ServiceProperties downloadServiceProperties()
  {
    return downloadServiceProperties(null, null);
  }
  
  @DoesServiceRequest
  public final ServiceProperties downloadServiceProperties(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, this);
    return (ServiceProperties)ExecutionEngine.executeWithRetry(this, null, downloadServicePropertiesImpl(paramQueueRequestOptions, false), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public QueueRequestOptions getDefaultRequestOptions()
  {
    return defaultRequestOptions;
  }
  
  public CloudQueue getQueueReference(String paramString)
  {
    return new CloudQueue(paramString, this);
  }
  
  @DoesServiceRequest
  public ServiceStats getServiceStats()
  {
    return getServiceStats(null, null);
  }
  
  @DoesServiceRequest
  public ServiceStats getServiceStats(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, this);
    return (ServiceStats)ExecutionEngine.executeWithRetry(this, null, getServiceStatsImpl(paramQueueRequestOptions, false), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  public boolean isUsePathStyleUris()
  {
    return super.isUsePathStyleUris();
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueue> listQueues()
  {
    return listQueues(null, QueueListingDetails.NONE, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueue> listQueues(String paramString)
  {
    return listQueues(paramString, QueueListingDetails.NONE, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueue> listQueues(String paramString, QueueListingDetails paramQueueListingDetails, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, this);
    return new LazySegmentedIterable(listQueuesSegmentedImpl(paramString, paramQueueListingDetails, null, paramQueueRequestOptions, new SegmentedStorageRequest()), this, null, paramQueueRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudQueue> listQueuesSegmented()
  {
    return listQueuesSegmented(null, QueueListingDetails.NONE, null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudQueue> listQueuesSegmented(String paramString)
  {
    return listQueuesSegmented(paramString, QueueListingDetails.NONE, null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudQueue> listQueuesSegmented(String paramString, QueueListingDetails paramQueueListingDetails, Integer paramInteger, ResultContinuation paramResultContinuation, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramOperationContext = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, this);
    paramQueueRequestOptions = new SegmentedStorageRequest();
    paramQueueRequestOptions.setToken(paramResultContinuation);
    return (ResultSegment)ExecutionEngine.executeWithRetry(this, null, listQueuesSegmentedImpl(paramString, paramQueueListingDetails, paramInteger, paramOperationContext, paramQueueRequestOptions), paramOperationContext.getRetryPolicyFactory(), localOperationContext);
  }
  
  public void setDefaultRequestOptions(QueueRequestOptions paramQueueRequestOptions)
  {
    Utility.assertNotNull("defaultRequestOptions", paramQueueRequestOptions);
    defaultRequestOptions = paramQueueRequestOptions;
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(ServiceProperties paramServiceProperties)
  {
    uploadServiceProperties(paramServiceProperties, null, null);
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(ServiceProperties paramServiceProperties, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    if (Utility.isNullOrEmpty(paramServiceProperties.getDefaultServiceVersion()))
    {
      OperationContext localOperationContext = paramOperationContext;
      if (paramOperationContext == null) {
        localOperationContext = new OperationContext();
      }
      localOperationContext.initialize();
      paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, this);
      Utility.assertNotNull("properties", paramServiceProperties);
      ExecutionEngine.executeWithRetry(this, null, uploadServicePropertiesImpl(paramServiceProperties, paramQueueRequestOptions, localOperationContext, false), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
      return;
    }
    throw new IllegalArgumentException("DefaultServiceVersion can only be set for the Blob service.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueueClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */