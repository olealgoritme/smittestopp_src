package com.microsoft.appcenter.ingestion.models.properties;

import org.json.JSONObject;
import org.json.JSONStringer;

public class DoubleTypedProperty
  extends TypedProperty
{
  public static final String TYPE = "double";
  public double value;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (DoubleTypedProperty.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      if (Double.compare(value, value) != 0) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getType()
  {
    return "double";
  }
  
  public double getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    long l = Double.doubleToLongBits(value);
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setValue(paramJSONObject.getDouble("value"));
  }
  
  public void setValue(double paramDouble)
  {
    value = paramDouble;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("value").value(getValue());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */