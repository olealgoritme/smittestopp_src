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
    paramString = paramJSONObject.optJSONArray(paramString);
    if (paramString == null) {
      return null;
    }
    paramJSONObject = paramModelFactory.createList(paramString.length());
    for (int i = 0; i < paramString.length(); i++)
    {
      JSONObject localJSONObject = paramString.getJSONObject(i);
      Model localModel = paramModelFactory.create();
      localModel.read(localJSONObject);
      paramJSONObject.add(localModel);
    }
    return paramJSONObject;
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
    JSONObject localJSONObject = paramJSONObject.optJSONObject(paramString);
    if (localJSONObject == null) {
      return null;
    }
    paramJSONObject = new HashMap(localJSONObject.length());
    paramString = localJSONObject.keys();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      paramJSONObject.put(str, localJSONObject.getString(str));
    }
    return paramJSONObject;
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
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        paramString = (Map.Entry)paramMap.next();
        paramJSONStringer.key((String)paramString.getKey()).value(paramString.getValue());
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
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.json.JSONUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */