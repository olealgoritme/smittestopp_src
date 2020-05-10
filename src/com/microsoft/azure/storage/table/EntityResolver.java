package com.microsoft.azure.storage.table;

import java.util.Date;
import java.util.HashMap;

public abstract interface EntityResolver<T>
{
  public abstract T resolve(String paramString1, String paramString2, Date paramDate, HashMap<String, EntityProperty> paramHashMap, String paramString3);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.EntityResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */