package com.microsoft.identity.common.adal.internal.cache;

public enum StorageHelper$EncryptionType
{
  static
  {
    ANDROID_KEY_STORE = new EncryptionType("ANDROID_KEY_STORE", 1);
    EncryptionType localEncryptionType = new EncryptionType("UNENCRYPTED", 2);
    UNENCRYPTED = localEncryptionType;
    $VALUES = new EncryptionType[] { USER_DEFINED, ANDROID_KEY_STORE, localEncryptionType };
  }
  
  public StorageHelper$EncryptionType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.cache.StorageHelper.EncryptionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */