package com.microsoft.appcenter.ingestion.models.properties;

import com.microsoft.appcenter.ingestion.models.json.JSONDateUtils;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DateTimeTypedProperty
  extends TypedProperty
{
  public static final String TYPE = "dateTime";
  public Date value;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (DateTimeTypedProperty.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (DateTimeTypedProperty)paramObject;
      paramObject = value;
      localObject = value;
      if (paramObject != null) {
        bool = ((Date)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getType()
  {
    return "dateTime";
  }
  
  public Date getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Date localDate = value;
    int j;
    if (localDate != null) {
      j = localDate.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setValue(JSONDateUtils.toDate(paramJSONObject.getString("value")));
  }
  
  public void setValue(Date paramDate)
  {
    value = paramDate;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("value").value(JSONDateUtils.toString(getValue()));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.properties.DateTimeTypedProperty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */