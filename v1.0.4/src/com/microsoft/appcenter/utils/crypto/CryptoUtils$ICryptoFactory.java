package com.microsoft.appcenter.utils.crypto;

public abstract interface CryptoUtils$ICryptoFactory
{
  public abstract CryptoUtils.ICipher getCipher(String paramString1, String paramString2);
  
  public abstract CryptoUtils.IKeyGenerator getKeyGenerator(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.utils.crypto.CryptoUtils.ICryptoFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */