package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Map;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class LogWithProperties
  extends AbstractLog
{
  public static final String PROPERTIES = "properties";
  public Map<String, String> properties;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (LogWithProperties)paramObject;
      paramObject = properties;
      localObject = properties;
      if (paramObject != null) {
        bool = ((Map)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Map<String, String> getProperties()
  {
    return properties;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Map localMap = properties;
    int j;
    if (localMap != null) {
      j = localMap.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setProperties(JSONUtils.readMap(paramJSONObject, "properties"));
  }
  
  public void setProperties(Map<String, String> paramMap)
  {
    properties = paramMap;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    JSONUtils.writeMap(paramJSONStringer, "properties", getProperties());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.LogWithProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */