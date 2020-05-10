package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.core.Utility;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class PropertyPair
{
  public String effectiveName = null;
  public Method getter = null;
  public boolean isEncrypted = false;
  public String name = null;
  public Method setter = null;
  public Class<?> type = null;
  
  public static HashMap<String, PropertyPair> generatePropertyPairs(Class<?> paramClass)
  {
    if (!TableServiceEntity.isReflectedEntityCacheDisabled())
    {
      new HashMap();
      HashMap localHashMap1 = (HashMap)TableServiceEntity.getReflectedEntityCache().get(paramClass);
      HashMap localHashMap2 = localHashMap1;
      if (localHashMap1 == null)
      {
        localHashMap2 = generatePropertyPairsHelper(paramClass);
        TableServiceEntity.getReflectedEntityCache().put(paramClass, localHashMap2);
      }
      return localHashMap2;
    }
    return generatePropertyPairsHelper(paramClass);
  }
  
  public static HashMap<String, PropertyPair> generatePropertyPairsHelper(Class<?> paramClass)
  {
    Object localObject1 = paramClass.getMethods();
    HashMap localHashMap = new HashMap();
    int i = localObject1.length;
    Object localObject3;
    for (int j = 0; j < i; j++)
    {
      localObject2 = localObject1[j];
      if ((((Method)localObject2).getName().length() >= 4) && ((((Method)localObject2).getName().startsWith("get")) || (((Method)localObject2).getName().startsWith("set"))))
      {
        localObject3 = ((Method)localObject2).getName().substring(3);
        if ((!((String)localObject3).equals("PartitionKey")) && (!((String)localObject3).equals("RowKey")) && (!((String)localObject3).equals("Timestamp")) && (!((String)localObject3).equals("Etag")) && (!((String)localObject3).equals("LastModified")))
        {
          if (localHashMap.containsKey(localObject3))
          {
            paramClass = (PropertyPair)localHashMap.get(localObject3);
          }
          else
          {
            paramClass = new PropertyPair();
            name = ((String)localObject3);
            localHashMap.put(localObject3, paramClass);
          }
          if ((((Method)localObject2).getName().startsWith("get")) && (((Method)localObject2).getParameterTypes().length == 0))
          {
            type = ((Method)localObject2).getReturnType();
            getter = ((Method)localObject2);
          }
          else if ((((Method)localObject2).getName().startsWith("set")) && (((Method)localObject2).getParameterTypes().length == 1) && (Void.TYPE.equals(((Method)localObject2).getReturnType())))
          {
            setter = ((Method)localObject2);
          }
          localObject2 = (StoreAs)((Method)localObject2).getAnnotation(StoreAs.class);
          if (localObject2 != null) {
            if (!Utility.isNullOrEmpty(((StoreAs)localObject2).name()))
            {
              localObject3 = effectiveName;
              if ((localObject3 != null) && (!((String)localObject3).equals(name)) && (!effectiveName.equals(((StoreAs)localObject2).name()))) {
                throw new IllegalArgumentException(String.format("StoreAs Annotation found for both getter and setter for property %s with unequal values.", new Object[] { name }));
              }
              if (!name.equals(((StoreAs)localObject2).name())) {
                effectiveName = ((StoreAs)localObject2).name();
              }
            }
            else
            {
              throw new IllegalArgumentException(String.format("StoreAs Annotation found for property %s with empty value.", new Object[] { name }));
            }
          }
        }
      }
    }
    Object localObject2 = new ArrayList();
    paramClass = new ArrayList();
    Iterator localIterator = localHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (Map.Entry)localIterator.next();
      localObject1 = (PropertyPair)((Map.Entry)localObject3).getValue();
      boolean bool;
      if ((getValuesetter != null) && (getValuesetter.isAnnotationPresent(Encrypt.class))) {
        bool = true;
      } else {
        bool = false;
      }
      isEncrypted = bool;
      if (!((PropertyPair)((Map.Entry)localObject3).getValue()).shouldProcess()) {
        ((ArrayList)localObject2).add(((Map.Entry)localObject3).getKey());
      } else if (!Utility.isNullOrEmpty(getValueeffectiveName)) {
        paramClass.add(((Map.Entry)localObject3).getKey());
      } else {
        getValueeffectiveName = getValuename;
      }
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localHashMap.remove((String)((Iterator)localObject1).next());
    }
    localObject2 = paramClass.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      paramClass = (PropertyPair)localHashMap.get(localObject1);
      localHashMap.remove(localObject1);
      localHashMap.put(effectiveName, paramClass);
    }
    return localHashMap;
  }
  
  public void consumeEntityProperty(EntityProperty paramEntityProperty, Object paramObject)
  {
    Class localClass = setter.getParameterTypes()[0];
    if (paramEntityProperty.getIsNull())
    {
      if (!localClass.isPrimitive()) {
        setter.invoke(paramObject, new Object[] { null });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.STRING)
    {
      if (localClass.equals(String.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsString() });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.BINARY)
    {
      if (localClass.equals(Byte[].class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsByteObjectArray() });
      } else if (localClass.equals(byte[].class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsByteArray() });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.BOOLEAN)
    {
      if (localClass.equals(Boolean.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsBooleanObject() });
      } else if (localClass.equals(Boolean.TYPE)) {
        setter.invoke(paramObject, new Object[] { Boolean.valueOf(paramEntityProperty.getValueAsBoolean()) });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.DOUBLE)
    {
      if (localClass.equals(Double.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsDoubleObject() });
      } else if (localClass.equals(Double.TYPE)) {
        setter.invoke(paramObject, new Object[] { Double.valueOf(paramEntityProperty.getValueAsDouble()) });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.GUID)
    {
      if (localClass.equals(UUID.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsUUID() });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.INT32)
    {
      if (localClass.equals(Integer.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsIntegerObject() });
      } else if (localClass.equals(Integer.TYPE)) {
        setter.invoke(paramObject, new Object[] { Integer.valueOf(paramEntityProperty.getValueAsInteger()) });
      }
    }
    else if (paramEntityProperty.getEdmType() == EdmType.INT64)
    {
      if (localClass.equals(Long.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsLongObject() });
      } else if (localClass.equals(Long.TYPE)) {
        setter.invoke(paramObject, new Object[] { Long.valueOf(paramEntityProperty.getValueAsLong()) });
      }
    }
    else
    {
      if (paramEntityProperty.getEdmType() != EdmType.DATE_TIME) {
        break label559;
      }
      if (localClass.equals(Date.class)) {
        setter.invoke(paramObject, new Object[] { paramEntityProperty.getValueAsDate() });
      }
    }
    return;
    label559:
    throw new IllegalArgumentException(String.format("Property %s with Edm Type %s cannot be de-serialized.", new Object[] { name, paramEntityProperty.getEdmType().toString() }));
  }
  
  public EntityProperty generateEntityProperty(Object paramObject)
  {
    Class localClass = getter.getReturnType();
    paramObject = new EntityProperty(getter.invoke(paramObject, null), localClass);
    ((EntityProperty)paramObject).setIsEncrypted(isEncrypted);
    return (EntityProperty)paramObject;
  }
  
  public boolean shouldProcess()
  {
    if (!Utility.isNullOrEmpty(name))
    {
      Method localMethod = getter;
      if ((localMethod != null) && (!localMethod.isAnnotationPresent(Ignore.class)))
      {
        localMethod = setter;
        if ((localMethod != null) && (!localMethod.isAnnotationPresent(Ignore.class)) && (getter.getReturnType().equals(setter.getParameterTypes()[0]))) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.PropertyPair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */