package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class BlobDecryptStream
  extends BlobOutputStream
{
  public boolean bufferIV;
  public OutputStream cryptoStream;
  public int discardFirst;
  public BlobEncryptionPolicy encryptionPolicy;
  public byte[] iv = new byte[16];
  public final Map<String, String> metadata;
  public boolean noPadding;
  public long position;
  public Boolean requireEncryption;
  public Long userProvidedLength;
  public final OutputStream userStream;
  
  public BlobDecryptStream(OutputStream paramOutputStream, Map<String, String> paramMap, Long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, BlobEncryptionPolicy paramBlobEncryptionPolicy, Boolean paramBoolean)
  {
    userStream = paramOutputStream;
    metadata = paramMap;
    userProvidedLength = paramLong;
    discardFirst = paramInt;
    encryptionPolicy = paramBlobEncryptionPolicy;
    bufferIV = paramBoolean1;
    noPadding = paramBoolean2;
    requireEncryption = paramBoolean;
  }
  
  public void close()
  {
    cryptoStream.close();
  }
  
  public void flush()
  {
    userStream.flush();
  }
  
  public void write(InputStream paramInputStream, long paramLong)
  {
    Utility.writeToOutputStream(paramInputStream, this, paramLong, false, false, null, null);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (bufferIV)
    {
      long l = position;
      i = paramInt1;
      j = paramInt2;
      if (l < 16L)
      {
        j = 16 - (int)l;
        if (paramInt2 <= j) {
          j = paramInt2;
        }
        System.arraycopy(paramArrayOfByte, paramInt1, iv, (int)position, j);
        position += j;
        i = paramInt1 + j;
        j = paramInt2 - j;
      }
    }
    if (cryptoStream == null)
    {
      LengthLimitingStream localLengthLimitingStream = new LengthLimitingStream(userStream, discardFirst, userProvidedLength);
      try
      {
        BlobEncryptionPolicy localBlobEncryptionPolicy = encryptionPolicy;
        Map localMap = metadata;
        Boolean localBoolean = requireEncryption;
        byte[] arrayOfByte;
        if (!bufferIV) {
          arrayOfByte = null;
        } else {
          arrayOfByte = iv;
        }
        cryptoStream = localBlobEncryptionPolicy.decryptBlob(localLengthLimitingStream, localMap, localBoolean, arrayOfByte, noPadding);
      }
      catch (StorageException paramArrayOfByte)
      {
        throw Utility.initIOException(paramArrayOfByte);
      }
    }
    if (j > 0)
    {
      cryptoStream.write(paramArrayOfByte, i, j);
      position += j;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobDecryptStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */