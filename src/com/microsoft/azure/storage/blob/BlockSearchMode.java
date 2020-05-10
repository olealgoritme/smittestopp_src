package com.microsoft.azure.storage.blob;

public enum BlockSearchMode
{
  static
  {
    BlockSearchMode localBlockSearchMode = new BlockSearchMode("LATEST", 2);
    LATEST = localBlockSearchMode;
    $VALUES = new BlockSearchMode[] { COMMITTED, UNCOMMITTED, localBlockSearchMode };
  }
  
  public BlockSearchMode() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlockSearchMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */