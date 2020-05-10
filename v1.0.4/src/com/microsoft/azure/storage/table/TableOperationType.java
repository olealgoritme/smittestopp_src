package com.microsoft.azure.storage.table;

public enum TableOperationType
{
  static
  {
    DELETE = new TableOperationType("DELETE", 1);
    REPLACE = new TableOperationType("REPLACE", 2);
    RETRIEVE = new TableOperationType("RETRIEVE", 3);
    MERGE = new TableOperationType("MERGE", 4);
    INSERT_OR_REPLACE = new TableOperationType("INSERT_OR_REPLACE", 5);
    TableOperationType localTableOperationType = new TableOperationType("INSERT_OR_MERGE", 6);
    INSERT_OR_MERGE = localTableOperationType;
    $VALUES = new TableOperationType[] { INSERT, DELETE, REPLACE, RETRIEVE, MERGE, INSERT_OR_REPLACE, localTableOperationType };
  }
  
  public TableOperationType() {}
  
  public TableUpdateType getUpdateType()
  {
    if (this == INSERT_OR_MERGE) {
      return TableUpdateType.MERGE;
    }
    if (this == INSERT_OR_REPLACE) {
      return TableUpdateType.REPLACE;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableOperationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */