package com.microsoft.azure.storage.core;

import java.io.IOException;
import java.io.InputStream;

public class NetworkInputStream
  extends InputStream
{
  public long bytesRead = 0L;
  public final long expectedLength;
  public final InputStream inputStream;
  
  public NetworkInputStream(InputStream paramInputStream, long paramLong)
  {
    inputStream = paramInputStream;
    expectedLength = paramLong;
  }
  
  public void close()
  {
    inputStream.close();
  }
  
  public int read()
  {
    throw new UnsupportedOperationException();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 > -1) {
      bytesRead += paramInt1;
    } else {
      if (bytesRead != expectedLength) {
        break label44;
      }
    }
    return paramInt1;
    label44:
    throw new IOException("An incorrect number of bytes was read from the connection. The connection may have been closed.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.NetworkInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */