package com.microsoft.azure.storage;

import java.io.InputStream;
import java.util.Iterator;

public final class SubStreamGenerator
  implements Iterable<InputStream>
{
  public final long blockSize;
  public int blocksPending;
  public int currentBlock = 0;
  public long lastBlockSize;
  public final Object mutex = new Object();
  public final InputStream wrappedStream;
  
  public SubStreamGenerator(InputStream paramInputStream, int paramInt, long paramLong)
  {
    wrappedStream = paramInputStream;
    blocksPending = paramInt;
    blockSize = paramLong;
    lastBlockSize = paramLong;
  }
  
  public Iterator<InputStream> iterator()
  {
    return new SubStreamGenerator.SubStreamIterator(this, null);
  }
  
  public void setLastBlockSize(long paramLong)
  {
    lastBlockSize = paramLong;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.SubStreamGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */