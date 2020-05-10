package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.ServiceProperties;
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
import java.util.EnumSet;

public final class CloudFileClient
  extends ServiceClient
{
  public FileRequestOptions defaultRequestOptions = new FileRequestOptions();
  
  public CloudFileClient(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    super(paramStorageUri, paramStorageCredentials);
    if ((paramStorageCredentials != null) && (!paramStorageCredentials.getClass().equals(StorageCredentialsAnonymous.class)))
    {
      FileRequestOptions.applyDefaults(defaultRequestOptions);
      return;
    }
    throw new IllegalArgumentException("StorageCredentials cannot be null or anonymous for this service.");
  }
  
  public CloudFileClient(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private Iterable<CloudFileShare> listSharesWithPrefix(String paramString, EnumSet<ShareListingDetails> paramEnumSet, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, this);
    return new LazySegmentedIterable(listSharesWithPrefixSegmentedImpl(paramString, paramEnumSet, null, paramFileRequestOptions, new SegmentedStorageRequest()), this, null, paramFileRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  private ResultSegment<CloudFileShare> listSharesWithPrefixSegmented(String paramString, EnumSet<ShareListingDetails> paramEnumSet, Integer paramInteger, ResultContinuation paramResultContinuation, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, this);
    Utility.assertContinuationType(paramResultContinuation, ResultContinuationType.SHARE);
    paramOperationContext = new SegmentedStorageRequest();
    paramOperationContext.setToken(paramResultContinuation);
    return (ResultSegment)ExecutionEngine.executeWithRetry(this, null, listSharesWithPrefixSegmentedImpl(paramString, paramEnumSet, paramInteger, paramFileRequestOptions, paramOperationContext), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  private StorageRequest<CloudFileClient, Void, ResultSegment<CloudFileShare>> listSharesWithPrefixSegmentedImpl(String paramString, EnumSet<ShareListingDetails> paramEnumSet, Integer paramInteger, FileRequestOptions paramFileRequestOptions, SegmentedStorageRequest paramSegmentedStorageRequest)
  {
    Utility.assertContinuationType(paramSegmentedStorageRequest.getToken(), ResultContinuationType.SHARE);
    paramString = new ListingContext(paramString, paramInteger);
    return new CloudFileClient.1(this, paramFileRequestOptions, getStorageUri(), paramSegmentedStorageRequest, paramString, paramFileRequestOptions, paramEnumSet);
  }
  
  @DoesServiceRequest
  public final FileServiceProperties downloadServiceProperties()
  {
    return downloadServiceProperties(null, null);
  }
  
  @DoesServiceRequest
  public final FileServiceProperties downloadServiceProperties(FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, this);
    return new FileServiceProperties((ServiceProperties)ExecutionEngine.executeWithRetry(this, null, downloadServicePropertiesImpl(paramFileRequestOptions, false), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext));
  }
  
  public FileRequestOptions getDefaultRequestOptions()
  {
    return defaultRequestOptions;
  }
  
  public CloudFileShare getShareReference(String paramString)
  {
    Utility.assertNotNullOrEmpty("shareName", paramString);
    return getShareReference(paramString, null);
  }
  
  public CloudFileShare getShareReference(String paramString1, String paramString2)
  {
    Utility.assertNotNullOrEmpty("shareName", paramString1);
    return new CloudFileShare(paramString1, paramString2, this);
  }
  
  public boolean isUsePathStyleUris()
  {
    return super.isUsePathStyleUris();
  }
  
  @DoesServiceRequest
  public Iterable<CloudFileShare> listShares()
  {
    return listSharesWithPrefix(null, EnumSet.noneOf(ShareListingDetails.class), null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudFileShare> listShares(String paramString)
  {
    return listSharesWithPrefix(paramString, EnumSet.noneOf(ShareListingDetails.class), null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudFileShare> listShares(String paramString, EnumSet<ShareListingDetails> paramEnumSet, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return listSharesWithPrefix(paramString, paramEnumSet, paramFileRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudFileShare> listSharesSegmented()
  {
    return listSharesSegmented(null, EnumSet.noneOf(ShareListingDetails.class), null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudFileShare> listSharesSegmented(String paramString)
  {
    return listSharesWithPrefixSegmented(paramString, EnumSet.noneOf(ShareListingDetails.class), null, null, null, null);
  }
  
  @DoesServiceRequest
  public ResultSegment<CloudFileShare> listSharesSegmented(String paramString, EnumSet<ShareListingDetails> paramEnumSet, Integer paramInteger, ResultContinuation paramResultContinuation, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return listSharesWithPrefixSegmented(paramString, paramEnumSet, paramInteger, paramResultContinuation, paramFileRequestOptions, paramOperationContext);
  }
  
  public void setDefaultRequestOptions(FileRequestOptions paramFileRequestOptions)
  {
    Utility.assertNotNull("defaultRequestOptions", paramFileRequestOptions);
    defaultRequestOptions = paramFileRequestOptions;
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(FileServiceProperties paramFileServiceProperties)
  {
    uploadServiceProperties(paramFileServiceProperties, null, null);
  }
  
  @DoesServiceRequest
  public void uploadServiceProperties(FileServiceProperties paramFileServiceProperties, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramFileRequestOptions = FileRequestOptions.populateAndApplyDefaults(paramFileRequestOptions, this);
    Utility.assertNotNull("properties", paramFileServiceProperties);
    ExecutionEngine.executeWithRetry(this, null, uploadServicePropertiesImpl(paramFileServiceProperties.getServiceProperties(), paramFileRequestOptions, localOperationContext, false), paramFileRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.CloudFileClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */