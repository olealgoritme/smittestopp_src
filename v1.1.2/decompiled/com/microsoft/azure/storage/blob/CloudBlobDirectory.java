package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.Utility;
import java.net.URI;
import java.util.EnumSet;

public final class CloudBlobDirectory
  implements ListBlobItem
{
  public final CloudBlobClient blobServiceClient;
  public final CloudBlobContainer container;
  public CloudBlobDirectory parent;
  public final String prefix;
  public final StorageUri storageUri;
  
  public CloudBlobDirectory(StorageUri paramStorageUri, String paramString, CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer)
  {
    this(paramStorageUri, paramString, paramCloudBlobClient, paramCloudBlobContainer, null);
  }
  
  public CloudBlobDirectory(StorageUri paramStorageUri, String paramString, CloudBlobClient paramCloudBlobClient, CloudBlobContainer paramCloudBlobContainer, CloudBlobDirectory paramCloudBlobDirectory)
  {
    Utility.assertNotNull("uri", paramStorageUri);
    Utility.assertNotNull("client", paramCloudBlobClient);
    Utility.assertNotNull("container", paramCloudBlobContainer);
    blobServiceClient = paramCloudBlobClient;
    parent = paramCloudBlobDirectory;
    container = paramCloudBlobContainer;
    prefix = paramString;
    storageUri = paramStorageUri;
  }
  
  public CloudAppendBlob getAppendBlobReference(String paramString)
  {
    return getAppendBlobReference(paramString, null);
  }
  
  public CloudAppendBlob getAppendBlobReference(String paramString1, String paramString2)
  {
    Utility.assertNotNullOrEmpty("blobName", paramString1);
    return new CloudAppendBlob(getPrefix().concat(paramString1), paramString2, getContainer());
  }
  
  public CloudBlockBlob getBlockBlobReference(String paramString)
  {
    return getBlockBlobReference(paramString, null);
  }
  
  public CloudBlockBlob getBlockBlobReference(String paramString1, String paramString2)
  {
    Utility.assertNotNullOrEmpty("blobName", paramString1);
    return new CloudBlockBlob(getPrefix().concat(paramString1), paramString2, getContainer());
  }
  
  public CloudBlobContainer getContainer()
  {
    return container;
  }
  
  public CloudBlobDirectory getDirectoryReference(String paramString)
  {
    Utility.assertNotNullOrEmpty("directoryName", paramString);
    String str = paramString;
    if (!paramString.endsWith(blobServiceClient.getDirectoryDelimiter())) {
      str = paramString.concat(blobServiceClient.getDirectoryDelimiter());
    }
    paramString = getPrefix().concat(str);
    return new CloudBlobDirectory(PathUtility.appendPathToUri(storageUri, str, blobServiceClient.getDirectoryDelimiter()), paramString, blobServiceClient, container, this);
  }
  
  public CloudPageBlob getPageBlobReference(String paramString)
  {
    return getPageBlobReference(paramString, null);
  }
  
  public CloudPageBlob getPageBlobReference(String paramString1, String paramString2)
  {
    Utility.assertNotNullOrEmpty("blobName", paramString1);
    return new CloudPageBlob(getPrefix().concat(paramString1), paramString2, getContainer());
  }
  
  public CloudBlobDirectory getParent()
  {
    if (parent == null)
    {
      String str = CloudBlob.getParentNameFromURI(getStorageUri(), blobServiceClient.getDirectoryDelimiter(), getContainer());
      if (str != null) {
        parent = new CloudBlobDirectory(PathUtility.appendPathToUri(container.getStorageUri(), str), str, blobServiceClient, getContainer());
      }
    }
    return parent;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public CloudBlobClient getServiceClient()
  {
    return blobServiceClient;
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
  public Iterable<ListBlobItem> listBlobs()
  {
    return getContainer().listBlobs(getPrefix());
  }
  
  @DoesServiceRequest
  public Iterable<ListBlobItem> listBlobs(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return getContainer().listBlobs(getPrefix().concat(str));
  }
  
  @DoesServiceRequest
  public Iterable<ListBlobItem> listBlobs(String paramString, boolean paramBoolean, EnumSet<BlobListingDetails> paramEnumSet, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return getContainer().listBlobs(getPrefix().concat(str), paramBoolean, paramEnumSet, paramBlobRequestOptions, paramOperationContext);
  }
  
  @DoesServiceRequest
  public ResultSegment<ListBlobItem> listBlobsSegmented()
  {
    return getContainer().listBlobsSegmented(getPrefix());
  }
  
  @DoesServiceRequest
  public ResultSegment<ListBlobItem> listBlobsSegmented(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return getContainer().listBlobsSegmented(getPrefix().concat(str));
  }
  
  @DoesServiceRequest
  public ResultSegment<ListBlobItem> listBlobsSegmented(String paramString, boolean paramBoolean, EnumSet<BlobListingDetails> paramEnumSet, Integer paramInteger, ResultContinuation paramResultContinuation, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return getContainer().listBlobsSegmented(getPrefix().concat(str), paramBoolean, paramEnumSet, paramInteger, paramResultContinuation, paramBlobRequestOptions, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlobDirectory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */