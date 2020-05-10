package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class AppExtension
  implements Model
{
  public static final String ID = "id";
  public static final String LOCALE = "locale";
  public static final String NAME = "name";
  public static final String USER_ID = "userId";
  public static final String VER = "ver";
  public String id;
  public String locale;
  public String name;
  public String userId;
  public String ver;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (AppExtension.class == paramObject.getClass()))
    {
      paramObject = (AppExtension)paramObject;
      String str = id;
      if (str != null ? !str.equals(id) : id != null) {
        return false;
      }
      str = ver;
      if (str != null ? !str.equals(ver) : ver != null) {
        return false;
      }
      str = name;
      if (str != null ? !str.equals(name) : name != null) {
        return false;
      }
      str = locale;
      if (str != null ? !str.equals(locale) : locale != null) {
        return false;
      }
      str = userId;
      paramObject = userId;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getLocale()
  {
    return locale;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getUserId()
  {
    return userId;
  }
  
  public String getVer()
  {
    return ver;
  }
  
  public int hashCode()
  {
    String str = id;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = ver;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = name;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = locale;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = userId;
    if (str != null) {
      i = str.hashCode();
    }
    return (((j * 31 + k) * 31 + m) * 31 + n) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setId(paramJSONObject.optString("id", null));
    setVer(paramJSONObject.optString("ver", null));
    setName(paramJSONObject.optString("name", null));
    setLocale(paramJSONObject.optString("locale", null));
    setUserId(paramJSONObject.optString("userId", null));
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setLocale(String paramString)
  {
    locale = paramString;
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setUserId(String paramString)
  {
    userId = paramString;
  }
  
  public void setVer(String paramString)
  {
    ver = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "id", getId());
    JSONUtils.write(paramJSONStringer, "ver", getVer());
    JSONUtils.write(paramJSONStringer, "name", getName());
    JSONUtils.write(paramJSONStringer, "locale", getLocale());
    JSONUtils.write(paramJSONStringer, "userId", getUserId());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.one.AppExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */