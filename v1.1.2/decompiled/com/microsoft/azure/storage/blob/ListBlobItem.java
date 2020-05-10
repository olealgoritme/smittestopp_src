package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;

public abstract interface ListBlobItem
{
  public abstract CloudBlobContainer getContainer();
  
  public abstract CloudBlobDirectory getParent();
  
  public abstract StorageUri getStorageUri();
  
  public abstract URI getUri();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.ListBlobItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */