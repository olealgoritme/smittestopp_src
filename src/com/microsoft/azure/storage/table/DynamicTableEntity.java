package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import java.util.HashMap;

public class DynamicTableEntity
  extends TableServiceEntity
{
  public HashMap<String, EntityProperty> properties = new HashMap();
  
  public DynamicTableEntity() {}
  
  public DynamicTableEntity(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public DynamicTableEntity(String paramString1, String paramString2, String paramString3, HashMap<String, EntityProperty> paramHashMap)
  {
    super(paramString1, paramString2);
    etag = paramString3;
    setProperties(paramHashMap);
  }
  
  public DynamicTableEntity(String paramString1, String paramString2, HashMap<String, EntityProperty> paramHashMap)
  {
    this(paramString1, paramString2, null, paramHashMap);
  }
  
  public DynamicTableEntity(HashMap<String, EntityProperty> paramHashMap)
  {
    setProperties(paramHashMap);
  }
  
  public HashMap<String, EntityProperty> getProperties()
  {
    return properties;
  }
  
  public void readEntity(HashMap<String, EntityProperty> paramHashMap, OperationContext paramOperationContext)
  {
    setProperties(paramHashMap);
  }
  
  public void setProperties(HashMap<String, EntityProperty> paramHashMap)
  {
    properties = paramHashMap;
  }
  
  public HashMap<String, EntityProperty> writeEntity(OperationContext paramOperationContext)
  {
    return getProperties();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.DynamicTableEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */