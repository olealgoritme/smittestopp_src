package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DeviceExtension
  implements Model
{
  public static final String LOCAL_ID = "localId";
  public String localId;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (DeviceExtension.class == paramObject.getClass()))
    {
      Object localObject = (DeviceExtension)paramObject;
      paramObject = localId;
      localObject = localId;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
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
  
  public int hashCode()
  {
    String str = localId;
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
    setLocalId(paramJSONObject.optString("localId", null));
  }
  
  public void setLocalId(String paramString)
  {
    localId = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "localId", getLocalId());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.DeviceExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */