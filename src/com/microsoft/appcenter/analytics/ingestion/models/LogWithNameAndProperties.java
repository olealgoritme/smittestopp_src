package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import org.json.JSONObject;
import org.json.JSONStringer;

public abstract class LogWithNameAndProperties
  extends LogWithProperties
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
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (LogWithNameAndProperties)paramObject;
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
  
  public int hashCode()
  {
    int i = super.hashCode();
    String str = name;
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
    setName(paramJSONObject.getString("name"));
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("name").value(getName());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.ingestion.models.LogWithNameAndProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */