package com.microsoft.azure.storage.blob;

public class PageRange
{
  public long endOffset;
  public long startOffset;
  
  public PageRange(long paramLong1, long paramLong2)
  {
    setStartOffset(paramLong1);
    setEndOffset(paramLong2);
  }
  
  public long getEndOffset()
  {
    return endOffset;
  }
  
  public long getStartOffset()
  {
    return startOffset;
  }
  
  public void setEndOffset(long paramLong)
  {
    endOffset = paramLong;
  }
  
  public void setStartOffset(long paramLong)
  {
    startOffset = paramLong;
  }
  
  public String toString()
  {
    return String.format("bytes=%d-%d", new Object[] { Long.valueOf(getStartOffset()), Long.valueOf(getEndOffset()) });
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.PageRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */