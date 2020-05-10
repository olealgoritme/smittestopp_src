package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Data
  implements Model
{
  public static final String BASE_DATA = "baseData";
  public static final String BASE_TYPE = "baseType";
  public final JSONObject mProperties = new JSONObject();
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Data.class == paramObject.getClass()))
    {
      paramObject = (Data)paramObject;
      return mProperties.toString().equals(mProperties.toString());
    }
    return false;
  }
  
  public JSONObject getProperties()
  {
    return mProperties;
  }
  
  public int hashCode()
  {
    return mProperties.toString().hashCode();
  }
  
  public void read(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.names();
    if (localJSONArray != null) {
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        String str = localJSONArray.getString(i);
        mProperties.put(str, paramJSONObject.get(str));
      }
    }
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "baseType", mProperties.optString("baseType", null));
    JSONUtils.write(paramJSONStringer, "baseData", mProperties.optJSONObject("baseData"));
    JSONArray localJSONArray = mProperties.names();
    if (localJSONArray != null) {
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        String str = localJSONArray.getString(i);
        if ((!str.equals("baseType")) && (!str.equals("baseData"))) {
          paramJSONStringer.key(str).value(mProperties.get(str));
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.one.Data
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */