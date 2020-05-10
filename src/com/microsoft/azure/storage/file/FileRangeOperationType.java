package com.microsoft.azure.storage.file;

public enum FileRangeOperationType
{
  static
  {
    FileRangeOperationType localFileRangeOperationType = new FileRangeOperationType("CLEAR", 1);
    CLEAR = localFileRangeOperationType;
    $VALUES = new FileRangeOperationType[] { UPDATE, localFileRangeOperationType };
  }
  
  public FileRangeOperationType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileRangeOperationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */