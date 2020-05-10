package com.microsoft.appcenter.utils.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public final class CryptoUtils$1
  implements CryptoUtils.ICryptoFactory
{
  public CryptoUtils.ICipher getCipher(String paramString1, String paramString2)
  {
    return new CryptoUtils.1.2(this, Cipher.getInstance(paramString1, paramString2));
  }
  
  public CryptoUtils.IKeyGenerator getKeyGenerator(String paramString1, String paramString2)
  {
    return new CryptoUtils.1.1(this, KeyGenerator.getInstance(paramString1, paramString2));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.crypto.CryptoUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */