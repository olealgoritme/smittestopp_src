package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.c;

public enum StorageAuthenticationType
{
  static
  {
    StorageAuthenticationType localStorageAuthenticationType = new StorageAuthenticationType("IDENTITY", 1);
    IDENTITY = localStorageAuthenticationType;
    $VALUES = new StorageAuthenticationType[] { KEY, localStorageAuthenticationType };
  }
  
  public StorageAuthenticationType() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.StorageAuthenticationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */