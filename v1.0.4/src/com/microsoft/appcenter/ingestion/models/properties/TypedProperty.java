package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class TypedProperty
  implements Model
{
  public String name;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      Object localObject = (TypedProperty)paramObject;
      paramObject = name;
      localObject = name;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getName()
  {
    return name;
  }
  
  public abstract String getType();
  
  public int hashCode()
  {
    String str = name;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    if (paramJSONObject.getString("type").equals(getType()))
    {
      setName(paramJSONObject.getString("name"));
      return;
    }
    throw new JSONException("Invalid type");
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    paramJSONStringer.key("type").value(getType());
    paramJSONStringer.key("name").value(getName());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.properties.TypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */