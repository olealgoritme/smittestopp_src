package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;
import java.util.HashMap;

public final class FileDirectoryAttributes
{
  public HashMap<String, String> metadata;
  public String name;
  public FileDirectoryProperties properties;
  public StorageUri storageUri;
  
  public FileDirectoryAttributes()
  {
    setMetadata(new HashMap());
    setProperties(new FileDirectoryProperties());
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public FileDirectoryProperties getProperties()
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
  
  public void setProperties(FileDirectoryProperties paramFileDirectoryProperties)
  {
    properties = paramFileDirectoryProperties;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileDirectoryAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */