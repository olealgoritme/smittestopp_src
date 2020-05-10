package com.microsoft.appcenter.utils.crypto;

import java.security.Key;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public final class CryptoUtils$1
  implements CryptoUtils.ICryptoFactory
{
  public CryptoUtils.ICipher getCipher(String paramString1, String paramString2)
  {
    new CryptoUtils.ICipher()
    {
      public byte[] doFinal(byte[] paramAnonymousArrayOfByte)
      {
        return val$cipher.doFinal(paramAnonymousArrayOfByte);
      }
      
      public byte[] doFinal(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return val$cipher.doFinal(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
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
      
      public void init(int paramAnonymousInt, Key paramAnonymousKey)
      {
        val$cipher.init(paramAnonymousInt, paramAnonymousKey);
      }
      
      public void init(int paramAnonymousInt, Key paramAnonymousKey, AlgorithmParameterSpec paramAnonymousAlgorithmParameterSpec)
      {
        val$cipher.init(paramAnonymousInt, paramAnonymousKey, paramAnonymousAlgorithmParameterSpec);
      }
    };
  }
  
  public CryptoUtils.IKeyGenerator getKeyGenerator(String paramString1, String paramString2)
  {
    new CryptoUtils.IKeyGenerator()
    {
      public void generateKey()
      {
        val$keyGenerator.generateKey();
      }
      
      public void init(AlgorithmParameterSpec paramAnonymousAlgorithmParameterSpec)
      {
        val$keyGenerator.init(paramAnonymousAlgorithmParameterSpec);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.crypto.CryptoUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */