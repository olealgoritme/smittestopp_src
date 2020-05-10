package com.microsoft.appcenter.ingestion.models.properties;

import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TypedPropertyUtils
{
  public static TypedProperty create(String paramString)
  {
    if ("boolean".equals(paramString)) {
      return new BooleanTypedProperty();
    }
    if ("dateTime".equals(paramString)) {
      return new DateTimeTypedProperty();
    }
    if ("double".equals(paramString)) {
      return new DoubleTypedProperty();
    }
    if ("long".equals(paramString)) {
      return new LongTypedProperty();
    }
    if ("string".equals(paramString)) {
      return new StringTypedProperty();
    }
    throw new JSONException(a.b("Unsupported type: ", paramString));
  }
  
  public static List<TypedProperty> read(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("typedProperties");
    if (paramJSONObject != null)
    {
      ArrayList localArrayList = new ArrayList(paramJSONObject.length());
      for (int i = 0; i < paramJSONObject.length(); i++)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        TypedProperty localTypedProperty = create(localJSONObject.getString("type"));
        localTypedProperty.read(localJSONObject);
        localArrayList.add(localTypedProperty);
      }
      return localArrayList;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.properties.TypedPropertyUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */