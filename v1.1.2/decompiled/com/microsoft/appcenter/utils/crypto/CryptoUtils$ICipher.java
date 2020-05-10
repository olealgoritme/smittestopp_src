package com.microsoft.appcenter.utils.crypto;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public abstract interface CryptoUtils$ICipher
{
  public abstract byte[] doFinal(byte[] paramArrayOfByte);
  
  public abstract byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract String getAlgorithm();
  
  public abstract int getBlockSize();
  
  public abstract byte[] getIV();
  
  public abstract String getProvider();
  
  public abstract void init(int paramInt, Key paramKey);
  
  public abstract void init(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec);
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.crypto.CryptoUtils.ICipher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */