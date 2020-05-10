package com.microsoft.appcenter.ingestion.models.properties;

import org.json.JSONObject;
import org.json.JSONStringer;

public class LongTypedProperty
  extends TypedProperty
{
  public static final String TYPE = "long";
  public long value;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (LongTypedProperty.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (LongTypedProperty)paramObject;
      if (value != value) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getType()
  {
    return "long";
  }
  
  public long getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    long l = value;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setValue(paramJSONObject.getLong("value"));
  }
  
  public void setValue(long paramLong)
  {
    value = paramLong;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("value").value(getValue());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */