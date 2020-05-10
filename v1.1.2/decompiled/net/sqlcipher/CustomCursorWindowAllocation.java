package net.sqlcipher;

public class CustomCursorWindowAllocation
  implements CursorWindowAllocation
{
  public long growthPaddingSize = 0L;
  public long initialAllocationSize = 0L;
  public long maxAllocationSize = 0L;
  
  public CustomCursorWindowAllocation(long paramLong1, long paramLong2, long paramLong3)
  {
    initialAllocationSize = paramLong1;
    growthPaddingSize = paramLong2;
    maxAllocationSize = paramLong3;
  }
  
  public long getGrowthPaddingSize()
  {
    return growthPaddingSize;
  }
  
  public long getInitialAllocationSize()
  {
    return initialAllocationSize;
  }
  
  public long getMaxAllocationSize()
  {
    return maxAllocationSize;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.CustomCursorWindowAllocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */