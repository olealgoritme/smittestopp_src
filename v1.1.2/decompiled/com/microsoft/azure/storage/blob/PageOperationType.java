package com.microsoft.azure.storage.blob;

public enum PageOperationType
{
  static
  {
    PageOperationType localPageOperationType = new PageOperationType("CLEAR", 1);
    CLEAR = localPageOperationType;
    $VALUES = new PageOperationType[] { UPDATE, localPageOperationType };
  }
  
  public PageOperationType() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.PageOperationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */