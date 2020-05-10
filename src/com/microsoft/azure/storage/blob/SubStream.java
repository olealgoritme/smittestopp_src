package com.microsoft.azure.storage.blob;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SubStream
  extends InputStream
{
  public final Object lock;
  public long markIndex;
  public byte[] readBuffer;
  public int readBufferLength;
  public ByteArrayInputStream readBufferStream;
  public long streamBeginIndex;
  public long streamLength;
  public long substreamCurrentIndex;
  public InputStream wrappedStream;
  
  public SubStream(InputStream paramInputStream, long paramLong1, long paramLong2, Object paramObject)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= 1L))
    {
      if (paramInputStream != null)
      {
        if (paramInputStream.markSupported())
        {
          wrappedStream = paramInputStream;
          streamBeginIndex = paramLong1;
          substreamCurrentIndex = 0L;
          streamLength = paramLong2;
          lock = paramObject;
          readBuffer = new byte[4194304];
          paramInputStream = new ByteArrayInputStream(readBuffer);
          readBufferStream = paramInputStream;
          readBufferLength = 0;
          markIndex = 0L;
          paramInputStream.mark(Integer.MAX_VALUE);
          return;
        }
        throw new IllegalArgumentException("The source stream to be wrapped must be markable.");
      }
      throw new NullPointerException("Source stream is null.");
    }
    throw new IndexOutOfBoundsException();
  }
  
  private int readHelper(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    synchronized (lock)
    {
      wrappedStream.reset();
      long l1 = streamBeginIndex + substreamCurrentIndex;
      long l2 = 0L;
      int i = 0;
      while (i <= 7)
      {
        long l3 = wrappedStream.skip(l1 - l2);
        if (l3 == 0L)
        {
          i = (byte)(i + 1);
          l3 = l2;
        }
        else
        {
          l3 = l2 + l3;
          i = 0;
        }
        l2 = l3;
        if (l3 == l1)
        {
          paramInt1 = wrappedStream.read(paramArrayOfByte, paramInt1, paramInt2);
          return paramInt1;
        }
      }
      paramArrayOfByte = new java/io/IOException;
      paramArrayOfByte.<init>("The supplied stream has failed to skip to the correct position after successive attempts. Please ensure there are bytes available and try your upload again.");
      throw paramArrayOfByte;
    }
  }
  
  public void close()
  {
    wrappedStream = null;
    readBuffer = null;
    readBufferStream.close();
    readBufferStream = null;
  }
  
  public InputStream getInputStream()
  {
    return wrappedStream;
  }
  
  public long getLength()
  {
    return streamLength;
  }
  
  public void mark(int paramInt)
  {
    try
    {
      markIndex = substreamCurrentIndex;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    throw new IOException();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    try
    {
      int i = read(paramArrayOfByte, 0, paramArrayOfByte.length);
      return i;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0)) {}
    try
    {
      int i = paramArrayOfByte.length;
      if (paramInt2 <= i - paramInt1)
      {
        if (paramInt2 == 0) {
          return 0;
        }
        i = paramInt2;
        if (substreamCurrentIndex + paramInt2 > streamLength) {
          i = (int)(streamLength - substreamCurrentIndex);
        }
        int j = readBufferStream.read(paramArrayOfByte, paramInt1, Math.min(readBufferLength, i));
        paramInt2 = Math.max(0, j);
        readBufferLength -= paramInt2;
        if (j == i)
        {
          substreamCurrentIndex += paramInt2;
          return paramInt2;
        }
        if (j < i)
        {
          readBufferStream.reset();
          j = readHelper(readBuffer, 0, readBuffer.length);
          readBufferLength = j;
          if (j == -1) {
            readBufferLength = 0;
          }
        }
        i = readBufferStream.read(paramArrayOfByte, paramInt1 + paramInt2, Math.min(readBufferLength, i - paramInt2));
        paramInt1 = paramInt2;
        if (i != -1)
        {
          paramInt1 = paramInt2 + i;
          readBufferLength -= i;
        }
        substreamCurrentIndex += paramInt1;
        return paramInt1;
      }
      paramArrayOfByte = new java/lang/IndexOutOfBoundsException;
      paramArrayOfByte.<init>();
      throw paramArrayOfByte;
    }
    finally {}
  }
  
  public void reset()
  {
    try
    {
      substreamCurrentIndex = markIndex;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long skip(long paramLong)
  {
    long l1 = substreamCurrentIndex;
    long l2 = streamLength;
    long l3 = paramLong;
    if (l1 + paramLong > l2) {
      l3 = l2 - l1;
    }
    substreamCurrentIndex += l3;
    readBufferLength = ((int)Math.max(0L, readBufferLength - l3));
    return l3;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.SubStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */