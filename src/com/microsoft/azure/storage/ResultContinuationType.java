package com.microsoft.azure.storage;

public enum ResultContinuationType
{
  static
  {
    BLOB = new ResultContinuationType("BLOB", 1);
    CONTAINER = new ResultContinuationType("CONTAINER", 2);
    FILE = new ResultContinuationType("FILE", 3);
    QUEUE = new ResultContinuationType("QUEUE", 4);
    TABLE = new ResultContinuationType("TABLE", 5);
    ResultContinuationType localResultContinuationType = new ResultContinuationType("SHARE", 6);
    SHARE = localResultContinuationType;
    $VALUES = new ResultContinuationType[] { NONE, BLOB, CONTAINER, FILE, QUEUE, TABLE, localResultContinuationType };
  }
  
  public ResultContinuationType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ResultContinuationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */