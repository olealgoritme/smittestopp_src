package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class UserExtension
  implements Model
{
  public static final String LOCALE = "locale";
  public static final String LOCAL_ID = "localId";
  public String localId;
  public String locale;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (UserExtension.class == paramObject.getClass()))
    {
      paramObject = (UserExtension)paramObject;
      String str = localId;
      if (str != null ? !str.equals(localId) : localId != null) {
        return false;
      }
      str = locale;
      paramObject = locale;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getLocalId()
  {
    return localId;
  }
  
  public String getLocale()
  {
    return locale;
  }
  
  public int hashCode()
  {
    String str = localId;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = locale;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setLocalId(paramJSONObject.optString("localId", null));
    setLocale(paramJSONObject.optString("locale", null));
  }
  
  public void setLocalId(String paramString)
  {
    localId = paramString;
  }
  
  public void setLocale(String paramString)
  {
    locale = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "localId", getLocalId());
    JSONUtils.write(paramJSONStringer, "locale", getLocale());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.UserExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */