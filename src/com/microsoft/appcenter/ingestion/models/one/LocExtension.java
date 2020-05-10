package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class LocExtension
  implements Model
{
  public static final String TZ = "tz";
  public String tz;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (LocExtension.class == paramObject.getClass()))
    {
      Object localObject = (LocExtension)paramObject;
      paramObject = tz;
      localObject = tz;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getTz()
  {
    return tz;
  }
  
  public int hashCode()
  {
    String str = tz;
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
    setTz(paramJSONObject.optString("tz", null));
  }
  
  public void setTz(String paramString)
  {
    tz = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "tz", getTz());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.LocExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */