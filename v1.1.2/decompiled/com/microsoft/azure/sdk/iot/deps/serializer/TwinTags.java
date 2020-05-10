package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.j;
import e.c.c.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class TwinTags
{
  public static final String METADATA_TAG = "$metadata";
  public static final String VERSION_TAG = "$version";
  public Map<String, Object> tags = new HashMap();
  
  private void addProperty(m paramm, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Number))
    {
      paramm.a(paramString, paramm.a((Number)paramObject));
    }
    else if ((paramObject instanceof Boolean))
    {
      paramm.a(paramString, paramm.a((Boolean)paramObject));
    }
    else if ((paramObject instanceof Character))
    {
      paramm.a(paramString, paramm.a((Character)paramObject));
    }
    else
    {
      if ((paramObject.getClass().isLocalClass()) || (paramObject.getClass().isArray())) {
        break label103;
      }
      paramm.a(paramString, paramm.a(paramObject.toString()));
    }
    return;
    label103:
    throw new IllegalArgumentException("Type not supported");
  }
  
  private Map<String, Object> updateFromJson(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    try
    {
      HashMap localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      Iterator localIterator = paramMap1.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        paramMap1 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = ((Map.Entry)localObject1).getValue();
        Object localObject2 = paramMap2.get(paramMap1);
        if (!paramMap2.containsKey(paramMap1))
        {
          if (localObject1 != null)
          {
            paramMap2.put(paramMap1, localObject1);
            localHashMap.put(paramMap1, localObject1);
          }
        }
        else if (localObject1 == null)
        {
          paramMap2.remove(paramMap1);
          localHashMap.put(paramMap1, null);
        }
        else if ((localObject1 instanceof Map))
        {
          if ((localObject2 instanceof Map))
          {
            localObject1 = updateFromJson((Map)localObject1, (Map)localObject2);
            if (localObject1 != null) {
              localHashMap.put(paramMap1, localObject1);
            }
          }
          else
          {
            paramMap2.put(paramMap1, localObject1);
            localHashMap.put(paramMap1, localObject1);
          }
        }
        else
        {
          paramMap2.put(paramMap1, localObject1);
          localHashMap.put(paramMap1, localObject1);
        }
      }
      int i = localHashMap.size();
      paramMap1 = localHashMap;
      if (i == 0) {
        paramMap1 = null;
      }
      return paramMap1;
    }
    finally {}
  }
  
  private j updateFromMap(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    try
    {
      m localm = new e/c/c/m;
      localm.<init>();
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap1.next();
        String str = (String)((Map.Entry)localObject1).getKey();
        localObject1 = ((Map.Entry)localObject1).getValue();
        Object localObject2 = paramMap2.get(str);
        if (localObject1 == null)
        {
          paramMap2.remove(str);
          localm.a(str, null);
        }
        else if (!paramMap2.containsKey(str))
        {
          if ((localObject1 instanceof Map))
          {
            localObject2 = new java/util/HashMap;
            ((HashMap)localObject2).<init>();
            paramMap2.put(str, localObject2);
            localm.a(str, updateFromMap((Map)localObject1, (Map)paramMap2.get(str)));
          }
          else
          {
            paramMap2.put(str, localObject1);
            addProperty(localm, str, localObject1);
          }
        }
        else if ((localObject1 instanceof Map))
        {
          if (!(localObject2 instanceof Map))
          {
            localObject2 = new java/util/HashMap;
            ((HashMap)localObject2).<init>();
            paramMap2.put(str, localObject2);
          }
          localObject1 = updateFromMap((Map)localObject1, (Map)paramMap2.get(str));
          if ((localObject1 != null) && (!((j)localObject1).toString().equals("{}"))) {
            localm.a(str, (j)localObject1);
          }
        }
        else if (!localObject1.equals(localObject2))
        {
          paramMap2.put(str, localObject1);
          addProperty(localm, str, localObject1);
        }
      }
      return localm;
    }
    finally {}
  }
  
  public Map<String, Object> getMap()
  {
    try
    {
      Map localMap = tags;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String toJson()
  {
    return new e().a().a(tags);
  }
  
  public j toJsonElement()
  {
    return new e().a().b(tags);
  }
  
  public j update(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = updateFromMap(paramMap, tags);
      if (paramMap != null)
      {
        boolean bool = paramMap.toString().equals("{}");
        if (!bool) {
          return paramMap;
        }
      }
      return null;
    }
    finally {}
  }
  
  public void update(Map<String, Object> paramMap, TwinChangedCallback paramTwinChangedCallback)
  {
    paramMap = updateFromJson(paramMap, tags);
    if ((paramMap != null) && (paramTwinChangedCallback != null)) {
      paramTwinChangedCallback.execute(paramMap);
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
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.TwinTags
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */