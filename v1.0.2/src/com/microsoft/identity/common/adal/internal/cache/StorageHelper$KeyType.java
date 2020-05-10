package com.microsoft.identity.common.adal.internal.cache;

public enum StorageHelper$KeyType
{
  static
  {
    ADAL_USER_DEFINED_KEY = new KeyType("ADAL_USER_DEFINED_KEY", 2);
    KeyType localKeyType = new KeyType("KEYSTORE_ENCRYPTED_KEY", 3);
    KEYSTORE_ENCRYPTED_KEY = localKeyType;
    $VALUES = new KeyType[] { LEGACY_AUTHENTICATOR_APP_KEY, LEGACY_COMPANY_PORTAL_KEY, ADAL_USER_DEFINED_KEY, localKeyType };
  }
  
  public StorageHelper$KeyType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.cache.StorageHelper.KeyType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */