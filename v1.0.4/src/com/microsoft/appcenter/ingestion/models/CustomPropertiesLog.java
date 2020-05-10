package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class CustomPropertiesLog
  extends AbstractLog
{
  public static final String PROPERTIES = "properties";
  public static final String PROPERTY_NAME = "name";
  public static final String PROPERTY_TYPE = "type";
  public static final String PROPERTY_TYPE_BOOLEAN = "boolean";
  public static final String PROPERTY_TYPE_CLEAR = "clear";
  public static final String PROPERTY_TYPE_DATETIME = "dateTime";
  public static final String PROPERTY_TYPE_NUMBER = "number";
  public static final String PROPERTY_TYPE_STRING = "string";
  public static final String PROPERTY_VALUE = "value";
  public static final String TYPE = "customProperties";
  public Map<String, Object> properties;
  
  public static Map<String, Object> readProperties(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.getJSONArray("properties");
    paramJSONObject = new HashMap();
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      paramJSONObject.put(localJSONObject.getString("name"), readPropertyValue(localJSONObject));
    }
    return paramJSONObject;
  }
  
  public static Object readPropertyValue(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.getString("type");
    if (str.equals("clear"))
    {
      paramJSONObject = null;
    }
    else if (str.equals("boolean"))
    {
      paramJSONObject = Boolean.valueOf(paramJSONObject.getBoolean("value"));
    }
    else if (str.equals("number"))
    {
      paramJSONObject = paramJSONObject.get("value");
      if (!(paramJSONObject instanceof Number)) {
        throw new JSONException("Invalid value type");
      }
    }
    else if (str.equals("dateTime"))
    {
      paramJSONObject = JSONDateUtils.toDate(paramJSONObject.getString("value"));
    }
    else
    {
      if (!str.equals("string")) {
        break label119;
      }
      paramJSONObject = paramJSONObject.getString("value");
    }
    return paramJSONObject;
    label119:
    throw new JSONException("Invalid value type");
  }
  
  public static void writeProperties(JSONStringer paramJSONStringer, Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramJSONStringer.key("properties").array();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramJSONStringer.object();
        JSONUtils.write(paramJSONStringer, "name", localEntry.getKey());
        writePropertyValue(paramJSONStringer, localEntry.getValue());
        paramJSONStringer.endObject();
      }
      paramJSONStringer.endArray();
      return;
    }
    throw new JSONException("Properties cannot be null");
  }
  
  public static void writePropertyValue(JSONStringer paramJSONStringer, Object paramObject)
  {
    if (paramObject == null)
    {
      JSONUtils.write(paramJSONStringer, "type", "clear");
    }
    else if ((paramObject instanceof Boolean))
    {
      JSONUtils.write(paramJSONStringer, "type", "boolean");
      JSONUtils.write(paramJSONStringer, "value", paramObject);
    }
    else if ((paramObject instanceof Number))
    {
      JSONUtils.write(paramJSONStringer, "type", "number");
      JSONUtils.write(paramJSONStringer, "value", paramObject);
    }
    else if ((paramObject instanceof Date))
    {
      JSONUtils.write(paramJSONStringer, "type", "dateTime");
      JSONUtils.write(paramJSONStringer, "value", JSONDateUtils.toString((Date)paramObject));
    }
    else
    {
      if (!(paramObject instanceof String)) {
        break label119;
      }
      JSONUtils.write(paramJSONStringer, "type", "string");
      JSONUtils.write(paramJSONStringer, "value", paramObject);
    }
    return;
    label119:
    throw new JSONException("Invalid value type");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (CustomPropertiesLog.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (CustomPropertiesLog)paramObject;
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
  
  public Map<String, Object> getProperties()
  {
    return properties;
  }
  
  public String getType()
  {
    return "customProperties";
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
    setProperties(readProperties(paramJSONObject));
  }
  
  public void setProperties(Map<String, Object> paramMap)
  {
    properties = paramMap;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    writeProperties(paramJSONStringer, getProperties());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.CustomPropertiesLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */