package com.microsoft.identity.common.internal.providers.keys;

public class KeyStoreConfiguration
{
  public final char[] mKeyStorePassword;
  public final String mKeyStoreProvider;
  public final String mKeyStoreType;
  
  public KeyStoreConfiguration(String paramString1, String paramString2, char[] paramArrayOfChar)
  {
    mKeyStoreType = paramString1;
    mKeyStoreProvider = paramString2;
    mKeyStorePassword = paramArrayOfChar;
  }
  
  public char[] getKeyStorePassword()
  {
    return mKeyStorePassword;
  }
  
  public String getKeyStoreProvider()
  {
    return mKeyStoreProvider;
  }
  
  public String getKeyStoreType()
  {
    return mKeyStoreType;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.keys.KeyStoreConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */