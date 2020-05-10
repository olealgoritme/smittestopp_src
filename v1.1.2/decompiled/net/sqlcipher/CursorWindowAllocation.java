package net.sqlcipher;

public abstract interface CursorWindowAllocation
{
  public abstract long getGrowthPaddingSize();
  
  public abstract long getInitialAllocationSize();
  
  public abstract long getMaxAllocationSize();
}

/* Location:
 * Qualified Name:     net.sqlcipher.CursorWindowAllocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */