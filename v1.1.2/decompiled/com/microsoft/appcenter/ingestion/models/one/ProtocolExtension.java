package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONStringer;

public class ProtocolExtension
  implements Model
{
  public static final String DEV_MAKE = "devMake";
  public static final String DEV_MODEL = "devModel";
  public static final String TICKET_KEYS = "ticketKeys";
  public String devMake;
  public String devModel;
  public List<String> ticketKeys;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (ProtocolExtension.class == paramObject.getClass()))
    {
      paramObject = (ProtocolExtension)paramObject;
      Object localObject = ticketKeys;
      if (localObject != null ? !((List)localObject).equals(ticketKeys) : ticketKeys != null) {
        return false;
      }
      localObject = devMake;
      if (localObject != null ? !((String)localObject).equals(devMake) : devMake != null) {
        return false;
      }
      localObject = devModel;
      paramObject = devModel;
      if (localObject != null) {
        bool = ((String)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getDevMake()
  {
    return devMake;
  }
  
  public String getDevModel()
  {
    return devModel;
  }
  
  public List<String> getTicketKeys()
  {
    return ticketKeys;
  }
  
  public int hashCode()
  {
    Object localObject = ticketKeys;
    int i = 0;
    int j;
    if (localObject != null) {
      j = ((List)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = devMake;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = devModel;
    if (localObject != null) {
      i = ((String)localObject).hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setTicketKeys(JSONUtils.readStringArray(paramJSONObject, "ticketKeys"));
    setDevMake(paramJSONObject.optString("devMake", null));
    setDevModel(paramJSONObject.optString("devModel", null));
  }
  
  public void setDevMake(String paramString)
  {
    devMake = paramString;
  }
  
  public void setDevModel(String paramString)
  {
    devModel = paramString;
  }
  
  public void setTicketKeys(List<String> paramList)
  {
    ticketKeys = paramList;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.writeStringArray(paramJSONStringer, "ticketKeys", getTicketKeys());
    JSONUtils.write(paramJSONStringer, "devMake", getDevMake());
    JSONUtils.write(paramJSONStringer, "devModel", getDevModel());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.one.ProtocolExtension
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */