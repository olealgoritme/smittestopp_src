package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageUri;
import java.net.URI;

public abstract interface ListFileItem
{
  public abstract CloudFileDirectory getParent();
  
  public abstract CloudFileShare getShare();
  
  public abstract StorageUri getStorageUri();
  
  public abstract URI getUri();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.ListFileItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */