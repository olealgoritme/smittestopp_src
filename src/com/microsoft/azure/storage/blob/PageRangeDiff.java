package com.microsoft.azure.storage.blob;

public final class PageRangeDiff
  extends PageRange
{
  public boolean isCleared;
  
  public PageRangeDiff(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super(paramLong1, paramLong2);
    setIsCleared(paramBoolean);
  }
  
  public boolean isCleared()
  {
    return isCleared;
  }
  
  public void setIsCleared(boolean paramBoolean)
  {
    isCleared = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.PageRangeDiff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */