package com.microsoft.azure.storage.analytics;

public enum StorageService
{
  static
  {
    StorageService localStorageService = new StorageService("TABLE", 3);
    TABLE = localStorageService;
    $VALUES = new StorageService[] { BLOB, FILE, QUEUE, localStorageService };
  }
  
  public StorageService() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.analytics.StorageService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */