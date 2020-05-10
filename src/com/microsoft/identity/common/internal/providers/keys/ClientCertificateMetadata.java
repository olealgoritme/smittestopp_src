package com.microsoft.identity.common.internal.providers.keys;

public class ClientCertificateMetadata
{
  public String mAlias;
  public char[] mPassword;
  
  public ClientCertificateMetadata(String paramString, char[] paramArrayOfChar)
  {
    mAlias = paramString;
    mPassword = paramArrayOfChar;
  }
  
  public String getAlias()
  {
    return mAlias;
  }
  
  public char[] getPassword()
  {
    return mPassword;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.keys.ClientCertificateMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */