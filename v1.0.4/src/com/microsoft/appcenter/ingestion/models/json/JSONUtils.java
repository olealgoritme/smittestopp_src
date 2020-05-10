package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public class JSONUtils
{
  public static <M extends Model> List<M> readArray(JSONObject paramJSONObject, String paramString, ModelFactory<M> paramModelFactory)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray == null) {
      return null;
    }
    paramString = paramModelFactory.createList(localJSONArray.length());
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      paramJSONObject = paramModelFactory.create();
      paramJSONObject.read(localJSONObject);
      paramString.add(paramJSONObject);
    }
    return paramString;
  }
  
  public static Boolean readBoolean(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return Boolean.valueOf(paramJSONObject.getBoolean(paramString));
    }
    return null;
  }
  
  public static Integer readInteger(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return Integer.valueOf(paramJSONObject.getInt(paramString));
    }
    return null;
  }
  
  public static Long readLong(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.has(paramString)) {
      return Long.valueOf(paramJSONObject.getLong(paramString));
    }
    return null;
  }
  
  public static Map<String, String> readMap(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    HashMap localHashMap = new HashMap(paramJSONObject.length());
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      localHashMap.put(paramString, paramJSONObject.getString(paramString));
    }
    return localHashMap;
  }
  
  public static List<String> readStringArray(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = paramJSONObject.optJSONArray(paramString);
    if (paramJSONObject == null) {
      return null;
    }
    paramString = new ArrayList(paramJSONObject.length());
    for (int i = 0; i < paramJSONObject.length(); i++) {
      paramString.add(paramJSONObject.getString(i));
    }
    return paramString;
  }
  
  public static void write(JSONStringer paramJSONStringer, String paramString, Object paramObject)
  {
    if (paramObject != null) {
      paramJSONStringer.key(paramString).value(paramObject);
    }
  }
  
  public static void writeArray(JSONStringer paramJSONStringer, String paramString, List<? extends Model> paramList)
  {
    if (paramList != null)
    {
      paramJSONStringer.key(paramString).array();
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (Model)paramString.next();
        paramJSONStringer.object();
        paramList.write(paramJSONStringer);
        paramJSONStringer.endObject();
      }
      paramJSONStringer.endArray();
    }
  }
  
  public static void writeMap(JSONStringer paramJSONStringer, String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramJSONStringer.key(paramString).object();
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        paramJSONStringer.key((String)paramMap.getKey()).value(paramMap.getValue());
      }
      paramJSONStringer.endObject();
    }
  }
  
  public static void writeStringArray(JSONStringer paramJSONStringer, String paramString, List<String> paramList)
  {
    if (paramList != null)
    {
      paramJSONStringer.key(paramString).array();
      paramString = paramList.iterator();
      while (paramString.hasNext()) {
        paramJSONStringer.value((String)paramString.next());
      }
      paramJSONStringer.endArray();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.json.JSONUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */