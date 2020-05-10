package com.microsoft.appcenter.ingestion.models.properties;

import org.json.JSONObject;
import org.json.JSONStringer;

public class StringTypedProperty
  extends TypedProperty
{
  public static final String TYPE = "string";
  public String value;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (StringTypedProperty.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (StringTypedProperty)paramObject;
      paramObject = value;
      localObject = value;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getType()
  {
    return "string";
  }
  
  public String getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    String str = value;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setValue(paramJSONObject.getString("value"));
  }
  
  public void setValue(String paramString)
  {
    value = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("value").value(getValue());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.properties.StringTypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */