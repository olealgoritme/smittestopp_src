package com.microsoft.appcenter.utils.crypto;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;

public class CryptoUtils$1$1
  implements CryptoUtils.IKeyGenerator
{
  public CryptoUtils$1$1(CryptoUtils.1 param1, KeyGenerator paramKeyGenerator) {}
  
  public void generateKey()
  {
    val$keyGenerator.generateKey();
  }
  
  public void init(AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    val$keyGenerator.init(paramAlgorithmParameterSpec);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.crypto.CryptoUtils.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */