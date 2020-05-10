package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.j;
import e.c.c.m;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConfigurationContentParser
{
  public static final String DEVICE_CONTENT_NAME = "deviceContent";
  public static final String MODULES_CONTENT_NAME = "modulesContent";
  public static transient Gson gson = new Gson();
  @a(deserialize=true, serialize=false)
  @c("deviceContent")
  public Map<String, Object> deviceContent;
  @a(deserialize=true, serialize=false)
  @c("modulesContent")
  public Map<String, Map<String, Object>> modulesContent;
  
  public ConfigurationContentParser() {}
  
  public ConfigurationContentParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, ConfigurationContentParser.class);
        paramString = (ConfigurationContentParser)t.a(ConfigurationContentParser.class).cast(paramString);
        modulesContent = modulesContent;
        deviceContent = deviceContent;
        return;
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public Map<String, Object> getDeviceContent()
  {
    return deviceContent;
  }
  
  public Map<String, Map<String, Object>> getModulesContent()
  {
    return modulesContent;
  }
  
  public void setDeviceContent(Map<String, Object> paramMap)
  {
    deviceContent = paramMap;
  }
  
  public void setModulesContent(Map<String, Map<String, Object>> paramMap)
  {
    modulesContent = paramMap;
  }
  
  public String toJson()
  {
    return gson.a(this);
  }
  
  public j toJsonElement()
  {
    m localm = new m();
    if (modulesContent != null)
    {
      HashMap localHashMap = new HashMap();
      localObject = modulesContent.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      localm.a("modulesContent", ParserUtility.mapToJsonElement(localHashMap));
    }
    Object localObject = deviceContent;
    if (localObject != null) {
      localm.a("deviceContent", ParserUtility.mapToJsonElement((Map)localObject));
    }
    return localm;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.ConfigurationContentParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */