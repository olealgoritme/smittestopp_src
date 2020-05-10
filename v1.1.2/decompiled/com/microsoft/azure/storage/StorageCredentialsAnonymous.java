package com.microsoft.azure.storage;

import java.net.URI;

public final class StorageCredentialsAnonymous
  extends StorageCredentials
{
  public static final StorageCredentials ANONYMOUS = new StorageCredentialsAnonymous();
  
  public static StorageCredentials getInstance()
  {
    return ANONYMOUS;
  }
  
  public String toString(boolean paramBoolean)
  {
    return "";
  }
  
  public StorageUri transformUri(StorageUri paramStorageUri, OperationContext paramOperationContext)
  {
    return paramStorageUri;
  }
  
  public URI transformUri(URI paramURI, OperationContext paramOperationContext)
  {
    return paramURI;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StorageCredentialsAnonymous
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */