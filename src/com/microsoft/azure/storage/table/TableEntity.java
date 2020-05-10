package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import java.util.Date;
import java.util.HashMap;

public abstract interface TableEntity
{
  public abstract String getEtag();
  
  public abstract String getPartitionKey();
  
  public abstract String getRowKey();
  
  public abstract Date getTimestamp();
  
  public abstract void readEntity(HashMap<String, EntityProperty> paramHashMap, OperationContext paramOperationContext);
  
  public abstract void setEtag(String paramString);
  
  public abstract void setPartitionKey(String paramString);
  
  public abstract void setRowKey(String paramString);
  
  public abstract void setTimestamp(Date paramDate);
  
  public abstract HashMap<String, EntityProperty> writeEntity(OperationContext paramOperationContext);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */