package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

public class StartServiceLog
  extends AbstractLog
{
  public static final String SERVICES = "services";
  public static final String TYPE = "startService";
  public List<String> services;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (StartServiceLog.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (StartServiceLog)paramObject;
      paramObject = services;
      localObject = services;
      if (paramObject != null) {
        bool = ((List)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public List<String> getServices()
  {
    return services;
  }
  
  public String getType()
  {
    return "startService";
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    List localList = services;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setServices(JSONUtils.readStringArray(paramJSONObject, "services"));
  }
  
  public void setServices(List<String> paramList)
  {
    services = paramList;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    JSONUtils.writeStringArray(paramJSONStringer, "services", getServices());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.StartServiceLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */