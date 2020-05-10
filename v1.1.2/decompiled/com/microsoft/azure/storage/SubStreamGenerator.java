package com.microsoft.azure.storage;

import com.microsoft.azure.storage.blob.SubStream;
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
    return new SubStreamIterator(null);
  }
  
  public void setLastBlockSize(long paramLong)
  {
    lastBlockSize = paramLong;
  }
  
  public class SubStreamIterator
    implements Iterator<InputStream>
  {
    public SubStreamIterator() {}
    
    public boolean hasNext()
    {
      boolean bool;
      if (SubStreamGenerator.access$100(SubStreamGenerator.this) > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public SubStream next()
    {
      SubStreamGenerator.access$110(SubStreamGenerator.this);
      InputStream localInputStream = SubStreamGenerator.access$200(SubStreamGenerator.this);
      long l1 = SubStreamGenerator.access$308(SubStreamGenerator.this);
      long l2 = SubStreamGenerator.access$400(SubStreamGenerator.this);
      long l3;
      if (SubStreamGenerator.access$100(SubStreamGenerator.this) > 0) {
        l3 = SubStreamGenerator.access$400(SubStreamGenerator.this);
      } else {
        l3 = SubStreamGenerator.access$500(SubStreamGenerator.this);
      }
      return new SubStream(localInputStream, l1 * l2, l3, SubStreamGenerator.access$600(SubStreamGenerator.this));
    }
    
    public void remove() {}
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.SubStreamGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */