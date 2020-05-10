package com.microsoft.azure.storage.table;

public enum TableUpdateType
{
  static
  {
    TableUpdateType localTableUpdateType = new TableUpdateType("REPLACE", 1);
    REPLACE = localTableUpdateType;
    $VALUES = new TableUpdateType[] { MERGE, localTableUpdateType };
  }
  
  public TableUpdateType() {}
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableUpdateType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */