package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.j;
import e.c.c.w.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Deprecated
public class TwinProperty
{
  public static final String LAST_UPDATE_TAG = "$lastUpdated";
  public static final String LAST_UPDATE_VERSION_TAG = "$lastUpdatedVersion";
  public static final String METADATA_TAG = "$metadata";
  public static final String VERSION_TAG = "$version";
  public Object lock = new Object();
  public ConcurrentMap<String, Property> property = new ConcurrentHashMap();
  public Boolean reportMetadata = Boolean.valueOf(false);
  public Integer version = null;
  
  private Map<String, Object> updateFields(Map<String, Object> arg1)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ???.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localHashMap;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((String)localEntry.getKey()).isEmpty())
      {
        if (((String)localEntry.getKey()).contains("$")) {
          continue;
        }
        synchronized (lock)
        {
          ConcurrentMap localConcurrentMap;
          Object localObject1;
          Object localObject2;
          if (property.containsKey(localEntry.getKey()))
          {
            if (localEntry.getValue() == null)
            {
              property.remove(localEntry.getKey());
              localHashMap.put(localEntry.getKey(), null);
            }
            else if (!Property.access$000((Property)property.get(localEntry.getKey())).equals(localEntry.getValue()))
            {
              localConcurrentMap = property;
              localObject1 = localEntry.getKey();
              localObject2 = new com/microsoft/azure/sdk/iot/deps/serializer/TwinProperty$Property;
              ((Property)localObject2).<init>(this, localEntry.getValue(), null, null);
              localConcurrentMap.put(localObject1, localObject2);
              localHashMap.put(localEntry.getKey(), localEntry.getValue());
            }
          }
          else if (localEntry.getValue() != null)
          {
            localConcurrentMap = property;
            localObject2 = localEntry.getKey();
            localObject1 = new com/microsoft/azure/sdk/iot/deps/serializer/TwinProperty$Property;
            ((Property)localObject1).<init>(this, localEntry.getValue(), null, null);
            localConcurrentMap.put(localObject2, localObject1);
            localHashMap.put(localEntry.getKey(), localEntry.getValue());
          }
        }
      }
    }
    throw new IllegalArgumentException("Invalid Key on Json");
    return localMap;
  }
  
  private Map<String, Object> updateMetadata(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramMap = (Map.Entry)((Iterator)localObject1).next();
      if (((String)paramMap.getKey()).equals("$metadata"))
      {
        Iterator localIterator1 = ((Map)paramMap.getValue()).entrySet().iterator();
        while (localIterator1.hasNext())
        {
          Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
          synchronized (lock)
          {
            if (property.containsKey(localEntry1.getKey()))
            {
              Iterator localIterator2 = ((Map)localEntry1.getValue()).entrySet().iterator();
              localObject1 = null;
              paramMap = null;
              while (localIterator2.hasNext())
              {
                Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
                if (((String)localEntry2.getKey()).equals("$lastUpdated")) {
                  localObject1 = localEntry2.getValue().toString();
                } else if (((String)localEntry2.getKey()).equals("$lastUpdatedVersion")) {
                  paramMap = Integer.valueOf((int)((Double)localEntry2.getValue()).doubleValue());
                }
              }
              if (Property.access$200((Property)property.get(localEntry1.getKey())).update((String)localObject1, paramMap)) {
                localHashMap.put(localEntry1.getKey(), localEntry1.getValue());
              }
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  private void updateVersion(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if (((String)paramMap.getKey()).equals("$version")) {
        version = new Integer((int)((Double)paramMap.getValue()).doubleValue());
      }
    }
  }
  
  public Boolean addProperty(String paramString, Object paramObject, Integer paramInteger)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        if (paramString.length() <= 128)
        {
          if ((!paramString.contains(".")) && (!paramString.contains(" ")) && (!paramString.contains("$")))
          {
            if (paramObject == null)
            {
              if (property.containsKey(paramString)) {
                property.remove(paramString);
              }
              paramString = Boolean.valueOf(true);
            }
            else
            {
              if ((!property.containsKey(paramString)) || (!Property.access$000((Property)property.get(paramString)).equals(paramObject)) || (reportMetadata.booleanValue())) {
                localBoolean = Boolean.valueOf(true);
              }
              property.put(paramString, new Property(paramObject, paramInteger, null));
              paramString = localBoolean;
            }
            return paramString;
          }
          throw new IllegalArgumentException("Property key contains illegal character");
        }
        throw new IllegalArgumentException("Property key is too big for json");
      }
      throw new IllegalArgumentException("Property key shall not be empty");
    }
    throw new IllegalArgumentException("Property key shall not be null");
  }
  
  public void enableMetadata()
  {
    reportMetadata = Boolean.valueOf(true);
  }
  
  public Object get(String paramString)
  {
    synchronized (lock)
    {
      if (property.containsKey(paramString)) {
        paramString = Property.access$000((Property)property.get(paramString));
      } else {
        paramString = null;
      }
      return paramString;
    }
  }
  
  public TwinMetadata getMetadata(String paramString)
  {
    synchronized (lock)
    {
      if (property.containsKey(paramString)) {
        paramString = Property.access$200((Property)property.get(paramString));
      } else {
        paramString = null;
      }
      return paramString;
    }
  }
  
  public Map<String, Object> getPropertyMap()
  {
    synchronized (lock)
    {
      boolean bool = property.isEmpty();
      HashMap localHashMap = null;
      if (!bool)
      {
        localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        Iterator localIterator = property.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          Object localObject3 = Property.access$000((Property)localEntry.getValue());
          if (localObject3 == null) {
            localHashMap.put(localEntry.getKey(), null);
          } else {
            localHashMap.put(localEntry.getKey(), localObject3);
          }
        }
      }
      return localHashMap;
    }
  }
  
  public Integer getVersion()
  {
    return version;
  }
  
  public int size()
  {
    return property.size();
  }
  
  public String toJson()
  {
    return toJsonElement().toString();
  }
  
  public j toJsonElement()
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    synchronized (lock)
    {
      Iterator localIterator = property.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap1.put(localEntry.getKey(), Property.access$000((Property)localEntry.getValue()));
        localHashMap2.put(localEntry.getKey(), Property.access$200((Property)localEntry.getValue()).toJsonElement());
      }
      if (reportMetadata.booleanValue()) {
        localHashMap1.put("$metadata", localHashMap2);
      }
      ??? = version;
      if (??? != null) {
        localHashMap1.put("$version", ???);
      }
      return ParserUtility.mapToJsonElement(localHashMap1);
    }
  }
  
  public j update(Map<String, Object> paramMap)
  {
    TwinProperty localTwinProperty = new TwinProperty();
    Object localObject1 = lock;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    if (paramMap != null) {
      try
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (addProperty((String)localEntry.getKey(), localEntry.getValue(), null).booleanValue())
          {
            ConcurrentMap localConcurrentMap = property;
            Object localObject4 = localEntry.getKey();
            localObject3 = new com/microsoft/azure/sdk/iot/deps/serializer/TwinProperty$Property;
            ((Property)localObject3).<init>(this, localEntry.getValue(), null, null);
            localConcurrentMap.put(localObject4, localObject3);
          }
        }
        localObject3 = localObject2;
        if (localTwinProperty.size() > 0) {
          localObject3 = localTwinProperty.toJsonElement();
        }
      }
      finally
      {
        break label165;
      }
    }
    return (j)localObject3;
    label165:
    throw paramMap;
  }
  
  public void update(String paramString, TwinChangedCallback paramTwinChangedCallback)
  {
    try
    {
      e locale = new e/c/c/e;
      locale.<init>();
      paramString = locale.a().a(paramString, Map.class);
      paramString = (Map)t.a(Map.class).cast(paramString);
      update(paramString, paramTwinChangedCallback);
      return;
    }
    catch (Exception paramTwinChangedCallback)
    {
      paramString = new StringBuilder();
      paramString.append("Malformed Json:");
      paramString.append(paramTwinChangedCallback);
      throw new IllegalArgumentException(paramString.toString());
    }
  }
  
  public void update(Map<String, Object> paramMap, TwinChangedCallback paramTwinChangedCallback)
  {
    new HashMap();
    new HashMap();
    try
    {
      updateVersion(paramMap);
      Map localMap = updateFields(paramMap);
      paramMap = updateMetadata(paramMap);
      if (reportMetadata.booleanValue())
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramMap = (Property)property.get(localEntry.getKey());
          if (paramMap == null) {
            localMap.put(localEntry.getKey(), null);
          } else {
            localMap.put(localEntry.getKey(), Property.access$000(paramMap));
          }
        }
      }
      if ((localMap.size() != 0) && (paramTwinChangedCallback != null)) {
        paramTwinChangedCallback.execute(localMap);
      }
      return;
    }
    catch (Exception paramMap)
    {
      paramTwinChangedCallback = new StringBuilder();
      paramTwinChangedCallback.append("Malformed Json:");
      paramTwinChangedCallback.append(paramMap);
      throw new IllegalArgumentException(paramTwinChangedCallback.toString());
    }
  }
  
  public void validate(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        if (((String)paramMap.getKey()).equals("$metadata"))
        {
          if ((paramMap.getValue() instanceof Map)) {
            ParserUtility.validateMap((Map)paramMap.getValue());
          }
        }
        else if ((!((String)paramMap.getKey()).equals("$version")) && ((paramMap.getValue() instanceof Map))) {
          ParserUtility.validateMap((Map)paramMap.getValue());
        }
      }
      return;
    }
    throw new IllegalArgumentException("property cannot be null");
  }
  
  public class Property
  {
    public TwinMetadata metadata;
    public Object value;
    
    public Property(Object paramObject, Integer paramInteger)
    {
      value = paramObject;
      metadata = new TwinMetadata(paramInteger);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.TwinProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */