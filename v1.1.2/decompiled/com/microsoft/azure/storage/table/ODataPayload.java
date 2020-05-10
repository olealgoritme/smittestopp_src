package com.microsoft.azure.storage.table;

import java.util.ArrayList;

public final class ODataPayload<T>
{
  public ArrayList<T> results = new ArrayList();
  public ArrayList<TableResult> tableResults = new ArrayList();
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.ODataPayload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */