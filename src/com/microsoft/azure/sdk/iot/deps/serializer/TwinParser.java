package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import com.google.gson.internal.Excluder;
import e.c.c.e;
import e.c.c.j;
import e.c.c.m;
import e.c.c.s;
import e.c.c.w.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class TwinParser
{
  public static final String DESIRED_TAG = "desired";
  public static final int MAX_MAP_LEVEL = 5;
  public static final String PROPERTIES_TAG = "properties";
  public static final String REPORTED_TAG = "reported";
  public static final String TAGS_TAG = "tags";
  public static TwinChangedCallback onTagsCallback;
  public RegisterManagerParser manager = new RegisterManagerParser();
  public TwinChangedCallback onDesiredCallback = null;
  public TwinChangedCallback onReportedCallback = null;
  public TwinProperties properties = new TwinProperties();
  public TwinTags tags = null;
  
  public TwinParser() {}
  
  public TwinParser(TwinChangedCallback paramTwinChangedCallback)
  {
    this();
    setDesiredCallback(paramTwinChangedCallback);
  }
  
  public TwinParser(TwinChangedCallback paramTwinChangedCallback1, TwinChangedCallback paramTwinChangedCallback2)
  {
    this();
    setDesiredCallback(paramTwinChangedCallback1);
    setReportedCallback(paramTwinChangedCallback2);
  }
  
  private j innerUpdateDesiredProperty(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      validateMap(paramMap);
      paramMap = properties.updateDesired(paramMap);
    }
    else
    {
      paramMap = null;
    }
    return paramMap;
  }
  
  private j innerUpdateReportedProperty(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      validateMap(paramMap);
      paramMap = properties.updateReported(paramMap);
    }
    else
    {
      paramMap = null;
    }
    return paramMap;
  }
  
  private j innerUpdateTags(Map<String, Object> paramMap)
  {
    if (tags != null)
    {
      if (paramMap != null)
      {
        validateMap(paramMap);
        return tags.update(paramMap);
      }
      throw new IllegalArgumentException("Null tags map");
    }
    throw new IOException("Update not enabled Tags");
  }
  
  private void validateJson(String paramString)
  {
    try
    {
      localObject1 = new e/c/c/e;
      ((e)localObject1).<init>();
      Object localObject2 = a.clone();
      int i = 0;
      z = false;
      a = ((Excluder)localObject2);
      l = false;
      paramString = ((e)localObject1).a().a(paramString, HashMap.class);
      paramString = (Map)t.a(HashMap.class).cast(paramString);
      if (paramString != null)
      {
        localObject1 = paramString.entrySet().iterator();
        int j = 1;
        int k = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
          if (((String)localEntry.getKey()).equals("properties"))
          {
            properties.validate((Map)localEntry.getValue());
          }
          else
          {
            if ((((String)localEntry.getKey()).equals("desired")) || (((String)localEntry.getKey()).equals("reported"))) {
              break label227;
            }
            if (!((String)localEntry.getKey()).equals("tags")) {
              continue;
            }
            localObject2 = tags;
            if (localObject2 != null) {
              ((TwinTags)localObject2).validate((Map)localEntry.getValue());
            }
          }
          i = 1;
          k = 1;
          continue;
          label227:
          if (k == 0)
          {
            properties.validate(paramString);
            i = j;
          }
          else
          {
            throw new IllegalArgumentException("Invalid Entry");
          }
        }
        if (i == 0) {
          throw new IllegalArgumentException("Json do not contains twin information");
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Malformed Json: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
  }
  
  private void validateMap(Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      validateMap(paramMap, 0, 5);
    }
  }
  
  private void validateMap(Map<String, Object> paramMap, int paramInt1, int paramInt2)
  {
    paramInt1++;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = ((Map.Entry)localIterator.next()).getValue();
      if ((paramMap != null) && ((paramMap.getClass().isArray()) || (paramMap.getClass().isLocalClass()))) {
        throw new IllegalArgumentException("Malformed Json: illegal value type");
      }
      if ((paramMap != null) && ((paramMap instanceof Map))) {
        if (paramInt1 <= paramInt2) {
          validateMap((Map)paramMap, paramInt1, paramInt2);
        } else {
          throw new IllegalArgumentException("Malformed Json: exceed 5 levels");
        }
      }
    }
  }
  
  public void enableMetadata()
  {
    properties.enableDesiredMetadata();
    properties.enableReportedMetadata();
  }
  
  public void enableTags()
  {
    if (tags == null) {
      tags = new TwinTags();
    }
  }
  
  public TwinConnectionState getConnectionState()
  {
    return manager.connectionState;
  }
  
  public String getConnectionStateUpdatedTime()
  {
    return manager.connectionStateUpdatedTime;
  }
  
  public Map<String, Object> getDesiredPropertyMap()
  {
    return properties.getDesiredPropertyMap();
  }
  
  public Integer getDesiredPropertyVersion()
  {
    return properties.getDesiredVersion();
  }
  
  public String getDeviceId()
  {
    return manager.deviceId;
  }
  
  public String getETag()
  {
    return manager.eTag;
  }
  
  public String getGenerationId()
  {
    return manager.generationId;
  }
  
  public String getLastActivityTime()
  {
    return manager.lastActivityTime;
  }
  
  public Map<String, Object> getReportedPropertyMap()
  {
    return properties.getReportedPropertyMap();
  }
  
  public Integer getReportedPropertyVersion()
  {
    return properties.getReportedVersion();
  }
  
  public TwinStatus getStatus()
  {
    return manager.status;
  }
  
  public String getStatusReason()
  {
    return manager.statusReason;
  }
  
  public String getStatusUpdatedTime()
  {
    return manager.statusUpdatedTime;
  }
  
  public Map<String, Object> getTagsMap()
  {
    TwinTags localTwinTags = tags;
    if (localTwinTags != null) {
      return localTwinTags.getMap();
    }
    throw new IOException("Update not enabled Tags");
  }
  
  public Integer getVersion()
  {
    return manager.version;
  }
  
  public String resetDesiredProperty(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      validateMap(paramMap);
      paramMap = properties.resetDesired(paramMap);
      if (paramMap == null) {
        paramMap = "{}";
      } else {
        paramMap = paramMap.toString();
      }
      return paramMap;
    }
    throw new IllegalArgumentException("Null property map");
  }
  
  public String resetReportedProperty(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      validateMap(paramMap);
      paramMap = properties.resetReported(paramMap);
      if (paramMap == null) {
        paramMap = "{}";
      } else {
        paramMap = paramMap.toString();
      }
      return paramMap;
    }
    throw new IllegalArgumentException("Null property map");
  }
  
  public String resetTags(Map<String, Object> paramMap)
  {
    if (tags != null)
    {
      if (paramMap != null)
      {
        validateMap(paramMap);
        TwinTags localTwinTags = new TwinTags();
        tags = localTwinTags;
        paramMap = localTwinTags.update(paramMap);
        if (paramMap == null) {
          paramMap = "{}";
        } else {
          paramMap = paramMap.toString();
        }
        return paramMap;
      }
      throw new IllegalArgumentException("Null tags map");
    }
    throw new IOException("Update not enabled Tags");
  }
  
  public void setDesiredCallback(TwinChangedCallback paramTwinChangedCallback)
  {
    onDesiredCallback = paramTwinChangedCallback;
  }
  
  public void setDeviceId(String paramString)
  {
    ParserUtility.validateId(paramString);
    manager.setDeviceId(paramString);
  }
  
  public void setETag(String paramString)
  {
    ParserUtility.validateStringUTF8(paramString);
    manager.eTag = paramString;
  }
  
  public void setReportedCallback(TwinChangedCallback paramTwinChangedCallback)
  {
    onReportedCallback = paramTwinChangedCallback;
  }
  
  public void setTagsCallback(TwinChangedCallback paramTwinChangedCallback)
  {
    onTagsCallback = paramTwinChangedCallback;
  }
  
  public String toJson()
  {
    return toJsonElement().toString();
  }
  
  public j toJsonElement()
  {
    Object localObject = new e();
    l = false;
    m localm = ((e)localObject).a().b(manager).c();
    localObject = tags;
    if (localObject != null) {
      localm.a("tags", ((TwinTags)localObject).toJsonElement());
    }
    localm.a("properties", properties.toJsonElement());
    return localm;
  }
  
  public String updateDesiredProperty(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = innerUpdateDesiredProperty(paramMap);
      if (paramMap == null) {
        return null;
      }
      return paramMap.toString();
    }
    throw new IllegalArgumentException("Null desired property map.");
  }
  
  public void updateDesiredProperty(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty()) {
        try
        {
          properties.updateDesired(paramString, onDesiredCallback);
        }
        catch (s locals)
        {
          paramString = new StringBuilder();
          paramString.append("Malformed json: ");
          paramString.append(locals);
          throw new IllegalArgumentException(paramString.toString());
        }
      }
      return;
    }
    throw new IllegalArgumentException("Null json");
  }
  
  public String updateDeviceManager(String paramString1, TwinStatus paramTwinStatus, String paramString2)
  {
    manager.validateDeviceManager(paramString1, paramTwinStatus, paramString2);
    boolean bool = manager.setStatus(paramTwinStatus, paramString2);
    if (manager.setDeviceId(paramString1)) {
      bool = true;
    }
    if (!bool) {
      return null;
    }
    return toJson();
  }
  
  public String updateReportedProperty(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = innerUpdateReportedProperty(paramMap);
      if (paramMap == null) {
        return null;
      }
      return paramMap.toString();
    }
    throw new IllegalArgumentException("Null reported property map.");
  }
  
  public void updateReportedProperty(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty()) {
        try
        {
          properties.updateReported(paramString, onReportedCallback);
        }
        catch (s locals)
        {
          paramString = new StringBuilder();
          paramString.append("Malformed json: ");
          paramString.append(locals);
          throw new IllegalArgumentException(paramString.toString());
        }
      }
      return;
    }
    throw new IllegalArgumentException("Null json");
  }
  
  public String updateTags(Map<String, Object> paramMap)
  {
    paramMap = innerUpdateTags(paramMap);
    if (paramMap == null) {
      return null;
    }
    return paramMap.toString();
  }
  
  public String updateTwin(Map<String, Object> paramMap1, Map<String, Object> paramMap2, Map<String, Object> paramMap3)
  {
    m localm = new m();
    validateMap(paramMap1);
    validateMap(paramMap2);
    validateMap(paramMap3);
    Object localObject = new e();
    l = false;
    localObject = ((e)localObject).a().b(manager).c();
    if ((tags == null) && (paramMap3 != null)) {
      throw new IOException("Update not enabled Tags");
    }
    if ((paramMap1 == null) && (paramMap2 == null) && (paramMap3 == null)) {
      throw new IllegalArgumentException("Null maps");
    }
    j localj = innerUpdateDesiredProperty(paramMap1);
    if (localj != null) {
      localm.a("desired", localj);
    } else {
      localm.a("desired", new m());
    }
    paramMap2 = innerUpdateReportedProperty(paramMap2);
    if (paramMap2 != null) {
      localm.a("reported", paramMap2);
    } else {
      localm.a("reported", new m());
    }
    if (tags != null) {
      if (paramMap3 == null)
      {
        ((m)localObject).a("tags", new m());
      }
      else
      {
        paramMap1 = innerUpdateTags(paramMap3);
        if (paramMap1 != null)
        {
          ((m)localObject).a("tags", paramMap1);
          break label247;
        }
        ((m)localObject).a("tags", new m());
        break label247;
      }
    }
    paramMap1 = null;
    label247:
    if ((localj == null) && (paramMap2 == null) && (paramMap1 == null)) {
      return null;
    }
    ((m)localObject).a("properties", localm);
    return ((j)localObject).toString();
  }
  
  public void updateTwin(String paramString)
  {
    if (paramString != null)
    {
      validateJson(paramString);
      if (!paramString.isEmpty())
      {
        Object localObject1 = new e();
        Object localObject2 = a.clone();
        int i = 0;
        z = false;
        a = ((Excluder)localObject2);
        l = false;
        localObject2 = ((e)localObject1).a();
        try
        {
          localObject1 = ((Gson)localObject2).a(paramString, HashMap.class);
          localObject1 = (Map)t.a(HashMap.class).cast(localObject1);
          paramString = ((Gson)localObject2).a(paramString, RegisterManagerParser.class);
          manager = ((RegisterManagerParser)t.a(RegisterManagerParser.class).cast(paramString));
          Iterator localIterator = ((Map)localObject1).entrySet().iterator();
          while (localIterator.hasNext())
          {
            paramString = (Map.Entry)localIterator.next();
            if (((String)paramString.getKey()).equals("properties"))
            {
              properties.update((Map)paramString.getValue(), onDesiredCallback, onReportedCallback);
            }
            else
            {
              if ((((String)paramString.getKey()).equals("desired")) || (((String)paramString.getKey()).equals("reported"))) {
                break label263;
              }
              if (!((String)paramString.getKey()).equals("tags")) {
                continue;
              }
              localObject2 = tags;
              if (localObject2 != null) {
                ((TwinTags)localObject2).update((Map)paramString.getValue(), onTagsCallback);
              }
            }
            i = 1;
            continue;
            label263:
            if (i == 0) {
              properties.update((Map)localObject1, onDesiredCallback, onReportedCallback);
            } else {
              throw new IllegalArgumentException("Invalid Entry");
            }
          }
        }
        catch (s locals)
        {
          paramString = new StringBuilder();
          paramString.append("Malformed Json: ");
          paramString.append(locals);
          throw new IllegalArgumentException(paramString.toString());
        }
      }
      return;
    }
    throw new IllegalArgumentException("Null json");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.TwinParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */