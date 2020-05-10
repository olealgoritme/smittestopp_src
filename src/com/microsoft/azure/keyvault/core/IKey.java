package com.microsoft.azure.keyvault.core;

import e.c.b.a.a.a;
import java.io.Closeable;
import k.a.a.b.e.b;

public abstract interface IKey
  extends Closeable
{
  public abstract a<byte[]> decryptAsync(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, String paramString);
  
  public abstract a<Object<byte[], byte[], String>> encryptAsync(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString);
  
  public abstract String getDefaultEncryptionAlgorithm();
  
  public abstract String getDefaultKeyWrapAlgorithm();
  
  public abstract String getDefaultSignatureAlgorithm();
  
  public abstract String getKid();
  
  public abstract a<b<byte[], String>> signAsync(byte[] paramArrayOfByte, String paramString);
  
  public abstract a<byte[]> unwrapKeyAsync(byte[] paramArrayOfByte, String paramString);
  
  public abstract a<Boolean> verifyAsync(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString);
  
  public abstract a<b<byte[], String>> wrapKeyAsync(byte[] paramArrayOfByte, String paramString);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.keyvault.core.IKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */