package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import com.microsoft.appcenter.ingestion.models.properties.TypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.TypedPropertyUtils;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

public class EventLog
  extends LogWithNameAndProperties
{
  public static final String TYPE = "event";
  public UUID id;
  public List<TypedProperty> typedProperties;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (EventLog.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (EventLog)paramObject;
      Object localObject = id;
      if (localObject != null ? !((UUID)localObject).equals(id) : id != null) {
        return false;
      }
      localObject = typedProperties;
      paramObject = typedProperties;
      if (localObject != null) {
        bool = ((List)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public UUID getId()
  {
    return id;
  }
  
  public String getType()
  {
    return "event";
  }
  
  public List<TypedProperty> getTypedProperties()
  {
    return typedProperties;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = id;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((UUID)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = typedProperties;
    if (localObject != null) {
      j = ((List)localObject).hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setId(UUID.fromString(paramJSONObject.getString("id")));
    setTypedProperties(TypedPropertyUtils.read(paramJSONObject));
  }
  
  public void setId(UUID paramUUID)
  {
    id = paramUUID;
  }
  
  public void setTypedProperties(List<TypedProperty> paramList)
  {
    typedProperties = paramList;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("id").value(getId());
    JSONUtils.writeArray(paramJSONStringer, "typedProperties", getTypedProperties());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.ingestion.models.EventLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */