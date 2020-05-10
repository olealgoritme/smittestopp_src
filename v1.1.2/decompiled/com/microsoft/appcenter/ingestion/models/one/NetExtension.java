package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class NetExtension
  implements Model
{
  public static final String PROVIDER = "provider";
  public String provider;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (NetExtension.class == paramObject.getClass()))
    {
      Object localObject = (NetExtension)paramObject;
      paramObject = provider;
      localObject = provider;
      if (paramObject != null) {
        bool = ((String)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getProvider()
  {
    return provider;
  }
  
  public int hashCode()
  {
    String str = provider;
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
    setProvider(paramJSONObject.optString("provider", null));
  }
  
  public void setProvider(String paramString)
  {
    provider = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "provider", getProvider());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.one.NetExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */