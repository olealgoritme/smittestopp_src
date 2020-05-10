package net.sqlcipher;

public class DefaultCursorWindowAllocation
  implements CursorWindowAllocation
{
  public long WindowAllocationUnbounded = 0L;
  public long initialAllocationSize = 1048576L;
  
  public long getGrowthPaddingSize()
  {
    return initialAllocationSize;
  }
  
  public long getInitialAllocationSize()
  {
    return initialAllocationSize;
  }
  
  public long getMaxAllocationSize()
  {
    return WindowAllocationUnbounded;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.DefaultCursorWindowAllocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */