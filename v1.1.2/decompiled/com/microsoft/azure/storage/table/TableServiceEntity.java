package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TableServiceEntity
  implements TableEntity
{
  public static final int DEFAULT_CONCURRENCY_MULTIPLIER = 4;
  public static final int DEFAULT_INITIAL_CAPACITY = 31;
  public static final float DEFAULT_LOAD_FACTOR = 0.75F;
  public static boolean disableReflectedEntityCache = false;
  public static ConcurrentHashMap<Class<?>, HashMap<String, PropertyPair>> reflectedEntityCache = ;
  public String etag = null;
  public String partitionKey = null;
  public String rowKey = null;
  public Date timeStamp = new Date();
  
  public TableServiceEntity() {}
  
  public TableServiceEntity(String paramString1, String paramString2)
  {
    partitionKey = paramString1;
    rowKey = paramString2;
  }
  
  public static ConcurrentHashMap<Class<?>, HashMap<String, PropertyPair>> getReflectedEntityCache()
  {
    return reflectedEntityCache;
  }
  
  public static ConcurrentHashMap<Class<?>, HashMap<String, PropertyPair>> initialize()
  {
    return new ConcurrentHashMap(31, 0.75F, Runtime.getRuntime().availableProcessors() * 4);
  }
  
  public static boolean isReflectedEntityCacheDisabled()
  {
    return disableReflectedEntityCache;
  }
  
  public static void readEntityWithReflection(Object paramObject, HashMap<String, EntityProperty> paramHashMap, OperationContext paramOperationContext)
  {
    paramOperationContext = PropertyPair.generatePropertyPairs(paramObject.getClass());
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramHashMap = (Map.Entry)localIterator.next();
      if (paramOperationContext.containsKey(paramHashMap.getKey())) {
        ((PropertyPair)paramOperationContext.get(paramHashMap.getKey())).consumeEntityProperty((EntityProperty)paramHashMap.getValue(), paramObject);
      }
    }
  }
  
  public static void setReflectedEntityCacheDisabled(boolean paramBoolean)
  {
    ConcurrentHashMap localConcurrentHashMap = reflectedEntityCache;
    if ((localConcurrentHashMap != null) && (paramBoolean)) {
      localConcurrentHashMap.clear();
    }
    disableReflectedEntityCache = paramBoolean;
  }
  
  public static HashMap<String, EntityProperty> writeEntityWithReflection(Object paramObject)
  {
    Object localObject = PropertyPair.generatePropertyPairs(paramObject.getClass());
    HashMap localHashMap = new HashMap();
    localObject = ((HashMap)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localHashMap.put(getValueeffectiveName, ((PropertyPair)localEntry.getValue()).generateEntityProperty(paramObject));
    }
    return localHashMap;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public String getPartitionKey()
  {
    return partitionKey;
  }
  
  public String getRowKey()
  {
    return rowKey;
  }
  
  public Date getTimestamp()
  {
    return timeStamp;
  }
  
  public void readEntity(HashMap<String, EntityProperty> paramHashMap, OperationContext paramOperationContext)
  {
    try
    {
      readEntityWithReflection(this, paramHashMap, paramOperationContext);
      return;
    }
    catch (InvocationTargetException paramHashMap)
    {
      throw new StorageException("InternalError", "The entity threw an exception during deserialization.", 306, null, paramHashMap);
    }
    catch (IllegalAccessException paramHashMap)
    {
      throw new StorageException("InvalidDocument", "The entity threw an exception during deserialization.", 306, null, paramHashMap);
    }
    catch (IllegalArgumentException paramHashMap)
    {
      throw new StorageException("InvalidDocument", "The response received is invalid or improperly formatted.", 306, null, paramHashMap);
    }
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setPartitionKey(String paramString)
  {
    partitionKey = paramString;
  }
  
  public void setRowKey(String paramString)
  {
    rowKey = paramString;
  }
  
  public void setTimestamp(Date paramDate)
  {
    timeStamp = paramDate;
  }
  
  public HashMap<String, EntityProperty> writeEntity(OperationContext paramOperationContext)
  {
    try
    {
      paramOperationContext = writeEntityWithReflection(this);
      return paramOperationContext;
    }
    catch (InvocationTargetException paramOperationContext)
    {
      throw new StorageException("InternalError", "The entity threw an exception during serialization.", 306, null, paramOperationContext);
    }
    catch (IllegalAccessException paramOperationContext)
    {
      throw new StorageException("InternalError", "An attempt was made to access an inaccessible member of the entity during serialization.", 306, null, paramOperationContext);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableServiceEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */