package com.microsoft.appcenter.ingestion.models.properties;

import org.json.JSONObject;
import org.json.JSONStringer;

public class BooleanTypedProperty
  extends TypedProperty
{
  public static final String TYPE = "boolean";
  public boolean value;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (BooleanTypedProperty.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (BooleanTypedProperty)paramObject;
      if (value != value) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getType()
  {
    return "boolean";
  }
  
  public boolean getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    return super.hashCode() * 31 + value;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setValue(paramJSONObject.getBoolean("value"));
  }
  
  public void setValue(boolean paramBoolean)
  {
    value = paramBoolean;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("value").value(getValue());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.properties.BooleanTypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */