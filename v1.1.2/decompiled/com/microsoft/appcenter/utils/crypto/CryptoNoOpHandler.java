package com.microsoft.appcenter.utils.crypto;

import android.content.Context;
import java.security.KeyStore.Entry;

public class CryptoNoOpHandler
  implements CryptoHandler
{
  public byte[] decrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte)
  {
    return paramArrayOfByte;
  }
  
  public byte[] encrypt(CryptoUtils.ICryptoFactory paramICryptoFactory, int paramInt, KeyStore.Entry paramEntry, byte[] paramArrayOfByte)
  {
    return paramArrayOfByte;
  }
  
  public void generateKey(CryptoUtils.ICryptoFactory paramICryptoFactory, String paramString, Context paramContext) {}
  
  public String getAlgorithm()
  {
    return "None";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.crypto.CryptoNoOpHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */