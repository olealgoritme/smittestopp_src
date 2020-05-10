package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;
import java.util.HashMap;

public final class FileAttributes
{
  public HashMap<String, String> metadata;
  public FileProperties properties;
  public StorageUri storageUri;
  
  public FileAttributes()
  {
    setMetadata(new HashMap());
    setProperties(new FileProperties());
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public FileProperties getProperties()
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
  
  public void setProperties(FileProperties paramFileProperties)
  {
    properties = paramFileProperties;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */