package com.microsoft.azure.storage;

public enum StorageErrorCode
{
  public int value;
  
  static
  {
    LEASE_ID_MISSING = new StorageErrorCode("LEASE_ID_MISSING", 20, 21);
    LEASE_ID_MISMATCH = new StorageErrorCode("LEASE_ID_MISMATCH", 21, 22);
    LEASE_NOT_PRESENT = new StorageErrorCode("LEASE_NOT_PRESENT", 22, 23);
    StorageErrorCode localStorageErrorCode = new StorageErrorCode("SERVER_BUSY", 23, 24);
    SERVER_BUSY = localStorageErrorCode;
    $VALUES = new StorageErrorCode[] { ACCESS_DENIED, ACCOUNT_NOT_FOUND, AUTHENTICATION_FAILURE, BAD_GATEWAY, BAD_REQUEST, BLOB_ALREADY_EXISTS, BLOB_NOT_FOUND, CONDITION_FAILED, CONTAINER_ALREADY_EXISTS, CONTAINER_NOT_FOUND, HTTP_VERSION_NOT_SUPPORTED, NONE, NOT_IMPLEMENTED, RESOURCE_ALREADY_EXISTS, RESOURCE_NOT_FOUND, SERVICE_BAD_REQUEST, SERVICE_INTEGRITY_CHECK_FAILED, SERVICE_INTERNAL_ERROR, SERVICE_TIMEOUT, TRANSPORT_ERROR, LEASE_ID_MISSING, LEASE_ID_MISMATCH, LEASE_NOT_PRESENT, localStorageErrorCode };
  }
  
  public StorageErrorCode(int paramInt)
  {
    value = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.StorageErrorCode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */