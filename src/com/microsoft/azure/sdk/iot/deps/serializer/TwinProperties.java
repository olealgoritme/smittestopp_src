package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.j;
import e.c.c.m;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class TwinProperties
{
  public static final String DESIRED_TAG = "desired";
  public static final String REPORTED_TAG = "reported";
  public TwinProperty desired = new TwinProperty();
  public TwinProperty reported = new TwinProperty();
  
  public void clearDesired()
  {
    desired = new TwinProperty();
  }
  
  public void clearReported()
  {
    reported = new TwinProperty();
  }
  
  public void enableDesiredMetadata()
  {
    desired.enableMetadata();
  }
  
  public void enableReportedMetadata()
  {
    reported.enableMetadata();
  }
  
  public Map<String, Object> getDesiredPropertyMap()
  {
    return desired.getPropertyMap();
  }
  
  public Integer getDesiredVersion()
  {
    return desired.getVersion();
  }
  
  public Map<String, Object> getReportedPropertyMap()
  {
    return reported.getPropertyMap();
  }
  
  public Integer getReportedVersion()
  {
    return reported.getVersion();
  }
  
  public j resetDesired(Map<String, Object> paramMap)
  {
    TwinProperty localTwinProperty = new TwinProperty();
    desired = localTwinProperty;
    return localTwinProperty.update(paramMap);
  }
  
  public j resetReported(Map<String, Object> paramMap)
  {
    TwinProperty localTwinProperty = new TwinProperty();
    reported = localTwinProperty;
    return localTwinProperty.update(paramMap);
  }
  
  public String toJson()
  {
    return toJsonElement().toString();
  }
  
  public j toJsonElement()
  {
    m localm = new m();
    localm.a("desired", desired.toJsonElement());
    localm.a("reported", reported.toJsonElement());
    return localm;
  }
  
  public void update(Map<String, Object> paramMap, TwinChangedCallback paramTwinChangedCallback1, TwinChangedCallback paramTwinChangedCallback2)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((String)localEntry.getKey()).equals("desired")) {
        desired.update((Map)localEntry.getValue(), paramTwinChangedCallback1);
      } else if (((String)localEntry.getKey()).equals("reported")) {
        reported.update((Map)localEntry.getValue(), paramTwinChangedCallback2);
      } else {
        throw new IllegalArgumentException("Invalid Property");
      }
    }
  }
  
  public j updateDesired(Map<String, Object> paramMap)
  {
    return desired.update(paramMap);
  }
  
  public void updateDesired(String paramString, TwinChangedCallback paramTwinChangedCallback)
  {
    desired.update(paramString, paramTwinChangedCallback);
  }
  
  public j updateReported(Map<String, Object> paramMap)
  {
    return reported.update(paramMap);
  }
  
  public void updateReported(String paramString, TwinChangedCallback paramTwinChangedCallback)
  {
    reported.update(paramString, paramTwinChangedCallback);
  }
  
  public void validate(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      if (((String)paramMap.getKey()).equals("desired")) {
        desired.validate((Map)paramMap.getValue());
      } else if (((String)paramMap.getKey()).equals("reported")) {
        reported.validate((Map)paramMap.getValue());
      } else {
        throw new IllegalArgumentException("Invalid Property");
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.TwinProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */