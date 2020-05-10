package com.microsoft.identity.common.internal.telemetry;

import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.concurrent.ConcurrentHashMap;

public class Properties
{
  public ConcurrentHashMap<String, String> mProperties;
  
  public Properties()
  {
    mProperties = new ConcurrentHashMap();
  }
  
  public Properties(ConcurrentHashMap<String, String> paramConcurrentHashMap)
  {
    mProperties = paramConcurrentHashMap;
  }
  
  public ConcurrentHashMap<String, String> getProperties()
  {
    return mProperties;
  }
  
  public Properties put(Properties paramProperties)
  {
    ConcurrentHashMap localConcurrentHashMap = mProperties;
    if (localConcurrentHashMap == null) {
      mProperties = paramProperties.getProperties();
    } else {
      localConcurrentHashMap.putAll(paramProperties.getProperties());
    }
    return this;
  }
  
  public Properties put(String paramString1, String paramString2)
  {
    if (mProperties == null) {
      mProperties = new ConcurrentHashMap();
    }
    if ((!StringUtil.isEmpty(paramString1)) && (!StringUtil.isEmpty(paramString2))) {
      mProperties.put(paramString1, paramString2);
    }
    return this;
  }
  
  public Properties remove(String paramString)
  {
    mProperties.remove(paramString);
    return this;
  }
  
  public Properties remove(String paramString1, String paramString2)
  {
    mProperties.remove(paramString1, paramString2);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.Properties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */