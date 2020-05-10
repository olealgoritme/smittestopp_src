package com.microsoft.azure.storage;

public enum StorageLocation
{
  static
  {
    StorageLocation localStorageLocation = new StorageLocation("SECONDARY", 1);
    SECONDARY = localStorageLocation;
    $VALUES = new StorageLocation[] { PRIMARY, localStorageLocation };
  }
  
  public StorageLocation() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StorageLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */