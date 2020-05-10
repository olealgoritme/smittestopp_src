package com.microsoft.appcenter.crashes.ingestion.models;

import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import java.util.UUID;
import org.json.JSONObject;
import org.json.JSONStringer;

public class HandledErrorLog
  extends LogWithProperties
{
  public static final String EXCEPTION = "exception";
  public static final String TYPE = "handledError";
  public Exception exception;
  public UUID id;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (HandledErrorLog.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      Object localObject = (HandledErrorLog)paramObject;
      paramObject = id;
      if (paramObject != null ? !((UUID)paramObject).equals(id) : id != null) {
        return false;
      }
      paramObject = exception;
      localObject = exception;
      if (paramObject != null) {
        bool = ((Exception)paramObject).equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public Exception getException()
  {
    return exception;
  }
  
  public UUID getId()
  {
    return id;
  }
  
  public String getType()
  {
    return "handledError";
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
    localObject = exception;
    if (localObject != null) {
      j = ((Exception)localObject).hashCode();
    }
    return (i * 31 + k) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setId(UUID.fromString(paramJSONObject.getString("id")));
    if (paramJSONObject.has("exception"))
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("exception");
      paramJSONObject = new Exception();
      paramJSONObject.read(localJSONObject);
      setException(paramJSONObject);
    }
  }
  
  public void setException(Exception paramException)
  {
    exception = paramException;
  }
  
  public void setId(UUID paramUUID)
  {
    id = paramUUID;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("id").value(getId());
    if (getException() != null)
    {
      paramJSONStringer.key("exception").object();
      exception.write(paramJSONStringer);
      paramJSONStringer.endObject();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */