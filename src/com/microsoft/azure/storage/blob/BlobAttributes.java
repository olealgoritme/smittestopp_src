package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;
import java.util.HashMap;

public final class BlobAttributes
{
  public HashMap<String, String> metadata;
  public BlobProperties properties;
  public String snapshotID;
  public StorageUri storageUri;
  
  public BlobAttributes(BlobType paramBlobType)
  {
    setMetadata(new HashMap());
    setProperties(new BlobProperties(paramBlobType));
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public BlobProperties getProperties()
  {
    return properties;
  }
  
  public final String getSnapshotID()
  {
    return snapshotID;
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public final URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  public void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public void setProperties(BlobProperties paramBlobProperties)
  {
    properties = paramBlobProperties;
  }
  
  public final void setSnapshotID(String paramString)
  {
    snapshotID = paramString;
  }
  
  public void setStorageUri(StorageUri paramStorageUri)
  {
    storageUri = paramStorageUri;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */