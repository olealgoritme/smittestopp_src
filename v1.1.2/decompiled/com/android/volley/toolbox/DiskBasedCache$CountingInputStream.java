package com.android.volley.toolbox;

import java.io.FilterInputStream;
import java.io.InputStream;

public class DiskBasedCache$CountingInputStream
  extends FilterInputStream
{
  public long bytesRead;
  public final long length;
  
  public DiskBasedCache$CountingInputStream(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    length = paramLong;
  }
  
  public long bytesRead()
  {
    return bytesRead;
  }
  
  public long bytesRemaining()
  {
    return length - bytesRead;
  }
  
  public int read()
  {
    int i = super.read();
    if (i != -1) {
      bytesRead += 1L;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      bytesRead += paramInt1;
    }
    return paramInt1;
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.DiskBasedCache.CountingInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */