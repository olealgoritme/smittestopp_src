package com.microsoft.azure.storage;

import java.util.Map;

public abstract interface CloudStorageAccount$ConnectionStringFilter
{
  public abstract Map<String, String> apply(Map<String, String> paramMap);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CloudStorageAccount.ConnectionStringFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */