package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class OsExtension
  implements Model
{
  public static final String NAME = "name";
  public static final String VER = "ver";
  public String name;
  public String ver;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (OsExtension.class == paramObject.getClass()))
    {
      Object localObject = (OsExtension)paramObject;
      paramObject = name;
      if (paramObject != null ? !((String)paramObject).equals(name) : name != null) {
        return false;
      }
      paramObject = ver;
      localObject = ver;
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
  
  public String getVer()
  {
    return ver;
  }
  
  public int hashCode()
  {
    String str = name;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = ver;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setName(paramJSONObject.optString("name", null));
    setVer(paramJSONObject.optString("ver", null));
  }
  
  public void setName(String paramString)
  {
    name = paramString;
  }
  
  public void setVer(String paramString)
  {
    ver = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "name", getName());
    JSONUtils.write(paramJSONStringer, "ver", getVer());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.one.OsExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */