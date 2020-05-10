package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import java.security.KeyStore.Entry;

public abstract interface CryptoHandler
{
  public abstract byte[] decrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte);
  
  public abstract byte[] encrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte);
  
  public abstract void generateKey(CryptoUtils.ICryptoFactory paramICryptoFactory, String paramString, Context paramContext);
  
  public abstract String getAlgorithm();
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.crypto.CryptoHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */