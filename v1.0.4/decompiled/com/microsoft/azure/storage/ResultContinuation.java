package com.microsoft.azure.storage;

public final class ResultContinuation
{
  public ResultContinuationType continuationType;
  public String nextMarker;
  public String nextPartitionKey;
  public String nextRowKey;
  public String nextTableName;
  public StorageLocation targetLocation;
  
  public ResultContinuationType getContinuationType()
  {
    return continuationType;
  }
  
  public String getNextMarker()
  {
    return nextMarker;
  }
  
  public String getNextPartitionKey()
  {
    return nextPartitionKey;
  }
  
  public String getNextRowKey()
  {
    return nextRowKey;
  }
  
  public String getNextTableName()
  {
    return nextTableName;
  }
  
  public StorageLocation getTargetLocation()
  {
    return targetLocation;
  }
  
  public boolean hasContinuation()
  {
    boolean bool;
    if ((getNextMarker() == null) && (nextPartitionKey == null) && (nextRowKey == null) && (nextTableName == null)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void setContinuationType(ResultContinuationType paramResultContinuationType)
  {
    continuationType = paramResultContinuationType;
  }
  
  public void setNextMarker(String paramString)
  {
    nextMarker = paramString;
  }
  
  public void setNextPartitionKey(String paramString)
  {
    nextPartitionKey = paramString;
  }
  
  public void setNextRowKey(String paramString)
  {
    nextRowKey = paramString;
  }
  
  public void setNextTableName(String paramString)
  {
    nextTableName = paramString;
  }
  
  public void setTargetLocation(StorageLocation paramStorageLocation)
  {
    targetLocation = paramStorageLocation;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.ResultContinuation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */