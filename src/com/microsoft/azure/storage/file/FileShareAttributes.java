package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;
import java.util.HashMap;

public final class FileShareAttributes
{
  public HashMap<String, String> metadata;
  public String name;
  public FileShareProperties properties;
  public StorageUri storageUri;
  
  public FileShareAttributes()
  {
    setMetadata(new HashMap());
    setProperties(new FileShareProperties());
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
  
  public void setProperties(FileShareProperties paramFileShareProperties)
  {
    properties = paramFileShareProperties;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileShareAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */