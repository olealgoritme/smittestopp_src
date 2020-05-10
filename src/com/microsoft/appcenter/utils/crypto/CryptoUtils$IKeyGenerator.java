package com.microsoft.appcenter.utils.crypto;

import java.security.spec.AlgorithmParameterSpec;

public abstract interface CryptoUtils$IKeyGenerator
{
  public abstract void generateKey();
  
  public abstract void init(AlgorithmParameterSpec paramAlgorithmParameterSpec);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.crypto.CryptoUtils.IKeyGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */