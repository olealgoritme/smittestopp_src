package com.microsoft.azure.storage.core;

import java.io.IOException;
import java.io.OutputStream;

public class WrappedByteArrayOutputStream
  extends OutputStream
{
  public byte[] buffer;
  public int offset;
  public final int startingOffset;
  
  public WrappedByteArrayOutputStream(byte[] paramArrayOfByte, int paramInt)
  {
    buffer = paramArrayOfByte;
    offset = paramInt;
    startingOffset = paramInt;
  }
  
  public int getPosition()
  {
    return offset - startingOffset;
  }
  
  public void write(int paramInt)
  {
    int i = offset;
    byte[] arrayOfByte = buffer;
    if (i != arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(byte)paramInt);
      offset = (i + 1);
      return;
    }
    throw new IOException("An incorrect number of bytes was read from the connection. The connection may have been closed.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.WrappedByteArrayOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */