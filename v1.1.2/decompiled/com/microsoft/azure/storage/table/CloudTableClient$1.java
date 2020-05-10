package com.microsoft.azure.storage.table;

import java.util.Date;
import java.util.HashMap;

public class CloudTableClient$1
  implements EntityResolver<String>
{
  public CloudTableClient$1(CloudTableClient paramCloudTableClient) {}
  
  public String resolve(String paramString1, String paramString2, Date paramDate, HashMap<String, EntityProperty> paramHashMap, String paramString3)
  {
    return ((EntityProperty)paramHashMap.get("TableName")).getValueAsString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.CloudTableClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */