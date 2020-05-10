package com.microsoft.identity.common.adal.internal.cache;

import javax.crypto.SecretKey;

public abstract interface IStorageHelper
{
  public abstract String decrypt(String paramString);
  
  public abstract String encrypt(String paramString);
  
  public abstract SecretKey loadSecretKeyForEncryption();
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.cache.IStorageHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */