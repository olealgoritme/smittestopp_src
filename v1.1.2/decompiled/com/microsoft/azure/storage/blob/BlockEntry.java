package com.microsoft.azure.storage.blob;

public final class BlockEntry
{
  public String id;
  public BlockSearchMode searchMode;
  public long size;
  
  public BlockEntry(String paramString)
  {
    setId(paramString);
    searchMode = BlockSearchMode.LATEST;
  }
  
  public BlockEntry(String paramString, BlockSearchMode paramBlockSearchMode)
  {
    setId(paramString);
    searchMode = paramBlockSearchMode;
  }
  
  public String getId()
  {
    return id;
  }
  
  public BlockSearchMode getSearchMode()
  {
    return searchMode;
  }
  
  public long getSize()
  {
    return size;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setSearchMode(BlockSearchMode paramBlockSearchMode)
  {
    searchMode = paramBlockSearchMode;
  }
  
  public void setSize(long paramLong)
  {
    size = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlockEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */