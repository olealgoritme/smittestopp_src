package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;
import java.util.HashMap;

public final class BlobContainerAttributes
{
  public HashMap<String, String> metadata;
  public String name;
  public BlobContainerProperties properties;
  public StorageUri storageUri;
  
  public BlobContainerAttributes()
  {
    setMetadata(new HashMap());
    setProperties(new BlobContainerProperties());
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public BlobContainerProperties getProperties()
  {
    return properties;
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  public void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setProperties(BlobContainerProperties paramBlobContainerProperties)
  {
    properties = paramBlobContainerProperties;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobContainerAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */