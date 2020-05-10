package com.microsoft.azure.storage.blob;

public enum BlockListingFilter
{
  static
  {
    BlockListingFilter localBlockListingFilter = new BlockListingFilter("ALL", 2);
    ALL = localBlockListingFilter;
    $VALUES = new BlockListingFilter[] { COMMITTED, UNCOMMITTED, localBlockListingFilter };
  }
  
  public BlockListingFilter() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlockListingFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */