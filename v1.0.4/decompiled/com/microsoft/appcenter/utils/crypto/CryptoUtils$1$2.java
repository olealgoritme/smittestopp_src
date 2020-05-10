package com.microsoft.appcenter.utils.crypto;

import java.security.Key;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;

public class CryptoUtils$1$2
  implements CryptoUtils.ICipher
{
  public CryptoUtils$1$2(CryptoUtils.1 param1, Cipher paramCipher) {}
  
  public byte[] doFinal(byte[] paramArrayOfByte)
  {
    return val$cipher.doFinal(paramArrayOfByte);
  }
  
  public byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return val$cipher.doFinal(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public String getAlgorithm()
  {
    return val$cipher.getAlgorithm();
  }
  
  public int getBlockSize()
  {
    return val$cipher.getBlockSize();
  }
  
  public byte[] getIV()
  {
    return val$cipher.getIV();
  }
  
  public String getProvider()
  {
    return val$cipher.getProvider().getName();
  }
  
  public void init(int paramInt, Key paramKey)
  {
    val$cipher.init(paramInt, paramKey);
  }
  
  public void init(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    val$cipher.init(paramInt, paramKey, paramAlgorithmParameterSpec);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.crypto.CryptoUtils.1.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */