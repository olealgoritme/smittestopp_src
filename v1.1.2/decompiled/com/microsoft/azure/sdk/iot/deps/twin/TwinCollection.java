package com.microsoft.azure.sdk.iot.deps.twin;

import com.microsoft.azure.sdk.iot.deps.serializer.ParserUtility;
import com.microsoft.azure.sdk.iot.deps.util.Tools;
import e.c.c.j;
import e.c.c.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TwinCollection
  extends HashMap<String, Object>
{
  public static final String METADATA_TAG = "$metadata";
  public static final String VERSION_TAG = "$version";
  public Map<String, TwinMetadata> metadataMap = new HashMap();
  public TwinMetadata twinMetadata;
  public Integer version;
  
  public TwinCollection() {}
  
  public TwinCollection(TwinCollection paramTwinCollection)
  {
    if ((paramTwinCollection != null) && (!paramTwinCollection.isEmpty()))
    {
      version = paramTwinCollection.getVersionFinal();
      twinMetadata = paramTwinCollection.getTwinMetadataFinal();
      Iterator localIterator = paramTwinCollection.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getValue() instanceof TwinCollection)) {
          super.put((String)localEntry.getKey(), new TwinCollection((TwinCollection)localEntry.getValue()));
        } else {
          super.put((String)localEntry.getKey(), localEntry.getValue());
        }
        metadataMap.put((String)localEntry.getKey(), paramTwinCollection.getTwinMetadataFinal((String)localEntry.getKey()));
      }
    }
  }
  
  public TwinCollection(Map<? extends String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      putAllFinal(paramMap);
    }
  }
  
  public static void addMetadata(TwinCollection paramTwinCollection, Map<? extends String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    Integer localInteger = null;
    paramMap = null;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (str.equals("$lastUpdated"))
      {
        paramMap = (String)localEntry.getValue();
      }
      else if ((str.equals("$lastUpdatedVersion")) && ((localEntry.getValue() instanceof Number)))
      {
        localInteger = Integer.valueOf(((Number)localEntry.getValue()).intValue());
      }
      else
      {
        Object localObject = paramTwinCollection.get(str);
        if (localObject != null)
        {
          TwinMetadata localTwinMetadata = TwinMetadata.tryExtractFromMap(localEntry.getValue());
          if (localTwinMetadata != null) {
            metadataMap.put(str, localTwinMetadata);
          }
          if ((localObject instanceof TwinCollection)) {
            addMetadata((TwinCollection)localObject, (Map)localEntry.getValue());
          }
        }
        else
        {
          throw new IllegalArgumentException("Twin metadata is inconsistent");
        }
      }
    }
    if ((localInteger != null) || (!Tools.isNullOrEmpty(paramMap).booleanValue())) {
      twinMetadata = new TwinMetadata(paramMap, localInteger);
    }
  }
  
  public static TwinCollection createFromRawCollection(Map<? extends String, Object> paramMap)
  {
    TwinCollection localTwinCollection = new TwinCollection();
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = null;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((String)localEntry.getKey()).equals("$version"))
      {
        if ((localEntry.getValue() instanceof Number)) {
          version = Integer.valueOf(((Number)localEntry.getValue()).intValue());
        } else {
          throw new IllegalArgumentException("version is not a number");
        }
      }
      else if (((String)localEntry.getKey()).equals("$metadata")) {
        paramMap = (Map)localEntry.getValue();
      } else {
        localTwinCollection.putFinal((String)localEntry.getKey(), localEntry.getValue());
      }
    }
    if (paramMap != null) {
      addMetadata(localTwinCollection, paramMap);
    }
    return localTwinCollection;
  }
  
  private void fillJsonMetadata(m paramm)
  {
    Object localObject1 = twinMetadata;
    if (localObject1 != null)
    {
      paramm.a("$lastUpdated", paramm.a(ParserUtility.dateTimeUtcToString(((TwinMetadata)localObject1).getLastUpdated())));
      paramm.a("$lastUpdatedVersion", paramm.a(twinMetadata.getLastUpdatedVersion()));
    }
    localObject1 = metadataMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
      if (localEntry.getValue() != null)
      {
        m localm = ((TwinMetadata)localEntry.getValue()).toJsonElement().c();
        Object localObject2 = get(localEntry.getKey());
        if ((localObject2 instanceof TwinCollection)) {
          ((TwinCollection)localObject2).fillJsonMetadata(localm);
        }
        paramm.a((String)localEntry.getKey(), localm);
      }
    }
  }
  
  @Deprecated
  public TwinMetadata getTwinMetadata()
  {
    TwinMetadata localTwinMetadata = twinMetadata;
    if (localTwinMetadata == null) {
      return null;
    }
    return new TwinMetadata(localTwinMetadata);
  }
  
  @Deprecated
  public TwinMetadata getTwinMetadata(String paramString)
  {
    if (metadataMap.get(paramString) == null) {
      return null;
    }
    return new TwinMetadata((TwinMetadata)metadataMap.get(paramString));
  }
  
  public final TwinMetadata getTwinMetadataFinal()
  {
    TwinMetadata localTwinMetadata = twinMetadata;
    if (localTwinMetadata == null) {
      return null;
    }
    return new TwinMetadata(localTwinMetadata);
  }
  
  public final TwinMetadata getTwinMetadataFinal(String paramString)
  {
    if (metadataMap.get(paramString) == null) {
      return null;
    }
    return new TwinMetadata((TwinMetadata)metadataMap.get(paramString));
  }
  
  @Deprecated
  public Integer getVersion()
  {
    return version;
  }
  
  public final Integer getVersionFinal()
  {
    return version;
  }
  
  @Deprecated
  public Object put(String paramString, Object paramObject)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Object localObject = get(paramString);
      if ((paramObject instanceof Map)) {
        super.put(paramString, new TwinCollection((Map)paramObject));
      } else {
        super.put(paramString, paramObject);
      }
      if ((!paramString.equals("$version")) && (!paramString.equals("$metadata"))) {
        ParserUtility.validateMap(this);
      }
      return localObject;
    }
    throw new IllegalArgumentException("Key cannot be null or empty");
  }
  
  @Deprecated
  public void putAll(Map<? extends String, ?> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        putFinal((String)paramMap.getKey(), paramMap.getValue());
      }
      return;
    }
    throw new IllegalArgumentException("map to add cannot be null or empty.");
  }
  
  public final void putAllFinal(Map<? extends String, ?> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        putFinal((String)localEntry.getKey(), localEntry.getValue());
      }
      return;
    }
    throw new IllegalArgumentException("map to add cannot be null or empty.");
  }
  
  public final Object putFinal(String paramString, Object paramObject)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      Object localObject = get(paramString);
      if ((paramObject instanceof Map)) {
        super.put(paramString, new TwinCollection((Map)paramObject));
      } else {
        super.put(paramString, paramObject);
      }
      if ((!paramString.equals("$version")) && (!paramString.equals("$metadata"))) {
        ParserUtility.validateMap(this);
      }
      return localObject;
    }
    throw new IllegalArgumentException("Key cannot be null or empty");
  }
  
  public j toJsonElement()
  {
    return ParserUtility.mapToJsonElement(this);
  }
  
  public j toJsonElementWithMetadata()
  {
    m localm = ParserUtility.mapToJsonElement(this).c();
    Object localObject = version;
    if (localObject != null) {
      localm.a("$version", localm.a(localObject));
    }
    localObject = new m();
    fillJsonMetadata((m)localObject);
    if (!((m)localObject).g().isEmpty()) {
      localm.a("$metadata", (j)localObject);
    }
    return localm;
  }
  
  public String toString()
  {
    return toJsonElementWithMetadata().toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.twin.TwinCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */