package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.io.OutputStream;

public class LengthLimitingStream
  extends BlobOutputStream
{
  public Long endOffset;
  public Long length;
  public long position;
  public long startOffset;
  public final OutputStream wrappedStream;
  
  public LengthLimitingStream(OutputStream paramOutputStream, long paramLong, Long paramLong1)
  {
    wrappedStream = paramOutputStream;
    startOffset = paramLong;
    length = paramLong1;
    if (paramLong1 != null) {
      endOffset = Long.valueOf(paramLong1.longValue() - 1L + paramLong);
    }
  }
  
  public void close() {}
  
  public void flush()
  {
    wrappedStream.flush();
  }
  
  public void write(InputStream paramInputStream, long paramLong)
  {
    Utility.writeToOutputStream(paramInputStream, this, paramLong, false, false, null, null);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l1 = position;
    long l2 = startOffset;
    int i = paramInt1;
    int j = paramInt2;
    if (l1 < l2)
    {
      int k = (int)Math.min(l2 - l1, paramInt2);
      i = paramInt1 + k;
      j = paramInt2 - k;
      position += k;
    }
    Long localLong = endOffset;
    paramInt1 = j;
    if (localLong != null) {
      paramInt1 = (int)Math.min(localLong.longValue() + 1L - position, j);
    }
    if (paramInt1 > 0)
    {
      wrappedStream.write(paramArrayOfByte, i, paramInt1);
      position += paramInt1;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.LengthLimitingStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */